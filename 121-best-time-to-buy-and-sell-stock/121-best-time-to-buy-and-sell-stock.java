class Solution {
    public int maxProfit(int[] prices) {
        
       int minPrice =Integer.MAX_VALUE, profit =0;
      
        for (int currPrice : prices){
            if (currPrice < minPrice){
                minPrice = currPrice;
            } else if( currPrice -minPrice > profit){
                profit = currPrice-minPrice;
            }
        }
        return profit;
    }
}