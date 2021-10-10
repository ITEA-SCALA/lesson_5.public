package com.itea.task1

/**
 * @see https://www.crockford.com/mckeeman.html
 *
 * TODO:  Д.З.
 * value
 * object
 * array
 * string
 * number
 * "true"
 * "false"
 * "null"
 *
 * @see https://github.com/playframework/play-json
 * #JSON AST
 * JsObject: a JSON object, represented as a Map. Can be constructed from an ordered Seq or any kind of Map using JsObject.apply
 * JsArray: a JSON array, consisting of a Seq[JsValue]
 * JsNumber: a JSON number, represented as a BigDecimal.
 * JsString: a JSON string.
 * JsBoolean: a JSON boolean, either JsTrue or JsFalse.
 * JsNull: the JSON null value.
 *
 */
sealed trait Json {

  def print(): Unit = ???
  // { "a" : "super" }
}

val json = JsNode("blabla", JsString(""))

case object JsNull extends Json
// strings, numbers, booleans, objects, array