package com.modelos_y_simulacion_2024;

import com.modelos_y_simulacion_2024.Utils.MyRandomizer;
import com.modelos_y_simulacion_2024.dominio.Randomizer;
import com.modelos_y_simulacion_2024.dominio.Engine;
import com.modelos_y_simulacion_2024.escenario.Airport;
import com.modelos_y_simulacion_2024.escenario.Behaviors.Tabla1;
import com.modelos_y_simulacion_2024.escenario.Behaviors.Tabla2;

public class Main {
    public static void main(String[] args) {
        Randomizer r = new MyRandomizer();
        Engine e = new Airport(100, new Tabla1(r), new Tabla2(r));
        e.execute();
        e.generate_report();
    }
}
