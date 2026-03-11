package com.example.clubiqoapp;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.security.SecureRandom;
import java.time.LocalDateTime;

public class LoginFragment extends Fragment {

    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();

        return fragment;
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

        TextView signupButton=view.findViewById(R.id.signup_button);
        TextView forgotButton=view.findViewById(R.id.forgot_button);
        TextView visitorButton=view.findViewById(R.id.visitor_button);
        Button done=view.findViewById(R.id.login_button);
        EditText email=view.findViewById(R.id.log_email);
        EditText password=view.findViewById(R.id.log_pass);

        signupButton.setOnClickListener(v -> {
            ((MainActivity) requireActivity()).replaceFrag(new SignupFragment());
        });
        forgotButton.setOnClickListener(v -> {
            if(!email.getText().toString().trim().isEmpty()) {
                DataController.resetPassword(email.getText().toString().trim());
                Snackbar.make(v, "A mail has been sent to you containing the new password.", Snackbar.LENGTH_INDEFINITE)
                        .setBackgroundTint(Color.YELLOW)
                        .setTextColor(Color.BLACK)
                        .setAction("Dismiss", s -> {})
                        .show();

            }else {
                Snackbar.make(v,"Please enter an email.", Snackbar.LENGTH_LONG)
                        .show();
            }
        });
        done.setOnClickListener(v -> {
            String emailStr=email.getText().toString().trim();
            if(emailStr.isEmpty()) {
                email.setError("Required");
                return;
            }
            String passStr=password.getText().toString();
            if(passStr.isEmpty()) {
                password.setError("Required");
                return;
            }
            if(DataController.login(emailStr,passStr)){
                Member member=DataController.getProfileInfo();
                TokenManager.generateToken(requireContext());
                ((MainActivity) requireActivity()).setUserRole(member.getRole());
                ((MainActivity) requireActivity()).replaceFrag(HomePageFragment.newInstance("profile")
                );
            }else{
                Snackbar.make(v,"Email or password is wrong!", Snackbar.LENGTH_LONG)
                            .show();
            }

        });

        visitorButton.setOnClickListener(v -> {
            Fragment homePageFragment=HomePageFragment.newInstance(
                    "news"
            );
            ((MainActivity) requireActivity()).replaceFrag(homePageFragment);
        });
    }

}