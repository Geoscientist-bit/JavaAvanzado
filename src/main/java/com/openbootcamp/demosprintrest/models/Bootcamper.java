package com.openbootcamp.demosprintrest.models;

//contiene la información sobre los objetos que vamos a trabajar

public class Bootcamper {
    private String nombre;
    private double valor;

    public Bootcamper(){}
    public Bootcamper(String nombre){ this.nombre = nombre; }
    public String getNombre(){ return nombre; }
    public void setNombre(String nombre){ this.nombre = nombre; }

}
