package com.demo;

public class Main4 {

    public static void main(String[] args) {
        Target adapter = new Adapter();
    
        adapter.method(10);
    }
    
}

class Service {
    void specificMethod() {
        System.out.println("기존서비스 기능 호출");

    }
}

interface Target {
    void method(int data);

}

class Adapter extends Service implements Target {

    @Override
    public void method(int data) {
        System.out.println("데이터 전달");
        specificMethod();
    }
   
    
}
