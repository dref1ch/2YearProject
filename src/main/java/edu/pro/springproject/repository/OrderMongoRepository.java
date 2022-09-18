package edu.pro.springproject.repository;

/*
 * @author JohnBuritto
 * @project SpringProject12
 * @class OrderMongoRepository
 * @version 1.0.0
 * @since 27.05.2022, 13:40
 * Software Engineering Department
 *
 * Copyright (c) 1993-1996 Sun Microsystems, Inc. All Rights Reserved.
 */

import edu.pro.springproject.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMongoRepository extends MongoRepository<Order, String> {

}
