package com.umg.edu.manager.masa;

import org.springframework.stereotype.Service;

@Service
public class MasaManager {
    public static Double convertirAGramos(double masa, String origen){
        switch(origen.toLowerCase()){
            case "gramos" -> {
                return masa;
            }
            case "kilogramos" -> {
                return masa * 1000;
            }
            case "libras" -> {
                return masa * 453.592;
            }
            case "onzas" -> {
                return masa * 28.3495;
            }
            default -> throw new IllegalArgumentException("No se reconoce la unidad de medida "
            + origen);
        }
    }

    public static Double convertirDeGramos(double masa, String destino){
        switch(destino.toLowerCase()){
            case "gramos" -> {
                return masa;
            }
            case "kilogramos" -> {
                return masa / 1000;
            }
            case "libras" -> {
                return masa / 453.592;
            }
            case "onzas" -> {
                return masa / 28.3495;
            }
            default -> throw new IllegalArgumentException("No se reconoce la unidad de medida "
            + destino);
        }
    }
}