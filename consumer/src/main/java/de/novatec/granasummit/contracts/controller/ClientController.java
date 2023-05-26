package de.novatec.granasummit.contracts.controller;

import de.novatec.granasummit.contracts.dto.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
public class ClientController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("client")
    public ResponseEntity<OrderResponse> getOrder(String number){

        /*
        ResponseEntity<String> responseString = restTemplate.getForEntity(
                "http://localhost:8090/order?number=" + number,
                String.class);

        System.out.println(responseString.getHeaders().getContentType());
        System.out.println(responseString.getBody());
        */

        OrderResponse responseEntity = restTemplate.getForObject(
        "http://localhost:8090/order?number=" + number,
            OrderResponse.class);

        ;

        ResponseEntity<OrderResponse> entity = ResponseEntity.of(Optional.of(responseEntity));

        return entity;
    }

}
