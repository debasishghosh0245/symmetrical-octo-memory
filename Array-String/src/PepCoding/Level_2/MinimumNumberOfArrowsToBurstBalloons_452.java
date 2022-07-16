import java.util.*;
public class MinimumNumberOfArrowsToBurstBalloons_452{

    public static void main(String[] args){
        int[][] points={{1,6},{2,8},{7,12},{10,16}};
        System.out.println(findMinArrowShots(points));
    }

    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)->Integer.compare(a[1],b[1]));
        int[] lastPoint=points[0];
        int arrows=1;
        for(int i=1;i<points.length;i++){
            if(lastPoint[1]<points[i][0]){
                arrows++;
                lastPoint=points[i];
            }
        }
        return arrows;
    }
}
