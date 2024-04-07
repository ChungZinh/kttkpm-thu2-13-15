/*
 * @ (#) $NAME.java         4/7/2024
 *
 * Copyright (c) 2024 IUH.
 *
 */

package iuh.fit.serviceorder.repositories;

import iuh.fit.serviceorder.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * @description: ...
 * @author: Vinh Trung Pham
 * @studentID: 20119821
 * @date: 4/7/2024
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
