package com.github.plokhotnyuk.jsoniter_scala.macros

import com.github.plokhotnyuk.jsoniter_scala.core.JsonValueCodec

import scala.collection.immutable.{List, Map}

object JsonSchema {
  import JsonSchemaAST._

  implicit val RootCodec: JsonValueCodec[JsonSchemaAST.Root] =
    JsonCodecMaker.make[JsonSchemaAST.Root](CodecMakerConfig(
      discriminatorFieldName = "typ"
    ))
}

object JsonSchemaAST {
  sealed trait Property

  case class Root(
    $schema: String,
    `type`: String,
    properties: Map[String, Property],
    required: List[String] = List.empty,
    format: Option[String] = None,
  ) extends Property

  case class BasicProperty(
    `type`: String,
    format: Option[String] = None,
  ) extends Property

  case class ComplexProperty(
    `type`: String,
    properties: Map[String, Property],
    format: Option[String] = None,
    required: List[String] = List.empty,
  ) extends Property

  case class ArrayProperty(
    `type`: String,
    items: Property
  ) extends Property

  case class EnumProperty(
    `type`: String,
    enum: List[String],
  ) extends Property
}
