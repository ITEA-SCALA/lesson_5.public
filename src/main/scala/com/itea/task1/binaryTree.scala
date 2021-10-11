package com.itea.task1

/**
 * Как двоичное дерево может выглядеть в Scala
 */
sealed trait BinaryTree {

//  def print(): Unit = println( "." ) //TODO:  Д.З. дописать...

  def getOrElse() = this match {
    case b: Branch => {
      print("b=")
      b
    }
    case l: Leaf => {
      print("l=")
      l
    }
  }
}

case class Leaf(v: Int) extends BinaryTree { //TODO:  последний элемент (все значения будут в листках)
  override def toString: String = {
    s"'$v'"
  }
}
case class Branch(left: BinaryTree, right: BinaryTree) extends BinaryTree { //
  override def toString: String = {
    s"$right $left"
  }
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

  //
//  println( binaryTree ) // '3' '4' '5'
//
//  println( leaf4.getOrElse() ) // l='4'
//  println( leaf5.getOrElse() ) // l='5'
//  println( leaf3.getOrElse() ) // l='3'
//  println( binaryTree.getOrElse() ) // b='3' '4' '5'

  //
  println( binaryTree ) // '3' '4' '5'

  val binaryTreeLeft = binaryTree.left
  println( binaryTreeLeft ) // '4' '5'
//  val l1 = binaryTreeLeft.getOrElse()
//  println( l1 )
//  val l2 = l1.getOrElse()
//  println( l2 )

//  println( binaryTreeLeft.getOrElse().getOrElse().getOrElse() ) // b=b=b='4' '5'

  val binaryTreeRight = binaryTree.right
  println( binaryTreeRight ) // '3'
//  println( binaryTreeRight.getOrElse() )
}
