package in.yesh.cloudgateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallbackController {

    @GetMapping("/bookServiceFallBack")
    public Mono<String> bookServiceFallBack()    {
        return Mono.just("Book service is taking loo long or is down, please try after sometime");
    }


    @GetMapping("/subscriptionServiceFallBack")
    public Mono<String> subscriptionServiceFallBack()    {
        return Mono.just("Subscription service is taking loo long or is down please try after sometime");
    }
}

