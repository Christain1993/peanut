package com.christain.peanut.spring_mvc_study.controller;

import com.christain.peanut.common.domain.Period;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PeanutSpringController {

    @RequestMapping(value = "/peanut" ,method = RequestMethod.GET)
    public void peanut(Period period) {
        System.out.println(period);
    }

    @RequestMapping(value = "/show" ,method = RequestMethod.GET)
    public String show() {
        return "helloword";
    }


}
