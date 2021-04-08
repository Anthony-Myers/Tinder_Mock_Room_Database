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

import com.example.tindermockroomdatabase.R;

import com.example.tindermockroomdatabase.ProfileViewModel;
import com.example.tindermockroomdatabase.databinding.EmailFragmentBinding;

import java.util.regex.Pattern;

public class EmailFragment extends Fragment {
    private ProfileViewModel mProfileViewModel;
    private EmailFragmentBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = EmailFragmentBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mProfileViewModel = new ViewModelProvider(requireActivity(),
                new ViewModelProvider.AndroidViewModelFactory(requireActivity().getApplication()))
                .get(ProfileViewModel.class);

        binding.emailEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void afterTextChanged(Editable s) {
                if(isValidEmail(binding.emailEditText.getText().toString())){
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
            mProfileViewModel.setProfileEmail(binding.emailEditText.getText().toString());
            NavHostFragment.findNavController(this).navigate(R.id.action_email_fragment_to_name_fragment);
        });

        binding.xButton.setOnClickListener(v -> {
            requireActivity().finish();
            System.exit(0);
        });
    }

    @Override
    public void onResume() {
        binding.emailEditText.setText(mProfileViewModel.getProfileEmail());
        super.onResume();
    }

    public boolean isValidEmail(String email){
        Pattern emailRegex = Pattern.compile("^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$");
        return emailRegex.matcher(email).matches();
    }
}
