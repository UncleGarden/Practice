/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Garden
 */
public class LowestCommonAcestor {

    public static void main(String[] args) {
        File file = new File("C:\\Users\\Jiateng\\Desktop\\test.txt");
        //File file = new File(args[0]);
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException fnfe) {
            System.err.println("Exception:" + fnfe);
        }
        String line;
        Node ten = new Node(10);
        Node tn = new Node(29);
        Node t = new Node(20);
        Node three = new Node(3);
        Node eight = new Node(8);
        Node ft = new Node(52);
        Node tht = new Node(30);

        tht._left = eight;
        tht._right = ft;
        eight._left = three;
        eight._right = t;
        t._left = ten;
        t._right = tn;

        try {
            while ((line = in.readLine()) != null) {

                if (line.isEmpty()) {
                    continue;
                }

                String[] array = line.split("\\s+");
                int x = Integer.valueOf(array[0]);
                int y = Integer.valueOf(array[1]);

                System.out.println(findLowestCommonAncestor(tht, x, y));

            }
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
        }
    }

    public static int findLowestCommonAncestor(Node n, int x, int y) {

        int lower = Math.min(x, y);
        int higher = Math.max(x, y);

        int value = n.getValue();

        //start with the biggest node, if one of the nodes is the root, return.
        if (lower == value) {
            return value;
        }
        if (higher == value) {
            return value;
        }

        //the lower and higher are the left and right. return value.
        if (lower < value && higher > value) {
            return value;
        }

        //left node
        if (lower < value && higher < value) {
            if (n.getLeft() != null) {
                return findLowestCommonAncestor(n.getLeft(), x, y);
            } else {
                return value;
            }
        }

        //right node
        if (lower > value && higher > value) {
            if (n.getRight() != null) {
                return findLowestCommonAncestor(n.getRight(), x, y);
            } else {
                return value;
            }
        }

        return value;
    }

    private static class Node {

        private int _value;

        private Node _left = null;
        private Node _right = null;

        public Node(int value) {
            _value = value;
        }

        public int getValue() {
            return _value;
        }

        public Node getLeft() {
            return _left;
        }

        public Node getRight() {
            return _right;
        }
    }
}
