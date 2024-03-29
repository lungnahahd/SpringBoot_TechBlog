package Lungnaha.MyFirstSpring.Controller;

import Lungnaha.MyFirstSpring.Domain.DetailData;
import Lungnaha.MyFirstSpring.Domain.GetDataForm;
import Lungnaha.MyFirstSpring.Domain.Member;
import Lungnaha.MyFirstSpring.Service.ServiceWithData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    @PostMapping("/detail")
    public String PostDetail(DetailData detailData, Model model){
        Optional<Member> member = service.ShowNameMember(detailData.getName());
        model.addAttribute("member",member);
        return "redirect:/detail";
    }

    //@GetMapping("/detail")
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String ShowDetail(String name, Model model){
        Optional<Member> member1 = service.ShowNameMember(name);
        Member getMember = member1.get();
        model.addAttribute("member",getMember);
        return "/detail";
    }

    @GetMapping("/main")
    public String ShowElements(Model model){
        List<Member> member = service.ShowAllMember();
        model.addAttribute("member",member);
        return "main.html";
    }

}
