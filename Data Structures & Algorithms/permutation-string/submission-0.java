class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> countHash = new HashMap<>();

        for(char c: s1.toCharArray()){
            countHash.merge(c,1,Integer::sum);
        }
        
        for(int i = 0; i < s2.length() - s1.length() + 1; i++){
            // System.out.println(i);
            // System.out.println(s2.charAt(i));
            if(countHash.containsKey(s2.charAt(i))){
                HashMap<Character, Integer> freqMap = new HashMap<>();
                int count = 0;
                for(int j = i; count < s1.length(); j++, count++){
                    freqMap.merge(s2.charAt(j), 1, Integer::sum);
                    // System.out.println(s2.charAt(j));
                    // System.out.println(j);
                    // freqMap.put(s2.charAt(j), 1);
                    // System.out.println("freqHashMap is "+freqMap);
                }

                // System.out.println("freqHashMap is "+freqMap+" countHashMap is "+countHash);

                if(freqMap.equals(countHash)) return true;
            }
        }

        return false;
    }
}
