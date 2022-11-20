package ru.netology.dao.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String date;

    @ManyToOne(optional = false)

    private Customers customer;

    private String productName;

    private int amount;

    public Orders(String date, Customers customer, String productName, int amount) {
        this.date = date;
        this.customer = customer;
        this.productName = productName;
        this.amount = amount;
    }
}
