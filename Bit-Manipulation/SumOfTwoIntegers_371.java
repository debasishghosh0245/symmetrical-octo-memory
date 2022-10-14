public class SumOfTwoIntegers_371{

    public static void main(String args[]){
        int a=2;
        int b =3;
        System.out.println(sum(a,b));
    }

    public static int sum(int a,int b){
        int carry=a&b<<1;
        int sumWithOutCarry=a^b;
        while(carry!=0){
            sumWithOutCarry=a^b;
            carry=a&b;
            carry=carry<<1;
            a=sumWithOutCarry;
            b=carry;
        }
        return sumWithOutCarry;
    }
}
