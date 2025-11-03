package com.jaganyv.dailymotivationapp.Controller;

import com.jaganyv.dailymotivationapp.Model.Motivation;
import com.jaganyv.dailymotivationapp.Service.MotivationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/motivation")
public class MotivationController {
    @Autowired
    private MotivationService motivationService;
    public MotivationController(MotivationService motivationService) {
        this.motivationService = motivationService;
    }
    @GetMapping("/all")
    public List<Motivation> getAll(){
        return motivationService.getAll();
    }
    @GetMapping("/random")
    public Motivation getRandom(){
        Motivation m = motivationService.getRandomMotivation();
        if(m == null)
            throw new RuntimeException("No motivation found");
        return m;
    }
        @PostMapping
                public Motivation addMotivation(@RequestBody Motivation m){
              return motivationService.addMotivation(m);
        }
        @PutMapping("/{id}/favorite")
                public  Motivation markFavourite(@PathVariable Long id){
            return motivationService.markAsFavorite(id);
        }
     @DeleteMapping("/{id}")
             public void delete(@PathVariable Long id){
                motivationService.deleteByIid(id);
            }
}
