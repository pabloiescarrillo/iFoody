package es.iescarrillo.android.ifoody.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import es.iescarrillo.android.ifoody.R;
import es.iescarrillo.android.ifoody.adapters.CategoryAdapter;
import es.iescarrillo.android.ifoody.models.Category;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private CategoryAdapter adapter;
    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Obtengo el recyclerView de la vista
        recyclerView = view.findViewById(R.id.rv_categories);

        // Inicializamos la lista y el adapter
        List<Category> categories = new ArrayList<>();
        categories.add(new Category("Burger", R.drawable.burger));
        categories.add(new Category("Donut", R.drawable.donut));
        categories.add(new Category("Pizza", R.drawable.pizza));
        categories.add(new Category("Hot dog", R.drawable.hotdog));
        categories.add(new Category("Sandwich", R.drawable.sandwich));
        categories.add(new Category("Fresh", R.drawable.ice_cream));

        adapter = new CategoryAdapter(getContext(), categories);
        recyclerView.setAdapter(adapter);

        // Creamos la variable de tipo LayoutManager
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);

        // Método en el que le vamos a pasar una variable de tipo LayoutManager que es el que me va a dejar
        // indicar que tiene que mostrarse en horizontal
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }

}