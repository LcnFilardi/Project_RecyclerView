package com.exemple.recyclerviewproject.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.exemple.recyclerviewproject.R;
import com.exemple.recyclerviewproject.activity.adapter.Adapter;
import com.exemple.recyclerviewproject.activity.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Filme> listaFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        //Listagem de filmes
        this.criarFilmes();

        //Configurar adapter
        Adapter adaptador = new Adapter(  );

        //Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter( adaptador );
    }

    public void criarFilmes(){
        Filme filme = new Filme("Filme 1", "comédia", "2022");
        listaFilmes.add(filme);
        filme = new Filme("Filme 2", "romance", "2022");
        listaFilmes.add(filme);
        filme = new Filme("Filme 3", "suspense", "2022");
        listaFilmes.add(filme);
        filme = new Filme("Filme 4", "terror", "2022");
        listaFilmes.add(filme);
        filme = new Filme("Filme 5", "drama", "2022");
        listaFilmes.add(filme);
        filme = new Filme("Filme 6", "comedia romatica", "2022");
        listaFilmes.add(filme);
        filme = new Filme("Filme 7", "anime", "2022");
        listaFilmes.add(filme);
        filme = new Filme("Filme 8", "acao", "2022");
        listaFilmes.add(filme);
        filme = new Filme("Filme 9", "ficcao cientifica", "2022");
        listaFilmes.add(filme);
        filme = new Filme("Filme 10", "aventura", "2022");
        listaFilmes.add(filme);

    }
}
