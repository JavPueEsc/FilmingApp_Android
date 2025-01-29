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
import androidx.navigation.fragment.NavHostFragment;

import es.studium.pmdm_practicat6.R;

public class DetallesSeriesFragment extends Fragment implements View.OnClickListener {

    TextView textoTituloSerie;
    String tituloSerie;
    static ImageView caratulaSerie;
    int numeroSerie =0;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detallesseries, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textoTituloSerie = view.findViewById(R.id.text_series);
        caratulaSerie = view.findViewById(R.id.image_series);
        caratulaSerie.setOnClickListener(this);

        // Obtener argumentos del bundle
        if (getArguments() != null) {
            tituloSerie = getArguments().getString("tituloSerie");
            numeroSerie = getArguments().getInt("numeroSerie");

            // Mostrar el título en el TextView

            textoTituloSerie.setText(tituloSerie);
            establecerCaratulaSerie(numeroSerie, caratulaSerie);
        }
    }

    public static void establecerCaratulaSerie(int numeroSerie, ImageView caratulaS){
        switch (numeroSerie){
            case 0:
                caratulaS.setImageResource(R.drawable.angel);
                break;
            case 1:
                caratulaS.setImageResource(R.drawable.death);
                break;
            case 2:
                caratulaS.setImageResource(R.drawable.fate);
                break;
            case 3:
                caratulaS.setImageResource(R.drawable.nhk);
                break;
            case 4:
                caratulaS.setImageResource(R.drawable.suzumiya);
                break;
            case 5:
                caratulaS.setImageResource(R.drawable.angel);
                break;
            case 6:
                caratulaS.setImageResource(R.drawable.death);
                break;
            case 7:
                caratulaS.setImageResource(R.drawable.fate);
                break;
            case 8:
                caratulaS.setImageResource(R.drawable.nhk);
                break;
            case 9:
                caratulaS.setImageResource(R.drawable.suzumiya);
                break;
            default:
                caratulaS.setImageResource(R.drawable.logoapp);
                break;
        }
    }

    @Override
    public void onClick(View view) {
    if(view == caratulaSerie){
        // Crear un bundle con los parámetros a enviar
        Bundle args = new Bundle();
        args.putString("tituloSerie2", tituloSerie);
        args.putInt("numeroSerie2", numeroSerie);

        // Navegar al nuevo fragmento
        NavHostFragment.findNavController(DetallesSeriesFragment.this)
                .navigate(R.id.nav_caratulaSerieFragment, args);
    }
    }
}
