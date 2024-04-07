package iuh.fit.serviceorder;

import iuh.fit.serviceorder.models.Order;
import iuh.fit.serviceorder.repositories.OrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import net.datafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ServiceOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceOrderApplication.class, args);
    }

    private final OrderRepository orderRepository;

    private final Faker faker = new Faker();

    public ServiceOrderApplication(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            for (int i = 1; i <= 10; i++) {
                Order order = createFakeOrder();
                orderRepository.save(order);
            }
        };
    }

    private Order createFakeOrder() {
        Order order = new Order();
        order.setOrderDate(faker.date().past(10, java.util.concurrent.TimeUnit.DAYS).toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDateTime());
        order.setStatus(faker.lorem().word());
        order.setShippingAddress(faker.address().fullAddress());
        return order;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


}
