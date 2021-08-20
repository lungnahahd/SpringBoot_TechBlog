package Lungnaha.MyFirstSpring.Controller;

import Lungnaha.MyFirstSpring.Repository.DataInsertMemory;
import Lungnaha.MyFirstSpring.Repository.TemplateJDBC;
import Lungnaha.MyFirstSpring.Service.ServiceWithData;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.aspectj.SpringConfiguredConfiguration;

import javax.sql.DataSource;

// Java 코드를 작성해서 직접 Configuration으로 원하는 부분을 Spring Bean에 올리는 과정
// 해당 코드로 직접 Spring Bean에 올리려면 @Service, @Repository를 모두 제거한 다음에 진행 필요

@Configuration
public class ServiceConfiguration {
    private final DataSource dataSource;

    public ServiceConfiguration(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Bean // 직접 자바 코드로 Repository 등록하기
    public DataInsertMemory dataInsertMemory(){
        return  new DataInsertMemory();
    }

    @Bean // JDBC 템플릿으로 구현한 Repository도 Bean에 올려서 사용 가능
    public TemplateJDBC templateJDBC(){
        return new TemplateJDBC(dataSource);
    }


    @Bean // 직접 자바 코드로 Service 등록하기
    public ServiceWithData serviceWithData(){
        //return new ServiceWithData(dataInsertMemory());
        return new ServiceWithData(templateJDBC());
    }
}
