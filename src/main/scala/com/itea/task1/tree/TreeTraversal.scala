package com.itea.task1.tree

/**
 * Обход BFS и DFS дерева
 * ***
 * @see https://codereview.stackexchange.com/questions/62844/bfs-and-dfs-tree-traversal
 *      https://codereview.stackexchange.com/questions/62744/bfs-tree-traversal-scala
 */

import scala.+:
import scala.annotation.tailrec

object TreeTraversal extends App {

  case class Node[+T](value: T, left: Option[Node[T]], right: Option[Node[T]]) {
//    def map[V](f: T => V): Node[V] = Node(f(value), left.map(l => l.map(f)), right.map(r => r.map(f)))
//    def childrenLeftRight: List[Node[T]] = List(left, right).flatten
  }

  def terminalNode[T](value: T) = Node(value, None, None)

//  def dfs[T](tree: Node[T]): List[T] = {
//    var output = List[T]()
//    tree.map(t => (output = t :: output))
//    output.reverse
//  }
//
//  def bfs[T](tree: Node[T]): List[T] = {
//    @tailrec
//    def bfsLoop(accum: List[List[T]], nextLayer: List[Node[T]]): List[T] = nextLayer match {
//      case Nil => accum.reverse.flatten
//      case _ => bfsLoop(nextLayer.map(_.value) :: accum, nextLayer.flatMap(_.childrenLeftRight))
//    }
//    bfsLoop(List[List[T]](), List(tree))
//  }

  // Node(6,
  //      Some(
  //           Node(13,
  //                Some(
  //                     Node(101,
  //                          None,None)
  //                     ),None)
  //                ),
  //                Some(
  //                     Node(42,
  //                          Some(
  //                               Node(666,
  //                                    None,None)
  //                              ),
  //                          Some(
  //                               Node(65,
  //                                    None,None)
  //                              )
  //                          )
  //           )
  //     )
  val tree1 = Node[Int](6, Some(Node(13, Some(terminalNode(101)), None)), Some(Node(42, Some(terminalNode(666)), Some(terminalNode(65)))))
//  println("map: " + tree1.map(i => s"Hello-$i"))
//  println("dfs: " + dfs(tree1))
//  println("bfs: " + bfs(tree1))

  println( tree1 )
  //
  def print1[T](node: Node[T], path: List[T] = List(), str: String = "?"): Unit = {
    if (node == null) ()
    else {
      path.::(node.value)
      println(str + "-" + node.value)
      traverses.::(1)
    }
    if (node.left.nonEmpty) print1(node.left.get, path, "L")
    if (node.right.nonEmpty) print1(node.right.get, path, "R")
    path.dropRight(1)
  }

//  val traverses: List[Int] = List()
  val traverses: List[Int] = List(11, 22, 33)
//  traverses.::(1)
  traverses ++ List(2)
//  traverses.::(3)

  println( traverses )
  println( "size=" + traverses.size ) // size=3
  println( "last=" + traverses.last ) // last=33
  println( "length=" + traverses.length ) // length=3

  print1(tree1)

//  traverses.foreach( print(_) )
}
