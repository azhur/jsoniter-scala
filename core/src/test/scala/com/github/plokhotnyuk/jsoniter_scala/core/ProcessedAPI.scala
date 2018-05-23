package com.github.plokhotnyuk.jsoniter_scala.core

object ProcessedAPI {
  def createCodec(handler: String => Unit): JsonValueCodec[Unit] = new JsonValueCodec[Unit] {
    val nullValue: Unit = ()

    def decodeValue(in: JsonReader, default: Unit): Unit =
      if (in.isNextToken('{')) {
        if (in.skipToKey("result")) {
          if (in.isNextToken('[')) {
            if (!in.isNextToken(']')) {
              in.rollbackToken()
              do handler(in.readString(null))
              while (in.isNextToken(','))
              if (!in.isCurrentToken(']')) in.arrayEndOrCommaError()
            }
          } else in.readNullOrTokenError((), '[')
        }
      } else in.readNullOrTokenError((), '{')

    def encodeValue(x: Unit, out: JsonWriter): Unit = ???
  }
}
