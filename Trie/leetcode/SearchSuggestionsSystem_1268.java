import java.util.*;
public class SearchSuggestionsSystem_1268{
    public static void main(String[] args){
        Trie trie=new Trie();
        //String[] products={"havana"};
        String[] products={"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord="tmouse";
        for(String product: products){
            trie.insert(product);
        }
        List<List<String>> ans=new ArrayList<>();
        for(int i=0;i<searchWord.length();i++){
            ans.add(trie.search(searchWord.substring(0,i+1)));
        }
        System.out.println(ans);
    }
}
class Trie{
    TrieNode root;
    public static class TrieNode{
        String word;
        TreeMap<Character,TrieNode> children=new TreeMap<>();
    }
    Trie(){
        root=new TrieNode();
    }
    public void insert(String word){
        TrieNode curr=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            curr.children.putIfAbsent(ch,new TrieNode());
            curr=curr.children.get(ch);
        }
        curr.word=word;
    }
    public List<String> search(String prefix){
        List<String> result=new ArrayList<>();
        TrieNode curr=root;
        for(int i=0;i<prefix.length();i++){
            char ch=prefix.charAt(i);
            if(!curr.children.containsKey(ch)){
                return new ArrayList<>();
            }
            curr=curr.children.get(ch);
        }
        dfs(curr,result,new StringBuilder(prefix));
        return result;
    }
    public List<String> dfs(TrieNode root,List<String> result,StringBuilder sb){
        if (result.size() == 3)
			return result;
        if (root.word != null) {
			result.add(sb.toString());
		}
		for (Map.Entry<Character, TrieNode> entry : root.children.entrySet()) {
			Character ch = entry.getKey();
			TrieNode child = entry.getValue();
			sb.append(entry.getKey());
            dfs(child,result,sb);
			sb.deleteCharAt(sb.length() - 1);
		}
        return result;
    }
}
