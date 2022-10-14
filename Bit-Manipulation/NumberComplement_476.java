public class NumberComplement_476{

    public static void main(String args[]){
        int n=5;
        System.out.println(findComplement(n));
    }
    //Find the position of the Most Significant Bit in num
    public static int calMaxBit(int num){
        int bit=0;
        while(num>0){
            num=num>>1;
            bit++;
        }
        return bit;
    }
    public static int findComplement(int num){
        int ans=0;
        int maxBit=calMaxBit(num);
        for(int bit=0;bit<maxBit;bit++){
            int mask=1<<bit;
            System.out.println(Integer.toBinaryString(mask^num));
            num=mask^num;
        }
        System.out.println("Ans "+Integer.toBinaryString(num));
        return num;
    }
}
