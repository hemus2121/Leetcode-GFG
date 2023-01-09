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
            int hourSpent = 0;
            
            //iter over piles and get the hours spent
            for (int pile: piles){
                hourSpent += Math.ceil((double)pile/mid);
            }
            
            // Check if middle is a workable speed, and cut the search space by half.
            if (hourSpent<=h){
                high = mid;
            }else {
                low = mid+1;
            }
        }
        // Once the left and right boundaries coincide, we find the target value,
        // that is, the minimum workable eating speed.
        return low;
    }
}