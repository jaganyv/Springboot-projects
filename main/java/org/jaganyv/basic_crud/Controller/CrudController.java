package org.jaganyv.basic_crud.Controller;

import org.jaganyv.basic_crud.Service.CrudService;
import org.jaganyv.basic_crud.entity.Crud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class CrudController {
    @Autowired
    private CrudService cs;
    @GetMapping("/home")
    public List<Crud> getAll(){
        return cs.getAllTasks();
    }
    @PostMapping()
    public Crud postAll(@RequestBody Crud cd){
        return cs.postAllTasks(cd);
    }
    @GetMapping("/{id}")
    public Crud getById(@PathVariable Crud cd1){
        return cs.getByIdd(cd1);
    }
    @PutMapping("/{id}")
    public Crud updateId(@PathVariable int id , @RequestBody Crud cd3){
        return cs.updateById(id,cd3);
    }

    @DeleteMapping("/{id}")
    public String deleteId(@PathVariable int id) {
        return cs.deleteById(id);
    }


}
