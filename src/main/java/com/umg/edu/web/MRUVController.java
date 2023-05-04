package com.umg.edu.web;

import com.umg.edu.manager.mruv.MRUVManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/mruv")
@CrossOrigin(origins = "${angular.url}", methods = { RequestMethod.POST, RequestMethod.GET})
public class MRUVController {
    MRUVManager manager = new MRUVManager();

    @GetMapping("/calcularmruv")
    public ResponseEntity<Map<String, Double>> calcularMRUV(@RequestParam (required = false) Double distancia,
                                                            @RequestParam (required = false) Double velocidadInicial,
                                                            @RequestParam (required = false) Double velocidadFinal,
                                                            @RequestParam (required = false) Double tiempo,
                                                            @RequestParam (required = false) Double aceleracion) {
        Map<String, Double> resultados = manager.calcularMRUV(distancia, velocidadInicial, velocidadFinal, tiempo, aceleracion);

        return new ResponseEntity<>(resultados, HttpStatus.OK);
    }
}
