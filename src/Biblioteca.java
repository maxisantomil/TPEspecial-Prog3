
import java.util.ArrayList;
import java.util.LinkedList;

public class Biblioteca {
    
    private Tree arbol;
    private LinkedList<Libro>libros;
    
    public Biblioteca() {
        this.arbol = new Tree();
        this.libros = new LinkedList<Libro>();
    }

    public Biblioteca(Tree tree, LinkedList<Libro>libros) {
        this.arbol = tree;
        this.libros = libros;
    }
    

    public Tree getArbol() {
		return arbol;
	}

    public void agregarLibros(Genero genero) {
    	for (Libro l:libros) {
    			if (l.tieneGenero(genero.getNombre()) ) {
    				genero.addLibro(l);
    		}
    	}
    }
    
    public Genero buscarPorGenero(String genero) {
    	Genero genero2= this.arbol.buscarGenero(genero);
    	agregarLibros(genero2);
    	
    	return genero2;
    }
    

}
