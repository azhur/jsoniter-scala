package com.github.plokhotnyuk.jsoniter_scala.macros

import java.util.Base64

import io.circe._
import io.circe.generic.extras._
import io.circe.generic.extras.semiauto._

object CirceEncodersDecoders {
  val printer: Printer = Printer.noSpaces.copy(dropNullValues = true, reuseWriters = true)
  implicit val config: Configuration = Configuration.default.withDiscriminator("type")
  implicit val aEncoder: Encoder[A] = deriveEncoder[A]
  implicit val aDecoder: Decoder[A] = deriveDecoder[A]
  implicit val bEncoder: Encoder[B] = deriveEncoder[B]
  implicit val bDecoder: Decoder[B] = deriveDecoder[B]
  implicit val cEncoder: Encoder[C] = deriveEncoder[C]
  implicit val cDecoder: Decoder[C] = deriveDecoder[C]
  implicit val adtEncoder: Encoder[AdtBase] = deriveEncoder[AdtBase]
  implicit val adtDecoder: Decoder[AdtBase] = deriveDecoder[AdtBase]
  implicit val enumEncoder: Encoder[SuitEnum.Value] = Encoder.enumEncoder(SuitEnum)
  implicit val enumDecoder: Decoder[SuitEnum.Value] = Decoder.enumDecoder(SuitEnum)
}

object CirceEncodersDecoders2 {
  val printer: Printer = Printer.noSpaces.copy(dropNullValues = true, reuseWriters = true)
  implicit val arrayByteEncoder: Encoder[Array[Byte]] =
    Encoder.encodeString.contramap[Array[Byte]](Base64.getEncoder.encodeToString)
  implicit val arrayByteDecoder: Decoder[Array[Byte]] =
    Decoder.decodeString.map[Array[Byte]](Base64.getDecoder.decode)
  implicit val config: Configuration = Configuration.default.withDiscriminator("kind").withSnakeCaseConstructorNames.withSnakeCaseMemberNames
  implicit val audioEncoder: Encoder[DAAudio] = deriveEncoder[DAAudio]
  implicit val audioDecoder: Decoder[DAAudio] = deriveDecoder[DAAudio]
  implicit val filenameEncoder: Encoder[DAFilename] = deriveEncoder[DAFilename]
  implicit val filenameDecoder: Decoder[DAFilename] = deriveDecoder[DAFilename]
  implicit val documentAttributeEncoder: Encoder[DocumentAttribute] = deriveEncoder[DocumentAttribute]
  implicit val documentAttributeDecoder: Decoder[DocumentAttribute] = deriveDecoder[DocumentAttribute]
}