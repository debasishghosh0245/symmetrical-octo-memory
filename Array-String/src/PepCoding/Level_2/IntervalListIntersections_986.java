import java.util.*;
public class IntervalListIntersections_986{
    public static void main(String[] args){
        int[][] firstList={{0,2},{5,10},{13,23},{24,25}};
        int[][] secondList={{1,5},{8,12},{15,24},{25,26}};
        int[][] result=intervalIntersection(firstList,secondList);
        for(int[] ans:result){
            System.out.println(Arrays.toString(ans));
        }
    }

    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> list=new ArrayList<>();
        int i=0;
        int j=0;
        while(i<firstList.length && j<secondList.length){
            int low=Math.max(firstList[i][0],secondList[j][0]);
            int high=Math.min(firstList[i][1],secondList[j][1]);
            if(low <= high){
                list.add(new int[]{cmnStart,cmnEnd});
            }
            if(firstList[i][1] < secondList[j][1]) {
                i++;
            }else{
                j++;
            }
        }
        return list.toArray(new int[list.size()][2]);
    }

}
