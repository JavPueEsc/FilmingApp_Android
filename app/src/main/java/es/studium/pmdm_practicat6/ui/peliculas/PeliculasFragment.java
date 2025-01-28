package es.studium.pmdm_practicat6.ui.peliculas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import es.studium.pmdm_practicat6.MainActivity;
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

        final TextView textView = binding.textPeliculas;
        galleryViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}