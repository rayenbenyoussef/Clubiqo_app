package com.example.clubiqoapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.material.snackbar.Snackbar;

public class UpdateProfileFragment extends Fragment {

    public static final String ARG_FULLNAME="Fullname";
    public static final String ARG_PHONEN="Phone number";
    public static final String ARG_PASSWORD="Password";

    private String fullname;
    private String phoneNumber;
    private String password;



    public UpdateProfileFragment() {
        // Required empty public constructor
    }


    public static UpdateProfileFragment newInstance(String fullname,String phonenumber,String password) {
        UpdateProfileFragment fragment = new UpdateProfileFragment();
        Bundle args=new Bundle();
        args.putString(ARG_FULLNAME,fullname);
        args.putString(ARG_PHONEN,phonenumber);
        args.putString(ARG_PASSWORD,password);
        fragment.setArguments(args);

        return fragment;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null) {
            Bundle args = getArguments();

            this.fullname = args.getString(ARG_FULLNAME);
            this.phoneNumber = args.getString(ARG_PHONEN);
            this.password = args.getString(ARG_PASSWORD);

        }

        EditText userFullname=view.findViewById(R.id.user_fullname);
        userFullname.setHint(this.fullname);

        EditText userPhone=view.findViewById(R.id.user_phone);
        userPhone.setHint(this.phoneNumber);

        EditText userPassword=view.findViewById(R.id.user_password);
        userPassword.setHint(this.password);

        EditText userCPassword=view.findViewById(R.id.confrim_pass);

        ImageButton btnBack = view.findViewById(R.id.dvback_button);

        btnBack.setOnClickListener(v -> {

            getParentFragmentManager().beginTransaction()
                    .replace(R.id.frame_lay, HomePageFragment.newInstance(
                            "profile"
                    ))
                    .addToBackStack(null)
                    .commit();
        });

        ImageButton btnDone = view.findViewById(R.id.done_button);

        btnDone.setOnClickListener(v -> {
            String fullnameStr=userFullname.getText().toString().trim();
            String phonenumberStr=userPhone.getText().toString().trim();
            String passwordStr=userPassword.getText().toString();
            String cpasswordStr=userCPassword.getText().toString();

            if(!fullnameStr.isEmpty() && fullnameStr.split(" ").length!=2){
                userFullname.setError("enter fullname please.");
                return;
            }
            if(!phonenumberStr.isEmpty() && phonenumberStr.length()!=8){
                userPhone.setError("phone number must have 8 digits");
                return;
            }
            if(!passwordStr.isEmpty() && !passwordStr.equals(cpasswordStr)){
                userCPassword.setError("recheck your password");
                return;
            }

            if(DataController.updateProfile(fullnameStr,phonenumberStr,passwordStr)){

                getParentFragmentManager().beginTransaction()
                        .replace(R.id.frame_lay, HomePageFragment.newInstance(
                                "profile"
                        ))
                        .addToBackStack(null)
                        .commit();
            }else{
                Snackbar.make(v,"Something went wrong, please check your informations.", Snackbar.LENGTH_LONG)
                        .show();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_update_profile, container, false);
    }
}