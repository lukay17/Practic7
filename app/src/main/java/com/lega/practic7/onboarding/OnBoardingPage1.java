package com.lega.practic7.onboarding;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.lega.practic7.PageAdapterOnboarding;
import com.lega.practic7.R;

import com.lega.practic7.ViewActivity;
import com.lega.practic7.databinding.FragmentOnBoardingPage1Binding;

public class OnBoardingPage1 extends Fragment {

    private FragmentOnBoardingPage1Binding binding;
    private String next = "TWO";

    public OnBoardingPage1() {
        // Required empty public constructor
    }

    public static OnBoardingPage1 newInstance() {
        return new OnBoardingPage1();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

   @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentOnBoardingPage1Binding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listener();

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private void listener(){
        binding.FOP1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ViewActivity.class);
                intent.putExtra("pos", next);
                startActivity(intent);
            }
        });

    }
}