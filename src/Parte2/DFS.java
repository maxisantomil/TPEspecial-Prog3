package Parte2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DFS {

	GrafoDirigido grafo;
	int tiempo;
    private HashMap<String,String> colores;
    private HashMap<String, Integer>visitados;
    private HashMap<String, Integer> finales;
   
    public DFS(GrafoDirigido grafo){
        this.grafo=grafo;
        this.colores=new HashMap<>();
        this.visitados=new HashMap<>();
        this.finales=new HashMap<>();
    }

    public HashMap<String, String> getColores() {
        return colores;
    }

    
    public void setColores( String v, String color) {
        this.colores.put(v, color);
    }

    public HashMap<String, Integer> getVisitados() {
        return visitados;
    }

    public HashMap<String, Integer> getFinales() {
        return finales;
    }

    public ArrayList<String> dfsCiclo(String verticeEntrada){
    	ArrayList<String>verticesPadres= new ArrayList<String>();
        Iterator<String> it=grafo.obtenerVertices();
        ArrayList<String> retorna= new ArrayList<String>();
        while(it.hasNext()){
            String vertice=it.next();
            this.colores.put(vertice, "blanco");
            //System.out.println("vertice " + vertice + "color " + colores.get(vertice));
           // System.out.println(colores.get(vertice));
        }
        tiempo=0;
//        Iterator<String> vertices=grafo.obtenerVertices();
//        while(vertices.hasNext()){
            //String vertice=vertices.next();
            if(colores.get(verticeEntrada).equals("blanco")){
              retorna.addAll(Dfs_VisitCiclo(verticeEntrada,verticesPadres));
            }
            return retorna;
    }
    private ArrayList<String> Dfs_VisitCiclo(String vertice,ArrayList<String>verticesPadres) {
    	ArrayList<String>verticesVisitados= new ArrayList<String>();
    	//verticesVisitados.add(vertice);
    
        this.colores.put(vertice,"amarillo");
        tiempo=tiempo+1;
        int d=tiempo;
        this.visitados.put(vertice, d);
    	String padreActual=vertice;
        Iterator<String> it=grafo.obtenerAdyacentes(vertice);
        while(it.hasNext()){
            String v=it.next();
            if(colores.get(v)=="blanco"){
            	verticesPadres.add(padreActual);
                Dfs_VisitCiclo(v,verticesPadres);
            }
            if(colores.get(v).equals("amarillo")){
            	  System.out.println("tiene ciclo");
            	  verticesVisitados.add(v);
            	  verticesVisitados.addAll(verticesPadres);
            }
        }
        this.colores.put(vertice,"negro");
        tiempo=tiempo+1;
        finales.put(vertice, tiempo);
        
        return verticesVisitados;
    }
    

}
