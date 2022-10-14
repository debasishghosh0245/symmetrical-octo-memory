public class PrintValueOfRsbMask{

    public static void main(String[] args){
        int n=58;
        System.out.println(Integer.toBinaryString(n & -n));
    }
}
