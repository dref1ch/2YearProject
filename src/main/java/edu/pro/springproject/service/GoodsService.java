package edu.pro.springproject.service;/*
    @author Denys
    @project SpringProject
    @class GoodsService
    @version 1.0.0
    @since 17.03.2022 - 17 - 06
*/

import edu.pro.springproject.model.Goods;
import edu.pro.springproject.model.TimeOfDelivery;
import edu.pro.springproject.repository.GoodsMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class GoodsService {
    private LocalDateTime now = LocalDateTime.now();
    private List<Goods> goods = new ArrayList<>(
            Arrays.asList(
                    new Goods("10","PULL&BEAR  ","low cost shoes","1LBV1",920, TimeOfDelivery.ONEDAY,now,now),
                    new Goods("11","Zara ","avarage cost shoes","121LBV2",3200,TimeOfDelivery.ONEDAY,now,now),
                    new Goods("12","Timberland  ","high cost shoes","191LBV3",5400,TimeOfDelivery.ONEDAY,now,now),
                    new Goods("13","Tervolina  ","low cost shoes","21L2BV1",1240,TimeOfDelivery.ONEDAY,now,now),
                    new Goods("14","Mascotte ","avarage cost shoes","22L2BV2",4200,TimeOfDelivery.ONEDAY,now,now),
                    new Goods("15","Hogl ","high cost shoes","231LBV3",3000,TimeOfDelivery.ONEDAY,now,now))

    );

    @Autowired
    GoodsMongoRepository repository;

    @PostConstruct
    void init(){
        repository.saveAll(goods);
    }
    public  List<Goods> getAllGoods(){
        return repository.findAll();
    }


    public Goods getOneById(String id){
        return repository.findById(id).orElse(null);
    }

    public  Goods create(Goods goods){
      //  goods.setUpdatedAt(LocalDateTime.now());
        goods.setCreatedAt(LocalDateTime.now());
        goods.setUpdatedAt(LocalDateTime.now());
       // goods.setCreatedAt(repository.findById(goods.getId()).orElse(null).getCreatedAt());
        return  repository.save(goods);
    }
    public  Goods update(Goods goods) {
        goods.setUpdatedAt(LocalDateTime.now());
        return repository.save(goods);
    }
    public void  delete(String id){
        repository.deleteById(id);
    }

    public List<String> getGoodsNameNCode() {
        List<String> goods = new ArrayList<>();

        repository.findAll()
                .forEach(good -> goods.add(good.getName() + "(" + good.getCode() + ")"));

        return goods;
    }

    public Goods parseAndGetByCode(String goods) {
        goods = goods.replace('(', ' ');
        goods = goods.replace(')', ' ');

        List<String> goodsComponents = Arrays.asList(goods.split(" +"));

        return repository.queryFindByCode(goodsComponents.get(goodsComponents.size() - 1));
    }
}
