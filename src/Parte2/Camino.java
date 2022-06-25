package Parte2;

import java.util.ArrayList;

public class Camino {

	ArrayList<String>vertices;
    int suma;


    public Camino(ArrayList<String> vertices, int suma) {
        this.vertices = vertices;
        this.suma = suma;
    }


    public ArrayList<String> getVertices() {
        return new ArrayList<>(vertices);
    }


    public void addVertices(String vertice) {
        this.vertices.add(vertice);
    }


    public void setCamino(ArrayList<String>camino){
        vertices=camino;
    }

    public int getSuma() {
        return suma;
    }


    public void setSuma(int suma) {
        this.suma += suma;
    }

    public void removeVertice(String vertice){
        vertices.remove(vertice);
    }

    public void removeSuma(int suma){
        suma-=suma;
    }
    

}