/*
 * @ (#) $NAME.java         4/7/2024
 *
 * Copyright (c) 2024 IUH.
 *
 */

package iuh.fit.serviceorder.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/*
 * @description: ...
 * @author: Vinh Trung Pham
 * @studentID: 20119821
 * @date: 4/7/2024
 */
@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private long id;
    @Column(name = "order_date")
    private LocalDateTime orderDate;
    @Column(name = "status")
    private String status;
    @Column(name = "shipping_address")
    private String shippingAddress;
    @OneToOne
    private User user;

    public Order(LocalDateTime orderDate, String status, String shippingAddress) {
        this.orderDate = orderDate;
        this.status = status;
        this.shippingAddress = shippingAddress;
    }
}
