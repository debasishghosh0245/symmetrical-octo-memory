import java.util.*;
public class GroupAnagrams_49{
    public static void main(String[] args){
        String[] strs={"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagram(strs));
    }
    public static List<List<String>> groupAnagram(String[] strs){
        HashMap<HashMap<Character,Integer>,List<String>> map=new HashMap<>();
        List<List<String>> result=new ArrayList<>();
        for(String str: strs){
            HashMap<Character,Integer> frqMap=buildFreqMap(str);
            map.putIfAbsent(frqMap,new ArrayList<>());
            List<String> list=map.get(frqMap);
            list.add(str);
            map.put(frqMap,list);
        }
        for(List<String> val:map.values()){
            result.add(val);
        }
        return result;
    }
    public static HashMap<Character,Integer> buildFreqMap(String str){
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        return map;
    }
}
