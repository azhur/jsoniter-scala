package io.crossref

import com.github.plokhotnyuk.jsoniter_scala.macros.named

case class DateParts(`date-parts`: Array[Array[Int]], `date-time`: String, timestamp: Long)

case class PartialDate(`date-parts`: Array[Array[Int]])

case class ContentDomain(domain: Seq[String], `crossmark-restriction`: Boolean)

case class Affiliation(name: String)

case class Authors(given: Option[String], family: Option[String], affiliation: Seq[Affiliation])

case class PublishedOnline(dateParts: DateParts)

case class Deposited(dateParts: DateParts)

case class Issued(dateParts: DateParts)

case class Link(URL: String, `content-type`: String, `content-version`: String, `intended-application`: String)

case class ISSNType(value: String, `type`: String)

case class Relation(`id-type`: String, id: String, `asserted-by`: String)

case class ClinicalTrialNumber(`clinical-trial-number`: String, registry: String, `type`: Option[String])

case class Contributor(family: String,
                       given: Option[String],
                       ORCID: Option[String],
                       `authenticated-orcid`: Option[Boolean],
                       affiliation: Seq[Affiliation])

case class Update(updated: PartialDate, DOI: String, `type`: String, label: Option[String])

case class Assertion(name: String,
                     value: String,
                     URL: Option[String],
                     explanation: Option[String],
                     label: Option[String],
                     order: Option[Int],
                     group: Option[AssertionGroup])

case class AssertionGroup(name: String, label: Option[String])

case class License(`content-version`: String, `delay-in-days`: Int, start: DateParts, URL: String)

case class ResourceLink(`intended-application`: String, `content-version`: String, URL: String, `content-type`: Option[String])

case class Funder(name: String, DOI: Option[String], award: Seq[String], `doi-asserted-by`: Option[String])

case class JournalIssue(issue: String)

case class Reference(key: String,
                     author: Option[String],
                     issue: Option[String],
                     edition: Option[String],
                     component: Option[String],
                     `standard-designator`: Option[String],
                     `standards-body`: Option[String],
                     unstructured: Option[String],
                     `article-title`: Option[String],
                     `series-title`: Option[String],
                     `volume-title`: Option[String],
                     `journal-issue`: Option[JournalIssue],
                     ISSN: Option[String],
                     `issn-type`: Option[String],
                     ISBN: Option[String],
                     `isbn-type`: Option[String],
                     volume: Option[String],
                     `first-page`: Option[String],
                     year: Option[String],
                     `journal-title`: Option[String],
                     DOI: Option[String],
                     `doi-asserted-by`: Option[String])

case class Publication(publisher: String,
                       title: Seq[String],
                       `original-title`: Seq[String],
                       `short-title`: Seq[String],
                       `abstract`: Option[String],
                       `references-count`: Int,
                       `is-referenced-by-count`: Int,
                       source: String,
                       prefix: String,
                       DOI: String,
                       URL: String,
                       member: String,
                       `type`: String,
                       created: DateParts,
                       deposited: DateParts,
                       indexed: DateParts,
                       issued: PartialDate,
                       posted: Option[PartialDate],
                       accepted: Option[PartialDate],
                       subtitle: Seq[String],
                       `container-title`: Seq[String],
                       `short-container-title`: Seq[String],
                       `group-title`: Option[String],
                       issue: Option[String],
                       volume: Option[String],
                       page: Option[String],
                       `article-number`: Option[String],
                       `published-print`: Option[PartialDate],
                       `published-online`: Option[PartialDate],
                       subject: Seq[String],
                       ISSN: Seq[String],
                       `issn-type`: Seq[ISSNType],
                       ISBN: Seq[String],
                       archive: Seq[String],
                       license: Seq[License],
                       funder: Seq[Funder],
                       assertion: Seq[Assertion],
                       author: Seq[Authors],
                       editor: Seq[Contributor],
                       chair: Seq[Contributor],
                       translator: Seq[Contributor],
                       `update-to`: Seq[Update],
                       `update-policy`: Option[String],
                       link: Seq[Link],
                       `clinical-trial-number`: Seq[ClinicalTrialNumber],
                       `alternative-id`: Option[String],
                       reference: Seq[Reference] = Seq.empty[Reference],
                       `content-domain`: Option[ContentDomain],
                       relation: Option[Map[String, Relation]],
                       `reference-count`: Int,
                       score: Double)

case class Query(`start-index`: Int, `search-terms`: Option[String])

case class Items(facets: Map[String, String],
                 `total-results`: Long,
                 items: Seq[Publication],
                 `items-per-page`: Int,
                 query: Query,
                 `next-cursor`: Option[String])

case class Response[M <: Product](status: String, messageType: String, messageVersion: String, message: M)

case class ItemResponse(status: String, `message-type`: String, `message-version`: String, message: Items)