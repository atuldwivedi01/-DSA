/*
Question:
Given a binary tree, return a 2-D array with vertical order traversal of it. Go through the example and image for more details.


NOTE: If 2 Tree Nodes shares the same vertical level then the one with lesser depth will come first.
*/

class customData{
     TreeNode node;
     Integer pos;
     customData(TreeNode node,int n){
         this.node=node;
         this.pos=n;
     }
 }
public class Solution {
    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        ArrayList<ArrayList<Integer>> ans=new ArrayList<ArrayList<Integer>>();
        Deque<customData> q=new LinkedList<customData>();
        HashMap<Integer,ArrayList<TreeNode>> hm=new HashMap<Integer,ArrayList<TreeNode>>();
        TreeNode last=A;
        int min=Integer.MAX_VALUE;
        int max=0;
        int pos=0;
        q.addLast(new customData(A,0));
        while(q.size()!=0){
            customData cur=q.removeFirst();
            // System.out.println(cur.node.val);
            if(hm.containsKey(cur.pos)){
                ArrayList<TreeNode> temp=hm.get(cur.pos);
                temp.add(cur.node);
                hm.put(cur.pos,temp);
            }else{
                ArrayList<TreeNode> temp=new ArrayList<>();
                temp.add(cur.node);
                hm.put(cur.pos,temp); 
            }
            if(cur.node.left!=null){
                q.addLast(new customData(cur.node.left,cur.pos-1));
                min=Math.min(min,cur.pos-1);
            }
            if(cur.node.right!=null){
                q.addLast(new customData(cur.node.right,cur.pos+1));
                max=Math.max(max,cur.pos+1);
            }
            if(q.size()!=0 && cur.node==last){
                customData cLast=q.peekLast();
                last=cLast.node;
            }
        }
        if(min==Integer.MAX_VALUE){
            min=0;
        }
        if(max==Integer.MIN_VALUE){
            max=0;
        }
        // System.out.println(min+" "+max);
    for(int i=min;i<=max;i++){
        ArrayList<TreeNode> temp=hm.get(i);
        ArrayList<Integer>ansTemp=new ArrayList<>();
        for(int j=0;j<temp.size();j++){
            ansTemp.add(temp.get(j).val);
        }
        ans.add(ansTemp);
    }
    return ans;
    }
}
