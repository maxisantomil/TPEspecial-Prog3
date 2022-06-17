package Parte2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class CSVReader {
private String path;
    
    public CSVReader(String path) {
    	this.path=path;
    }
	
    public ArrayList<ArrayList<String>> readContent(){
    	
    	ArrayList<ArrayList<String>>solucion=new ArrayList<>();
        String line = "";
        String cvsSplitBy = ";";
        try (BufferedReader br = new BufferedReader(new FileReader(this.path))) {
        	br.readLine(); 
            while ((line = br.readLine()) != null) {
                String[] items = line.split(cvsSplitBy);
                //System.out.println(items);
                for (String p:items) {
                    String linePalabra= ",";
                	String[]palabras= p.split(linePalabra);
                	ArrayList<String>generos=new ArrayList<>();
                	for(String palabra: palabras) {
                		generos.add(palabra);
                	}
                	solucion.add(generos);
                }  
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
      
        return solucion;
        
    }
}