package es.studium.pmdm_practicat6.ui.peliculas;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PeliculasViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public PeliculasViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Este es el Fragmento de películas.");
    }

    public LiveData<String> getText() {
        return mText;
    }
}