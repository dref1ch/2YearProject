package edu.pro.springproject.controller.api;

/*
 * @author JohnBuritto
 * @project SpringProject12
 * @class OrderRestController
 * @version 1.0.0
 * @since 27.05.2022, 14:08
 * Software Engineering Department
 *
 * Copyright (c) 1993-1996 Sun Microsystems, Inc. All Rights Reserved.
 */

import edu.pro.springproject.model.Order;
import edu.pro.springproject.repository.OrderMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderRestController {
    @Autowired
    OrderMongoRepository repository;

    @RequestMapping("/all")
    public List<Order> getAll() {
        return repository.findAll();
    }
}
