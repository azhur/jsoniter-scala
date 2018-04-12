package io.crossref

import com.github.plokhotnyuk.jsoniter_scala.core._
import org.scalatest.{Matchers, WordSpec}

class CrossrefSpec extends WordSpec with Matchers {
  "JsonImplicits" should {
    "parse data.json from file" in {
      val data = readFromStream(getClass.getResourceAsStream("data.json"))(JsonImplicits.codec)
      println(data)
    }
  }
  "JsonCodecThing" should {
    "parse data.json from file" in {
      val codec = new JsonCodecThings
      val data = readFromStream(getClass.getResourceAsStream("data.json"))(codec)
      println(data)
    }
  }
}
