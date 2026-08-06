class Solution {

    ArrayList<String> arrayList = new ArrayList<>();

    public String encode(List<String> strs) {

        StringBuilder sb = new StringBuilder();

        for(String s : strs){
            sb.append(s);
            arrayList.add(s);
        }
        // System.out.println(arrayList);

        String result = sb.toString();

        return result;
    }

    public List<String> decode(String str) {
        List<String> output = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 1; i <= arrayList.size(); i++){

            String input = arrayList.get(i-1);

            for(char ch: input.toCharArray()){
                sb.append(ch);
            }
            String result = sb.toString();
            output.add(result);
            sb.setLength(0);
            
            // if(ch == ' '){
            //     String result = sb.toString();
            //     output.add(result);
            //     sb.setLength(0);
            // }
            // else{
            //     sb.append(ch);
            // }
        }

        return output;
    }

}
