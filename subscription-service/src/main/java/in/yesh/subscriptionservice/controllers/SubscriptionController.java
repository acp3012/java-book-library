package in.yesh.subscriptionservice.controllers;

import in.yesh.subscriptionservice.dtos.SubscriptionRequest;
import in.yesh.subscriptionservice.dtos.SubscriptionResponse;
import in.yesh.subscriptionservice.services.SubscriptionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionController {
    private final SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @PostMapping
    public ResponseEntity<SubscriptionResponse> createSubscription(@RequestBody SubscriptionRequest subscriptionRequest){
         SubscriptionResponse response = subscriptionService.createSubscription(subscriptionRequest);
//        SubscriptionResponse response = subscriptionService.createSubscriptionUsingFeign(
//                subscriptionRequest.getBookId(),
//                subscriptionRequest);

        HttpStatus status = HttpStatus.CREATED;

        if(response.getId() == 0)  status = HttpStatus.UNPROCESSABLE_ENTITY;
        return new ResponseEntity<>(response, status);
    }

    @GetMapping
    public ResponseEntity<List<SubscriptionResponse>> getSubscriptions(@PathParam(value="name") String name){
        return new ResponseEntity<>(subscriptionService.getSubscriptionByName(name),HttpStatus.OK);
    }
}
