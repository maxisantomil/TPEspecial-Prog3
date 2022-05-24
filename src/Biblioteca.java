
import java.util.ArrayList;
import java.util.LinkedList;

public class Biblioteca {
    
    private Tree arbol;

    public Biblioteca() {
        this.arbol = new Tree();

    }

    public Biblioteca(Tree tree) {
        this.arbol = tree;
    }

    public Tree getArbol() {
		return arbol;
	}

    public void agregarLibros(LinkedList<Libro>libros) {
    	ArrayList<Genero> generos=arbol.getGeneros();
    	System.out.println(generos.size());
    	for (Libro l:libros) {
    		for (Genero g:generos) {
    			if (l.tieneGenero(g.getNombre()) ) {
    				g.addLibro(l);
    			}
    		}
    	}
    }
    public Genero buscarPorGenero(String genero) {
    	return this.arbol.buscarGenero(genero);
    }
    

}
