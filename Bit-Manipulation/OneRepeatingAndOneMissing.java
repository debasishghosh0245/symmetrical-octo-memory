import java.util.*;
public class OneRepeatingAndOneMissing{

    public static void main(String[] args){
        int[] arr={1,3,4,5,1,6,2};
        System.out.println(Arrays.toString(oneRepeatingAndOneMissing(arr)));
    }

    public static int[] oneRepeatingAndOneMissing(int[] arr){
        int n=arr.length;
        int[] result=new int[2];
        int xor=0;
        for(int i=0;i<arr.length;i++){
            xor=xor^arr[i];
        }
        for(int i=1;i<=arr.length;i++){
            xor=xor ^ i;
        }
        int mask=xor & (-xor);
        int x=0;
        int y=0;
        for(int i=0;i<arr.length;i++){
            if((mask & arr[i])==0){
                x=x^arr[i];
            }else{
                y=y^arr[i];
            }
        }
        for(int i=1;i<=arr.length;i++){
            if((mask & i)==0){
                x=x^i;
            }else{
                y=y^i;
            }
        }
        //find repeating and missing
        for(int i=0;i<arr.length;i++){
            if(x==arr[i]){
                result[0]=x;
                result[1]=y;
                break;
            }else{
                result[0]=y;
                result[1]=x;
            }
        }
        return result;
    }
}
