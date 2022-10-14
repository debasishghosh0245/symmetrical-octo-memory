import java.util.*;
public class RansomNote_383{
    public static void main(String[] args){
        String ransomNote="ab";
        String magazine="ab";
        System.out.println(canConstruct(ransomNote,magazine));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<magazine.length();i++){
            char ch=magazine.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<ransomNote.length();i++){
            char ch=ransomNote.charAt(i);
            if(map.getOrDefault(ch,0)==0) return false;
            else map.put(ch,map.get(ch)-1);
        }
        return true;
    }
}
