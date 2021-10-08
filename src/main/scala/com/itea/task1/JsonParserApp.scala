package com.itea.task1

object JsonParserApp extends App {

  case class SomeClass(aa: Int, bb: Boolean, cc: Char, ss: String)

  val clazz = SomeClass(123, true, 'i', "abc")

  var iteratorClazz = clazz.productElementNames
  var indexElement: Int = 0

  print(clazz.getClass.getSimpleName + ": {")
  while (iteratorClazz.hasNext) {
    val nameElement: String = iteratorClazz.next()
    val valueElement: Any = clazz.productElement(indexElement)
    print( elementToJson(nameElement, valueElement, indexElement) )
    indexElement += 1
  }
  print("\n}")


  def elementToJson(nameElement: String, valueElement: Any, indexElement: Int): String = {
    var str: String = "\n  \"" + nameElement + "\": " + valueToJson(valueElement)
    if (indexElement != 0) str = "," + str
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
