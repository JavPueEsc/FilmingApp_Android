package es.studium.pmdm_practicat6.ui.inicio;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import es.studium.pmdm_practicat6.MainActivity;
import es.studium.pmdm_practicat6.R;
import es.studium.pmdm_practicat6.databinding.FragmentInicioBinding;
import es.studium.pmdm_practicat6.ui.series.DetallesSeriesFragment;

public class InicioFragment extends Fragment implements View.OnClickListener{

    private FragmentInicioBinding binding;
    View peliculaRecomendada;
    View serieRecomendada;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        InicioViewModel homeViewModel =
                new ViewModelProvider(this).get(InicioViewModel.class);

        binding = FragmentInicioBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        peliculaRecomendada = root.findViewById(R.id.rectangulo_izqSup);
        serieRecomendada =  root.findViewById(R.id.rectangulo_izqInf);
        peliculaRecomendada.setOnClickListener(this);
        serieRecomendada.setOnClickListener(this);
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        //Cambiar icono del menú lateral
        if (getActivity() instanceof MainActivity) {
            ((MainActivity) getActivity()).cambiarIconoMenuLateral(R.drawable.ic_icono_menulateral);
        }
        //Cambiar el color del texto de la barra superior
        ((MainActivity) getActivity()).cambiarColorTextoBarraSuperior(R.color.verdeApp);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onClick(View view) {
        if(view == peliculaRecomendada){
            int numeroPelicula = 4;
            String tituloPelicula = getString(R.string.titulo_terminator);
            // Crear un bundle con los parámetros a enviar
            Bundle args = new Bundle();
            args.putString("tituloPelicula", tituloPelicula);
            args.putInt("numeroPelicula", numeroPelicula);

            //Cambiar el color del texto de la barra superior
            ((MainActivity) getActivity()).cambiarColorTextoBarraSuperior(R.color.rosaApp);

            // Navegar al nuevo fragmento
            NavHostFragment.findNavController(InicioFragment.this)
                    .navigate(R.id.nav_detallesPeliculasFragment, args);
        }
        else{
            int numeroSerie = 4;
            String tituloSerie = getString(R.string.titulo_lost);
            // Crear un bundle con los parámetros a enviar
            Bundle args = new Bundle();
            args.putString("tituloSerie", tituloSerie);
            args.putInt("numeroSerie", numeroSerie);

            //Cambiar el color del texto de la barra superior
            ((MainActivity) getActivity()).cambiarColorTextoBarraSuperior(R.color.amarilloApp);

            // Navegar al nuevo fragmento
            NavHostFragment.findNavController(InicioFragment.this)
                    .navigate(R.id.nav_detallesSeriesFragment, args);
        }
    }
}