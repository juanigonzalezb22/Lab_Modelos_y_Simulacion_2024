package com.modelos_y_simulacion_2024;

import com.modelos_y_simulacion_2024.dominio.DataManager;
import com.modelos_y_simulacion_2024.dominio.DataManagerReplication;
import com.modelos_y_simulacion_2024.dominio.Engine;
import com.modelos_y_simulacion_2024.escenario.AirportEtapa1;
import com.modelos_y_simulacion_2024.escenario.AirportManyToOne;
import com.modelos_y_simulacion_2024.escenario.AirportOneToOne;
import com.modelos_y_simulacion_2024.escenario.Behaviors.BehaviorUniform;
import com.modelos_y_simulacion_2024.escenario.Behaviors.HoraPicoExponencial;
import com.modelos_y_simulacion_2024.escenario.Behaviors.Table;
import com.modelos_y_simulacion_2024.escenario.Behaviors.TestBehavior;
import com.modelos_y_simulacion_2024.policies.dequeSelectionPolicy.PoliticaDeMultiplesServidores;
import com.modelos_y_simulacion_2024.policies.dequeSelectionPolicy.PoliticaDeUnicoServidor2;
import com.modelos_y_simulacion_2024.policies.dequeSelectionPolicy.PoliticaDequeueDeUnicaCola;
import com.modelos_y_simulacion_2024.policies.dequeSelectionPolicy.PoliticaDesencolarUnoAUno;
import com.modelos_y_simulacion_2024.policies.selectionPolicy.PoliticaDeUnicaCola;
import com.modelos_y_simulacion_2024.policies.selectionPolicy.PoliticaSegundaEtapaQueue;
import com.modelos_y_simulacion_2024.policies.selectionPolicy.PoliticaSegundaEtapaServer;
import com.modelos_y_simulacion_2024.utils.Pair;
import com.modelos_y_simulacion_2024.utils.distribuciones.Exponential;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {

        double init_time = 0;
        double simulation_length = 40320; //40320
        int serverQuantity = 5;
        int cantReplicaciones=5;
        DataManagerReplication dataManagerPadre = new DataManagerReplication();
        DataManagerReplication dataManagerPadre2 = new DataManagerReplication();
        
        Exponential exp = new Exponential(60,15);
        System.err.println(exp.sample(ThreadLocalRandom.current().nextDouble()));
        System.err.println(exp.sample(ThreadLocalRandom.current().nextDouble()));
        System.err.println(exp.sample(ThreadLocalRandom.current().nextDouble()));
        System.err.println(exp.sample(ThreadLocalRandom.current().nextDouble()));
        System.err.println(exp.sample(ThreadLocalRandom.current().nextDouble()));


        System.out.println("\n********************** ETAPA 1 **********************");
        @SuppressWarnings({ "rawtypes", "unchecked" })
        Engine e1 = new AirportEtapa1(
                init_time,
                simulation_length,
                new Table(new Pair(10d, 0.35d), new Pair(15d, 0.45d), new Pair(17d, 0.2d)),
                new Table(new Pair(8d, 0.38d), new Pair(10d, 0.32d), new Pair(13d, 0.1d), new Pair(15d, 0.2d)),
                //new TestBehavior(10),
                //new TestBehavior(5),
                new DataManager(dataManagerPadre)
            );
        e1.execute();
        e1.generate_report();

        
        System.out.println("\n********************** ETAPA 2 **********************\n");
        Engine e2 = new AirportOneToOne(
            init_time,
            simulation_length,
            serverQuantity,
            new HoraPicoExponencial( 15, 9, Arrays.asList(
                    new Pair<>(540.0, 780.0),
                    new Pair<>(1200.0, 1380.0) 
                )),
            new BehaviorUniform( 10, 15 ),
            new PoliticaSegundaEtapaServer(),
            new PoliticaSegundaEtapaQueue(),
            new PoliticaDeUnicoServidor2(),
            new PoliticaDesencolarUnoAUno(),
            new DataManager(dataManagerPadre)
            );
        e2.execute();
        e2.generate_report();
        dataManagerPadre.generateReport();


        System.out.println("\n********************** ETAPA 3 **********************\n");
        for (int i = 0; i < cantReplicaciones; i++) {
            System.out.println("\nREPLICACION "+(i+1) );
            Engine e = new AirportManyToOne(
                init_time,
                simulation_length,
                serverQuantity,
                new HoraPicoExponencial( 15, 9.0, Arrays.asList(
                    new Pair<>(540.0, 780.0),  
                    new Pair<>(1200.0, 1380.0)
                )),
                new BehaviorUniform( 10, 15 ),
                new PoliticaSegundaEtapaServer(),
                new PoliticaDeUnicaCola(),
                new PoliticaDeMultiplesServidores(),
                new PoliticaDequeueDeUnicaCola(),
                new DataManager(dataManagerPadre2));
            e.execute();
            e.generate_report();
        }
        dataManagerPadre2.generateReport();
        
    }

    // public static void main(String[] args) {

    // Normal normal = new Normal(10d, 4d);

    // for (int i = 0; i < 100; i++) {

    // System.out.println( normal.generarVariableNormal() );
    // }
    // }
}
