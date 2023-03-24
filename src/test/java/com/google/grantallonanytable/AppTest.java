package com.google.grantallonanytable;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

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
        Assertions.assertTrue(BigDecimal.TEN.intValue() == 10);
        Assertions.assertEquals(1.000, 1);
    }

}
