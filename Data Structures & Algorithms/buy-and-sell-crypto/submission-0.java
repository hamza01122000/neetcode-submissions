class Solution {
    public int maxProfit(int[] prices) {
        int target = 0;
        
        for(int i = 1; i <= prices.length; i++){
            for(int j = i+1; j <= prices.length; j++){
                int temp = prices[j-1] - prices[i-1];

                if(temp > target) target = temp;
            }
        }

        return target;
    }
}
