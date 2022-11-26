package in.yesh.subscriptionservice.services;

import in.yesh.subscriptionservice.dtos.IssueRequest;
import in.yesh.subscriptionservice.dtos.IssueResponse;
//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//@FeignClient(value="book-service",url="http://BOOK-SERVICE/api/books")
public interface FeignHttpClient {
//    @PostMapping("{bookId}/issues")
//    public IssueResponse createSubscriptionThroughFeign(@PathVariable String bookId,
//                                                       @RequestBody IssueRequest request);
}
