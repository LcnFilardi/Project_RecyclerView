package com.exemple.recyclerviewproject.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.exemple.recyclerviewproject.R;
import com.exemple.recyclerviewproject.activity.ClickListener;
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
        Adapter adaptador = new Adapter( listaFilmes );

        //Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter( adaptador );

        //Evento de click
        recyclerView.addOnItemTouchListener(
                new ClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new ClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Filme filme = listaFilmes.get(position);
                                Toast.makeText(
                                        getApplicationContext(),
                                        "Item selecionado: " + filme.getTituloFilme(),
                                        Toast.LENGTH_SHORT
                                ).show();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Filme filme = listaFilmes.get(position);
                                Toast.makeText(
                                        getApplicationContext(),
                                        "Click Longo: " + filme.getTituloFilme(),
                                        Toast.LENGTH_SHORT
                                ).show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );
    }

    public void criarFilmes(){
        Filme filme = new Filme("Deadpool", "Ação e Comédia", "2016");
        listaFilmes.add(filme);
        filme = new Filme("A culpa é das Estrelas", "Romance e Drama", "2022");
        listaFilmes.add(filme);
        filme = new Filme("A Hora da Sua Morte ", "Suspense", "2019");
        listaFilmes.add(filme);
        filme = new Filme("It - A Coisa", "Terror e Suspense", "2022");
        listaFilmes.add(filme);
        filme = new Filme(" À espera de um milagre", "Drama, Policial e Fantasia", "1999");
        listaFilmes.add(filme);
        filme = new Filme("A Barraca do Beijo", "Comédia romântica", "2018");
        listaFilmes.add(filme);
        filme = new Filme("Missão: Impossível – Acerto De Contas", "Ação", "2023");
        listaFilmes.add(filme);
        filme = new Filme("Matrix Resurrections", "Ação e Ficção científica", "2021");
        listaFilmes.add(filme);
        filme = new Filme("Avatar 2 - O Caminho da Água", "Aventura, Ação e Fantasia", "2022");
        listaFilmes.add(filme);

    }
}
