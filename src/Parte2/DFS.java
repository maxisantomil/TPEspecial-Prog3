package Parte2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class DFS {

	GrafoDirigido grafo;
	int tiempo;
    private HashMap<String,String> colores;
    private HashMap<String, Integer>visitados;
    private HashMap<String, Integer> finales;
    private ArrayList<String>solucionActual=new ArrayList<>();
    boolean tieneCiclo = false;
    String verticeOrigen;
   
    public DFS(GrafoDirigido grafo){
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
        solucionActual.add(verticeOrigen);
        //
        encontrarSolucion(verticeOrigen);
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
            
            System.out.println("---------------Arranca solucion de los Ciclos---------------");
            Iterator<String> ItGeneros=grafoFinal.obtenerVertices();
            while (ItGeneros.hasNext()) {
            	String v= ItGeneros.next();
            	System.out.print(" "+ v);
            	
            }
            Iterator<Arco> ItArcos=grafoFinal.obtenerArcos();
            while (ItArcos.hasNext()) {
        		System.out.println(ItArcos.next());
          }
            
            System.out.println("---------------FINNNNNN---------------");
      }
       
//       public void buscarSuma(String v){
//       	this.verticeOrigen=v;
//           Camino camino=new Camino(new ArrayList<>(), 0);
//           Camino caminoFinal=new Camino(new ArrayList<>(), 0);
//           Iterator<String>vertices=grafo.obtenerVertices();
//           while(vertices.hasNext()){
//               String vertice=vertices.next();
//               this.colores.put(vertice,"blanco");
//           }
//           //agrega el verticeInicial a la solucion
//           camino.addVertices(verticeOrigen);
//           int suma;
//           
//           encontrarSumaMayor(verticeOrigen, camino, caminoFinal);
//         }

//         private void encontrarSumaMayor(String vertex, Camino camino,Camino caminoFinal){
//           Iterator <String> ady=grafo.obtenerAdyacentes(vertex);
//
//           //Condicion Base: si el vertex es el vertice de inicio y el vertex es amarillo
//           if(camino.getSuma()>caminoFinal.getSuma() && (!ady.hasNext())){
//             caminoFinal.setCamino(camino.getVertices());
//             caminoFinal.setSuma(camino.getSuma());
//             camino.setCamino(new ArrayList<String>());
//             camino.setSuma(-caminoFinal.getSuma());
//           }
//          ArrayList<String>lista = new ArrayList<String>();
//          lista.size();
//          lista.get(lista.size());
//          
//           Iterator <String> adyacentes=grafo.obtenerAdyacentes(vertex);
//           while(adyacentes.hasNext()){
//               String vertice=adyacentes.next();
//               if(this.colores.get(vertice).equals("blanco")){
//                   this.colores.put(vertice, "amarillo");
//                   int suma=grafo.obtenerArco(vertex,vertice).getEtiqueta();
//                   camino.addVertices(vertice);
//                   camino.setSuma(suma);
//                   encontrarSumaMayor(vertice, camino, caminoFinal);
//                   this.colores.put(vertice, "blanco");
//                   camino.removeVertice(vertice);
//                   camino.removeSuma(suma);
//               }
//           }
//           this.colores.put(vertex, "negro");
//       }
//
//          public void mostrarSuma(){
//       	    GrafoDirigido grafoFinal= new GrafoDirigido();
//               for(int i=0;i< solucionActual.size();i++){
//               	if (i==0)
//               		grafoFinal.agregarVertice(solucionActual.get(i), null);
//               	else {
//               		String padre = solucionActual.get(i-1);
//               		grafoFinal.agregarVertice(solucionActual.get(i),padre);
//               		grafoFinal.agregarArco(solucionActual.get(i),padre);
//               	}
//               }
//               
//               System.out.println("---------------Arranca solucion de los Ciclos---------------");
//               Iterator<String> ItGeneros=grafoFinal.obtenerVertices();
//               while (ItGeneros.hasNext()) {
//               	String v= ItGeneros.next();
//               	System.out.print(" "+ v);
//               	
//               }
//               Iterator<Arco> ItArcos=grafoFinal.obtenerArcos();
//               while (ItArcos.hasNext()) {
//           		System.out.println(ItArcos.next());
//             }
//         
//       
//       }
      
          public ArrayList<String> generosMayorValor(GrafoDirigido grafo, String vertice){
              ArrayList<String>solucion=new ArrayList<>();
              solucion.add(vertice);
              Iterator<String>vertices=grafo.obtenerVertices();
              while(vertices.hasNext()){
                  String v=vertices.next();
                  this.colores.put(v,"blanco");
              }
              String verticeActual;
              while(vertice!=null){
                  if(this.colores.get(vertice).equals("blanco")){
                      verticeActual= seleccionar(vertice);
                      if (verticeActual!=null) {
	                      solucion.add(verticeActual);
                      }
                      this.colores.put(verticeActual, "blanco");
                      vertice=verticeActual;
                  }
                  
              }
              return solucion;
          }

          private String seleccionar(String v){
              this.colores.put(v, "amarillo");
              Iterator<String>vertices=grafo.obtenerAdyacentes(v);
              Arco a=new Arco();
              while(vertices.hasNext()){
                  String vertice=vertices.next();
                  if(this.colores.get(vertice).equals("blanco")){
                      this.colores.put(vertice, "amarillo");
                      if(a.getEtiqueta()<grafo.obtenerArco(v, vertice).getEtiqueta()){
                          a=grafo.obtenerArco(v, vertice);
                          System.out.println("arcos seleccionar " +a);
                      }
                  }
                  if(this.colores.get(vertice).equals("negro")){
                      return null;
                  }
              }
             
              this.colores.put(v, "negro");
              return a.getVerticeDestino();

          }
       
}
