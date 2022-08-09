import java.util.*;
public class FindAllAnagramsInAString_4380{
    public static void main(String[] args){
        String s="cbaebabacd";
        String p="abc";
        System.out.println(findAnagrams(s,p));
    }
    public static List<Integer> findAnagrams(String s, String p) {
        HashMap<Character,Integer> pMap=new HashMap<>();
        HashMap<Character,Integer> sMap=new HashMap<>();
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<p.length();i++){
            char ch=p.charAt(i);
            pMap.put(ch,pMap.getOrDefault(ch,0)+1);
        }
        int j=0;
        while(j<p.length()){
            char ch=s.charAt(j);
            sMap.put(ch,sMap.getOrDefault(ch,0)+1);
            j++;
        }
        int i=0;
        while(j<s.length()){
            if(pMap.equals(sMap)){
                list.add(i);
            }
            sMap.put(s.charAt(j),sMap.getOrDefault(s.charAt(j),0)+1);
            if((sMap.getOrDefault(s.charAt(i),0)-1)==0){
                sMap.remove(s.charAt(i));
            }else{
                sMap.put(s.charAt(i),sMap.getOrDefault(s.charAt(i),0)-1);
            }
            i++;
            j++;
        }
        return list;
    }
}
