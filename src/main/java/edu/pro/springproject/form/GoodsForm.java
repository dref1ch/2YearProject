package edu.pro.springproject.form;/*
    @author Denys
    @project SpringProject
    @class GoodsForm
    @version 1.0.0
    @since 10.04.2022 - 18 - 55
*/

import edu.pro.springproject.model.TimeOfDelivery;

public class GoodsForm {
    private String id;
    private String name;
    private String description;
    private String code;
    private double price;
    private TimeOfDelivery delivery;
    private String createdAt;
    private String updatedAt;

    public GoodsForm() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public TimeOfDelivery getDelivery() {
        return delivery;
    }

    public void setDelivery(TimeOfDelivery delivery) {
        this.delivery = delivery;
    }

    @Override
    public String toString() {
        return "GoodsForm{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", code='" + code + '\'' +
                ", price=" + price +
                ", delivery='" + delivery + '\'' +
                '}';
    }
}
