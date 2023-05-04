package com.umg.edu.web;

import com.umg.edu.manager.mru.MRUManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mru")
@CrossOrigin(origins = "${angular.url}", methods = { RequestMethod.GET })
public class MRUController {
    MRUManager manager = new MRUManager();

    @GetMapping("/calcularMRU")
    public Double calcularMRU(@RequestParam (required = false) Double distancia,
                              @RequestParam (required = false) Double velocidad,
                              @RequestParam (required = false) Double tiempo) throws IllegalAccessException {
        return manager.calcularMRU(distancia, velocidad, tiempo);
    }
}