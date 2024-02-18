package dev.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping("/yap")
    public ResponseEntity<String> calistir() {
        
        return ResponseEntity.ok(testService.test());
    }

    @GetMapping("/hata")
    public ResponseEntity<String> hata() {

        try {
            throw new Exception("Bu bir örnek istisna");
        } catch (Exception e) {
            log.error("İstisna yakalandı: " + e);
        }

        return ResponseEntity.ok(testService.test());
    }

    @GetMapping("/hata_iki")
    public ResponseEntity<String> hata_iki() {

        int a = 5 / 0;

        return ResponseEntity.ok(testService.test());
    }
}
