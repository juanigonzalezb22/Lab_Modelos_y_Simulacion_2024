package com.modelos_y_simulacion_2024.utils.distribuciones;

public class Exponential implements Distribution {

    private final double lambda;
    private final double mu;

    public Exponential(double lambda){
        this.lambda = lambda;
        this.mu = 1d/lambda;
    }

    @Override
    public double probabilidad(double x) {
      if( x >= 0 ){
        return this.lambda * Math.pow(Math.E, -lambda * x);
      } else {
        return 0d;
      }
    }

    @Override
    public double sample(double x) {
      if( x >= 0 ){
        return -this.mu * Math.log(1-x);
      } else {
        return 0;
      }
    }
}
