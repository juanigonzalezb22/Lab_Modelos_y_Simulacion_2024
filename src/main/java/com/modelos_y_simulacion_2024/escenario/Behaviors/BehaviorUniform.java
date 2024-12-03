package com.modelos_y_simulacion_2024.escenario.Behaviors;

import com.modelos_y_simulacion_2024.dominio.Behavior;
import com.modelos_y_simulacion_2024.utils.distribuciones.Uniform;

import java.util.concurrent.ThreadLocalRandom;

public class BehaviorUniform implements Behavior {

    private final Uniform uniform; 

    public BehaviorUniform(double a, double b) {
        this.uniform = new Uniform(a, b); 
    }

    @Override
    public double nextTime(double clock) {
        double randomValue = ThreadLocalRandom.current().nextDouble();
        return this.uniform.sample(randomValue);
    }
}
