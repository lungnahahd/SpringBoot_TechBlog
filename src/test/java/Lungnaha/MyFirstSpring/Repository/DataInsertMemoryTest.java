package Lungnaha.MyFirstSpring.Repository;

import Lungnaha.MyFirstSpring.Domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

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
        //assertThat(result).isEqualTo(member);
    }

    @Test
    void 이름으로값찾기() {
        //given
        Member member1 = new Member();
        Member member2 = new Member();

        member1.setName("Kim");
        member2.setName("Lee");

        //when
        temp.Save(member1);
        temp.Save(member2);

        //then
        Boolean check = false;
        Boolean check2 = false;
        if (temp.findByName("Kim").get() == member1){
            check = true;
        }
        if(temp.findByName("Lee").get() == member1){
            check2 = true;
        }
        System.out.println(check);
        System.out.println(check2);


    }

    @Test
    void 전부뒤지기() {
        //given
        Member member = new Member();
        Member member1 = new Member();
        Member member2 = new Member();

        member.setName("Kim");
        member.setCharacter("가슴 뻠핑 날");
        member1.setName("Lee");
        member1.setCharacter("등 화나는 날");
        member2.setName("Park");
        member2.setCharacter("어깨 조지는 날");

        //when
        temp.Save(member);
        temp.Save(member1);
        temp.Save(member2);

        //then
        List resultList = temp.findAll();
        for(int i = 0 ;i < resultList.size() ;i++){
            Member show = (Member)resultList.get(i);
            System.out.println(show.getName());
            System.out.println(show .getCharacter());
        }
    }
}