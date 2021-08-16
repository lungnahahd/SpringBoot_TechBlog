package Lungnaha.MyFirstSpring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstConnect {
    @GetMapping("dj") // Get 방식을 받기 위해서 사용하는 기능
    public  String hello(Model model){
        model.addAttribute("data", "Love..."); //Model을 활용해서 해당 html에 Key-Value 넘겨주기
        return "firstSite.html"; // 해당 Get 방식이 들어왔을 때, 호출하려는 Html 파일 적기
    }
}
