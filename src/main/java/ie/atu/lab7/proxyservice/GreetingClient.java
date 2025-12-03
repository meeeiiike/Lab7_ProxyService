package ie.atu.lab7.proxyservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "greetingClient", url = "${greeting.service.base-url")
public interface GreetingClient {

    @GetMapping("/api/greet/{name}")
    String call_greet(@PathVariable("name") String name);
}
