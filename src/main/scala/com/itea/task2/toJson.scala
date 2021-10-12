package com.itea.task2

import com.itea

sealed trait Json {

  def getOrElse(empty: Any): String = this match {
    case JsonNumeric(value) => "(Numeric) " + value
    case JsonString(value) if value!=null => "(String) \"" + value + "\""
    case JsonBoolean(value) if value!=null => "(Boolean) " + value
    case JsonArray(values)  if values!=null => "(Array) [" + values.mkString(", ") + "]"
    case JsonObject(value)  => "(Object) " + value
    case None               => empty.toString
    case _                  => null
  }
}

case object None extends Json
case class JsonNumeric(value: Integer = 0) extends Json
case class JsonString(value: String = null) extends Json
case class JsonBoolean(value: Boolean = false) extends Json
case class JsonArray(values: Array[Any] = null) extends Json
case class JsonObject(value: AnyRef = null) extends Json

object ToJsonApp extends App {
  println( None.getOrElse(None) )                      // None
  println( JsonNumeric(100).getOrElse(None) )          // (Numeric) 100
  println( JsonNumeric().getOrElse(None) )             // 0
  println( JsonString("Hello").getOrElse(None) )       // (String) Hello
  println( JsonString().getOrElse(None) )              // null
  println( JsonBoolean(true).getOrElse(None) )         // (Boolean) true
  println( JsonBoolean().getOrElse(None) )             // (Boolean) false
  println( JsonArray(Array(1, 2, 3)).getOrElse(None) ) // (Array) [1, 2, 3]
  println( JsonArray().getOrElse(None) )               // null
  println( JsonObject(Tmp(1)).getOrElse(None) )        // (Object) Tmp(1)
  println( JsonObject().getOrElse(None) )              // (Object) null
}

private case class Tmp(id: Int)