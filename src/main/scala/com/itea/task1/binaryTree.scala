package com.itea.task1

/**
 * КАк двоичное дерево может выглядеть в Scala
 */
sealed trait BinaryTree {

  def print(): Unit = println() //TODO:  Д.З. дописать...
}

case class Leaf(v: Int) extends BinaryTree //TODO:  последний элемент (все значения будут в листках)
case class Branch(left: BinaryTree, right: BinaryTree) extends BinaryTree //

object BinaryTreeApp extends App {

  /*
          /\
         /| 3
        5 4
   */

  Branch( Branch(Left(5), Left(4)), Left(3)).print()
}
