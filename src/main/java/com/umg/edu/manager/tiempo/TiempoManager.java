package com.umg.edu.manager.tiempo;

import org.springframework.stereotype.Service;

@Service
public class TiempoManager {
    public static Double convertirASegundos(double tiempo, String origen){
        switch(origen.toLowerCase()){
            case "segundos" -> {
                return tiempo;
            }
            case "minutos" -> {
                return tiempo * 60;
            }
            case "horas" -> {
                return tiempo * 3600;
            }
            case "dias" -> {
                return tiempo * 86400;
            }
            case "anios" -> {
                return tiempo * 31536000;
            }
            default -> throw new IllegalArgumentException("No se reconoce la unidad de medida "
            + origen);
        }
    }

    public static Double convertirDeSegundos(double tiempo, String destino){
        switch(destino.toLowerCase()){
            case "segundos" -> {
                return tiempo;
            }
            case "minutos" -> {
                return tiempo / 60;
            }
            case "horas" -> {
                return tiempo / 3600;
            }
            case "dias" -> {
                return tiempo / 86400;
            }
            case "anios" -> {
                return tiempo / 31536000;
            }
            default -> throw new IllegalArgumentException("No se reconoce la unidad de medida "
            + destino);
        }
    }
}