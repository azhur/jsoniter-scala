package com.github.plokhotnyuk.jsoniter_scala.macros

class ResponseAPIBenchmarkSpec extends BenchmarkSpecBase {
  val benchmark = new ResponseAPIBenchmark
  
  "PrimitivesBenchmark" should {
    "deserialize properly" in {
      benchmark.readSuccess() shouldBe benchmark.success
      benchmark.readError() shouldBe benchmark.error
      benchmark.readData1() shouldBe benchmark.data1
      benchmark.readData2() shouldBe benchmark.data2
    }
    "serialize properly" in {
      toString(benchmark.writeSuccess()) shouldBe toString(benchmark.successBytes)
      toString(benchmark.writeError()) shouldBe toString(benchmark.errorBytes)
      toString(benchmark.writeData1()) shouldBe toString(benchmark.data1Bytes)
      toString(benchmark.writeData2()) shouldBe toString(benchmark.data2Bytes)
    }
  }
}