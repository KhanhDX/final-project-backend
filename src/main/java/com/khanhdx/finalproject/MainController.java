package com.khanhdx.finalproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app")
public class MainController {
    @Autowired
    private Repositories repositories;

    @GetMapping("/a")
    public List<Entities> all(){
        return repositories.findAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody Entities entities){
        repositories.saveAndFlush(entities);
    }

}
