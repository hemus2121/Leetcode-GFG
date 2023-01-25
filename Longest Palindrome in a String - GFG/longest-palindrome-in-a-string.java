//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestPalin(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static String longestPalin(String S){
        // code here
        
        String longest = "";
        int n = S.length();
        
        //iterate for the string 
        for (int i =0;i< S.length();i++){
            
            //for odd length String
            String palin = expand (S, i, i);
            if (palin.length()> longest.length()){
                 longest = palin;
            }
            
            //for even length String 
            palin = expand(S, i, i+1);
            if (palin.length() > longest.length()){
                longest = palin;
            }
        }
        return longest;
    }
    
    static String expand (String s, int p1, int p2){
        while (p1>=0 && p2 < s.length() && s.charAt(p1)== s.charAt(p2)){
            p1--;
            p2++;
        }
        return s.substring(p1+1,p2);
    }
}