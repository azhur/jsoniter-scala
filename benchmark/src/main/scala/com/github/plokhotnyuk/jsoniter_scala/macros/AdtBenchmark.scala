package com.github.plokhotnyuk.jsoniter_scala.macros

import java.nio.charset.StandardCharsets._
import java.util.concurrent.atomic.AtomicReferenceArray

import com.fasterxml.jackson.annotation.JsonSubTypes.Type
import com.fasterxml.jackson.annotation.{JsonSubTypes, JsonTypeInfo}
import com.github.plokhotnyuk.jsoniter_scala.core._
import com.github.plokhotnyuk.jsoniter_scala.macros.CirceEncodersDecoders._
import com.github.plokhotnyuk.jsoniter_scala.macros.JacksonSerDesers._
import com.github.plokhotnyuk.jsoniter_scala.macros.JsoniterCodecs._
import com.github.plokhotnyuk.jsoniter_scala.macros.PlayJsonFormats._
import io.circe.parser._
import io.circe.syntax._
import org.openjdk.jmh.annotations.Benchmark
import play.api.libs.json.Json

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes(Array(
  new Type(value = classOf[A], name = "A"),
  new Type(value = classOf[B], name = "B"),
  new Type(value = classOf[C], name = "C")))
sealed trait AdtBase extends Product with Serializable

case class A(a: Int) extends AdtBase

case class B(b: String) extends AdtBase

case class C(l: AdtBase, r: AdtBase) extends AdtBase

class AdtBenchmark extends CommonParams {
  val obj: AdtBase = C(A(1), B("VVV"))
  val jsonString: String = """{"type":"C","l":{"type":"A","a":1},"r":{"type":"B","b":"VVV"}}"""
  val jsonString2: String = """{"l":{"a":1,"type":"A"},"r":{"b":"VVV","type":"B"},"type":"C"}"""
  val jsonBytes: Array[Byte] = jsonString.getBytes(UTF_8)
  val objQueue: AtomicReferenceArray[AdtBase] = new AtomicReferenceArray(128)
  val jsonQueue: AtomicReferenceArray[Array[Byte]] = new AtomicReferenceArray(128)

  @volatile var i = 0

  @Benchmark
  def readCirce(): AdtBase = {
    val x = decode[AdtBase](new String(jsonBytes, UTF_8)).fold(throw _, x => x)
    objQueue.lazySet(i & 127, x)
    i += 1
    x
  }

  @Benchmark
  def readJacksonScala(): AdtBase = {
    val x = jacksonMapper.readValue[AdtBase](jsonBytes)
    objQueue.lazySet(i & 127, x)
    i += 1
    x
  }

  @Benchmark
  def readJsoniterScala(): AdtBase = {
    val x = readFromArray[AdtBase](jsonBytes)
    objQueue.lazySet(i & 127, x)
    i += 1
    x
  }

  @Benchmark
  def readPlayJson(): AdtBase = {
    val x = Json.parse(jsonBytes).as[AdtBase](adtFormat)
    objQueue.lazySet(i & 127, x)
    i += 1
    x
  }

  @Benchmark
  def writeCirce(): Array[Byte] = {
    val x = printer.pretty(obj.asJson).getBytes(UTF_8)
    jsonQueue.lazySet(i & 127, x)
    i += 1
    x
  }

  @Benchmark
  def writeJacksonScala(): Array[Byte] = {
    val x = jacksonMapper.writeValueAsBytes(obj)
    jsonQueue.lazySet(i & 127, x)
    i += 1
    x
  }

  @Benchmark
  def writeJsoniterScala(): Array[Byte] = {
    val x = writeToArray(obj)
    jsonQueue.lazySet(i & 127, x)
    i += 1
    x
  }

  @Benchmark
  def writeJsoniterScalaPrealloc(): Int = {
    val x = writeToPreallocatedArray(obj, preallocatedBuf, preallocatedOff)
    i ^= preallocatedBuf(i & 127)
    x
  }

  @Benchmark
  def writePlayJson(): Array[Byte] = {
    val x = Json.toBytes(Json.toJson(obj)(adtFormat))
    jsonQueue.lazySet(i & 127, x)
    i += 1
    x
  }
}