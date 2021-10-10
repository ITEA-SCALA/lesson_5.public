package com.itea.task1

// Optional
// Option

//sealed trait Maybe[+T] {
sealed trait Maybe {

//  def getOrElse[A >: T](empty: A): T = this match {
  def getOrElse(empty: Int): Int = this match {
    case SomeInt(value) => value
    case None           => empty
  }

}

//case object None extends Maybe[Nothing]
//case class Some[T](value: T) extends Maybe[T]
case object None extends Maybe //TODO: use Maybe as Option in Scala
case class SomeInt(value: Int) extends Maybe //TODO: use Maybe as Option in Scala

object Main extends App {
//  val maybeInt: Maybe[Int] = None
  val maybeInt: Maybe = None
}