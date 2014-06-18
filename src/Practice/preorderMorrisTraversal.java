/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

import Model.MorrisTreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jiateng
 */
public class preorderMorrisTraversal {

    public List<Integer> preorderTraversal(MorrisTreeNode root) {

        ArrayList<Integer> res = new ArrayList<Integer>();
        MorrisTreeNode current = root;
        MorrisTreeNode prev = null;

        while (current != null) {
            if (current.getLeft() == null) {

                res.add(current.getVal());
                //System.out.println(current.getVal());
                current = current.getRight();
            } else {
                prev = current.getLeft();

                while (prev.getRight() != null && prev.getRight() != current) {
                    prev = prev.getRight();
                }

                if (prev.getRight() == null) {
                    res.add(current.getVal());
                    //System.out.println(current.getVal());

                    prev.setRight(current);
                    current = current.getLeft();
                } else {
                    prev.setRight(null);
                    current = current.getRight();
                }
            }
        }
        return res;
    }
}
