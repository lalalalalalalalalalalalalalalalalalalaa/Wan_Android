package com.example.wan_android.newitem;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class NewsViewModelFactoy extends ViewModelProvider.NewInstanceFactory {

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(NewsViewModel.class)){
            return (T) new NewsViewModel(new NewsRepository());
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
