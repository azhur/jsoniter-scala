package io.crossref

import com.github.plokhotnyuk.jsoniter_scala.core._
import org.scalatest.{Matchers, WordSpec}

class CrossrefSpec extends WordSpec with Matchers {
  "Publication" should {
    "be created by the constructor call" in {
      new io.crossref.Publication(
        publisher = "",
        title = Nil,
        `original-title` = Nil,
        `short-title` = Nil,
        `abstract` = None,
        referenceCount = 1,
        `references-count` = 1,
        `is-referenced-by-count` = 1,
        source = "",
        prefix = "",
        DOI = "",
        URL = "",
        member = "",
        `type` = "",
        created = null,
        deposited = null,
        indexed = null,
        issued = null,
        posted = None,
        accepted = None,
        subtitle = Nil,
        `container-title` = Nil,
        `short-container-title` = Nil,
        `group-title` = None,
        issue = None,
        volume = None,
        page = None,
        `article-number` = None,
        `published-print` = None,
        `published-online` = None,
        subject = Nil,
        ISSN = Nil,
        `issn-type` = Nil,
        ISBN = Nil,
        archive = Nil,
        license = Nil,
        funder = Nil,
        assertion = Nil,
        author = Nil,
        editor = Nil,
        chair = Nil,
        translator = Nil,
        `update-to` = Nil,
        `update-policy` = None,
        link = Nil,
        `clinical-trial-number` = Nil,
        `alternative-id` = None,
        reference = Nil,
        `content-domain` = None,
        relation = None,
        score = 0.0)
    }
  }
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
