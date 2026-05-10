package com.web.backweb.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.web.backweb.entities.pk.OrderItemPK;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table (name = "tb_order_item")
public class OrderItem implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private OrderItemPK Id = new OrderItemPK();

    private Integer Quantity;
    private Double Price;

    //CONSTRUCTOR

    public OrderItem (){}

    public OrderItem (Order order, Product product, Integer Quantity, Double Price) {
        Id.setOrder(order);
        Id.setProduct(product);
        this.Quantity = Quantity;
        this.Price = Price;
    }

    //GETS AND SETTS

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer quantity) {
        Quantity = quantity;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    @JsonIgnore
    public Order getOrder () {
        return Id.getOrder();
    }

    public void setOrder (Order order) {
       Id.setOrder(order);
    }

    public Product getProduct(){
        return Id.getProduct();
    }

    public void setProduct(Product product){
        Id.setProduct(product);
    }

    //HASH AND EQUALS

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(Id, orderItem.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(Id);
    }

    //SubTotal
    public double getSubTotal (){
        return Quantity * Price;
    }
}

