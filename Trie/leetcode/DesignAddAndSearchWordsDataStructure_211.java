import java.util.*;
public class DesignAddAndSearchWordsDataStructure_211{
    public static void main(String[] args){
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println("Search >> "+wordDictionary.search("..m",wordDictionary.root));
        wordDictionary.display(wordDictionary.root);
    }
}
class WordDictionary{
    TrieNode root;
    public static class TrieNode{
        boolean isLast;
        HashMap<Character,TrieNode> children=new HashMap<>();
    }
    WordDictionary(){
        root=new TrieNode();
    }
    public void addWord(String word){
        TrieNode curr=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(curr.children.get(ch)==null){
                curr.children.put(ch,new TrieNode());
            }
            curr=curr.children.get(ch);
        }
        curr.isLast=true;
    }
    public boolean search(String word,TrieNode root){
        TrieNode curr=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(curr.children!=null && !curr.children.containsKey(ch)){
                if(ch=='.'){
                    HashMap<Character,TrieNode> children=curr.children;
                    for(char key: children.keySet()){
                        TrieNode child=children.get(key);
                        if(search(word.substring(i+1),child)){
                            return true;
                        }
                    }
                    return false;
                }
            }
            curr=curr.children.get(ch);
        }
        if(curr==null){
            return false;
        }
        return curr.isLast;
    }
    public void display(TrieNode root){
        HashMap<Character,TrieNode> children=root.children;
        for(Map.Entry<Character,TrieNode> entry: children.entrySet()){
            System.out.print(entry.getKey());
            TrieNode child=children.get(entry.getKey());
            display(child);
            if(child.isLast){
                System.out.println(" ");
            }
        }
    }
}
