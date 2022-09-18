package edu.pro.springproject.repository;

/*
 * @author JohnBuritto
 * @project SpringProject12
 * @class CustomerMongoRepository
 * @version 1.0.0
 * @since 26.05.2022, 16:05
 * Software Engineering Department
 *
 * Copyright (c) 1993-1996 Sun Microsystems, Inc. All Rights Reserved.
 */

import edu.pro.springproject.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerMongoRepository extends MongoRepository<Customer, String> {

}
