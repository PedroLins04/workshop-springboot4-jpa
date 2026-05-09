package com.web.backweb.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.web.backweb.entities.enums.OrderStatus;
import jakarta.persistence.*;

import java.io.Serializable;
import java.nio.MappedByteBuffer;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    @OneToMany(mappedBy = "Id.order")
    private Set<OrderItem> items = new HashSet<>();

    private Integer order_status;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;

    //CONSTRUCTORS

    public Order() {
    }

    public Order(Long id, Instant moment, OrderStatus status, User client) {
        Id = id;
        this.moment = moment;
        setStatus(status);
        this.client = client;
    }

    //GETS AND SETS

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return OrderStatus.ValueOf(order_status);
    }

    public void setStatus(OrderStatus status) {
        if (status != null) {
            this.order_status = status.getCode();
        }
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Set<OrderItem> getItems() {
        return items;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    //HASH AND EQUALS

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(Id, order.Id) && Objects.equals(moment, order.moment) && Objects.equals(client, order.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, moment, client);
    }

    //toString

    @Override
    public String toString() {
        return "Order{" +
                "Id=" + Id +
                ", moment=" + moment +
                ", client=" + client +
                '}';
    }
}
