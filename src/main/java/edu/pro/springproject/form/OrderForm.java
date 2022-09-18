package edu.pro.springproject.form;

/*
 * @author JohnBuritto
 * @project SpringProject12
 * @class OrderForm
 * @version 1.0.0
 * @since 27.05.2022, 13:37
 * Software Engineering Department
 *
 * Copyright (c) 1993-1996 Sun Microsystems, Inc. All Rights Reserved.
 */

public class OrderForm {
    private String customer;
    private String goods;
    private String transport;

    public OrderForm() {

    }

    public OrderForm(String customer, String goods, String transport) {
        this.customer = customer;
        this.goods = goods;
        this.transport = transport;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    @Override
    public String toString() {
        return "OrderForm{" +
                "customer='" + customer + '\'' +
                ", goods='" + goods + '\'' +
                ", transport='" + transport + '\'' +
                '}';
    }
}
