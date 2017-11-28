package kvstore

import org.scalatest.{MustMatchers, WordSpec}

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global

class KeyValueStoreImplTest extends WordSpec with MustMatchers {

  val kvStore = new KeyValueStoreImpl()

  "Key value store" must {

    "associate a given value to a given key in a given namespace" in {
      kvStore.put("agoda", "wf", 1)
      kvStore.store.keySet() must contain ("agoda")
      kvStore.store.get("agoda").keySet() must contain ("wf")
    }

    "return the value which is associated to a given key in a given namespace" in {
      kvStore.put("agoda", "wf", 1)
      kvStore.store.get("agoda").get("wf") must contain (1)
    }

    "remove the association of any value to a given key in a given namespace" in {
      kvStore.put("agoda", "wf", 2)
      kvStore.delete("agoda", "wf", 2)
      kvStore.get("agoda", "wf") must not contain (2)
    }

    "return a collection of all values which are associated to any keys in a given namespace" in {
      kvStore.put("agoda", "wf", 1)
      kvStore.put("agoda", "wf2", 3)
      val values = kvStore.values("agoda")
      values must contain (1)
      values must contain (3)
    }

    "behave correctly in multi threaded environment" in {
      val fut1 = Future{kvStore.put("agoda", "wf3", 5)}
      val fut2 = Future{kvStore.put("agoda", "wf4", 6)}
      val fut3 = Future{kvStore.put("agoda", "wf5", 7)}
      val allFutures = Future.sequence(List(fut1, fut2, fut3))
      val res = Await.result(allFutures, Duration.Inf)
      val values = kvStore.values("agoda")
      values must contain (5)
      values must contain (6)
      values must contain (7)
    }


  }

}
