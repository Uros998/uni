package com.example.cs330_pz_apoteka;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.cs330_pz_apoteka.database.DBHelper;
import com.example.cs330_pz_apoteka.fragments.HelpFragment;
import com.example.cs330_pz_apoteka.fragments.LekFragment;
import com.example.cs330_pz_apoteka.fragments.MapsActivity;
import com.example.cs330_pz_apoteka.fragments.UsersProfileFragment;
import com.example.cs330_pz_apoteka.fragments.WelcomeFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import java.io.ByteArrayInputStream;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private TextView welcomeUser;
    private String email, username;
    private TextView tvEmail, tvUsername;
    static final String STATE_USER = "user";
    DBHelper dbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbhelper = new DBHelper(this);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Contact Via")
                        .setItems(R.array.helper, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                if(which == 0){
                                    Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: +381656629465"));
                                    startActivity(intentCall);
                                } else if(which == 1){
                                    String[] to = {"bogijanko01@gmail.com"};
                                    String[] cc = null;
                                    sendEmail(to,null,"Moja apoteka-Pitanje", "Pozdrav, imam sledeci problem: ,\n" + username);
                                }
                            }
                        });
                builder.create();
                builder.show();
            }
        });
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);

        String email = getIntent().getStringExtra("EMAIL");
        String username = getIntent().getStringExtra("NAME");

        System.out.println("NAME: " + username + " EMAIL: " + email + "  ");

        View v =  navigationView.getHeaderView(0);
        ImageView avatar = v.findViewById(R.id.profile_image);
        byte[] photo = dbhelper.getImage(email);
        if(photo != null){
            ByteArrayInputStream imgStream = new ByteArrayInputStream(photo);
            Bitmap bm= BitmapFactory.decodeStream(imgStream);
            try{
                if(bm != null){
                    avatar.setImageBitmap(bm);
                } else{
                    Toast.makeText(this, "Image is null", Toast.LENGTH_SHORT).show();
                }
            } catch (NullPointerException e){
                e.printStackTrace();
            }
        }
        try {
            tvUsername = (TextView) v.findViewById(R.id.welcomeName);
            tvUsername.setText(username);

            tvEmail = (TextView) v.findViewById(R.id.welcomeMail);
            tvEmail.setText(email);
        } catch (NullPointerException e){
            e.printStackTrace();
        }

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString(STATE_USER, email);
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        savedInstanceState = getIntent().getExtras();

        try {
            if (email.toString() != null || !TextUtils.isEmpty(email)) {
                welcomeUser.setText("Welcome " + email);
            } else if (savedInstanceState == null) {
                Toast.makeText(this, "Bundle is null", Toast.LENGTH_SHORT).show();
            }
        } catch (NullPointerException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            case R.id.action_help:
                Fragment fragment;
                fragment = new HelpFragment();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Fragment fragment = null;
        FragmentActivity fragmentActivity = null;
        System.out.println("Kliknuto");
        int id = item.getItemId();
        if (id == R.id.nav_home) {
            try {
                fragment = new WelcomeFragment();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        else if (id == R.id.nav_profile) {
            String username = getIntent().getStringExtra("NAME");
            String email = getIntent().getStringExtra("EMAIL");
            try {
                Class fragmentClass;
                fragmentClass = UsersProfileFragment.class;
                fragment = (Fragment) fragmentClass.newInstance();
                Bundle bundle = new Bundle();
                bundle.putString("NAME", username);
                bundle.putString("EMAIL", email);
                fragment.setArguments(bundle);
                fragment = new UsersProfileFragment();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        else if (id == R.id.nav_map) {
            try {
                Intent maps = new Intent(this, MapsActivity.class);
                startActivity(maps);
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        else if (id == R.id.nav_help) {
            try {
                fragment = new HelpFragment();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        else if (id == R.id.nav_lekovi) {
            try {
                fragment = new LekFragment();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        else if (id == R.id.nav_logout){
            finish();
        }

        if (fragment != null){
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(R.id.main_frame, fragment);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }else if(!drawer.isDrawerOpen(GravityCompat.START)){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Izloguj se");
            builder.setMessage("Da li ste sigurni da zelite da se izlogujete?");
            builder.setCancelable(false);
            builder.setPositiveButton("Da", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });

            builder.setNegativeButton("Ne", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            builder.show();
        } else {
            super.onBackPressed();
        }
    }

    public void call(View v){
        Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: +381656629465"));
        startActivity(intentCall);
    }

    public void visit(View v){
        Intent mapsIntent = new Intent(this, MapsActivity.class);
        startActivity(mapsIntent);
    }

    public void mail(View v){
        String[] to = {"bogijanko01@gmail,com"};
        String[] cc = null;
        sendEmail(to,null,"Moja apoteka-pitanje", "Pozdrav, imam sledeci problem: ");
    }

    private void sendEmail(String[] emailAddresses, String[] carbonCopies, String subject, String message) {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        String[] to = emailAddresses;
        String[] cc = carbonCopies;
        emailIntent.putExtra(Intent.EXTRA_EMAIL, to);
        emailIntent.putExtra(Intent.EXTRA_CC, cc);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, message);
        emailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIntent, "Email"));
    }
}