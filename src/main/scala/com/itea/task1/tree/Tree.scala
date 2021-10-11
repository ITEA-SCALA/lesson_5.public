//package com.itea.task1.tree
//
///**
// * @see https://hernandigiorgi.com/create-a-functor-for-a-binary-tree-in-scala/
// *      http://aperiodic.net/phil/scala/s-99/
// */
//sealed trait Tree[+A] {
//  def map[A, B](tree: Tree[A])(func: A => B): Tree[B] = {
//    tree match {
//      case Branch(left, right) =>
//        Branch(map(left)(func),  map(right)(func))
//      case Leaf(value) =>
//        Leaf(func(value))
//    }
//  }
//}
//final case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]
//final case class Leaf[A](values: A) extends Tree[A]
//
//  object TreeApp extends App {
//    val l1: Leaf[Int] = Leaf(1)
//    val l2: Leaf[Int] = Leaf(2)
//    val l3: Leaf[Int] = Leaf(3)
//    val b1: Branch[Int] = Branch(l1, l2)
//    val b2: Branch[Int] = Branch(b1, l3)
//
////    println(b2)
//
//  }
