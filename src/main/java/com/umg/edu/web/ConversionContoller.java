package com.umg.edu.web;

import com.umg.edu.manager.longitud.LongitudManager;
import com.umg.edu.manager.masa.MasaManager;
import com.umg.edu.manager.tiempo.TiempoManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conversion")
@CrossOrigin(origins = "${angular.url}", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ConversionContoller {

    @GetMapping("/convertLong/{longitud}/{original}/{destino}")
    public Double convertLongitud(@PathVariable("longitud") Double longitud, @PathVariable("original") String original, @PathVariable("destino") String destino) throws IllegalAccessException {
        double longitudMetros = LongitudManager.convertAMetros(longitud, original);
        return LongitudManager.convertDeMetros(longitudMetros, destino);
    }

    @GetMapping("/convertMasa/{masa}/{original}/{destino}")
    public Double convertMasa(@PathVariable("masa") Double masa, @PathVariable("original") String original, @PathVariable("destino") String destino) throws IllegalAccessException {
        double masaGramos = MasaManager.convertirAGramos(masa, original);
        return MasaManager.convertirDeGramos(masaGramos, destino);
    }

    @GetMapping("/convertTiempo/{time}/{original}/{destino}")
    public Double convertTime(@PathVariable("time") Double time, @PathVariable("original") String original, @PathVariable("destino") String destino) throws IllegalAccessException {
        double timeSegundos = TiempoManager.convertirASegundos(time, original);
        return TiempoManager.convertirDeSegundos(timeSegundos, destino);
    }
}