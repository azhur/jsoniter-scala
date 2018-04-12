package io.crossref

import com.github.plokhotnyuk.jsoniter_scala.core._
import com.github.plokhotnyuk.jsoniter_scala.macros.{CodecMakerConfig, JsonCodecMaker}

import scala.annotation.switch;

object JsonImplicits {
  val codec: JsonValueCodec[ItemResponse] = JsonCodecMaker.make[ItemResponse](CodecMakerConfig())
}

final class JsonCodecThings extends JsonValueCodec[ItemResponse] {
  def nullValue: ItemResponse                                                      = null;
  def decodeValue(in: JsonReader, default: ItemResponse): ItemResponse = d0(in, default);
  def encodeValue(x: ItemResponse, out: JsonWriter): Unit                          = e0(x, out);
  private[this] val v0: Array[Array[Int]]                                                      = new Array[Array[Int]](0);
  private[this] val v1: Array[Int]                                                             = new Array[Int](0);
  private[this] val r0: Array[String]                                                          = Array("status", "message-type", "message-version", "message");
  private[this] val r1: Array[String]                                                          = Array("total-results", "items-per-page", "query");
  private[this] val r2: Array[String] = Array(
    "publisher",
    "reference-count",
    "references-count",
    "is-referenced-by-count",
    "source",
    "prefix",
    "DOI",
    "URL",
    "member",
    "type",
    "created",
    "deposited",
    "indexed",
    "issued",
    "score"
  );
  private[this] val r3: Array[String]  = Array("date-time", "timestamp");
  private[this] val r4: Array[String]  = Array("value", "type");
  private[this] val r5: Array[String]  = Array("content-version", "delay-in-days", "start", "URL");
  private[this] val r6: Array[String]  = Array("name");
  private[this] val r7: Array[String]  = Array("name", "value");
  private[this] val r8: Array[String]  = Array("name");
  private[this] val r9: Array[String]  = Array("name");
  private[this] val r10: Array[String] = Array("family");
  private[this] val r11: Array[String] = Array("updated", "DOI", "type");
  private[this] val r12: Array[String] = Array("URL", "content-type", "content-version", "intended-application");
  private[this] val r13: Array[String] = Array("clinical-trial-number", "registry");
  private[this] val r14: Array[String] = Array("key");
  private[this] val r15: Array[String] = Array("issue");
  private[this] val r16: Array[String] = Array("crossmark-restriction");
  private[this] val r17: Array[String] = Array("id-type", "id", "asserted-by");
  private[this] val r18: Array[String] = Array("start-index");
  private[this] def d2(in: JsonReader,
                       default: scala.collection.immutable.Map[String, String]): scala.collection.immutable.Map[String, String] =
    if (in.isNextToken('{'))
      if (in.isNextToken('}'))
        default
      else {
        in.rollbackToken();
        var x = Map.empty[String, String];
        do x = x.updated(in.readKeyAsString(), in.readString(null)) while (in.isNextToken(','));
        if (in.isCurrentToken('}'))
          x
        else
          in.objectEndOrCommaError()
      } else
      in.readNullOrTokenError(default, '{');
  private[this] def d5(in: JsonReader, default: Seq[String]): Seq[String] =
    if (in.isNextToken('['))
      if (in.isNextToken(']'))
        default
      else {
        in.rollbackToken();
        val x = Seq.newBuilder[String];
        do x.+=(in.readString(null)) while (in.isNextToken(','));
        if (in.isCurrentToken(']'))
          x.result()
        else
          in.arrayEndOrCommaError()
      } else
      in.readNullOrTokenError(default, '[');
  private[this] def d6(in: JsonReader, default: Option[String]): Option[String] =
    if (in.isNextToken('n'))
      in.readNullOrError(default, "expected value or null")
    else {
      in.rollbackToken();
      Some(in.readString(null))
    };
  private[this] def d9(in: JsonReader, default: Array[Int]): Array[Int] =
    if (in.isNextToken('['))
      if (in.isNextToken(']'))
        default
      else {
        in.rollbackToken();
        var x = new Array[Int](16);
        var i = 0;
        do {
          if (i.==(x.length))
            x = java.util.Arrays.copyOf(x, i.<<(1))
          else
            ();
          x.update(i, in.readInt());
          i.+=(1)
        } while (in.isNextToken(','));
        if (in.isCurrentToken(']'))
          if (i.==(x.length))
            x
          else
            java.util.Arrays.copyOf(x, i)
        else
          in.arrayEndOrCommaError()
      } else
      in.readNullOrTokenError(default, '[');
  private[this] def d8(in: JsonReader, default: Array[Array[Int]]): Array[Array[Int]] =
    if (in.isNextToken('['))
      if (in.isNextToken(']'))
        default
      else {
        in.rollbackToken();
        var x = new Array[Array[Int]](16);
        var i = 0;
        do {
          if (i.==(x.length))
            x = java.util.Arrays.copyOf(x, i.<<(1))
          else
            ();
          x.update(i, d9(in, v1));
          i.+=(1)
        } while (in.isNextToken(','));
        if (in.isCurrentToken(']'))
          if (i.==(x.length))
            x
          else
            java.util.Arrays.copyOf(x, i)
        else
          in.arrayEndOrCommaError()
      } else
      in.readNullOrTokenError(default, '[');
  private[this] def d7(in: JsonReader, default: DateParts): DateParts =
    if (in.isNextToken('{')) {
      var `_date-parts`: Array[Array[Int]] = v0;
      var `_date-time`: String             = null;
      var _timestamp: Long                 = 0L;
      var p0                               = 7;
      if (in.isNextToken('}').`unary_!`) {
        in.rollbackToken();
        do {
          val l = in.readKeyAsCharBuf();
          (in.charBufToHashCode(l): @switch) match {
            case -560061439 =>
              if (in.isCharBufEqualsTo(l, "date-parts")) {
                if (p0.&(1).!=(0))
                  p0.^=(1)
                else
                  in.duplicatedKeyError(l);
                `_date-parts` = d8(in, `_date-parts`)
              } else
                in.unexpectedKeyError(l)
            case -295034484 =>
              if (in.isCharBufEqualsTo(l, "date-time")) {
                if (p0.&(2).!=(0))
                  p0.^=(2)
                else
                  in.duplicatedKeyError(l);
                `_date-time` = in.readString(`_date-time`)
              } else
                in.unexpectedKeyError(l)
            case 55126294 =>
              if (in.isCharBufEqualsTo(l, "timestamp")) {
                if (p0.&(4).!=(0))
                  p0.^=(4)
                else
                  in.duplicatedKeyError(l);
                _timestamp = in.readLong()
              } else
                in.unexpectedKeyError(l)
            case _ => in.unexpectedKeyError(l)
          }
        } while (in.isNextToken(','));
        if (in.isCurrentToken('}').`unary_!`)
          in.objectEndOrCommaError()
        else
          ()
      } else
        ();
      if (p0.&(6).!=(0))
        in.requiredFieldError(r3(Integer.numberOfTrailingZeros(p0)))
      else
        ();
      new DateParts(`date-parts` = `_date-parts`, `date-time` = `_date-time`, timestamp = _timestamp)
    } else
      in.readNullOrTokenError(default, '{');
  private[this] def d10(in: JsonReader, default: PartialDate): PartialDate =
    if (in.isNextToken('{')) {
      var `_date-parts`: Array[Array[Int]] = v0;
      var p0                               = 1;
      if (in.isNextToken('}').`unary_!`) {
        in.rollbackToken();
        do {
          val l = in.readKeyAsCharBuf();
          (in.charBufToHashCode(l): @switch) match {
            case -560061439 =>
              if (in.isCharBufEqualsTo(l, "date-parts")) {
                if (p0.&(1).!=(0))
                  p0.^=(1)
                else
                  in.duplicatedKeyError(l);
                `_date-parts` = d8(in, `_date-parts`)
              } else
                in.unexpectedKeyError(l)
            case _ => in.unexpectedKeyError(l)
          }
        } while (in.isNextToken(','));
        if (in.isCurrentToken('}').`unary_!`)
          in.objectEndOrCommaError()
        else
          ()
      } else
        ();
      new PartialDate(`date-parts` = `_date-parts`)
    } else
      in.readNullOrTokenError(default, '{');
  private[this] def d11(in: JsonReader, default: Option[PartialDate]): Option[PartialDate] =
    if (in.isNextToken('n'))
      in.readNullOrError(default, "expected value or null")
    else {
      in.rollbackToken();
      Some(d10(in, null))
    };
  private[this] def d13(in: JsonReader, default: ISSNType): ISSNType =
    if (in.isNextToken('{')) {
      var _value: String = null;
      var _type: String  = null;
      var p0             = 3;
      if (in.isNextToken('}').`unary_!`) {
        in.rollbackToken();
        do {
          val l = in.readKeyAsCharBuf();
          (in.charBufToHashCode(l): @switch) match {
            case 111972721 =>
              if (in.isCharBufEqualsTo(l, "value")) {
                if (p0.&(1).!=(0))
                  p0.^=(1)
                else
                  in.duplicatedKeyError(l);
                _value = in.readString(_value)
              } else
                in.unexpectedKeyError(l)
            case 3575610 =>
              if (in.isCharBufEqualsTo(l, "type")) {
                if (p0.&(2).!=(0))
                  p0.^=(2)
                else
                  in.duplicatedKeyError(l);
                _type = in.readString(_type)
              } else
                in.unexpectedKeyError(l)
            case _ => in.unexpectedKeyError(l)
          }
        } while (in.isNextToken(','));
        if (in.isCurrentToken('}').`unary_!`)
          in.objectEndOrCommaError()
        else
          ()
      } else
        ();
      if (p0.&(3).!=(0))
        in.requiredFieldError(r4(Integer.numberOfTrailingZeros(p0)))
      else
        ();
      new ISSNType(value = _value, `type` = _type)
    } else
      in.readNullOrTokenError(default, '{');
  private[this] def d12(in: JsonReader, default: Seq[ISSNType]): Seq[ISSNType] =
    if (in.isNextToken('['))
      if (in.isNextToken(']'))
        default
      else {
        in.rollbackToken();
        val x = Seq.newBuilder[ISSNType];
        do x.+=(d13(in, null)) while (in.isNextToken(','));
        if (in.isCurrentToken(']'))
          x.result()
        else
          in.arrayEndOrCommaError()
      } else
      in.readNullOrTokenError(default, '[');
  private[this] def d15(in: JsonReader, default: License): License =
    if (in.isNextToken('{')) {
      var `_content-version`: String    = null;
      var `_delay-in-days`: Int         = 0;
      var _start: DateParts = null;
      var _URL: String                  = null;
      var p0                            = 15;
      if (in.isNextToken('}').`unary_!`) {
        in.rollbackToken();
        do {
          val l = in.readKeyAsCharBuf();
          (in.charBufToHashCode(l): @switch) match {
            case -467293308 =>
              if (in.isCharBufEqualsTo(l, "content-version")) {
                if (p0.&(1).!=(0))
                  p0.^=(1)
                else
                  in.duplicatedKeyError(l);
                `_content-version` = in.readString(`_content-version`)
              } else
                in.unexpectedKeyError(l)
            case 1548606901 =>
              if (in.isCharBufEqualsTo(l, "delay-in-days")) {
                if (p0.&(2).!=(0))
                  p0.^=(2)
                else
                  in.duplicatedKeyError(l);
                `_delay-in-days` = in.readInt()
              } else
                in.unexpectedKeyError(l)
            case 109757538 =>
              if (in.isCharBufEqualsTo(l, "start")) {
                if (p0.&(4).!=(0))
                  p0.^=(4)
                else
                  in.duplicatedKeyError(l);
                _start = d7(in, _start)
              } else
                in.unexpectedKeyError(l)
            case 84303 =>
              if (in.isCharBufEqualsTo(l, "URL")) {
                if (p0.&(8).!=(0))
                  p0.^=(8)
                else
                  in.duplicatedKeyError(l);
                _URL = in.readString(_URL)
              } else
                in.unexpectedKeyError(l)
            case _ => in.unexpectedKeyError(l)
          }
        } while (in.isNextToken(','));
        if (in.isCurrentToken('}').`unary_!`)
          in.objectEndOrCommaError()
        else
          ()
      } else
        ();
      if (p0.&(15).!=(0))
        in.requiredFieldError(r5(Integer.numberOfTrailingZeros(p0)))
      else
        ();
      new License(`content-version` = `_content-version`, `delay-in-days` = `_delay-in-days`, start = _start, URL = _URL)
    } else
      in.readNullOrTokenError(default, '{');
  private[this] def d14(in: JsonReader, default: Seq[License]): Seq[License] =
    if (in.isNextToken('['))
      if (in.isNextToken(']'))
        default
      else {
        in.rollbackToken();
        val x = Seq.newBuilder[License];
        do x.+=(d15(in, null)) while (in.isNextToken(','));
        if (in.isCurrentToken(']'))
          x.result()
        else
          in.arrayEndOrCommaError()
      } else
      in.readNullOrTokenError(default, '[');
  private[this] def d17(in: JsonReader, default: Funder): Funder =
    if (in.isNextToken('{')) {
      var _name: String                      = null;
      var _DOI: Option[String]               = None;
      var _award: Seq[String]                = Seq.empty[String];
      var `_doi-asserted-by`: Option[String] = None;
      var p0                                 = 15;
      if (in.isNextToken('}').`unary_!`) {
        in.rollbackToken();
        do {
          val l = in.readKeyAsCharBuf();
          (in.charBufToHashCode(l): @switch) match {
            case 3373707 =>
              if (in.isCharBufEqualsTo(l, "name")) {
                if (p0.&(1).!=(0))
                  p0.^=(1)
                else
                  in.duplicatedKeyError(l);
                _name = in.readString(_name)
              } else
                in.unexpectedKeyError(l)
            case 67870 =>
              if (in.isCharBufEqualsTo(l, "DOI")) {
                if (p0.&(2).!=(0))
                  p0.^=(2)
                else
                  in.duplicatedKeyError(l);
                _DOI = d6(in, _DOI)
              } else
                in.unexpectedKeyError(l)
            case 93223517 =>
              if (in.isCharBufEqualsTo(l, "award")) {
                if (p0.&(4).!=(0))
                  p0.^=(4)
                else
                  in.duplicatedKeyError(l);
                _award = d5(in, _award)
              } else
                in.unexpectedKeyError(l)
            case 1330102960 =>
              if (in.isCharBufEqualsTo(l, "doi-asserted-by")) {
                if (p0.&(8).!=(0))
                  p0.^=(8)
                else
                  in.duplicatedKeyError(l);
                `_doi-asserted-by` = d6(in, `_doi-asserted-by`)
              } else
                in.unexpectedKeyError(l)
            case _ => in.unexpectedKeyError(l)
          }
        } while (in.isNextToken(','));
        if (in.isCurrentToken('}').`unary_!`)
          in.objectEndOrCommaError()
        else
          ()
      } else
        ();
      if (p0.&(1).!=(0))
        in.requiredFieldError(r6(Integer.numberOfTrailingZeros(p0)))
      else
        ();
      new Funder(name = _name, DOI = _DOI, award = _award, `doi-asserted-by` = `_doi-asserted-by`)
    } else
      in.readNullOrTokenError(default, '{');
  private[this] def d16(in: JsonReader, default: Seq[Funder]): Seq[Funder] =
    if (in.isNextToken('['))
      if (in.isNextToken(']'))
        default
      else {
        in.rollbackToken();
        val x = Seq.newBuilder[Funder];
        do x.+=(d17(in, null)) while (in.isNextToken(','));
        if (in.isCurrentToken(']'))
          x.result()
        else
          in.arrayEndOrCommaError()
      } else
      in.readNullOrTokenError(default, '[');
  private[this] def d20(in: JsonReader, default: Option[Int]): Option[Int] =
    if (in.isNextToken('n'))
      in.readNullOrError(default, "expected value or null")
    else {
      in.rollbackToken();
      Some(in.readInt())
    };
  private[this] def d22(in: JsonReader, default: AssertionGroup): AssertionGroup =
    if (in.isNextToken('{')) {
      var _name: String          = null;
      var _label: Option[String] = None;
      var p0                     = 3;
      if (in.isNextToken('}').`unary_!`) {
        in.rollbackToken();
        do {
          val l = in.readKeyAsCharBuf();
          (in.charBufToHashCode(l): @switch) match {
            case 3373707 =>
              if (in.isCharBufEqualsTo(l, "name")) {
                if (p0.&(1).!=(0))
                  p0.^=(1)
                else
                  in.duplicatedKeyError(l);
                _name = in.readString(_name)
              } else
                in.unexpectedKeyError(l)
            case 102727412 =>
              if (in.isCharBufEqualsTo(l, "label")) {
                if (p0.&(2).!=(0))
                  p0.^=(2)
                else
                  in.duplicatedKeyError(l);
                _label = d6(in, _label)
              } else
                in.unexpectedKeyError(l)
            case _ => in.unexpectedKeyError(l)
          }
        } while (in.isNextToken(','));
        if (in.isCurrentToken('}').`unary_!`)
          in.objectEndOrCommaError()
        else
          ()
      } else
        ();
      if (p0.&(1).!=(0))
        in.requiredFieldError(r8(Integer.numberOfTrailingZeros(p0)))
      else
        ();
      new AssertionGroup(name = _name, label = _label)
    } else
      in.readNullOrTokenError(default, '{');
  private[this] def d21(in: JsonReader, default: Option[AssertionGroup]): Option[AssertionGroup] =
    if (in.isNextToken('n'))
      in.readNullOrError(default, "expected value or null")
    else {
      in.rollbackToken();
      Some(d22(in, null))
    };
  private[this] def d19(in: JsonReader, default: Assertion): Assertion =
    if (in.isNextToken('{')) {
      var _name: String                              = null;
      var _value: String                             = null;
      var _URL: Option[String]                       = None;
      var _explanation: Option[String]               = None;
      var _label: Option[String]                     = None;
      var _order: Option[Int]                        = None;
      var _group: Option[AssertionGroup] = None;
      var p0                                         = 127;
      if (in.isNextToken('}').`unary_!`) {
        in.rollbackToken();
        do {
          val l = in.readKeyAsCharBuf();
          (in.charBufToHashCode(l): @switch) match {
            case 3373707 =>
              if (in.isCharBufEqualsTo(l, "name")) {
                if (p0.&(1).!=(0))
                  p0.^=(1)
                else
                  in.duplicatedKeyError(l);
                _name = in.readString(_name)
              } else
                in.unexpectedKeyError(l)
            case 111972721 =>
              if (in.isCharBufEqualsTo(l, "value")) {
                if (p0.&(2).!=(0))
                  p0.^=(2)
                else
                  in.duplicatedKeyError(l);
                _value = in.readString(_value)
              } else
                in.unexpectedKeyError(l)
            case 84303 =>
              if (in.isCharBufEqualsTo(l, "URL")) {
                if (p0.&(4).!=(0))
                  p0.^=(4)
                else
                  in.duplicatedKeyError(l);
                _URL = d6(in, _URL)
              } else
                in.unexpectedKeyError(l)
            case -1105867239 =>
              if (in.isCharBufEqualsTo(l, "explanation")) {
                if (p0.&(8).!=(0))
                  p0.^=(8)
                else
                  in.duplicatedKeyError(l);
                _explanation = d6(in, _explanation)
              } else
                in.unexpectedKeyError(l)
            case 102727412 =>
              if (in.isCharBufEqualsTo(l, "label")) {
                if (p0.&(16).!=(0))
                  p0.^=(16)
                else
                  in.duplicatedKeyError(l);
                _label = d6(in, _label)
              } else
                in.unexpectedKeyError(l)
            case 106006350 =>
              if (in.isCharBufEqualsTo(l, "order")) {
                if (p0.&(32).!=(0))
                  p0.^=(32)
                else
                  in.duplicatedKeyError(l);
                _order = d20(in, _order)
              } else
                in.unexpectedKeyError(l)
            case 98629247 =>
              if (in.isCharBufEqualsTo(l, "group")) {
                if (p0.&(64).!=(0))
                  p0.^=(64)
                else
                  in.duplicatedKeyError(l);
                _group = d21(in, _group)
              } else
                in.unexpectedKeyError(l)
            case _ => in.unexpectedKeyError(l)
          }
        } while (in.isNextToken(','));
        if (in.isCurrentToken('}').`unary_!`)
          in.objectEndOrCommaError()
        else
          ()
      } else
        ();
      if (p0.&(3).!=(0))
        in.requiredFieldError(r7(Integer.numberOfTrailingZeros(p0)))
      else
        ();
      new Assertion(name = _name,
        value = _value,
        URL = _URL,
        explanation = _explanation,
        label = _label,
        order = _order,
        group = _group)
    } else
      in.readNullOrTokenError(default, '{');
  private[this] def d18(in: JsonReader, default: Seq[Assertion]): Seq[Assertion] =
    if (in.isNextToken('['))
      if (in.isNextToken(']'))
        default
      else {
        in.rollbackToken();
        val x = Seq.newBuilder[Assertion];
        do x.+=(d19(in, null)) while (in.isNextToken(','));
        if (in.isCurrentToken(']'))
          x.result()
        else
          in.arrayEndOrCommaError()
      } else
      in.readNullOrTokenError(default, '[');
  private[this] def d26(in: JsonReader, default: Affiliation): Affiliation =
    if (in.isNextToken('{')) {
      var _name: String = null;
      var p0            = 1;
      if (in.isNextToken('}').`unary_!`) {
        in.rollbackToken();
        do {
          val l = in.readKeyAsCharBuf();
          (in.charBufToHashCode(l): @switch) match {
            case 3373707 =>
              if (in.isCharBufEqualsTo(l, "name")) {
                if (p0.&(1).!=(0))
                  p0.^=(1)
                else
                  in.duplicatedKeyError(l);
                _name = in.readString(_name)
              } else
                in.unexpectedKeyError(l)
            case _ => in.unexpectedKeyError(l)
          }
        } while (in.isNextToken(','));
        if (in.isCurrentToken('}').`unary_!`)
          in.objectEndOrCommaError()
        else
          ()
      } else
        ();
      if (p0.&(1).!=(0))
        in.requiredFieldError(r9(Integer.numberOfTrailingZeros(p0)))
      else
        ();
      new Affiliation(name = _name)
    } else
      in.readNullOrTokenError(default, '{');
  private[this] def d25(in: JsonReader, default: Seq[Affiliation]): Seq[Affiliation] =
    if (in.isNextToken('['))
      if (in.isNextToken(']'))
        default
      else {
        in.rollbackToken();
        val x = Seq.newBuilder[Affiliation];
        do x.+=(d26(in, null)) while (in.isNextToken(','));
        if (in.isCurrentToken(']'))
          x.result()
        else
          in.arrayEndOrCommaError()
      } else
      in.readNullOrTokenError(default, '[');
  private[this] def d24(in: JsonReader, default: Authors): Authors =
    if (in.isNextToken('{')) {
      var _given: Option[String]                     = None;
      var _family: Option[String]                    = None;
      var _affiliation: Seq[Affiliation] = Seq.empty[Affiliation];
      var p0                                         = 7;
      if (in.isNextToken('}').`unary_!`) {
        in.rollbackToken();
        do {
          val l = in.readKeyAsCharBuf();
          (in.charBufToHashCode(l): @switch) match {
            case 98367357 =>
              if (in.isCharBufEqualsTo(l, "given")) {
                if (p0.&(1).!=(0))
                  p0.^=(1)
                else
                  in.duplicatedKeyError(l);
                _given = d6(in, _given)
              } else
                in.unexpectedKeyError(l)
            case -1281860764 =>
              if (in.isCharBufEqualsTo(l, "family")) {
                if (p0.&(2).!=(0))
                  p0.^=(2)
                else
                  in.duplicatedKeyError(l);
                _family = d6(in, _family)
              } else
                in.unexpectedKeyError(l)
            case 2019918576 =>
              if (in.isCharBufEqualsTo(l, "affiliation")) {
                if (p0.&(4).!=(0))
                  p0.^=(4)
                else
                  in.duplicatedKeyError(l);
                _affiliation = d25(in, _affiliation)
              } else
                in.unexpectedKeyError(l)
            case _ => in.unexpectedKeyError(l)
          }
        } while (in.isNextToken(','));
        if (in.isCurrentToken('}').`unary_!`)
          in.objectEndOrCommaError()
        else
          ()
      } else
        ();
      new Authors(given = _given, family = _family, affiliation = _affiliation)
    } else
      in.readNullOrTokenError(default, '{');
  private[this] def d23(in: JsonReader, default: Seq[Authors]): Seq[Authors] =
    if (in.isNextToken('['))
      if (in.isNextToken(']'))
        default
      else {
        in.rollbackToken();
        val x = Seq.newBuilder[Authors];
        do x.+=(d24(in, null)) while (in.isNextToken(','));
        if (in.isCurrentToken(']'))
          x.result()
        else
          in.arrayEndOrCommaError()
      } else
      in.readNullOrTokenError(default, '[');
  private[this] def d29(in: JsonReader, default: Option[Boolean]): Option[Boolean] =
    if (in.isNextToken('n'))
      in.readNullOrError(default, "expected value or null")
    else {
      in.rollbackToken();
      Some(in.readBoolean())
    };
  private[this] def d28(in: JsonReader, default: Contributor): Contributor =
    if (in.isNextToken('{')) {
      var _family: String                            = null;
      var _given: Option[String]                     = None;
      var _ORCID: Option[String]                     = None;
      var `_authenticated-orcid`: Option[Boolean]    = None;
      var _affiliation: Seq[Affiliation] = Seq.empty[Affiliation];
      var p0                                         = 31;
      if (in.isNextToken('}').`unary_!`) {
        in.rollbackToken();
        do {
          val l = in.readKeyAsCharBuf();
          (in.charBufToHashCode(l): @switch) match {
            case -1281860764 =>
              if (in.isCharBufEqualsTo(l, "family")) {
                if (p0.&(1).!=(0))
                  p0.^=(1)
                else
                  in.duplicatedKeyError(l);
                _family = in.readString(_family)
              } else
                in.unexpectedKeyError(l)
            case 98367357 =>
              if (in.isCharBufEqualsTo(l, "given")) {
                if (p0.&(2).!=(0))
                  p0.^=(2)
                else
                  in.duplicatedKeyError(l);
                _given = d6(in, _given)
              } else
                in.unexpectedKeyError(l)
            case 75467739 =>
              if (in.isCharBufEqualsTo(l, "ORCID")) {
                if (p0.&(4).!=(0))
                  p0.^=(4)
                else
                  in.duplicatedKeyError(l);
                _ORCID = d6(in, _ORCID)
              } else
                in.unexpectedKeyError(l)
            case -55038755 =>
              if (in.isCharBufEqualsTo(l, "authenticated-orcid")) {
                if (p0.&(8).!=(0))
                  p0.^=(8)
                else
                  in.duplicatedKeyError(l);
                `_authenticated-orcid` = d29(in, `_authenticated-orcid`)
              } else
                in.unexpectedKeyError(l)
            case 2019918576 =>
              if (in.isCharBufEqualsTo(l, "affiliation")) {
                if (p0.&(16).!=(0))
                  p0.^=(16)
                else
                  in.duplicatedKeyError(l);
                _affiliation = d25(in, _affiliation)
              } else
                in.unexpectedKeyError(l)
            case _ => in.unexpectedKeyError(l)
          }
        } while (in.isNextToken(','));
        if (in.isCurrentToken('}').`unary_!`)
          in.objectEndOrCommaError()
        else
          ()
      } else
        ();
      if (p0.&(1).!=(0))
        in.requiredFieldError(r10(Integer.numberOfTrailingZeros(p0)))
      else
        ();
      new Contributor(family = _family,
        given = _given,
        ORCID = _ORCID,
        `authenticated-orcid` = `_authenticated-orcid`,
        affiliation = _affiliation)
    } else
      in.readNullOrTokenError(default, '{');
  private[this] def d27(in: JsonReader, default: Seq[Contributor]): Seq[Contributor] =
    if (in.isNextToken('['))
      if (in.isNextToken(']'))
        default
      else {
        in.rollbackToken();
        val x = Seq.newBuilder[Contributor];
        do x.+=(d28(in, null)) while (in.isNextToken(','));
        if (in.isCurrentToken(']'))
          x.result()
        else
          in.arrayEndOrCommaError()
      } else
      in.readNullOrTokenError(default, '[');
  private[this] def d31(in: JsonReader, default: Update): Update =
    if (in.isNextToken('{')) {
      var _updated: PartialDate = null;
      var _DOI: String                      = null;
      var _type: String                     = null;
      var _label: Option[String]            = None;
      var p0                                = 15;
      if (in.isNextToken('}').`unary_!`) {
        in.rollbackToken();
        do {
          val l = in.readKeyAsCharBuf();
          (in.charBufToHashCode(l): @switch) match {
            case -234430277 =>
              if (in.isCharBufEqualsTo(l, "updated")) {
                if (p0.&(1).!=(0))
                  p0.^=(1)
                else
                  in.duplicatedKeyError(l);
                _updated = d10(in, _updated)
              } else
                in.unexpectedKeyError(l)
            case 67870 =>
              if (in.isCharBufEqualsTo(l, "DOI")) {
                if (p0.&(2).!=(0))
                  p0.^=(2)
                else
                  in.duplicatedKeyError(l);
                _DOI = in.readString(_DOI)
              } else
                in.unexpectedKeyError(l)
            case 3575610 =>
              if (in.isCharBufEqualsTo(l, "type")) {
                if (p0.&(4).!=(0))
                  p0.^=(4)
                else
                  in.duplicatedKeyError(l);
                _type = in.readString(_type)
              } else
                in.unexpectedKeyError(l)
            case 102727412 =>
              if (in.isCharBufEqualsTo(l, "label")) {
                if (p0.&(8).!=(0))
                  p0.^=(8)
                else
                  in.duplicatedKeyError(l);
                _label = d6(in, _label)
              } else
                in.unexpectedKeyError(l)
            case _ => in.unexpectedKeyError(l)
          }
        } while (in.isNextToken(','));
        if (in.isCurrentToken('}').`unary_!`)
          in.objectEndOrCommaError()
        else
          ()
      } else
        ();
      if (p0.&(7).!=(0))
        in.requiredFieldError(r11(Integer.numberOfTrailingZeros(p0)))
      else
        ();
      new Update(updated = _updated, DOI = _DOI, `type` = _type, label = _label)
    } else
      in.readNullOrTokenError(default, '{');
  private[this] def d30(in: JsonReader, default: Seq[Update]): Seq[Update] =
    if (in.isNextToken('['))
      if (in.isNextToken(']'))
        default
      else {
        in.rollbackToken();
        val x = Seq.newBuilder[Update];
        do x.+=(d31(in, null)) while (in.isNextToken(','));
        if (in.isCurrentToken(']'))
          x.result()
        else
          in.arrayEndOrCommaError()
      } else
      in.readNullOrTokenError(default, '[');
  private[this] def d33(in: JsonReader, default: Link): Link =
    if (in.isNextToken('{')) {
      var _URL: String                    = null;
      var `_content-type`: String         = null;
      var `_content-version`: String      = null;
      var `_intended-application`: String = null;
      var p0                              = 15;
      if (in.isNextToken('}').`unary_!`) {
        in.rollbackToken();
        do {
          val l = in.readKeyAsCharBuf();
          (in.charBufToHashCode(l): @switch) match {
            case 84303 =>
              if (in.isCharBufEqualsTo(l, "URL")) {
                if (p0.&(1).!=(0))
                  p0.^=(1)
                else
                  in.duplicatedKeyError(l);
                _URL = in.readString(_URL)
              } else
                in.unexpectedKeyError(l)
            case 785670158 =>
              if (in.isCharBufEqualsTo(l, "content-type")) {
                if (p0.&(2).!=(0))
                  p0.^=(2)
                else
                  in.duplicatedKeyError(l);
                `_content-type` = in.readString(`_content-type`)
              } else
                in.unexpectedKeyError(l)
            case -467293308 =>
              if (in.isCharBufEqualsTo(l, "content-version")) {
                if (p0.&(4).!=(0))
                  p0.^=(4)
                else
                  in.duplicatedKeyError(l);
                `_content-version` = in.readString(`_content-version`)
              } else
                in.unexpectedKeyError(l)
            case 1252392622 =>
              if (in.isCharBufEqualsTo(l, "intended-application")) {
                if (p0.&(8).!=(0))
                  p0.^=(8)
                else
                  in.duplicatedKeyError(l);
                `_intended-application` = in.readString(`_intended-application`)
              } else
                in.unexpectedKeyError(l)
            case _ => in.unexpectedKeyError(l)
          }
        } while (in.isNextToken(','));
        if (in.isCurrentToken('}').`unary_!`)
          in.objectEndOrCommaError()
        else
          ()
      } else
        ();
      if (p0.&(15).!=(0))
        in.requiredFieldError(r12(Integer.numberOfTrailingZeros(p0)))
      else
        ();
      new Link(URL = _URL,
        `content-type` = `_content-type`,
        `content-version` = `_content-version`,
        `intended-application` = `_intended-application`)
    } else
      in.readNullOrTokenError(default, '{');
  private[this] def d32(in: JsonReader, default: Seq[Link]): Seq[Link] =
    if (in.isNextToken('['))
      if (in.isNextToken(']'))
        default
      else {
        in.rollbackToken();
        val x = Seq.newBuilder[Link];
        do x.+=(d33(in, null)) while (in.isNextToken(','));
        if (in.isCurrentToken(']'))
          x.result()
        else
          in.arrayEndOrCommaError()
      } else
      in.readNullOrTokenError(default, '[');
  private[this] def d35(in: JsonReader, default: ClinicalTrialNumber): ClinicalTrialNumber =
    if (in.isNextToken('{')) {
      var `_clinical-trial-number`: String = null;
      var _registry: String                = null;
      var _type: Option[String]            = None;
      var p0                               = 7;
      if (in.isNextToken('}').`unary_!`) {
        in.rollbackToken();
        do {
          val l = in.readKeyAsCharBuf();
          (in.charBufToHashCode(l): @switch) match {
            case 151266906 =>
              if (in.isCharBufEqualsTo(l, "clinical-trial-number")) {
                if (p0.&(1).!=(0))
                  p0.^=(1)
                else
                  in.duplicatedKeyError(l);
                `_clinical-trial-number` = in.readString(`_clinical-trial-number`)
              } else
                in.unexpectedKeyError(l)
            case -690212803 =>
              if (in.isCharBufEqualsTo(l, "registry")) {
                if (p0.&(2).!=(0))
                  p0.^=(2)
                else
                  in.duplicatedKeyError(l);
                _registry = in.readString(_registry)
              } else
                in.unexpectedKeyError(l)
            case 3575610 =>
              if (in.isCharBufEqualsTo(l, "type")) {
                if (p0.&(4).!=(0))
                  p0.^=(4)
                else
                  in.duplicatedKeyError(l);
                _type = d6(in, _type)
              } else
                in.unexpectedKeyError(l)
            case _ => in.unexpectedKeyError(l)
          }
        } while (in.isNextToken(','));
        if (in.isCurrentToken('}').`unary_!`)
          in.objectEndOrCommaError()
        else
          ()
      } else
        ();
      if (p0.&(3).!=(0))
        in.requiredFieldError(r13(Integer.numberOfTrailingZeros(p0)))
      else
        ();
      new ClinicalTrialNumber(`clinical-trial-number` = `_clinical-trial-number`, registry = _registry, `type` = _type)
    } else
      in.readNullOrTokenError(default, '{');
  private[this] def d34(in: JsonReader, default: Seq[ClinicalTrialNumber]): Seq[ClinicalTrialNumber] =
    if (in.isNextToken('['))
      if (in.isNextToken(']'))
        default
      else {
        in.rollbackToken();
        val x = Seq.newBuilder[ClinicalTrialNumber];
        do x.+=(d35(in, null)) while (in.isNextToken(','));
        if (in.isCurrentToken(']'))
          x.result()
        else
          in.arrayEndOrCommaError()
      } else
      in.readNullOrTokenError(default, '[');
  private[this] def d39(in: JsonReader, default: JournalIssue): JournalIssue =
    if (in.isNextToken('{')) {
      var _issue: String = null;
      var p0             = 1;
      if (in.isNextToken('}').`unary_!`) {
        in.rollbackToken();
        do {
          val l = in.readKeyAsCharBuf();
          (in.charBufToHashCode(l): @switch) match {
            case 100509913 =>
              if (in.isCharBufEqualsTo(l, "issue")) {
                if (p0.&(1).!=(0))
                  p0.^=(1)
                else
                  in.duplicatedKeyError(l);
                _issue = in.readString(_issue)
              } else
                in.unexpectedKeyError(l)
            case _ => in.unexpectedKeyError(l)
          }
        } while (in.isNextToken(','));
        if (in.isCurrentToken('}').`unary_!`)
          in.objectEndOrCommaError()
        else
          ()
      } else
        ();
      if (p0.&(1).!=(0))
        in.requiredFieldError(r15(Integer.numberOfTrailingZeros(p0)))
      else
        ();
      new JournalIssue(issue = _issue)
    } else
      in.readNullOrTokenError(default, '{');
  private[this] def d38(in: JsonReader, default: Option[JournalIssue]): Option[JournalIssue] =
    if (in.isNextToken('n'))
      in.readNullOrError(default, "expected value or null")
    else {
      in.rollbackToken();
      Some(d39(in, null))
    };
  private[this] def d37(in: JsonReader, default: Reference): Reference =
    if (in.isNextToken('{')) {
      var _key: String                                       = null;
      var _author: Option[String]                            = None;
      var _issue: Option[String]                             = None;
      var _edition: Option[String]                           = None;
      var _component: Option[String]                         = None;
      var `_standard-designator`: Option[String]             = None;
      var `_standards-body`: Option[String]                  = None;
      var _unstructured: Option[String]                      = None;
      var `_article-title`: Option[String]                   = None;
      var `_series-title`: Option[String]                    = None;
      var `_volume-title`: Option[String]                    = None;
      var `_journal-issue`: Option[JournalIssue] = None;
      var _ISSN: Option[String]                              = None;
      var `_issn-type`: Option[String]                       = None;
      var _ISBN: Option[String]                              = None;
      var `_isbn-type`: Option[String]                       = None;
      var _volume: Option[String]                            = None;
      var `_first-page`: Option[String]                      = None;
      var _year: Option[String]                              = None;
      var `_journal-title`: Option[String]                   = None;
      var _DOI: Option[String]                               = None;
      var `_doi-asserted-by`: Option[String]                 = None;
      var p0                                                 = 4194303;
      if (in.isNextToken('}').`unary_!`) {
        in.rollbackToken();
        do {
          val l = in.readKeyAsCharBuf();
          (in.charBufToHashCode(l): @switch) match {
            case 106079 =>
              if (in.isCharBufEqualsTo(l, "key")) {
                if (p0.&(1).!=(0))
                  p0.^=(1)
                else
                  in.duplicatedKeyError(l);
                _key = in.readString(_key)
              } else
                in.unexpectedKeyError(l)
            case -1406328437 =>
              if (in.isCharBufEqualsTo(l, "author")) {
                if (p0.&(2).!=(0))
                  p0.^=(2)
                else
                  in.duplicatedKeyError(l);
                _author = d6(in, _author)
              } else
                in.unexpectedKeyError(l)
            case 100509913 =>
              if (in.isCharBufEqualsTo(l, "issue")) {
                if (p0.&(4).!=(0))
                  p0.^=(4)
                else
                  in.duplicatedKeyError(l);
                _issue = d6(in, _issue)
              } else
                in.unexpectedKeyError(l)
            case -1887963714 =>
              if (in.isCharBufEqualsTo(l, "edition")) {
                if (p0.&(8).!=(0))
                  p0.^=(8)
                else
                  in.duplicatedKeyError(l);
                _edition = d6(in, _edition)
              } else
                in.unexpectedKeyError(l)
            case -1399907075 =>
              if (in.isCharBufEqualsTo(l, "component")) {
                if (p0.&(16).!=(0))
                  p0.^=(16)
                else
                  in.duplicatedKeyError(l);
                _component = d6(in, _component)
              } else
                in.unexpectedKeyError(l)
            case 61026596 =>
              if (in.isCharBufEqualsTo(l, "standard-designator")) {
                if (p0.&(32).!=(0))
                  p0.^=(32)
                else
                  in.duplicatedKeyError(l);
                `_standard-designator` = d6(in, `_standard-designator`)
              } else
                in.unexpectedKeyError(l)
            case -1135736903 =>
              if (in.isCharBufEqualsTo(l, "standards-body")) {
                if (p0.&(64).!=(0))
                  p0.^=(64)
                else
                  in.duplicatedKeyError(l);
                `_standards-body` = d6(in, `_standards-body`)
              } else
                in.unexpectedKeyError(l)
            case -1988238166 =>
              if (in.isCharBufEqualsTo(l, "unstructured")) {
                if (p0.&(128).!=(0))
                  p0.^=(128)
                else
                  in.duplicatedKeyError(l);
                _unstructured = d6(in, _unstructured)
              } else
                in.unexpectedKeyError(l)
            case -768937279 =>
              if (in.isCharBufEqualsTo(l, "article-title")) {
                if (p0.&(256).!=(0))
                  p0.^=(256)
                else
                  in.duplicatedKeyError(l);
                `_article-title` = d6(in, `_article-title`)
              } else
                in.unexpectedKeyError(l)
            case -563134590 =>
              if (in.isCharBufEqualsTo(l, "series-title")) {
                if (p0.&(512).!=(0))
                  p0.^=(512)
                else
                  in.duplicatedKeyError(l);
                `_series-title` = d6(in, `_series-title`)
              } else
                in.unexpectedKeyError(l)
            case 1516364261 =>
              if (in.isCharBufEqualsTo(l, "volume-title")) {
                if (p0.&(1024).!=(0))
                  p0.^=(1024)
                else
                  in.duplicatedKeyError(l);
                `_volume-title` = d6(in, `_volume-title`)
              } else
                in.unexpectedKeyError(l)
            case -1557928253 =>
              if (in.isCharBufEqualsTo(l, "journal-issue")) {
                if (p0.&(2048).!=(0))
                  p0.^=(2048)
                else
                  in.duplicatedKeyError(l);
                `_journal-issue` = d38(in, `_journal-issue`)
              } else
                in.unexpectedKeyError(l)
            case 2257157 =>
              if (in.isCharBufEqualsTo(l, "ISSN")) {
                if (p0.&(4096).!=(0))
                  p0.^=(4096)
                else
                  in.duplicatedKeyError(l);
                _ISSN = d6(in, _ISSN)
              } else
                in.unexpectedKeyError(l)
            case -66383102 =>
              if (in.isCharBufEqualsTo(l, "issn-type")) {
                if (p0.&(8192).!=(0))
                  p0.^=(8192)
                else
                  in.duplicatedKeyError(l);
                `_issn-type` = d6(in, `_issn-type`)
              } else
                in.unexpectedKeyError(l)
            case 2256630 =>
              if (in.isCharBufEqualsTo(l, "ISBN")) {
                if (p0.&(16384).!=(0))
                  p0.^=(16384)
                else
                  in.duplicatedKeyError(l);
                _ISBN = d6(in, _ISBN)
              } else
                in.unexpectedKeyError(l)
            case 2025923505 =>
              if (in.isCharBufEqualsTo(l, "isbn-type")) {
                if (p0.&(32768).!=(0))
                  p0.^=(32768)
                else
                  in.duplicatedKeyError(l);
                `_isbn-type` = d6(in, `_isbn-type`)
              } else
                in.unexpectedKeyError(l)
            case -810883302 =>
              if (in.isCharBufEqualsTo(l, "volume")) {
                if (p0.&(65536).!=(0))
                  p0.^=(65536)
                else
                  in.duplicatedKeyError(l);
                _volume = d6(in, _volume)
              } else
                in.unexpectedKeyError(l)
            case -207102068 =>
              if (in.isCharBufEqualsTo(l, "first-page")) {
                if (p0.&(131072).!=(0))
                  p0.^=(131072)
                else
                  in.duplicatedKeyError(l);
                `_first-page` = d6(in, `_first-page`)
              } else
                in.unexpectedKeyError(l)
            case 3704893 =>
              if (in.isCharBufEqualsTo(l, "year")) {
                if (p0.&(262144).!=(0))
                  p0.^=(262144)
                else
                  in.duplicatedKeyError(l);
                _year = d6(in, _year)
              } else
                in.unexpectedKeyError(l)
            case -1548066750 =>
              if (in.isCharBufEqualsTo(l, "journal-title")) {
                if (p0.&(524288).!=(0))
                  p0.^=(524288)
                else
                  in.duplicatedKeyError(l);
                `_journal-title` = d6(in, `_journal-title`)
              } else
                in.unexpectedKeyError(l)
            case 67870 =>
              if (in.isCharBufEqualsTo(l, "DOI")) {
                if (p0.&(1048576).!=(0))
                  p0.^=(1048576)
                else
                  in.duplicatedKeyError(l);
                _DOI = d6(in, _DOI)
              } else
                in.unexpectedKeyError(l)
            case 1330102960 =>
              if (in.isCharBufEqualsTo(l, "doi-asserted-by")) {
                if (p0.&(2097152).!=(0))
                  p0.^=(2097152)
                else
                  in.duplicatedKeyError(l);
                `_doi-asserted-by` = d6(in, `_doi-asserted-by`)
              } else
                in.unexpectedKeyError(l)
            case _ => in.unexpectedKeyError(l)
          }
        } while (in.isNextToken(','));
        if (in.isCurrentToken('}').`unary_!`)
          in.objectEndOrCommaError()
        else
          ()
      } else
        ();
      if (p0.&(1).!=(0))
        in.requiredFieldError(r14(Integer.numberOfTrailingZeros(p0)))
      else
        ();
      new Reference(
        key = _key,
        author = _author,
        issue = _issue,
        edition = _edition,
        component = _component,
        `standard-designator` = `_standard-designator`,
        `standards-body` = `_standards-body`,
        unstructured = _unstructured,
        `article-title` = `_article-title`,
        `series-title` = `_series-title`,
        `volume-title` = `_volume-title`,
        `journal-issue` = `_journal-issue`,
        ISSN = _ISSN,
        `issn-type` = `_issn-type`,
        ISBN = _ISBN,
        `isbn-type` = `_isbn-type`,
        volume = _volume,
        `first-page` = `_first-page`,
        year = _year,
        `journal-title` = `_journal-title`,
        DOI = _DOI,
        `doi-asserted-by` = `_doi-asserted-by`
      )
    } else
      in.readNullOrTokenError(default, '{');
  private[this] def d36(in: JsonReader, default: Seq[Reference]): Seq[Reference] =
    if (in.isNextToken('['))
      if (in.isNextToken(']'))
        default
      else {
        in.rollbackToken();
        val x = Seq.newBuilder[Reference];
        do x.+=(d37(in, null)) while (in.isNextToken(','));
        if (in.isCurrentToken(']'))
          x.result()
        else
          in.arrayEndOrCommaError()
      } else
      in.readNullOrTokenError(default, '[');
  private[this] def d41(in: JsonReader, default: ContentDomain): ContentDomain =
    if (in.isNextToken('{')) {
      var _domain: Seq[String]              = Seq.empty[String];
      var `_crossmark-restriction`: Boolean = false;
      var p0                                = 3;
      if (in.isNextToken('}').`unary_!`) {
        in.rollbackToken();
        do {
          val l = in.readKeyAsCharBuf();
          (in.charBufToHashCode(l): @switch) match {
            case -1326197564 =>
              if (in.isCharBufEqualsTo(l, "domain")) {
                if (p0.&(1).!=(0))
                  p0.^=(1)
                else
                  in.duplicatedKeyError(l);
                _domain = d5(in, _domain)
              } else
                in.unexpectedKeyError(l)
            case 367294732 =>
              if (in.isCharBufEqualsTo(l, "crossmark-restriction")) {
                if (p0.&(2).!=(0))
                  p0.^=(2)
                else
                  in.duplicatedKeyError(l);
                `_crossmark-restriction` = in.readBoolean()
              } else
                in.unexpectedKeyError(l)
            case _ => in.unexpectedKeyError(l)
          }
        } while (in.isNextToken(','));
        if (in.isCurrentToken('}').`unary_!`)
          in.objectEndOrCommaError()
        else
          ()
      } else
        ();
      if (p0.&(2).!=(0))
        in.requiredFieldError(r16(Integer.numberOfTrailingZeros(p0)))
      else
        ();
      new ContentDomain(domain = _domain, `crossmark-restriction` = `_crossmark-restriction`)
    } else
      in.readNullOrTokenError(default, '{');
  private[this] def d40(in: JsonReader, default: Option[ContentDomain]): Option[ContentDomain] =
    if (in.isNextToken('n'))
      in.readNullOrError(default, "expected value or null")
    else {
      in.rollbackToken();
      Some(d41(in, null))
    };
  private[this] def d44(in: JsonReader, default: Relation): Relation =
    if (in.isNextToken('{')) {
      var `_id-type`: String     = null;
      var _id: String            = null;
      var `_asserted-by`: String = null;
      var p0                     = 7;
      if (in.isNextToken('}').`unary_!`) {
        in.rollbackToken();
        do {
          val l = in.readKeyAsCharBuf();
          (in.charBufToHashCode(l): @switch) match {
            case 1606655148 =>
              if (in.isCharBufEqualsTo(l, "id-type")) {
                if (p0.&(1).!=(0))
                  p0.^=(1)
                else
                  in.duplicatedKeyError(l);
                `_id-type` = in.readString(`_id-type`)
              } else
                in.unexpectedKeyError(l)
            case 3355 =>
              if (in.isCharBufEqualsTo(l, "id")) {
                if (p0.&(2).!=(0))
                  p0.^=(2)
                else
                  in.duplicatedKeyError(l);
                _id = in.readString(_id)
              } else
                in.unexpectedKeyError(l)
            case 409999551 =>
              if (in.isCharBufEqualsTo(l, "asserted-by")) {
                if (p0.&(4).!=(0))
                  p0.^=(4)
                else
                  in.duplicatedKeyError(l);
                `_asserted-by` = in.readString(`_asserted-by`)
              } else
                in.unexpectedKeyError(l)
            case _ => in.unexpectedKeyError(l)
          }
        } while (in.isNextToken(','));
        if (in.isCurrentToken('}').`unary_!`)
          in.objectEndOrCommaError()
        else
          ()
      } else
        ();
      if (p0.&(7).!=(0))
        in.requiredFieldError(r17(Integer.numberOfTrailingZeros(p0)))
      else
        ();
      new Relation(`id-type` = `_id-type`, id = _id, `asserted-by` = `_asserted-by`)
    } else
      in.readNullOrTokenError(default, '{');
  private[this] def d43(
                         in: JsonReader,
                         default: scala.collection.immutable.Map[String, Relation]): scala.collection.immutable.Map[String, Relation] =
    if (in.isNextToken('{'))
      if (in.isNextToken('}'))
        default
      else {
        in.rollbackToken();
        var x = Map.empty[String, Relation];
        do x = x.updated(in.readKeyAsString(), d44(in, null)) while (in.isNextToken(','));
        if (in.isCurrentToken('}'))
          x
        else
          in.objectEndOrCommaError()
      } else
      in.readNullOrTokenError(default, '{');
  private[this] def d42(in: JsonReader, default: Option[Map[String, Relation]]): Option[Map[String, Relation]] =
    if (in.isNextToken('n'))
      in.readNullOrError(default, "expected value or null")
    else {
      in.rollbackToken();
      Some(d43(in, Map.empty[String, Relation]))
    };
  private[this] def d4(in: JsonReader, default: Publication): Publication =
    if (in.isNextToken('{')) {
      var _publisher: String                                             = null;
      var _title: Seq[String]                                            = Seq.empty[String];
      var `_original-title`: Seq[String]                                 = Seq.empty[String];
      var `_short-title`: Seq[String]                                    = Seq.empty[String];
      var _abstract: Option[String]                                      = None;
      var `_reference-count`: Int                                        = 0;
      var `_references-count`: Int                                       = 0;
      var `_is-referenced-by-count`: Int                                 = 0;
      var _source: String                                                = null;
      var _prefix: String                                                = null;
      var _DOI: String                                                   = null;
      var _URL: String                                                   = null;
      var _member: String                                                = null;
      var _type: String                                                  = null;
      var _created: DateParts                                = null;
      var _deposited: DateParts                              = null;
      var _indexed: DateParts                                = null;
      var _issued: PartialDate                               = null;
      var _posted: Option[PartialDate]                       = None;
      var _accepted: Option[PartialDate]                     = None;
      var _subtitle: Seq[String]                                         = Seq.empty[String];
      var `_container-title`: Seq[String]                                = Seq.empty[String];
      var `_short-container-title`: Seq[String]                          = Seq.empty[String];
      var `_group-title`: Option[String]                                 = None;
      var _issue: Option[String]                                         = None;
      var _volume: Option[String]                                        = None;
      var _page: Option[String]                                          = None;
      var `_article-number`: Option[String]                              = None;
      var `_published-print`: Option[PartialDate]            = None;
      var `_published-online`: Option[PartialDate]           = None;
      var _subject: Seq[String]                                          = Seq.empty[String];
      var _ISSN: Seq[String]                                             = Seq.empty[String];
      var `_issn-type`: Seq[ISSNType]                        = Seq.empty[ISSNType];
      var _ISBN: Seq[String]                                             = Seq.empty[String];
      var _archive: Seq[String]                                          = Seq.empty[String];
      var _license: Seq[License]                             = Seq.empty[License];
      var _funder: Seq[Funder]                               = Seq.empty[Funder];
      var _assertion: Seq[Assertion]                         = Seq.empty[Assertion];
      var _author: Seq[Authors]                              = Seq.empty[Authors];
      var _editor: Seq[Contributor]                          = Seq.empty[Contributor];
      var _chair: Seq[Contributor]                           = Seq.empty[Contributor];
      var _translator: Seq[Contributor]                      = Seq.empty[Contributor];
      var `_update-to`: Seq[Update]                          = Seq.empty[Update];
      var `_update-policy`: Option[String]                               = None;
      var _link: Seq[Link]                                   = Seq.empty[Link];
      var `_clinical-trial-number`: Seq[ClinicalTrialNumber] = Seq.empty[ClinicalTrialNumber];
      var `_alternative-id`: Option[String]                              = None;
      var _reference: Seq[Reference]                         = Seq.empty[Reference];
      var `_content-domain`: Option[ContentDomain]           = None;
      var _relation: Option[Map[String, Relation]]           = None;
      var _score: Double                                                 = 0.0;
      var p0                                                             = -1;
      var p1                                                             = 524287;
      if (in.isNextToken('}').`unary_!`) {
        in.rollbackToken();
        do {
          val l = in.readKeyAsCharBuf();
          (in.charBufToHashCode(l): @switch) match {
            case 1447404028 =>
              if (in.isCharBufEqualsTo(l, "publisher")) {
                if (p0.&(1).!=(0))
                  p0.^=(1)
                else
                  in.duplicatedKeyError(l);
                _publisher = in.readString(_publisher)
              } else
                in.unexpectedKeyError(l)
            case 110371416 =>
              if (in.isCharBufEqualsTo(l, "title")) {
                if (p0.&(2).!=(0))
                  p0.^=(2)
                else
                  in.duplicatedKeyError(l);
                _title = d5(in, _title)
              } else
                in.unexpectedKeyError(l)
            case 498884444 =>
              if (in.isCharBufEqualsTo(l, "original-title")) {
                if (p0.&(4).!=(0))
                  p0.^=(4)
                else
                  in.duplicatedKeyError(l);
                `_original-title` = d5(in, `_original-title`)
              } else
                in.unexpectedKeyError(l)
            case -130716217 =>
              if (in.isCharBufEqualsTo(l, "short-title")) {
                if (p0.&(8).!=(0))
                  p0.^=(8)
                else
                  in.duplicatedKeyError(l);
                `_short-title` = d5(in, `_short-title`)
              } else
                in.unexpectedKeyError(l)
            case 1732898850 =>
              if (in.isCharBufEqualsTo(l, "abstract")) {
                if (p0.&(16).!=(0))
                  p0.^=(16)
                else
                  in.duplicatedKeyError(l);
                _abstract = d6(in, _abstract)
              } else
                in.unexpectedKeyError(l)
            case -216743923 =>
              if (in.isCharBufEqualsTo(l, "reference-count")) {
                if (p0.&(32).!=(0))
                  p0.^=(32)
                else
                  in.duplicatedKeyError(l);
                `_reference-count` = in.readInt()
              } else
                in.unexpectedKeyError(l)
            case -1985607286 =>
              if (in.isCharBufEqualsTo(l, "references-count")) {
                if (p0.&(64).!=(0))
                  p0.^=(64)
                else
                  in.duplicatedKeyError(l);
                `_references-count` = in.readInt()
              } else
                in.unexpectedKeyError(l)
            case -1152800822 =>
              if (in.isCharBufEqualsTo(l, "is-referenced-by-count")) {
                if (p0.&(128).!=(0))
                  p0.^=(128)
                else
                  in.duplicatedKeyError(l);
                `_is-referenced-by-count` = in.readInt()
              } else
                in.unexpectedKeyError(l)
            case -896505829 =>
              if (in.isCharBufEqualsTo(l, "source")) {
                if (p0.&(256).!=(0))
                  p0.^=(256)
                else
                  in.duplicatedKeyError(l);
                _source = in.readString(_source)
              } else
                in.unexpectedKeyError(l)
            case -980110702 =>
              if (in.isCharBufEqualsTo(l, "prefix")) {
                if (p0.&(512).!=(0))
                  p0.^=(512)
                else
                  in.duplicatedKeyError(l);
                _prefix = in.readString(_prefix)
              } else
                in.unexpectedKeyError(l)
            case 67870 =>
              if (in.isCharBufEqualsTo(l, "DOI")) {
                if (p0.&(1024).!=(0))
                  p0.^=(1024)
                else
                  in.duplicatedKeyError(l);
                _DOI = in.readString(_DOI)
              } else
                in.unexpectedKeyError(l)
            case 84303 =>
              if (in.isCharBufEqualsTo(l, "URL")) {
                if (p0.&(2048).!=(0))
                  p0.^=(2048)
                else
                  in.duplicatedKeyError(l);
                _URL = in.readString(_URL)
              } else
                in.unexpectedKeyError(l)
            case -1077769574 =>
              if (in.isCharBufEqualsTo(l, "member")) {
                if (p0.&(4096).!=(0))
                  p0.^=(4096)
                else
                  in.duplicatedKeyError(l);
                _member = in.readString(_member)
              } else
                in.unexpectedKeyError(l)
            case 3575610 =>
              if (in.isCharBufEqualsTo(l, "type")) {
                if (p0.&(8192).!=(0))
                  p0.^=(8192)
                else
                  in.duplicatedKeyError(l);
                _type = in.readString(_type)
              } else
                in.unexpectedKeyError(l)
            case 1028554472 =>
              if (in.isCharBufEqualsTo(l, "created")) {
                if (p0.&(16384).!=(0))
                  p0.^=(16384)
                else
                  in.duplicatedKeyError(l);
                _created = d7(in, _created)
              } else
                in.unexpectedKeyError(l)
            case -818154563 =>
              if (in.isCharBufEqualsTo(l, "deposited")) {
                if (p0.&(32768).!=(0))
                  p0.^=(32768)
                else
                  in.duplicatedKeyError(l);
                _deposited = d7(in, _deposited)
              } else
                in.unexpectedKeyError(l)
            case 1943292145 =>
              if (in.isCharBufEqualsTo(l, "indexed")) {
                if (p0.&(65536).!=(0))
                  p0.^=(65536)
                else
                  in.duplicatedKeyError(l);
                _indexed = d7(in, _indexed)
              } else
                in.unexpectedKeyError(l)
            case -1179159893 =>
              if (in.isCharBufEqualsTo(l, "issued")) {
                if (p0.&(131072).!=(0))
                  p0.^=(131072)
                else
                  in.duplicatedKeyError(l);
                _issued = d10(in, _issued)
              } else
                in.unexpectedKeyError(l)
            case -982450881 =>
              if (in.isCharBufEqualsTo(l, "posted")) {
                if (p0.&(262144).!=(0))
                  p0.^=(262144)
                else
                  in.duplicatedKeyError(l);
                _posted = d11(in, _posted)
              } else
                in.unexpectedKeyError(l)
            case -2146525273 =>
              if (in.isCharBufEqualsTo(l, "accepted")) {
                if (p0.&(524288).!=(0))
                  p0.^=(524288)
                else
                  in.duplicatedKeyError(l);
                _accepted = d11(in, _accepted)
              } else
                in.unexpectedKeyError(l)
            case -2060497896 =>
              if (in.isCharBufEqualsTo(l, "subtitle")) {
                if (p0.&(1048576).!=(0))
                  p0.^=(1048576)
                else
                  in.duplicatedKeyError(l);
                _subtitle = d5(in, _subtitle)
              } else
                in.unexpectedKeyError(l)
            case -675652084 =>
              if (in.isCharBufEqualsTo(l, "container-title")) {
                if (p0.&(2097152).!=(0))
                  p0.^=(2097152)
                else
                  in.duplicatedKeyError(l);
                `_container-title` = d5(in, `_container-title`)
              } else
                in.unexpectedKeyError(l)
            case -2086442309 =>
              if (in.isCharBufEqualsTo(l, "short-container-title")) {
                if (p0.&(4194304).!=(0))
                  p0.^=(4194304)
                else
                  in.duplicatedKeyError(l);
                `_short-container-title` = d5(in, `_short-container-title`)
              } else
                in.unexpectedKeyError(l)
            case -328855158 =>
              if (in.isCharBufEqualsTo(l, "group-title")) {
                if (p0.&(8388608).!=(0))
                  p0.^=(8388608)
                else
                  in.duplicatedKeyError(l);
                `_group-title` = d6(in, `_group-title`)
              } else
                in.unexpectedKeyError(l)
            case 100509913 =>
              if (in.isCharBufEqualsTo(l, "issue")) {
                if (p0.&(16777216).!=(0))
                  p0.^=(16777216)
                else
                  in.duplicatedKeyError(l);
                _issue = d6(in, _issue)
              } else
                in.unexpectedKeyError(l)
            case -810883302 =>
              if (in.isCharBufEqualsTo(l, "volume")) {
                if (p0.&(33554432).!=(0))
                  p0.^=(33554432)
                else
                  in.duplicatedKeyError(l);
                _volume = d6(in, _volume)
              } else
                in.unexpectedKeyError(l)
            case 3433103 =>
              if (in.isCharBufEqualsTo(l, "page")) {
                if (p0.&(67108864).!=(0))
                  p0.^=(67108864)
                else
                  in.duplicatedKeyError(l);
                _page = d6(in, _page)
              } else
                in.unexpectedKeyError(l)
            case 1771837440 =>
              if (in.isCharBufEqualsTo(l, "article-number")) {
                if (p0.&(134217728).!=(0))
                  p0.^=(134217728)
                else
                  in.duplicatedKeyError(l);
                `_article-number` = d6(in, `_article-number`)
              } else
                in.unexpectedKeyError(l)
            case 452836878 =>
              if (in.isCharBufEqualsTo(l, "published-print")) {
                if (p0.&(268435456).!=(0))
                  p0.^=(268435456)
                else
                  in.duplicatedKeyError(l);
                `_published-print` = d11(in, `_published-print`)
              } else
                in.unexpectedKeyError(l)
            case 1120802578 =>
              if (in.isCharBufEqualsTo(l, "published-online")) {
                if (p0.&(536870912).!=(0))
                  p0.^=(536870912)
                else
                  in.duplicatedKeyError(l);
                `_published-online` = d11(in, `_published-online`)
              } else
                in.unexpectedKeyError(l)
            case -1867885268 =>
              if (in.isCharBufEqualsTo(l, "subject")) {
                if (p0.&(1073741824).!=(0))
                  p0.^=(1073741824)
                else
                  in.duplicatedKeyError(l);
                _subject = d5(in, _subject)
              } else
                in.unexpectedKeyError(l)
            case 2257157 =>
              if (in.isCharBufEqualsTo(l, "ISSN")) {
                if (p0.&(-2147483648).!=(0))
                  p0.^=(-2147483648)
                else
                  in.duplicatedKeyError(l);
                _ISSN = d5(in, _ISSN)
              } else
                in.unexpectedKeyError(l)
            case -66383102 =>
              if (in.isCharBufEqualsTo(l, "issn-type")) {
                if (p1.&(1).!=(0))
                  p1.^=(1)
                else
                  in.duplicatedKeyError(l);
                `_issn-type` = d12(in, `_issn-type`)
              } else
                in.unexpectedKeyError(l)
            case 2256630 =>
              if (in.isCharBufEqualsTo(l, "ISBN")) {
                if (p1.&(2).!=(0))
                  p1.^=(2)
                else
                  in.duplicatedKeyError(l);
                _ISBN = d5(in, _ISBN)
              } else
                in.unexpectedKeyError(l)
            case -748101438 =>
              if (in.isCharBufEqualsTo(l, "archive")) {
                if (p1.&(4).!=(0))
                  p1.^=(4)
                else
                  in.duplicatedKeyError(l);
                _archive = d5(in, _archive)
              } else
                in.unexpectedKeyError(l)
            case 166757441 =>
              if (in.isCharBufEqualsTo(l, "license")) {
                if (p1.&(8).!=(0))
                  p1.^=(8)
                else
                  in.duplicatedKeyError(l);
                _license = d14(in, _license)
              } else
                in.unexpectedKeyError(l)
            case -1263365582 =>
              if (in.isCharBufEqualsTo(l, "funder")) {
                if (p1.&(16).!=(0))
                  p1.^=(16)
                else
                  in.duplicatedKeyError(l);
                _funder = d16(in, _funder)
              } else
                in.unexpectedKeyError(l)
            case 1314395906 =>
              if (in.isCharBufEqualsTo(l, "assertion")) {
                if (p1.&(32).!=(0))
                  p1.^=(32)
                else
                  in.duplicatedKeyError(l);
                _assertion = d18(in, _assertion)
              } else
                in.unexpectedKeyError(l)
            case -1406328437 =>
              if (in.isCharBufEqualsTo(l, "author")) {
                if (p1.&(64).!=(0))
                  p1.^=(64)
                else
                  in.duplicatedKeyError(l);
                _author = d23(in, _author)
              } else
                in.unexpectedKeyError(l)
            case -1307827859 =>
              if (in.isCharBufEqualsTo(l, "editor")) {
                if (p1.&(128).!=(0))
                  p1.^=(128)
                else
                  in.duplicatedKeyError(l);
                _editor = d27(in, _editor)
              } else
                in.unexpectedKeyError(l)
            case 94623429 =>
              if (in.isCharBufEqualsTo(l, "chair")) {
                if (p1.&(256).!=(0))
                  p1.^=(256)
                else
                  in.duplicatedKeyError(l);
                _chair = d27(in, _chair)
              } else
                in.unexpectedKeyError(l)
            case -1721943526 =>
              if (in.isCharBufEqualsTo(l, "translator")) {
                if (p1.&(512).!=(0))
                  p1.^=(512)
                else
                  in.duplicatedKeyError(l);
                _translator = d27(in, _translator)
              } else
                in.unexpectedKeyError(l)
            case -1949245953 =>
              if (in.isCharBufEqualsTo(l, "update-to")) {
                if (p1.&(1024).!=(0))
                  p1.^=(1024)
                else
                  in.duplicatedKeyError(l);
                `_update-to` = d30(in, `_update-to`)
              } else
                in.unexpectedKeyError(l)
            case 1434653366 =>
              if (in.isCharBufEqualsTo(l, "update-policy")) {
                if (p1.&(2048).!=(0))
                  p1.^=(2048)
                else
                  in.duplicatedKeyError(l);
                `_update-policy` = d6(in, `_update-policy`)
              } else
                in.unexpectedKeyError(l)
            case 3321850 =>
              if (in.isCharBufEqualsTo(l, "link")) {
                if (p1.&(4096).!=(0))
                  p1.^=(4096)
                else
                  in.duplicatedKeyError(l);
                _link = d32(in, _link)
              } else
                in.unexpectedKeyError(l)
            case 151266906 =>
              if (in.isCharBufEqualsTo(l, "clinical-trial-number")) {
                if (p1.&(8192).!=(0))
                  p1.^=(8192)
                else
                  in.duplicatedKeyError(l);
                `_clinical-trial-number` = d34(in, `_clinical-trial-number`)
              } else
                in.unexpectedKeyError(l)
            case -73084101 =>
              if (in.isCharBufEqualsTo(l, "alternative-id")) {
                if (p1.&(16384).!=(0))
                  p1.^=(16384)
                else
                  in.duplicatedKeyError(l);
                `_alternative-id` = d6(in, `_alternative-id`)
              } else
                in.unexpectedKeyError(l)
            case -925155509 =>
              if (in.isCharBufEqualsTo(l, "reference")) {
                if (p1.&(32768).!=(0))
                  p1.^=(32768)
                else
                  in.duplicatedKeyError(l);
                _reference = d36(in, _reference)
              } else
                in.unexpectedKeyError(l)
            case -1352613736 =>
              if (in.isCharBufEqualsTo(l, "content-domain")) {
                if (p1.&(65536).!=(0))
                  p1.^=(65536)
                else
                  in.duplicatedKeyError(l);
                `_content-domain` = d40(in, `_content-domain`)
              } else
                in.unexpectedKeyError(l)
            case -554436100 =>
              if (in.isCharBufEqualsTo(l, "relation")) {
                if (p1.&(131072).!=(0))
                  p1.^=(131072)
                else
                  in.duplicatedKeyError(l);
                _relation = d42(in, _relation)
              } else
                in.unexpectedKeyError(l)
            case 109264530 =>
              if (in.isCharBufEqualsTo(l, "score")) {
                if (p1.&(262144).!=(0))
                  p1.^=(262144)
                else
                  in.duplicatedKeyError(l);
                _score = in.readDouble()
              } else
                in.unexpectedKeyError(l)
            case _ => in.unexpectedKeyError(l)
          }
        } while (in.isNextToken(','));
        if (in.isCurrentToken('}').`unary_!`)
          in.objectEndOrCommaError()
        else
          ()
      } else
        ();
      if (p0.&(262113).!=(0))
        in.requiredFieldError(r2(Integer.numberOfTrailingZeros(p0)))
      else
        ();
      if (p1.&(262144).!=(0))
        in.requiredFieldError(r2(Integer.numberOfTrailingZeros(p1).+(32)))
      else
        ();
      new Publication(
        publisher = _publisher,
        title = _title,
        `original-title` = `_original-title`,
        `short-title` = `_short-title`,
        `abstract` = _abstract,
        `reference-count` = `_reference-count`,
        `references-count` = `_references-count`,
        `is-referenced-by-count` = `_is-referenced-by-count`,
        source = _source,
        prefix = _prefix,
        DOI = _DOI,
        URL = _URL,
        member = _member,
        `type` = _type,
        created = _created,
        deposited = _deposited,
        indexed = _indexed,
        issued = _issued,
        posted = _posted,
        accepted = _accepted,
        subtitle = _subtitle,
        `container-title` = `_container-title`,
        `short-container-title` = `_short-container-title`,
        `group-title` = `_group-title`,
        issue = _issue,
        volume = _volume,
        page = _page,
        `article-number` = `_article-number`,
        `published-print` = `_published-print`,
        `published-online` = `_published-online`,
        subject = _subject,
        ISSN = _ISSN,
        `issn-type` = `_issn-type`,
        ISBN = _ISBN,
        archive = _archive,
        license = _license,
        funder = _funder,
        assertion = _assertion,
        author = _author,
        editor = _editor,
        chair = _chair,
        translator = _translator,
        `update-to` = `_update-to`,
        `update-policy` = `_update-policy`,
        link = _link,
        `clinical-trial-number` = `_clinical-trial-number`,
        `alternative-id` = `_alternative-id`,
        reference = _reference,
        `content-domain` = `_content-domain`,
        relation = _relation,
        score = _score
      )
    } else
      in.readNullOrTokenError(default, '{');
  private[this] def d3(in: JsonReader, default: Seq[Publication]): Seq[Publication] =
    if (in.isNextToken('['))
      if (in.isNextToken(']'))
        default
      else {
        in.rollbackToken();
        val x = Seq.newBuilder[Publication];
        do x.+=(d4(in, null)) while (in.isNextToken(','));
        if (in.isCurrentToken(']'))
          x.result()
        else
          in.arrayEndOrCommaError()
      } else
      in.readNullOrTokenError(default, '[');
  private[this] def d45(in: JsonReader, default: Query): Query =
    if (in.isNextToken('{')) {
      var `_start-index`: Int             = 0;
      var `_search-terms`: Option[String] = None;
      var p0                              = 3;
      if (in.isNextToken('}').`unary_!`) {
        in.rollbackToken();
        do {
          val l = in.readKeyAsCharBuf();
          (in.charBufToHashCode(l): @switch) match {
            case 1330622375 =>
              if (in.isCharBufEqualsTo(l, "start-index")) {
                if (p0.&(1).!=(0))
                  p0.^=(1)
                else
                  in.duplicatedKeyError(l);
                `_start-index` = in.readInt()
              } else
                in.unexpectedKeyError(l)
            case -967973598 =>
              if (in.isCharBufEqualsTo(l, "search-terms")) {
                if (p0.&(2).!=(0))
                  p0.^=(2)
                else
                  in.duplicatedKeyError(l);
                `_search-terms` = d6(in, `_search-terms`)
              } else
                in.unexpectedKeyError(l)
            case _ => in.unexpectedKeyError(l)
          }
        } while (in.isNextToken(','));
        if (in.isCurrentToken('}').`unary_!`)
          in.objectEndOrCommaError()
        else
          ()
      } else
        ();
      if (p0.&(1).!=(0))
        in.requiredFieldError(r18(Integer.numberOfTrailingZeros(p0)))
      else
        ();
      new Query(`start-index` = `_start-index`, `search-terms` = `_search-terms`)
    } else
      in.readNullOrTokenError(default, '{');
  private[this] def d1(in: JsonReader, default: Items): Items =
    if (in.isNextToken('{')) {
      var _facets: scala.collection.immutable.Map[String, String] = Map.empty[String, String];
      var `_total-results`: Long                                  = 0L;
      var _items: Seq[Publication]                    = Seq.empty[Publication];
      var `_items-per-page`: Int                                  = 0;
      var _query: Query                               = null;
      var `_next-cursor`: Option[String]                          = None;
      var p0                                                      = 63;
      if (in.isNextToken('}').`unary_!`) {
        in.rollbackToken();
        do {
          val l = in.readKeyAsCharBuf();
          (in.charBufToHashCode(l): @switch) match {
            case -1282162276 =>
              if (in.isCharBufEqualsTo(l, "facets")) {
                if (p0.&(1).!=(0))
                  p0.^=(1)
                else
                  in.duplicatedKeyError(l);
                _facets = d2(in, _facets)
              } else
                in.unexpectedKeyError(l)
            case -2118551955 =>
              if (in.isCharBufEqualsTo(l, "total-results")) {
                if (p0.&(2).!=(0))
                  p0.^=(2)
                else
                  in.duplicatedKeyError(l);
                `_total-results` = in.readLong()
              } else
                in.unexpectedKeyError(l)
            case 100526016 =>
              if (in.isCharBufEqualsTo(l, "items")) {
                if (p0.&(4).!=(0))
                  p0.^=(4)
                else
                  in.duplicatedKeyError(l);
                _items = d3(in, _items)
              } else
                in.unexpectedKeyError(l)
            case 157438124 =>
              if (in.isCharBufEqualsTo(l, "items-per-page")) {
                if (p0.&(8).!=(0))
                  p0.^=(8)
                else
                  in.duplicatedKeyError(l);
                `_items-per-page` = in.readInt()
              } else
                in.unexpectedKeyError(l)
            case 107944136 =>
              if (in.isCharBufEqualsTo(l, "query")) {
                if (p0.&(16).!=(0))
                  p0.^=(16)
                else
                  in.duplicatedKeyError(l);
                _query = d45(in, _query)
              } else
                in.unexpectedKeyError(l)
            case -378975376 =>
              if (in.isCharBufEqualsTo(l, "next-cursor")) {
                if (p0.&(32).!=(0))
                  p0.^=(32)
                else
                  in.duplicatedKeyError(l);
                `_next-cursor` = d6(in, `_next-cursor`)
              } else
                in.unexpectedKeyError(l)
            case _ => in.unexpectedKeyError(l)
          }
        } while (in.isNextToken(','));
        if (in.isCurrentToken('}').`unary_!`)
          in.objectEndOrCommaError()
        else
          ()
      } else
        ();
      if (p0.&(26).!=(0))
        in.requiredFieldError(r1(Integer.numberOfTrailingZeros(p0)))
      else
        ();
      new Items(facets = _facets,
        `total-results` = `_total-results`,
        items = _items,
        `items-per-page` = `_items-per-page`,
        query = _query,
        `next-cursor` = `_next-cursor`)
    } else
      in.readNullOrTokenError(default, '{');
  private[this] def d0(in: JsonReader, default: ItemResponse): ItemResponse =
    if (in.isNextToken('{')) {
      var _status: String             = null;
      var `_message-type`: String     = null;
      var `_message-version`: String  = null;
      var _message: Items = null;
      var p0                          = 15;
      if (in.isNextToken('}').`unary_!`) {
        in.rollbackToken();
        do {
          val l = in.readKeyAsCharBuf();
          (in.charBufToHashCode(l): @switch) match {
            case -892481550 =>
              if (in.isCharBufEqualsTo(l, "status")) {
                if (p0.&(1).!=(0))
                  p0.^=(1)
                else
                  in.duplicatedKeyError(l);
                _status = in.readString(_status)
              } else
                in.unexpectedKeyError(l)
            case -1332241088 =>
              if (in.isCharBufEqualsTo(l, "message-type")) {
                if (p0.&(2).!=(0))
                  p0.^=(2)
                else
                  in.duplicatedKeyError(l);
                `_message-type` = in.readString(`_message-type`)
              } else
                in.unexpectedKeyError(l)
            case -2091644654 =>
              if (in.isCharBufEqualsTo(l, "message-version")) {
                if (p0.&(4).!=(0))
                  p0.^=(4)
                else
                  in.duplicatedKeyError(l);
                `_message-version` = in.readString(`_message-version`)
              } else
                in.unexpectedKeyError(l)
            case 954925063 =>
              if (in.isCharBufEqualsTo(l, "message")) {
                if (p0.&(8).!=(0))
                  p0.^=(8)
                else
                  in.duplicatedKeyError(l);
                _message = d1(in, _message)
              } else
                in.unexpectedKeyError(l)
            case _ => in.unexpectedKeyError(l)
          }
        } while (in.isNextToken(','));
        if (in.isCurrentToken('}').`unary_!`)
          in.objectEndOrCommaError()
        else
          ()
      } else
        ();
      if (p0.&(15).!=(0))
        in.requiredFieldError(r0(Integer.numberOfTrailingZeros(p0)))
      else
        ();
      new ItemResponse(status = _status,
        `message-type` = `_message-type`,
        `message-version` = `_message-version`,
        message = _message)
    } else
      in.readNullOrTokenError(default, '{');
  private[this] def e2(x: scala.collection.immutable.Map[String, String], out: JsonWriter): Unit = {
    out.writeObjectStart();
    x.foreach(((kv) => {
      out.writeKey(kv._1);
      out.writeVal(kv._2)
    }));
    out.writeObjectEnd()
  };
  private[this] def e5(x: Seq[String], out: JsonWriter): Unit = {
    out.writeArrayStart();
    x.foreach(((x) => {
      out.writeComma();
      out.writeVal(x)
    }));
    out.writeArrayEnd()
  };
  private[this] def e8(x: Array[Int], out: JsonWriter): Unit = {
    out.writeArrayStart();
    val l = x.length;
    var i = 0;
    while (i.<(l)) {
      out.writeComma();
      out.writeVal(x(i));
      i.+=(1)
    };
    out.writeArrayEnd()
  };
  private[this] def e7(x: Array[Array[Int]], out: JsonWriter): Unit = {
    out.writeArrayStart();
    val l = x.length;
    var i = 0;
    while (i.<(l)) {
      out.writeComma();
      e8(x(i), out);
      i.+=(1)
    };
    out.writeArrayEnd()
  };
  private[this] def e6(x: DateParts, out: JsonWriter): Unit = {
    out.writeObjectStart();
    {
      val v = x.`date-parts`;
      if (v.length.>(0)) {
        out.writeNonEscapedAsciiKey("date-parts");
        e7(v, out)
      } else
        ()
    };
    {
      out.writeNonEscapedAsciiKey("date-time");
      out.writeVal(x.`date-time`)
    };
    {
      out.writeNonEscapedAsciiKey("timestamp");
      out.writeVal(x.timestamp)
    };
    out.writeObjectEnd()
  };
  private[this] def e9(x: PartialDate, out: JsonWriter): Unit = {
    out.writeObjectStart();
    {
      val v = x.`date-parts`;
      if (v.length.>(0)) {
        out.writeNonEscapedAsciiKey("date-parts");
        e7(v, out)
      } else
        ()
    };
    out.writeObjectEnd()
  };
  private[this] def e11(x: ISSNType, out: JsonWriter): Unit = {
    out.writeObjectStart();
    {
      out.writeNonEscapedAsciiKey("value");
      out.writeVal(x.value)
    };
    {
      out.writeNonEscapedAsciiKey("type");
      out.writeVal(x.`type`)
    };
    out.writeObjectEnd()
  };
  private[this] def e10(x: Seq[ISSNType], out: JsonWriter): Unit = {
    out.writeArrayStart();
    x.foreach(((x) => {
      out.writeComma();
      e11(x, out)
    }));
    out.writeArrayEnd()
  };
  private[this] def e13(x: License, out: JsonWriter): Unit = {
    out.writeObjectStart();
    {
      out.writeNonEscapedAsciiKey("content-version");
      out.writeVal(x.`content-version`)
    };
    {
      out.writeNonEscapedAsciiKey("delay-in-days");
      out.writeVal(x.`delay-in-days`)
    };
    {
      out.writeNonEscapedAsciiKey("start");
      e6(x.start, out)
    };
    {
      out.writeNonEscapedAsciiKey("URL");
      out.writeVal(x.URL)
    };
    out.writeObjectEnd()
  };
  private[this] def e12(x: Seq[License], out: JsonWriter): Unit = {
    out.writeArrayStart();
    x.foreach(((x) => {
      out.writeComma();
      e13(x, out)
    }));
    out.writeArrayEnd()
  };
  private[this] def e15(x: Funder, out: JsonWriter): Unit = {
    out.writeObjectStart();
    {
      out.writeNonEscapedAsciiKey("name");
      out.writeVal(x.name)
    };
    {
      val v = x.DOI;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("DOI");
        out.writeVal(v.get)
      } else
        ()
    };
    {
      val v = x.award;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("award");
        e5(v, out)
      } else
        ()
    };
    {
      val v = x.`doi-asserted-by`;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("doi-asserted-by");
        out.writeVal(v.get)
      } else
        ()
    };
    out.writeObjectEnd()
  };
  private[this] def e14(x: Seq[Funder], out: JsonWriter): Unit = {
    out.writeArrayStart();
    x.foreach(((x) => {
      out.writeComma();
      e15(x, out)
    }));
    out.writeArrayEnd()
  };
  private[this] def e18(x: AssertionGroup, out: JsonWriter): Unit = {
    out.writeObjectStart();
    {
      out.writeNonEscapedAsciiKey("name");
      out.writeVal(x.name)
    };
    {
      val v = x.label;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("label");
        out.writeVal(v.get)
      } else
        ()
    };
    out.writeObjectEnd()
  };
  private[this] def e17(x: Assertion, out: JsonWriter): Unit = {
    out.writeObjectStart();
    {
      out.writeNonEscapedAsciiKey("name");
      out.writeVal(x.name)
    };
    {
      out.writeNonEscapedAsciiKey("value");
      out.writeVal(x.value)
    };
    {
      val v = x.URL;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("URL");
        out.writeVal(v.get)
      } else
        ()
    };
    {
      val v = x.explanation;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("explanation");
        out.writeVal(v.get)
      } else
        ()
    };
    {
      val v = x.label;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("label");
        out.writeVal(v.get)
      } else
        ()
    };
    {
      val v = x.order;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("order");
        out.writeVal(v.get)
      } else
        ()
    };
    {
      val v = x.group;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("group");
        e18(v.get, out)
      } else
        ()
    };
    out.writeObjectEnd()
  };
  private[this] def e16(x: Seq[Assertion], out: JsonWriter): Unit = {
    out.writeArrayStart();
    x.foreach(((x) => {
      out.writeComma();
      e17(x, out)
    }));
    out.writeArrayEnd()
  };
  private[this] def e22(x: Affiliation, out: JsonWriter): Unit = {
    out.writeObjectStart();
    {
      out.writeNonEscapedAsciiKey("name");
      out.writeVal(x.name)
    };
    out.writeObjectEnd()
  };
  private[this] def e21(x: Seq[Affiliation], out: JsonWriter): Unit = {
    out.writeArrayStart();
    x.foreach(((x) => {
      out.writeComma();
      e22(x, out)
    }));
    out.writeArrayEnd()
  };
  private[this] def e20(x: Authors, out: JsonWriter): Unit = {
    out.writeObjectStart();
    {
      val v = x.given;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("given");
        out.writeVal(v.get)
      } else
        ()
    };
    {
      val v = x.family;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("family");
        out.writeVal(v.get)
      } else
        ()
    };
    {
      val v = x.affiliation;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("affiliation");
        e21(v, out)
      } else
        ()
    };
    out.writeObjectEnd()
  };
  private[this] def e19(x: Seq[Authors], out: JsonWriter): Unit = {
    out.writeArrayStart();
    x.foreach(((x) => {
      out.writeComma();
      e20(x, out)
    }));
    out.writeArrayEnd()
  };
  private[this] def e24(x: Contributor, out: JsonWriter): Unit = {
    out.writeObjectStart();
    {
      out.writeNonEscapedAsciiKey("family");
      out.writeVal(x.family)
    };
    {
      val v = x.given;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("given");
        out.writeVal(v.get)
      } else
        ()
    };
    {
      val v = x.ORCID;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("ORCID");
        out.writeVal(v.get)
      } else
        ()
    };
    {
      val v = x.`authenticated-orcid`;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("authenticated-orcid");
        out.writeVal(v.get)
      } else
        ()
    };
    {
      val v = x.affiliation;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("affiliation");
        e21(v, out)
      } else
        ()
    };
    out.writeObjectEnd()
  };
  private[this] def e23(x: Seq[Contributor], out: JsonWriter): Unit = {
    out.writeArrayStart();
    x.foreach(((x) => {
      out.writeComma();
      e24(x, out)
    }));
    out.writeArrayEnd()
  };
  private[this] def e26(x: Update, out: JsonWriter): Unit = {
    out.writeObjectStart();
    {
      out.writeNonEscapedAsciiKey("updated");
      e9(x.updated, out)
    };
    {
      out.writeNonEscapedAsciiKey("DOI");
      out.writeVal(x.DOI)
    };
    {
      out.writeNonEscapedAsciiKey("type");
      out.writeVal(x.`type`)
    };
    {
      val v = x.label;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("label");
        out.writeVal(v.get)
      } else
        ()
    };
    out.writeObjectEnd()
  };
  private[this] def e25(x: Seq[Update], out: JsonWriter): Unit = {
    out.writeArrayStart();
    x.foreach(((x) => {
      out.writeComma();
      e26(x, out)
    }));
    out.writeArrayEnd()
  };
  private[this] def e28(x: Link, out: JsonWriter): Unit = {
    out.writeObjectStart();
    {
      out.writeNonEscapedAsciiKey("URL");
      out.writeVal(x.URL)
    };
    {
      out.writeNonEscapedAsciiKey("content-type");
      out.writeVal(x.`content-type`)
    };
    {
      out.writeNonEscapedAsciiKey("content-version");
      out.writeVal(x.`content-version`)
    };
    {
      out.writeNonEscapedAsciiKey("intended-application");
      out.writeVal(x.`intended-application`)
    };
    out.writeObjectEnd()
  };
  private[this] def e27(x: Seq[Link], out: JsonWriter): Unit = {
    out.writeArrayStart();
    x.foreach(((x) => {
      out.writeComma();
      e28(x, out)
    }));
    out.writeArrayEnd()
  };
  private[this] def e30(x: ClinicalTrialNumber, out: JsonWriter): Unit = {
    out.writeObjectStart();
    {
      out.writeNonEscapedAsciiKey("clinical-trial-number");
      out.writeVal(x.`clinical-trial-number`)
    };
    {
      out.writeNonEscapedAsciiKey("registry");
      out.writeVal(x.registry)
    };
    {
      val v = x.`type`;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("type");
        out.writeVal(v.get)
      } else
        ()
    };
    out.writeObjectEnd()
  };
  private[this] def e29(x: Seq[ClinicalTrialNumber], out: JsonWriter): Unit = {
    out.writeArrayStart();
    x.foreach(((x) => {
      out.writeComma();
      e30(x, out)
    }));
    out.writeArrayEnd()
  };
  private[this] def e33(x: JournalIssue, out: JsonWriter): Unit = {
    out.writeObjectStart();
    {
      out.writeNonEscapedAsciiKey("issue");
      out.writeVal(x.issue)
    };
    out.writeObjectEnd()
  };
  private[this] def e32(x: Reference, out: JsonWriter): Unit = {
    out.writeObjectStart();
    {
      out.writeNonEscapedAsciiKey("key");
      out.writeVal(x.key)
    };
    {
      val v = x.author;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("author");
        out.writeVal(v.get)
      } else
        ()
    };
    {
      val v = x.issue;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("issue");
        out.writeVal(v.get)
      } else
        ()
    };
    {
      val v = x.edition;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("edition");
        out.writeVal(v.get)
      } else
        ()
    };
    {
      val v = x.component;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("component");
        out.writeVal(v.get)
      } else
        ()
    };
    {
      val v = x.`standard-designator`;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("standard-designator");
        out.writeVal(v.get)
      } else
        ()
    };
    {
      val v = x.`standards-body`;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("standards-body");
        out.writeVal(v.get)
      } else
        ()
    };
    {
      val v = x.unstructured;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("unstructured");
        out.writeVal(v.get)
      } else
        ()
    };
    {
      val v = x.`article-title`;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("article-title");
        out.writeVal(v.get)
      } else
        ()
    };
    {
      val v = x.`series-title`;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("series-title");
        out.writeVal(v.get)
      } else
        ()
    };
    {
      val v = x.`volume-title`;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("volume-title");
        out.writeVal(v.get)
      } else
        ()
    };
    {
      val v = x.`journal-issue`;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("journal-issue");
        e33(v.get, out)
      } else
        ()
    };
    {
      val v = x.ISSN;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("ISSN");
        out.writeVal(v.get)
      } else
        ()
    };
    {
      val v = x.`issn-type`;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("issn-type");
        out.writeVal(v.get)
      } else
        ()
    };
    {
      val v = x.ISBN;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("ISBN");
        out.writeVal(v.get)
      } else
        ()
    };
    {
      val v = x.`isbn-type`;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("isbn-type");
        out.writeVal(v.get)
      } else
        ()
    };
    {
      val v = x.volume;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("volume");
        out.writeVal(v.get)
      } else
        ()
    };
    {
      val v = x.`first-page`;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("first-page");
        out.writeVal(v.get)
      } else
        ()
    };
    {
      val v = x.year;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("year");
        out.writeVal(v.get)
      } else
        ()
    };
    {
      val v = x.`journal-title`;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("journal-title");
        out.writeVal(v.get)
      } else
        ()
    };
    {
      val v = x.DOI;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("DOI");
        out.writeVal(v.get)
      } else
        ()
    };
    {
      val v = x.`doi-asserted-by`;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("doi-asserted-by");
        out.writeVal(v.get)
      } else
        ()
    };
    out.writeObjectEnd()
  };
  private[this] def e31(x: Seq[Reference], out: JsonWriter): Unit = {
    out.writeArrayStart();
    x.foreach(((x) => {
      out.writeComma();
      e32(x, out)
    }));
    out.writeArrayEnd()
  };
  private[this] def e34(x: ContentDomain, out: JsonWriter): Unit = {
    out.writeObjectStart();
    {
      val v = x.domain;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("domain");
        e5(v, out)
      } else
        ()
    };
    {
      out.writeNonEscapedAsciiKey("crossmark-restriction");
      out.writeVal(x.`crossmark-restriction`)
    };
    out.writeObjectEnd()
  };
  private[this] def e36(x: Relation, out: JsonWriter): Unit = {
    out.writeObjectStart();
    {
      out.writeNonEscapedAsciiKey("id-type");
      out.writeVal(x.`id-type`)
    };
    {
      out.writeNonEscapedAsciiKey("id");
      out.writeVal(x.id)
    };
    {
      out.writeNonEscapedAsciiKey("asserted-by");
      out.writeVal(x.`asserted-by`)
    };
    out.writeObjectEnd()
  };
  private[this] def e35(x: scala.collection.immutable.Map[String, Relation], out: JsonWriter): Unit = {
    out.writeObjectStart();
    x.foreach(((kv) => {
      out.writeKey(kv._1);
      e36(kv._2, out)
    }));
    out.writeObjectEnd()
  };
  private[this] def e4(x: Publication, out: JsonWriter): Unit = {
    out.writeObjectStart();
    {
      out.writeNonEscapedAsciiKey("publisher");
      out.writeVal(x.publisher)
    };
    {
      val v = x.title;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("title");
        e5(v, out)
      } else
        ()
    };
    {
      val v = x.`original-title`;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("original-title");
        e5(v, out)
      } else
        ()
    };
    {
      val v = x.`short-title`;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("short-title");
        e5(v, out)
      } else
        ()
    };
    {
      val v = x.`abstract`;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("abstract");
        out.writeVal(v.get)
      } else
        ()
    };
    {
      out.writeNonEscapedAsciiKey("reference-count");
      out.writeVal(x.`reference-count`)
    };
    {
      out.writeNonEscapedAsciiKey("references-count");
      out.writeVal(x.`references-count`)
    };
    {
      out.writeNonEscapedAsciiKey("is-referenced-by-count");
      out.writeVal(x.`is-referenced-by-count`)
    };
    {
      out.writeNonEscapedAsciiKey("source");
      out.writeVal(x.source)
    };
    {
      out.writeNonEscapedAsciiKey("prefix");
      out.writeVal(x.prefix)
    };
    {
      out.writeNonEscapedAsciiKey("DOI");
      out.writeVal(x.DOI)
    };
    {
      out.writeNonEscapedAsciiKey("URL");
      out.writeVal(x.URL)
    };
    {
      out.writeNonEscapedAsciiKey("member");
      out.writeVal(x.member)
    };
    {
      out.writeNonEscapedAsciiKey("type");
      out.writeVal(x.`type`)
    };
    {
      out.writeNonEscapedAsciiKey("created");
      e6(x.created, out)
    };
    {
      out.writeNonEscapedAsciiKey("deposited");
      e6(x.deposited, out)
    };
    {
      out.writeNonEscapedAsciiKey("indexed");
      e6(x.indexed, out)
    };
    {
      out.writeNonEscapedAsciiKey("issued");
      e9(x.issued, out)
    };
    {
      val v = x.posted;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("posted");
        e9(v.get, out)
      } else
        ()
    };
    {
      val v = x.accepted;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("accepted");
        e9(v.get, out)
      } else
        ()
    };
    {
      val v = x.subtitle;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("subtitle");
        e5(v, out)
      } else
        ()
    };
    {
      val v = x.`container-title`;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("container-title");
        e5(v, out)
      } else
        ()
    };
    {
      val v = x.`short-container-title`;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("short-container-title");
        e5(v, out)
      } else
        ()
    };
    {
      val v = x.`group-title`;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("group-title");
        out.writeVal(v.get)
      } else
        ()
    };
    {
      val v = x.issue;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("issue");
        out.writeVal(v.get)
      } else
        ()
    };
    {
      val v = x.volume;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("volume");
        out.writeVal(v.get)
      } else
        ()
    };
    {
      val v = x.page;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("page");
        out.writeVal(v.get)
      } else
        ()
    };
    {
      val v = x.`article-number`;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("article-number");
        out.writeVal(v.get)
      } else
        ()
    };
    {
      val v = x.`published-print`;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("published-print");
        e9(v.get, out)
      } else
        ()
    };
    {
      val v = x.`published-online`;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("published-online");
        e9(v.get, out)
      } else
        ()
    };
    {
      val v = x.subject;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("subject");
        e5(v, out)
      } else
        ()
    };
    {
      val v = x.ISSN;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("ISSN");
        e5(v, out)
      } else
        ()
    };
    {
      val v = x.`issn-type`;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("issn-type");
        e10(v, out)
      } else
        ()
    };
    {
      val v = x.ISBN;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("ISBN");
        e5(v, out)
      } else
        ()
    };
    {
      val v = x.archive;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("archive");
        e5(v, out)
      } else
        ()
    };
    {
      val v = x.license;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("license");
        e12(v, out)
      } else
        ()
    };
    {
      val v = x.funder;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("funder");
        e14(v, out)
      } else
        ()
    };
    {
      val v = x.assertion;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("assertion");
        e16(v, out)
      } else
        ()
    };
    {
      val v = x.author;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("author");
        e19(v, out)
      } else
        ()
    };
    {
      val v = x.editor;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("editor");
        e23(v, out)
      } else
        ()
    };
    {
      val v = x.chair;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("chair");
        e23(v, out)
      } else
        ()
    };
    {
      val v = x.translator;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("translator");
        e23(v, out)
      } else
        ()
    };
    {
      val v = x.`update-to`;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("update-to");
        e25(v, out)
      } else
        ()
    };
    {
      val v = x.`update-policy`;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("update-policy");
        out.writeVal(v.get)
      } else
        ()
    };
    {
      val v = x.link;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("link");
        e27(v, out)
      } else
        ()
    };
    {
      val v = x.`clinical-trial-number`;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("clinical-trial-number");
        e29(v, out)
      } else
        ()
    };
    {
      val v = x.`alternative-id`;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("alternative-id");
        out.writeVal(v.get)
      } else
        ()
    };
    {
      val v = x.reference;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("reference");
        e31(v, out)
      } else
        ()
    };
    {
      val v = x.`content-domain`;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("content-domain");
        e34(v.get, out)
      } else
        ()
    };
    {
      val v = x.relation;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("relation");
        e35(v.get, out)
      } else
        ()
    };
    {
      out.writeNonEscapedAsciiKey("score");
      out.writeVal(x.score)
    };
    out.writeObjectEnd()
  };
  private[this] def e3(x: Seq[Publication], out: JsonWriter): Unit = {
    out.writeArrayStart();
    x.foreach(((x) => {
      out.writeComma();
      e4(x, out)
    }));
    out.writeArrayEnd()
  };
  private[this] def e37(x: Query, out: JsonWriter): Unit = {
    out.writeObjectStart();
    {
      out.writeNonEscapedAsciiKey("start-index");
      out.writeVal(x.`start-index`)
    };
    {
      val v = x.`search-terms`;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("search-terms");
        out.writeVal(v.get)
      } else
        ()
    };
    out.writeObjectEnd()
  };
  private[this] def e1(x: Items, out: JsonWriter): Unit = {
    out.writeObjectStart();
    {
      val v = x.facets;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("facets");
        e2(v, out)
      } else
        ()
    };
    {
      out.writeNonEscapedAsciiKey("total-results");
      out.writeVal(x.`total-results`)
    };
    {
      val v = x.items;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("items");
        e3(v, out)
      } else
        ()
    };
    {
      out.writeNonEscapedAsciiKey("items-per-page");
      out.writeVal(x.`items-per-page`)
    };
    {
      out.writeNonEscapedAsciiKey("query");
      e37(x.query, out)
    };
    {
      val v = x.`next-cursor`;
      if (v.isEmpty.`unary_!`) {
        out.writeNonEscapedAsciiKey("next-cursor");
        out.writeVal(v.get)
      } else
        ()
    };
    out.writeObjectEnd()
  };
  private[this] def e0(x: ItemResponse, out: JsonWriter): Unit = {
    out.writeObjectStart();
    {
      out.writeNonEscapedAsciiKey("status");
      out.writeVal(x.status)
    };
    {
      out.writeNonEscapedAsciiKey("message-type");
      out.writeVal(x.`message-type`)
    };
    {
      out.writeNonEscapedAsciiKey("message-version");
      out.writeVal(x.`message-version`)
    };
    {
      out.writeNonEscapedAsciiKey("message");
      e1(x.message, out)
    };
    out.writeObjectEnd()
  }
};