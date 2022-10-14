public class CountSetBitsInFirstNNaturalNumbers{

    public static void main(String[] args){
        int n=6;
        System.out.println(Integer.toBinaryString(n & -n));
    }
}
