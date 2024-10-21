package com.modelos_y_simulacion_2024.utils;

public class Pair<T,E> {

    private final T e1;
    private final E e2;
    
    public Pair(T e1, E e2){
        this.e1 = e1;
        this.e2 = e2;
    }

    public T e1(){
        return e1;
    }

    public E e2(){
        return e2;
    }
}
