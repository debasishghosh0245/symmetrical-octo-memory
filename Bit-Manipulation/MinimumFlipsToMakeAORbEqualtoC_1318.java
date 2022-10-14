public class MinimumFlipsToMakeAORbEqualtoC_1318{

    public static void main(String[] args){
        //int a=2,b=6,c=5;
        //int a = 4, b = 2, c = 7;
        int a = 1, b = 2, c = 3;
        System.out.println(countFlips(a,b,c));
    }

    public static int countFlips(int a,int b,int c){
        int count=0;
        for(int bit=0;bit<32;bit++){
            int b1=0,b2=0,b3=0;
            int mask = 1 << bit;
            if((mask & a)>=1)  b1=1;
            if((mask & b)>=1)  b2=1;
            if((mask & c)>=1)  b3=1;
            count+=(b1 & b2) & (b3 ^ (b1 | b2));
            count+=b3 ^ (b1 | b2);
        }
        return count;
    }
}
