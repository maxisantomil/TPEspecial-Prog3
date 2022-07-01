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
   
        
        // Ejercicio 3 : Obtener el grafo �nicamente con los g�neros afines a un g�nero A; es decir que,
        // partiendo del g�nero A, se consigui� una vinculaci�n cerrada entre uno o m�s
        // g�neros que permiti� volver al g�nero de inicio.
        
        Servicio3 servicio3= new Servicio3(grafoD);
        servicio3.buscarCiclo("viajes");
        
        // Ejercicio 2 : A partir de un g�nero A encontrar, en tiempo polinomial, la secuencia de g�neros
        // que m�s alto valor de b�squeda posee. Vamos a definir el valor de b�squeda de
        // una secuencia como la suma de los arcos que la componen.
        
        System.out.println("***************Secuencia de generos con mayor valor de busqueda ********************** ");
    	Servicio2 servicio2 = new Servicio2(grafoD);
        ArrayList<String>generoMayor=servicio2.generosMayorValor("viajes");
    	for(int i=0; i<generoMayor.size();i++){
    		System.out.println(generoMayor.get(i));
    	}
    	System.out.println("**********************************fin****************");
    	
        // Ejercicio 1 : Obtener los N g�neros m�s buscados luego de buscar por el g�nero A.

        ArrayList<String>generosMasBuscados=grafoD.generosMasBuscados("romance");
        System.out.println("Generos mas buscados: ");
        for (String g:generosMasBuscados) {
        	System.out.println(" "+g);
        }
        
	}
	
	
}