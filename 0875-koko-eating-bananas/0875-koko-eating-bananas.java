class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int low =1, high=0;
        // get the maximum speed
        for (int pile : piles){
            high = Math.max(high, pile);
        }
        
        while (low < high){
            // Get the middle index between left and right boundary indexes.
            // hourSpent stands for the total hour Koko spends.
            int mid = low + (high-low)/2;
                     
          
            // Check if middle is a workable speed, and cut the search space by half.
            if (canEatAll(piles, mid, h)){
                high = mid;
            }else {
                low = mid+1;
            }
        }
        // Once the left and right boundaries coincide, we find the target value,
        // that is, the minimum workable eating speed.
        return low;
    }
    
    boolean canEatAll(int[] piles, int K, int h){
         int countHour = 0; // Hours take to eat all bananas at speed K.
         for (int pile : piles){
             countHour += pile / K;
             if (pile % K != 0)
                 countHour++;
         }
        return countHour <= h;
    }
}