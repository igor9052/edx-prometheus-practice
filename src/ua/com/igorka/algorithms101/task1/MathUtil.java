package ua.com.igorka.algorithms101.task1;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.Arrays;

/**
 * Created by igor on 04.02.15
 * Project name: Task1
 */
public class MathUtil {

    private String[] mulTable = new String[10];
    private String x;
    private String y;

    public String bigMul(String v1, String v2) {
        if (v1.length() < v2.length()) {
            x = v2;
            y = v1;
        } else {
            x = v1;
            y = v2;
        }
        initMulTable(x);
        String result;
        result = mulTable[Character.getNumericValue(y.charAt(y.length() - 1))];
        for (int i = y.length() - 2; i >= 0; i--) {
            result = plus(result, mulTable[Character.getNumericValue(y.charAt(i))], y.length() - i - 1);
        }

        return result;
    }

    /*This method init mul table which contains 10 numbers:
    * x * 0
    * x * 1
    * x * 2
    * .....
    * x * 9
    * It has done once and then it is used for adding*/
    private void initMulTable(String value) {
        mulTable[0] = "0";
        mulTable[1] = value;
        for (int i = 2; i < 10; i++) {
            mulTable[i] = initMul(value, i);
        }
    }

    /*This method helps to init mul table (see initMulTable method):
    * x * 2
    * .....
    * x * 9
    * It has done once and then it is used for adding*/
    private String initMul(String valueX, int valueY) {
        int tail = 0;
        char[] x = valueX.toCharArray();
        char[] result = new char[valueX.length() + 1];
        for (int i = valueX.length() - 1; i >= 0; i--) {
            int z = Character.getNumericValue(x[i]) * valueY + tail;
            if (z > 9) {
                tail = getOldDigit(z);
                for (int k = 0; k < tail; k++) {
                    z -= 10;
                }
            } else {
                tail = 0;
            }
            result[i + 1] = (char) (z + 48);
        }
        if (tail > 0) {
            result[0] = (char) (tail + 48);
        } else {
            result[0] = 0;
        }

        String resultValue = String.valueOf(result);
        if (tail == 0) {
            return resultValue.substring(1);
        }
        return resultValue;
    }
    /*Adding two numbers which are presented by Strings
    * n - shift of Y relatively X (result) from right to left
    * X = 678956, Y = 345678, n = 3 then:
    *    678956  : X
    * 345678     : Y shifted by 3
    * 346356956  : Result (sum of X and Y)
    * */
    private String plus(String result, String y, int n) {
        if ("0".equals(y)) {
            return result;
        }
        int length;
        if (n == 0) {
            length = Integer.max(y.length(), result.length()) + 1;
        } else {
          length = Integer.max(y.length() + n, result.length()) + 1;
        }

        char[] r1 = result.toCharArray();
        char[] y1 = y.toCharArray();
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

        while (pointerR1 >= 0 && pointerY >= 0) {
            int temp = Character.getNumericValue(r1[pointerR1]) + Character.getNumericValue(y1[pointerY]) + tail;
            if (temp > 9) {
                tail = 1;
                temp = temp - 10;
            } else {
                tail = 0;
            }
            newResult[pointerNewResult] = (char) (temp + 48);
            pointerNewResult--;
            pointerR1--;
            pointerY--;
        }

        while (pointerY >= 0) {
            int temp = Character.getNumericValue(y1[pointerY]) + tail;
            if (temp > 9) {
                tail = 1;
                temp = temp - 10;
            } else {
                tail = 0;
            }
            newResult[pointerNewResult] = (char) (temp + 48);
            pointerNewResult--;
            pointerY--;
        }

        while (pointerR1 >= 0) {
            int temp = Character.getNumericValue(r1[pointerR1]) + tail;
            if (temp > 9) {
                tail = 1;
                temp = temp - 10;
            } else {
                tail = 0;
            }
            newResult[pointerNewResult] = (char) (temp + 48);
            pointerNewResult--;
            pointerR1--;
        }

        if (tail > 0) {
            newResult[pointerNewResult] = '1';
        } else {
            newResult[pointerNewResult] = '0';
        }

        String stringResult = String.valueOf(newResult);

        if (tail > 0) {
            return stringResult;
        } else {
            return stringResult.substring(1);
        }
    }

    public String plus(String x, String y) {
        return plus(x, y, 0);
    }

    /*This method return the old digit of two-dimension number
    * if value = 56, return 5; value = 16,return 1;*/
    private int getOldDigit(int value) {
        int result = 0;
        do {
            value -= 10;
            result++;
        } while (value > 9);
        return result;
    }

    public String minus(String x, String y) {
        char [] cx = x.toCharArray();
        char [] cy = y.toCharArray();
        char [] r1 = new char[x.length()];
        int pointerX = x.length() - 1;
        int pointerR = x.length() - 1;
        int pointerY = y.length() - 1;
        int tail = 0;
        while (pointerY >= 0) {
            int r = Character.getNumericValue(cx[pointerX]) - tail - Character.getNumericValue(cy[pointerY]);
            if (r < 0) {
                r = r + 10;
                tail = 1;
            }
            else {
                tail = 0;
            }
            r1[pointerR] = (char)(r + 48);
            pointerR--;
            pointerX--;
            pointerY--;
        }

        while (pointerX >= 0) {
            int n = Character.getNumericValue(cx[pointerX]) - tail;
            if (n < 0) {
                n = n + 10;
                tail = 1;
            }
            else {
                tail = 0;
            }
            r1[pointerR] = (char)(n + 48);
            pointerR--;
            pointerX--;
        }
        String result = String.valueOf(r1);
        int i = 0;
        for (; i < result.length() -1; i++) {
            if (!"0".equals(result.substring(i,i+1))) {
                break;
            }
        }
        if (i > 0) {
            return result.substring(i);
        }
        return result;
    }

    /*****************KARATSUBA method******************/


    public String mulK(String x, String y) {
        if (x.length() == 1 && y.length() == 1) {
            return mul(x, y);
        }
        return cutNumber(x, y);
    }

    private String cutNumber(String x, String y) {
        String a = x.substring(0, x.length() / 2);
        String b = x.substring(x.length() / 2, x.length());
        String c = y.substring(0, y.length() / 2);
        String d = y.substring(y.length() / 2, y.length());
        return abcd(a,b,c,d,x.length());
    }

    private String abcd(String a, String b, String c, String d, int n) {
        String ac = mulK(a, c);
        String bd = mulK(b, d);
        String ad_bc = mulK(plus(a, b), plus(c, d)); // need to implement
        ad_bc = minus(ad_bc, ac);
        ad_bc = minus(ad_bc, bd);
        String r1 = powerTenN(ac, n);
        String r2 = powerTenN(ad_bc, n / 2);
        String result = plus(r1, r2);
        result = plus(result, bd);
        return result;
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
}
