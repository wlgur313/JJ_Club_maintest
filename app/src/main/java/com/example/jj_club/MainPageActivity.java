package com.example.jj_club;
////////////////////메인 페이지///////////////////

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.jj_club.databinding.ActivityMainBinding;
import com.example.jj_club.databinding.ActivityMainPageBinding;

public
class MainPageActivity extends AppCompatActivity {

    // fragment 만들 때 같이 만들어 준 binding
    ActivityMainPageBinding binding;
    @Override
    protected
    void onCreate ( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);

        //==============================Fragment 전환 Start ==================================

        binding = ActivityMainPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replaceFragment(new HomeFragment());

        // fragment에 있는 vector 이미지들 클릭할 때 마다 화면 전환하도록 만든 코드
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.vector_home:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.vector_myClub:
                    replaceFragment(new MyClubFragment());
                    break;
                case R.id.vector_profile:
                    replaceFragment(new ProfileFragment());
                    break;

            }
            return true;
        });

    }

    private void replaceFragment( Fragment  fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();


        //==============================Fragment 전환 End==================================
    }

}