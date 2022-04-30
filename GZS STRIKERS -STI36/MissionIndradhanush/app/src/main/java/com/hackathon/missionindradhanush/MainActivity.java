package com.hackathon.missionindradhanush;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import android.support.v4.app.Fragment;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.hackathon.missionindradhanush.HomeFragment;
import com.hackathon.missionindradhanush.ProfileFragment;
import com.hackathon.missionindradhanush.R;

public class MainActivity extends AppCompatActivity
        implements



        NavigationView.OnNavigationItemSelectedListener,HomeFragment.OnFragmentInteractionListener {

    NavigationView navigationView;
    int size;
    String title;
    DrawerLayout drawer;
    Button btn;
    FragmentManager fragmentManager;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




         drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        size = navigationView.getMenu().size();
        for (int i = 0; i < size; i++) {
            navigationView.getMenu().getItem(i).setCheckable(false);
        }

        FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
        tx.replace(R.id.frame_container, new HomeFragment());
        tx.commit();

     //   btn=(Button)findViewById(R.id.addchild);

       /** btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), AddChild.class)) ;
            }
        });**/



    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            firebaseAuth=FirebaseAuth.getInstance();
            firebaseAuth.signOut();
            finish();

            startActivity(new Intent(this,LoginActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")



        //replacing the fragment


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Fragment fragment = null;
        Intent intent;

        Bundle bundle = new Bundle();
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        if (id == R.id.home) {
            fragment = new HomeFragment();
            ft.replace(R.id.frame_container, fragment);
            ft.addToBackStack(null);
            ft.commit();

        } else if (id == R.id.profile) {

            fragment = new ProfileFragment();
            ft.replace(R.id.frame_container, fragment);
            ft.addToBackStack(null);

            ft.commit();


        } else if (id == R.id.faq) {

            fragment = new FAQFragment();
            ft.replace(R.id.frame_container, fragment);
            ft.addToBackStack(null);

            ft.commit();



        } else if (id == R.id.nearby) {


            fragment = new NearByFragment();
            ft.replace(R.id.frame_container, fragment);
            ft.addToBackStack(null);

            ft.commit();

        }

    //    if (fragment != null) {


  //    }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }




}



