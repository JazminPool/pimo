package e.jazmi.pimo;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.TypefaceSpan;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;

//Debemos importar todo para que agarre!!!!, cada uno es una vista de la app
public class MainActivity extends AppCompatActivity implements  NavigationView.OnNavigationItemSelectedListener, Fragment_Chat.OnFragmentInteractionListener,
        Fragment_Recordatorios.OnFragmentInteractionListener, Fragment_Notas.OnFragmentInteractionListener,
        Fragment_Contact.OnFragmentInteractionListener, Fragment_Schedule.OnFragmentInteractionListener,
        Fragment_Faqs_Menu.OnFragmentInteractionListener, Fragment_Info.OnFragmentInteractionListener, Fragment_Score.OnFragmentInteractionListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //dos lineas magicas que hacen el fullscreen :)
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.TextBlueGray));
        toolbar.setTitle("P i m o "+ "\uD83D\uDC36");

        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        Fragment chat = new Fragment_Chat();
        getSupportFragmentManager().beginTransaction().add(R.id.content_main, chat).commit();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment miFragment = null;
        boolean fragment_seleccionado = false;

        if (id == R.id.nav_chat) {
            miFragment = new Fragment_Chat();
            fragment_seleccionado=true;
        } else if (id == R.id.nav_reminder) {
            miFragment = new Fragment_Recordatorios();
            fragment_seleccionado=true;
        } else if (id == R.id.nav_note) {
            miFragment = new Fragment_Notas();
            fragment_seleccionado=true;
        } else if (id == R.id.nav_contact) {
            miFragment = new Fragment_Contact();
            fragment_seleccionado=true;
        } else if (id == R.id.nav_schedule) {
            miFragment = new Fragment_Schedule();
            fragment_seleccionado=true;
        } else if (id == R.id.nav_faqs) {
            miFragment = new Fragment_Faqs_Menu();
            fragment_seleccionado=true;
        } else if (id == R.id.nav_rank) {
            miFragment = new Fragment_Score();
            fragment_seleccionado=true;
        }
        else if(id == R.id.nav_info){
            miFragment = new Fragment_Info();
            fragment_seleccionado=true;
        }

        if(fragment_seleccionado==true){
            //todo: reemplaza el contenido del inicio por el nuevo fragment seleccionado.
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main,miFragment).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
