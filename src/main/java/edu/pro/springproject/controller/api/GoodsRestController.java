package edu.pro.springproject.controller.api;

import edu.pro.springproject.model.Goods;
import edu.pro.springproject.service.GoodsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/goods")
public class GoodsRestController {
   @Autowired
    GoodsService service;

    @GetMapping("/all")
    @ApiOperation(value = "Get all goods from our goods list",
            produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "We get our list of goods", response = Goods.class),
            @ApiResponse(code = 500, message = "An error occured")
    })
    public  List<Goods>getAll(){
        return service.getAllGoods();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get  goods by ID from our goods list",
            produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "We get our   goods from ID", response = Goods.class),
            @ApiResponse(code = 500, message = "An error occured")
    })
    public  Goods getById(@PathVariable(value = "id")String id){
        return  service.getOneById(id);
    }
    @PostMapping("/")
    @ApiOperation(value = "Create goods to our goods list",
            produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Goods created", response = Goods.class),
            @ApiResponse(code = 500, message = "An error occured")
    })
    public Goods create(@RequestBody Goods goods){
        return  service.create(goods);
    }
    @PutMapping("/")
    @ApiOperation(value = "Update goods from our goods list",
            produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "We updated  goods", response = Goods.class),
            @ApiResponse(code = 500, message = "An error occured")
    })
    public Goods update(@RequestBody Goods goods){
        return  service.update(goods);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete goods by ID from our goods list",
            produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "We delete Goods by ID from our list of goods", response = Goods.class),
            @ApiResponse(code = 500, message = "An error occured")
    })
    public void delete(@PathVariable(value = "id")String id){
        service.delete(id);
    }


    /*
    /////////////////////////////////////////////////////////////////////////
    @GetMapping("/delete/{id}")
    public Goods deleteById(@PathVariable(value = "id") String id) {
    Goods goodsToDelete = service.getAllGoods().stream().filter(goods1 -> goods1.getId().equals(id))
            .findFirst().get();
    boolean success = service.getAllGoods().remove(goodsToDelete);
    return (success) ? goodsToDelete : null ;
    }
*/

}
