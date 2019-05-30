package com.dream.house.controller;

import com.dream.house.model.House;
import com.dream.house.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomepageController {

    @Autowired
    private RecommendService recommendService;

    @RequestMapping("index")
    public String accountsRegister(ModelMap modelMap){
        List<House> houses =  recommendService.getLastest();
        modelMap.put("recomHouses", houses);
        return "/homepage/index";
    }


    @RequestMapping("")
    public String index(ModelMap modelMap){
        return "redirect:/index";
    }
}
