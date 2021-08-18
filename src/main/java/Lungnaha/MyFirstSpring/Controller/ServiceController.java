package Lungnaha.MyFirstSpring.Controller;

import Lungnaha.MyFirstSpring.Service.ServiceWithData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ServiceController {
    private final ServiceWithData service;

    @Autowired // Controller 생성시 해당 Service도 같이 올려주는 개념
    public ServiceController(ServiceWithData service){
        this.service = service;
    }

}
