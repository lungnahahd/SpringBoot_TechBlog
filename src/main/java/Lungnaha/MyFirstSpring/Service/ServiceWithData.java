package Lungnaha.MyFirstSpring.Service;

import Lungnaha.MyFirstSpring.Domain.Member;
import Lungnaha.MyFirstSpring.Repository.DataInsertMemory;

import java.util.List;
import java.util.Optional;

// 지금까지 Interface를 활용한 저장소 기능을 이용해서 실질적으로 서비스를 구현
// 여기서는 실무에서 요구하는 서비스를 차례대로 구현하면 된다.
public class ServiceWithData {
    
    // 저장소 기능 받아오기
    // 주석처리된 부분처럼 Service에서 직접 저장소 객체를 생성하면 매번 새로운 저장소가 생성되어서 원하는 결과가 나올 수 X
    // DataInsertMemory temp = new DataInsertMemory();

    // 생성할 때마다 생성하지 말고, 이렇게 생성자를 활용해서 저장소를 서비스가 시작할 때 넘겨받도록 구현!!!
    private DataInsertMemory temp;
    public ServiceWithData(DataInsertMemory dataInsertMemory){
        this.temp = dataInsertMemory;
    }

    // 회원가입 기능
    public String join(Member member){

        try {
            if(checkOldMember(member)){
                temp.Save(member);
            }else{
                // 이미 존재하는 회원일 경우, 아래처럼 예외 던져주기
                throw new Exception();
            }
        }catch (Exception e){ 
            throw new IllegalStateException("이미 존재하는 이름입니다.");
        }
        return member.getCharacter();

    }
    // 회원가입 전에 동일 회원이 있는지 검증하는 부분
    private boolean checkOldMember(Member member){
        boolean notSame = true;
        Optional<Member> oldMember = temp.findByName(member.getName());
        if(oldMember.isPresent()){
            notSame = false;
        }
        return notSame;
    }

    // 전체 회원 조회하기
    public List<Member> ShowAllMember(){
        List resultList = temp.findAll();
        /*for(int i = 0 ;i < resultList.size() ;i++){
            Member show = (Member)resultList.get(i);
            System.out.print(show.getId());
            System.out.print(show.getName());
            System.out.print(show.getCharacter());
            System.out.println();
        }*/
        return resultList;
    }




}
