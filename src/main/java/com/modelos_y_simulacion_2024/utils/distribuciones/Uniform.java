package com.modelos_y_simulacion_2024.utils.distribuciones;

public class Uniform implements Distribution {

    private final double a,b;

    public Uniform(double a, double b){
        this.a = a;
        this.b = b;        
    }

    @Override
    public double probabilidad(double x) {
        if(x >= this.a && x <= this.b){
            return 1d/(this.b-this.a);
        }
        return 0d;
    }

    @Override
    public double sample(double x) {
        return  x * ( this.b - this.a ) + this.a;
    }
}
