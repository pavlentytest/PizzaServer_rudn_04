package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @Autowired
    PizzaCRUD crud;

    @GetMapping("/add")
    public @ResponseBody String add(
            @RequestParam String name,
            @RequestParam Integer size) {
        Pizza pizza = new Pizza(name, size);
        crud.save(pizza);
        return "Saved successefull!";
    }

    @GetMapping("/list")
    public @ResponseBody Iterable<Pizza> getAll() {
        return crud.findAll();
    }
}
