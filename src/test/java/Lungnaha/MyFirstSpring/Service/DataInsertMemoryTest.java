package Lungnaha.MyFirstSpring.Service;

import Lungnaha.MyFirstSpring.Domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

class DataInsertMemoryTest {

    DataInsertMemory temp = new DataInsertMemory();

    @AfterEach
    public void afterEach(){
        temp.clearStore();
    }

    @Test
    // 테스트 시에 함수는 간단하게 알아보기 쉽게 구현!!
    void 저장기능() {
        //given
        Member member = new Member();
        member.setName("Kim");
        //when
        temp.Save(member);
        //then
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