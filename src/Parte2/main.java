package Parte2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Timer;


import java.util.*;
public class main {

	public static void main(String[] args) {
		GrafoDirigido<String> grafoD = new GrafoDirigido<String>();
		
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
        		}
        			
        		
        	}
        }
        System.out.println();
        Iterator<String> ItGeneros=grafoD.obtenerVertices();
        while (ItGeneros.hasNext()) {
        	String v= ItGeneros.next();
        	System.out.println("padre de"+ grafoD.obtenerVertice(v)+": "+grafoD.obtenerVertice(v).getPadre());
        }
//        grafoD.obtenerArcos("viajes");
//        Iterator<Arco<String>> ItArcos=grafoD.obtenerArcos("viajes");
//        while (ItArcos.hasNext()) {
//    		System.out.println(ItArcos.next());
//        }
	}
}