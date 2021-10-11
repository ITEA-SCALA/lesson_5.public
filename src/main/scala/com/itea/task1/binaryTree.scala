package com.itea.task1

/**
 * Как двоичное дерево может выглядеть в Scala
 */
sealed trait BinaryTree {

  def print(): Unit = println( "." ) //TODO:  Д.З. дописать...
}

case class Leaf(v: Int) extends BinaryTree { //TODO:  последний элемент (все значения будут в листках)
  override def toString: String = s"$v"
}
case class Branch(left: BinaryTree, right: BinaryTree) extends BinaryTree { //
  override def toString: String = s"$right $left"
}

object BinaryTreeApp extends App {

  /*
          /\
         /| 3
        5 4
   */

//  Branch( Branch(Left(5), Left(4)), Left(3)).print()
  val leaf4: Leaf = Leaf(4)
  val leaf5: Leaf = Leaf(5)

  val branch: Branch = Branch(leaf5, leaf4)
  val leaf3: Leaf = Leaf(3)
  val binaryTree: Branch = Branch(branch, leaf3)

  println( binaryTree )
  binaryTree.print()
}
