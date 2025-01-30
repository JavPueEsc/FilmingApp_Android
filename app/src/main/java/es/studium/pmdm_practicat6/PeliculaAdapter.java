package es.studium.pmdm_practicat6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import es.studium.pmdm_practicat6.PeliculaViewHolder;
import java.util.List;
import es.studium.pmdm_practicat6.ui.peliculas.ModeloPelicula;


public class PeliculaAdapter extends RecyclerView.Adapter<PeliculaViewHolder>{

    private final List<ModeloPelicula> items;
    private final RecyclerViewOnItemClickListener listener;

    // Constructor
    public PeliculaAdapter(List<ModeloPelicula> items, RecyclerViewOnItemClickListener listener) {
        this.items = items;
        this.listener = listener;
    }

    @NonNull
    @Override
    public PeliculaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tarjeta_pelicula, parent, false);
        return new PeliculaViewHolder(itemView, listener); // Pasar el listener aquí
    }

    @Override
    public void onBindViewHolder(@NonNull PeliculaViewHolder holder, int position) {
        ModeloPelicula pelicula = items.get(position);
        holder.caratula.setImageResource(pelicula.getCaratula());
        holder.titulo.setText(pelicula.getTitulo());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
