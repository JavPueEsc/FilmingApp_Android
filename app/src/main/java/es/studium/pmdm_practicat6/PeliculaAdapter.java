package es.studium.pmdm_practicat6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import es.studium.pmdm_practicat6.ui.peliculas.ModeloPelicula;
import es.studium.pmdm_practicat6.ui.peliculas.PeliculasFragment;

public class PeliculaAdapter extends RecyclerView.Adapter<PeliculaAdapter.PeliculaViewHolder>{

    private List<ModeloPelicula> items;

    public static class PeliculaViewHolder extends RecyclerView.ViewHolder
    {
        // Campos respectivos de un item
        public ImageView caratula;
        public TextView titulo;

        public PeliculaViewHolder(View v)
        {
            super(v);
            caratula = (ImageView) v.findViewById(R.id.imagen);
            titulo = (TextView) v.findViewById(R.id.nombre);
        }
    }

    public PeliculaAdapter(List<ModeloPelicula> items)
    {
        this.items = items;
    }

    @Override
    public int getItemCount()
    {
        return items.size();
    }

    @Override
    public PeliculaViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)
    {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.tarjeta_pelicula, viewGroup, false);
        return new PeliculaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PeliculaViewHolder viewHolder, int i)
    {
        viewHolder.caratula.setImageResource(items.get(i).getCaratula());
        viewHolder.titulo.setText(items.get(i).getTitulo());
    }


}
