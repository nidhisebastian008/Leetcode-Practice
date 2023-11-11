class Solution {
    public int maxProfit(int[] prices) {
        int profit=0;
        int buy=Integer.MAX_VALUE;
        for(int p:prices)
        {
            buy=Math.min(buy, p);
            profit=Math.max(profit,p-buy);
        }
        return profit;
        
    }
}