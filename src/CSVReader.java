
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class CSVReader {

    private String path;
    
    public CSVReader(String path) {
    	this.path=path;
    }

    	
    public Biblioteca readContent(){
    	Tree tree=new Tree();
    	LinkedList<Libro>libros= new LinkedList<>();
    	Biblioteca biblioteca= new Biblioteca(tree);
        String line = "";
        String cvsSplitBy = ";";
        int idLibro=0;
        try (BufferedReader br = new BufferedReader(new FileReader(this.path))) {
        	br.readLine(); 
            while ((line = br.readLine()) != null) {
                String[] items = line.split(cvsSplitBy);
                for (String p:items) {
                	idLibro++;
                    String linePalabra= ",";
                	String[]palabra= p.split(linePalabra);
                		Libro libro= new Libro(idLibro, palabra[0],palabra[1],palabra[2]);
                		String cvsSplitSpace = " ";
                		String[] generosDivision= palabra[3].split(cvsSplitSpace);
                		for(String g:generosDivision) {
                			libro.addGeneros(g);
                			tree.addGenero(g);
                		}
                		libros.add(libro);
                }  
                
            }//tree.printInOrder();
          
          	biblioteca.agregarLibros(libros);	
        } catch (IOException e) {
            e.printStackTrace();
        }
      
        return biblioteca;
        
    }
}