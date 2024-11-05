package com.modelos_y_simulacion_2024.escenario.Behaviors;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.modelos_y_simulacion_2024.dominio.Behavior;
import com.modelos_y_simulacion_2024.utils.Pair;
import com.modelos_y_simulacion_2024.utils.distribuciones.Exponential;

public class HoraPicoExponencial implements Behavior {

    private final Exponential exponential;
    private final Exponential exponential_hora_pico;
    private final List<Pair<Double,Double>> intervals; 


    public HoraPicoExponencial(double muEstandar, double horaPico, List<Pair<Double,Double>> intervals ){
        this.exponential = new Exponential(muEstandar);
        this.exponential_hora_pico = new Exponential(horaPico);
        this.intervals = intervals;
    }

    @Override
    public double nextTime(double clock) {
        
        // if( clock ){
        //     return this.exponential_hora_pico.sample(ThreadLocalRandom.current().nextDouble());
        // }
        // else{
        //     return this.exponential.sample(ThreadLocalRandom.current().nextDouble());
        // }
        return clock;
    }

}
