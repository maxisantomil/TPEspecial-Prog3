package Parte2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Vertice<T> {
	private String padre;
	private String verticeId;
	LinkedList<Arco<T>>arcos;
	
	public String getVerticeId() {
		return verticeId;
	}

	public String getPadre() {
		return padre;
	}
	public void setPadre(String v) {
		this.padre= v;
	}
	public void setVerticeId(String verticeId) {
		this.verticeId = verticeId;
	}

	public LinkedList<Arco<T>> getArcos() {
		return arcos;
	}

	public void setArcos(LinkedList<Arco<T>> arcos) {
		this.arcos = arcos;
	}

	public Vertice(String verticeId) {
		this.verticeId=verticeId;
		arcos = new LinkedList<Arco<T>>();
	}

	public void agregarArco(Arco<T> aux) {
		this.arcos.add(aux);
	}
	
	
	public boolean existeArco(String idAdyacente) {
		boolean result= false;
		for (Arco<T> a: arcos ) {
			if (a.getVerticeDestino()==idAdyacente){
				return result=true;
			}
		}
		return result;
	}
	
	public void borrarArco(String idAdyacente) {
		if (existeArco(idAdyacente)) {
			Arco<T> arcoAux =null;
			for (Arco<T> a: arcos ) {
				if (a.getVerticeDestino()==idAdyacente){
					arcoAux= a;
				}
			}
			arcos.remove(arcoAux);
		}
	}

	public Arco<T> devolverArco(String idAdyacente) {
		//return arcos.get(verticeId2);
		Arco<T> arcoAux =null;
		for (Arco<T> a: arcos ) {
			if (a.getVerticeDestino()==idAdyacente){
				arcoAux= a;
			}
		}
		return arcoAux;
	}
	
	public int cantArcos() {
		return this.arcos.size();
	}
	public Iterator<String> obtenerAdyacentes(){
		ArrayList<String> aux = new ArrayList<String>();
		for (Arco<T> a: arcos ) {
			aux.add(a.getVerticeDestino());
		}
		return aux.iterator();
	}

	@Override
	public String toString() {
		return " "+verticeId ;
	}
	
}
