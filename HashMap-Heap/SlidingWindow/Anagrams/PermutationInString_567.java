import java.util.*;
public class PermutationInString_567{

    public static void main(String[] args){
        String s1="ab";
        String s2="eidboaoo";
        System.out.println(checkInclusion(s1,s2));
    }

    public static boolean checkInclusion(String s1, String s2) {
        HashMap<Character,Integer> map1=new HashMap<>();
        HashMap<Character,Integer> map2=new HashMap<>();
        for(int i=0;i<s1.length();i++){
            char ch=s1.charAt(i);
            map1.put(ch,map1.getOrDefault(ch,0)+1);
        }
        int j=0;
        int i=0;
        while(j<s1.length()){
            char ch=s2.charAt(j++);
            map2.put(ch,map2.getOrDefault(ch,0)+1);
        }
        while(j<s2.length()){
            //System.out.println("Map1 >>"+map1);
            System.out.println("Map2 >>"+map2);
            if(map1.equals(map2)) return true;
            else{
                char ch1=s2.charAt(j);
                map2.put(ch1,map2.getOrDefault(ch1,0)+1);
                char ch2=s2.charAt(i);
                map2.put(ch2,map2.getOrDefault(ch2,0)-1);
                if(map2.getOrDefault(ch2,0)==0){
                    map2.remove(ch2);
                }
                i++;
                j++;
            }
        }
        System.out.println("Map2 >>"+map2);
        if(map1.equals(map2)) return true;
        return false;
    }
}
