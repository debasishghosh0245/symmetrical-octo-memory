import java.util.*;
public class PascalTriangleII_119{

    public static void main(String[] args){
        int row=3;
        System.out.println(generate(row));
    }
    public static List<Integer> generate(int row_index) {
        List<Integer> result=new ArrayList<>();
        long val=1;
        for(int i=0;i<=row_index;i++){
            result.add((int)val);
            long currVal=val*(row_index-i)/(i+1);
            val=currVal;
        }
        return result;
    }

}
