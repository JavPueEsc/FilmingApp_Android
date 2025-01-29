package es.studium.pmdm_practicat6;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import es.studium.pmdm_practicat6.ui.peliculas.ModeloPelicula;

public class SerieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public ImageView caratula;
    public TextView titulo;
    private final RecyclerViewOnItemClickListener listener;

    public SerieViewHolder(@NonNull View itemView, @NonNull RecyclerViewOnItemClickListener listener) {
        super(itemView);
        caratula = itemView.findViewById(R.id.imagen);
        titulo = itemView.findViewById(R.id.nombre);
        this.listener = listener;
        itemView.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (listener != null) {
            listener.onClick(v, getBindingAdapterPosition());
        }
    }
}
