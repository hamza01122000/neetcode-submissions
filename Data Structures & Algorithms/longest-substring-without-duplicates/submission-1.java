class Solution {
    public int lengthOfLongestSubstring(String s) {
        int target = 0;
        int temp = 0;
        HashSet<Character> hashSet = new HashSet<>();

        char[] charArray = s.toCharArray();

    
        for(int i = 1; i <= charArray.length; i++){
            char ch = charArray[i-1];

            hashSet.add(ch);
            temp = 1;

            if(charArray.length == 1) return temp;

            for(int j = i+1; j <= charArray.length; j++){
                char nextChar = charArray[j-1];

                if(hashSet.contains(nextChar)){
                    if(target < temp) target = temp;
                    hashSet.clear();
                    break;
                }
                else{
                    temp++;
                    hashSet.add(nextChar);
                    if(j == charArray.length){
                        if(temp > target) target = temp;
                    }
                }
            }

        }

        return target;
    }
}
