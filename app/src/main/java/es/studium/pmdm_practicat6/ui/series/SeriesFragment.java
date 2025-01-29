package es.studium.pmdm_practicat6.ui.series;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import es.studium.pmdm_practicat6.MainActivity;
import es.studium.pmdm_practicat6.R;
import es.studium.pmdm_practicat6.RecyclerViewOnItemClickListener;
import es.studium.pmdm_practicat6.SerieAdapter;
import es.studium.pmdm_practicat6.databinding.FragmentSeriesBinding;

public class SeriesFragment extends Fragment  {

    private FragmentSeriesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SeriesViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SeriesViewModel.class);

        binding = FragmentSeriesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //Cambiar icono menú lateral
        ((MainActivity) getActivity()).cambiarIconoMenuLateral(R.drawable.ic_icono_menulateral);

        //final TextView textView = binding.textSeries;

        //Cambiar el color del texto de la barra superior
        ((MainActivity) getActivity()).cambiarColorTextoBarraSuperior(R.color.amarilloApp);

        //slideshowViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        //CardView Series
        List<ModeloSerie> items = new ArrayList<>();

        items.add(new ModeloSerie(R.drawable.angel, "Angel Beats"));
        items.add(new ModeloSerie(R.drawable.death, "Death Note"));
        items.add(new ModeloSerie(R.drawable.fate, "Fate Stay Night"));
        items.add(new ModeloSerie(R.drawable.nhk, "Welcome to the NHK"));
        items.add(new ModeloSerie(R.drawable.suzumiya, "Suzumiya Haruhi"));
        items.add(new ModeloSerie(R.drawable.angel, "Angel Beats"));
        items.add(new ModeloSerie(R.drawable.death, "Death Note"));
        items.add(new ModeloSerie(R.drawable.fate, "Fate Stay Night"));
        items.add(new ModeloSerie(R.drawable.nhk, "Welcome to the NHK"));
        items.add(new ModeloSerie(R.drawable.suzumiya, "Suzumiya Haruhi"));
// Obtener el Recycler
        RecyclerView recycler = root.findViewById(R.id.myRecyclerView2);
        recycler.setHasFixedSize(true);
// Usar un administrador para LinearLayout
        RecyclerView.LayoutManager lManager = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(lManager);
// Crear un nuevo adaptador
        SerieAdapter adapter = new SerieAdapter(items, new RecyclerViewOnItemClickListener() {
            @Override
            public void onClick(View v, int position) {
                // Aquí puedes manejar el clic en cada item
                // Por ejemplo, mostrar un Toast con el título de la serie clickeada
                ModeloSerie clickedSerie = items.get(position);
                Toast.makeText(getContext(), "Has seleccionado: " + clickedSerie.getTitulo(), Toast.LENGTH_SHORT).show();
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