package Parte2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Vertice {
	private LinkedList<String> padres=new LinkedList<>();
	private String verticeId;
	LinkedList<Arco>arcos;
	
	public String getVerticeId() {
		return verticeId;
	}

	public LinkedList<String> getPadres() {
		return new LinkedList<>(padres);
	}
	public void setPadre(String v) {
		padres.add(v);
	}
	public void setVerticeId(String verticeId) {
		this.verticeId = verticeId;
	}

	public LinkedList<Arco> getArcos() {
		return arcos;
	}

	public void setArcos(LinkedList<Arco> arcos) {
		this.arcos = arcos;
	}

	public Vertice(String verticeId) {
		this.verticeId=verticeId;
		arcos = new LinkedList<Arco>();
	}

	public void agregarArco(Arco aux) {
		this.arcos.add(aux);
	}
	
	
	public boolean existeArco(String idAdyacente) {
		boolean result= false;
		for (Arco a: arcos ) {
			if (a.getVerticeDestino().equals(idAdyacente)){
				result=true;
				System.out.println("resuktadooo "+ result);
				return result;
			}
		}
		return result;
	}
	
	public void borrarArco(String idAdyacente) {
		if (existeArco(idAdyacente)) {
			Arco arcoAux =null;
			for (Arco a: arcos ) {
				if (a.getVerticeDestino()==idAdyacente){
					arcoAux= a;
				}
			}
			arcos.remove(arcoAux);
		}
	}

	public Arco devolverArco(String idAdyacente) {
		//return arcos.get(verticeId2);
		Arco arcoAux =null;
		for (Arco a: arcos ) {
			if (a.getVerticeDestino().equals(idAdyacente)){
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
		for (Arco a: arcos ) {
			aux.add(a.getVerticeDestino());
		}
		return aux.iterator();
	}

	@Override
	public String toString() {
		return " "+verticeId ;
	}
	
}
