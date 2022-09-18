package edu.pro.springproject.controller.api;/*
    @author Denys
    @project SpringProject12
    @class TransportRestController
    @version 1.0.0
    @since 24.05.2022 - 22 - 56
*/
import edu.pro.springproject.model.Goods;
import edu.pro.springproject.model.Transport;
import edu.pro.springproject.service.GoodsService;
import edu.pro.springproject.service.TransportService;
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
@RequestMapping("/api/v1/transport")

public class TransportRestController {

    @Autowired
    TransportService service;

    @GetMapping("/all")
    @ApiOperation(value = "Get all transport from our goods list",
            produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "We get our list of transport", response = Transport.class),
            @ApiResponse(code = 500, message = "An error occured")
    })
    public  List<Transport>getAll(){
        return service.getAllTransport();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get  transport by ID from our transport list",
            produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "We get our   transport from ID", response = Transport.class),
            @ApiResponse(code = 500, message = "An error occured")
    })
    public  Transport getById(@PathVariable(value = "id")String id){
        return  service.getOneById(id);
    }
    @PostMapping("/")
    @ApiOperation(value = "Create transport to our goods list",
            produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "transport created", response = Transport.class),
            @ApiResponse(code = 500, message = "An error occured")
    })
    public Transport create(@RequestBody Transport transport){
        return  service.create(transport);
    }
    @PutMapping("/")
    @ApiOperation(value = "Update transport from our transport list",
            produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "We updated  transport", response = Transport.class),
            @ApiResponse(code = 500, message = "An error occured")
    })
    public Transport update(@RequestBody Transport transport){
        return  service.update(transport);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete transport by ID from our transport list",
            produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "We delete Transport by ID from our list of transport", response = Transport.class),
            @ApiResponse(code = 500, message = "An error occured")
    })
    public void delete(@PathVariable(value = "id")String id){
        service.delete(id);
    }
}
