package com.example.navigationcomponentjetpack1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private NavController navController;
    private BottomNavigationView bottom_nav;
    private AppBarConfiguration appBarConfiguration;


    //creating instance for drawerlayout and navigation drawer
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar=findViewById(R.id.toolbar);

        navigationView=findViewById(R.id.id_nav_view);
        drawerLayout=findViewById(R.id.id_drawer_layout);


        // In some cases, you might need to define multiple top-level destinations instead of using the
        // default start destination. Using a BottomNavigationView is a common use case for this,
        // where you may have sibling screens that are not hierarchically related to each other
        // and may each have their own set of related destinations. For cases like these,
        // you can instead pass a set of destination IDs to the constructor, as shown below:
        //pass that setUpActionBarWithNavController

        //setOpenableLayout alternative of setDrawerLayout

        /***
         When the user is at a top-level destination,
         the Navigation button becomes a drawer icon
         if the destination uses a DrawerLayout.
         If the destination doesn't use a DrawerLayout,
         the Navigation button is hidden. When the user is on any other destination,
         the Navigation button appears as an Up button .
         To configure the Navigation button using only
         the start destination as the top-level destination, create an AppBarConfiguration object,
         and pass in the corresponding navigation graph, as shown below:
         ***/

        appBarConfiguration=new AppBarConfiguration.Builder(R.id.homeFragment2,R.id.searchFragment)
                .setOpenableLayout(drawerLayout)
                .build();


        NavHostFragment navHostFragment= (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        navController=navHostFragment.getNavController();
        setSupportActionBar(toolbar);

        
        // to connect custom back button in the appbar with navcontroller
        NavigationUI.setupActionBarWithNavController(this,navController,appBarConfiguration);

        // instantiating the bottomnav
        bottom_nav=findViewById(R.id.bottom_navid);
        // connect bottom nav with navcontroller
        NavigationUI.setupWithNavController(bottom_nav,navController);

        //connect navigation view with navcontroller
        NavigationUI.setupWithNavController(navigationView,navController);






        

    }



    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController,appBarConfiguration)||super.onSupportNavigateUp();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.termsAndConditions){
            NavDirections action=NavGraphDirections.actionGlobalTermsFragment();
            navController.navigate(action);
            return true;

        }
        return NavigationUI.onNavDestinationSelected(item,navController)||super.onOptionsItemSelected(item);
    }
}