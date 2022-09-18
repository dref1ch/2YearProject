package edu.pro.springproject.repository;/*
    @author Denys
    @project SpringProject
    @class GoodsMongoRepository
    @version 1.0.0
    @since 17.03.2022 - 17 - 49
*/

import edu.pro.springproject.model.Goods;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsMongoRepository extends MongoRepository<Goods, String> {
    @Query(value = "{code:  ?0}")
    public Goods queryFindByCode(String code);
}
