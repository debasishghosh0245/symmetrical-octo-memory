import java.util.*;
public class FindAllAnagramsInAString_438{
    public static void main(String[] args){
        String s="abab";
        String p="ab";
        // String s="cbaebabacd";
        // String p="abc";
        System.out.println(findAnagrams(s,p));
    }
    public static List<Integer> findAnagrams(String s, String p) {
        int i=0;
        int j=p.length();
        List<Integer> list=new ArrayList<>();
        while(j<=s.length()){
            //System.out.println("Substring >>"+s.substring(i,j));
            if(isAnamgram(s.substring(i,j),p)){
                list.add(i);
            }
            i++;
            j++;
        }
        return list;
    }
    public static boolean isAnamgram(String s,String p){
        HashMap<Character,Integer> map=new HashMap<>();
        if(s.length()!=p.length()) return false;
        for(int i=0;i<s.length();i++){
            char chs=s.charAt(i);
            char chp=p.charAt(i);
            map.put(chs,map.getOrDefault(chs,0)+1);
            map.put(chp,map.getOrDefault(chp,0)-1);
        }
        for(int val:map.values()){
            if(val!=0) return false;
        }
        return true;
    }
}
