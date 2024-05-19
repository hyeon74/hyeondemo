package com.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class Main9 {
    
    public static void main(String[] args) {
        List<String> lst =  new ArrayList<>();

        for(int i=0 ; i < 1000 ; i++) {
            lst.add(String.valueOf(i));
        }
      

        double sTime = System.currentTimeMillis();

        // List<Integer> lst2 = lst.stream()
        // .map((str)->Integer.parseInt(str))
        // .toList();

        double eTime = System.currentTimeMillis();
        
        double diffTime = (eTime - sTime)/1000.0;
        System.out.println(diffTime);


        double sTime2 = System.currentTimeMillis();
        
        List<Integer> lst3 = Optional.ofNullable(lst).stream()
            .flatMap(Collection::stream)
            .map((str)->Integer.parseInt(str))
            .toList();

        List aa = Optional.ofNullable(lst).stream()
            
            // .flatMap(Optional::stream)
            .flatMap(Collection::stream)
            .toList();
            
            System.out.println(aa);
            // .flatMap(Collection::stream)
            // .map((str)->Integer.parseInt(str))    

        double eTime2 = System.currentTimeMillis();

        
        double diffTime2 = (eTime2 - sTime2)/1000.0;

       
        System.out.println(diffTime2);
    }
}
