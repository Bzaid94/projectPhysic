package com.umg.edu.manager.longitud;

public class LongitudManager {
    public static Double convertAMetros(double longitud, String origen) throws IllegalAccessException {
        switch(origen.toLowerCase()){
            case "metros" -> {
                return longitud;
            }
            case "kilometros" -> {
                return longitud * 1000;
            }
            case "millas" -> {
                return longitud * 1609.34;
            }
            case "pies" -> {
                return longitud * 0.3048;
            }
            case "pulgadas" -> {
                return longitud * 0.0254;
            }
            case "centimetros" -> {
                return longitud / 100;
            }
            default -> throw new IllegalAccessException("No se reconoce la unidad de medida "
            + origen);
        }
    }

    public static Double convertDeMetros(double longitudMetros, String destino) throws IllegalAccessException {
        switch(destino.toLowerCase()){
            case "metros" -> {
                return longitudMetros;
            }
            case "kilometros" -> {
                return longitudMetros / 1000;
            }
            case "millas" -> {
                return longitudMetros / 1609.34;
            }
            case "pies" -> {
                return longitudMetros / 0.3048;
            }
            case "pulgadas" -> {
                return longitudMetros / 0.0254;
            }
            case "centimetros" -> {
                return longitudMetros * 100;
            }
            default -> throw new IllegalAccessException("No se reconoce la unidad de medida "
            + destino);
        }
    }
}