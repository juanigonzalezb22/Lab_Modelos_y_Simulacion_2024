package com.modelos_y_simulacion_2024;

import java.util.List;

import com.modelos_y_simulacion_2024.dominio.DataManager;
import com.modelos_y_simulacion_2024.dominio.DataManagerReplication;
import com.modelos_y_simulacion_2024.dominio.Engine;
import com.modelos_y_simulacion_2024.escenario.AirportEtapa1;
import com.modelos_y_simulacion_2024.escenario.AirportOneToOne;
import com.modelos_y_simulacion_2024.escenario.Behaviors.HoraPicoExponencial;
import com.modelos_y_simulacion_2024.escenario.Behaviors.Table;
import com.modelos_y_simulacion_2024.escenario.Behaviors.TestBehavior;
import com.modelos_y_simulacion_2024.policies.PoliticaDeUnicoServidor;
import com.modelos_y_simulacion_2024.policies.PoliticaDeUnicoServidor2;
import com.modelos_y_simulacion_2024.policies.PoliticaDeUnicaCola;
import com.modelos_y_simulacion_2024.policies.PoliticaDesencolarUnoAUno;
import com.modelos_y_simulacion_2024.policies.PoliticaSegundaEtapaServer;
import com.modelos_y_simulacion_2024.policies.PoliticaSegundaEtapaQueue;
import com.modelos_y_simulacion_2024.utils.Pair;


public class Main {
    public static void main(String[] args) {

        double init_time = 0;
        double simulation_length = 100;
        int serverQuantity = 5;
        int cantReplicaciones=5;
        DataManagerReplication dataManagerPadre = new DataManagerReplication();
        

        System.out.println("\n********************** ETAPA 1 **********************");
        Engine e1 = new AirportEtapa1(
                init_time,
                40320,
                new Table(new Pair(8d, 0.38d), new Pair(10d, 0.32d), new Pair(13d, 0.1d), new Pair(15d, 0.2d)),
                new Table(new Pair(10d, 0.35d), new Pair(15d, 0.45d), new Pair(17d, 0.2d)),
                new DataManager(dataManagerPadre)
            );
            e1.execute();
            e1.generate_report();

        System.out.println("\n********************** ETAPA 2 **********************\n");

        Engine e2 = new AirportOneToOne(
            init_time,
            simulation_length,
            serverQuantity,
            new Table(new Pair(10d, 0.35d), new Pair(15d, 0.45d), new Pair(17d, 0.2d)),
            new Table(new Pair(8d, 0.38d), new Pair(10d, 0.32d), new Pair(13d, 0.1d), new Pair(15d, 0.2d)),
            new PoliticaSegundaEtapaServer(),
            new PoliticaSegundaEtapaQueue(),
            new PoliticaDeUnicoServidor2(),
            new PoliticaDesencolarUnoAUno(),
            new DataManager(dataManagerPadre)
            );
            e2.execute();
            e2.generate_report();

            System.out.println("\n********************** ETAPA 3 **********************\n");

        for (int i = 0; i < cantReplicaciones; i++) {
            System.out.println("\nREPLICACION "+(i+1) );
            Engine e = new AirportOneToOne(
                init_time,
                simulation_length,
                serverQuantity,
                new Table(new Pair(8d, 0.38d), new Pair(10d, 0.32d), new Pair(13d, 0.1d), new Pair(15d, 0.2d)),
                new Table(new Pair(10d, 0.35d), new Pair(15d, 0.45d), new Pair(17d, 0.2d)),
                new PoliticaDeUnicoServidor(),
                new PoliticaDeUnicaCola(),
                new PoliticaDeUnicoServidor2(),
                new PoliticaDesencolarUnoAUno(),
                new DataManager(dataManagerPadre));
            e.execute();
            e.generate_report();
        }
        dataManagerPadre.generateReport();
        
    }

    // public static void main(String[] args) {

    // Normal normal = new Normal(10d, 4d);

    // for (int i = 0; i < 100; i++) {

    // System.out.println( normal.generarVariableNormal() );
    // }
    // }
}
