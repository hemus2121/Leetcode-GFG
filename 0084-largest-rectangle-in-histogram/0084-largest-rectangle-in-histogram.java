class Solution {
    public int largestRectangleArea(int[] heights) {
       int [] smallLeft = nearSmallerLeft(heights);
        int [] smallright = nearSmallerRight(heights);
        
        long area =0;
        for (int i =0;i<heights.length;i++){
            int r = smallright[i];
            int l = smallLeft[i];
            area = Math.max(area, (r-l-1)*heights[i]);
        }
        return (int) area;
    }

    //build near smallest elements response from left side 
    public int [] nearSmallerLeft(int []A){
        Stack <Integer> st = new Stack();
        int [] res = new int [A.length];
        for (int i =0;i<A.length;i++){
            while (!st.isEmpty() && A[st.peek()]>= A[i]){
                st.pop();
            }
            //if stack empty denote by index =-1 otherwise peak element on stack
            if (st.isEmpty()) res[i]=-1;
            else res[i]= st.peek(); 

            st.push(i);
        }
        return res;
    }

    // build near smallest elements response from right side
    //condition check is SAME in while loop but interate from A.length-1
    public int [] nearSmallerRight(int []A){
        Stack <Integer> st = new Stack();
        int [] res = new int [A.length];
        for (int i =A.length-1;i>=0;i--){
            while (!st.isEmpty() && A[st.peek()]>= A[i]){
                st.pop();
            }
            //if stack empty denote by index =-1 otherwise peak element on stack
            if (st.isEmpty()) res[i]=A.length;
            else res[i]= st.peek(); 
            st.push(i);
        }
        return res;
    }
    
}