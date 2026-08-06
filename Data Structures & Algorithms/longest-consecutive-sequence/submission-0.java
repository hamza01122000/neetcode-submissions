class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        HashMap<Integer, Integer> targetHashMap = new HashMap<>();

        int target = 0;
        int count = 0;

        for(int n : nums){
            hashMap.put(n, 0);
        }

        for(Map.Entry<Integer, Integer> curr : hashMap.entrySet()){
            if(curr.getValue() == 1) continue;
            else{
                
                int key = curr.getKey();
                hashMap.put(curr.getKey(), 1);
                count = count + 1;
                targetHashMap.put(key, count);
                System.out.print(targetHashMap);

                for(int j = curr.getKey() + 1, k = 0; k < nums.length; j++, k++){
                    
                    if(!hashMap.containsKey(j)){
                        
                        targetHashMap.put(key, count);
                        
                        count = 0;
                        break;
                    }
                    else{
                        
                        hashMap.put(j, 1);
                        
                        if(!targetHashMap.containsKey(j)){
                            count = count + 1;
                        }
                        else{
                            targetHashMap.merge(j, count, Integer::sum);
                            targetHashMap.put(key, targetHashMap.remove(j));
                            count = 0;
                            break;
                        }
                    }
                }
            }
        }

        
        for(Map.Entry<Integer, Integer> curr : targetHashMap.entrySet()){
            if(curr.getValue() > target){
                target = curr.getValue();
            }
        }
        return target;
    }
}
