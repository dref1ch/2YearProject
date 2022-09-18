package edu.pro.springproject.service;/*
    @author Denys
    @project SpringProject12
    @class CustomerService
    @version 1.0.0
    @since 27.05.2022 - 15 - 53
*/


import edu.pro.springproject.model.*;
import edu.pro.springproject.repository.CustomerMongoRepository;
import edu.pro.springproject.repository.GoodsMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CustomerService {
    private LocalDateTime now = LocalDateTime.now();
    private List<Customer> customers = new ArrayList<>(
            Arrays.asList(
                    new Customer("1","Jon","some description",
                            new Address("UKR","IF","unknown"," jovtneva"," 20","unknown")
                            ,new ContactPerson("Denys","Anatoliyovych","Antonyuk ","09854700","Example@gmail.com"),now ,now))



    );

    @Autowired
    CustomerMongoRepository repository;

    @PostConstruct
    void init(){
        repository.saveAll(customers);
    }
    public  List<Customer> getAllCustomers(){
        return repository.findAll();
    }


    public Customer getOneById(String id){
        return repository.findById(id).orElse(null);
    }

    public  Customer create(Customer customers){
        //  goods.setUpdatedAt(LocalDateTime.now());
        customers.setCreatedAt(LocalDateTime.now());
        customers.setUpdatedAt(LocalDateTime.now());
        // goods.setCreatedAt(repository.findById(goods.getId()).orElse(null).getCreatedAt());
        return  repository.save(customers);
    }
    public  Customer update(Customer customers) {
        customers.setUpdatedAt(LocalDateTime.now());
        return repository.save(customers);
    }
    public void  delete(String id){
        repository.deleteById(id);
    }
/*
    public List<String> getCustomersNameNCode() {
        List<String> customers = new ArrayList<>();

        repository.findAll()
                .forEach(good -> customers.add(customers.getName() + "(" + customers.add(customers.) + ")"));

        return customers;
    }
*/
    /*
    public Goods parseAndGetByCode(String goods) {
        goods = goods.replace('(', ' ');
        goods = goods.replace(')', ' ');

        List<String> goodsComponents = Arrays.asList(goods.split(" +"));

        return repository.queryFindByCode(goodsComponents.get(goodsComponents.size() - 1));
    }

     */
}