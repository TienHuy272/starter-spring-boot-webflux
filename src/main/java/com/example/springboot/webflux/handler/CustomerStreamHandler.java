package com.example.springboot.webflux.handler;

import com.example.springboot.webflux.dao.CustomerDao;
import com.example.springboot.webflux.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerStreamHandler {

    @Autowired
    private CustomerDao customerDao;

    public Mono<ServerResponse> getCustomers(ServerRequest request) {
        Flux<Customer> customerList = customerDao.getCustomersStream();
        return ServerResponse.ok().contentType(MediaType.TEXT_EVENT_STREAM).body(customerList, Customer.class);
    }
}
