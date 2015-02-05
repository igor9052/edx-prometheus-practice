package ua.com.igorka.algorithms101.task1;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.Arrays;

/**
 * Created by igor on 04.02.15
 * Project name: Task1
 */
public class MathUtil {

    private String [] mulTable = new String[10];
    private String x;
    private String y;

    public String bigMul(String v1, String v2) {
        if (v1.length() < v2.length()) {
            x = v2;
            y = v1;
        }
        else {
            x = v1;
            y = v2;
        }
        initMulTable(x);
        String result;

        result = mulTable[Character.getNumericValue(y.charAt(y.length() - 1))];
        for (int i = y.length() - 2; i >=0; i--) {
            result = plus(result, mulTable[Character.getNumericValue(y.charAt(i))], y.length()-i-1);
        }

        return result;
    }

    private void initMulTable(String value) {
        mulTable[0] = "0";
        mulTable[1] = value;
        for (int i = 2; i <10; i++){
            mulTable[i] = initMul(value, i);
        }
    }

    private String initMul(String valueX, int valueY) {
        int tail = 0;
        char [] x = valueX.toCharArray();
        char [] result = new char[valueX.length() + 1];
        for (int i = valueX.length() - 1; i >= 0; i--){
            int z = Character.getNumericValue(x[i]) * valueY + tail;
            if (z > 9) {
                tail = getOldDigit(z);
                for (int k = 0; k < tail; k++) {
                    z -= 10;
                }
            } else {
                tail = 0;
            }
            result[i+1] = (char)(z + 48);
        }
        if (tail > 0) {
            result[0] = (char)(tail + 48);
        }
        else {
            result[0] = 0;
        }

        String resultValue = String.valueOf(result);
        if (tail == 0) {
            return resultValue.substring(1);
        }
        return resultValue;
    }

    private String plus(String result, String y, int n) {
        if ("0".equals(y)) {
            return result;
        }
        int length = y.length()+ n + 1;
        char[] r1 = result.toCharArray();
        char[] y1= y.toCharArray();
        char[] newResult = new char[length];
        int pointerR1 = r1.length - 1;
        int pointerY = y1.length - 1;
        int pointerNewResult = newResult.length - 1;

        for (int i = 0; i < n; i++) {
            newResult[pointerNewResult] = r1[pointerR1];
            pointerNewResult--;
            pointerR1--;
        }

        int tail = 0;

        while (pointerR1 >= 0) {
            int temp = Character.getNumericValue(r1[pointerR1]) + Character.getNumericValue(y1[pointerY]) + tail;
            if (temp > 9) {
                tail = 1;
                temp = temp - 10;
            }
            else {
                tail = 0;
            }
            newResult[pointerNewResult] = (char)(temp + 48);
            pointerNewResult--;
            pointerR1--;
            pointerY--;
        }

        while (pointerY >= 0) {
            int temp = Character.getNumericValue(y1[pointerY]) + tail;
            if (temp > 9) {
                tail = 1;
                temp = temp - 10;
            }
            else {
                tail = 0;
            }
            newResult[pointerNewResult] = (char)(temp + 48);
            pointerNewResult--;
            pointerY--;
        }
        if (tail > 0){
            newResult[pointerNewResult] = '1';
        }
        else {
            newResult[pointerNewResult] = '0';
        }

        String stringResult = String.valueOf(newResult);

        if (tail > 0) {
            return stringResult;
        }
        else {
            return stringResult.substring(1);
        }
    }

    /*This method return the old digit of two-dimension number
    * if value = 56, return 5; value = 16,return 1;*/
    private int getOldDigit(int value) {
        int result = 0;
        do {
            value -= 10;
            result++;
        } while (value > 9);
        return  result;
    }






























    private String mul(String x, String y) {
        int x1 = Integer.parseInt(x);
        int y1 = Integer.parseInt(y);
        return String.valueOf(x1 * y1);
    }

    private String powerTenN(String value, int n) {
        if (n == 0) {
            return value;
        }

        String zeroTail = "";
        for (int i = 0; i < n; i++) {
            zeroTail = zeroTail.concat("0");
        }
        return value.concat(zeroTail);
    }

    private String add(String v1, String v2) {
        int n = v1.length() < v2.length() ? Integer.parseInt(v1) : Integer.parseInt(v2);
        return "";
    }



    private int ac(int a, int c) {
        return a * c;
    }

    private int bd(int b, int d) {
        return b * d;
    }

    /* (a+b)(c+d) */
    private int third(int a, int b, int c, int d) {
        return (a + b)*(c + d);
    }

    public int ad_plus_bd(){
         return 1;
    }




}
