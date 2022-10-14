import java.util.*;
public class SortCharactersByFrequency_451{
    public static void main(String[] args){
        //String str="tree";
        //String str="cccaaa";
        String str="Aabb";
        System.out.println(sortCharByFreq(str));
    }
    public static class Pair implements Comparable<Pair>{
        Character key;
        int val;
        Pair(Character key,int val){
            this.key=key;
            this.val=val;
        }
        public int compareTo(Pair pair){
            return pair.val-this.val;
        }
    }
    public static String sortCharByFreq(String str){
        StringBuilder sb=new StringBuilder();
        HashMap<Character,Integer> freqMap=new HashMap<Character,Integer>();
        PriorityQueue<Pair> maxHeap=new PriorityQueue<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            freqMap.put(ch,freqMap.getOrDefault(ch,0)+1);
        }
        //System.out.println("Freqency map >>"+freqMap);
        for(Map.Entry<Character,Integer> entry: freqMap.entrySet()){
            maxHeap.offer(new Pair(entry.getKey(),entry.getValue()));
        }
        while(!maxHeap.isEmpty()){
            Pair pair=maxHeap.poll();
            int val=pair.val;
            char key=pair.key;
            //System.out.println("Key >>"+key+" Val >>"+val);
            while(val-->0){
                sb.append(key);
            }
        }
        return sb.toString();
    }
}
