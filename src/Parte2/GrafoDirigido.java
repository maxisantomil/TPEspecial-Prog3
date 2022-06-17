package Parte2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T>{
	HashMap <String, Vertice> mapVertices = new HashMap <String, Vertice> ();
	
		@Override
		public void agregarVertice(String verticeId, String padre) {
			Vertice actual=new Vertice(verticeId);
			actual.setPadre(padre);
			if (!mapVertices.containsKey(verticeId)){
				mapVertices.put(verticeId,actual);
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
			for (Vertice<T> v: mapVertices.values()) {
				if (v.getVerticeId()!=verticeId) {
					v.borrarArco(verticeId);
				}
			}
			
		}

		@Override
		public void agregarArco(String verticeId1, String verticeId2, T etiqueta) {
			String padre= mapVertices.get(verticeId1).getPadre();
			int suma = 1;
				if (mapVertices.containsKey(padre)&& mapVertices.containsKey(verticeId1)){
					if (!mapVertices.get(padre).existeArco(verticeId1)) {
						if(padre == verticeId2) {
							Arco<T> aux = new Arco(padre,verticeId1,suma);
							mapVertices.get(padre).agregarArco(aux);
						}
					}else {
						obtenerArco(padre, verticeId1).setEtiqueta(suma+1);
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
		public Arco<T> obtenerArco(String verticeId1, String verticeId2) {
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
		public Iterator<Arco<T>> obtenerArcos() {
			ArrayList<Arco<T>> aux = new ArrayList<Arco<T>>();
			for (Vertice v: mapVertices.values()) {
				aux.addAll(v.getArcos());
			}
			return aux.iterator();
		}

		@Override
		public Iterator<Arco<T>> obtenerArcos(String verticeId) {
			return mapVertices.get(verticeId).getArcos().iterator();
		}

		public Vertice obtenerVertice(String id) {
			return mapVertices.get(id);
		}
}
