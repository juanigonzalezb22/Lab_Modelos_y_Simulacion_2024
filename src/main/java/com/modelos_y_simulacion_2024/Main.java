package com.modelos_y_simulacion_2024;

import com.modelos_y_simulacion_2024.dominio.Randomizer;
import com.modelos_y_simulacion_2024.dominio.DataManager;
import com.modelos_y_simulacion_2024.dominio.Engine;
import com.modelos_y_simulacion_2024.escenario.Airport;
import com.modelos_y_simulacion_2024.escenario.Behaviors.Tabla1;
import com.modelos_y_simulacion_2024.escenario.Behaviors.Tabla2;
import com.modelos_y_simulacion_2024.escenario.Behaviors.TestBehavior;
import com.modelos_y_simulacion_2024.utils.MyRandomizer;
import com.modelos_y_simulacion_2024.utils.TestRandomizer;
import com.modelos_y_simulacion_2024.utils.TestRandomizer2;
import com.modelos_y_simulacion_2024.utils.distribuciones.Exponential;
import com.modelos_y_simulacion_2024.utils.distribuciones.Uniform;

public class Main {
    // public static void main(String[] args) {
    //     TestRandomizer r1 = new TestRandomizer();
    //     TestRandomizer2 r2 = new TestRandomizer2();
    //     DataManager dataManager = new DataManager();

    //     //Engine e = new Airport(0,150, new Tabla1(r1), new Tabla2(r2), dataManager);

    //     Engine e = new Airport(0,100, new TestBehavior(10), new TestBehavior(11), dataManager);
    //     e.execute();
    //     e.generate_report();
    // }

    public static void main(String[] args) {
        Exponential exp = new Exponential(3d);

        System.out.println("\n\nExponential:\n");
        System.out.println(exp.sample(0.1d));
        System.out.println(exp.sample(0.7d));
        System.out.println(exp.sample(0.9d));

        Uniform uni = new Uniform(5, 10);
        System.out.println("\n\nUniform:\n");
        
        System.out.println(uni.sample(0.22344d));
        System.out.println(uni.sample(0.62d));
        System.out.println(uni.sample(0.9d));
        System.out.println(uni.sample(0d));
        System.out.println(uni.sample(0.5));
        System.out.println(uni.sample(1d));
    }
}
