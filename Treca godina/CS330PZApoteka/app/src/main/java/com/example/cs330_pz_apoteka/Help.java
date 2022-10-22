package com.example.cs330_pz_apoteka;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class Help extends Fragment{

        public Help() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view;
            view = inflater.inflate(R.layout.help, container, false);
            return view;
        }
}
