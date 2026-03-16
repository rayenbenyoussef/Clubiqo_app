package com.example.clubiqoapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.navigation.NavigationView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    private static final String ARG_FULLNAME = "Fullname";
    private static final String ARG_EMAIL = "Email";
    private static final String ARG_IMG = "Profile img";

    private String fullname;
    private String email;
    private String img;


    public ProfileFragment() {
        super(R.layout.fragment_profile);
    }

    public static ProfileFragment newInstance(String fullname,String email,String img) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_FULLNAME, fullname);
        args.putString(ARG_EMAIL, email);
        args.putString(ARG_IMG, img);
        fragment.setArguments(args);

        return fragment;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            Bundle args = getArguments();

            this.fullname = args.getString(ARG_FULLNAME);
            this.email = args.getString(ARG_EMAIL);
            this.img = args.getString(ARG_IMG);

        }

        TextView appTitle=requireActivity().findViewById(R.id.app_title);
        appTitle.setText("Profile");

        Button btnEdit = view.findViewById(R.id.edit_button);
        TextView userFullname=view.findViewById(R.id.user_fullname);
        userFullname.setText(this.fullname);
        TextView userEmail=view.findViewById(R.id.user_email);
        userEmail.setText(this.email);
        ImageView img=view.findViewById(R.id.photo_id);

        Glide.with(view.getContext())
                .load(this.img)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error)
                .circleCrop()
                .into(img);

        btnEdit.setOnClickListener(v -> {
            Member member=DataController.getProfileInfo();
            Fragment updateProfilefragment=UpdateProfileFragment.newInstance(
                    member.getFullname(),
                    member.getPhoneNumber(),
                    member.getImg()
            );
            getParentFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_lay,updateProfilefragment)
                    .addToBackStack(null)
                    .commit();
        });

        NavigationView profileNavigationView = view.findViewById(R.id.profile_navbar);
        profileNavigationView.setNavigationItemSelectedListener(item -> {
            int id=item.getItemId();
            if(id==R.id.sub){

            }else if (id==R.id.pay_hist) {

            }else if (id==R.id.logout) {
                TokenManager.deleteToken(requireContext());
                ((MainActivity) requireActivity()).setUserRole("visitor");
                ((MainActivity) requireActivity())
                        .replaceFrag(new LoginFragment());
            }else{
                return false;
            }

            return true;
        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

}