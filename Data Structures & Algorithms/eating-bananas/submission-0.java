class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int r = Integer.MIN_VALUE;
        int l = 1;
        int result = 0;
        int mid = 0;
        int res = 0;

        for(int n: piles){
            r = Math.max(r, n);
            // l = Math.min(l, n);
        }

        while(l <= r){
            mid = l + (r - l)/2;
            System.out.print("mid "+mid);
            for(int i = 0; i < piles.length; i++){
                result = (piles[i] + mid - 1)/mid + result;
            }
            // if(result == h) r = mid;
            if(result <= h){
                res = mid;
                r = mid - 1;
            } 
            else l = mid + 1;
            // if(h == result) break;
            result = 0;
        }

        return res;
    }
}
