package scala.phoneCode

import org.scalatest.{MustMatchers, WordSpecLike}

import scala.io.Source
import scala.talks.jun2011.scalaExchange.PhoneCoder

class PhoneCoderTest extends WordSpecLike with MustMatchers {

  val dictFile = getClass.getResource("/phoneCode/dictionary_test").getPath
  val words = Source.fromFile(dictFile).getLines().toList

  val phoneCode = new PhoneCoder(words)

  "Phone Code" must {

    "translate numbers to words" in {
      val strings = phoneCode.translate("562482")
      strings must be (Set("mir Tor", "Mix Tor"))
    }
  }

}
