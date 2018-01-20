package com.github.plokhotnyuk.jsoniter_scala.macros

class AnyRefsBenchmarkSpec extends BenchmarkSpecBase {
  val benchmark = new AnyRefsBenchmark
  
  "AnyRefsBenchmark" should {
    "deserialize properly" in {
      benchmark.readCirce() shouldBe benchmark.obj
      benchmark.readJackson() shouldBe benchmark.obj
      benchmark.readJsoniter() shouldBe benchmark.obj
      benchmark.readPlay() shouldBe benchmark.obj
    }
    "serialize properly" in {
      toString(benchmark.writeCirce()) shouldBe benchmark.jsonString
      toString(benchmark.writeJackson()) shouldBe benchmark.jsonString
      toString(benchmark.writeJsoniter()) shouldBe benchmark.jsonString
      toString(benchmark.preallocatedBuf, benchmark.writeJsoniterPrealloc()) shouldBe benchmark.jsonString
      toString(benchmark.writePlay()) shouldBe benchmark.jsonString
    }
  }
}