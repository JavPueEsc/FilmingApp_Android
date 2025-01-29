package es.studium.pmdm_practicat6.ui.series;

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

public class CaratulaSerieFragment extends Fragment {

    ImageView caratulaSerieGrande;
    TextView tituloCaratula;
    int numeroSerieRecibido =0;
    String tituloSerie;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_caratulaseries, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        caratulaSerieGrande = view.findViewById(R.id.caratula_series);
        tituloCaratula = view.findViewById(R.id.tituloTextoCaratula);

        // Obtener argumentos del bundle
        if (getArguments() != null) {

            numeroSerieRecibido = getArguments().getInt("numeroSerie2");
            tituloSerie = getArguments().getString("tituloSerie2");
            // Mostrar la imagen
            DetallesSeriesFragment.establecerCaratulaSerie(numeroSerieRecibido, caratulaSerieGrande);
            tituloCaratula.setText(tituloSerie);
        }

    }
}
