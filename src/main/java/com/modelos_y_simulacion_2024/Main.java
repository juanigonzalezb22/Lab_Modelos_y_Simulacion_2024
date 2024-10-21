package com.modelos_y_simulacion_2024;

import com.modelos_y_simulacion_2024.dominio.Randomizer;
import com.modelos_y_simulacion_2024.dominio.Behavior;
import com.modelos_y_simulacion_2024.dominio.DataManager;
import com.modelos_y_simulacion_2024.dominio.Engine;
import com.modelos_y_simulacion_2024.escenario.Airport;
import com.modelos_y_simulacion_2024.escenario.Behaviors.Table;
import com.modelos_y_simulacion_2024.escenario.Behaviors.TestBehavior;
import com.modelos_y_simulacion_2024.utils.Pair;
import com.modelos_y_simulacion_2024.utils.distribuciones.EmpiricalDiscrete;
import com.modelos_y_simulacion_2024.utils.distribuciones.Exponential;
import com.modelos_y_simulacion_2024.utils.distribuciones.Uniform;
import com.modelos_y_simulacion_2024.utils.randomizers.TestRandomizer;
import com.modelos_y_simulacion_2024.utils.randomizers.TestRandomizer2;

public class Main {
    public static void main(String[] args) {
        TestRandomizer r1 = new TestRandomizer();
        TestRandomizer2 r2 = new TestRandomizer2();
        DataManager dataManager = new DataManager();

        Engine e = new Airport(
                0,
                150,
                new Table(new Pair(10d, 0.35d), new Pair(15d, 0.45d), new Pair(17d, 0.2d)),
                new Table(new Pair(8d, 0.38d), new Pair(10d, 0.32d), new Pair(13d, 0.1d), new Pair(15d, 0.2d)),
                dataManager);

        // Engine e = new Airport(0,100, new TestBehavior(10), new TestBehavior(11),
        // dataManager);
        e.execute();
        e.generate_report();
    }

    // public static void main(String[] args) {

    // EmpiricalDiscrete ed = new EmpiricalDiscrete(new Pair(5d,0.2d), new
    // Pair(6d,0.35d), new Pair(7d,0.2d), new Pair(8d,0.25d) );

    // System.out.println(ed.probabilidad(8)); // 0.25
    // System.out.println(ed.probabilidad(5)); // 0.2
    // System.out.println(ed.probabilidad(6)); // 0.35
    // System.out.println(ed.probabilidad(7)); // 0.2
    // System.out.println(ed.probabilidad(9)); // 0.0
    // System.out.println(ed.probabilidad(4)); // 0.0

    // System.out.println("============================");

    // System.out.println(ed.sample(0.22344d)); // 6
    // System.out.println(ed.sample(0.62d)); // 7
    // System.out.println(ed.sample(0.9d)); // 8
    // System.out.println(ed.sample(0d)); // 5
    // System.out.println(ed.sample(0.5)); // 6
    // System.out.println(ed.sample(1d)); // 8

    // System.out.println(ed.sample(1.5d)); // 8
    // System.out.println(ed.sample(0d)); // 5
    // }
}
