package com.modelos_y_simulacion_2024;

import com.modelos_y_simulacion_2024.dominio.Randomizer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.modelos_y_simulacion_2024.dominio.Behavior;
import com.modelos_y_simulacion_2024.dominio.DataManager;
import com.modelos_y_simulacion_2024.dominio.Engine;
import com.modelos_y_simulacion_2024.escenario.Airport;
import com.modelos_y_simulacion_2024.escenario.Behaviors.Table;
import com.modelos_y_simulacion_2024.escenario.Behaviors.TestBehavior;
import com.modelos_y_simulacion_2024.utils.Pair;
import com.modelos_y_simulacion_2024.utils.distribuciones.EmpiricalDiscrete;
import com.modelos_y_simulacion_2024.utils.distribuciones.Exponential;
import com.modelos_y_simulacion_2024.utils.distribuciones.Normal;
import com.modelos_y_simulacion_2024.utils.distribuciones.Uniform;
import com.modelos_y_simulacion_2024.utils.randomizers.TestRandomizer;
import com.modelos_y_simulacion_2024.utils.randomizers.TestRandomizer2;

public class Main {
    // public static void main(String[] args) {
    //     TestRandomizer r1 = new TestRandomizer();
    //     TestRandomizer2 r2 = new TestRandomizer2();
    //     DataManager dataManager = new DataManager();

    //     Engine e = new Airport(
    //             0,
    //             150,
    //             new Table(new Pair(10d, 0.35d), new Pair(15d, 0.45d), new Pair(17d, 0.2d)),
    //             new Table(new Pair(8d, 0.38d), new Pair(10d, 0.32d), new Pair(13d, 0.1d), new Pair(15d, 0.2d)),
    //             dataManager);

    //     // Engine e = new Airport(0,100, new TestBehavior(10), new TestBehavior(11),
    //     // dataManager);
    //     e.execute();
    //     e.generate_report();
    // }

    public static void main(String[] args) {

        Normal normal = new Normal(10d, 4d);

        for (int i = 0; i < 100; i++) {

            System.out.println( normal.generarVariableNormal() );
        }
    }
}
