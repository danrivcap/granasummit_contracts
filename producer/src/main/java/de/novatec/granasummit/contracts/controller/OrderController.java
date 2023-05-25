package de.novatec.granasummit.contracts.controller;

import de.novatec.granasummit.contracts.dto.OrderResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class OrderController {

    @GetMapping("order")
    public ResponseEntity<OrderResponse> getOrder(String number){
        OrderResponse order = new OrderResponse(number,"Arnold");
        ResponseEntity<OrderResponse> entity = ResponseEntity.of(Optional.of(order));

        return entity;
    }
}
