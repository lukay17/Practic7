package com.lega.practic7;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.snackbar.Snackbar;
import com.lega.practic7.databinding.ActivityViewBinding;
import com.lega.practic7.onboarding.OnBoardingPage1;
import com.lega.practic7.onboarding.OnBoardingPage2;
import com.lega.practic7.onboarding.OnBoardingPage3;

public class ViewActivity extends AppCompatActivity {

    private ActivityViewBinding binding;
    private PageAdapterOnboarding pageAdapter;
    private String position;
    private String pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        pageAdapter = new PageAdapterOnboarding(this);
        binding.VPAContainerPages.setAdapter(pageAdapter);
        binding.VPAContainerPages.setCurrentItem(0, false);
        binding.VPAContainerPages.setUserInputEnabled(false);

        if(getIntent().getExtras() != null){
            position = getIntent().getExtras().getString("pos");
            Log.e("lega",position);
            switch (position){
                case "ONE":
                    binding.VPAContainerPages.setCurrentItem(0, false);
                    break;
                case "TWO":
                    binding.VPAContainerPages.setCurrentItem(1, false);
                    break;
                case "THREE":
                    binding.VPAContainerPages.setCurrentItem(2, false);
                    break;
                default:
                    throw  new IllegalStateException("Unexpected value " + position);
            }
        }
    }



}