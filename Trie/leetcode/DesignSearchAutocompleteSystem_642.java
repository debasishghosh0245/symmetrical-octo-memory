import java.util.*;
public class DesignSearchAutocompleteSystem_642{
    public static void main(String[] args){
        String[] sentences={"i love you", "island", "iroman", "i love leetcode"};
        int[] hotDegree={5,3,2,2};
        AutocompleteSystem autoCompleteSys= new AutocompleteSystem(sentences,hotDegree);
        //autoCompleteSys.display(autoCompleteSys.root);
        System.out.println(autoCompleteSys.input("i"));
    }
}
class AutocompleteSystem{
    TrieNode root;
    PriorityQueue<Pair> priorityQueue;
    public static class TrieNode{
        String prefix;
        int hotDegree;
        TreeMap<Character,TrieNode> children=new TreeMap<>();
    }
    static class Pair implements Comparable<Pair>{
        int hotDegree;
        TrieNode child;
        Character ch;
        Pair(int hotDegree,TrieNode child,Character ch){
            this.hotDegree=hotDegree;
            this.child=child;
            this.ch=ch;
        }
        public int compareTo(Pair pair){
            return pair.hotDegree-this.hotDegree;
        }
    }
    public AutocompleteSystem(String[] sentences, int[] times) {
        root=new TrieNode();
        for(int i=0;i<sentences.length;i++){
            String sentence=sentences[i];
            int hotDegree=times[i];
            addWord(sentence,hotDegree);
        }
    }
    public void addWord(String word,int hotDegree){
        TrieNode curr=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(!curr.children.containsKey(ch)){
                curr.children.put(ch,new TrieNode());
                curr.hotDegree+=hotDegree;
            }
            curr=curr.children.get(ch);
        }
        curr.prefix=word;
    }
    public List<String> input(String prefix) {
        TrieNode curr=root;
        List<String> list=new ArrayList<>();
        for(int i=0;i<prefix.length();i++){
            char ch=prefix.charAt(i);
            if(!curr.children.containsKey(ch)){
                return new ArrayList<>();
            }
            curr=curr.children.get(ch);
        }
        priorityQueue=new PriorityQueue<Pair>();
        StringBuilder sb=new StringBuilder();
        sb.append(prefix);
        dfs(curr,list,priorityQueue,sb);
        return list;
    }
    public static void dfs(TrieNode root,List<String> list,PriorityQueue<Pair> priorityQueue,StringBuilder sb){
        if(list.size()==3) return;
        for(Map.Entry<Character,TrieNode> entry:root.children.entrySet()){
            TrieNode child=entry.getValue();
            priorityQueue.offer(new Pair(child.hotDegree,child,entry.getKey()));
            while(priorityQueue.size()>3){
                priorityQueue.poll();
            }
        }
        //System.out.println("Priority Queue >>"+priorityQueue);
        while(!priorityQueue.isEmpty()){
            Pair pair=priorityQueue.poll();
            TrieNode child=pair.child;
            if(child.prefix!=null){
                list.add(sb.toString());
            }
            sb.append(pair.ch);
            dfs(child,list,priorityQueue,sb);
        }
    }
    public void display(TrieNode root){
        if(root.prefix!=null){
            System.out.println("");
            return;
        }
        for(Map.Entry<Character,TrieNode> entry: root.children.entrySet()){
            System.out.print(entry.getKey()+" ");
            TrieNode child=entry.getValue();
            System.out.print(child.hotDegree+" ");
            display(child);
        }
    }
}
