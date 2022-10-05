class Solution {
    public int maxProfit(int[] prices) {
        
       int minPrice =Integer.MAX_VALUE, profit =0;
        // Iterate input array and get minimal till now
        /*for (int i =0;i< prices.length;i++){
            if (prices[i]<minPrice){
                minPrice = prices[i];
            } else if ( prices[i]- minPrice > profit){
                profit = prices[i]-minPrice;
            }
        }
        return profit; */
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