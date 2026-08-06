class Solution {
    public boolean isPalindrome(String s) {
        boolean result = true;

        String resultString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        char[] charArray = resultString.toCharArray();

        for(int i = 1, j = resultString.length(); i < resultString.length()/2 + 1; i++, j--){
            if(charArray[i-1] != charArray[j-1]) return false;
            else if(i+1 == j-1) return true;
            else if(i == j-1 && charArray[i-1] == charArray[j-1]) break;
        }
        return true;
    }
}
