
package com.mycompany.proyectofinal;

public class Ronda {
    private int nro;
    private Partido [] partidos;
    private int numPartidos;
    
    public Ronda(int maxPartido){
        this.partidos = new Partido[maxPartido];
        this.numPartidos = 0;
    }
    
    public int getNro(){
        return this.nro;
    }
    
    public void setNro(int nro){
        this.nro = nro;
    }
    
    public int getVectorLength(){
        return partidos.length;
    }
    
    public Partido getPartido(int i){
        return partidos[i];
    }
    
    public void imprimirPartidos(){
        for(Partido partido: partidos){
            System.out.println("Equipo 1: "+ partido.getEquipo1() + " Equipo 2: "+partido.getEquipo2() + " Goles 1:" + partido.getGolesEquipo1() + " Goles 2: " + partido.getGolesEquipo2());   
        }
    }
    
    public void addPartido(Partido part){
        if (numPartidos < partidos.length){
            partidos[numPartidos] = part;
            numPartidos++;
        }else{
            System.out.println("No hay espacio para mas partidos. ");
        }
    }
}
