package com.example.clubiqoapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomePageFragment extends Fragment {

    public static final String ARG_FRAGNAME="Fragment name";

    private String fragName;

    public HomePageFragment() {
        // Required empty public constructor
    }

    public static HomePageFragment newInstance(String fragName) {
        HomePageFragment fragment=new HomePageFragment();

        Bundle args=new Bundle();
        args.putString(ARG_FRAGNAME,fragName);
        fragment.setArguments(args);

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
        return inflater.inflate(R.layout.fragment_home_page, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            Bundle args = getArguments();
            this.fragName = args.getString(ARG_FRAGNAME);
        }

        Fragment startFrag;
        if(this.fragName.equals("news")){
            startFrag=new NewsFragment();
        }else if(this.fragName.equals("events")){
            startFrag=new EventsFragment();

        }else if(this.fragName.equals("profile")){
            Fragment updatedProfileFragment= ProfileFragment.newInstance(
                    DataController.getProfileInfo().getFullname(),
                    DataController.getProfileInfo().getEmail()
            );
            startFrag=updatedProfileFragment;
        }else if(this.fragName.equals("manage")){
            startFrag=new ManageFragment();
        }else if(this.fragName.equals("settings")){

            startFrag=new SettingsFragment();
        }else{
            startFrag=new NewsFragment();
        }

        getParentFragmentManager()
                .beginTransaction()
                .replace(R.id.home_frame_lay, startFrag)
                .commit();

        BottomNavigationView bottomNavigationView = view.findViewById(R.id.bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        if(((MainActivity) requireActivity()).getUserRole().equals("Admin")||
                ((MainActivity) requireActivity()).getUserRole().equals("Moderator")){
            menu.findItem(R.id.manage).setVisible(true);
        }else{
            menu.findItem(R.id.manage).setVisible(false);
        }


        bottomNavigationView.setOnItemSelectedListener(item -> {
            int id=item.getItemId();
            Fragment selectedFragment=null;
            if(id==R.id.events){
                selectedFragment=new EventsFragment();
            }else if (id==R.id.profile) {
                if(((MainActivity) requireActivity()).getUserRole().equals("visitor")){
                    ((MainActivity) requireActivity()).replaceFrag(new LoginFragment());
                }else{
                    selectedFragment=ProfileFragment.newInstance(
                            DataController.getProfileInfo().getFullname(),
                            DataController.getProfileInfo().getEmail()
                    );
                }

            }else if (id==R.id.news) {
                selectedFragment=new NewsFragment();
            }else if (id==R.id.manage) {
                selectedFragment=new ManageFragment();
            }else if (id==R.id.settings) {
                selectedFragment=new SettingsFragment();
            }

            if (selectedFragment != null) {

                // Perform the fragment transaction
                getParentFragmentManager()   // or getSupportFragmentManager() if in Activity
                        .beginTransaction()
                        .replace(R.id.home_frame_lay, selectedFragment)
                        .addToBackStack(null)
                        .commit();
            }



            return true;
        } );


    }
}