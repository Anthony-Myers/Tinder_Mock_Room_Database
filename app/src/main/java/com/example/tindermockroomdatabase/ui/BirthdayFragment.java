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
import com.example.tindermockroomdatabase.databinding.BirthdayFragmentBinding;

public class BirthdayFragment extends Fragment {

    private ProfileViewModel mProfileViewModel;
    private BirthdayFragmentBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = BirthdayFragmentBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mProfileViewModel = new ViewModelProvider(requireActivity(),
                new ViewModelProvider.AndroidViewModelFactory(requireActivity().getApplication()))
                .get(ProfileViewModel.class);

        if(!mProfileViewModel.getProfileBirthDay().isEmpty()&&!mProfileViewModel.getProfileBirthMonth().isEmpty()&&!mProfileViewModel.getProfileBirthYear().isEmpty()){
            enableContinue();
        }

        binding.dayEditText.setText(mProfileViewModel.getProfileBirthDay());

        binding.dayEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void afterTextChanged(Editable s) {
                if(!binding.dayEditText.getText().toString().isEmpty() && !binding.monthEditText.getText().toString().isEmpty() && !binding.yearEditText.getText().toString().isEmpty()){
                    enableContinue();
                }else{
                    disableContinue();
                }
            }
        });

        binding.monthEditText.setText(mProfileViewModel.getProfileBirthMonth());

        binding.monthEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void afterTextChanged(Editable s) {
                if(!binding.dayEditText.getText().toString().isEmpty() && !binding.monthEditText.getText().toString().isEmpty() && !binding.yearEditText.getText().toString().isEmpty()){
                    enableContinue();
                }else{
                    disableContinue();
                }
            }
        });

        binding.yearEditText.setText(mProfileViewModel.getProfileBirthYear());

        binding.yearEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void afterTextChanged(Editable s) {
               if(!binding.dayEditText.getText().toString().isEmpty() && !binding.monthEditText.getText().toString().isEmpty() && !binding.yearEditText.getText().toString().isEmpty()){
                   enableContinue();
               }else{
                   disableContinue();
               }
            }
        });

        binding.continueButton.setOnClickListener(v -> {
            mProfileViewModel.setProfileBirthMonth(binding.monthEditText.getText().toString());
            mProfileViewModel.setProfileBirthDay(binding.dayEditText.getText().toString());
            mProfileViewModel.setProfileBirthYear(binding.yearEditText.getText().toString());
            NavHostFragment.findNavController(this).navigate(R.id.action_birthday_fragment_to_gender_fragment);
        });

        binding.backToNameButton.setOnClickListener(v -> {
            mProfileViewModel.setProfileBirthMonth(binding.monthEditText.getText().toString());
            mProfileViewModel.setProfileBirthDay(binding.dayEditText.getText().toString());
            mProfileViewModel.setProfileBirthYear(binding.yearEditText.getText().toString());
            NavHostFragment.findNavController(this).navigate(R.id.action_birthday_fragment_pop);
        });
    }

    public void enableContinue() {
        binding.continueButton.setBackgroundColor(getResources().getColor(R.color.button_orange));
        binding.continueButton.setTextColor(getResources().getColor(R.color.white));
        binding.continueButton.setEnabled(true);
    }

    public void disableContinue() {
        binding.continueButton.setBackgroundColor(getResources().getColor(R.color.button_disabled_grey));
        binding.continueButton.setTextColor(getResources().getColor(R.color.button_grey));
        binding.continueButton.setEnabled(false);
    }

}
