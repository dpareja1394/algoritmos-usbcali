import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class AdditionMagic{
    public String add(double a, String b) {
        return String.valueOf(a).concat(b);
    }

    public String add(double a, double b) {
        BigDecimal num1 = new BigDecimal(String.valueOf(a)).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal num2 = new BigDecimal(String.valueOf(b)).setScale(2, BigDecimal.ROUND_HALF_UP);
        double suma = (num1.add(num2)).doubleValue();
        return String.valueOf(suma);
    }

    public String add(String a, String b) {
        return a.concat(b);
    }
}
public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        String sub = sc.nextLine();
        int n = Integer.parseInt(sub);
        for(int i=0;i<n;i++) {
            String[] temp = sc.nextLine().split(" ");
            Boolean  firstDouble = isFloat(temp[0]);
            Boolean  secondDouble = isFloat(temp[1]);
            AdditionMagic additionMagic = new AdditionMagic();
            if(firstDouble && secondDouble){
                System.out.println(additionMagic.add(Double.parseDouble(temp[0]), Double.parseDouble(temp[1])));
            }else {
                System.out.println(additionMagic.add(temp[0], temp[1]));
            }
        }
    }
    private static final Pattern DOUBLE_PATTERN = Pattern.compile(
            "[\\x00-\\x20]*[+-]?(NaN|Infinity|((((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)" +
                    "([eE][+-]?(\\p{Digit}+))?)|(\\.((\\p{Digit}+))([eE][+-]?(\\p{Digit}+))?)|" +
                    "(((0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+)))" +
                    "[pP][+-]?(\\p{Digit}+)))[fFdD]?))[\\x00-\\x20]*");

    public static boolean isFloat(String s)
    {
        return DOUBLE_PATTERN.matcher(s).matches();
    }
}