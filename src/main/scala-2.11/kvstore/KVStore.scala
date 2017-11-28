package kvstore

import java.util.concurrent.ConcurrentHashMap

import scala.collection.JavaConverters._

trait KeyValueStore {

  def put(namespace: String, key: String, value: Any): Unit

  def get(namespace: String, key: String): Set[Any]

  def delete(namespace: String, key: String, value: Any): Unit

  def values(namespace: String): Set[Any]

}

class KeyValueStoreImpl extends KeyValueStore {

  val store = new ConcurrentHashMap[String, ConcurrentHashMap[String, Set[Any]]]()

  override def put(namespace: String, key: String, value: Any): Unit = {
    if(store.containsKey(namespace)) {
      val nsStore = store.get(namespace)
      if(nsStore.containsKey(key)) {
        val existingValues = nsStore.get(key)
        val updatedValues = existingValues.union(Set(value))
        nsStore.put(key, updatedValues)
      }
      else nsStore.put(key, Set(value))
      store.put(namespace, nsStore)
    } else {
      val map = new ConcurrentHashMap[String, Set[Any]]()
      map.put(key, Set(value))
      store.put(namespace, map)
    }
  }

  override def get(namespace: String, key: String): Set[Any] = {
    store.get(namespace).get(key)
  }

  override def delete(namespace: String, key: String, value: Any): Unit = {
    val values = store.get(namespace).get(key).filterNot(_ == value)
    val map = new ConcurrentHashMap[String, Set[Any]]()
    map.put(key, values)
    store.put(namespace, map)
  }

  override def values(namespace: String): Set[Any] = {
    store.get(namespace).values().asScala.flatten.toSet
  }
}