package com.mycompany.proyectofinal;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class ProyectoFinal {
    private static String linea;//Recibe la linea de cada fila
    private static String[] partes = null;//almacena cada linea
    
    public static void leerArchivo(String ruta){
        try{
            //lee archivo
            BufferedReader lector = new BufferedReader(new FileReader(ruta));
            while((linea = lector.readLine())!= null){//Lee la linea siempre que no este vacia
                partes = linea.split(",");//Separa los string desde el ;
                imprimirLinea();
                System.out.println(" ");
            }
            lector.close();
            linea = null;
            partes = null;
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void imprimirLinea(){
        for(String parte:partes){//Recorre el arreglo partes(donde se guardan las lineas)
            System.out.println(parte + " | ");//Lo separa con |
        }
    }
    public static void llenarRondas(String ruta,Ronda[] rondas){
        String csvFile = ruta;
        String csvDelimiter = ",";
        String[] expectativaHeader = {"Ronda","Equipo1","Goles1","Goles2","Equipo2"};
        try(BufferedReader br = new BufferedReader(new FileReader(csvFile))){
            //Leo y valido el header
            String[]header = br.readLine().split(csvDelimiter);
            if(header.equals(expectativaHeader)){
                throw new IllegalArgumentException("El archivo CSV no contiene las columnas que se esperaban");
            }
            while((linea = br.readLine())!= null){
                String[] fields = linea.split(csvDelimiter);
                //Creo partido para poder llenarlo con info del csv
                Partido partido = new Partido();
                partido.setEquipo1(fields[1]);
                partido.setGolesEquipo1(Integer.parseInt(fields[2].trim()));
                partido.setGolesEquipo2(Integer.parseInt(fields[3].trim()));
                partido.setEquipo2(fields[4]);
                //Creo resultadoLocal para poder llenarlo con la info que saque del partido y del csv
                resultadoEnum resultadoLocal = new resultadoEnum();
                //Decidir si mandar al objeto resultadoEnum
                if(partido.getGolesEquipo1() > partido.getGolesEquipo2()){
                    resultadoLocal.setGanador(partido.getEquipo1());
                    resultadoLocal.setPerdedor(partido.getEquipo2());                   
                }else{
                    if(partido.getGolesEquipo1() < partido.getGolesEquipo2()){
                        resultadoLocal.setGanador(partido.getEquipo2());
                        resultadoLocal.setPerdedor(partido.getEquipo1());
                    }else{
                        if(partido.getGolesEquipo1() == partido.getGolesEquipo2()){
                            resultadoLocal.setEmpate(true);
                        }
                    }
                }
                partido.setResult(resultadoLocal);
                //Agrego partido a su ronda
                rondas[Integer.parseInt(fields[0].trim())].addPartido(partido);
                
            }
        }catch(IOException e){ //Es por si ocurre un error con el csv
            e.printStackTrace();
        }
    }
    
    public static Ronda[] generarRondas(String ruta){
        String csvFile = ruta;
        String csvDelimiter = ",";
        String [] expectativaHeader = {"Ronda","Equipo1","Goles1","Goles2","Equipo2"};
        int numRondas = 0;
        try(BufferedReader br = new BufferedReader(new FileReader(csvFile))){
            //Leo y valido el header del csv
            String[] header = br.readLine().split(csvDelimiter);
            if(header.equals(expectativaHeader)){
                throw new IllegalArgumentException("El archivo CSV no contiene las columnas que se esperaban");
            }
            while((linea = br.readLine()) != null){
                String[]fields = linea.split(csvDelimiter);
                numRondas = Integer.parseInt(fields[0].trim());
            }
            numRondas++;
        
        }catch(IOException e){
            e.printStackTrace();
        }
        //Crea vector de rondas
        Ronda [] rondas = new Ronda[numRondas];
        return rondas;
    }
    
    public static int cantPartidos(String ruta){
        String csvFile = ruta;
        String csvDelimiter = ",";
        String [] expectativaHeader = {"Ronda","Equipo1","Goles1","Goles2","Equipo2"};
        //Cantidad sera usada para contar la cantidad de partidos por ronda
        int cantidad = 0;
        //rondaAct es para poder la contar la cantidad de partidos durante la primera ronda dentro del csv
        int rondaAct = 0;
        //rondaComp es para comparar con la ronda que quiero analizar que es rondaAct
        int rondaComp = 0;
        try(BufferedReader br = new BufferedReader(new FileReader(csvFile))){
            String[]header = br.readLine().split(csvDelimiter);
            if(header.equals(expectativaHeader)){
                throw new IllegalArgumentException("El archivo csv no contiene las columnas que se esperaba");
            }
            while((linea = br.readLine()) != null){
                String[] fields = linea.split(csvDelimiter);
                rondaComp = Integer.parseInt(fields[0]);
                
                if(rondaAct == rondaComp){
                    cantidad++;
                }   
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return cantidad;
    }
    
    public static void iniciarRondas(Ronda[] rondas,int cantPartidos){
        for(int i = 0;i < rondas.length;i++){
            Ronda ronda;
            ronda = new Ronda(cantPartidos);
            rondas[i] = ronda;
            rondas[i].setNro(i);
        }
    }
    
    public static void imprimirPersonas(Persona[] personas){
        for(int i=0;i<personas.length;i++){
            System.out.println("PERSONA: " + i);
            System.out.println("--------------");
            personas[i].imprimirPronosticos();
        }
    }
    
    public static void imprimirPartidos(Ronda [] rondas){
        for(int i = 0;i < rondas.length;i++){
            System.out.println("Ronda: " + i);
            System.out.println("----------");
            rondas[i].imprimirPartidos();
        }
    }
    
    public static void actualizarPuntos(Persona[] personas,Ronda[]rondas,int cantPartidos){
        for(int i = 0;i< personas.length;i ++){
            for(int j=0;j<rondas.length;j++){
                personas[i].contarPuntos(rondas[j],cantPartidos);
            }
        }
    }
    
    public static void imprimirPuntos(Persona[] personas){
        for(int i= 0;i<personas.length;i++){
            System.out.println("PUNTOS PERSONA; " +i);
            System.out.println("---------------");
            System.out.println(personas[i].getPuntos());
        }
    }
    public static void main(String[] args) {
        Conexion c1 = new Conexion();
        String rutaResultados = "../resultados.csv";
        
        ProyectoFinal.leerArchivo(rutaResultados);
        //calculo cantidad de partidos por ronda
        int cantidadPartidos = ProyectoFinal.cantPartidos(rutaResultados);
        //Creacion de las rondas
        Ronda [] rondas = ProyectoFinal.generarRondas(rutaResultados);
        ProyectoFinal.iniciarRondas(rondas, cantidadPartidos);
        //calculo cantidad de personas dentro de la db
        int cantidadPartidosTotales = rondas.length * cantidadPartidos;
        int cantidadPersonas = c1.devolverNumeroPersonas(cantidadPartidosTotales);
        System.out.println("cantidad de personas: " + cantidadPersonas);
        
        
        //Si hay rondas dentro del archivo
        if (rondas != null){
            //Lleno las rondas con la info del csv
            ProyectoFinal.llenarRondas(rutaResultados, rondas);
            //imprimo el vector rondas
            ProyectoFinal.imprimirPartidos(rondas);
            
            Persona[] personas = c1.generarPersonas(cantidadPartidosTotales, cantidadPersonas);
            //imprimo los pronosticos de las personas
            ProyectoFinal.imprimirPersonas(personas);
            //Actualizo puntos
            ProyectoFinal.actualizarPuntos(personas, rondas,cantidadPartidos);
            //imprimo puntos
            ProyectoFinal.imprimirPuntos(personas);
        }
        
    }
}
