package es.iescarrillo.android.ifoody.activities;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import es.iescarrillo.android.ifoody.R;
import es.iescarrillo.android.ifoody.fragments.HomeFragment;
import es.iescarrillo.android.ifoody.fragments.MyOrdersFragment;
import es.iescarrillo.android.ifoody.fragments.MyProfileFragment;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private NavigationView menu;
    private BottomNavigationView bottomMenu;
    private Fragment fragment;
    private int selectedColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Método para cargar los elementos del xml
        loadComponents();

        // Método para indicar que el toolbar hará la función de barra de acciones
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.open_menu,
                R.string.close_menu);

        // Listener para capturar los eventos que se produzcan en el menú lateral
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        // Evento para sincronizar el estado del botón hamburguesa con el estado del menú lateral
        actionBarDrawerToggle.syncState();

        // Inicializo la variable fragment con el fragment que quiero cargar por defecto
        fragment = new HomeFragment();
        // Cargar el fragment en la Activity
        getSupportFragmentManager().beginTransaction().replace(R.id.content_fragment, fragment).commit();

        // Función para detectar el punto de menú seleccionado, se almacenará en la variable
        // de la función lambda
        menu.setNavigationItemSelectedListener(item -> {

            if(item.getItemId() == R.id.my_orders){ //
                fragment = new MyOrdersFragment();
            } else if (item.getItemId() == R.id.my_profile) {
                fragment = new MyProfileFragment();
            } else if (item.getItemId() == R.id.prueba){
                Log.i("Menu", "Has selecionado prueba");
            }

            // Método para cargar el fragment
            getSupportFragmentManager().beginTransaction().replace(R.id.content_fragment, fragment).commit();

            // Cargamos el fragment y cerramos el drawer
            drawerLayout.closeDrawers();

            return true;
        });

        selectedColor = R.color.primary_color;

        bottomMenu.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.item_tab_1){
                fragment = new HomeFragment();
                item.getIcon().setTint(selectedColor);
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.content_fragment, fragment).commit();

            return true;
        });
    }


    private void loadComponents(){
        drawerLayout = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolbar);
        menu = findViewById(R.id.nvMenu);
        bottomMenu = findViewById(R.id.bottomMenu);
    }

}