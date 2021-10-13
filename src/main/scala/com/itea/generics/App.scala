package com.itea.generics

//object App extends App {
//
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

//  sealed trait Option[+T] {
//
////    def getOrElse(default: T): T = this match {
////      case Some(value) => value
////      case None => default
////    }
//
//    def isEmpty: Boolean = this match {
//      case Some(value) => false
//      case _ => true
//    }
//
//    def filter(func: T => Boolean): Option[T] = this match {
//      case n @ None => n
////      case Some(value: T) => if (0<value) Some(value) else None
//      case Some(value: T) => if (func) Some(value) else None
//    }
//
//  }
//
//  case object None extends Option[Nothing]
//  case class Some[T](value: T) extends Option[T]


import scala.{Option => SOption}
import scala.{None => SNone}

sealed trait Option[+T] {

  def isEmpty: Boolean = this match {
    case None => true
    case _    => false
  }

//  def getOrElse(default: T): T = this match {
//    case Some(value) => value
//    case None => default
//  }

  def filter(func: T => Boolean): Option[T] = this match { //TODO: (func: T => Boolean) это объявление анонимной функции
//    case n @ None => n
//    case Some(v) => ???
    case Some(v) if func(v) => this
    case _ => None
  }

}

  case object None extends Option[Nothing]
  case class Some[T](value: T) extends Option[T]

object Application extends App {

  val tryThis = Some(3)   // Some(3)
//  val tryThis = Some(6) // None
  println( tryThis.filter(i => i < 5) ) //TODO: (i => i < 5) это реализация анонимной функции, где в левой части (перед знаком '=>') - значение, а в правой части (после знака '=>') - выражение

}
