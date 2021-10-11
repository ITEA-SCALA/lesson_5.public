package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @see https://www.techiedelight.com/print-all-paths-from-root-to-leaf-nodes-binary-tree/
 */
// A class to store a binary tree node
class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int data) {
        this.data = data;
    }
}

class BinaryTreeMain2 {

    public static void main(String[] args) {
/*
          1
        /   \
       /     \
      2       3
     / \     / \
    4   5   6   7
           /     \
          8       9
*/
        Node root = new Node(1);
/*
[1, 2, 4]
[1, 2, 5]
[1, 3, 6, 8]
[1, 3, 7, 9]
 */
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.right = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.left.left = new Node(8);
        root.right.right = new Node(7);
        root.right.right.right = new Node(9);

        // print all root-to-leaf paths
        printRootToleafPaths(root);
    }

    static List<List> traverses = new ArrayList();

    // Основная функция для печати путей от корневого узла до каждого листового узла
    public static void printRootToleafPaths(Node node) {
        printRootToleafPaths(node, new ArrayList()); // list to store root-to-leaf path
        System.out.println(traverses);


        List<List> arrTraversePrint = new ArrayList<>();
        for (int iArrTraversePrint=0; iArrTraversePrint<4; iArrTraversePrint++) {
            List traversePrint = new ArrayList<>();
            for (List arr: traverses) {
                try {
                    int objTraverse = (int) arr.get(iArrTraversePrint);
                    if (!traversePrint.contains(objTraverse)) traversePrint.add(objTraverse);
                } catch (Exception e) {}
            }
            arrTraversePrint.add(traversePrint);
        }

        for (List arr: arrTraversePrint) System.out.println(arr);
    }

    // Рекурсивная функция для поиска путей от корневого узла до каждого листового узла
    public static void printRootToleafPaths(Node node, List path) { //public static void printRootToleafPaths(Node node, Deque<Integer> path) {
        if (node == null) return; // base case

        path.add(node.data); // включить текущий узел в путь
        if (isLeaf(node)) {
            traverses.add(Arrays.asList(path.toArray())); //TODO: если листовой узел найден, вывести путь

        }

        // recur for the left and right subtree
        printRootToleafPaths(node.left, path);
        printRootToleafPaths(node.right, path);

        // backtrack: удалить текущий узел после левого и правого поддерева.
        path.remove(path.size()-1);
    }

    // Функция для проверки, является ли данный узел листовым узлом или нет
    public static boolean isLeaf(Node node) {
        return (node.left == null && node.right == null);
    }
}
