package com.umg.edu.manager.mruv;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MRUVManager {
    public double calcularAceleracion(double velocidadInicial, double velocidadFinal, double tiempo){
        return (velocidadFinal - velocidadInicial) / tiempo;
    }

    public double calcularVelocidadMedia(double velocidadInicial, double velocidadFinal){
        return (velocidadFinal + velocidadInicial) / 2;
    }

    public double calcularDistancia(double velocidadInicial, double velocidadFinal, double tiempo){
        return ((velocidadInicial + velocidadFinal) / 2) * tiempo;
    }

    public double calcularVelocidadFinal(double velocidadInicial, double aceleracion, double tiempo){
        return velocidadInicial + (aceleracion * tiempo);
    }

    public double calcularDistanciaSinVf(double velocidadInicial, double aceleracion, double tiempo){
        return velocidadInicial * tiempo + (aceleracion * Math.pow(tiempo, 2)) / 2;
    }

    public double calcularDistanciaSinVo(double velocidadFinal, double aceleracion, double tiempo){
        return velocidadFinal * tiempo - (aceleracion * Math.pow(tiempo, 2)) / 2;
    }

    public double calcularDistanciaSinT(double VelocidadFinal, double velocidadInicial, double aceleracion){
        return (Math.pow(VelocidadFinal, 2) - Math.pow(velocidadInicial, 2)) / (2 * aceleracion);
    }

    public Map<String, Double> calcularMRUV(Double distancia, Double velocidadInicial , Double velocidadFinal, Double tiempo, Double aceleracion){
        Map<String, Double> resultados = new HashMap<>();

        if (distancia == 0 && tiempo == 0) {
            resultados.put("Distancia", calcularDistanciaSinT(velocidadFinal, velocidadInicial, aceleracion));
        }else if(distancia == 0 && velocidadFinal == 0){
            resultados.put("Distancia", calcularDistanciaSinVf(velocidadInicial, aceleracion, tiempo));
        }else if (distancia == 0){
            resultados.put("Distancia", calcularDistancia(velocidadInicial, velocidadFinal, tiempo));
        }

        if(velocidadFinal == 0){
            resultados.put("Velocidad Final", calcularVelocidadFinal(velocidadInicial, aceleracion, tiempo));
        }

        if(velocidadFinal == 0) {
            Double newVelocidadFinal = resultados.get("Velocidad Final");
            resultados.put("Velocidad Media", calcularVelocidadMedia(velocidadInicial, newVelocidadFinal));
        }

        if(velocidadFinal > 0){
            resultados.put("Velocidad Media", calcularVelocidadMedia(velocidadInicial, velocidadFinal));
        }

        if(aceleracion == 0){
            double vf = velocidadFinal == 0 ? (2 * distancia - velocidadInicial * tiempo) / tiempo : velocidadFinal;
            resultados.put("Aceleración", calcularAceleracion(velocidadInicial, vf, tiempo));
        }

        if(tiempo == 0){
            double vf = velocidadFinal == 0 ? (2 * distancia) / velocidadInicial : velocidadFinal;
            resultados.put("Tiempo", (vf - velocidadInicial) / aceleracion);
        }

        return resultados;
    }
}