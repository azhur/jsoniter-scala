package com.github.plokhotnyuk.jsoniter_scala.macros

class GoogleMapsAPIBenchmarkSpec extends BenchmarkSpecBase {
  val benchmark = new GoogleMapsAPIBenchmark
  
  "GoogleMapsAPIBenchmark" should {
    "deserialize properly" in {
      benchmark.readCirce() shouldBe benchmark.obj
      benchmark.readCirceJackson() shouldBe benchmark.obj
      benchmark.readCirceJackson2() shouldBe benchmark.obj
      benchmark.readJacksonScala() shouldBe benchmark.obj
      benchmark.readJsoniterScala() shouldBe benchmark.obj
      benchmark.readPlayJson() shouldBe benchmark.obj
    }
    "serialize properly" in {
      toString(benchmark.writeCirce()) shouldBe GoogleMapsAPI.compactJsonString
      toString(benchmark.writeCirceJackson()) shouldBe GoogleMapsAPI.compactJsonString
      toString(benchmark.writeCirceJackson2()) shouldBe GoogleMapsAPI.compactJsonString
      toString(benchmark.writeJacksonScala()) shouldBe GoogleMapsAPI.compactJsonString
      toString(benchmark.writeJsoniterScala()) shouldBe GoogleMapsAPI.compactJsonString
      toString(benchmark.preallocatedBuf, benchmark.writeJsoniterScalaPrealloc()) shouldBe GoogleMapsAPI.compactJsonString
      toString(benchmark.writePlayJson()) shouldBe GoogleMapsAPI.compactJsonString
    }
  }
}