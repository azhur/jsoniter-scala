package com.github.plokhotnyuk.jsoniter_scala.macros

import com.github.plokhotnyuk.jsoniter_scala.core._
import com.github.plokhotnyuk.jsoniter_scala.macros.JsoniterCodecs._
import org.openjdk.jmh.annotations.Benchmark

case class Message(message: String)

class MessageBenchmark extends CommonParams {
  @Benchmark
  def getBytes(): Array[Byte] = "Hello, World!".getBytes("UTF-8")

  @Benchmark
  def writeJsoniter(): Array[Byte] = JsonWriter.write(messageCodec, Message("Hello, World!"))
}