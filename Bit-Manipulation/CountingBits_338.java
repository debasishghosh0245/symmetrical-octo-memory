import java.util.*;
public class CountingBits_338{

    public static void main(String[] args){
        int n=5;
        int[] num=new int[n+1];
        for(int i=0;i<=n;i++){
            num[i]=numberOf1Bits(i);
        }
        System.out.println(Arrays.toString(num));
    }

    public static int numberOf1Bits(int num){
        int count=0;
        while(num!=0){
            int rsb=num & (-num);
            num=num-rsb;
            count++;
        }
        return count;
    }
}
