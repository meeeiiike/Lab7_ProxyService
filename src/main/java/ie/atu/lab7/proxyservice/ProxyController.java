package ie.atu.lab7.proxyservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProxyController {

    private final GreetingClient greetingClient;

    public ProxyController(GreetingClient greetingClient) {
        this.greetingClient = greetingClient;
    }

    @GetMapping("/api/proxy-greet/{name}")
    public ResponseEntity<String> proxyGreet(@PathVariable("name") String name) {
        String response = greetingClient.call_greet(name);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}