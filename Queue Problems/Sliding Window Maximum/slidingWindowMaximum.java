/*
Question: 
Given an array of integers A. There is a sliding window of size B, moving from the very left of the array to the very right. You can only see the B numbers in the window. Each time the sliding window moves rightwards by one position. You have to find the maximum for each window.

Return an array C, where C[i] is the maximum value in the array from A[i] to A[i+B-1].

Refer to the given example for clarity.

NOTE: If B > length of the array, return 1 element with the max of the array.
 A = [1, 3, -1, -3, 5, 3, 6, 7]
 B = 3
 o/p= [3, 3, 5, 5, 6, 7]
 */
import java.util.*;
public class slidingWindowMaximum {
    public static void main(String []args){
        // Test 1
        Integer [] temp=new Integer[]{1,3,-1,-3,5,3,6,7};
        System.out.println(slidingMaximum(Arrays.asList(temp), 3));
    }
    public static ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        int k=B;
        Deque<Integer> q=new LinkedList<>();
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
        
    }}
