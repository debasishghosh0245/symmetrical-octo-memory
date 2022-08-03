import java.util.*;
public class SpiralMatrix_54{
    public static void main(String[] args){
        int[][] matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        System.out.println(sprialOrder(matrix));
    }

    public static List<Integer> sprialOrder(int[][] matrix){
        int rowStart=0;
        int colStart=0;
        int rowEnd=matrix.length-1;
        int colEnd=matrix[0].length-1;
        int totalCnt=matrix.length*matrix[0].length;
        int currCnt=0;
        List<Integer> list=new ArrayList<>();
        while(currCnt<totalCnt){
            //top view
            for(int i=rowStart,j=colStart;j<=colEnd && currCnt<totalCnt;j++){
                list.add(matrix[i][j]);
                currCnt++;
            }
            rowStart++;
            //right View
            for(int i=rowStart,j=colEnd;i<=rowEnd && currCnt<totalCnt;i++){
                list.add(matrix[i][j]);
                currCnt++;
            }
            //down View
            colEnd--;
            for(int i=rowEnd,j=colEnd;j>=colStart && currCnt<totalCnt;j--){
                list.add(matrix[i][j]);
                currCnt++;
            }
            //left View
            rowEnd--;
            for(int i=rowEnd,j=colStart;i>=rowStart && currCnt<totalCnt;i--){
                list.add(matrix[i][j]);
                currCnt++;
            }
            colStart++;
        }
        return list;
    }
}
