package io.circe.jackson

import com.fasterxml.jackson.databind.{ObjectMapper, ObjectWriter}
import io.circe.Json

object jackson2 extends WithJacksonMapper with JacksonParser with JacksonCompat {
  override protected def makeWriter(mapper: ObjectMapper): ObjectWriter = mapper.writer()

  final def encode(json: Json): String = makeWriter(mapper).writeValueAsString(json)

  final def encodeByteArray(json: Json): Array[Byte] = makeWriter(mapper).writeValueAsBytes(json)
}
