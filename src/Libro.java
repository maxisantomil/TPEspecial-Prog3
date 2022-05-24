
import java.util.ArrayList;

public class Libro {
	private int id=0;
	private String titulo;
	private String autor;
	private String cant_paginas;
	private ArrayList<String>generos;
	
	public Libro(int id,String titulo,String autor, String cant_paginas) {
		this.id= id;
		this.titulo=titulo;
		this.autor=autor;
		this.cant_paginas=cant_paginas;
		generos= new ArrayList<String>();
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getCant_paginas() {
		return cant_paginas;
	}

	public void setCant_paginas(String cant_paginas) {
		this.cant_paginas = cant_paginas;
	}

	public ArrayList<String> getGeneros() {
		return new ArrayList<String>(generos);
	}

	public void addGeneros(String genero) {
		this.generos.add(genero);
	}

	public int getId() {
		return id;
	}
	
	public boolean tieneGenero(String genero){
		return this.getGeneros().contains(genero);
	}
	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", cant_paginas=" + cant_paginas
				+ ", generos=" + generos + "]";
	}
	
}
