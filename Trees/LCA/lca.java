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
public class lca {
    
    public static void main(String []args){
        // Provide a Binary Tree to test.
    }
    static HashMap<Integer,ArrayList<Integer>> hm=new HashMap<Integer,ArrayList<Integer>>(); // key: Value of Node, [InTime , OutTime];
    public static int LCA(TreeNode A, int B, int C) {
        Travel(A);
        TreeNode cur=A;
        if(!hm.containsKey(B) || !hm.containsKey(C)){
            return -1;
        }
        int in_B=hm.get(B).get(0);
        int out_B=hm.get(B).get(1);
        int in_C=hm.get(C).get(0);
        int out_C=hm.get(C).get(1);
        // for (Map.Entry<Integer,ArrayList<Integer>> entry : hm.entrySet()){
        //     System.out.println(entry.getKey()+" : "+entry.getValue().get(0)+" , "+entry.getValue().get(1));
        // } 
        while(cur!=null){
            int in_left=Integer.MAX_VALUE;
            int out_left=Integer.MIN_VALUE;
            int in_right=Integer.MAX_VALUE;
            int out_right=Integer.MIN_VALUE;
            if(cur.left!=null){
            in_left=hm.get(cur.left.val).get(0);
            out_left=hm.get(cur.left.val).get(1);
            }
            if(cur.right!=null){
            in_right=hm.get(cur.right.val).get(0);
            out_right=hm.get(cur.right.val).get(1);
            }
            if(cur.left!=null && (in_left<=in_B && out_left>=out_B) && (in_left<=in_C && out_left>=out_C)){
                cur=cur.left;
            }
            else if(cur.right!=null && (in_right<=in_B && out_right>=out_B) && (in_right<=in_C && out_right>=out_C)){
                cur=cur.right;
            }
            else{
                return cur.val;
            }
        }
        return -1;
    }
    static int T=0;
    public static void Travel(TreeNode root){
        if(root==null){
            return;
        }
        if(hm.containsKey(root.val)){
            ArrayList<Integer> temp=hm.get(root.val);
            temp.add(T);
            hm.put(root.val,temp);
        }else{
            ArrayList<Integer> temp=new ArrayList<Integer>();
            temp.add(T);
            hm.put(root.val,temp);
        }
        T+=1;
        Travel(root.left);
        Travel(root.right);
        if(hm.containsKey(root.val)){
            ArrayList<Integer> temp=hm.get(root.val);
            temp.add(T);
            hm.put(root.val,temp);
        }else{
            ArrayList<Integer> temp=new ArrayList<Integer>();
            temp.add(T);
            hm.put(root.val,temp);
        }
        T+=1;
    }

}
