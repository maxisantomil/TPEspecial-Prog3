package Parte2;

import java.util.ArrayList;
import java.util.Iterator;

public class Servicio2 {

	GrafoDirigido grafo;
	public Servicio2(GrafoDirigido g) {
		grafo=g;
	}

    public ArrayList<String> generosMayorValor(String vertice){
        ArrayList<String>solucion=new ArrayList<>();
        boolean encontrado=false;
        solucion.add(vertice);
        while(vertice!=null && !encontrado){
            String v=seleccionar(vertice, solucion);
            if(v!=null){
                solucion.add(v);
                vertice=v;
            }else encontrado=true;
            
        }
        return solucion;
    }

    private String seleccionar(String vertice, ArrayList<String> solucion){
        Iterator<String>vertices=grafo.obtenerAdyacentes(vertice);
        Arco a=new Arco();
        while(vertices.hasNext()){
            String v=vertices.next();
            if(!solucion.contains(v)){
                if(a.getEtiqueta()<grafo.obtenerArco(vertice, v).getEtiqueta()){
                    a=grafo.obtenerArco(vertice, v);
                }
            }
            
        }   
        return a.getVerticeDestino();
    }
}
