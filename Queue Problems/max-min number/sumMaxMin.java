/*
 * Question:
 Given an array A of both positive and negative integers.

Your task is to compute the sum of minimum and maximum elements of all sub-array of size B.

NOTE: Since the answer can be very large, you are required to return the sum modulo 109 + 7.
 */


import java.util.*;
public class sumMaxMin {
    public static void main(String [] args){
        // Test 1
        Integer [] arr=new Integer[]{2, 5, -1, 7, -3, -1, -2};
        ArrayList<Integer> testArray= new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            testArray.add(arr[i]);
        }
        System.out.println(solve(testArray,3));

    }
    public static int solve(ArrayList<Integer> A, int B) {
        
        ArrayList<Integer> maxElements=findMax(A,B);
        ArrayList<Integer> minElements=findMin(A,B);
        long mod=1000000007;
        long ans=0;
        for(int i=0;i<maxElements.size();i++){
            ans=(ans%mod+(minElements.get(i)+maxElements.get(i))%mod+mod)%mod;
            ans%=mod;
        }
        return (int)(ans%mod);
    }

    public static ArrayList<Integer> findMax(ArrayList<Integer> A,int B){
        int k=B;
        Deque<Integer> q=new ArrayDeque();
        ArrayList<Integer> ans=new ArrayList<Integer>();
        for (int i=0;i<B;i++){
            while(q.size()!=0 && A.get(q.getLast())<=A.get(i)){
                q.removeLast();
            }
            q.offerLast(i);
        }
        ans.add(A.get(q.peekFirst()));
        for (int i=k ;i<A.size();i++){
            while(q.size()!=0 && A.get(q.getLast())<=A.get(i)){
                q.removeLast();
            }
            q.offerLast(i);
            if(q.peekFirst()<=i-k){
                q.removeFirst();
            }
            ans.add(A.get(q.peekFirst()));
        }
        return ans;
    }

    public static ArrayList<Integer> findMin(ArrayList<Integer> A,int B){
        int k=B;
        Deque<Integer> q=new ArrayDeque();
        ArrayList<Integer> ans=new ArrayList<Integer>();
        for (int i=0;i<B;i++){
            while(q.size()!=0 && A.get(q.getLast())>=A.get(i)){
                q.removeLast();
            }
            q.offerLast(i);
        }
        ans.add(A.get(q.peekFirst()));
        for (int i=k ;i<A.size();i++){
            while(q.size()!=0 && A.get(q.getLast())>=A.get(i)){
                q.removeLast();
            }
            q.offerLast(i);
            if(q.peekFirst()<=i-k){
                q.removeFirst();
            }
            ans.add(A.get(q.peekFirst()));
        }
        return ans;
    }
}
