package com.google.grantallonanytable.yaPrac1;

import com.google.grantallonanytable.App;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        logger.info("Yandex(1)");
        main();
    }

    public static void main() {
        robotMove("DLL");
        robotMove("DLLUUU");
        robotMove("DLLUUURRRR");
        robotMove("DLLUUURRRRDDDDD");
        robotMove("DLLUUURRRRDDDDDLLLLLLUUUUUUUURRRRRRRRDDDDDDDDD");
    }

    private static void robotMove(String code) {
        logger.info("Command line: {}", code);
        int maxRight = 0;
        int minLeft = 0;
        int minUp = 0;
        int maxDown = 0;
        int x = 0;
        int y = 0;
        // Вычисление размера области движения. В общем случае движение робота начинается где-то внутри области (не в углу)
        String[] commands = code.toUpperCase().split("");
        for(String s: commands) {
            switch (s) {
                case "L": x--; break;
                case "R": x++; break;
                case "U": y--; break;
                case "D": y++; break;
                default: logger.error("Invalid input {}", s);
            }
            minLeft = Math.min(minLeft, x);
            maxRight = Math.max(maxRight, x);
            minUp = Math.min(minUp, y);
            maxDown = Math.max(maxDown, y);
        }
        logger.info("minLeft={},maxRight={},minUp={},maxDown={}", minLeft, maxRight, minUp, maxDown);
        // Размер области maxRight-minLeft * maxDown-minup
        List<String> zeros = Stream.generate(() -> "_").limit(maxRight - minLeft + 1).collect(toList());
        List<List<String>> field = Stream.generate(() -> new ArrayList<>(zeros)).limit(maxDown - minUp + 1).collect(toList());
        x = 0;
        y = 0;
        // Заполнение поля
        for(String command: commands) {
            switch (command) {
                case "L": x--; break;
                case "R": x++; break;
                case "U": y--; break;
                case "D": y++; break;
                default: logger.error("Invalid input {}", command);
            }
            // пометить текущую точку
            field.get(y - minUp).set(x - minLeft, "*");
            //logger.info("Command {}:", command);
            //printField(field);
        }
        // пометить начало
        field.get(-minUp).set(-minLeft, "#");
        printField(field);
    }

    private static void printField(List<List<String>> field) {
        logger.info(field.stream().map(line -> String.join("", line)).collect(Collectors.joining("\n", "\n", "\n")));
    }

}
