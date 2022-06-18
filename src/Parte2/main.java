package Parte2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Timer;


import java.util.*;
public class main {

	public static void main(String[] args) {
		GrafoDirigido grafoD = new GrafoDirigido();
		
        String csvFile = "src/datasets/generos/dataset1.csv";
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
        System.out.println();
        Iterator<String> ItGeneros=grafoD.obtenerVertices();
        while (ItGeneros.hasNext()) {
        	String v= ItGeneros.next();
        	LinkedList<String> padres= grafoD.obtenerVertice(v).getPadres();
        	System.out.println(padres.size());
        	 Iterator<String> ItPadres=padres.iterator();
        	 while (ItPadres.hasNext()) {
        		 System.out.println("padre de"+ grafoD.obtenerVertice(v)+": "+ ItPadres.next());
        	 }
        }
        grafoD.obtenerArcos("viajes");
        Iterator<Arco> ItArcos=grafoD.obtenerArcos("viajes");
        System.out.println(grafoD.existeArco("viajes", "juegos"));
        while (ItArcos.hasNext()) {
    		System.out.println(ItArcos.next());
        }
	}
}