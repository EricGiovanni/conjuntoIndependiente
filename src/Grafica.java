import java.util.ArrayList;

public class Grafica {
    private ArrayList<Vertice> vertices;

    /**
     * Constructor que crea una grafica dada una lista de vertices
     * 
     * @param vertices
     */
    public Grafica(ArrayList<Vertice> vertices) {
        this.vertices = vertices;
    }

    /**
     * Metodo que devuelve la lista de vertices
     * 
     * @return
     */
    public ArrayList<Vertice> getVertices() {
        return this.vertices;
    }

    /**
     * Método que devuelve un vértice por su nombre
     * 
     * @param nombre
     * @return
     * @throws Exception
     */
    public Vertice getVertice(String nombre) throws Exception {
        for (Vertice v : this.vertices) {
            if (v.getNombre().equals(nombre)) {
                return v;
            }
        }
        throw new Exception("Ocurrio un error, no encontramos el vertice");
    }

    /**
     * Metodo que modifica la lista de vertices
     * 
     * @param vertices
     */
    public void setVertices(ArrayList<Vertice> vertices) {
        this.vertices = vertices;
    }

    /**
     * Metodo que agrega un vertice a la grafica
     * 
     * @param v
     */
    public void agregaVertice(Vertice v) {
        this.vertices.add(v);
    }

    /**
     * Metodo que imprime una representacion en cadena de una grafica
     */
    @Override
    public String toString() {
        String s = "";
        for (Vertice x : vertices) {
            s = s + x.toString() + "\n";
        }
        return s;
    }

    /**
     * Devuelve el conjunto independiente del teorema dado
     * 
     * @return
     */
    public Grafica getConjuntoIndependiente() {
        ArrayList<Vertice> vertices = new ArrayList<Vertice>();
        Grafica g = new Grafica(vertices);
        return getConjuntoIndependiente(g, new ArrayList<Vertice>(this.vertices));
    }

    /**
     * Método privado para hacer recursión sobre la gráfica
     * 
     * @param g
     * @return
     */
    private Grafica getConjuntoIndependiente(Grafica g, ArrayList<Vertice> auxiliar) {
        if (auxiliar.size() == 1 && !g.pertenece(auxiliar.get(0))) {
            g.agregaVertice(auxiliar.get(0));
            return g;
        }
        if (auxiliar.size() == 0) {
            return g;
        }
        if (auxiliar.size() == 2) {
            if (auxiliar.get(0).getVecinos().size() == 1 && !g.pertenece(auxiliar.get(0))) {
                g.agregaVertice(auxiliar.get(0));
            } else if (auxiliar.get(1).getVecinos().size() == 1 && !g.pertenece(auxiliar.get(0))) {
                g.agregaVertice(auxiliar.get(1));
            } else if (!g.pertenece(auxiliar.get(0)) && !g.pertenece(auxiliar.get(1))) {
                g.agregaVertice(auxiliar.get(0));
                g.agregaVertice(auxiliar.get(1));
            }
            return g;
        }
        if (!g.pertenece(auxiliar.get(0))) {
            g.agregaVertice(auxiliar.get(0));
        }
        auxiliar.remove(0);
        return getConjuntoIndependiente(g, auxiliar);
        /*
         * if (this.vertices.size() == 3) { if (this.vertices.get(0).getVecinos().size()
         * == 2) { g.agregaVertice(this.vertices.get(0)); } else if
         * (this.vertices.get(1).getVecinos().size() == 2) {
         * g.agregaVertice(this.vertices.get(1)); } else if
         * (this.vertices.get(2).getVecinos().size() == 2) {
         * g.agregaVertice(this.vertices.get(2)); } else if
         * (this.vertices.get(0).getVecinos().size() == 0 &&
         * this.vertices.get(1).getVecinos().size() == 0 &&
         * this.vertices.get(2).getVecinos().size() == 0) {
         * g.setVertices(this.vertices); } else if
         * (this.vertices.get(0).getVecinos().size() == 0 ||
         * this.vertices.get(1).getVecinos().size() == 0 ||
         * this.vertices.get(2).getVecinos().size() == 0) return g; }
         */
    }

    /**
     * Metodo privado que nos dice si un vertice pertenece a la grafica o no, o si
     * uno de sus vecinos lo tiene ahí
     * 
     * @param vertice
     * @return
     */
    private boolean pertenece(Vertice vertice) {
        for (Vertice v : this.vertices) {
            if (vertice.equals(v)) {
                return true;
            }
            for (Vertice vecino : v.getVecinos()) {
                if (vertice.equals(vecino)) {
                    return true;
                }
            }
        }
        return false;
    }
}
