import java.util.*;
public class CarPooling_1094{

    public static void main(String[] args){
        // int[][] trips={{2,1,5},{3,3,7}}; int capacity = 4; int[][]
        // trips={{2,1,5},{3,5,7}}; int capacity=3; int[][]
        // trips={{7,5,6},{6,7,8},{10,1,6}}; int capacity=16;
        int[][] trips={{9,0,1},{3,3,7}};
        int capacity=4;
        System.out.println(carPooling(trips,capacity));
    }

    public static boolean carPooling(int[][] trips, int capacity) {
        int finalDropOff=Integer.MIN_VALUE;
        for(int[] trip: trips){
            finalDropOff=Math.max(trip[2],finalDropOff);
        }
        int[] passengers=new int[finalDropOff+1];
        for(int[] trip: trips){
            passengers[trip[1]]+=trip[0];
            passengers[trip[2]]+=-trip[0];
        }
        //Running Sum
        for(int i=0;i<passengers.length;i++){
            if(i-1>=0){
                passengers[i]=passengers[i-1]+passengers[i];
            }
            if(passengers[i]>capacity) return false;
        }
        for(int i=0;i<passengers.length;i++){
            System.out.print(" "+passengers[i]);
        }
        return true;
    }
}
