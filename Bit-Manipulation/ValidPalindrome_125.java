public class ValidPalindrome_125{

    public static void main(String[] args){
        //String str="race a car";
        //String str=" ";
        //String str=",.";
        String str="0P";
        System.out.println(isValidPalidrome(str));
    }
    public static boolean isValidPalidrome(String str){
        int i=0;
        int j=str.length()-1;
        while(i<j){
            while(i<str.length() && !Character.isDigit(str.charAt(i))
                && !Character.isLetter(str.charAt(i))) i++;
            while(j>=0 && !Character.isDigit(str.charAt(j))
                && !Character.isLetter(str.charAt(j))) j--;
            System.out.println("i "+i);
            System.out.println("j "+j);
            if(i >= str.length() && j < 0) return true;
            char ch1=str.charAt(i);
            char ch2=str.charAt(j);
            if(Character.toUpperCase(ch1)!=Character.toUpperCase(ch2)) return false;
            i++;
            j--;
        }
        return true;
    }
}
