package com.jaganyv.dailymotivationapp.Service;

import com.jaganyv.dailymotivationapp.Model.Motivation;
import com.jaganyv.dailymotivationapp.Repository.MotivationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class MotivationService {
    @Autowired
    private final MotivationRepository repository;


    public MotivationService(MotivationRepository repository) {
        this.repository = repository;
    }

    public List<Motivation>  getAll(){
        return repository.findAll();
    }

    public Motivation addMotivation(Motivation motivation){
        return repository.save(motivation);
    }

    public Motivation getRandomMotivation(){
        List<Motivation> all = repository.findAll();
        if( all.isEmpty()) return null;
        Random random = new Random();
        return all.get(random.nextInt(all.size()));
    }

    public Motivation markAsFavorite(Long id){
        Optional<Motivation>  optional = repository.findById(id);
        if(optional.isEmpty()) return null;
        Motivation motivation = optional.get();
        motivation.setFavourite(true);
        return repository.save(motivation);
    }
    public void deleteByIid(Long id){
        repository.deleteById(id);
    }
}
