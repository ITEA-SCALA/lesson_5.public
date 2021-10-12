package com.itea.task2

import com.itea

sealed trait Json {

  def getOrElse(empty: Any): String = this match {
    case JsonNumeric(key, value) => "(Numeric) " + key + ":" + value
    case JsonString(key, value) if value!=null => "(String) \"" + key + ":" + value + "\""
    case JsonBoolean(key, value) if value!=null => "(Boolean) " + key + ":" + value
    case JsonArray(key, values)  if values!=null => "(Array) " + key + ":" + "[" + values.mkString(", ") + "]"
    case JsonObject(key, value)  if value!=null => "(Object) " + key + ":{" + value + "}"
    case None               => empty.toString
//    case _                  => null
    case _                  => empty.toString
  }
}

case object None extends Json
case class JsonNumeric(key: String, value: Integer = 0) extends Json
case class JsonString(key: String, value: String = null) extends Json
case class JsonBoolean(key: String, value: Boolean = false) extends Json
case class JsonArray(key: String, values: Array[Any] = null) extends Json
case class JsonObject(key: String, value: AnyRef = null) extends Json

object ToJsonApp extends App {
  println( None.getOrElse(None) )                              // None
  println( JsonNumeric("num", 123).getOrElse(None) )           // (Numeric) num:123
  println( JsonNumeric("num").getOrElse(None) )                // (Numeric) num:0
  println( JsonString("str", "Hello").getOrElse(None) )        // (String) "str:Hello"
  println( JsonString("str").getOrElse(None) )                 // None
  println( JsonBoolean("bool", true).getOrElse(None) )         // (Boolean) bool:true
  println( JsonBoolean("bool").getOrElse(None) )               // (Boolean) bool:false
  println( JsonArray("args", Array(1, 2, 3)).getOrElse(None) ) // (Array) args:[1, 2, 3]
  println( JsonArray("array").getOrElse(None) )                // None
  println( JsonObject("tmp", new Tmp(1)).getOrElse(None) ) // (Object) tmp:{id:1}
  println( JsonObject("tmp").getOrElse(None) )                 // None
}

private class Tmp(id: Int) {
  override def toString: String = s"id:$id"
}