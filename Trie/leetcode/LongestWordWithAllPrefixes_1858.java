import java.util.*;
public class LongestWordWithAllPrefixes_1858{
    public static void main(String[] args){
        //String[] words={"k","ki","kir","kira","kiran"};
        //String[] words={"a", "banana", "app", "appl", "ap", "apply", "apple"};
        String[] words={"abc","bc","ab","qwe"};
        Trie trie=new Trie();
        for(String word: words){
            trie.insert(word);
        }
        trie.dfs(trie.root);
        System.out.println(trie.longestWord);
    }
}
class Trie{
    TrieNode root;
    String longestWord="";
    public class TrieNode{
        String prefix;
        TreeMap<Character,TrieNode> children=new TreeMap<>();
    }
    Trie(){
        root=new TrieNode();
    }
    public void insert(String word){
        TrieNode curr=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(!curr.children.containsKey(ch)){
                curr.children.put(ch,new TrieNode());
            }
            curr=curr.children.get(ch);
        }
        curr.prefix=word;
    }
    public void dfs(TrieNode root){
        for(Map.Entry<Character,TrieNode> entry: root.children.entrySet()){
            TrieNode child=entry.getValue();
            if(child.prefix!=null){
                if(child.prefix.length()>longestWord.length()){
                    longestWord=child.prefix;
                }
                dfs(child);
            }
        }
    }
}
