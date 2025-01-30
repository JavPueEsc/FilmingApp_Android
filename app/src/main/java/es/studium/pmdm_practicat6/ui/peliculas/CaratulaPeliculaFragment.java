package es.studium.pmdm_practicat6.ui.peliculas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import es.studium.pmdm_practicat6.R;
import es.studium.pmdm_practicat6.ui.series.DetallesSeriesFragment;

public class CaratulaPeliculaFragment extends Fragment {

    ImageView caratulaPeliculaGrande;
    TextView tituloCaratula;
    int numeroPeliculaRecibido =0;
    String tituloPelicula;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_caratulapeliculas, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        caratulaPeliculaGrande = view.findViewById(R.id.caratula_peliculas);
        tituloCaratula = view.findViewById(R.id.tituloTextoCaratula);

        // Obtener argumentos del bundle
        if (getArguments() != null) {

            numeroPeliculaRecibido = getArguments().getInt("numeroPelicula2");
            tituloPelicula = getArguments().getString("tituloPelicula2");
            // Mostrar la imagen
            DetallesPeliculasFragment.establecerCaratulaPelicula(numeroPeliculaRecibido, caratulaPeliculaGrande);
            tituloCaratula.setText(tituloPelicula);
        }

    }
}
