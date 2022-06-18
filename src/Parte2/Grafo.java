package Parte2;

import java.util.Iterator;

public interface Grafo<T> {
	
	// Agrega un vertice 
		public void agregarVertice(String genero,String padre);

		// Borra un vertice
		public void borrarVertice(String genero);

		// Agrega un arco con una etiqueta, que conecta el verticeId1 con el verticeId2
		public void agregarArco(String genero1, String genero2);

		// Borra el arco que conecta el verticeId1 con el verticeId2
		public void borrarArco(String genero1, String genero2);

		// Verifica si existe un vertice
		public boolean contieneVertice(String genero);  

		// Verifica si existe un arco entre dos vertices
		public boolean existeArco(String genero1, String genero2);
		
		// Obtener el arco que conecta el verticeId1 con el verticeId2
		public Arco obtenerArco(String genero1, String genero2);

		// Devuelve la cantidad total de vertices en el grafo
		public int cantidadVertices();

		// Devuelve la cantidad total de arcos en el grafo
		public int cantidadArcos();

		// Obtiene un iterador que me permite recorrer todos los vertices almacenados en el grafo 
		public Iterator<String> obtenerVertices();

		// Obtiene un iterador que me permite recorrer todos los vertices adyacentes a verticeId 
		public Iterator<String> obtenerAdyacentes(String genero);

		// Obtiene un iterador que me permite recorrer todos los arcos del grafo
		public Iterator<Arco> obtenerArcos();
			
		// Obtiene un iterador que me permite recorrer todos los arcos que parten desde verticeId
		public Iterator<Arco> obtenerArcos(String genero);
		
		
}
