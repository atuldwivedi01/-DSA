/*
Question:
Two elements of a binary search tree (BST), represented by root A are swapped by mistake.
Tell us the 2 values swapping which the tree will be restored.
A solution using O(n) space is pretty straightforward. Could you devise a constant space solution?
*/


import java.util.*;
public class recoverBinarySearchTree {
    public static void main(String [] args){
        // Give Test Tree.
    }   
    int first=-1;
    int second=-1;
    int prev=Integer.MIN_VALUE;
    int curr=-1;
    public ArrayList<Integer> recoverTree(TreeNode A) {
        check(A);
        ArrayList<Integer> res=new ArrayList<>();
        res.add(second);
        res.add(first);
        return res;
    }
    public void check(TreeNode root){
        if(root==null){
            return ;
        }
        check(root.left);
        curr=root.val;
        if(curr<prev){
            if(first==-1){
                first=prev;
            }
            second=root.val;
        }
        prev=curr;
        check(root.right);
    }
    
}
