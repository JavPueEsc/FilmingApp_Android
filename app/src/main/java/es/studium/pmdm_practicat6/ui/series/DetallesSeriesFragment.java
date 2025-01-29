package es.studium.pmdm_practicat6.ui.series;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import es.studium.pmdm_practicat6.R;

public class DetallesSeriesFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detallesseries, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView tituloSerie1 = view.findViewById(R.id.text_series);
        TextView posicionSerie = view.findViewById(R.id.posicion_series);
        // Obtener argumentos del bundle
        if (getArguments() != null) {
            String tituloSerie = getArguments().getString("tituloSerie");
            int numeroSerie = getArguments().getInt("numeroSerie");

            // Mostrar el título en el TextView

            tituloSerie1.setText(tituloSerie);
            posicionSerie.setText(String.valueOf(numeroSerie));
        }
    }
}
