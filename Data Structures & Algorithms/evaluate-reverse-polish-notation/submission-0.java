class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;

        for(int i = 0; i < tokens.length; i++){
            String c = tokens[i];
            if(c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")){
                int pop1 = stack.pop();
                int pop2 = stack.pop();
                if(c.equals("+")) result = pop2 + pop1;
                if(c.equals("-")) result = pop2 - pop1;
                if(c.equals("*")) result = pop2 * pop1;
                if(c.equals("/")) result = pop2 / pop1;
                
                stack.push(result);
            }
            else{
                int val = Integer.parseInt(c);
                stack.push(val);
            }
        }

        return stack.peek();
    }
}
