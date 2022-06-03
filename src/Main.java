
import java.util.LinkedList;
import java.io.*;
public class Main {

	public static void main (String []args) {
		Timer timer= new Timer();
        Biblioteca biblioteca=new Biblioteca();
        String csvFile = "src/datasets/dataset1.csv";
        CSVReader reader=new CSVReader(csvFile);
        timer.start();
        biblioteca=reader.readContent();
        String genero;
        biblioteca.getArbol().printPreOrder();
        try {
        	 BufferedReader entrada= new BufferedReader(new InputStreamReader(System.in));
        	 System.out.println("Ingrese un genero");
        	 genero=entrada.readLine();
        	
        	 System.out.println(timer.stop());
        	 if (biblioteca.buscarPorGenero(genero).getLibros().isEmpty()) {
        		 System.out.println("el genero no existe");
        	 }else {
        	 CSVWritter writter=new CSVWritter(biblioteca);
        	 writter.salida(genero);
        	 }
        }catch(Exception e) {
        	 System.out.println(e);
        }
	}	
}
