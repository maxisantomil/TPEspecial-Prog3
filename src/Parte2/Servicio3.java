package Parte2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class Servicio3 {

	GrafoDirigido grafo;
	int tiempo;
    private HashMap<String,String> colores;
    private HashMap<String, Integer>visitados;
    private HashMap<String, Integer> finales;
    private ArrayList<String>solucionActual=new ArrayList<>();
    boolean tieneCiclo = false;
    String verticeOrigen;
   
    public Servicio3(GrafoDirigido grafo){
        this.grafo=grafo;
        this.colores=new HashMap<>();
        this.visitados=new HashMap<>();
        this.finales=new HashMap<>();
        this.verticeOrigen=null;
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


    public void buscarCiclo(String v){
    	this.verticeOrigen=v;
        Iterator<String>vertices=grafo.obtenerVertices();
        while(vertices.hasNext()){
            String vertice=vertices.next();
            this.colores.put(vertice,"blanco");
        }
        //agrega el verticeInicial a la solucion
        if (grafo.contieneVertice(verticeOrigen)) {
	        solucionActual.add(verticeOrigen);
	        encontrarSolucion(verticeOrigen);	        
        }
        else {
        	System.out.println("el genero no existe");
        }
    }

	private void encontrarSolucion(String vertex){ 
	    //Condicion Base: si el vertex es el vertice de inicio y el vertex es amarillo
	    if(vertex.equals(this.verticeOrigen) && this.colores.get(vertex).equals("amarillo")){
	      tieneCiclo = true;
	      System.out.println(" ");
	      mostrarGrafo();
	      //retorna para descubrir mas ciclos
	      return;
	    } 
        	
        Iterator <String> adyacentes=grafo.obtenerAdyacentes(vertex);
        while(adyacentes.hasNext()){
            String vertice=adyacentes.next();
            if(this.colores.get(vertice).equals("blanco")){
                this.colores.put(vertice, "amarillo");
                solucionActual.add(vertice);
                encontrarSolucion(vertice);
                this.colores.put(vertice, "blanco");
                solucionActual.remove(vertice);
            }
        }
        this.colores.put(vertex, "negro");
    }

   public void mostrarGrafo(){
	    GrafoDirigido grafoFinal= new GrafoDirigido();
        for(int i=0;i< solucionActual.size();i++){
        	if (i==0)
        		grafoFinal.agregarVertice(solucionActual.get(i), null);
        	else {
        		String padre = solucionActual.get(i-1);
        		grafoFinal.agregarVertice(solucionActual.get(i),padre);
        		grafoFinal.agregarArco(solucionActual.get(i),padre);
        	}
        }
        
        System.out.println("---------------Generos afines a x genero ---------------");
        Iterator<String> ItGeneros=grafoFinal.obtenerVertices();
        while (ItGeneros.hasNext()) {
        	String v= ItGeneros.next();
        	System.out.println(" "+ v);
        	
        }
     
        
        System.out.println("------------------------------");
  }
       
}
