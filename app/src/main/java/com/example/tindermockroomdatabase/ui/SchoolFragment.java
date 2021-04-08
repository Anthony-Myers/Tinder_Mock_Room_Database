package com.example.tindermockroomdatabase.ui;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.tindermockroomdatabase.ProfileViewModel;
import com.example.tindermockroomdatabase.R;
import com.example.tindermockroomdatabase.databinding.SchoolFragmentBinding;

public class SchoolFragment extends Fragment {
    private ProfileViewModel mProfileViewModel;
    private SchoolFragmentBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = SchoolFragmentBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mProfileViewModel = new ViewModelProvider(requireActivity(),
                new ViewModelProvider.AndroidViewModelFactory(requireActivity().getApplication()))
                .get(ProfileViewModel.class);

        if(!mProfileViewModel.getProfileSchool().isEmpty()){
            binding.continueButton.setBackgroundColor(getResources().getColor(R.color.button_orange));
            binding.continueButton.setTextColor(getResources().getColor(R.color.white));
            binding.continueButton.setEnabled(true);
        }

        binding.schoolEditText.setText(mProfileViewModel.getProfileSchool());

        binding.schoolEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void afterTextChanged(Editable s) {
                if(!binding.schoolEditText.getText().toString().isEmpty()){
                    binding.continueButton.setBackgroundColor(getResources().getColor(R.color.button_orange));
                    binding.continueButton.setTextColor(getResources().getColor(R.color.white));
                    binding.continueButton.setEnabled(true);
                }else{
                    binding.continueButton.setBackgroundColor(getResources().getColor(R.color.button_disabled_grey));
                    binding.continueButton.setTextColor(getResources().getColor(R.color.button_grey));
                    binding.continueButton.setEnabled(false);
                }
            }
        });

        binding.continueButton.setOnClickListener(v -> {
            mProfileViewModel.setProfileSchool(binding.schoolEditText.getText().toString());
            mProfileViewModel.createPerson();
            mProfileViewModel.clearProfile();
            NavHostFragment.findNavController(this).navigate(R.id.action_school_fragment_to_profiles_fragment);
        });

        binding.backToGenderButton.setOnClickListener(v -> {
            mProfileViewModel.setProfileSchool(binding.schoolEditText.getText().toString());
            NavHostFragment.findNavController(this).navigate(R.id.action_school_fragment_pop);
        });
    }
}
