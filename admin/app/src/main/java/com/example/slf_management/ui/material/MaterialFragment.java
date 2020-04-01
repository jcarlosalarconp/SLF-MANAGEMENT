package com.example.slf_management.ui.material;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.slf_management.R;

public class MaterialFragment extends Fragment {

    private MaterialViewModel materialViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        materialViewModel =
                ViewModelProviders.of(this).get(MaterialViewModel.class);
        View root = inflater.inflate(R.layout.fragment_material, container, false);
        final TextView textView = root.findViewById(R.id.text_material);
        materialViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}