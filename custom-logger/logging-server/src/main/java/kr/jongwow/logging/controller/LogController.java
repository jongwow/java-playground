package kr.jongwow.logging.controller;

import kr.jongwow.logging.dto.LogDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
public class LogController {
    @PostMapping("/v1/log")
    @ResponseStatus(HttpStatus.OK)
    public void receiveLog(@RequestBody LogDTO logDTO) {
        System.out.println("SERVER LOG[" + logDTO.level + "] " + logDTO.message);
        return;
    }
}
