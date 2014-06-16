/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Jiateng
 */
public class MorrisTreeNode {

    int val;
    MorrisTreeNode left;
    MorrisTreeNode right;

    public MorrisTreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public MorrisTreeNode getLeft() {
        return left;
    }

    public void setLeft(MorrisTreeNode left) {
        this.left = left;
    }

    public MorrisTreeNode getRight() {
        return right;
    }

    public void setRight(MorrisTreeNode right) {
        this.right = right;
    }

}
