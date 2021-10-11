//package com;
//
///**
// * @see https://www.educative.io/edpresso/how-to-print-the-nodes-of-a-binary-tree-in-sorted-order
// */
///*
// * Программа на Java для обхода двоичного дерева поиска
// * Применяется обход по порядку без рекурсии и печать всех узлов в отсортированном порядке
// * В обходе InOrder посещается первый левый узел, за которым следует корневой и правый узел
// *
// * input:
// *       0
// *      / \
// *    20   50
// *    /  \  \
// *  10   30  60
// *  /   /  \
// * 5   67  78
// *
// * output: 5 10 20 30 40 50 60 67 78
// */
//public class BinaryTreeMain1 {
//
//    public static void main(String[] args) throws Exception {
//        // построить бинарное дерево
//        BinaryTree node = new BinaryTree();
//        node.root = new BinaryTree.TreeNode("0");
//
//        // 5 10 20 67 30 78 0 50 60
////        node.root.left = new BinaryTree.TreeNode("20");
////        node.root.left.left = new BinaryTree.TreeNode("10");
////        node.root.left.left.left = new BinaryTree.TreeNode("5");
////        node.root.left.right = new BinaryTree.TreeNode("30");
////        node.root.right = new BinaryTree.TreeNode("50");
////        node.root.right.right = new BinaryTree.TreeNode("60");
////        node.root.left.right.left = new BinaryTree.TreeNode("67");
////        node.root.left.right.right = new BinaryTree.TreeNode("78");
//
//        // |5 10 20| |67 30| |78| |0| |50| |60|
//        node.root.left = new BinaryTree.TreeNode("20");
//        node.root.left.left = new BinaryTree.TreeNode("10");
//        node.root.left.left.left = new BinaryTree.TreeNode("5");
//
//        node.root.right = new BinaryTree.TreeNode("50");
//        node.root.right.right = new BinaryTree.TreeNode("60");
//
//        node.root.left.right = new BinaryTree.TreeNode("30");
//        node.root.left.right.left = new BinaryTree.TreeNode("67");
//        node.root.left.right.right = new BinaryTree.TreeNode("78");
//
//
//        // обход двоичного дерева с использованием InOrder обход с использованием рекурсии
//        // 5 10 20 67 30 78 0 50 60
////        System.out.println("printing nodes of binary tree on InOrder using recursion");    tree.print();
//        //  5 10 67 78 30 20 60 50 0
//        traversePrint(node.root);
//    }
//
//    static void traversePrint(BinaryTree.TreeNode node) {
//        traversePrint(node, ".");
//        System.out.println( strTraversePrint );
////        System.out.println( new StringBuilder(strTraversePrint).reverse() );
//    }
//    static void traversePrint(BinaryTree.TreeNode node, String test) {
//        if (node != null) {
//            traversePrint(node.left, "L");
//            traversePrint(node.right, "R");
//            strTraversePrint = strTraversePrint + " " + test + "-" + node.data;
//        }
//    }
//    static String strTraversePrint = "";
//}
//
//class BinaryTree {
//
//    static class TreeNode {
//        String data;
//        TreeNode left, right;
//
//        TreeNode(String data) {
//            this.data = data;
////            left = right = null;
//        }
//    }
//
//    // root of binary tree
//    TreeNode root;
//
//    /**
//     * traverse the binary tree in in-order traversal algorithm
//     */
////    public void print() {
////        print(root);
////    }
////
////    private void print(TreeNode node) {
////        if (node == null) {
////            return;
////        }
////
////        print(node.left);
////        System.out.printf("%s ", node.data);
////        print(node.right);
////    }
//}
