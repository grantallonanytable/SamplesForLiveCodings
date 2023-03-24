package com.google.grantallonanytable.alphaInsur;


import com.google.grantallonanytable.App;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
        logger.info("Starting test...");
        Assertions.assertEquals(t1(), 22);
        System.out.println("Finished.");
    }

    public Integer t1() {
        Integer[][] mat = {{1,2,3},
                           {2,3,4},
                           {5,6,7}};
        Integer sum = 0;
        for (int ind = 0; ind < mat.length; ind++) {
            sum += mat[ind][ind];
            sum += mat[ind][mat.length - ind - 1];
        }
        return sum;
    }

}
