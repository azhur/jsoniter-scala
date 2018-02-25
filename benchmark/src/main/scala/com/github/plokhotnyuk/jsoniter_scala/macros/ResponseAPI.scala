package com.github.plokhotnyuk.jsoniter_scala.macros

import com.github.plokhotnyuk.jsoniter_scala.core.{JsonReader, JsonValueCodec, JsonWriter}

import scala.annotation.{switch, tailrec}

sealed trait Response
case class SuccessResponse(success: String) extends Response
case class ErrorResponse(error: String) extends Response
case class DataResponse(dataType: String, commonField: String, data: List[Data]) extends Response

sealed trait Data
case class Data1(a: BigDecimal) extends Data
case class Data2(b: String) extends Data

object ResponseAPI {
  implicit val data1Codec: JsonValueCodec[Data1] = JsonCodecMaker.make[Data1](CodecMakerConfig())
  implicit val data2Codec: JsonValueCodec[Data2] = JsonCodecMaker.make[Data2](CodecMakerConfig())
  implicit val codec: JsonValueCodec[Response] = new JsonValueCodec[Response] {
    private val successReqFieldNames: Array[String] = Array("success")
    private val errorReqFieldNames: Array[String] = Array("error")
    private val dataReqFieldNames: Array[String] = Array("dataType", "commonField")

    val nullValue: Response = null

    override def decodeValue(in: JsonReader, default: Response): Response =
      if (in.isNextToken('{')) {
        var _success: String = null
        var successReq = 1
        var _error: String = null
        var errorReq = 1
        var _dataType: String = null
        var dataDiscriminator: Int = 0
        var _commonField: String = null
        var _data: List[Data] = Nil
        var dataReq = 3
        var responseDiscriminator = 0
        if (!in.isNextToken('}')) {
          in.rollbackToken()
          in.setMark()
          if (scanToKey(in, "dataType")) {
            _dataType = in.readString(_dataType)
            dataDiscriminator = _dataType match {
              case "data1" => 1
              case "data2" => 2
              case _ => in.discriminatorValueError("dataType")
            }
            dataReq &= -2
            responseDiscriminator |= 4
          }
          in.rollbackToMark()
          do {
            val l = in.readKeyAsCharBuf()
            (in.charBufToHashCode(l): @switch) match {
              case -1867169789 => if (in.isCharBufEqualsTo(l, "success")) {
                _success = in.readString(_success)
                successReq &= -2
                responseDiscriminator |= 1
              } else in.skip()
              case 96784904 => if (in.isCharBufEqualsTo(l, "error")) {
                _error = in.readString(_error)
                errorReq &= -2
                responseDiscriminator |= 2
              } else in.skip()
              case -1948188209 => if (in.isCharBufEqualsTo(l, "commonField")) {
                _commonField = in.readString(_commonField)
                dataReq &= -3
                responseDiscriminator |= 4
              } else in.skip()
              case 3076010 => if (in.isCharBufEqualsTo(l, "data")) {
                _data = {
                  if (in.isNextToken('[')) {
                    if (in.isNextToken(']')) _data
                    else {
                      in.rollbackToken()
                      val x = List.newBuilder[Data]
                      do
                        x += (if (dataDiscriminator == 1) data1Codec else data2Codec).decodeValue(in, null)
                      while (in.isNextToken(','))
                      if (in.isCurrentToken(']')) x.result()
                      else in.arrayEndOrCommaError()
                    }
                  }
                  else in.readNullOrTokenError(_data, '[')
                }
              } else in.skip()
              case _ => in.skip()
            }
          } while (in.isNextToken(',')) ;
          if (!in.isCurrentToken('}')) in.objectEndOrCommaError()
        }
        responseDiscriminator match {
          case 1 =>
            if (successReq != 0) in.requiredKeyError(successReqFieldNames, Array(successReq))
            SuccessResponse(success = _success)
          case 2 =>
            if (errorReq != 0) in.requiredKeyError(errorReqFieldNames, Array(errorReq))
            ErrorResponse(error = _error)
          case 4 =>
            if (dataReq != 0) in.requiredKeyError(dataReqFieldNames, Array(errorReq))
            DataResponse(dataType = _dataType, commonField = _commonField, data = _data)
          case _ => in.decodeError("illegal response")
        }
      } else in.readNullOrTokenError(default, '{')

    override def encodeValue(x: Response, out: JsonWriter): Unit = {
      out.writeObjectStart()
      x match {
        case sr: SuccessResponse =>
          out.writeNonEscapedAsciiKey("success")
          out.writeVal(sr.success)
        case er: ErrorResponse =>
          out.writeNonEscapedAsciiKey("error")
          out.writeVal(er.error)
        case dr: DataResponse =>
          out.writeNonEscapedAsciiKey("dataType")
          out.writeVal(dr.dataType)
          out.writeNonEscapedAsciiKey("commonField")
          out.writeVal(dr.commonField)
          if (dr.data.nonEmpty) {
            out.writeNonEscapedAsciiKey("data")
            out.writeArrayStart()
            dr.data.foreach { x =>
              out.writeComma()
              x match {
                case d1: Data1 => data1Codec.encodeValue(d1, out)
                case d2: Data2 => data2Codec.encodeValue(d2, out)
              }
            }
            out.writeArrayEnd()
          }
      }
      out.writeObjectEnd()
    }

    @tailrec
    def scanToKey(in: JsonReader, s: String): Boolean =
      if (in.isCharBufEqualsTo(in.readKeyAsCharBuf(), s)) true
      else {
        in.skip()
        if (in.isNextToken(',')) scanToKey(in, s)
        else false
      }
  }
}