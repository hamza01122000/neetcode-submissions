class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] output = new int[temperatures.length];
        Stack<Integer> elementStack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();
        int index = 0;

        elementStack.push(temperatures[0]);
        indexStack.push(index);

        for(int i = 1; i < temperatures.length; i++){
            if(temperatures[i] > elementStack.peek()){
                while(!elementStack.isEmpty() && temperatures[i] > elementStack.peek()){
                        elementStack.pop();
                        index = indexStack.pop();
                        output[index] = i - index;
                        index++;
                }
            elementStack.push(temperatures[i]);
            indexStack.push(i);
            }
            else{
                elementStack.push(temperatures[i]);
                indexStack.push(i);
            }
        }

        return output;
    }
}
