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
    static List<List> traverses = new ArrayList();

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
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.right = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.left.left = new Node(8);
        root.right.right = new Node(7);
        root.right.right.right = new Node(9);

        print(root);
    }

    static void print(Node root) {
        getTraverse(root, new ArrayList());
//        System.out.println(traverses);

        List<List> allTraversePrint = new ArrayList<>();

        for (int iTraversePrint = 0; iTraversePrint < 10; iTraversePrint++) {
            List traversePrint = new ArrayList<>();
            for (List arr: traverses) {
                try {
                    int valuePrint = (int) arr.get(iTraversePrint);
                    if (!traversePrint.contains(valuePrint)) traversePrint.add(valuePrint);
                } catch (Exception e) {}
            }
            if (!traversePrint.isEmpty()) allTraversePrint.add(traversePrint);
        }

        for (List arr: allTraversePrint) System.out.println(arr);
    }

    /*
      Рекурсивная функция для поиска путей от корневого узла до каждого листового узла
        [1, 2, 4]
        [1, 2, 5]
        [1, 3, 6, 8]
        [1, 3, 7, 9]
     */
    static void getTraverse(Node node, List path) {
        if (node == null) return; // base case

        path.add(node.data); // включить текущий узел в путь
        if (node.left == null && node.right == null) traverses.add( Arrays.asList(path.toArray()) ); //TODO: если листовой узел найден, вывести путь

        getTraverse(node.left, path); // base case
        getTraverse(node.right, path); // base case

        path.remove( path.size()-1 ); // backtrack: удалить текущий узел после левого и правого поддерева.
    }
}
