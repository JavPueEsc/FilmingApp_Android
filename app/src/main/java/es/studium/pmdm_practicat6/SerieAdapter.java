package es.studium.pmdm_practicat6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import es.studium.pmdm_practicat6.ui.series.ModeloSerie;
import es.studium.pmdm_practicat6.RecyclerViewOnItemClickListener;

public class SerieAdapter extends RecyclerView.Adapter<SerieViewHolder> {
    private final List<ModeloSerie> items;
    private final RecyclerViewOnItemClickListener listener;

    // Constructor
    public SerieAdapter(List<ModeloSerie> items, RecyclerViewOnItemClickListener listener) {
        this.items = items;
        this.listener = listener;
    }

    @NonNull
    @Override
    public SerieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tarjeta_serie, parent, false);
        return new SerieViewHolder(itemView, listener); // Pasar el listener aquí
    }

    @Override
    public void onBindViewHolder(@NonNull SerieViewHolder holder, int position) {
        ModeloSerie serie = items.get(position);
        holder.caratula.setImageResource(serie.getCaratula());
        holder.titulo.setText(serie.getTitulo());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
