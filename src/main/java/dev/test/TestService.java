package dev.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TestService {

    public ResponseDTO test(RequestDTO request){
        log.info(request.getIstek()+" istek geldi, service çalıştı");
        return ResponseDTO.builder().Detail("Success").build();
    }
}
