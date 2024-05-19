package com.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalInt;

import lombok.Getter;

public class Main7 {

    public static void main(String[] args) {
        // Function<Arr, Integer> fn = Arr::func4;
        // int aa = fn.apply(arr.get(0));
        // System.out.println(aa);

        // BiFunction<Arr, String, Integer> fn2 = Arr::func4;

        List<Arr2> arr = new ArrayList<>();

//        Arr2 aaa = new Arr2("hyeon2", "15", 11);
         arr.add(new Arr2("hyeon", "13"));
         arr.add(new Arr2("hyeon2", "15", 11));
         arr.add(new Arr2("hyeon3", "17"));

         Arr2 arr9 = new Arr2("hyeon", "13");

         OptionalInt optInt = OptionalInt.empty();
//         System.out.println("int:" + optInt.orElse(9));

        Integer a = null;
//        System.out.println(a.toString());
        System.out.println(String.valueOf(a));
//        System.out.println("INT:" + Integer.valueOf(null));

        System.out.println((Objects.nonNull(null)));

//        System.out.println(arr9.getAgeInt());
//         int arrStr = arr9.getAgeInt();
         Integer arrStr9 = Optional.ofNullable(arr9.getAgeInt()).orElse(10);

//         OptionalInt test = ;
//         System.out.println("test:" + arr9.getAgeInt()!=null?arr9.getAgeInt():9);
        if(arr9.getAgeInt()!=null){
            System.out.println(arr9.getAgeInt());
        }
//         System.out.println(((arr9.getAgeInt())!=null)?1:0 );
//         Objects.isNull(null);
         List<Integer> sIntegersList = arr.stream()
             // .map((f) -> f.func2(f.age))
             // .map((f) -> f.func3(f))
             .map((ar) -> Optional.ofNullable(ar.getAgeInt()).orElse(0))
             .toList();

        // int test;
        // String.valueOf(test);
         System.out.println(" sIntegersList:" + sIntegersList);

         String ssss = null;
//        System.out.println((ssss.isBlank())?"0000":ssss);

//        System.out.println();

        // Arr a = new Arr("hyeon", "13");
        // System.out.println(a.getAgeInt());
        System.out.println("#####1:" + Optional.ofNullable("null").orElse(Str.str()));
//        System.out.println("#####2:" + Optional.ofNullable("null").orElseGet(Str::str));
    }
    
}

class Str {
    Str() {
        System.out.println("str");
    }
    static String str() {
        System.out.println("-------str");
        return "str";
    }
}

@Getter
class Arr2 {
    String name;
    String age;
    Integer ageInt;

//    public String getAge() {
//        return age;
//    }
//
//    public Integer getAgeInt() {
//        return ageInt;
//    }

    Arr2(String name, String age) {
        this.name = name;
        this.age = age;
    }

    Arr2(String name, String age, Integer ageInt) {
        this.name = name;
        this.age = age;
        this.ageInt = ageInt;
    }

    int func2(String arr) {
        return Integer.parseInt(arr);
    }

    static int func3(Arr2 arr) {
        return Integer.parseInt(arr.age);
    }

    int func4(String arr) {
        return Integer.parseInt(arr);
    }

}
