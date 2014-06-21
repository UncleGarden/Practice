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
public class postorderMorrisTraversal {

    /**
     * left - right - root
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(MorrisTreeNode root) {
        //res to store the nodes
        ArrayList<Integer> res = new ArrayList<Integer>();
        //create a dump node to be the processor of the whole tree 
        MorrisTreeNode dump = new MorrisTreeNode(0);
        //make the whole tree as the left subtree of dump
        dump.setLeft(root);

        //current node
        MorrisTreeNode current = dump;
        //prev node
        MorrisTreeNode prev = null;

        //if current is not null
        while (current != null) {
            //if the left tree is null
            if (current.getLeft() == null) {
                //current move to the right
                current = current.getRight();
            } //if the left tree is not null, find the **processor node**
            else {
                //point the prev to the left root
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
                    //change the tree, change the **right child rule** between parent-child pairs
                    reverse(current.getLeft(), prev);
                    MorrisTreeNode temp = prev;
                    //add into the list
                    while (temp != current.getLeft()) {
                        res.add(temp.getVal());
                        temp = temp.getRight();
                    }
                    //after all, add the last one
                    res.add(temp.getVal());
                    //then fix the tree, fix the parent-child pairs
                    reverse(prev, current.getLeft());
                    //fix the tree, break the circle
                    prev.setRight(null);
                    //move to the right subtree. 
                    //In the end, the current will point to the dump, and the right child of dump is null, loop end
                    current = current.getRight();
                }
            }
        }

        return res;
    }

    //change the rule of the **right child rule** between parent-child pairs
    public void reverse(MorrisTreeNode start, MorrisTreeNode end) {
        if (start == end) {
            return;
        }

        MorrisTreeNode pre = start;
        MorrisTreeNode cur = start.getRight();
        MorrisTreeNode next;

        while (pre != end) {
            next = cur.getRight();
            cur.setRight(pre);
            pre = cur;
            cur = next;
        }
    }
}
