package dev.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping("/yap")
    public ResponseEntity<ResponseDTO> calistir(@RequestBody RequestDTO request) {
        return ResponseEntity.ok(testService.test(request));
    }

    @PostMapping("/hata")
    public ResponseEntity<ResponseDTO> hata(@RequestBody RequestDTO request) {

        try {
            throw new Exception("Bu bir örnek istisna");
        } catch (Exception e) {
            log.error("İstisna yakalandı: " + e);
        }

        return ResponseEntity.ok(testService.test(request));
    }

    @PostMapping("/hata_iki")
    public ResponseEntity<ResponseDTO> hata_iki(@RequestBody RequestDTO request) {

        int a = 5 / 0;

        return ResponseEntity.ok(testService.test(request));
    }
}
