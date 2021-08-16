package Lungnaha.MyFirstSpring.Interface;

import Lungnaha.MyFirstSpring.Domain.Member;

import java.util.List;
import java.util.Optional;
// 처음에는 Memory에 데이터 저장 예정 -> 추후에 DB 연동 진행
// 이런 과정으로 모두 처리하기 위해선 Interface 구현으로 처리가 굳굳

// 아래 코드들을 통해서 무슨 기능을 구현할지만 지정
public interface DBInterface {
    Member Save(Member member);
    Optional<Member> findByName(String name); // Java에서 제공해주는 기능으로 Null이 들어왔을 경우 원활한 처리를 제공
    List<Member> findAll();    
}
