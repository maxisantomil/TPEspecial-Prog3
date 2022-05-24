
import java.util.ArrayList;

public class Genero {
	
	private String nombre;
    private ArrayList<Libro>libros;

    public Genero() {
        this.nombre=null;
        this.libros=new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Libro> getLibros() {
        return new ArrayList<>(libros);
    }

    public void addLibro(Libro libro) {
        if(libro.tieneGenero(this.nombre)){
            this.libros.add(libro);
        }  
    }

	@Override
	public String toString() {
		return "Genero [nombre=" + nombre + ", libros=" + libros + "]";
	}
    
}
