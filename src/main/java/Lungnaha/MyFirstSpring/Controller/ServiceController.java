package Lungnaha.MyFirstSpring.Controller;

import Lungnaha.MyFirstSpring.Domain.GetDataForm;
import Lungnaha.MyFirstSpring.Domain.Member;
import Lungnaha.MyFirstSpring.Service.ServiceWithData;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ServiceController {
    private final ServiceWithData service;

    @Autowired // Controller 생성시 해당 Service도 같이 올려주는 개념
    public ServiceController(ServiceWithData service){
        this.service = service;
    }

    @GetMapping("/")
    public String home(){
        return "home.html";
    }

    @GetMapping("/memberControl")
    public String MemberControl(){
        return "managementMember.html";
    }

    @GetMapping("/member/new")
    public String NewMember(){
        return "newMember.html";
    }
    
    @PostMapping("/member/new") // post 형식으로 데이터를 받는 경우 동작하는 코드 구현
    public String MakeNew(GetDataForm getDataForm){ // 우리가 지정한 형식으로 데이터가 들어오므로 이렇게 처리
        Member member = new Member(); // 실질적으로 활용되는 데이터 객체 생성
        member.setName(getDataForm.getDay());
        member.setCharacter(getDataForm.getStory());
        service.join(member);
        return "redirect:/"; // 동작 완료 후, 다시 홈 화면으로 돌아가도록 구현
    }

    @GetMapping("/member")
    public String ShowList(Model model){
        List<Member> member = service.ShowAllMember();
        model.addAttribute("member",member);
        return "showMembers.html";
    }
    @GetMapping("/main#experience")
    public String MakeDBTable(Model model){
        List<Member> member = service.ShowAllMember();
        model.addAttribute("member",member);
        return "main.html";
    }

    @GetMapping("/main")
    public String ShowElements(Model model){
        List<Member> member = service.ShowAllMember();
        model.addAttribute("member",member);
        return "main.html";
    }

}
