package Lungnaha.MyFirstSpring.Service;

import Lungnaha.MyFirstSpring.Domain.Member;
import Lungnaha.MyFirstSpring.Repository.DataInsertMemory;
import Lungnaha.MyFirstSpring.Repository.TemplateJDBC;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest // Test 진행 시에 Spring boot를 같이 띄워서 Test를 진행하기 위해서 필요
@Transactional // 각 Test 실행 마다 해당 동작을 실제 DB에 반영하지 않게 하기 위해서 필요
class ServiceWithDataTest {

    @Autowired ServiceWithData service;
    @Autowired TemplateJDBC temp;
//
//    // 각 테스트마다 독립된 서비스와 저장소를 사용하도록 재정의 진행
//    @BeforeEach
//    public void BeforeBehaviour(){
//        temp = new DataInsertMemory();
//        service = new ServiceWithData(temp);
//    }
//    // 테스트가 끝날 때마다 메모리 비우기 동작 실행
//    @AfterEach
//    public void AfterBehaviour(){
//        temp.clearStore();
//    }

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        Member member2 = new Member();
        Member member1 = new Member();
        //member.setId(5L);
        member.setName("Monday");
        member.setCharacter("가슴운동");
        member2.setName("Monday");
        member2.setCharacter("무분할");
        member1.setName("Tuesday");
        member1.setCharacter("등운동");


        //when
        service.join(member);
        service.join(member2);
        //String getCharacter2 = service.join(member1);
        //String makeError = service.join(member2);

        //then
        System.out.println(member.getName());
        //System.out.println(getCharacter2);
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