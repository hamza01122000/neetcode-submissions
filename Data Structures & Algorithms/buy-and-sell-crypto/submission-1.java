class Solution {
    public int maxProfit(int[] prices) {
        int target = 0;
        int maxElement = prices[0];
        int maxIndex = 0;

        for(int i = 1; i <= prices.length; i++){
            if(prices[i-1] > maxElement){
                maxIndex = i-1;
                maxElement = prices[i-1];
            }
        }
        
        for(int i = 1; i <= prices.length; i++){

            int temp = maxElement - prices[i-1];
            if(temp > target) target = temp;  
            // System.out.print("target: "+target+" ");

            if(i-1 == maxIndex && i-1 != prices.length-1){

                maxElement = prices[i];
                for(int j = i; j < prices.length; j++){
                    // System.out.print("Max: "+maxElement+" Index: "+i+" j is: "+j+" ");
                   if(prices[j] >= maxElement){
                        maxIndex = j;
                        maxElement = prices[j];
                    } 
                }
        }
    }
    return target;
    }
}

