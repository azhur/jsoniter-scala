package com.github.plokhotnyuk.jsoniter_scala.macros

import java.time._
import java.util.{Base64, UUID}

import com.github.plokhotnyuk.jsoniter_scala.core.{JsonReader, JsonValueCodec, JsonWriter, ReaderConfig}
import com.github.plokhotnyuk.jsoniter_scala.macros.JsonCodecMaker._
import com.github.plokhotnyuk.jsoniter_scala.macros.SuitEnum.SuitEnum

object JsoniterCodecs {
  val stacklessExceptionConfig = ReaderConfig(throwParseExceptionWithStackTrace = false)
  val stacklessExceptionWithoutDumpConfig =
    ReaderConfig(throwParseExceptionWithStackTrace = false, appendHexDumpToParseException = false)
  implicit val anyRefsCodec: JsonValueCodec[AnyRefs] = make[AnyRefs](CodecMakerConfig())
  implicit val arraysCodec: JsonValueCodec[Arrays] = make[Arrays](CodecMakerConfig())
  implicit val bigDecimalArrayCodec: JsonValueCodec[Array[BigDecimal]] = make[Array[BigDecimal]](CodecMakerConfig())
  implicit val bigIntArrayCodec: JsonValueCodec[Array[BigInt]] = make[Array[BigInt]](CodecMakerConfig())
  implicit val bitSetsCodec: JsonValueCodec[BitSets] = make[BitSets](CodecMakerConfig())
  implicit val booleanArrayCodec: JsonValueCodec[Array[Boolean]] = make[Array[Boolean]](CodecMakerConfig())
  implicit val byteArrayCodec: JsonValueCodec[Array[Byte]] = make[Array[Byte]](CodecMakerConfig())
  implicit val doubleArrayCodec: JsonValueCodec[Array[Double]] = make[Array[Double]](CodecMakerConfig())
  implicit val durationArrayCodec: JsonValueCodec[Array[Duration]] = make[Array[Duration]](CodecMakerConfig())
  implicit val floatArrayCodec: JsonValueCodec[Array[Float]] = make[Array[Float]](CodecMakerConfig())
  implicit val instantArrayCodec: JsonValueCodec[Array[Instant]] = make[Array[Instant]](CodecMakerConfig())
  implicit val localDateArrayCodec: JsonValueCodec[Array[LocalDate]] = make[Array[LocalDate]](CodecMakerConfig())
  implicit val localDateTimeArrayCodec: JsonValueCodec[Array[LocalDateTime]] = make[Array[LocalDateTime]](CodecMakerConfig())
  implicit val offsetDateTimeArrayCodec: JsonValueCodec[Array[OffsetDateTime]] = make[Array[OffsetDateTime]](CodecMakerConfig())
  implicit val offsetTimeArrayCodec: JsonValueCodec[Array[OffsetTime]] = make[Array[OffsetTime]](CodecMakerConfig())
  implicit val localTimeArrayCodec: JsonValueCodec[Array[LocalTime]] = make[Array[LocalTime]](CodecMakerConfig())
  implicit val periodArrayCodec: JsonValueCodec[Array[Period]] = make[Array[Period]](CodecMakerConfig())
  implicit val zonedDateTimeArrayCodec: JsonValueCodec[Array[ZonedDateTime]] = make[Array[ZonedDateTime]](CodecMakerConfig())
  implicit val zoneOffsetArrayCodec: JsonValueCodec[Array[ZoneOffset]] = make[Array[ZoneOffset]](CodecMakerConfig())
  implicit val zoneIdArrayCodec: JsonValueCodec[Array[ZoneId]] = make[Array[ZoneId]](CodecMakerConfig())
  implicit val javaEnumArrayCodec: JsonValueCodec[Array[Suit]] = make[Array[Suit]](CodecMakerConfig())
  implicit val enumArrayCodec: JsonValueCodec[Array[SuitEnum]] = make[Array[SuitEnum]](CodecMakerConfig())
  implicit val intArrayCodec: JsonValueCodec[Array[Int]] = make[Array[Int]](CodecMakerConfig())
  implicit val shortArrayCodec: JsonValueCodec[Array[Short]] = make[Array[Short]](CodecMakerConfig())
  implicit val longArrayCodec: JsonValueCodec[Array[Long]] = make[Array[Long]](CodecMakerConfig())
  implicit val uuidArrayCodec: JsonValueCodec[Array[UUID]] = make[Array[UUID]](CodecMakerConfig())
  implicit val iterablesCodec: JsonValueCodec[Iterables] = make[Iterables](CodecMakerConfig())
  implicit val mapsCodec: JsonValueCodec[Maps] = make[Maps](CodecMakerConfig())
  implicit val missingReqFieldCodec: JsonValueCodec[MissingReqFields] = make[MissingReqFields](CodecMakerConfig())
  implicit val mutableIterablesCodec: JsonValueCodec[MutableIterables] = make[MutableIterables](CodecMakerConfig())
  implicit val mutableMapsCodec: JsonValueCodec[MutableMaps] = make[MutableMaps](CodecMakerConfig())
  implicit val intAndLongMapsCodec: JsonValueCodec[IntAndLongMaps] = make[IntAndLongMaps](CodecMakerConfig())
  implicit val intCodec: JsonValueCodec[Int] = make[Int](CodecMakerConfig())
  implicit val primitivesCodec: JsonValueCodec[Primitives] = make[Primitives](CodecMakerConfig())
  implicit val extractFieldsCodec: JsonValueCodec[ExtractFields] = make[ExtractFields](CodecMakerConfig())
  implicit val adtCodec: JsonValueCodec[AdtBase] = make[AdtBase](CodecMakerConfig())
  implicit val listOfAdtWithBase64Codec: JsonValueCodec[List[DocumentAttribute]] = {
    implicit val base64Codec: Base64Codec = new Base64Codec()
    make[List[DocumentAttribute]](CodecMakerConfig(
      fieldNameMapper = enforce_snake_case,
      adtLeafClassNameMapper = x => simpleClassName(x) match {
        case "DAAudio" => "da_audio"
        case "DAFilename" => "da_filename"
      },
      discriminatorFieldName = "kind"))
  }
  implicit val stringCodec: JsonValueCodec[String] = make[String](CodecMakerConfig())
  implicit val googleMapsAPICodec: JsonValueCodec[DistanceMatrix] = make[DistanceMatrix](CodecMakerConfig())
  implicit val twitterAPICodec: JsonValueCodec[Seq[Tweet]] = make[Seq[Tweet]](CodecMakerConfig())
}

class Base64Codec extends JsonValueCodec[Array[Byte]] {
  override def decodeValue(in: JsonReader, default: Array[Byte]): Array[Byte] =
    Base64.getDecoder.decode(in.readString())

  override def encodeValue(x: Array[Byte], out: JsonWriter): Unit =
    out.writeNonEscapedAsciiVal(Base64.getEncoder.encodeToString(x))

  override val nullValue: Array[Byte] = new Array[Byte](0)
}