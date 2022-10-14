public class Visa_StrigDivisiblityTest{
    public static void main(String[] args){
        String s1="abcabc";
        String s2="abcd";

        if(!(s1+s2).equals(s2+s1)) {
            System.out.println(" ");
        }
        else{
            String gstOfSTR=s1.substring(0,findGCD(s1.length(),s2.length()));
            System.out.println(gstOfSTR);
        }
    }

    public static int findGCD(int s1,int s2){
        if(s1%s2==0) return s2;
        return findGCD(s2,s1%s2);
    }


}
