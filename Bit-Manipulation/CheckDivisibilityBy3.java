import java.util.*;
public class CheckDivisibilityBy3{

    public static void main(String[] args){
        String str="10010101010001";
        System.out.println(checkDivisibilityBy3(str,3));
    }

    public static boolean checkDivisibilityBy3(String str,int n){
        int evenBitSum=0;
        int oddBitSum=0;
        for(int i=str.length()-1;i>=0;i--){
            int ch=str.charAt(i)-'0';
            if(i % 2==0){
                evenBitSum+=ch;
            }else{
                oddBitSum+=ch;
            }
        }
        int x=evenBitSum-oddBitSum;
        return x % 11==0;
    }
}
