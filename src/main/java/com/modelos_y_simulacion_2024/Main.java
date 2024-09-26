package com.modelos_y_simulacion_2024;

import com.modelos_y_simulacion_2024.Utils.MyRandomizer;
import com.modelos_y_simulacion_2024.Utils.TestRandomizer;
import com.modelos_y_simulacion_2024.Utils.TestRandomizer2;
import com.modelos_y_simulacion_2024.dominio.Randomizer;
import com.modelos_y_simulacion_2024.dominio.DataManager;
import com.modelos_y_simulacion_2024.dominio.Engine;
import com.modelos_y_simulacion_2024.escenario.Airport;
import com.modelos_y_simulacion_2024.escenario.Behaviors.Tabla1;
import com.modelos_y_simulacion_2024.escenario.Behaviors.Tabla2;
import com.modelos_y_simulacion_2024.escenario.Behaviors.TestBehavior;

public class Main {
    public static void main(String[] args) {
        TestRandomizer r1 = new TestRandomizer();
        TestRandomizer2 r2 = new TestRandomizer2();
        DataManager dataManager = new DataManager();

        // Engine e = new Airport(200, new Tabla1(r1), new Tabla2(r2), dataManager);

        Engine e = new Airport(0,100, new TestBehavior(10), new TestBehavior(11), dataManager);
        e.execute();
        e.generate_report();
    }
}
