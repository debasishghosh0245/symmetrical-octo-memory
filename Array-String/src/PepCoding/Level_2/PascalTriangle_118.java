import java.util.*;
public class PascalTriangle_118{
    public static void main(String[] args){
        int row=5;
        System.out.println(generate(row));
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result=new ArrayList<>();
        for(int col=0;col<numRows;col++){
            int cC0=1;
            List<Integer> list=new ArrayList<>();
            for(int row=0;row<=col;row++){
                int curr=0;
                if(row==0){
                    curr=1;
                }else{
                    curr=(cC0*(col-(row-1))/((row-1)+1));
                }
                list.add(curr);
                cC0=curr;
            }
            result.add(list);
        }
        return result;
    }
}
