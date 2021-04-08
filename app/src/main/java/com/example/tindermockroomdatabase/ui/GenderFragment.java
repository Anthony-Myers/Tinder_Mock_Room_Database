package com.example.tindermockroomdatabase.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.tindermockroomdatabase.ProfileViewModel;
import com.example.tindermockroomdatabase.databinding.GenderFragmentBinding;
import com.example.tindermockroomdatabase.R;

public class GenderFragment extends Fragment {

    private ProfileViewModel mProfileViewModel;
    private GenderFragmentBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = GenderFragmentBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mProfileViewModel = new ViewModelProvider(requireActivity(),
                new ViewModelProvider.AndroidViewModelFactory(requireActivity().getApplication()))
                .get(ProfileViewModel.class);

        if(!mProfileViewModel.getProfileGender().isEmpty()){
            enableContinue();
        }

        binding.genderConsentCheckbox.setChecked(mProfileViewModel.getProfileGenderConsent());

        if(mProfileViewModel.getProfileGender().equals(binding.manButton.getText().toString())){
            binding.manButton.setBackgroundColor(getResources().getColor(R.color.button_orange));
            binding.manButton.setTextColor(getResources().getColor(R.color.black));
        }

        if(mProfileViewModel.getProfileGender().equals(binding.womanButton.getText().toString())){
            binding.womanButton.setBackgroundColor(getResources().getColor(R.color.button_orange));
            binding.womanButton.setTextColor(getResources().getColor(R.color.black));
        }

        binding.manButton.setOnClickListener(v -> {
            mProfileViewModel.setProfileGender(binding.manButton.getText().toString());
            binding.manButton.setBackgroundColor(getResources().getColor(R.color.button_orange));
            binding.manButton.setTextColor(getResources().getColor(R.color.black));
            binding.womanButton.setBackgroundColor(getResources().getColor(R.color.white));
            binding.womanButton.setTextColor(getResources().getColor(R.color.subtext_grey));
            enableContinue();
        });

        binding.womanButton.setOnClickListener(v -> {
            mProfileViewModel.setProfileGender(binding.womanButton.getText().toString());
            binding.womanButton.setBackgroundColor(getResources().getColor(R.color.button_orange));
            binding.womanButton.setTextColor(getResources().getColor(R.color.black));
            binding.manButton.setBackgroundColor(getResources().getColor(R.color.white));
            binding.manButton.setTextColor(getResources().getColor(R.color.subtext_grey));
            enableContinue();
        });

        binding.continueButton.setOnClickListener(v -> {
            NavHostFragment.findNavController(this).navigate(R.id.action_gender_fragment_to_school_fragment);
        });

        binding.backToBirthdayButton.setOnClickListener(v -> {
            NavHostFragment.findNavController(this).navigate(R.id.action_gender_fragment_pop);
        });

        binding.genderConsentCheckbox.setOnClickListener(v -> {
            mProfileViewModel.setProfileGenderConsent(binding.genderConsentCheckbox.isChecked());
        });
    }

    public void enableContinue(){
        binding.continueButton.setBackgroundColor(getResources().getColor(R.color.button_orange));
        binding.continueButton.setTextColor(getResources().getColor(R.color.white));
        binding.continueButton.setEnabled(true);
    }
}
