package es.studium.pmdm_practicat6.ui.peliculas;

public class ModeloPelicula {

    private final int caratula;
    private final String titulo;

    public ModeloPelicula(int caratula, String titulo)
    {
        this.caratula = caratula;
        this.titulo = titulo;
    }
    public String getTitulo()
    {
        return titulo;
    }
    public int getCaratula()
    {
        return caratula;
    }
}
