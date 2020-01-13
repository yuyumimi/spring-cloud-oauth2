package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName Controller
 * @Description TODO
 * @Author yuyu
 * @Date 2019/7/2 15:34
 * @Version 1.0
 **/
@RestController("/rest")
public class Controller {

        @GetMapping(value = "/hello")
    public String rest(){
        return "hello jenkins";
    }
}
