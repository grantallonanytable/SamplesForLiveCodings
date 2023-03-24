package com.google.grantallonanytable.myKt

import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*
import java.util.function.Function
import java.util.stream.Collectors

class AppTest {

    /**
     * 123123
     */
    @Test
    fun test1() {
        System.out.println("Стрингофикация")
        val dataA = DataA(
            "some string",
            42,
            mapOf("key1" to "val1", "key2" to "val2"),
            listOf(DataA1("now", LocalDateTime.now())),
            listOf(DataA2(1, BigDecimal.TEN))
        )

        val dataB = DataB(
            "some string?",
            42,
            mapOf("keyA" to "val1", "keyB" to "val2"),
            listOf(DataA1("yesterday", LocalDateTime.now().minusDays(1))),
            listOf(DataA2(1, BigDecimal.TEN)),
            mapOf("a" to 65, "b" to 66),
            listOf(DataB1(42))
        )

        System.out.println("data A")
        System.out.println(dataA)
        System.out.println("data B")
        System.out.println(dataB)
    }


    fun main() {
        test1()
    }

}
