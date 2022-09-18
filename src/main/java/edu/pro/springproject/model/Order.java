package edu.pro.springproject.model;

/*
 * @author JohnBuritto
 * @project SpringProject
 * @class Order
 * @version 1.0.0
 * @since 15.05.2022, 12:11
 * Software Engineering Department
 *
 * Copyright (c) 1993-1996 Sun Microsystems, Inc. All Rights Reserved.
 */

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Order {
    private String id;
    private String name;
    private String description;
    private Customer customer;
    private Transport transport;
    private Goods goods;
    private long numberOfGoods;
    private TypeOfDelivering typeOfDelivering;
    private double priceOfDelivering;
    private double priceOfGoods;
    private double totalPrice;
    private LocalDateTime dayOfStart;
    private LocalDateTime dayOfEnd;
    private DeliveringStatus deliveringStatus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Order() {

    }

    public Order(String name, String description, Customer customer, Transport transport, Goods goods,
                 long numberOfGoods, TypeOfDelivering typeOfDelivering, double priceOfDelivering, double priceOfGoods,
                 double totalPrice, LocalDateTime dayOfStart, LocalDateTime dayOfEnd, DeliveringStatus deliveringStatus) {
        this.name = name;
        this.description = description;
        this.customer = customer;
        this.transport = transport;
        this.goods = goods;
        this.numberOfGoods = numberOfGoods;
        this.typeOfDelivering = typeOfDelivering;
        this.priceOfDelivering = priceOfDelivering;
        this.priceOfGoods = priceOfGoods;
        this.totalPrice = totalPrice;
        this.dayOfStart = dayOfStart;
        this.dayOfEnd = dayOfEnd;
        this.deliveringStatus = deliveringStatus;
    }

    public Order(String id, String name, String description, Customer customer, Transport transport, Goods goods,
                 long numberOfGoods, TypeOfDelivering typeOfDelivering, double priceOfDelivering, double priceOfGoods,
                 double totalPrice, LocalDateTime dayOfStart, LocalDateTime dayOfEnd, DeliveringStatus deliveringStatus,
                 LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.customer = customer;
        this.transport = transport;
        this.goods = goods;
        this.numberOfGoods = numberOfGoods;
        this.typeOfDelivering = typeOfDelivering;
        this.priceOfDelivering = priceOfDelivering;
        this.priceOfGoods = priceOfGoods;
        this.totalPrice = totalPrice;
        this.dayOfStart = dayOfStart;
        this.dayOfEnd = dayOfEnd;
        this.deliveringStatus = deliveringStatus;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public long getNumberOfGoods() {
        return numberOfGoods;
    }

    public void setNumberOfGoods(long numberOfGoods) {
        this.numberOfGoods = numberOfGoods;
    }

    public TypeOfDelivering getTypeOfDelivering() {
        return typeOfDelivering;
    }

    public void setTypeOfDelivering(TypeOfDelivering typeOfDelivering) {
        this.typeOfDelivering = typeOfDelivering;
    }

    public double getPriceOfDelivering() {
        return priceOfDelivering;
    }

    public void setPriceOfDelivering(double priceOfDelivering) {
        this.priceOfDelivering = priceOfDelivering;
    }

    public double getPriceOfGoods() {
        return priceOfGoods;
    }

    public void setPriceOfGoods(double priceOfGoods) {
        this.priceOfGoods = priceOfGoods;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDateTime getDayOfStart() {
        return dayOfStart;
    }

    public void setDayOfStart(LocalDateTime dayOfStart) {
        this.dayOfStart = dayOfStart;
    }

    public LocalDateTime getDayOfEnd() {
        return dayOfEnd;
    }

    public void setDayOfEnd(LocalDateTime dayOfEnd) {
        this.dayOfEnd = dayOfEnd;
    }

    public DeliveringStatus getDeliveringStatus() {
        return deliveringStatus;
    }

    public void setDeliveringStatus(DeliveringStatus deliveringStatus) {
        this.deliveringStatus = deliveringStatus;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id.equals(order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", customer=" + customer +
                ", transport=" + transport +
                ", goods=" + goods +
                ", numberOfGoods=" + numberOfGoods +
                ", typeOfDelivering=" + typeOfDelivering +
                ", priceOfDelivering=" + priceOfDelivering +
                ", priceOfGoods=" + priceOfGoods +
                ", totalPrice=" + totalPrice +
                ", dayOfStart=" + dayOfStart +
                ", dayOfEnd=" + dayOfEnd +
                ", deliveringStatus=" + deliveringStatus +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
