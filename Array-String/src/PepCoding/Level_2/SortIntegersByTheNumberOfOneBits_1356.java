import java.util.*;
public class SortIntegersByTheNumberOfOneBits_1356{

    public static void main(String[] args){
        //int[] arr={0,1,2,3,4,5,6,7,8};
        int[] arr={1024,512,256,128,64,32,16,8,4,2,1};
        System.out.println(Arrays.toString(sortByBits(arr)));
    }
    public static int[] sortByBits(int[] arr) {
        PriorityQueue<Pair> minHeap=new PriorityQueue<>();
        int[] result=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            minHeap.offer(new Pair(countBits(arr[i]),arr[i]));
        }
        System.out.println("MinHeap "+minHeap);
        int i=0;
        while(!minHeap.isEmpty()){
            result[i++]=minHeap.poll().val;
        }
        return result;
    }

    static class Pair implements Comparable<Pair>{
        int key;
        int val;
        Pair(int key,int val){
            this.key=key;
            this.val=val;
        }
        public int compareTo(Pair pair){
            if(pair.key==this.key){
                return this.val-pair.val;
            }else{
                return this.key-pair.key;
            }
        }
        public String toString(){
            return this.key+" "+this.val;
        }
    }
    public static int countBits(int n){
        int count=0;
        while(n>0){
            int rsb=n & -n;
            n=n-rsb;
            count++;
        }
        return count;
    }
}
