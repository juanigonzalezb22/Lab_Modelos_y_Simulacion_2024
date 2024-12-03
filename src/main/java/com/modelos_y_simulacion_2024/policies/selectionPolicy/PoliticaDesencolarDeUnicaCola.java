package com.modelos_y_simulacion_2024.policies.selectionPolicy;


import java.util.List;
import com.modelos_y_simulacion_2024.dominio.Entity;
import com.modelos_y_simulacion_2024.dominio.Server;

public class PoliticaDesencolarDeUnicaCola implements SelectionPolicy<Server, Entity> {
    //Modelar bien que informacion es necesario para poder implementar deque policies
    @Override
    public Entity select( List<Server> options) {
        Entity entidad = null;
        for (Server s : options) {
            entidad = s.getQueue().nextEntity();
        }
        return entidad;
    }
    

}
