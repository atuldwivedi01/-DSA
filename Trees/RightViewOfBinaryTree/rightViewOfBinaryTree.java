/*
 Question: Right View of Binary tree
Given a binary tree of integers denoted by root A. Return an array of integers representing the right view of the Binary tree.
Right view of a Binary Tree is a set of nodes visible when the tree is visited from Right side.

 */

import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
        left=null;
        right=null;
    }
}
public class rightViewOfBinaryTree {
    public static void main(String [] args){
        // Make a Tree and test the function. 
    }
    public ArrayList<Integer> solve(TreeNode A) {
        Deque<TreeNode> q=new LinkedList<>();
        ArrayList<Integer> ans=new ArrayList<Integer>();
        q.addLast(A);
        TreeNode last=A;
        while(q.size()!=0){
            TreeNode cur=q.removeFirst();
            if(cur.left!=null){
                q.addLast(cur.left);                
            }
            if(cur.right!=null){
                q.addLast(cur.right);
            }
            if(cur==last){
                ans.add(cur.val);
                last=q.peekLast();
            }
        }
        return ans;


    }
}
