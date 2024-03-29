package Lungnaha.MyFirstSpring.Repository;

import Lungnaha.MyFirstSpring.Domain.Member;
import Lungnaha.MyFirstSpring.Interface.DBInterface;
import org.springframework.stereotype.Repository;

import java.util.*;

// 이전에 구현한 Interface의 기능을 구체적으로 구현
//@Repository // Service의 Autowired와 연결되기 위해서 Spring에 명시헤주는 역할
public class DataInsertMemory implements DBInterface {
    private static Map<Long, Member> temp = new HashMap<>(); // id와 데이터를 따로 담기 위해 사용
    private static long num = 0L; // id를 독립적으로 처리하기 위해 사용

    @Override
    public Member Save(Member member) {
        member.setId(++num); // id는 자동으로 증가하도록 설정
        temp.put(member.getId(),member);
        return null;
    }

    @Override
    public Optional<Member> findByName(String name) {
        Member member = null;
        for(Long i : temp.keySet()){
            if(temp.get(i).getName().equals(name)){
                Member turn = temp.get(i);
                return Optional.ofNullable(turn);
            }


        }
        return Optional.ofNullable(member);
    }



    @Override
    public List<Member> findAll() {

        return new ArrayList<>(temp.values());
    }
    //Test를 위해 필요한 함수 -> 실제 서비스에서는 사용 X
    public void clearStore(){
        temp.clear();
    }
}
