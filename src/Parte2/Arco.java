package Parte2;

/*
 * La clase arco representa un arco del grafo. Contiene un vertice origen, un vertice destino y una etiqueta.
 * Nota: Para poder exponer los arcos fuera del grafo y que nadie los modifique se hizo esta clase inmutable
 * (Inmutable: una vez creado el arco no es posible cambiarle los valores).
 */
public class Arco {
	private String verticeOrigen;
	private String verticeDestino;
	private int etiqueta;

	public Arco(String verticeOrigen, String verticeDestino) {
		this.verticeOrigen = verticeOrigen;
		this.verticeDestino = verticeDestino;
	}
	
	public Arco() {
		// TODO Auto-generated constructor stub
	}

	public String getVerticeOrigen() {
		return verticeOrigen;
	}
	
	public String getVerticeDestino() {
		return verticeDestino;
	}

	public int getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(int valor) {
		this.etiqueta=valor;
	}
	@Override
	public String toString() {
		return "Arco [verticeOrigen=" + verticeOrigen + ", verticeDestino=" + verticeDestino + ", etiqueta=" + etiqueta
				+ "]";
	}
	
	
}
