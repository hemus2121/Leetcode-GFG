class Solution {
    public int maxProfit(int[] prices) {
        
        int minPrice = Integer.MAX_VALUE, maxProfit=0;
        for (int i =0;i< prices.length;i++){
            minPrice = Math.min(minPrice, prices[i]); // get latest current min price
            maxProfit = Math.max(maxProfit, prices[i]- minPrice); // get maxProfit so far
        }
        return maxProfit;
    }
    
}