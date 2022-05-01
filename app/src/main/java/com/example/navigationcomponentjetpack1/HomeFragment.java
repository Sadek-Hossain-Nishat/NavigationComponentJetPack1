package com.example.navigationcomponentjetpack1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

public class HomeFragment extends Fragment {
    public HomeFragment() {
    }




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button button_login=view.findViewById(R.id.button_login);
        button_login.setOnClickListener(v -> {

            NavDirections action=HomeFragmentDirections.actionHomeFragment2ToLoginFragment(null);
            Navigation.findNavController(v).navigate(action);



        });
    }
}
