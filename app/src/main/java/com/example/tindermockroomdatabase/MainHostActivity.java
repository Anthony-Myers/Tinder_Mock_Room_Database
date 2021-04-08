package com.example.tindermockroomdatabase;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.Navigation;

public class MainHostActivity extends FragmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_host_fragment);

        Navigation.findNavController(this, R.id.form_nave_host_fragment)
                .setGraph(R.navigation.form_nav_graph);
    }
}
