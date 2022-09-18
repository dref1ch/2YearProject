package edu.pro.springproject.controller;

import edu.pro.springproject.model.Goods;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
public class ProjectController {
    @GetMapping("/title")
    String mainPage() {
        String out = "<p align=center>Міністерство освіти і науки України " +
                "<br><a href=\"http://chnu.edu.ua/index.php?page=ua\">Чернівецький національний університет </a>" +
                "<br><a href=\"http://ptcsi.chnu.edu.ua/\">\"Інститут фізико-технічних та комп'ютерних наук\"</a>" +
                "<br>імені Юрія Федьковича<p>";
        out += "<h2 align=center style = \"margin-top: 150px\">Курсовий проєкт\n</h2>" +
                "<h3 align=center>по темі: \"Продаж товару\"</h3>";
        out += "<pre><p align=center style = \"margin-top: 100px\">                       " +
                " <br>                                                  Виконав:" +
                "<br>                                           Студент 2 курсу,"+
                "<br>                                                 217 групи"+
                "<br>                                           126спеціальності" +
                "<br>                         Інформаційні системи та технології" +
                "<br>                                               Антонюк Д.А." +
                "<br>                                     Керівник:Прохоров.Г.В." +
                "<br>                                   Нормконтролер Борча М.Д." +
                "</p>";
        out += "<pre><p align=center style = \"margin-top: 100px\">                       " +
                " <br><b>До захисту допущено:                                </b>" +
                " <br>   Дата захисту  _________ 2022 рік                        " +
                "</p>";
        out += "<pre><p align=center style = \"margin-top: 100px\">                       " +
                " <br>                        <b>Дата захисту: ________ 2022 р.</b> " +
                " <br>                                         <b>Оцінка :</b>" +
                "<br>                               за національною шкалою __ " +
                "<br>                               за кількість балів  __    " +
                "<br>                               за  шкалою ECTS __        " +
                "</p>";
        out += "<pre><p align=center style = \"margin-top: 100px\">                       " +
                "<br><b>Керівник______                                     </b>" +
                "<br><b>Нормкотролер______                                </b> " +
                "</p>";
        out += "<h4 align=center style = \"margin-top: 100px\">" +
                "<a href=\"https://uk.wikipedia.org/wiki/%D0%A7%D0%B5%D1%80%D0%BD%D1%96%D0%B2%D1%86%D1%96\">Чернівці</a>"
                + " " + LocalDateTime.now().getYear() + "</h4>";

        return out;
    }
}