package edu.pro.springproject.service;/*
    @author Denys
    @project SpringProject12
    @class TransportService
    @version 1.0.0
    @since 24.05.2022 - 22 - 31
*/


import edu.pro.springproject.model.TimeOfDelivery;
import edu.pro.springproject.model.Transport;
import edu.pro.springproject.repository.TransportMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TransportService {
    private LocalDateTime now = LocalDateTime.now();
    private List<Transport> transport = new ArrayList<>(
            Arrays.asList(
                    new Transport("1","Mercedes Sprinter","Avtobus",now,now,127000),
                    new Transport("2","Deo Lanos","Avtobus",now,now,127000),
                    new Transport("3","Weo VG","Avtobus",now,now,127000))
    );

    @Autowired
    TransportMongoRepository repository;

    @PostConstruct
    void init(){
        repository.saveAll(transport);
    }
    public  List<Transport> getAllTransport(){
        return repository.findAll();
    }


    public Transport getOneById(String id){
        return repository.findById(id).orElse(null);
    }

    public  Transport create(Transport transport){
        //  goods.setUpdatedAt(LocalDateTime.now());
        transport.setCreatedAt(LocalDateTime.now());
        transport.setUpdatedAt(LocalDateTime.now());
        // goods.setCreatedAt(repository.findById(goods.getId()).orElse(null).getCreatedAt());
        return  repository.save(transport);
    }
    public  Transport update(Transport transport) {
        transport.setUpdatedAt(LocalDateTime.now());
        return repository.save(transport);
    }
    public void  delete(String id){
        repository.deleteById(id);
    }

    public List<String> getTransportsNId() {
        List<String> transports = new ArrayList<>();

        repository.findAll()
                .forEach(transport -> transports.add(transport.getName() + "(" + transport.getId() + ")"));

        return transports;
    }

    public Transport parseAndGetById(String transport) {
        transport = transport.replace('(', ' ');
        transport = transport.replace(')', ' ');

        List<String> transportComponents = Arrays.asList(transport.split(" +"));

        return getOneById(transportComponents.get(transportComponents.size() - 1));
    }
}