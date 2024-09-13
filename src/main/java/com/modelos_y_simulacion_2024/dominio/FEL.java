package com.modelos_y_simulacion_2024.dominio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FEL {
  private List<Event> fel_imp;
  private Comparator<Event> comparator;

  //0 salida
  //10 arribo

  public FEL(){
    this.fel_imp = new ArrayList<>();
    this.comparator = new Comparator<Event>() {
      @Override
      public int compare(Event e1, Event e2) {
        if( e1.getClock() < e2.getClock() ){
          return -1;
        } else if (e1.getClock() > e2.getClock()){
          return 1;
        } else if ( e1.getPlanificator().getTypeOrder() <  e2.getPlanificator().getTypeOrder() ){
          return -1;
        } else if (e1.getPlanificator().getTypeOrder() > e2.getPlanificator().getTypeOrder()){
          return 1;
        } else {
          return 0;
        }
      }
    };
  }
  
  public void insertEvent(Event e){
    this.fel_imp.add(e);
    this.fel_imp.sort(comparator);
  }

  public Event imminent(){
    return this.fel_imp.remove(0);
  }

  @Override
  public String toString() {
    String cadena = "-----------------------------------------------------\n";
    for(int i=0;i<this.fel_imp.size();i++){
      cadena += this.fel_imp.get(i).toString()+"\n";
    }
    cadena += "\n-----------------------------------------------------";
    return cadena;
  }
  
}
