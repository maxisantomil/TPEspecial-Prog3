
import java.io.BufferedWriter;
	import java.io.File;
	import java.io.FileWriter;
	import java.io.IOException;
import java.util.ArrayList;

public class CSVWritter {
	

	Biblioteca biblioteca;
	
	public CSVWritter(Biblioteca biblioteca) {
		this.biblioteca=biblioteca;
	}
	
	public void salida(String genero) {
		BufferedWriter bw = null;
		try {
			File file = new File("src/datasets/salidas/salida-"+ genero +".csv");
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			Genero g=biblioteca.buscarPorGenero(genero);
			String contenidoLinea1 = g.getNombre();
			bw.write(contenidoLinea1);
			bw.newLine();
			String contenidoLinea2 = "Titulo, Autor, Paginas, Generos";
			bw.write(contenidoLinea2);
			bw.newLine();
			for(Libro l: g.getLibros()) {
				String contenidoLinea3 = l.getTitulo()+", "+ l.getAutor()+", "+l.getCant_paginas()+ ", " +l.getGeneros() ;
				bw.write(contenidoLinea3);
				bw.newLine();
			}
			bw.newLine();
			System.out.println("se genera el archivo de salida exitosamente");

		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}

	}
