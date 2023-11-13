package com.mohit.nav_bar;

import android.os.Bundle;
import android.view.View;
import android.view.Menu;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.mohit.nav_bar.databinding.ActivityMainBinding;
import com.mohit.nav_bar.ui.gallery.GalleryFragment;
import com.mohit.nav_bar.ui.home.HomeFragment;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    private HomeFragment homeFragment;
    private GalleryFragment profileFragment;
    MeowBottomNavigation bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        bottomNavigation = findViewById(R.id.bottomNavigation);
        // Initialize the fragments
        homeFragment = new HomeFragment();

        // Add navigation items
        bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.ic_menu_gallery));
        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.ic_menu_camera));
        bottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.ic_menu_camera));
        bottomNavigation.add(new MeowBottomNavigation.Model(4, R.drawable.ic_menu_camera));

        // Set a listener for item clicks
        bottomNavigation.setOnClickMenuListener(model -> {
            // Handle navigation based on model.getId()
            switch (model.getId()) {
                case 1:
                    // Switch to the Home Fragment
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragmentContainer, homeFragment)
                            .commit();
                    break;
                case 2:


                    break;
                case 3:

                    break;
                case 4:

            }
            return null;
        });

        // Set the default selected item
        bottomNavigation.show(1, true);
        // Add this to set HomeFragment as the initial fragment
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, homeFragment)
                .commit();



    setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}