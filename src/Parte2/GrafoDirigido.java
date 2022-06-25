package Parte2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class GrafoDirigido implements Grafo{
	HashMap <String, Vertice> mapVertices = new HashMap <String, Vertice> ();
	
		@Override
		public void agregarVertice(String verticeId, String padre) {
			Vertice actual=new Vertice(verticeId);
			if (!mapVertices.containsKey(verticeId)){
				actual.setPadre(padre);
				mapVertices.put(verticeId,actual);
			}
			else {
				mapVertices.get(verticeId).setPadre(padre);
			}
		}

		@Override
		public void borrarVertice(String verticeId) {
			if (mapVertices.containsKey(verticeId)) {
				borrardeAdyacente(verticeId);
				mapVertices.remove(verticeId);
			}

		}

		private void borrardeAdyacente(String verticeId) {
			for (Vertice v: mapVertices.values()) {
				if (v.getVerticeId()!=verticeId) {
					v.borrarArco(verticeId);
				}
			}
			
		}

		@Override
		public void agregarArco(String verticeId1, String verticeId2) {
			LinkedList<String> padres= mapVertices.get(verticeId1).getPadres();
				if (padres.contains(verticeId2)) {
					String padre=verticeId2;
				if (mapVertices.containsKey(padre)&& mapVertices.containsKey(verticeId1)){
					if (!mapVertices.get(verticeId2).existeArco(verticeId1)) {
						if(padre.equals(verticeId2)) {
							Arco aux = new Arco(padre,verticeId1);
							aux.setEtiqueta(1);
							mapVertices.get(padre).agregarArco(aux);
						}
					}else if (mapVertices.get(padre).existeArco(verticeId1)) {
						Arco arco = obtenerArco(padre, verticeId1);
						int suma=arco.getEtiqueta();
						obtenerArco(padre, verticeId1).setEtiqueta(suma +1);
					}
				}
			}
		}

		@Override
		public void borrarArco(String verticeId1, String verticeId2) {
			
			if (mapVertices.containsKey(verticeId1)) {
				mapVertices.get(verticeId1).borrarArco(verticeId2);
			}

		}

		@Override
		public boolean contieneVertice(String verticeId) {
			return this.mapVertices.containsKey(verticeId);
		}

		@Override
		public boolean existeArco(String verticeId1, String verticeId2) {
			boolean existe=false;
			if (mapVertices.containsKey(verticeId1)) {
				 existe = mapVertices.get(verticeId1).existeArco(verticeId2);
			}
			return existe;
		}

		@Override
		public Arco obtenerArco(String verticeId1, String verticeId2) {
			if (this.existeArco(verticeId1,verticeId2)) {
				return (this.mapVertices.get(verticeId1).devolverArco(verticeId2));
			}
			return null;
		}

		@Override
		public int cantidadVertices() {
			return this.mapVertices.size();
		}

		@Override
		public int cantidadArcos() {
			int totalArcos=0;
			for (Vertice v: mapVertices.values()) {
				totalArcos+= v.cantArcos();
				}
			
			return totalArcos;
		}

		@Override
		public Iterator<String> obtenerVertices() {
			ArrayList<String> aux = new ArrayList<String>();
			for (Vertice v: mapVertices.values()) {
				aux.add(v.getVerticeId());
				}
			return aux.iterator();
		}

		@Override
		//obtener adyacentes de un vertice dado. ???
		public Iterator<String> obtenerAdyacentes(String verticeId) {
			if (this.contieneVertice(verticeId))
				return mapVertices.get(verticeId).obtenerAdyacentes();
			return null;
		}

		@Override
		public Iterator<Arco> obtenerArcos() {
			ArrayList<Arco> aux = new ArrayList<Arco>();
			for (Vertice v: mapVertices.values()) {
				aux.addAll(v.getArcos());
			}
			return aux.iterator();
		}

		@Override
		public Iterator<Arco> obtenerArcos(String verticeId) {
			return mapVertices.get(verticeId).getArcos().iterator();
		}

		public Vertice obtenerVertice(String id) {
			return mapVertices.get(id);
		}
		
		public ArrayList<String> generosMasBuscados(String verticeOrigen){
			ArrayList<String> generosBuscados= new ArrayList<String>();
			String auxGenero;
			LinkedList<Arco> arcos= mapVertices.get(verticeOrigen).getArcos();
//			while (arcos.hasNext()) {
//				Arco arco1=arcos.next();
//				Arco arco2=arcos.next();
//			}
			Collections.sort(arcos,new ComparadorEtiqueta().reversed());
			generosBuscados.addAll(obtenerGenerosMasBuscados(arcos));
			return generosBuscados;
		}

		private ArrayList<String> obtenerGenerosMasBuscados(LinkedList<Arco> arcos) {
			Iterator<Arco> arcosBuscados= arcos.iterator();
			ArrayList<String> destinos= new ArrayList<String>();
			while (arcosBuscados.hasNext()) {
				String destArco= arcosBuscados.next().getVerticeDestino();
				destinos.add(destArco);
			}
			return destinos;
		}
}
