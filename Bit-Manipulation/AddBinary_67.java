public class AddBinary_67{

    public static void main(String[] args){
        String a="1110110101";
        String b="1110111011";
        System.out.println(addBinary(a,b));
    }

    public static String addBinary(String num1,String num2){
        int carry=0;
        int i=num1.length()-1;
        int j=num2.length()-1;
        StringBuilder sb=new StringBuilder();
        while(i>=0 || j>=0){
            int digit1=0;
            int digit2=0;
            if(i>=0){
                 digit1=Integer.parseInt(num1.charAt(i)+"");
            }
            if(j>=0){
                digit2=Integer.parseInt(num2.charAt(j)+"");
            }
            int sum=carry+digit1+digit2;
            sb.insert(0,sum%2);
            carry=sum/2;
            i--;
            j--;
        }
        if(carry>0){
            sb.insert(0,carry);
        }
        System.out.println("StringBuilder >>"+sb.toString());
        return sb.toString();
    }
}
