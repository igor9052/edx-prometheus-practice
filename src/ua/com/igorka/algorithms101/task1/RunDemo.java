package ua.com.igorka.algorithms101.task1;

import java.math.BigDecimal;

/**
 * Created by igor on 04.02.15
 * Project name: Task1
 */
public class RunDemo {

    public static final String XX = "1685287499328328297814655639278583667919355849391453456921116729";

    public static final String YY = "7114192848577754587969744626558571536728983167954552999895348492";

    public static final int ITERATIONS = 1;

    public static final String X = "1234";
    public static final String Y = "5678";

    public static void main(String[] args) {


        BigDecimal x = new BigDecimal(XX);
        BigDecimal y = new BigDecimal(YY);

        MathUtil mathUtil = new MathUtil();

        long t1 = System.currentTimeMillis();
        for (int i = 0; i < ITERATIONS; i++) {
            //System.out.println(x.multiply(y));
            //System.out.println(mathUtil.bigMul(XX, YY));
            System.out.println(mathUtil.mulKaratsuba(X, Y));
            //System.out.println(mathUtil.countAdbc("105"));
            System.out.println(mathUtil.countAdbc("3"));
            System.out.println(mathUtil.countAdbc("4"));
            System.out.println(mathUtil.countAdbc("7"));
            System.out.println(mathUtil.countAdbc("16"));
            System.out.println(mathUtil.countAdbc("52"));
            System.out.println(mathUtil.countAdbc("94"));
            System.out.println(mathUtil.countAdbc("2840"));

        }
        long t2 = System.currentTimeMillis();
        System.out.println("Time: " + (t2 - t1));
    }
}
