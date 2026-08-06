// class Solution {

//     ArrayList<String> arrayList = new ArrayList<>();

//     public String encode(List<String> strs) {

//         StringBuilder sb = new StringBuilder();

//         for(String s : strs){
//             sb.append(s);
//             arrayList.add(s);
//         }
//         // System.out.println(arrayList);

//         String result = sb.toString();

//         return result;
//     }

//     public List<String> decode(String str) {
//         List<String> output = new ArrayList<>();
//         StringBuilder sb = new StringBuilder();
        
//         for(int i = 1; i <= arrayList.size(); i++){

//             String input = arrayList.get(i-1);

//             for(char ch: input.toCharArray()){
//                 sb.append(ch);
//             }
//             String result = sb.toString();
//             output.add(result);
//             sb.setLength(0);
            
//             // if(ch == ' '){
//             //     String result = sb.toString();
//             //     output.add(result);
//             //     sb.setLength(0);
//             // }
//             // else{
//             //     sb.append(ch);
//             // }
//         }

//         return output;
//     }

// }


public class Solution {

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (String s : strs) {
            res.append(s.length()).append('#').append(s);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = i + length;
            res.add(str.substring(i, j));
            i = j;
        }
        return res;
    }
}
