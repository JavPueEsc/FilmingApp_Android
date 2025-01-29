package es.studium.pmdm_practicat6.ui.series;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
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

        items.add(new ModeloSerie(R.drawable.aa_thewire, "The Wire"));
        items.add(new ModeloSerie(R.drawable.ba_breakingbad, "Breaking Bad"));
        items.add(new ModeloSerie(R.drawable.ca_friends, "Friends"));
        items.add(new ModeloSerie(R.drawable.da_buffy, "Buffy - The Vampire Slayer"));
        items.add(new ModeloSerie(R.drawable.ea_lost, "Lost"));
        items.add(new ModeloSerie(R.drawable.fa_southpark, "South Park"));
        items.add(new ModeloSerie(R.drawable.ga_xfiles, "X Files"));
        items.add(new ModeloSerie(R.drawable.ha_seinfeld, "Seinfeld"));
        items.add(new ModeloSerie(R.drawable.ia_madmen, "Mad Men"));
        items.add(new ModeloSerie(R.drawable.ja_futurama, "Futurama"));
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
                // Gestión de la pulsación en una serie
                //Abrimos un nuevo fargment
                ModeloSerie seriePulsada = items.get(position);
               // Toast.makeText(getContext(), "Has seleccionado: " + seriePulsada.getTitulo(), Toast.LENGTH_SHORT).show();
                // Crear un bundle con los parámetros a enviar
                Bundle args = new Bundle();
                args.putString("tituloSerie", seriePulsada.getTitulo());
                args.putInt("numeroSerie", position);
                // Navegar al nuevo fragmento
                NavHostFragment.findNavController(SeriesFragment.this)
                        .navigate(R.id.nav_detallesSeriesFragment, args);
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