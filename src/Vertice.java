import java.util.ArrayList;

public class Vertice implements Comparable<Vertice> {
    private ArrayList<Vertice> vecinos;
    private String nombre;

    /**
     * Constructor que recibe el nombre del vertice y sus vecinos
     * 
     * @param vecinos
     * @param nombre
     */
    public Vertice(ArrayList<Vertice> vecinos, String nombre) {
        this.vecinos = vecinos;
        this.nombre = nombre;
    }

    /**
     * Metodo que devuelve el nombre del vertice
     * 
     * @return nombre del vertice
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Metodo que modifica el nombre del vertice
     * 
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo que devuelve la lista de vecinos del vertice
     * 
     * @return lista de vertices de vecinos
     */
    public ArrayList<Vertice> getVecinos() {
        return this.vecinos;
    }

    /**
     * Metodo que modifica la lista de vecinos del vertice
     * 
     * @param nombre
     */
    public void setVecinos(ArrayList<Vertice> vecinos) {
        this.vecinos = vecinos;
    }

    /**
     * Metodo que agrega vecino a la lista de vertices vecinos
     * 
     * @param vecino
     */
    public void agregaVecino(Vertice vecino) {
        this.vecinos.add(vecino);
    }

    /**
     * Metodo que pasa a cadena el vertice
     * 
     * @return el vertice junto con sus vecinos
     */
    @Override
    public String toString() {
        String aux = "Los vecinos del vertice v" + this.nombre + " son: [";
        int i = 0;
        for (Vertice v : this.vecinos) {
            if (i != this.vecinos.size() - 1) {
                aux += "v" + v.getNombre() + ", ";
            } else {
                aux += "v" + v.getNombre();
            }
            i++;
        }
        aux += "]";
        return aux;
    }

    /**
     * Metodo que busca un vertice por nombre y nos dice si el elemento esta o no
     * 
     * @param nombre
     * @return boolean que nos dice si esta o no el vertice
     */
    public boolean buscaNombre(String nombre) {
        for (Vertice v : this.vecinos) {
            if (v.getNombre().equals(nombre)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo que sobrecarga el compareTo y compara 2 vertices
     * 
     * @param v
     * @return -1 si el vertice actual es menor, 1 si es mayor, 0 si son iguales
     */
    @Override
    public int compareTo(Vertice v) {
        if (Integer.parseInt(this.nombre) < Integer.parseInt(v.getNombre())) {
            return -1;
        }
        if (Integer.parseInt(this.nombre) > Integer.parseInt(v.getNombre())) {
            return 1;
        }
        return 0;
    }
}
