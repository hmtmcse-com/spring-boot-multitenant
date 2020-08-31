package com.hmtmcse.multitenant.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BismillahController {

    @GetMapping("/")
    @ResponseBody
    public String bismillah(){
        return "Bismillah";
    }

    // https://www.bytefish.de/blog/spring_boot_multitenancy.html
}
