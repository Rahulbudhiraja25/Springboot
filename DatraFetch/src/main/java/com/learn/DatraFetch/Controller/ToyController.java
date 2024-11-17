package com.learn.DatraFetch.Controller;


import com.learn.DatraFetch.Entity.Toy;
import com.learn.DatraFetch.Service.ToyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ToyController {
    @Autowired
    public ToyService toyService;
    @PostMapping("/save/toy")
    public String store(@RequestBody Toy toy) {
        return toyService.saveToy(toy);
    }
        @GetMapping("/get/toy")
        public List<Toy> getToy(@RequestParam String name){
            return toyService.getToy(name);
        }

}
