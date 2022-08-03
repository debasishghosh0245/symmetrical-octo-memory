public class ValidAnagram_242{

    public static void main(String[] args){
        String s="anagram";
        String t="nagaram";
        System.out.println(isAnamgram(s,t));
    }

    public static boolean isAnamgram(String s,String t){
        HashMap<Character,Integer> sMap=new HashMap<>();
        HashMap<Character,Integer> tMap=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            sMap.putIfAbsent(ch,0);
            sMap.put(ch,sMap.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            tMap.putIfAbsent(ch,0);
            tMap.put(ch,tMap.getOrDefault(ch,0)+1);
        }
        System.out.println("Source map >>"+sMap);
        System.out.println("Tem Map>> "+tMap);
    }
}
