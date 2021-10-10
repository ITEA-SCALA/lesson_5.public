package com.itea.task1

object App {
  List(1, 2, 3,4)

  def sort(l: List[Int]): List[Int] = l match {
    case h :: t => t
  }
}

//sealed trait List {
//
//  def ::(that: Int): List = this match {
//    case List.Nil => List.::(that, List.Nil)
//    case l @ _ => List.::(that, List.Nil)
//  }
//
//}
//
//object List {
//  case object Nil extends List
//  case class ::(value: Int, next: List) extends List
//}
//
//object App {
//  1 :: Nil //TODO:  смысл был в том чтобы получить вот такую запись. Это классическая запись листа
//}