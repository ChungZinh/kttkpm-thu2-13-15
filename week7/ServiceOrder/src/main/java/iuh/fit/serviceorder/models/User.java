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

/*
 * @description: ...
 * @author: Vinh Trung Pham
 * @studentID: 20119821
 * @date: 4/7/2024
 */
@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long id;
    @Column(name = "user_name")
    private String name;

    public User(String name) {
        this.name = name;
    }
}
