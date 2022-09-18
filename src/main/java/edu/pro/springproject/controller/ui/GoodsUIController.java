package edu.pro.springproject.controller.ui;/*
    @author Denys
    @project SpringProject
    @class GoodsUIController
    @version 1.0.0
    @since 03.04.2022 - 20 - 37
*/


import edu.pro.springproject.form.GoodsForm;
import edu.pro.springproject.model.Goods;
import edu.pro.springproject.model.TimeOfDelivery;
import edu.pro.springproject.service.GoodsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/ui/v1/goods")
public class GoodsUIController {

    @Autowired
    GoodsService service;

    @GetMapping("/all")
    public String getAll(Model model) {
        List<Goods> list = service.getAllGoods();
        model.addAttribute("goods", list);
        return "goods";
    }



/*
    @RequestMapping(value = "/pageEdit/{id}",method = RequestMethod.GET)
    public  String pageEdit(Model model,@PathVariable String id){
        Goods goods = service.getOneById(id);
        model.addAttribute("formEdit",goods);
        return "edit-goods";
    }
    @PostMapping( "/update" )
    public  String addGoods(Model model, @ModelAttribute("formEdit") Goods goods){
        service.update(goods);
        return "redirect:/ui/v1/goods/all";
    }

*/
 @RequestMapping(value = "/pageEdit/{id}", method = RequestMethod.GET)
public String pageEdit(Model model, @PathVariable("id") String id){
     Goods goods = service.getOneById(id);
     GoodsForm goodsForm = new GoodsForm();
     List<TimeOfDelivery> timesOfDelivery = Arrays.asList(TimeOfDelivery.values());
     goodsForm.setId(goods.getId());
     goodsForm.setName(goods.getName());
     goodsForm.setDescription(goods.getDescription());
     goodsForm.setCode(goods.getCode());
     goodsForm.setPrice(goods.getPrice());
     goodsForm.setDelivery(goods.getDelivery());
     goodsForm.setCreatedAt(goods.getCreatedAt().toString());
     model.addAttribute("formEdit",goodsForm);
     model.addAttribute("timesOfDelivery",timesOfDelivery);
    return "edit-goods";
}
    @RequestMapping(value = "/pageEdit/{id}", method = RequestMethod.POST)
    public String pageEdit(@PathVariable("id") String id,
                           @ModelAttribute("formEdit") GoodsForm goodsForm ){
        Goods goods = service.getOneById(goodsForm.getId());
        goods.setName(goodsForm.getName());
        goods.setDescription(goodsForm.getDescription());
        goods.setCode(goodsForm.getCode());
        goods.setPrice(goodsForm.getPrice());
        goods.setDelivery(goodsForm.getDelivery());
        LocalDate date = LocalDate.parse(goodsForm.getCreatedAt());
        LocalDateTime ldt = date.atStartOfDay();
        goods.setCreatedAt(LocalDate.parse(goodsForm.getCreatedAt()).atTime(1,1,1));
        service.update(goods);
        return "redirect:/ui/v1/goods/all";
    }


    @RequestMapping(value = "/put",method = RequestMethod.GET)
    public  String addGoods(Model model){
        GoodsForm goodsForm = new GoodsForm();
        List<TimeOfDelivery> times = Arrays.asList(TimeOfDelivery.values());
        model.addAttribute("form",goodsForm);
        model.addAttribute("times",times);
        return "add-goods";
    }
   @GetMapping("/delete/{id}")
   public  String getAll(Model model ,@PathVariable String id){
        service.delete(id);
       return "redirect:/ui/v1/goods/all";
   }

   @PostMapping( "/add" )
    public  String addGoods(Model model, @ModelAttribute("form") GoodsForm form){
        Goods goods= new Goods(form.getName(),form.getDescription(),form.getCode(),
                form.getPrice(),form.getDelivery());
        service.create(goods);
        return "redirect:/ui/v1/goods/all";
    }
}
