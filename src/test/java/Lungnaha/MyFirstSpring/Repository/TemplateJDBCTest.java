package Lungnaha.MyFirstSpring.Repository;

import Lungnaha.MyFirstSpring.Domain.Member;
import Lungnaha.MyFirstSpring.Service.ServiceWithData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest // Spring Boot를 같이 이용해서 테스트를 진행하기 위해 필요 -> 최대한 테스트에서는 Spring을 띄우지 않고 사용하는 것이 효과적
@Transactional // 해당 기능으로 Test의 동작이 실제 DB에 반영되지 않음 -> 앞에서 저장소를 비우는 동작을 한것과 동일한 효과
class TemplateJDBCTest {
    // Test 시에 Spring boot를 부를 것이므로 아래의 것들도 같이 띄워져야 테스트가 정확
    @Autowired ServiceWithData service;
    @Autowired TemplateJDBC temp;

    @Test
    void 회원가입() {
        //Given
        Member member = new Member();
        member.setName("광복절");
        member.setCharacter("헬스장 휴식일");
        //When
        temp.Save(member);
        //Then
        Member result = temp.findByName(member.getName()).get();

        System.out.println(result.getName());
    }

    @Test
    void findByName() {

    }

    @Test
    void findAll() {
    }
}