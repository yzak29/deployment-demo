package ma.demo.deployment;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {
        "http://localhost:5173",
        "http://localhost",
        "http://127.0.0.1"
})
public class HelloController {

    @GetMapping("/hello")
    public Map<String, String> hello() {
        System.out.println("Bonjour depuis Spring Boot !");
        return Map.of(
                "message", "Bonjour depuis Spring Boot !",
                "status", "OK"
        );
    }
}
