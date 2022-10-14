public class FindTheDifference_389{

    public static void main(String[] args){
        String s="abcd", t="abcde";
        System.out.println(findTheDifference(s,t));
    }

    public static char findTheDifference(String s,String t){
        char xor=0;
        // XOR all the characters of both s and t.
        for(int i=0;i<s.length();i++){
            xor^=s.charAt(i);
        }
        for(int i=0;i<t.length();i++){
            xor^=t.charAt(i);
        }
        //what is left is extra
        return xor;
    }
}
