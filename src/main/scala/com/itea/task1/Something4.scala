package com.itea.task1

case class Something4(
   str: String, // Infinity
   number: Int, // 2147483647 => Infinity
)

// Functional Programming
//TODO => Product

// Algebraic Data Types
// Property Based Testing <-
sealed trait User2
case object Anonymous extends User2
case object LoggedUser extends User2
case object Admin extends User2
case class Client(id: Int) extends User2