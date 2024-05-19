package com.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class Main2 {
    public static void main(String[] args) {
        System.out.println("Hello World");
        
        // // 
        // Main2.Cal test = new Main2.Cal();
        // test.print();

        Function<String, Integer> fnc = Main2::func;

        int str = fnc.apply("33");

        System.out.println("str:" + str);

        List<String> strIntList = List.of("1", "2" , "3", "4");

        List<Integer> intList = strIntList.stream()
            .map(Main2::of)
            .toList();

        System.out.println(intList);

        // Arr<String> str1 = new Arr<>("hyeon", "13");
        List<Arr> arr = new ArrayList<>();
        arr.add(new Arr("hyeon", "13"));
        arr.add(new Arr("hyeon2", "15"));
        arr.add(new Arr("hyeon3", "17"));

        Optional<Arr> opt = Optional.ofNullable(null);
        Optional<String> age = opt.map(a -> a.getAge());

        System.out.println("::" + age.isEmpty());
        System.out.println("::" + age.orElse("---"));
        // Function<Arr, Integer> fn = Arr::func3;
        // int aa = fn.apply(arr.get(0));
        // System.out.println(aa);

        // BiFunction<Arr, String, Integer> fn2 = Arr::func4;

        // List<Integer> sIntegersList = arr.stream()
        //     // .map((f) -> f.func2(f.age))
        //     // .map((f) -> f.func3(f))
        //     .map((ar) -> ar.func4(ar.getAge()))
        //     .toList();

        // System.out.println(" sIntegersList:" + sIntegersList);

    }

    

    static class Cal {
        static int val = 0;
        int print() {
            System.out.println("Hello World2");
            return 0;
        }
    }

    static int func(String str) {
        return Integer.parseInt(str);
    }

    static int of(String str) {
        return Integer.parseInt(str);
    }

    // Main2 main = new Main2();

    
    
    


    

    

    // <T> void preFunc2(List<? super Number> list) {
        
    // }

    // <T> void preFunc(Predicate<? super T> t) {
        
    // }

    
}

class Arr {
    String name;
    String age;
    int ageInt;

    public String getAge() {
        return age;
    }

    public int getAgeInt() {
        return ageInt;
    }

    Arr(String name, String age) {
        this.name = name;
        this.age = age;
    }

    int func2(String arr) {
        return Integer.parseInt(arr);
    }

    static int func3(Arr arr) {
        return Integer.parseInt(arr.age);
    }

    int func4(String arr) {
        return Integer.parseInt(arr);
    }
}
