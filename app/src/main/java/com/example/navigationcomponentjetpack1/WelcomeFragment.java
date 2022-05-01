package com.example.navigationcomponentjetpack1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public   class WelcomeFragment extends Fragment{


    public WelcomeFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_welcome, container, false);
    }


     @Override
     public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
         super.onViewCreated(view, savedInstanceState);

         TextView textView_username=view.findViewById(R.id.text_view_username);
         TextView textView_password=view.findViewById(R.id.text_view_password);
         Button button_ok=view.findViewById(R.id.button_ok);


         textView_username.setText(WelcomeFragmentArgs.fromBundle(getArguments()).getUsername());
         textView_password.setText(WelcomeFragmentArgs.fromBundle(getArguments()).getPassword());


         button_ok.setOnClickListener(v ->{

             NavDirections action=WelcomeFragmentDirections.actionWelcomeFragmentToHomeFragment2();
             Navigation.findNavController(v).navigate(action);

         });
     }
 }