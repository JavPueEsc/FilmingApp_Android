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
    TextView textoDirectorSerie;
    TextView textoRepartoSerie;
    TextView textoSinopsisSerie;
    TextView textoTemporadasSerie;
    String tituloSerie;
    static ImageView caratulaSerie;
    int numeroSerie = 0;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detallesseries, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textoTituloSerie = view.findViewById(R.id.text_series);
        textoDirectorSerie = view.findViewById(R.id.valorDirector);
        textoRepartoSerie = view.findViewById(R.id.valorReparto);
        textoSinopsisSerie = view.findViewById(R.id.valorSinopsis);
        textoTemporadasSerie = view.findViewById(R.id.valorTemporadas);
        caratulaSerie = view.findViewById(R.id.image_series);
        caratulaSerie.setOnClickListener(this);

        // Obtener argumentos del bundle
        if (getArguments() != null) {
            tituloSerie = getArguments().getString("tituloSerie");
            numeroSerie = getArguments().getInt("numeroSerie");

            // Mostrar el título en el TextView

            //textoTituloSerie.setText(tituloSerie);
            establecerDatosSerie(numeroSerie, textoTituloSerie,textoDirectorSerie,textoRepartoSerie,textoSinopsisSerie,textoTemporadasSerie,tituloSerie);
            establecerCaratulaSerie(numeroSerie, caratulaSerie);
        }
    }


    public static void establecerCaratulaSerie(int numeroSerie, ImageView caratulaS) {
        switch (numeroSerie) {
            case 0:
                caratulaS.setImageResource(R.drawable.aa_thewire);
                break;
            case 1:
                caratulaS.setImageResource(R.drawable.ba_breakingbad);
                break;
            case 2:
                caratulaS.setImageResource(R.drawable.ca_friends);
                break;
            case 3:
                caratulaS.setImageResource(R.drawable.da_buffy);
                break;
            case 4:
                caratulaS.setImageResource(R.drawable.ea_lost);
                break;
            case 5:
                caratulaS.setImageResource(R.drawable.fa_southpark);
                break;
            case 6:
                caratulaS.setImageResource(R.drawable.ga_xfiles);
                break;
            case 7:
                caratulaS.setImageResource(R.drawable.ha_seinfeld);
                break;
            case 8:
                caratulaS.setImageResource(R.drawable.ia_madmen);
                break;
            case 9:
                caratulaS.setImageResource(R.drawable.ja_futurama);
                break;
            default:
                caratulaS.setImageResource(R.drawable.logoapp);
                break;
        }
    }


    @Override
    public void onClick(View view) {
        if (view == caratulaSerie) {
            // Crear un bundle con los parámetros a enviar
            Bundle args = new Bundle();
            args.putString("tituloSerie2", tituloSerie);
            args.putInt("numeroSerie2", numeroSerie);

            // Navegar al nuevo fragmento
            NavHostFragment.findNavController(DetallesSeriesFragment.this)
                    .navigate(R.id.nav_caratulaSerieFragment, args);
        }
    }

    public static void establecerDatosSerie(int numeroSerie, TextView textoTituloSerie, TextView textoDirectorSerie, TextView textoRepartoSerie, TextView textoSinopsisSerie, TextView textoTemporadasSerie, String tituloSerie) {
        switch (numeroSerie) {
            case 0:
                textoTituloSerie.setText(tituloSerie);
                textoDirectorSerie.setText(R.string.director_the_wire);
                textoRepartoSerie.setText(R.string.reparto_the_wire);
                textoSinopsisSerie.setText(R.string.sinopsis_the_wire);
                textoTemporadasSerie.setText(R.string.temporadas_the_wire);
                break;
            case 1:
                textoTituloSerie.setText(tituloSerie);
                textoDirectorSerie.setText(R.string.director_breaking_bad);
                textoRepartoSerie.setText(R.string.reparto_breaking_bad);
                textoSinopsisSerie.setText(R.string.sinopsis_breaking_bad);
                textoTemporadasSerie.setText(R.string.temporadas_breaking_bad);
                break;
            case 2:
                textoTituloSerie.setText(tituloSerie);
                textoDirectorSerie.setText(R.string.director_friends);
                textoRepartoSerie.setText(R.string.reparto_friends);
                textoSinopsisSerie.setText(R.string.sinopsis_friends);
                textoTemporadasSerie.setText(R.string.temporadas_friends);
                break;
            case 3:
                textoTituloSerie.setText(tituloSerie);
                textoDirectorSerie.setText(R.string.director_buffy);
                textoRepartoSerie.setText(R.string.reparto_buffy);
                textoSinopsisSerie.setText(R.string.sinopsis_buffy);
                textoTemporadasSerie.setText(R.string.temporadas_buffy);
                break;
            case 4:
                textoTituloSerie.setText(tituloSerie);
                textoDirectorSerie.setText(R.string.director_lost);
                textoRepartoSerie.setText(R.string.reparto_lost);
                textoSinopsisSerie.setText(R.string.sinopsis_lost);
                textoTemporadasSerie.setText(R.string.temporadas_lost);
                break;
            case 5:
                textoTituloSerie.setText(tituloSerie);
                textoDirectorSerie.setText(R.string.director_south_park);
                textoRepartoSerie.setText(R.string.reparto_south_park);
                textoSinopsisSerie.setText(R.string.sinopsis_south_park);
                textoTemporadasSerie.setText(R.string.temporadas_south_park);
                break;
            case 6:
                textoTituloSerie.setText(tituloSerie);
                textoDirectorSerie.setText(R.string.director_xfiles);
                textoRepartoSerie.setText(R.string.reparto_xfiles);
                textoSinopsisSerie.setText(R.string.sinopsis_xfiles);
                textoTemporadasSerie.setText(R.string.temporadas_xfiles);
                break;
            case 7:
                textoTituloSerie.setText(tituloSerie);
                textoDirectorSerie.setText(R.string.director_seinfeld);
                textoRepartoSerie.setText(R.string.reparto_seinfeld);
                textoSinopsisSerie.setText(R.string.sinopsis_seinfeld);
                textoTemporadasSerie.setText(R.string.temporadas_seinfeld);
                break;
            case 8:
                textoTituloSerie.setText(tituloSerie);
                textoDirectorSerie.setText(R.string.director_mad_men);
                textoRepartoSerie.setText(R.string.reparto_mad_men);
                textoSinopsisSerie.setText(R.string.sinopsis_mad_men);
                textoTemporadasSerie.setText(R.string.temporadas_mad_men);
                break;
            case 9:
                textoTituloSerie.setText(tituloSerie);
                textoDirectorSerie.setText(R.string.director_futurama);
                textoRepartoSerie.setText(R.string.reparto_futurama);
                textoSinopsisSerie.setText(R.string.sinopsis_futurama);
                textoTemporadasSerie.setText(R.string.temporadas_futurama);
                break;
            default:
                textoTituloSerie.setText(tituloSerie);
                textoDirectorSerie.setText("");
                textoRepartoSerie.setText("");
                textoSinopsisSerie.setText("");
                textoTemporadasSerie.setText("");
                break;
        }
    }


}
