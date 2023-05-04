package com.umg.edu.manager.mru;

import org.springframework.stereotype.Service;

@Service
public class MRUManager {
    public double calcularVelocidad(double distancia, double tiempo) {
        return distancia / tiempo;
    }

    public double calcularDistancia(double velocidad, double tiempo) {
        return velocidad * tiempo;
    }

    public double calcularTiempo(double distancia, double velocidad) {
        return distancia / velocidad;
    }

    public double calcularMRU(Double distancia, Double velocidad, Double tiempo) throws IllegalAccessException {
        if (distancia == null || distancia == 0) {
            return calcularDistancia(velocidad, tiempo);
        } else if (velocidad == null || velocidad == 0) {
            return calcularVelocidad(distancia, tiempo);
        } else if (tiempo == null || tiempo == 0) {
            return calcularTiempo(distancia, velocidad);
        } else {
            throw new IllegalAccessException("No se puede calcular");
        }
    }
}