package com.modelos_y_simulacion_2024.escenario.Behaviors;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.modelos_y_simulacion_2024.dominio.Behavior;
import com.modelos_y_simulacion_2024.utils.Pair;
import com.modelos_y_simulacion_2024.utils.distribuciones.Exponential;

public class HoraPicoExponencial implements Behavior {

    private final Exponential exponential;
    private final Exponential exponential_hora_pico;
    private final List<Pair<Double, Double>> intervals;

    public HoraPicoExponencial(double muEstandar, double muHoraPico, List<Pair<Double, Double>> intervals) {
        this.exponential = new Exponential(60, muEstandar);
        this.exponential_hora_pico = new Exponential(60, muHoraPico);
        this.intervals = intervals;
    }

    @Override
    public double nextTime(double clock) {
        double hora = clock % 1440; // Hora actual en minutos (dentro de un día de 1440 minutos)

        // Verificar si la hora está dentro de algún intervalo en la lista
        boolean esHoraPico = intervals.stream()
                .anyMatch(interval -> hora >= interval.e1() && hora <= interval.e2());

        if (esHoraPico) {
            return this.exponential_hora_pico.sample(ThreadLocalRandom.current().nextDouble());
        } else {
            return this.exponential.sample(ThreadLocalRandom.current().nextDouble());
        }
    }
}
