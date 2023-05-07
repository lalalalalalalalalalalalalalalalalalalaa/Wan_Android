package com.example.wan_android.newitem;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.wan_android.databinding.FragmentNewsBinding;

import java.util.ArrayList;

public class NewsFragment extends Fragment {

    private NewsViewModel mViewModel;
    private FragmentNewsBinding binding;
    private NewsAdapter adapter;

    public static NewsFragment newInstance() {
        return new NewsFragment();
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentNewsBinding.inflate(LayoutInflater.from(requireContext()));
        return binding.getRoot();

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mViewModel = new ViewModelProvider(this,  (ViewModelProvider.Factory) ViewModelProvider.NewInstanceFactory.getInstance()).get(NewsViewModel.class);
        setRecycleView();
    }

    private void setBanner(){



    }


    private void setRecycleView(){
            adapter = new NewsAdapter(mViewModel);
            binding.recycleNews.setLayoutManager(new LinearLayoutManager(requireContext()));
            binding.recycleNews.setAdapter(adapter);

            mViewModel.getNews().observe(getViewLifecycleOwner(), items -> {
                adapter.submitList(new ArrayList<>(items), () -> Log.d("Observer", "finish submit list"));
            });
            mViewModel.getNewsData();

    }

}
