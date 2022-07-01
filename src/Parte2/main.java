package Parte2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Timer;


import java.util.*;
public class main {

	public static void main(String[] args) {
		GrafoDirigido grafoD = new GrafoDirigido();
		String genero;
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
        try {
        	do {
        	 BufferedReader entrada= new BufferedReader(new InputStreamReader(System.in));
        	 System.out.println("Ingrese un genero");
        	 genero=entrada.readLine();
        	 System.out.println("Ingrese el número del servicio que desea implementar");
        	 System.out.println(" 1- obtener los N géneros más buscados luego de buscar por el género A");
        	 System.out.println(" 2- encontrar a partir de un género A la secuencia que posee mayor valor de búsqueda");
        	 System.out.println(" 3- obtener el grafo únicamente con los géneros afines a A");
        	 String aux= entrada.readLine();
        	 if(aux.equals("1")) {
        		// Ejercicio 1 : Obtener los N géneros más buscados luego de buscar por el género A.
      	        ArrayList<String>generosMasBuscados=grafoD.generosMasBuscados(genero);
      	        System.out.println("*************** Géneros más buscados a partir de " + genero + " *************** ");
      	        for (String g:generosMasBuscados) {
      	        	System.out.println(" "+g);
      	        }
      	        System.out.println("");
        	 }
        	 if(aux.equals("2")) {
				 // Ejercicio 2 : A partir de un género A encontrar, en tiempo polinomial, la secuencia de géneros
				 // que más alto valor de búsqueda posee. Vamos a definir el valor de búsqueda de
				 // una secuencia como la suma de los arcos que la componen. 
    	        System.out.println("***************Secuencia de géneros con mayor valor de búsqueda *************** ");
    	    	Servicio2 servicio2 = new Servicio2(grafoD);
    	        ArrayList<String>generoMayor=servicio2.generosMayorValor(genero);
    	    	for(int i=0; i<generoMayor.size();i++){
    	    		System.out.println(generoMayor.get(i));
    	    	}
    	    	System.out.println("****************fin de la secuencia ***************");
    	    	System.out.println("");
        	 }
        	 if (aux.equals("3")) {
        		 // Ejercicio 3 : Obtener el grafo únicamente con los géneros afines a un género A; es decir que,
		        // partiendo del género A, se consiguió una vinculación cerrada entre uno o más
		        // géneros que permitió volver al género de inicio.
        		System.out.println("***************Géneros afines a " + genero+" *************** ");
		        Servicio3 servicio3= new Servicio3(grafoD);
		        servicio3.buscarCiclo("viajes");
		        System.out.println("****************fin del ciclo ***************");
		        System.out.println("");
        	 }
        	}while(genero!=null);
        }catch(Exception e) {
        	 System.out.println(e);
        }
	}   

}