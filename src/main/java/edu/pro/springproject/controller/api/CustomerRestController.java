package edu.pro.springproject.controller.api;

/*
 * @author JohnBuritto
 * @project SpringProject12
 * @class CustomerRestController
 * @version 1.0.0
 * @since 26.05.2022, 16:07
 * Software Engineering Department
 *
 * Copyright (c) 1993-1996 Sun Microsystems, Inc. All Rights Reserved.
 */

import edu.pro.springproject.model.Customer;
import edu.pro.springproject.repository.CustomerMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerRestController {
    @Autowired
    CustomerMongoRepository repository;

    @RequestMapping("/all")
    public List<Customer> gerAll() {
        return repository.findAll();
    }
}
