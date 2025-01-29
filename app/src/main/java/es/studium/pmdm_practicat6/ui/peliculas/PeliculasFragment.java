package es.studium.pmdm_practicat6.ui.peliculas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import es.studium.pmdm_practicat6.MainActivity;
import es.studium.pmdm_practicat6.PeliculaAdapter;
import es.studium.pmdm_practicat6.R;
import es.studium.pmdm_practicat6.databinding.FragmentPeliculasBinding;

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
        List items = new ArrayList();

        items.add(new ModeloPelicula(R.drawable.angel, "Angel Beats"));
        items.add(new ModeloPelicula(R.drawable.death, "Death Note"));
        items.add(new ModeloPelicula(R.drawable.fate, "Fate Stay Night"));
        items.add(new ModeloPelicula(R.drawable.nhk, "Welcome to the NHK"));
        items.add(new ModeloPelicula(R.drawable.suzumiya, "Suzumiya Haruhi"));
        items.add(new ModeloPelicula(R.drawable.angel, "Angel Beats"));
        items.add(new ModeloPelicula(R.drawable.death, "Death Note"));
        items.add(new ModeloPelicula(R.drawable.fate, "Fate Stay Night"));
        items.add(new ModeloPelicula(R.drawable.nhk, "Welcome to the NHK"));
        items.add(new ModeloPelicula(R.drawable.suzumiya, "Suzumiya Haruhi"));
// Obtener el Recycler
        RecyclerView recycler = root.findViewById(R.id.myRecyclerView);
        recycler.setHasFixedSize(true);
// Usar un administrador para LinearLayout
        RecyclerView.LayoutManager lManager = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(lManager);
// Crear un nuevo adaptador
        PeliculaAdapter adapter = new PeliculaAdapter(items);
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