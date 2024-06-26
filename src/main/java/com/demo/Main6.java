package com.demo;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Main6 {
    public static void main(String[] args) {
        Supplier<String> sp = () -> "Hello World";
        System.out.println(sp.get());

        Consumer<String> cs = (System.out::println);
        cs.accept("Hello World2");

        Predicate<String> pd = (str) -> str.startsWith("Hello");
        System.out.println(pd.test("Hello World2"));

        Function<String,String> fn = (str) -> str + "aa";
        System.out.println(fn.apply("Hello "));

        UnaryOperator<String> op = (str) -> str + "aa";
        System.out.println(op.apply("Hello "));

        BinaryOperator<String> op2 = (str, str2) -> str + ":" + str2;
        System.out.println(op2.apply("Hello","World"));

    }

    String sp() {
        return "Hello World";
    }
}
