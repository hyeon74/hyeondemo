package com.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main3 {

    public Set<String> getTeamClubNames(List<Member> members){
                    return members.stream() // (0)
                    .map(Member::getTeam) // (1)
                    .map(optTeam -> optTeam.flatMap(Team::getClub)) // (2)
                    .map(optClub -> optClub.map(Club::getName)) // (3)
                    .flatMap(Optional::stream) // (4)
                    .collect(Collectors.toSet()); // 스트림에서 값을 꺼내 중복되지 않도록 Set으로 모아줍니다.
    }

    public List<String> getTeamClubNames2(List<Member> members){
        return members.stream() // (0)
                .map(Member::getTeam) // (1)
                .map(team -> team.flatMap(Team::getClub)) // (2)
                .map(club -> club.map(Club::getName))
                .flatMap(Optional::stream)// (3)/ (4)
                .toList();
                //.collect(Collectors.toSet()); // 스트림에서 값을 꺼내 중복되지 않도록 Set으로 모아줍니다.
    }

    public static void main(String[] args) {

        List<Integer> list1 = List.of(1, 2, 3);
        List<Integer> list2 = List.of(4, 5, 6);
        List<Integer> list3 = List.of(7, 8, 9);

        List<Map<String, String>> list4 = new ArrayList<>();

        for(int i = 1 ; i < 10001 ; i++) {
            Map<String, String> mm = new HashMap<>();
            String key = "key_" + String.valueOf(i);
            String value = "value_" + String.valueOf(i);
            mm.put(key, value);
            list4.add(mm);
        }

        // List<List<Integer>> listOfLists = List.of(list1, list2, list3);

        // long sTime = System.currentTimeMillis();

        // List<String> listOfAllIntegers = listOfLists.stream()
        //         .map(List::toString)
        //         .toList();

        // long eTime = System.currentTimeMillis();

        // long elapsedTime = eTime - sTime;

        // System.out.println("elapsedTime : " + elapsedTime / 1000.0);

        // list3 = null;

        // Integer lst = Optional.ofNullable(list3).orElseGet(ArrayList::new)
        //         .stream()
        //         .filter(i -> (i == 7))
        //         .findAny()
        //         .orElse(0);

        // Integer llst = Optional.ofNullable(list3)
        //         .flatMap(ss -> ss.stream()
        //                 .filter(i -> (i == 7))
        //                 .findAny())
        //         .orElse(0);

        // long sTime2 = System.currentTimeMillis();
        // Integer lllst = Optional.ofNullable(list3).stream()
        //         .flatMap(Collection::stream)
        //         .filter(i -> (i == 7))
        //         .findAny()
        //         .orElse(0);

        // System.out.println("lst : " + lst);
        // System.out.println("llst : " + llst);


        long sTime2 = System.nanoTime();

        List<String> retList = list4.stream()
            // .filter((str)
            .map((mapp) -> mapp.get(mapp.keySet().iterator().next()))
            .toList();
        long eTime2 = System.nanoTime();

        long sTime3 = System.currentTimeMillis();
        List<String> retList2 = Optional.ofNullable(list4).stream()
            .flatMap(Collection::stream)
            // .filter((str)
            .map((mapp) -> mapp.get(mapp.keySet().iterator().next()))
            .toList();
        long eTime3 = System.currentTimeMillis();

        // Map<String, String> test = new HashMap<>();
        // test.put("key-", "value-");
        // test.put("key-2", "value-");
        // System.out.println(retList);
        // for()


        long elapsedTime2 = eTime2 - sTime2;
        long elapsedTime3 = eTime3 - sTime3;
        System.out.println("elapsedTime2 : " + elapsedTime2 / 1000000000.0);
        System.out.println("elapsedTime3 : " + elapsedTime3 / 1000.0);
    }

//         // List<Map<String, String>> lst = new ArrayList<>();
//         // Map<String, String> map = new HashMap<>();

//         // map.put("aa","aa-value");
//         // lst.add(map);
//         // map = new HashMap<>();
//         // map.put("bb","bb-value");
//         // lst.add(map);
//         // map = new HashMap<>();
//         // map.put("cc","cc-value");
//         // lst.add(map);
//         // map = new HashMap<>();
//         // map.put("dd","dd-value");
//         // lst.add(map);

//         // List<Double> lstStr = lst.stream()
//         //         .filter(str -> (str.get("aa")).equals("aa"))
//         //         .map(str -> 11)
//         //         .map(str -> 220.0)
//         //         .toList();
        

//         ClassName<String> a = new ClassName<String>();
// 		ClassName<Integer> b = new ClassName<Integer>();
 
// 		a.set("10");
// 		b.set(10);
 
// 		// System.out.println("a data : " + a.get());
// 		// // 반환된 변수의 타입 출력
// 		// System.out.println("a E Type : " + a.get().getClass().getName());
 
// 		// System.out.println();
// 		// System.out.println("b data : " + b.get());
// 		// // 반환된 변수의 타입 출력
// 		// System.out.println("b E Type : " + b.get().getClass().getName());
// 		// System.out.println();
 
// 		// 제네릭 메소드1 Integer
// 		System.out.println("<E> returnType : " + ClassName.genericMethod1(3).getClass().getName());
 
// 		// 제네릭 메소드1 String
// 		System.out.println("<E> returnType2 : " + ClassName.genericMethod2("ABCD").getClass().getName());
 
// 		// 제네릭 메소드2 ClassName a
// 		System.out.println("<T> returnType : " + ClassName.genericMethod1(a).getClass().getName());
 
// 		// 제네릭 메소드2 Double
// 		System.out.println("<T> returnType2 : " + ClassName.genericMethod2(3.0).getClass().getName());
	
//     }

//     public static void main(String[] args) {

//         // Function<Number, Integer> fnc = (aa) -> aa.intValue();
//         Predicate<Number> pre = (p) -> p.intValue() > 2;

// //        main.<Number>preTest(predi1);
//         Main3 main = new Main3();
//         main.preFunc(pre, 3);
//         List.of(1,2,4,5).stream().filter(pre).toList();
//     }

    <T> void preFunc(Predicate<T> pre, T t) {
        System.out.println("#####:" + pre.test(t));
    }




}

class Member {
    Member(Optional<Team> team) {
        this.team = team;
    }
    private Optional<Team> team;
    public Optional<Team> getTeam() { return team; }
}

class Team {
    private Optional<Club> club;

    Team(Optional<Club> club) {
        this.club = club;
    }

    public Optional<Club> getClub() { return club; }
}

class Club {
    private String name;

    Club(String name){
        this.name = name;
    }

    public String getName() {  return name; }
}


class ClassName<E> {
 
	private E element; // 제네릭 타입 변수
 
	void set(E element) { // 제네릭 파라미터 메소드
		this.element = element;
	}
 
	E get() { // 제네릭 타입 반환 메소드
		return element;
	}
 
	// 아래 메소드의 E타입은 제네릭 클래스의 E타입과 다른 독립적인 타입이다.
	static <F> F genericMethod1(F o) { // 제네릭 메소드
		return o;
	}
 
	static <E> E genericMethod2(E o) { // 제네릭 메소드
		return o;
	}
	
}

class Person {
    Person(int age, String name) {
        this.age = age;
        this.name = name;
    }
    int age;
    String name;
}
class SaltClass <E extends Comparable<E>> {  

}
class Student implements Comparable<Student> {
	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
