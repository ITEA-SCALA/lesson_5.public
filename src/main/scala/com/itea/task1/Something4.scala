package com.itea.task1

case class Something4(
   str: String, // Infinity
   number: Int, // 2147483647 => Infinity
)

// Functional Programming
//TODO => Product

// Algebraic Data Types
// Property Based Testing <-
sealed trait User
case object Anonymous extends User
case object LoggedUser extends User
case object Admin extends User
case class Client(id: Int) extends User