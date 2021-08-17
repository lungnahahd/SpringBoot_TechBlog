package Lungnaha.MyFirstSpring.Service;

import Lungnaha.MyFirstSpring.Domain.Member;
import Lungnaha.MyFirstSpring.Repository.DataInsertMemory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        member.setName("Monday");
        member.setCharacter("가슴운동");
        member.setName("Monday");
        member2.setCharacter("무분할");

        //when
        String getCharacter = service.join(member);

        //then
        System.out.println(getCharacter);
    }

    @Test
    void 회원명단공개() {
    }
}