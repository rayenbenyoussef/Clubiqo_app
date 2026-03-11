package com.example.clubiqoapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.clubiqoapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private static String userRole="visitor";
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());
        if(!TokenManager.isTokenExpired(TokenManager.readToken(this))){
            replaceFrag(HomePageFragment.newInstance(
                    "profile"
            ));
            setUserRole(DataController.getProfileInfo().getRole());
        }else{
            replaceFrag(new LoginFragment());
        }
    }

    public void replaceFrag(Fragment frag){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_lay,frag)
                .commit();
    }
    public void setUserRole(String role) {
        userRole = role;
    }

    public String getUserRole() {
        return userRole;
    }
}