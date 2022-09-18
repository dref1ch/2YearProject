package edu.pro.springproject.controller.ui;

/*
 * @author JohnBuritto
 * @project SpringProject12
 * @class OrderUIController
 * @version 1.0.0
 * @since 27.05.2022, 13:38
 * Software Engineering Department
 *
 * Copyright (c) 1993-1996 Sun Microsystems, Inc. All Rights Reserved.
 */

import edu.pro.springproject.form.OrderForm;
import edu.pro.springproject.model.Customer;
import edu.pro.springproject.model.Order;
import edu.pro.springproject.repository.CustomerMongoRepository;
import edu.pro.springproject.repository.OrderMongoRepository;
import edu.pro.springproject.service.GoodsService;
import edu.pro.springproject.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/ui/v1/orders")
public class OrderUIController {
    @Autowired
    OrderMongoRepository repository;
    @Autowired
    CustomerMongoRepository customerMongoRepository;
    @Autowired
    TransportService transportService;
    @Autowired
    GoodsService goodsService;

    @RequestMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("orders", repository.findAll());

        return "orders";
    }

    @RequestMapping(value = "/put", method = RequestMethod.GET)
    public String addOrder(Model model){
        OrderForm orderForm = new OrderForm();

        model.addAttribute("form", orderForm);
        model.addAttribute("customers", getCustomerNamesNId());
        model.addAttribute("goods", goodsService.getGoodsNameNCode());
        model.addAttribute("transports", transportService.getTransportsNId());

        return "add-order";
    }

    @RequestMapping(value = "/put", method = RequestMethod.POST)
    public String addOrder(@ModelAttribute("form") OrderForm orderForm){
        Order order = new Order();

        order.setCustomer(getCustomerById(orderForm.getCustomer()));
        order.setGoods(goodsService.parseAndGetByCode(orderForm.getGoods()));
        order.setTransport(transportService.parseAndGetById(orderForm.getTransport()));
        order.setCreatedAt(LocalDateTime.now());
        order.setUpdatedAt(LocalDateTime.now());

        repository.save(order);

        return "redirect:/ui/v1/orders/all";
    }

    private List<String> getCustomerNamesNId() {
        List<String> names = new ArrayList<>();

        customerMongoRepository.findAll()
                .forEach(customer -> names.add(customer.getContactPerson().getFirstName()
                        + " " + customer.getContactPerson().getMiddleName()
                        + " " + customer.getContactPerson().getLastName()
                        + "(" + customer.getId() + ")"));

        return names;
    }

    private Customer getCustomerById(String customer) {
        customer = customer.replace('(', ' ');
        customer = customer.replace(')', ' ');

        List<String> customerComponents = Arrays.asList(customer.split(" +"));

        return customerMongoRepository.findById(customerComponents.get(customerComponents.size() - 1)).orElse(null);
    }
}
