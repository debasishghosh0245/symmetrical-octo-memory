public class MinimumBitFlipsToConvertNumber_2220{

    public static void main(String[] args){
        // int start=10;
        // int goal=7;
        int start = 3, goal = 4;
        System.out.println(minBitFlips(start,goal));
    }

    public static int minBitFlips(int start, int goal) {
        int bitDiff=start ^ goal;
        //count number os set bit in bitdiff
        int cnt=0;
        while(bitDiff!=0){
            int rsb=(bitDiff & (-bitDiff));
            bitDiff=bitDiff-rsb;
            cnt++;
        }
        return cnt;
    }
}
