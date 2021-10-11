package com.itea.task1

/**
 * @see https://circe.github.io/circe/
 *      ***
 * import io.circe._, io.circe.generic.auto._, io.circe.parser._, io.circe.syntax._
 *
 * sealed trait Foo
 * case class Bar(xs: Vector[String]) extends Foo
 * case class Qux(i: Int, d: Option[Double]) extends Foo
 *
 * val foo: Foo = Qux(13, Some(14.0))
 *
 * val json = foo.asJson.noSpaces
 * println(json)
 *
 * @see https://circe.github.io/circe/codec.html
 * import io.circe.parser.decode
 * decode[List[Int]]("[1, 2, 3]")
 * // res1: Either[io.circe.Error, List[Int]] = Right(value = List(1, 2, 3))
 *
 */

//trait Either[L, R] {
//
//}
//
//case class Left[L, R](v: L) extends Either[L, R]
//case class Right[L, R](v: R) extends Either[L, R]

object EitherApp extends App {

  val a = 3 // '3' is Left(404)
//  val a = 6 // '6' is Right(This is good)
  val valid: Either[Int, String] = //TODO:  левая часть - это ошибка; а правая часть - это все хорошо;
    if (5 < a) Right("This is good")
    else Left(404)
  println( s"'${a}' is " + valid)

  sealed trait DomainError
  case class DbError(err: String) extends DomainError
  case class HttpError(err: String, httpCode: String) extends DomainError

  case class User(id: Int, name: String)
  val emptyNameUser = User(1, "")
  val validUser: Either[DomainError, User] =
    if (emptyNameUser.name.isEmpty) Left(DbError("DB error non empty!"))
    else Right(emptyNameUser)

  // три параметра принимается
  Either.cond(
    emptyNameUser.name.isEmpty, //TODO: условие
    emptyNameUser, //TODO: если все хорошо
    DbError("DB error non empty!")) //TODO: и если все плохо

//  valid.map()
//  valid.flatMap()
}