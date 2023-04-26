package com.mycompany.proyectofinal;


public class Pronostico {
    private Partido partido;
    private String equipo;
    private resultadoEnum resultado;
    
    public Pronostico(){
        this.equipo="";
    }
    public void setPartido(Partido partido){
        this.partido = partido;
    }
    
    public resultadoEnum getResultado(){
        return resultado;
    }
    
    public void setResultado(resultadoEnum resultado){
        this.resultado = resultado;
    }
    
    public String devolverPronostico(){
        String imp="";
        if (this.equipo.equals("")){
            imp= "Selecciono empate";
        }else{
            imp = "Equipo ganador: " + this.equipo;
        }
        return imp;
    }
    
    public String getEquipoGanador(){
        return equipo;
    }
    
    public void setEquipoGanador(String equipo){
        this.equipo= equipo;
    }
}
