package com.khanhdx.finalproject;

import com.khanhdx.finalproject.domain.dto.EntitiesDTO;
import com.khanhdx.finalproject.domain.model.Entities;
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

    @PutMapping("/update")
    public void update(@RequestParam Long id, @RequestBody Entities entitiesUpdate){
        Entities entities = repositories.findEntitiesById(id);
        entities.setName(entitiesUpdate.getName());
        repositories.save(entities);
    }

    @DeleteMapping("/delete")
    public void delete (@RequestParam Long id){
        Entities entities = repositories.getOne(id);
        repositories.delete(entities);
    }

}
