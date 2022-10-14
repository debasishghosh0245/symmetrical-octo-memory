public class FlipBitsToConvertAToB{

    public static void main(String[] args){
        int a=57;
        int b=76;
        System.out.println(flipBitsCnt(a,b));
    }
    public static int flipBitsCnt(int a,int b){
        int c=a^b;
        int cnt=0;
        while(c!=0){
            int rsb=c & -c;
            c=c-rsb;
            cnt++;
        }
        return cnt;
    }
}
