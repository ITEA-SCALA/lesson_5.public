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

object MaybeMain extends App {
//  val maybeInt: Maybe[Int] = None
  val maybeInt: Maybe = None // None
//  println(maybeInt)
  println( "Maybe = " + maybeInt.getOrElse(0) ) // Maybe = 0

  val maybeInt2: Maybe = SomeInt(100)
  println( "Maybe(2) = " + maybeInt2.getOrElse(0) ) // Maybe(2) = 100
}