package es.studium.pmdm_practicat6.ui.series;

public class ModeloSerie {

    private final int caratula;
    private final String titulo;

    public ModeloSerie(int caratula, String titulo)
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
