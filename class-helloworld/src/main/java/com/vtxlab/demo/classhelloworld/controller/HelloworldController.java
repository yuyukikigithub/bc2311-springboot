package com.vtxlab.demo.classhelloworld.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vtxlab.demo.classhelloworld.model.Cat;

@Controller // web layer, provide capability of API (application programming interface)
@ResponseBody // return JSON (Format of data transmission)
@RequestMapping(value="api/v1") // base path of URI: version 
public class HelloworldController {
    // no attribute, constructor, 
    // but have instance method 
    @GetMapping(value = "/hello") // endpoint
    public String helloworld(){
        return "Welcome to Spring boot.";
    }

    @GetMapping(value = "/getInteger")
    public Integer sthReturn(){
        return (int) 'a';
    }

    @GetMapping(value = "/getCharacter")
    public Character charReturn(){
        return 'a';
    }

    @GetMapping(value = "/getCat")
    public Cat catReturn(){
        return Cat.builder()
            .name("kitten")
            .age(1)
            .build();
    }

    @GetMapping(value = "/getCatList")
    public List<Cat> catReturnList(){
        return new ArrayList<>(List.of(new Cat("kitty", 1),new Cat("Anne", 2)));
        // return Stream.of(new Cat("kitty", 1),new Cat("Anne", 2)).collect(Collectors.toList())
    }

    @GetMapping(value = "/getCatArray")
    public Cat[] catReturnArray(){
        return this.catReturnList().toArray(new Cat[0]);
    }
    
}


