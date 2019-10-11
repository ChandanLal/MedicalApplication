package com.example.android.medicalapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
        TabAdapter tabAdapter;
        ViewPager viewPager;
        TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager=findViewById(R.id.viewPager);
        tabAdapter = new TabAdapter(getSupportFragmentManager());
        tabAdapter.addFragment(new Tab1Fragment(),"Tab 1");
        tabAdapter.addFragment(new Tab2Fragment(),"Tab 2");
        viewPager.setAdapter(tabAdapter);
        tabLayout.setupWithViewPager(viewPager);
         int[] tabIcons = {
                R.drawable.home,
                R.drawable.notification,

        };
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
    }
}
