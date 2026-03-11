package com.example.clubiqoapp;

import android.app.DatePickerDialog;
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

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SignupFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SignupFragment extends Fragment {

    public SignupFragment() {
        // Required empty public constructor
    }

    public static SignupFragment newInstance(String param1, String param2) {
        SignupFragment fragment = new SignupFragment();
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
        return inflater.inflate(R.layout.fragment_signup, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView loginButton=view.findViewById(R.id.log_button);
        Button done=view.findViewById(R.id.sign_button);

        EditText email=view.findViewById(R.id.sign_email);
        EditText fullname=view.findViewById(R.id.sign_fullname);
        EditText nid=view.findViewById(R.id.sign_nid);
        EditText birth=view.findViewById(R.id.sign_birth);
        EditText phonenum=view.findViewById(R.id.sign_phonenum);

        loginButton.setOnClickListener(v -> {
            ((MainActivity) requireActivity()).replaceFrag(new LoginFragment());
        });
        done.setOnClickListener(v -> {
            String fullNameStr = fullname.getText().toString().trim();
            String nidStr = nid.getText().toString().trim();
            String emailStr = email.getText().toString().trim();
            String phoneStr = phonenum.getText().toString().trim();
            String birthStr = birth.getText().toString().trim();

            if(fullNameStr.isEmpty()){
                fullname.setError("Required");
                return;
            }
            if(fullNameStr.split(" ").length!=2){
                fullname.setError("enter fullname please.");
                return;
            }



            if(nidStr.isEmpty()){
                nid.setError("Required");
                return;
            }else if(nidStr.length()!=8){
                nid.setError("National ID must have 8 digits.");
                return;
            }

            if(emailStr.isEmpty()){
                email.setError("Required");
                return;
            }
            int atIndex = emailStr.indexOf("@");
            if (atIndex <= 0 ||
                    atIndex != emailStr.lastIndexOf("@") ||
                    atIndex == emailStr.length() - 1) {

                email.setError("Invalid email");
                return;
            }
            String domainPart = emailStr.substring(atIndex + 1);
            int dotIndex = domainPart.indexOf(".");
            if (dotIndex <= 0 || dotIndex == domainPart.length() - 1) {
                email.setError("Invalid email");
                return;
            }

            if(phoneStr.isEmpty()){
                phonenum.setError("Required");
                return;
            } else if (phoneStr.length()!=8) {
                phonenum.setError("phone number must have 8 digits");
                return;
            }

            if(birthStr.isEmpty()){
                birth.setError("Required");
                return;
            }
            String[] date=birthStr.split("-");
            if(date.length!=3){
                birth.setError("Invalid date format");
                return;
            }
            int birthyear=Integer.parseInt(date[0]);
            int birthmonth=Integer.parseInt(date[1]);
            int birthday=Integer.parseInt(date[2]);
            if(birthyear<1909||birthyear>2009||
                    birthmonth<1||birthmonth>12||
                    birthday<1||birthday>31){
                birth.setError("Invalid date format");
                return;
            }

            if(DataController.signup(fullNameStr, nidStr, emailStr, phoneStr, LocalDate.of(birthyear,birthmonth,birthday))){
                Snackbar.make(view, "Password has been sent to your email. you can login now", Snackbar.LENGTH_INDEFINITE)
                        .setBackgroundTint(Color.YELLOW)
                        .setTextColor(Color.BLACK)
                        .setAction("Dismiss", s -> {})
                        .show();

            }else{
                Snackbar.make(v,"Something went wrong, please check your informations.", Snackbar.LENGTH_LONG)
                        .show();
            }
        });

    }
}