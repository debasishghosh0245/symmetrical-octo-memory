import java.util.*;
public class PartitionLabels_763{

    public static void main(String[] args){
        //String s="ababcbacadefegdehijhklij";
        String s="eccbbbbdec";
        System.out.println(partitionLabels(s));
    }

    public static List<Integer> partitionLabels(String s) {
        int count=0;
        HashMap<Character,Integer> map=new HashMap<Character,Integer>();
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),i);
        }
        //System.out.println(map);
        int max_idx=Integer.MIN_VALUE;
        int prev=-1;
        for(int i=0;i<s.length();i++){
            max_idx=Math.max(map.get(s.charAt(i)),max_idx);
            if(max_idx==i){
                result.add(max_idx-prev);
                prev=max_idx;
            }
        }
        return result;
    }
}
