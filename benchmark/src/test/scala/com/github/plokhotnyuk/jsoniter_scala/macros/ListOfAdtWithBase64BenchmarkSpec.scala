package com.github.plokhotnyuk.jsoniter_scala.macros

class ListOfAdtWithBase64BenchmarkSpec extends BenchmarkSpecBase {
  val benchmark = new ListOfAdtWithBase64Benchmark
  
  "ListOfAdtWithBase64Benchmark" should {
    "deserialize properly" in {
      def check(actual: DocumentAttribute, expected: DocumentAttribute): Unit = {
        (actual, expected) match {
          case (aa: DAAudio, ea: DAAudio) =>
            aa.duration shouldBe ea.duration
            aa.title shouldBe ea.title
            aa.duration shouldBe ea.duration
            (aa.waveform, ea.waveform) match {
              case (Some(aaw), Some(eaw)) =>
                aaw.deep shouldBe eaw.deep
            }
          case (af: DAFilename, ef: DAFilename) =>
            af shouldBe ef
        }
      }

      benchmark.readJsoniterScala().zip(benchmark.obj).foreach { case ((actual, expected)) =>
          check(actual, expected)
      }
      benchmark.readCirce().zip(benchmark.obj).foreach { case ((actual, expected)) =>
        check(actual, expected)
      }
    }
    "serialize properly" in {
      toString(benchmark.writeCirce()) shouldBe benchmark.jsonString2
      toString(benchmark.writeJsoniterScala()) shouldBe benchmark.jsonString
    }
  }
}