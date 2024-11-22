package com.modelos_y_simulacion_2024.policies;

import java.util.List;

import com.modelos_y_simulacion_2024.dominio.Entidad;
import com.modelos_y_simulacion_2024.dominio.Server;

public class PoliticaDesencolarUnicoServer implements SelectionPolicy<Server, Entidad>{

    @Override
    public Entidad select( List<Server> options) {
        
        return options.get(0).getQueue().nextEntity();

    }
    

}
