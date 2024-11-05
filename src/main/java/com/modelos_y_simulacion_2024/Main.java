package com.modelos_y_simulacion_2024;

import com.modelos_y_simulacion_2024.dominio.DataManager;
import com.modelos_y_simulacion_2024.dominio.Engine;
import com.modelos_y_simulacion_2024.escenario.AirportOneToOne;
import com.modelos_y_simulacion_2024.escenario.Behaviors.Table;
import com.modelos_y_simulacion_2024.utils.Pair;
import com.modelos_y_simulacion_2024.policies.PoliticaDesencolarUnoAUno;
import com.modelos_y_simulacion_2024.policies.PoliticaSegundaEtapaQueue;
import com.modelos_y_simulacion_2024.policies.PoliticaSegundaEtapaServer;

public class Main {
    public static void main(String[] args) {

        double init_time = 0;
        double simulation_length = 40320;
        int serverQuantity = 1;

        DataManager dataManager = new DataManager();

        // Engine e = new Airport(
        //         0,
        //         150,
                // new Table(new Pair(10d, 0.35d), new Pair(15d, 0.45d), new Pair(17d, 0.2d)),
                // new Table(new Pair(8d, 0.38d), new Pair(10d, 0.32d), new Pair(13d, 0.1d), new Pair(15d, 0.2d)),
        //         new PoliticaDeUnicoServidor(),
        //         new PoliticaDeUnicaCola(),
        //         new PoliticaDeUnicoServidor(),
        //         new PoliticaDequeueDeUnicaCola(),
        //         dataManager);

        
        Engine e = new AirportOneToOne(
            init_time,
            simulation_length,
            serverQuantity,
            new Table(new Pair(10d, 0.35d), new Pair(15d, 0.45d), new Pair(17d, 0.2d)),
            new Table(new Pair(8d, 0.38d), new Pair(10d, 0.32d), new Pair(13d, 0.1d), new Pair(15d, 0.2d)),
            new PoliticaSegundaEtapaServer(),
            new PoliticaSegundaEtapaQueue(),
            new PoliticaSegundaEtapaServer(),
            new PoliticaDesencolarUnoAUno(),
            dataManager);

        // Engine e = new AirportOneToOne(
        //     0,
        //     100,
        //     1,
        //     new TestBehavior(10),
        //     new TestBehavior(11),
        //     new PoliticaDeUnicoServidor(),
        //     new PoliticaDeUnicaCola(),
        //     new PoliticaDeUnicoServidor(),
        //     new PoliticaDesencolarUnicoServer(),
        //     dataManager);
        e.execute();
        e.generate_report();
    }

    // public static void main(String[] args) {

    //     Normal normal = new Normal(10d, 4d);

    //     for (int i = 0; i < 100; i++) {

    //         System.out.println( normal.generarVariableNormal() );
    //     }
    // }
}
