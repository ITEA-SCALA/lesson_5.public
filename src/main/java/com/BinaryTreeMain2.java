package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @see https://www.techiedelight.com/print-all-paths-from-root-to-leaf-nodes-binary-tree/
 *
          1
        /   \
       /     \
      2       3
     / \     / \
    4   5   6   7
           /     \
          8       9
*/
class BinaryTreeMain2 {

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

        System.out.println(root);
        root.print();
    }
}

class Node {
    public int data;
    public Node left;
    public Node right;
    private List<List> traverses = new ArrayList();

    public Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" +
                "'" + data + "'" +
                (left!=null ? ", L="+left : "") +
                (right!=null ? ", B="+right : "") +
                '}';
    }

    void print() {
        int branchDepth = 10;
        print(this, new ArrayList());
        List<List> allTraversePrint = new ArrayList<>();

        for (int iTraversePrint = 0; iTraversePrint < branchDepth; iTraversePrint++) {
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

    void print(Node node, List path) {
        if (node == null) return; // base case

        path.add(node.data); // включить текущий узел в путь
        if (node.left == null && node.right == null) traverses.add( Arrays.asList(path.toArray()) ); //TODO: если листовой узел найден, вывести путь

        print(node.left, path); // base case
        print(node.right, path); // base case

        path.remove( path.size()-1 ); // backtrack: удалить текущий узел после левого и правого поддерева.
    }
}
