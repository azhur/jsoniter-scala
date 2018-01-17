package com.github.plokhotnyuk.jsoniter_scala.macros

import com.github.plokhotnyuk.jsoniter_scala.core._
import com.github.plokhotnyuk.jsoniter_scala.macros.JsoniterCodecs._
import org.openjdk.jmh.annotations.Benchmark

case class Message(message: String)

class MessageBenchmark extends CommonParams {
  val plainText: String = "Hello, World!"
  val obj: Message = Message(plainText)
  val jsonString: String = """{"message":"Hello, World!"}"""
  val jsonBytes: Array[Byte] = jsonString.getBytes

  @Benchmark
  def getBytes(): Array[Byte] = plainText.getBytes("UTF-8")

  @Benchmark
  def writeJsoniter(): Array[Byte] = JsonWriter.write(messageCodec, obj)
}