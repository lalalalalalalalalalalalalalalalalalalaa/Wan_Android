package com.example.wan_android.newitem;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wan_android.R;
import com.example.wan_android.databinding.FragmentNewsBinding;
import com.example.wan_android.databinding.NewsItemBinding;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

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

        mViewModel = new ViewModelProvider(this, (ViewModelProvider.Factory) ViewModelProvider.NewInstanceFactory.getInstance()).get(NewsViewModel.class);
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
