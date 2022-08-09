import java.util.*;
public class LongestCommonPrefix_14{

    public static void main(String[] args){
        Trie trie=new Trie();
        //String[] strs={"flower","flow","flight"};
        //String[] strs={"dog","racecar","car"};
        String[] strs={"ab","a"};
        String prefix=strs[0];
        for(String str: strs){
            trie.insert(str);
            if(prefix.length()>str.length()){
                prefix=str;
            }
        }
        System.out.println(trie.prefix(prefix));
    }

    public static String longestPrefx(String[] strs){
        return "";
    }

}
class Trie{
    TrieNode root;
    public class TrieNode{
        HashMap<Character,TrieNode> children=new HashMap<Character,TrieNode>();
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
    }
    public String prefix(String prefix){
        TrieNode curr=root;
        StringBuilder longestPrefix=new StringBuilder();
        for(int i=0;i<prefix.length();i++){
            char ch=prefix.charAt(i);
            for(Character key:curr.children.keySet()){
                if(ch!=key){
                    return longestPrefix.toString();
                }
            }
            longestPrefix.append(ch);
            curr=curr.children.get(ch);
        }
        return longestPrefix.toString();
    }

}
