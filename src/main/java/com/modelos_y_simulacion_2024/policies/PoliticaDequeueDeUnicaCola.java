package com.modelos_y_simulacion_2024.policies;

import java.util.List;
import com.modelos_y_simulacion_2024.dominio.Entidad;
import com.modelos_y_simulacion_2024.dominio.Server;

public class PoliticaDequeueDeUnicaCola implements SelectionPolicy<Server, Entidad>{

    @Override
    public Entidad select(int id,List<Server> options) {
        Entidad entity = null;
        for (Server s : options) {
            entity = s.getQueue().nextEntity();
        }
        return entity;
    }
    
}
