package Lungnaha.MyFirstSpring.Service;

import Lungnaha.MyFirstSpring.Domain.Member;
import Lungnaha.MyFirstSpring.Repository.DataInsertMemory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ServiceWithDataTest {

    ServiceWithData service;
    DataInsertMemory temp;

    // 각 테스트마다 독립된 서비스와 저장소를 사용하도록 재정의 진행
    @BeforeEach
    public void BeforeBehaviour(){
        temp = new DataInsertMemory();
        service = new ServiceWithData(temp);
    }
    // 테스트가 끝날 때마다 메모리 비우기 동작 실행
    @AfterEach
    public void AfterBehaviour(){
        temp.clearStore();
    }

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        Member member2 = new Member();
        Member member1 = new Member();
        member.setName("Monday");
        member.setCharacter("가슴운동");
        member2.setName("Monday");
        member2.setCharacter("무분할");
        member1.setName("Tuesday");
        member1.setCharacter("등운동");


        //when
        String getCharacter = service.join(member);
        String getCharacter2 = service.join(member1);
        //String makeError = service.join(member2);

        //then
        System.out.println(getCharacter);
        System.out.println(getCharacter2);
        //System.out.println(makeError);
    }

    @Test
    void 회원명단공개() {
        //given
        Member member = new Member();
        Member member2 = new Member();
        Member member1 = new Member();
        member.setName("Monday");
        member.setCharacter("가슴운동");
        member2.setName("Monday");
        member2.setCharacter("무분할");
        member1.setName("Tuesday");
        member1.setCharacter("등운동");

        //when
        service.join(member);
        service.join(member1);
        //service.join(member2);

        //then
        List resultList = service.ShowAllMember();
        for(int i = 0 ;i < resultList.size() ;i++){
            Member show = (Member)resultList.get(i);
            System.out.println(show.getName());
            System.out.println(show .getCharacter());
        }
    }
}