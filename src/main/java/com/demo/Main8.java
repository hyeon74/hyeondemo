package com.demo;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;

public class Main8 {
    public static void main(String[] args) {

        // 메서드 시그니처
//        public Stream<T> stream();

        // 예제
//         List<String> result = List.of(1, 2, 3, 4)
//                 .stream()
//                 .map(val -> val % 2 == 0 ? Optional.of(val) : Optional.empty())
// //                .flatMap(Optional::stream)
//                 .map(String::valueOf)
//                 .collect(Collectors.toList());

//         System.out.println(result); // print '[2, 4]'

        Club aClub = new Club("홍길동");
        Club bClub = new Club("김길동");
        Club cClub = new Club("이길동");

        Team aTeam = new Team(Optional.ofNullable(aClub));
        Team bTeam = new Team(Optional.ofNullable(bClub));
        Team cTeam = new Team(Optional.ofNullable(cClub));

        Member aMember = new Member(Optional.ofNullable(aTeam));
        Member bMember = new Member(Optional.ofNullable(bTeam));
        Member cMember = new Member(Optional.ofNullable(cTeam));

        List stream = List.of(aMember, bMember, cMember);

        Main8 main8 = new Main8();
        Set<String> ret = main8.getTeamClubNames(stream);
        System.out.println(ret);
    }

    public Set<String> getTeamClubNames(List<Member> members){
        return members.stream() // (0)
                .map(Member::getTeam) // (1)
                .peek((prt) -> System.out.println("Member-getTeam:" + prt.toString()))
                .map(optTeam -> optTeam.flatMap(Team::getClub)) // (2)
                .peek((prt) -> System.out.println("Team-getClub_Flat:" + prt.toString()))
                .map(optClub -> optClub.map(Club::getName)) // (3)
                .peek((prt) -> System.out.println("Club-getName:" + prt.toString()))
                .flatMap(Optional::stream) // (4)
                .peek((prt) -> System.out.println("Optionl:::" + prt.toString()))
                .collect(Collectors.toSet()); // 스트림에서 값을 꺼내 중복되지 않도록 Set으로 모아줍니다.
    }

}

@AllArgsConstructor
class Member {
    private Optional<Team> team;
    public Optional<Team> getTeam() { return team; }
}

@AllArgsConstructor
class Team {
    private Optional<Club> club;
    public Optional<Club> getClub() { return club; }
}

@AllArgsConstructor
class Club {
    private String name;
    public String getName() {  return name; }
}


