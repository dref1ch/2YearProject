package edu.pro.springproject.controller.ui;/*
    @author Denys
    @project SpringProject12
    @class TransportUIController
    @version 1.0.0
    @since 24.05.2022 - 23 - 13
*/
import edu.pro.springproject.form.GoodsForm;
import edu.pro.springproject.form.TransportForm;
import edu.pro.springproject.model.Goods;
import edu.pro.springproject.model.TimeOfDelivery;
import edu.pro.springproject.model.Transport;
import edu.pro.springproject.service.GoodsService;
import edu.pro.springproject.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/ui/v1/transport")
public class TransportUIController {

    @Autowired
    TransportService service;

    @GetMapping("/all")
    public String getAll(Model model) {
        List<Transport> list = service.getAllTransport();
        model.addAttribute("transport", list);
        return "transport";
    }

    @RequestMapping(value = "/pageEdit/{id}", method = RequestMethod.GET)
    public String pageEdit(Model model, @PathVariable("id") String id){
        Transport transport = service.getOneById(id);
        TransportForm transportForm = new TransportForm();
        //List<TimeOfDelivery> timesOfDelivery = Arrays.asList(TimeOfDelivery.values());
        transportForm.setId(transport.getId());
        transportForm.setName(transport.getName());
        transportForm.setDescription(transport.getDescription());
        transportForm.setMileage(transport.getMileage());
        transportForm.setCreatedAt(LocalDateTime.parse(transport.getCreatedAt().toString()));//
        model.addAttribute("formEdit",transportForm);
        //model.addAttribute("timesOfDelivery",timesOfDelivery);
        return "edit-transport";
    }
    @RequestMapping(value = "/pageEdit/{id}", method = RequestMethod.POST)
    public String pageEdit(@PathVariable("id") String id,
                           @ModelAttribute("formEdit") TransportForm transportForm ){
        Transport transport = service.getOneById(transportForm.getId());
        transport.setName(transportForm.getName());
        transport.setDescription(transportForm.getDescription());
        transport.setMileage(transportForm.getMileage());
       // LocalDate date = LocalDate.parse(transportForm.getCreatedAt());
       // LocalDateTime ldt = date.atStartOfDay();
        //transport.setCreatedAt(LocalDate.parse(transportForm.getCreatedAt()).atTime(1,1,1));
        service.update(transport);
        return "redirect:/ui/v1/transport/all";
    }


    @RequestMapping(value = "/put",method = RequestMethod.GET)
    public  String addTransport(Model model){
        TransportForm transportForm = new TransportForm();
        model.addAttribute("form",transportForm);
        return "add-transport";
    }
    @GetMapping("/delete/{id}")
    public  String getAll(Model model ,@PathVariable String id){
        service.delete(id);
        return "redirect:/ui/v1/transport/all";
    }

    @PostMapping( "/add" )
    public  String addTransport(Model model, @ModelAttribute("form") TransportForm form){
        Transport transport= new Transport(form.getName(),form.getDescription(),form.getMileage());
        service.create(transport);
        return "redirect:/ui/v1/transport/all";
    }


}
