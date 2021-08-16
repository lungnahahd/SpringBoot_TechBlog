package Lungnaha.MyFirstSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Spring Boot 실행 시에 Tomcat을 활용해서 같이 실행시켜주는 기능
public class MyFirstSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyFirstSpringApplication.class, args);
	}

}
