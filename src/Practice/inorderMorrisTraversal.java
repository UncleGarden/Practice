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
public class inorderMorrisTraversal {

    /**
     * left - root - right
     *
     * Morris Traversal - link the nodes like circles, then fix the tree model.
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(MorrisTreeNode root) {
        //res to store the nodes
        ArrayList<Integer> res = new ArrayList<Integer>();
        //current node
        MorrisTreeNode current = root;
        //prev node
        MorrisTreeNode prev = null;

        //if current is not null
        while (current != null) {
            //if the left tree is null
            if (current.getLeft() == null) {
                //if left is null, add the root and move current to the right 
                res.add(current.getVal());
                //move to the right
                current = current.getRight();
            } //if the left tree is not null, find the **processor node**
            else {
                //because inorder, point prev to the left root
                prev = current.getLeft();
                //find the prev node for the current node
                while (prev.getRight() != null && prev.getRight() != current) {
                    prev = prev.getRight();
                }
                //if prev's right child is null
                if (prev.getRight() == null) {
                    //link the prev and current, prev is the processor of current
                    prev.setRight(current);
                    //move the current to the left child
                    current = current.getLeft();
                } //if prev's right child is not null, means that prev's right is the current node
                else {
                    //fix the tree model
                    prev.setRight(null);
                    //add into the list
                    res.add(current.getVal());
                    //move to the right tree of current node
                    current = current.getRight();
                }
            }
        }
        return res;
    }
}
