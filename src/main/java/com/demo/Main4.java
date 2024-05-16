package com.demo;

import java.util.Optional;

public class Main4 {
    // public static void main(String[] args) {
        
        Optional<String> opt = Optional.of("hello");
        String str = opt.orElse(anyName());

        String str2 = opt.orElseGet(this::anyName);
    // }Opt
    
    String anyName() {
        System.out.println("reach anyName");
        return "anyName";
    }
}
