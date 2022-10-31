class Solution {
    public int[] sortByBits(int[] arr) {
        //store array element along with bit values in 2 d matrix
       int[][] temp = new int[arr.length][2]; //[[0,0],[1,1],[2,1],[3,2],[4,1],[5,2]]
        
        for (int i =0;i< arr.length;i++){
            temp[i][0] = arr[i];
            temp[i][1] = Integer.bitCount(arr[i]);
        }
        Arrays.sort(temp, (a,b) -> a[1]==b[1]? a[0]-b[0]:a[1]-b[1]);
        
        for (int i = 0; i < arr.length; i++) {  
            arr[i] = temp[i][0];
        }
        
        return arr;
        
    }
}