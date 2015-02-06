package ua.com.igorka.algorithms101.task1;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.math.BigDecimal;

/**
 * Created by igor on 04.02.15
 * Project name: Task1
 */
public class RunDemo {

    public static final String Y = "1234";
    public static final String X = "5678";

    public static final String XX = "1330682774087918085669680039151046903893418011526021625695688898558125310188636840" +
            "31659492040318276821625695688898558125310188636840316594920403182768" +
            "31659492040318276821625695688898558125310188636840316594920403182768";

    public static final String YY = "1330682774087918085669680039151046903893418011526021625695688898558125310188636840" +
            "31659492040318276821625695688898558125310188636840316594920403182768";

    public static final int ITERATIONS = 1;


    public static void main(String[] args) {


        BigDecimal x = new BigDecimal(X);
        BigDecimal y = new BigDecimal(Y);

        MathUtil mathUtil = new MathUtil();

        //System.out.println(mathUtil.plus("100", "1120"));
        System.out.println(mathUtil.mulK(X, Y));



//        System.out.println(x.subtract(y));
//

//
//        long t1 = System.currentTimeMillis();
//        for (int i = 0; i < ITERATIONS; i++) {
//            System.out.println(mathUtil.bigMul(XX, YY));
//            //mathUtil.bigMul(XX, YY);
//        }
//        long t2 = System.currentTimeMillis();
//        System.out.println("Time: " + (t2 - t1));
//
//        t1 = System.currentTimeMillis();
//        for (int i = 0; i < ITERATIONS; i++) {
//            System.out.println(x.multiply(y));
//            //x.multiply(y);
//        }
//        t2 = System.currentTimeMillis();
//        System.out.println("Time: " + (t2 - t1));



        System.out.println();


    }
}
