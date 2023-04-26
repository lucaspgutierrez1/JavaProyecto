
package com.mycompany.proyectofinal;

public class Persona {
    private String nombre;
    private int puntos;
    private Pronostico [] pronosticos;
    private int acertados;
    private int numPronosticos;
    private int iterador;
    
    public Persona(int maxPronosticos){
        this.pronosticos = new Pronostico[maxPronosticos];
        this.nombre = "";
        this.numPronosticos = 0;
        this.puntos = 0;
        this.acertados = 0;
    }
    
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public int getPuntos(){
        return puntos;
    }
    public void setPuntos(int puntos){
        this.puntos = puntos;
    }
    public int getAcertados(){
        return acertados;
    }
    public void setAcertados(int acertados){
        this.acertados = acertados;
    }
    public Pronostico getPronostico(int i){
        return pronosticos[i];
    }
    //imprime pronosticos
    public void imprimirPronosticos(){
        for(int i=0;i<this.pronosticos.length;i++){
            System.out.println(pronosticos[i].devolverPronostico());
        }
    }
    
    //agrega un pronostico
    public void addPronostico(Pronostico pron){
        if(numPronosticos < pronosticos.length){
            pronosticos[numPronosticos] = pron;
            numPronosticos++;
        }else{
            System.out.println("No hay espacio para mas pronosticos");
        }
    }
    
    //Calcular puntos
    public void contarPuntos(Ronda ronda,int cantPartidos){
        resultadoEnum resultLocal;
        for(int i = 0;i<cantPartidos;i++){
            //Genera un resultado para poder comparar con el pronostico
            resultLocal = ronda.getPartido(i).getResultado();
            
            //Agarro el vector de pronosticos y comparo empate
            if(pronosticos[this.iterador].getResultado().isEmpate() == false){
                //Si no hubo empate comparo el ganador
                if(pronosticos[this.iterador].getEquipoGanador().equals(resultLocal.getGanador())){
                    //Si la prediccion es igual al resultado real se suma 1 punto
                    this.puntos++;
                }
            }else{
                if(pronosticos[this.iterador].getResultado().isEmpate() == resultLocal.isEmpate()){
                    this.puntos++;
                }
            }
            this.iterador++;
        }
    }
}
