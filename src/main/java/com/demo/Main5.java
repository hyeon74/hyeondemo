package com.demo;

import java.util.Optional;

public class Main5 {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        // java.util.Supplier<String> sp = ()-> "Hello~!";


        // Optional.ofNullable(null);
        // Optional.ofNullable(1);

        // long longOpt = OptionalLong.of(aa).orElse(0L);
        // System.out.println(longOpt);
        // OptionalLong longOpt = OptionalLong.of(0);
        // retOpt().ifPresentOrElse((a) -> System.out.println("null:" + a) , () -> System.out.println("-null"));
        // System.out.println(a);
        // String stt = retOpt().orElseGet(() -> "null");
        // System.out.println(stt);

        // Long a = null;
        // // Optional<Long> b = Optional.ofNullable(a);
        // Long b = Optional.of(a).orElse(0L);
 
        // System.out.println(b);
    }

    public static Optional<String> retOpt() {
        return Optional.ofNullable(null);
    }


    
}
