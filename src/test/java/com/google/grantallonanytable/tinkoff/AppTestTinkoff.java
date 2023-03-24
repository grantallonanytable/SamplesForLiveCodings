package com.google.grantallonanytable.tinkoff;


import com.google.grantallonanytable.App;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Unit test for simple App.
 */
public class AppTestTinkoff
{
    private static final Logger logger = LoggerFactory.getLogger(App.class);
    /**
     * 123123
     */
    @Test
    public void test1()
    {
        logger.info("Starting test 1...");
        UtilsTin.task1(null);
        logger.info("Starting test 2...");
        UtilsTin.task2(null);
    }

}
