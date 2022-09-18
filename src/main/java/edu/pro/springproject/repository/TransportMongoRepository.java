package edu.pro.springproject.repository;/*
    @author Denys
    @project SpringProject12
    @class TransportMongoRepository
    @version 1.0.0
    @since 24.05.2022 - 22 - 34
*/

import edu.pro.springproject.model.Transport;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface TransportMongoRepository extends MongoRepository<Transport, String> {

}
