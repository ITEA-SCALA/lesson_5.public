package com.itea.task2

sealed trait Json {

  def getOrElse(empty: Any): String = this match {
    case JsonNumeric(value) => "(Numeric) " + value
    case JsonString(value) if value!=null => "(String) \"" + value + "\""
    case JsonBoolean(value) => "(Boolean) " + value
    case None               => empty.toString
    case _                  => null
  }
}

case object None extends Json
case class JsonNumeric(value: Integer) extends Json
case class JsonString(value: String) extends Json
case class JsonBoolean(value: Boolean) extends Json

object ToJsonApp extends App {
  println( None.getOrElse(None) ) // None
  println( JsonString(null).getOrElse(None) ) // null
  println( JsonNumeric(100).getOrElse(None) ) // (Numeric) 100
  println( JsonString("Hello").getOrElse(None) ) // (String) Hello
  println( JsonBoolean(true).getOrElse(None) ) // (Boolean) true
}
