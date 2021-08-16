package Lungnaha.MyFirstSpring.Domain;

// 서버 프로그램의 Domain 즉, 데이터 형식 등을 관리하는 부분
public class Member {
    // 데이터들이 저장되는 변수들은 pirvate로 다른 데서 접근 못하게 처리
    private Long id;
    private String name;
    private String character;

    // 각 변수에 알맞는 getter, setter 함수 구현 -> 어느정도 보편화되어 있고 필수적인 부분
    // 간단하게 자동생성으로 생성 가능
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacter(){
        return  character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }
}
