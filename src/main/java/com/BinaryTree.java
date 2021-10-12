package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Программа на Java для обхода двоичного дерева
 * Применяется обход по порядку и печать всех узлов в отсортированном порядке
          1
        /   \
       /     \
      2       3
     / \     / \
    4   5   6   7
           /     \
          8       9
*/
class BinaryTree {

    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        root.right.left.left = new Node(8);
        root.right.right.right = new Node(9);

//        System.out.println(root); // {'1', L={'2', L={'4'}, B={'5'}}, B={'3', L={'6', L={'8'}}, B={'7', B={'9'}}}}
        root.prettyPrint();
    }
}

class Node {
    public int value;
    public Node left;
    public Node right;
    private List<List> nodeTree = new ArrayList();

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "{" +
                "'" + value + "'" +
                (left!=null ? ", L="+left : "") +
                (right!=null ? ", B="+right : "") +
                '}';
    }

    void prettyPrint() {
        int maxDepthNodeTree = 10;
        prettyPrint(this, new ArrayList());
        List<List> prettyTree = new ArrayList<>();

        for (int depthNodeTree = 0; depthNodeTree < maxDepthNodeTree; depthNodeTree++) {
            List prettyPath = new ArrayList<>();
            for (List path: nodeTree) {
                try {
                    int value = (int) path.get(depthNodeTree);
                    if (!prettyPath.contains(value)) prettyPath.add(value);
                } catch (Exception e) {}
            }
            if (!prettyPath.isEmpty()) prettyTree.add(prettyPath);
        }

        for (List arr: prettyTree) System.out.println(arr);
    }

    void prettyPrint(Node node, List path) {
        if (node == null) return; // base case

        path.add(node.value); //TODO: добавить текущий узел в путь
        if (node.left == null && node.right == null) nodeTree.add( Arrays.asList(path.toArray()) ); //TODO: если листовой узел найден тогда вывести путь

        prettyPrint(node.left, path); // base case
        prettyPrint(node.right, path); // base case

        path.remove( path.size()-1 ); //TODO: удалить текущий узел после левого и правого поддерева.
    }
}
