package com.itea

/**
 * Экземпляр Either - это экземпляр Left или Right (представляет значение одного из двух возможных типов).
 * Обычно Either - это альтернатива Option для работы с возможно пропущенными значениями.
 * ***
 * Соглашение гласит, что:
 * - 'Left' используется для неудач
 * - 'Right' - для успеха
 *
 * В этом случае None заменяется на Left, которое может содержать полезную информацию.
 * А Right занимает место полезного-значения.
 *
 *
 */

//trait Either[L, R] {
//
//}
//
//case class Left[L, R](v: L) extends Either[L, R]
//case class Right[L, R](v: R) extends Either[L, R]

object EitherApp extends App {

  // # 1.
  val a = 3 // '3' is Left(404)
  //  val a = 6 // '6' is Right(This is good)
  val valid: Either[Int, String] = //TODO:  левая часть - это ошибка; а правая часть - это все хорошо;
    if (5 < a) Right("This is good")
    else Left(404)
  println(s"'${a}' is " + valid)

  // # 2.
  sealed trait DomainError

  case class DbError(err: String) extends DomainError

  case class HttpError(err: String, httpCode: String) extends DomainError

  case class User(id: Int, name: String)

  //  val emptyNameUser = User(1, "") // Left(DbError(DB error non empty!))
  val emptyNameUser = User(1, "XXX") // Right(User(1,XXX))
  val validUser: Either[DomainError, User] =
    if (emptyNameUser.name.isEmpty) Left(DbError("DB error non empty!"))
    else Right(emptyNameUser)
  println(validUser)

  // # 3.
  val emptyNameUser2 = User(2, "") // #2-left: DbError(DB error non empty!)
  //  val emptyNameUser2 = User(2, "User-2") // #2     : User(2,User-2)
  // три параметра принимается
  val validUser2 = Either.cond(!emptyNameUser2.name.isEmpty, //TODO: условие
    emptyNameUser2, //TODO: если все хорошо
    DbError("DB error non empty!")) //TODO: и если все плохо
  println("#2-left: " + validUser2.left.getOrElse())
  println("#2     : " + validUser2.getOrElse())

  //  valid.map()
  //  valid.flatMap()
}
