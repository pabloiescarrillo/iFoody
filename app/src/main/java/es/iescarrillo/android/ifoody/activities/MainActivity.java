package es.iescarrillo.android.ifoody.activities;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import es.iescarrillo.android.ifoody.R;
import es.iescarrillo.android.ifoody.adapters.CategoryAdapter;
import es.iescarrillo.android.ifoody.models.Category;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private Toolbar toolbar;

    private CategoryAdapter adapter;
    private List<Category> categories;
    private RecyclerView rvList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        rvList = findViewById(R.id.rvList);
        categories = new ArrayList<>();

        for(int i=0; i<15; i++){
            Category category =  new Category();
            category.setTitle("Category " + i);
            category.setImage("@drawable/logo_rounded_app");
            categories.add(category);
        }

        adapter = new CategoryAdapter(getApplicationContext(), categories);
        rvList.setAdapter(adapter);
    }


    private void loadComponents(){
        drawerLayout = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolbar);
    }

}