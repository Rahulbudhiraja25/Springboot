package com.learn.DatraFetch.Service;


import com.learn.DatraFetch.Entity.Toy;
import com.learn.DatraFetch.Repository.ToyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToyService {
    @Autowired
    public ToyRepository toyRepository;

    public String saveToy(Toy toy){
         try {
             toyRepository.save(toy);
         }
         catch (Exception e){
             return "Data not Stored";
         }
         return "Data Stored Successfuly";
    }


    public List<Toy> getToy(String name){
        return toyRepository.findByName(name);
    }
}
