class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> validStack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            // System.out.print(" char of string "+s.charAt(i));
            if(s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '('){
                validStack.push(s.charAt(i));
            }
        else{
                if(validStack.isEmpty()) return false;
                // System.out.print(" char at top "+validStack.peek());
                if(s.charAt(i) == ')' && validStack.peek() == '(' || s.charAt(i) == '}' && validStack.peek() == '{' || s.charAt(i) == ']' && validStack.peek() == '['){
                    validStack.pop();
                }
                else return false;
                
            }
        }
        // System.out.println(validStack);
        // System.out.println(validStack.isEmpty());

        return validStack.isEmpty() ? true : false;
    }
}
