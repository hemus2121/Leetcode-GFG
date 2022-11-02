class Solution {
    public int maxProfit(int[] prices) {
        
       int minPrice =Integer.MAX_VALUE, profit =0;
      
       for (int i =0;i< prices.length;i++){
           // revise min price and max profit
           minPrice = Math.min(minPrice, prices[i]);
           profit = Math.max(profit, prices[i]-minPrice);
       }
        return profit;
    }
}