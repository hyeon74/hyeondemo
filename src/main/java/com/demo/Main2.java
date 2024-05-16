package com.demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.ToString;

public class Main2 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // System.out.println("####");   
        // // 직렬화할 고객 객체
        // Customer customer = new Customer(1, "홍길동", "123123", 40);

        // // 외부 파일명
        // String fileName = "Customer.ser";

        // // 파일 스트림 객체 생성 (try with resource)
        // try (
        //         FileOutputStream fos = new FileOutputStream(fileName);
        //         ObjectOutputStream out = new ObjectOutputStream(fos)
        // ) {
        //     // 직렬화 가능 객체를 바이트 스트림으로 변환하고 파일에 저장
        //     out.writeObject(customer);

        // } catch (IOException e) {
        //     e.printStackTrace();
        // }

        // 직렬화할 고객 객체
        Customer hongildong = new Customer(1, "홍길동", "123123", 40);
        Customer sejong = new Customer(2, "세종대왕", "4556456", 55);
        Customer jumong = new Customer(3, "주몽", "789789", 25);

        // 외부 파일명
        String fileName = "Customer.ser";

        // 리스트 생성
        List<Customer> customerList = new ArrayList<>();
        customerList.add(hongildong);
        customerList.add(sejong);
        customerList.add(jumong);

        // 리스트 자체를 직렬화 하기
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream out = new ObjectOutputStream(fos);
        out.writeObject(customerList);
        
        out.close();

        // 역직렬화 하여 리스트 객체에 넣기
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream in = new ObjectInputStream(fis);
        List<Customer> deserializedCustomerList = (List<Customer>) in.readObject();
        
        in.close();
        
        System.out.println(deserializedCustomerList);


    }
}

@ToString
@AllArgsConstructor
class Customer implements Serializable {
    int id; // 고객 아이디
    String name; // 고객 닉네임
    String password; // 고객 비밀번호
    int age; // 고객 나이

    // public Customer(int id, String name, String password, int age) {
    //     this.id = id;
    //     this.name = name;
    //     this.password = password;
    //     this.age = age;
    // }

    // @Override
    // public String toString() {
    //     return "Customer{" +
    //             "id=" + id +
    //             ", password='" + password + '\'' +
    //             ", name='" + name + '\'' +
    //             ", age=" + age +
    //             '}';
    // }
}

