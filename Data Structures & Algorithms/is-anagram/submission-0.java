class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        HashMap<Character, Integer> hashTable = new HashMap<>();

        for(char ch : s.toCharArray()){
            hashTable.merge(ch, 1, Integer::sum);
        }

        for(char ch : t.toCharArray()){
            hashTable.merge(ch, -1, Integer::sum);
        }

        for(int value: hashTable.values()){
            if(value < 0)
                return false;
        }

        return true;
    }
}
