package com.github.plokhotnyuk.jsoniter_scala.core

import org.scalatest.prop.PropertyChecks
import org.scalatest.{Matchers, WordSpec}

import scala.collection.mutable

class ProcessedAPISpec extends WordSpec with Matchers with PropertyChecks {
  "readFromStream" should {
    "parse JSON from the provided input stream" in {
      val in = getClass.getResourceAsStream("processed_api.json")
      val s3buffer = new mutable.ArrayBuffer[String](1000)
      readFromStream(in)(ProcessedAPI.createCodec { s =>
        s3buffer += s
        if (s3buffer.size > 1000) {
          println(s3buffer) // <-- store buffered strings here
          s3buffer.clear()
        }
      }) shouldBe ((): Unit)
      s3buffer shouldBe Seq("string1", "string2")  // <-- store rest of strings here
    }
  }
}
