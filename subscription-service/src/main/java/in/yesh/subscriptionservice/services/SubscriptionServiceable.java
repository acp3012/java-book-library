package in.yesh.subscriptionservice.services;

import in.yesh.subscriptionservice.dtos.IssueRequest;
import in.yesh.subscriptionservice.dtos.IssueResponse;
import in.yesh.subscriptionservice.dtos.SubscriptionRequest;
import in.yesh.subscriptionservice.dtos.SubscriptionResponse;
import in.yesh.subscriptionservice.entities.Subscription;

import java.util.List;

public interface SubscriptionServiceable {

    SubscriptionResponse createSubscription(SubscriptionRequest subscriptionRequest);
//    SubscriptionResponse createSubscriptionUsingFeign(String bookId, SubscriptionRequest subscriptionRequest);
    List<Subscription> getSubscription();

    List<SubscriptionResponse> getSubscriptionByName(String name);
}
