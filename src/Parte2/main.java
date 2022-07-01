package Parte2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Timer;


import java.util.*;
public class main {

	public static void main(String[] args) {
		GrafoDirigido grafoD = new GrafoDirigido();
		
        String csvFile = "src/datasets/generos/datasetGrupo.csv";
        CSVReader reader=new CSVReader(csvFile);
        ArrayList<ArrayList<String>>generosingresados=reader.readContent();

       
        for(ArrayList<String> g:generosingresados) {
        	String padre =" ";
        	for(int i=0; i< g.size();i++) {
        		if (i==0) {
        			grafoD.agregarVertice(g.get(i),padre);
        		}
        		else {
        			String padre2 = g.get(i-1);
        			grafoD.agregarVertice(g.get(i),padre2);
        			grafoD.agregarArco(g.get(i), padre2);
        		}
        			
        		
        	}
        }
   
        
        // Ejercicio 3 : Obtener el grafo únicamente con los géneros afines a un género A; es decir que,
        // partiendo del género A, se consiguió una vinculación cerrada entre uno o más
        // géneros que permitió volver al género de inicio.
        
        Servicio3 servicio3= new Servicio3(grafoD);
        servicio3.buscarCiclo("viajes");
        
        // Ejercicio 2 : A partir de un género A encontrar, en tiempo polinomial, la secuencia de géneros
        // que más alto valor de búsqueda posee. Vamos a definir el valor de búsqueda de
        // una secuencia como la suma de los arcos que la componen.
        
        System.out.println("***************Secuencia de generos con mayor valor de busqueda ********************** ");
    	Servicio2 servicio2 = new Servicio2(grafoD);
        ArrayList<String>generoMayor=servicio2.generosMayorValor("viajes");
    	for(int i=0; i<generoMayor.size();i++){
    		System.out.println(generoMayor.get(i));
    	}
    	System.out.println("**********************************fin****************");
    	
        // Ejercicio 1 : Obtener los N géneros más buscados luego de buscar por el género A.

        ArrayList<String>generosMasBuscados=grafoD.generosMasBuscados("romance");
        System.out.println("Generos mas buscados: ");
        for (String g:generosMasBuscados) {
        	System.out.println(" "+g);
        }
        
	}
	
	
}