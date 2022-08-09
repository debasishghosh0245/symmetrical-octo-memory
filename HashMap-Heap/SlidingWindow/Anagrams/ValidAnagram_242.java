import java.util.*;
public class ValidAnagram_242{
    public static void main(String[] args){
        String s="anagram";
        String t="nagaram";
        System.out.println(isAnamgram(s,t));
    }
    public static boolean isAnamgram(String s,String t){
        HashMap<Character,Integer> map=new HashMap<>();
        if(s.length()!=t.length()) return false;
        for(int i=0;i<s.length();i++){
            char chs=s.charAt(i);
            char cht=t.charAt(i);
            map.put(chs,map.getOrDefault(chs,0)+1);
            map.put(cht,map.getOrDefault(cht,0)-1);
        }
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            if(entry.getValue()!=0) return false;
        }
        return true;
    }
}
