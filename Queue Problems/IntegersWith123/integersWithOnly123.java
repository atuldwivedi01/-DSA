
import java.util.*;
public class integersWithOnly123 {
    public static void main(String [] args){
        // Test1
        int [] ans=solve(5);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] solve(int A) {
        int [] ans=new int [A];
        if(A<=3){
            for(int i=0;i<A;i++){
                ans[i]=i+1;
            }
            return ans;
        }
        for(int i=0;i<3;i++){
            ans[i]=i+1;
            
        }
        int cnt=3;
        Queue<Integer> q=new LinkedList<Integer>();
        q.add(1);
        q.add(2);
        q.add(3);
        while(cnt<=A){
            int w=q.remove();
            int x=10*w+1;
            int y=10*w+2;
            int z=10*w+3;
            ans[cnt++]=x;
            if(cnt==A) return ans;
            // System.out.println(cnt+" "+Arrays.toString(ans));
            ans[cnt++]=y;
            if(cnt==A) return ans;
            ans[cnt++]=z;
            if(cnt==A) return ans;
            q.add(x);
            q.add(y);
            q.add(z);
        }
        return ans;
    }
}
