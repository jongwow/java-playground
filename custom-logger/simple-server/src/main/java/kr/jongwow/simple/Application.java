package kr.jongwow.simple;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@Configuration
@EnableScheduling // 스케줄러 활성화
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
