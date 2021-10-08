package com.itea

/**
 * @see https://coderoad.ru/43214393/Как-получить-список-полей-и-подполей-класса-Scala-case
 *      https://coderoad.ru/48882455/Scala-отражение-для-получения-типов-всех-полей-объекта
 */
object ClassToJson extends App {

  case class SomeClass(aa: Int, bb: Boolean, cc: Char, ss: String)
  val clazz = SomeClass(123, true, 'i', "abc")

  // ///
  var iteratorClazz = clazz.productElementNames
  var countElement: Int = 0

//  while (iteratorClazz.hasNext) {
//    val nameElement: String = iteratorClazz.next()
//    val valueElement: Any = clazz.productElement(countElement)
//    println("name='" + nameElement + "' type='" + productElementType(valueElement) + "' index(" + countElement + ")")
//    countElement += 1
//  }


  // ///
  iteratorClazz = clazz.productElementNames
  countElement = 0

  print( clazz.getClass.getSimpleName + ": {")
  while (iteratorClazz.hasNext) {
    val nameElement: String = iteratorClazz.next()
    val valueElement: Any = clazz.productElement(countElement)
    print( elementToJson(nameElement, valueElement, countElement) )
    countElement += 1
  }
  print("\n}")


  // ///

//  def productElementType(value: Any): String = {
//    var toType: String = "???"
//    if (value.isInstanceOf[Int]) toType = "Int"
//    if (value.isInstanceOf[Boolean]) toType = "Boolean"
//    if (value.isInstanceOf[Char]) toType = "Char"
//    toType
//  }

  def productElementType(value: Any): String = value.getClass.getName match {
    case "java.lang.Integer" => "Int"
    case "java.lang.Boolean" => "Boolean"
    case "java.lang.Character" => "Char"
    case "java.lang.String" => "String"
    case _ => "???"
  }

  def elementToJson(nameElement: String, valueElement: Any, countElement: Int): String = {
    var str: String = "\n  \"" + nameElement + "\": " + valueToJson(valueElement)
    if ( countElement!=0 ) str = "," + str
    str
  }

  def valueToJson(valueElement: Any): String = valueElement.getClass.getName match {
    case "java.lang.Integer" => s"""$valueElement"""
    case "java.lang.Boolean" => s"""$valueElement"""
    case "java.lang.Character" => s"""\"$valueElement\""""
    case "java.lang.String" => s"""\"$valueElement\""""
    case _ => "???"
  }
}
