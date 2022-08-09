import java.util.*;
public class MagicDictionary_676{

    public static void main(String[] args){
        String[] str={"hello","leetcode"};
        MagicDictionary magicword=new MagicDictionary();
        magicword.buildDict(str);
    }
}
class MagicDictionary{
    static TrieNode root;
    MagicDictionary(){
        root=new TrieNode();
    }
    public static class TrieNode{
        String prefix;
        TreeMap<Character,TrieNode> children=new TreeMap<>();
    }
    public void buildDict(String[] dictionary) {
        for(String word: dictionary){
            addWord(word);
        }
    }
    public static void addWord(String word){
        TrieNode curr=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(!curr.children.containsKey(ch)) {
                curr.children.put(ch,new TrieNode());
            }
            curr=curr.children.get(ch);
        }
        curr.prefix=word;
    }
    public boolean search(String searchWord) {
        return false;
    }
}
