package Lungnaha.MyFirstSpring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FirstConnect {
    @GetMapping("dj") // Get 방식을 받기 위해서 사용하는 기능
    public  String Hello(Model model){
        model.addAttribute("data", "Love..."); //Model을 활용해서 해당 html에 Key-Value 넘겨주기
        return "firstSite.html"; // 해당 Get 방식이 들어왔을 때, 호출하려는 Html 파일 적기
    }

    @GetMapping("myName")
    //localhost:8080/myName?name=렁나하 이렇게 요청되면 렁나하가 name 변수에 담기는 원리
    public  String HelloName(@RequestParam("name") String name, Model model){ //RequestParam으로 해당 Key에 맞는 값을 String name에 넣고 html에 전달
        model.addAttribute("name", name);
        return "MyName.html";
    }

    @GetMapping("api")
    @ResponseBody // 이를 통해 단순 Html과 연결이 아니라 Get 방식으로 받은 데이터 자체를 화면에 출력 가능 -> 이런 식으로 API 처리 가능!!(응용 생각하기)
    public String GetAPIData(@RequestParam("friend") String name){
        return name;
    }
}
