package com.itea.task1

case class SomeClass(aa: Int, bb: Boolean, cc: Char, ss: String)

object JsonParserApp extends App {

  print(
    toJson(SomeClass(123, true, 'i', "abc")) )

  /**
   * @param clazz
   * @return
   */
  def toJson(clazz: SomeClass): String = { // TODO: need as AnyRef param
    val iteratorClazz = clazz.productElementNames

    var indexElement: Int = 0
    var json: String = clazz.getClass.getSimpleName + ": {"
    while (iteratorClazz.hasNext) {
      json = json + elementToJson(iteratorClazz.next(), clazz.productElement(indexElement), indexElement)
      indexElement += 1
    }
    json = json + "\n}"
    json
  }

  private def elementToJson(nameElement: String, valueElement: Any, indexElement: Int): String = {
    var str: String = "\n  \"" + nameElement + "\": " + valueToJson(valueElement)
    if (indexElement != 0) str = "," + str
    str
  }

  private def valueToJson(valueElement: Any): String = valueElement.getClass.getName match {
    case "java.lang.Integer" => s"""$valueElement"""
    case "java.lang.Boolean" => s"""$valueElement"""
    case "java.lang.Character" => s"""\"$valueElement\""""
    case "java.lang.String" => s"""\"$valueElement\""""
    case _ => "???"
  }
}
