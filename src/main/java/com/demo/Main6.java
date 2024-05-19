package com.demo;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Main6 {
    
    public static void main(String[] args) {
        Function<String, Integer> size;

        // (obj, x) -> obj.method(x)  
        size = (String s1) ->  s1.length();

        // ClassName::method
        size = String::length;

        int s = size.apply("Hello World"); // 11
        System.out.println(s);

        BiFunction<Main6, String, Integer> fnc = (main, str) -> main.func(str);

        BiFunction<Main6, String, Integer> fnc2 = Main6::func;
        
        
    }

    int func(String str){
        return 1;
    }


}
