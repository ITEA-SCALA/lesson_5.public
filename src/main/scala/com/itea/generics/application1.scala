package com.itea.generics

/**
 * @see http://aperiodic.net/phil/scala/s-99/
 */
object Application1 extends App {

  // P01 (*) Find the last element of a list.

  val list: List[Int] = List(1, 1, 2, 3, 5, 8)
//  println( list )

  println( "list.last = " + list.last ) // 8

  def last(list: List[Int], lastIndex: Int => Int): Int = {
    val index = lastIndex( list.length )
    list( index )
  }
  println( last(list, i => i-1) ) // 8

  def lastRecursive[T](ls: List[T]): T = ls match {
    case h :: Nil => h              //TODO: а в случае когда дошли до крайнего элемента 'Nil', тогда в этом случае возвращаем его предшественника
    case _ :: t => lastRecursive(t) //TODO: в case получаем какой то список '_'  дальше вызываем метод next '::' следующий элемент списка...  sound because `next` is used only locally
  }

  println( "lastRecursive = " + lastRecursive(list) )

}

