package com.example.wan_android;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.wan_android.categories.CategoriesFragment;
import com.example.wan_android.databinding.ActivityMainBinding;
import com.example.wan_android.newitem.NewsFragment;
import com.example.wan_android.setting.SettingFragment;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Main_ViewModel viewModel;
//    private Fragment settingFragment, categoriesFragment, newsFragment;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this));
        viewModel = new ViewModelProvider(this).get(Main_ViewModel.class);
        setContentView(binding.getRoot());

        initFragment();
        bottom_init();
        changetitle(R.string.News);


    }

    @SuppressLint("NonConstantResourceId")
    private void bottom_init(){
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){
                case R.id.menu_News:
                    showFragment(NewsFragment.newInstance());
                    changetitle(R.string.News);
                    break;
                case R.id.menu_Settings:
                    showFragment(SettingFragment.newInstance());
                    changetitle(R.string.settings);
                    break;
                case R.id.menu_Categories:
                    showFragment(CategoriesFragment.newInstance());
                    changetitle(R.string.Component);
                    break;
            }

            return true;
        });
    }


    private void initFragment(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
//        settingFragment = SettingFragment.newInstance();
//        categoriesFragment = CategoriesFragment.newInstance();
//        newsFragment = NewsFragment.newInstance();
//        transaction.add(R.id.fragment_layout,settingFragment);
//        transaction.add(R.id.fragment_layout, categoriesFragment);
//        transaction.add(R.id.fragment_layout, newsFragment);
        transaction.add(R.id.fragment_layout, NewsFragment.newInstance());
        transaction.commit();
//        showFragment(newsFragment);
    }

//    private void showFragment(Fragment fragment){
//        hideFragment();
//        getSupportFragmentManager().beginTransaction().show(fragment).commit();
//    }
    private void showFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout, fragment).commit();
    }

//    private void hideFragment(){
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.hide(settingFragment);
//        transaction.hide(categoriesFragment);
//        transaction.hide(newsFragment);
//        transaction.commit();
//    }


    private void changetitle(int stringId){
        Objects.requireNonNull(getSupportActionBar()).setTitle(getString(stringId));
    }


}