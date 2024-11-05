package com.modelos_y_simulacion_2024.escenario.Behaviors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.modelos_y_simulacion_2024.dominio.Behavior;
import com.modelos_y_simulacion_2024.utils.Pair;
import com.modelos_y_simulacion_2024.utils.distribuciones.EmpiricalDiscrete;

public class Table implements Behavior {

    private final EmpiricalDiscrete ed;

    public Table(List<Pair<Double, Double>> pairs){
        this.ed = new EmpiricalDiscrete(pairs);
    }

    public Table(Pair<Double, Double>... pairs){
        List<Pair<Double,Double>> pairsAux = new ArrayList<>();
        
        for (Pair<Double, Double> p : pairs) {
            pairsAux.add(p);
        }

        this.ed = new EmpiricalDiscrete(pairs);
    }

    @Override
    public double nextTime(double clock) {
        return this.ed.sample(ThreadLocalRandom.current().nextDouble());
    }
}
