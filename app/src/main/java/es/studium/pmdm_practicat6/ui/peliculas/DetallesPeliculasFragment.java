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
import androidx.navigation.fragment.NavHostFragment;

import es.studium.pmdm_practicat6.R;
import es.studium.pmdm_practicat6.ui.series.DetallesSeriesFragment;

public class DetallesPeliculasFragment extends Fragment implements View.OnClickListener{

    TextView textoTituloPelicula;
    TextView textoDirectorPelicula;
    TextView textoRepartoPelicula;
    TextView textoSinopsisPelicula;
    TextView textoPreSecuelaPelicula;
    String tituloPelicula;
    static ImageView caratulaPelicula;
    ImageView calificacionPelicula;
    int numeroPelicula = 0;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detallespeliculas, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textoTituloPelicula = view.findViewById(R.id.text_peliculas);
        textoDirectorPelicula = view.findViewById(R.id.valorDirectorPelicula);
        textoRepartoPelicula = view.findViewById(R.id.valorRepartoPelicula);
        textoSinopsisPelicula = view.findViewById(R.id.valorSinopsisPelicula);
        textoPreSecuelaPelicula = view.findViewById(R.id.valorPre_secuelaPelicula);
        caratulaPelicula = view.findViewById(R.id.image_peliculas);
        calificacionPelicula = view.findViewById(R.id.image_calificacionPelicula);
        caratulaPelicula.setOnClickListener(this);

        // Obtener argumentos del bundle
        if (getArguments() != null) {
            tituloPelicula = getArguments().getString("tituloPelicula");
            numeroPelicula = getArguments().getInt("numeroPelicula");

            // Mostrar el título en el TextView

            //textoTituloSerie.setText(tituloSerie);
            establecerDatosPelicula(numeroPelicula, textoTituloPelicula,textoDirectorPelicula,calificacionPelicula,textoRepartoPelicula,textoSinopsisPelicula,textoPreSecuelaPelicula,tituloPelicula);
            establecerCaratulaPelicula(numeroPelicula, caratulaPelicula);
        }
    }

    public static void establecerCaratulaPelicula(int numeroPelicula, ImageView caratulas) {
        switch (numeroPelicula) {
            case 0:
                caratulas.setImageResource(R.drawable.ka_bladerunner);
                break;
            case 1:
                caratulas.setImageResource(R.drawable.la_iception);
                break;
            case 2:
                caratulas.setImageResource(R.drawable.ma_madmax);
                break;
            case 3:
                caratulas.setImageResource(R.drawable.na_interstellar);
                break;
            case 4:
                caratulas.setImageResource(R.drawable.oa_terminator);
                break;
            case 5:
                caratulas.setImageResource(R.drawable.pa_darknight);
                break;
            case 6:
                caratulas.setImageResource(R.drawable.qa_seven);
                break;
            case 7:
                caratulas.setImageResource(R.drawable.ra_johnwick);
                break;
            case 8:
                caratulas.setImageResource(R.drawable.sa_gravity);
                break;
            case 9:
                caratulas.setImageResource(R.drawable.ta_looper);
                break;
            default:
                caratulas.setImageResource(R.drawable.logoapp);
                break;
        }
    }

    @Override
    public void onClick(View view) {
        if (view == caratulaPelicula) {
            // Crear un bundle con los parámetros a enviar
            Bundle args = new Bundle();
            args.putString("tituloPelicula2", tituloPelicula);
            args.putInt("numeroPelicula2", numeroPelicula);

            // Navegar al nuevo fragmento
            NavHostFragment.findNavController(DetallesPeliculasFragment.this)
                    .navigate(R.id.nav_caratulaPeliculaFragment, args);
        }
    }

    public static void establecerDatosPelicula(int numeroPelicula, TextView textoTituloPelicula, TextView textoDirectorPelicula, ImageView calificacionPelicula, TextView textoRepartoPelicula, TextView textoSinopsisPelicula, TextView textoSecuelasPrecuelasPelicula, String tituloPelicula) {
        switch (numeroPelicula) {
            case 0:
                textoTituloPelicula.setText(tituloPelicula);
                textoDirectorPelicula.setText(R.string.director_blade_runner);
                calificacionPelicula.setImageResource(R.drawable.a_cincoestrellas);
                textoRepartoPelicula.setText(R.string.reparto_blade_runner);
                textoSinopsisPelicula.setText(R.string.sinopsis_blade_runner);
                textoSecuelasPrecuelasPelicula.setText(R.string.secuelas_precuelas_blade_runner);
                break;
            case 1:
                textoTituloPelicula.setText(tituloPelicula);
                textoDirectorPelicula.setText(R.string.director_inception);
                calificacionPelicula.setImageResource(R.drawable.a_cincoestrellas);
                textoRepartoPelicula.setText(R.string.reparto_inception);
                textoSinopsisPelicula.setText(R.string.sinopsis_inception);
                textoSecuelasPrecuelasPelicula.setText(R.string.secuelas_precuelas_inception);
                break;
            case 2:
                textoTituloPelicula.setText(tituloPelicula);
                textoDirectorPelicula.setText(R.string.director_mad_max);
                calificacionPelicula.setImageResource(R.drawable.b_cuatroestrellas);
                textoRepartoPelicula.setText(R.string.reparto_mad_max);
                textoSinopsisPelicula.setText(R.string.sinopsis_mad_max);
                textoSecuelasPrecuelasPelicula.setText(R.string.secuelas_precuelas_mad_max);
                break;
            case 3:
                textoTituloPelicula.setText(tituloPelicula);
                textoDirectorPelicula.setText(R.string.director_interstellar);
                calificacionPelicula.setImageResource(R.drawable.c_tresestrellas);
                textoRepartoPelicula.setText(R.string.reparto_interstellar);
                textoSinopsisPelicula.setText(R.string.sinopsis_interstellar);
                textoSecuelasPrecuelasPelicula.setText(R.string.secuelas_precuelas_interstellar);
                break;
            case 4:
                textoTituloPelicula.setText(tituloPelicula);
                textoDirectorPelicula.setText(R.string.director_terminator);
                calificacionPelicula.setImageResource(R.drawable.a_cincoestrellas);
                textoRepartoPelicula.setText(R.string.reparto_terminator);
                textoSinopsisPelicula.setText(R.string.sinopsis_terminator);
                textoSecuelasPrecuelasPelicula.setText(R.string.secuelas_precuelas_terminator);
                break;
            case 5:
                textoTituloPelicula.setText(tituloPelicula);
                textoDirectorPelicula.setText(R.string.director_dark_knight);
                calificacionPelicula.setImageResource(R.drawable.a_cincoestrellas);
                textoRepartoPelicula.setText(R.string.reparto_dark_knight);
                textoSinopsisPelicula.setText(R.string.sinopsis_dark_knight);
                textoSecuelasPrecuelasPelicula.setText(R.string.secuelas_precuelas_dark_knight);
                break;
            case 6:
                textoTituloPelicula.setText(tituloPelicula);
                textoDirectorPelicula.setText(R.string.director_seven);
                calificacionPelicula.setImageResource(R.drawable.b_cuatroestrellas);
                textoRepartoPelicula.setText(R.string.reparto_seven);
                textoSinopsisPelicula.setText(R.string.sinopsis_seven);
                textoSecuelasPrecuelasPelicula.setText(R.string.secuelas_precuelas_seven);
                break;
            case 7:
                textoTituloPelicula.setText(tituloPelicula);
                textoDirectorPelicula.setText(R.string.director_john_wick);
                calificacionPelicula.setImageResource(R.drawable.b_cuatroestrellas);
                textoRepartoPelicula.setText(R.string.reparto_john_wick);
                textoSinopsisPelicula.setText(R.string.sinopsis_john_wick);
                textoSecuelasPrecuelasPelicula.setText(R.string.secuelas_precuelas_john_wick);
                break;
            case 8:
                textoTituloPelicula.setText(tituloPelicula);
                textoDirectorPelicula.setText(R.string.director_gravity);
                calificacionPelicula.setImageResource(R.drawable.d_dosestrellas);
                textoRepartoPelicula.setText(R.string.reparto_gravity);
                textoSinopsisPelicula.setText(R.string.sinopsis_gravity);
                textoSecuelasPrecuelasPelicula.setText(R.string.secuelas_precuelas_gravity);
                break;
            case 9:
                textoTituloPelicula.setText(tituloPelicula);
                textoDirectorPelicula.setText(R.string.director_looper);
                calificacionPelicula.setImageResource(R.drawable.b_cuatroestrellas);
                textoRepartoPelicula.setText(R.string.reparto_looper);
                textoSinopsisPelicula.setText(R.string.sinopsis_looper);
                textoSecuelasPrecuelasPelicula.setText(R.string.secuelas_precuelas_looper);
                break;
            default:
                textoTituloPelicula.setText(tituloPelicula);
                textoDirectorPelicula.setText("");
                textoRepartoPelicula.setText("");
                textoSinopsisPelicula.setText("");
                textoSecuelasPrecuelasPelicula.setText("");
                break;
        }
    }


}
