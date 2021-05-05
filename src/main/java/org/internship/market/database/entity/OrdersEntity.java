package org.internship.market.database.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "orders")
public class OrdersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "command_number")
    private int command_number;
    @Column(name = "amount")
    private int amount;
    @Column(name = "price")
    private  double price;
    @Column(name = "status")
    private String status;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private CustomerEntity customerEntity;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;

}
