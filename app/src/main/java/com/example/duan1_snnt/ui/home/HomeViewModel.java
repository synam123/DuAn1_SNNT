package com.example.duan1_snnt.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Chào Mừng Bạn Đến Với Shop SNNT");
    }

    public LiveData<String> getText() {
        return mText;
    }
}