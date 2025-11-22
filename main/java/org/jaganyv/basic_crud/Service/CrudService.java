package org.jaganyv.basic_crud.Service;

import lombok.Data;
import org.jaganyv.basic_crud.entity.Crud;
import org.jaganyv.basic_crud.repository.CrudRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@Data
public class CrudService {
    @Autowired
    private CrudRepo cr;
    public List<Crud> getAllTasks() {
        return cr.findAll();
    }

    public Crud postAllTasks(@RequestBody Crud cd) {
        return cr.save(cd);
    }

    public Crud getByIdd(Crud cd1) {
        return cr.findById(cd1.getId()).orElse(null);
    }

    public Crud updateById(int id, Crud cd3) {
        Crud existing = cr.findById(id).orElse(null);
        if(existing == null) return null;
        existing.setTask(cd3.getTask());
        return cr.save(existing);
    }

    public String deleteById(int id) {

        if (!cr.existsById(id)) {
            return "ID Not Found";
        }

        cr.deleteById(id);
        return "Deleted Successfully";
    }

}
