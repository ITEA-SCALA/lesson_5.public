package com.itea.task1.list0

sealed trait IntList {
  def add(v: Int): Unit = this match {
    case Nil => Node(v, Nil)
    case n @ Node(_,_) => Node(v, n)
  }
}

case object Nil extends IntList {
  override val toString: String = "NIL"
}

case class Node(value: Int, next: IntList) extends IntList {
  override val toString: String = s"$next $value" // NIL 3 2 1
}

object IntListMain extends App {
  val list = Node(1, Node(2, Node(3, Nil)))
  println( list )

}