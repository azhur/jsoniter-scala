package com.github.plokhotnyuk.jsoniter_scala.macros

import com.github.plokhotnyuk.jsoniter_scala.core._
import com.github.plokhotnyuk.jsoniter_scala.macros.ResponseAPI._
import org.openjdk.jmh.annotations.Benchmark

class ResponseAPIBenchmark extends CommonParams {
  val success: Response = SuccessResponse("OK")
  val successBytes: Array[Byte] = """{"success":"OK"}""".getBytes("UTF-8")
  val error: Response = ErrorResponse("Error")
  val errorBytes: Array[Byte] = """{"error":"Error"}""".getBytes("UTF-8")
  val data1: Response = DataResponse("data1", "s", List(Data1(BigDecimal(1)), Data1(BigDecimal(2))))
  val data1Bytes: Array[Byte] = """{"dataType":"data1","commonField":"s","data":[{"a":1},{"a":2}]}""".getBytes("UTF-8")
  val data2: Response = DataResponse("data2", "s", List(Data2("1"), Data2("2")))
  val data2Bytes: Array[Byte] = """{"dataType":"data2","commonField":"s","data":[{"b":"1"},{"b":"2"}]}""".getBytes("UTF-8")

  @Benchmark
  def readSuccess(): Response = read[Response](successBytes)

  @Benchmark
  def readError(): Response = read[Response](errorBytes)

  @Benchmark
  def readData1(): Response = read[Response](data1Bytes)

  @Benchmark
  def readData2(): Response = read[Response](data2Bytes)

  @Benchmark
  def writeSuccess(): Array[Byte] = write(success)

  @Benchmark
  def writeError(): Array[Byte] = write(error)

  @Benchmark
  def writeData1(): Array[Byte] = write(data1)

  @Benchmark
  def writeData2(): Array[Byte] = write(data2)
}