/*
 * @ (#) $NAME.java         4/7/2024
 *
 * Copyright (c) 2024 IUH.
 *
 */

package iuh.fit.serviceorder.controllers;

/*
 * @description: ...
 * @author: Vinh Trung Pham
 * @studentID: 20119821
 * @date: 4/7/2024
 */

import iuh.fit.serviceorder.models.Order;
import iuh.fit.serviceorder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class OrderController {
    @Autowired
    private OrderService orderService;

    //    private Jedis jedis = new Jedis();

    @GetMapping("/orders")
    public List<Order> getLisOrder() {
        return orderService.getListOrder();
    }

    @GetMapping("/orders/{id}")
    public Order getUserById(@PathVariable(value = "id") long id) {
        return orderService.getOrderById(id);
    }

    @PostMapping("/orders")
    public Order addOrder(@RequestBody Order order) {
        return orderService.addOrder(order);
    }

    @DeleteMapping("/orders/{orderId}")
    public void deleteOrder(@PathVariable(value = "orderId") long orderId) {
        orderService.deleteOrderById(orderId);
    }

}
