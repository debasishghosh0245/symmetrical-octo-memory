import java.util.*;
public class ConcatenatedWords_472{
    static TrieNode root;
    static class TrieNode{
        boolean isWord;
        HashMap<Character,TrieNode> children=new HashMap<>();
    }
    ConcatenatedWords_472(){
        root=new TrieNode();
    }
    public static void insert(String word){
        TrieNode curr=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(!curr.children.containsKey(ch)){
                curr.children.put(ch,new TrieNode());
            }
            curr=curr.children.get(ch);
        }
        curr.isWord=true;
    }
    public static void display(TrieNode root){
        HashMap<Character,TrieNode> children=root.children;
        for(Map.Entry<Character,TrieNode> entry:children.entrySet()){
            System.out.print(entry.getKey());
            TrieNode child=entry.getValue();
            display(child);
            if(child.isWord){
                System.out.println("");
            }
        }
    }
    public static boolean search(){
        return false;
    }

    public static void main(String[] args){
        String[] words={"cat","cats","catsdogcats","dog","dogcatsdog",
        "hippopotamuses","rat","ratcatdogcat"};
        ConcatenatedWords_472 trie=new ConcatenatedWords_472();
        for(String word: words){
            insert(word);
        }
        display(root);
    }
}
