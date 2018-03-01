package com.github.plokhotnyuk.jsoniter_scala.macros

import java.nio.charset.StandardCharsets.UTF_8

import com.github.plokhotnyuk.jsoniter_scala.core._
import com.github.plokhotnyuk.jsoniter_scala.macros.CirceEncodersDecoders2._
import com.github.plokhotnyuk.jsoniter_scala.macros.JsoniterCodecs._
import io.circe.parser._
import io.circe.syntax._
import org.openjdk.jmh.annotations.Benchmark

sealed trait DocumentAttribute

case class DAAudio(title: Option[String], performer: Option[String], waveform: Option[Array[Byte]], duration: Int) extends DocumentAttribute

case class DAFilename(fileName: String) extends DocumentAttribute

class ListOfAdtWithBase64Benchmark extends CommonParams {
  val obj: List[DocumentAttribute] = List(
    DAAudio(Some("title"), Some("perform"), Some(List(1, 2, 3, 4, 5).map(_.toByte).toArray), 15),
    DAFilename("filename"))
  val jsonString: String = """[{"kind":"da_audio","title":"title","performer":"perform","waveform":"AQIDBAU=","duration":15},{"kind":"da_filename","file_name":"filename"}]"""
  val jsonString2: String = """[{"title":"title","performer":"perform","waveform":"AQIDBAU=","duration":15,"kind":"da_audio"},{"file_name":"filename","kind":"da_filename"}]"""
  val jsonBytes: Array[Byte] = jsonString.getBytes

  @Benchmark
  def readCirce(): List[DocumentAttribute] = decode[List[DocumentAttribute]](new String(jsonBytes, UTF_8)).fold(throw _, x => x)

  @Benchmark
  def readJsoniterScala(): List[DocumentAttribute] = read[List[DocumentAttribute]](jsonBytes)

  @Benchmark
  def writeCirce(): Array[Byte] = printer.pretty(obj.asJson).getBytes(UTF_8)

  @Benchmark
  def writeJsoniterScala(): Array[Byte] = write(obj)
}