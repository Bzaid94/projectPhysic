package com.umg.edu.web;

import com.umg.edu.manager.leyesNewton.LeyesNewtonManager;
import org.springframework.web.bind.annotation.*;

@RestController
    @RequestMapping("/leyesnewton")
@CrossOrigin(origins = "${angular.url}", methods = { RequestMethod.GET })
public class LeyesNewtonController {

    LeyesNewtonManager manager = new LeyesNewtonManager();

    @GetMapping("/calcular")
    public Double calcularPeso(@RequestParam (required = false) Double masa) {
        return manager.calcularPeso(masa);
    }
}
