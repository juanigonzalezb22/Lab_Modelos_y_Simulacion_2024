package com.modelos_y_simulacion_2024.policies;


import java.util.List;
import com.modelos_y_simulacion_2024.dominio.Entidad;
import com.modelos_y_simulacion_2024.dominio.Server;

public class PoliticaDesencolarDeUnicaCola implements SelectionPolicy<Server, Entidad> {
    //Modelar bien que informacion es necesario para poder implementar deque policies
    @Override
    public Entidad select( List<Server> options) {
        Entidad entidad = null;
        for (Server s : options) {
            entidad = s.getQueue().nextEntity();
        }
        return entidad;
    }
    

}
