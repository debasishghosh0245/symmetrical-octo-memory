public class CopySetBitsInARange{
    public static void main(String[] args){
        int a=10;
        int b=13;
        int left=2;
        int right=3;
        int ans=copySetBit(a,b,left,right);
        System.out.println(ans);
    }
    public static int copySetBit(int a,int b,int left,int right){
        int mask=1<<(right-left+1);
        mask=(mask-1) << (left-1);
        a=a & mask;
        return (a | b);
    }
}
