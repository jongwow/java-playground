package kr.jongwow.simple.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SomeService {
    @Scheduled(fixedRate = 3000) // 3초마다 실행
    public void running(){
        log.info("Some Service is running. (every 3 seconds)");
    }
}
