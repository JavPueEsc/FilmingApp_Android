package es.studium.pmdm_practicat6.ui.peliculas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import es.studium.pmdm_practicat6.MainActivity;
import es.studium.pmdm_practicat6.PeliculaAdapter;
import es.studium.pmdm_practicat6.R;
import es.studium.pmdm_practicat6.RecyclerViewOnItemClickListener;
import es.studium.pmdm_practicat6.SerieAdapter;
import es.studium.pmdm_practicat6.databinding.FragmentPeliculasBinding;
import es.studium.pmdm_practicat6.ui.series.ModeloSerie;
import es.studium.pmdm_practicat6.ui.series.SeriesFragment;

public class PeliculasFragment extends Fragment {

    private FragmentPeliculasBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        PeliculasViewModel galleryViewModel =
                new ViewModelProvider(this).get(PeliculasViewModel.class);

        binding = FragmentPeliculasBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //Cambiar icono menú lateral
        ((MainActivity) getActivity()).cambiarIconoMenuLateral(R.drawable.ic_icono_menulateral);


        //final TextView textView = binding.textPeliculas;

        //Cambiar el color del texto de la barra superior
        ((MainActivity) getActivity()).cambiarColorTextoBarraSuperior(R.color.rosaApp);

        //galleryViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        //CardView Peliculas
        List<ModeloPelicula> items = new ArrayList<>();

        items.add(new ModeloPelicula(R.drawable.ka_bladerunner, "Blade Runner"));
        items.add(new ModeloPelicula(R.drawable.la_iception, "Inception"));
        items.add(new ModeloPelicula(R.drawable.ma_madmax, "Mad Max"));
        items.add(new ModeloPelicula(R.drawable.na_interstellar, "Interstellar"));
        items.add(new ModeloPelicula(R.drawable.oa_terminator, "Terminator"));
        items.add(new ModeloPelicula(R.drawable.pa_darknight, "Batman - The dark night"));
        items.add(new ModeloPelicula(R.drawable.qa_seven, "Seven"));
        items.add(new ModeloPelicula(R.drawable.ra_johnwick, "John Wick"));
        items.add(new ModeloPelicula(R.drawable.sa_gravity, "Gravity"));
        items.add(new ModeloPelicula(R.drawable.ta_looper, "Looper"));
// Obtener el Recycler
        RecyclerView recycler = root.findViewById(R.id.myRecyclerView);
        recycler.setHasFixedSize(true);
// Usar un administrador para LinearLayout
        RecyclerView.LayoutManager lManager = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(lManager);
// Crear un nuevo adaptador
        PeliculaAdapter adapter = new PeliculaAdapter(items, new RecyclerViewOnItemClickListener() {
            @Override
            public void onClick(View v, int position) {
                // Gestión de la pulsación en una serie
                //Abrimos un nuevo fargment
                ModeloPelicula peliculaPulsada = items.get(position);
                // Toast.makeText(getContext(), "Has seleccionado: " + seriePulsada.getTitulo(), Toast.LENGTH_SHORT).show();
                // Crear un bundle con los parámetros a enviar
                Bundle args = new Bundle();
                args.putString("tituloPelicula", peliculaPulsada.getTitulo());
                args.putInt("numeroPelicula", position);
                // Navegar al nuevo fragmento
                NavHostFragment.findNavController(PeliculasFragment.this)
                        .navigate(R.id.nav_detallesPeliculasFragment, args);
            }
        });
        recycler.setAdapter(adapter);
//final

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}