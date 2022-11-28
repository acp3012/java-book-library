package in.yesh.subscriptionservice.services;

import in.yesh.subscriptionservice.dtos.IssueRequest;
import in.yesh.subscriptionservice.dtos.IssueResponse;
import in.yesh.subscriptionservice.dtos.SubscriptionRequest;
import in.yesh.subscriptionservice.dtos.SubscriptionResponse;
import in.yesh.subscriptionservice.entities.Subscription;
import in.yesh.subscriptionservice.repositories.SubscriptionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubscriptionService implements SubscriptionServiceable  {
    private final SubscriptionRepository subscriptionRepository;
//    private final FeignHttpClient feignHttpClient;
    private final RestTemplate restTemplate;

    public SubscriptionService(SubscriptionRepository subscriptionRepository,
//                               FeignHttpClient feignHttpClient
             RestTemplate restTemplate) {
        this.subscriptionRepository = subscriptionRepository;
//        this.feignHttpClient = feignHttpClient;
        this.restTemplate = restTemplate;
    }
    // Calling book service api through Feign client
//    @Override
//    public SubscriptionResponse createSubscriptionUsingFeign(String bookId, SubscriptionRequest request) {
//        var issueRequest = new IssueRequest(request.getName());
//        IssueResponse response =  feignHttpClient.createSubscriptionThroughFeign(bookId,issueRequest);
//        return saveSubscription(response);
//    }
    @Override
    public SubscriptionResponse createSubscription(SubscriptionRequest subscriptionRequest) {

        String bookId = subscriptionRequest.getBookId();
        String url = String.format("http://BOOK-SERVICE/api/books/%s/issues",bookId);
        var issueRequest = new IssueRequest(subscriptionRequest.getName());
        // call book service Rest API
        // http://localhost:8081/api/books/B1212/issues
        IssueResponse  issueResponse =
                restTemplate.postForObject(url,issueRequest,IssueResponse.class);

        return saveSubscription(issueResponse);
    }

    @Override
    public List<Subscription> getSubscription() {
        return subscriptionRepository.findAll();
    }

    @Override
    public List<SubscriptionResponse> getSubscriptionByName(String name) {
        List<Subscription> subscriptions = name == null ? subscriptionRepository.findAll()
                :subscriptionRepository.findByName(name);

        return subscriptions.stream()
                .map(this::mapToSubscriptionRequest)
                .collect(Collectors.toList());
    }

    // private methods
    private SubscriptionResponse mapToSubscriptionRequest(Subscription subscription) {
       return SubscriptionResponse.builder()
                .id(subscription.getId())
                .bookId(subscription.getBookId())
                .name(subscription.getName())
                .dateSubscribed(subscription.getDateSubscribed())
                .dateReturned(subscription.getDateReturned())
                .build();
    }

    private Subscription mapToSubscription(IssueResponse issueResponse) {
        return Subscription.builder()
                .name(issueResponse.getSubscriberName())
                .bookId(issueResponse.getBookId())
                .dateSubscribed(issueResponse.getDateIssued())
                .build();
    }

    private SubscriptionResponse saveSubscription(IssueResponse issueResponse){
        assert issueResponse != null;
        Subscription subscription = mapToSubscription(issueResponse);
        SubscriptionResponse subscriptionResponse = new SubscriptionResponse();
        if(issueResponse.isIssueStatus()){
            subscription  = subscriptionRepository.save(subscription);
            subscriptionResponse.setId(subscription.getId());
            subscriptionResponse.setBookId(subscription.getBookId());
            subscriptionResponse.setName(subscription.getName());
            subscriptionResponse.setDateSubscribed(subscription.getDateSubscribed());
        }
        else {
            subscriptionResponse.setId(0);
            subscriptionResponse.setBookId(issueResponse.getBookId());
            subscriptionResponse.setName(issueResponse.getSubscriberName());
        }
        return subscriptionResponse;
    }
}