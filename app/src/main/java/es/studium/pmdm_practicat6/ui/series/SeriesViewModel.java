package es.studium.pmdm_practicat6.ui.series;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SeriesViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public SeriesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Este es el Fragmento de series.");
    }

    public LiveData<String> getText() {
        return mText;
    }
}