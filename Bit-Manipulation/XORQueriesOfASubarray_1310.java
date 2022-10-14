import java.util.*;
public class XORQueriesOfASubarray_1310{
    public static void main(String[] args){
        int[] arr={1,3,4,8};
        int[][] queries ={{0,1},{1,2},{0,3},{3,3}};
        System.out.println(Arrays.toString(xorQueries(arr,queries)));
    }
    public static int[] xorQueries(int[] arr, int[][] queries) {
        int[] result=new int[queries.length];
        //prefix xox
        int[] prefix_xor=new int[arr.length];
        prefix_xor[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            prefix_xor[i]=prefix_xor[i-1]^arr[i];
        }
        //System.out.println("Prefix Sum >>"+Arrays.toString(prefix_xor));
        for(int i=0;i<queries.length;i++){
            if(queries[i][0]==0){
                result[i]=prefix_xor[queries[i][1]];
            }else{
                System.out.println(i);
                System.out.println("left >>"+queries[i][1]);
                System.out.println("right >>"+queries[i][0]);
                result[i]=prefix_xor[queries[i][1]] ^ prefix_xor[queries[i][0]-1];
            }
        }
        return result;
    }
}
