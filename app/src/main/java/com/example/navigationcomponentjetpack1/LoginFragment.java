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
import android.widget.EditText;


public class LoginFragment extends Fragment {





    public LoginFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EditText useredittext=view.findViewById(R.id.edit_text_username);
        EditText passwordedittext=view.findViewById(R.id.edit_text_password);
        useredittext.setText(LoginFragmentArgs.fromBundle(getArguments()).getUsername());


        Button button_confirm=view.findViewById(R.id.button_confirm);
        button_confirm.setOnClickListener(
                v -> {



                    String username=useredittext.getText().toString();
                    String password=passwordedittext.getText().toString();
                    NavDirections action = LoginFragmentDirections.actionLoginFragmentToWelcomeFragment(
                            username,password
                    );
                    Navigation.findNavController(v).navigate(action);


                }


        );
    }
}