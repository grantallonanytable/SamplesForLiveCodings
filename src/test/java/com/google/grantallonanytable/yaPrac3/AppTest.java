package com.google.grantallonanytable.yaPrac3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AppTest {
    List<ClassA> list = new ArrayList();

    @Test
    void myTest1() {
        list.add(new ClassA());
        list.add(new ClassA("a1"));
        list.add(new ClassB());
        list.add(new ClassC());
        list.add(new ClassC());
        System.out.println(getAll() .stream().map(Object::toString).collect(Collectors.joining(";\n","All=[\n","\n]")));
        System.out.println(getAllA().stream().map(Object::toString).collect(Collectors.joining(";\n","A=[\n","\n]")));
        System.out.println(getAllB().stream().map(Object::toString).collect(Collectors.joining(";\n","B=[\n","\n]")));
        System.out.println(getAllC().stream().map(Object::toString).collect(Collectors.joining(";\n","C=[\n","\n]")));
    }

    List<ClassA> getAll() {
        return list;
    }

    List<ClassA> getAllA() {
        return list.stream()
                .filter(data -> ClassA.class.getSimpleName().equals(data.getClass().getSimpleName()))
                .collect(Collectors.toList());
    }

    List<ClassB> getAllB() {
        return list.stream().filter(ClassB.class::isInstance).map(ClassB.class::cast).collect(Collectors.toList());
    }

    List<ClassC> getAllC() {
        return list.stream().filter(ClassC.class::isInstance).map(ClassC.class::cast).collect(Collectors.toList());
    }

    private static class ClassA {
        String fieldA;
        public ClassA() {
            fieldA = "a";
        }

        public ClassA(String value) {
            fieldA = value;
        }
        public String toString() {
            return String.format("{field-a=\"%s\"}", fieldA);
        }
    }

    private static class ClassB extends ClassA {
        String fieldB;
        public ClassB() {
            fieldA = "class-b";
            fieldB = "b";
        }
        public String toString() {
            return String.format("{field-a=\"%s\", field-b=\"%s\"}", fieldA, fieldB);
        }
    }

    private static class ClassC extends ClassA {
        String fieldC;
        public ClassC() {
            super(null);
            fieldC = "ccc";
        }
        public String toString() {
            return String.format("{field-a=\"%s\", field-c=\"%s\"}", fieldA, fieldC);
        }
    }
}
