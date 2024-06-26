/*
 * @ (#) $NAME.java         4/7/2024
 *
 * Copyright (c) 2024 IUH.
 *
 */

package iuh.fit.serviceorder.service;

import io.github.resilience4j.retry.annotation.Retry;
import iuh.fit.serviceorder.models.Order;
import iuh.fit.serviceorder.models.User;
import iuh.fit.serviceorder.repositories.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

/*
 * @description: ...
 * @author: Vinh Trung Pham
 * @studentID: 20119821
 * @date: 4/7/2024
 */
@Slf4j
@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    private final RestTemplate restTemplate;

    public OrderService(OrderRepository orderRepository, RestTemplate restTemplate) {
        this.orderRepository = orderRepository;
        this.restTemplate = restTemplate;
    }

    @Retry(name = "retryApi")
    public List<Order> getListOrder(){
        List<Order> orderList = orderRepository.findAll();
        for (Order o: orderList) {
            User user = restTemplate.getForObject("http://localhost:8082/api/v1/users/"+o.getId(), User.class);
            o.setUser(user);
        }
        return orderList;
    }

    public Order getOrderById(long id){
        Order order = orderRepository.findById(id).get();
        User user = restTemplate.getForObject("http://localhost:8082/api/v1/users/"+id, User.class);
        order.setUser(user);
        return order;
    }

    public Order addOrder(Order order){
        return orderRepository.save(order);
    }

    public void deleteOrderById(long id){
        orderRepository.deleteById(id);
    }
}
