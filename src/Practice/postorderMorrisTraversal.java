/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

import Model.MorrisTreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Jiateng
 */
public class postorderMorrisTraversal {

    public List<Integer> postorderTraversal(MorrisTreeNode root) {

        ArrayList<Integer> res = new ArrayList<Integer>();

        MorrisTreeNode dump = new MorrisTreeNode(0);
        dump.setLeft(root);

        MorrisTreeNode current = dump;
        MorrisTreeNode prev = null;

        while (current != null) {
            if (current.getLeft() == null) {
                current = current.getRight();
            } else {
                prev = current.getLeft();
                while (prev.getRight() != null && prev.getRight() != current) {
                    prev = prev.getRight();
                }

                if (prev.getRight() == null) {
                    prev.setRight(current);
                    current = current.getLeft();
                } else {
                    reverse(current.getLeft(), prev);
                    MorrisTreeNode temp = prev;

                    while (temp != current.getLeft()) {
                        res.add(temp.getVal());
                        temp = temp.getRight();
                    }

                    res.add(temp.getVal());
                    reverse(prev, current.getLeft());
                    prev.setRight(null);
                    current = current.getRight();
                }
            }
        }

        return res;
    }

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
