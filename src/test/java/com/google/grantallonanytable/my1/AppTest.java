package com.google.grantallonanytable.my1;

import com.google.grantallonanytable.App;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private static final Logger logger = LoggerFactory.getLogger(App.class);
    /**
     * 123123
     */
    @Test
    public void test1()
    {
        logger.info("Демонстрация сравнения эффективности работы методов на примере парсинга разрядов чисел");
        main();
    }

    @Test
    public void test2()
    {
        logger.info("Демонстрация парсинга разрядов чисел");
        int a = (int) (1000000 * Math.random());
        System.out.printf("a=%d; method 1 result=%s%n", a, checkSum1(a));
        System.out.printf("a=%d; method 2 result=%s%n", a, checkSum2(a));
        int b = (int) (1000 * Math.random());
        b = b*1000 + 100*(b%10) + 10*((b/10)%10) + (b/100);
        System.out.printf("b=%d; method 1 result=%s%n", b, checkSum1(b));
        System.out.printf("b=%d; method 2 result=%s%n", b, checkSum2(b));
        int c = (int) (100 * Math.random());
        c = c*1000 + 100*(c%10) + 10*((c/10)%10) + (c/100);
        System.out.printf("c=%d; method 1 result=%s%n", c, checkSum1(c));
        System.out.printf("c=%d; method 2 result=%s%n", c, checkSum2(c));
    }

    public static void main() {
        effectiveTest();
    }

    private static void effectiveTest() {
        final int counts = 100000;
        long timeStart = System.nanoTime();
        for(int j=0; j<counts; j++) checkSum1((int) (1000000 * Math.random()));
        System.out.printf("Function1 %d ms per operation\n", (System.nanoTime() - timeStart)/counts);
        timeStart = System.nanoTime();
        for(int j=0; j<counts; j++) checkSum2((int) (1000000 * Math.random()));
        System.out.printf("Function1 %d ms per operation\n", (System.nanoTime() - timeStart)/counts);
    }

    private static boolean checkSum1(Integer a) {
        int sum = 0;
        int sign = 1;
        int number = a;
        for(int index = 1; a>0; index++) {
            if (index == 4) {
                sign = -1;
            }
            sum = sum + sign * a%10;
            a /= 10;
        }
        return sum == 0;
    }

    private static boolean checkSum2(Integer a) {
        List<Integer> digits = Arrays.stream(a.toString().split("(?!^)")).map(Integer::parseInt).collect(toList());
        // System.out.printf("Initial list: %s\n", digits.stream().map(Object::toString).collect(joining()));
        for(int index = digits.size() + 1; index<7; index ++) {
            digits.add(0, 0);
        }
        // System.out.printf("List with leading zeros: %s\n", digits.stream().map(Object::toString).collect(joining()));
        final int sum1 = digits.get(0) + digits.get(1) + digits.get(2);
        final int sum2 = digits.get(3) + digits.get(4) + digits.get(5);
        return sum1 == sum2;
    }

}
