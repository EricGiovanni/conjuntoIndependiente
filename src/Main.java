import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Debes enviar por parametro el archivo a leer");
        } else {
            try {
                ArrayList<Vertice> vertices = new ArrayList<Vertice>();
                Grafica g = new Grafica(vertices);
                String cadena;
                int i = 0;
                FileReader f = new FileReader(args[0]);
                BufferedReader b = new BufferedReader(f);
                while ((cadena = b.readLine()) != null) {
                    String[] sp = cadena.split(",");
                    if (i == 0) {
                        for (int j = 0; j < sp.length; j++) {
                            ArrayList<Vertice> vecinos = new ArrayList<Vertice>();
                            Vertice v = new Vertice(vecinos, sp[j]);
                            vertices.add(v);
                        }
                        g.setVertices(vertices);
                    } else {
                        Vertice agregarVecino = g.getVertice(sp[0]);
                        agregarVecino.agregaVecino(g.getVertice(sp[1]));
                    }
                    i++;
                }
                b.close();
                System.out.println(g);
                System.out.println(g.getConjuntoIndependiente());
            } catch (Exception e) {
                System.err.println("Debes abrir un archivo valido");
            }
        }
    }
}
