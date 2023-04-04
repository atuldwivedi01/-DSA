/*
Question:

Given a string A denoting a stream of lowercase alphabets, you have to make a new string B.
B is formed such that we have to find the first non-repeating character each time a character is inserted to
the stream and append it at the end to B. If no non-repeating character is found, append '#' at the end of B.

*/

import java.util.*;
public class firstNonRepeat{
    public static void main(String []args){
        // Test1
        String test1="aabbdd";
        System.out.println(solve(test1));
    } 
    public static String solve(String A) {
        
        
        char[] streamOfCharacter=A.toCharArray();
        
        Deque<Character> deque = new ArrayDeque<>();
        
        HashMap<Character,Integer> hm=new HashMap<Character,Integer>();
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<streamOfCharacter.length;i++){
            hm.put(streamOfCharacter[i],hm.getOrDefault(streamOfCharacter[i],0)+1);  
            if(hm.get(streamOfCharacter[i])==1){
                deque.addLast(streamOfCharacter[i]); 
            }
            while (deque.size()!=0 && hm.get(deque.getFirst())>1){
                deque.removeFirst();                
            }
           if(deque.size()!=0) {
            ans.append(deque.getFirst());
            }else{
                ans.append('#');
            }
        }
        // System.out.println(deque);
        return ans.toString();


    }
}