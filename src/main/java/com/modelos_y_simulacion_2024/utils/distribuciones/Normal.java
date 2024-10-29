package com.modelos_y_simulacion_2024.utils.distribuciones;

import java.util.List;

public class Normal{
  
  public double probabilidad(double x, double media, double varianza){
    
    double desviacion_estandar = Math.sqrt(varianza);
    double z = (x - media) / desviacion_estandar;

    double distribucion_normal = (1 / ( desviacion_estandar * Math.sqrt(2 * Math.PI) ) ) * Math.exp( -0.5 * Math.pow(z, 2) );

    return distribucion_normal;
  }

  public double sample(double x, double media, double varianza){
    
    //COMPLETAR
    
    return 0.0;
  }

  public double generarVariableNormal( List<Double> varIdependientes, double mediaX, double varianzaX, double mediaY, double varianzaY ) {
    //PASO 1
    double normalAproximada = 0;
    for (int i=0; i < varIdependientes.size(); i++) {
      normalAproximada = normalAproximada + varIdependientes.get(i);
    }
    double mediaZ = mediaX * varIdependientes.size();
    double varianzaZ = varianzaX * varIdependientes.size();

    //PASO 2
    double normalEstandar = ( normalAproximada - mediaZ ) / Math.sqrt( varianzaZ );

    //PASO 3
    double Y = normalEstandar * Math.sqrt( varianzaY ) + mediaY;

    return Y;
  }

}
