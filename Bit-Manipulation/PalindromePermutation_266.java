import java.util.*;
public class PalindromePermutation_266{
    public static void main(String[] args){
        String str="aab";
        System.out.println(canPermutePalindromeII(str));
    }
    public static boolean canPermutePalindrome(String str){
        char xor=0;
        for(char ch : str.toCharArray()){
            xor^=ch;
        }
        return xor==0 || Character.isLetter(xor);
    }
    public static boolean canPermutePalindromeSet(String str){
        HashSet<Character> set=new HashSet<>();
        for(char ch : str.toCharArray()){
            if(set.contains(ch)) {
                set.remove(ch);
            }else{
                set.add(ch);
            }
        }
        return  set.size()<=1;
    }
    public static boolean canPermutePalindromeII(String str){
        int[] arr=new int[26];
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(arr[ch-'a'] >= 1){
                    arr[ch-'a']--;
            }else{
                arr[ch-'a']++;
            }
        }
        int freq=0;
        for(int i=0;i<arr.length;i++){
            freq+=arr[i];
        }
        return freq <= 1;
    }
}
