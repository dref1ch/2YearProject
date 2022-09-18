package edu.pro.springproject.controller.ui;

/*
 * @author JohnBuritto
 * @project SpringProject12
 * @class CustomerUIController
 * @version 1.0.0
 * @since 26.05.2022, 16:20
 * Software Engineering Department
 *
 * Copyright (c) 1993-1996 Sun Microsystems, Inc. All Rights Reserved.
 */

import edu.pro.springproject.form.CustomerForm;
import edu.pro.springproject.form.TransportForm;
import edu.pro.springproject.model.Address;
import edu.pro.springproject.model.ContactPerson;
import edu.pro.springproject.model.Customer;
import edu.pro.springproject.model.Transport;
import edu.pro.springproject.repository.CustomerMongoRepository;
import edu.pro.springproject.service.CustomerService;
import edu.pro.springproject.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/ui/v1/customers")
public class CustomerUIController {
    @Autowired
    CustomerMongoRepository repository;
    @Autowired
    CustomerService service;

    @RequestMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("customers", repository.findAll());
        return "customers";
    }

    @RequestMapping(value = "/pageEdit/{id}", method = RequestMethod.GET)
    public String pageEdit(Model model, @PathVariable("id") String id){
        Customer customers = service.getOneById(id);
        CustomerForm customerForm = new CustomerForm();
        //List<TimeOfDelivery> timesOfDelivery = Arrays.asList(TimeOfDelivery.values());
        customerForm.setId(customers.getId());
        customerForm.setName(customers.getName());
        customerForm.setDescription(customers.getDescription());
        //customerForm.setAddress(customers.getAddress());
        //customerForm.setContactPerson(customers.getContactPerson());
        customerForm.setCreatedAt(LocalDateTime.parse(customers.getCreatedAt().toString()));//
        model.addAttribute("formEdit",customerForm);
        //model.addAttribute("timesOfDelivery",timesOfDelivery);
        return "edit-transport";
    }
    @RequestMapping(value = "/pageEdit/{id}", method = RequestMethod.POST)
    public String pageEdit(@PathVariable("id") String id,
                           @ModelAttribute("formEdit") CustomerForm customerForm ){
        Customer customers = service.getOneById(customerForm.getId());
        customers.setName(customerForm.getName());
        customers.setDescription(customerForm.getDescription());
        //customers.setAddress(customerForm.getAddress());
        //customers.setContactPerson(customerForm.getContactPerson());
        // LocalDate date = LocalDate.parse(transportForm.getCreatedAt());
        // LocalDateTime ldt = date.atStartOfDay();
        //transport.setCreatedAt(LocalDate.parse(transportForm.getCreatedAt()).atTime(1,1,1));
        service.update(customers);
        return "redirect:/ui/v1/customers/all";
    }


    @RequestMapping(value = "/put",method = RequestMethod.GET)
    public String addCustomers(Model model){
        CustomerForm customersForm = new  CustomerForm();
        model.addAttribute("form",customersForm );
        return "add-customers";
    }

    @RequestMapping(value = "/put",method = RequestMethod.POST)
    public String addCustomers(@ModelAttribute("form") CustomerForm form){
        Address address = new Address(form.getCountry(), form.getDistrict(), form.getSettlement(),
                form.getStreet(), form.getHouseNumber(), form.getApartmentNumber());
        ContactPerson contactPerson = new ContactPerson(form.getFirstName(), form.getMiddleName(),
                form.getLastName(), form.getTelephoneNumber(), form.geteMail());
        Customer customer = new Customer();

        customer.setName(form.getName());
        customer.setDescription(form.getDescription());
        customer.setAddress(address);
        customer.setContactPerson(contactPerson);
        customer.setCreatedAt(LocalDateTime.now());
        customer.setUpdatedAt(LocalDateTime.now());

        service.create(customer);

        return "redirect:/ui/v1/customers/all";
    }

    @GetMapping("/delete/{id}")
    public  String getAll(Model model ,@PathVariable String id){
        service.delete(id);
        return "redirect:/ui/v1/customers/all";
    }
}
