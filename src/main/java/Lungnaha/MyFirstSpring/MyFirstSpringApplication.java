package Lungnaha.MyFirstSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.TimeZone;

@SpringBootApplication // Spring Boot 실행 시에 Tomcat을 활용해서 같이 실행시켜주는 기능
public class MyFirstSpringApplication {
	@PostConstruct
	public void started(){
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		System.out.println("현재시각 : " + new Date());
	}

	public static void main(String[] args) {
		SpringApplication.run(MyFirstSpringApplication.class, args);
	}

}
