package com.itea.generics

object App extends App {

//  sealed trait Json[T] {
//    def getOrElse(empty: T): String = this match {
//      case JsonString(value) if value != null => "(String) \"" + value + "\""
//      case JsonNum(value) if value != null => "(Num) " + value
//      case _                       => null
//    }
//  }
//
////  case object None extends Json[T]
//  case class JsonString[T](value: String) extends Json[T]
//  case class JsonNum[T](value: Int) extends Json[T]
////
//  println( JsonString("null").getOrElse(None) )
////  println( JsonString(null).getOrElse(None) )
////
//  println( JsonNum(123).getOrElse(None) )
//////  println( JsonNum(null).getOrElse(None) )

  sealed trait Option[+T] {

//    def getOrElse(default: T): T = this match {
//      case Some(value) => value
//      case None => default
//    }

    def isEmpty: Boolean = this match {
      case Some(value) => false
      case _ => true
    }

    def filter(func: T => Boolean): Option[T] = this match {
      case n @ None => n
//      case Some(value: T) => if (0<value) Some(value) else None
      case Some(value: T) => if (func) Some(value) else None
    }

  }

  case object None extends Option[Nothing]
  case class Some[T](value: T) extends Option[T]




}
