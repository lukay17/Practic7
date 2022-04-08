package com.lega.practic7.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;
import com.lega.practic7.R;
import com.lega.practic7.databinding.FragmentHomeBinding;
import com.lega.practic7.repository.User;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private static final String KEY_DATA = "data" ;
    private static String name = "";
    private static String surname = "";
    private String welcome = "";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        loadComponents();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public static Fragment newInstance(User user){
        HomeFragment fragment = new HomeFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(KEY_DATA, user);
        fragment.setArguments(bundle);
        if(user != null){
            name = user.getUser();
            surname = user.getSurName();
        }
        return fragment;
    }

    private void loadComponents() {
        binding.AHTitle.setText(R.string.home_title);

        binding.AHCardImage.setImageResource(R.drawable.calendar);

        binding.AHCardTitle1.setText(R.string.title1);

        binding.AHCardSubtitle1.setText(R.string.subtitle1);

        binding.AHCardImage2.setImageResource(R.drawable.tree);

        binding.AHCardTitle2.setText(R.string.title2);

        binding.AHCardSubtitle2.setText(R.string.subtitle2);

        welcome = "Hi, " + name + " " + surname;
        binding.AHUser.setText(welcome);
        Snackbar.make(binding.AHTitle, welcome, Snackbar.LENGTH_SHORT).show();
    }

    public void openWeb(String url){
        Uri web= Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW,web);
        startActivity(intent);
    }
}