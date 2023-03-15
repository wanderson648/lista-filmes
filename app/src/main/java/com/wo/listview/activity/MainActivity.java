package com.wo.listview.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wo.listview.R;
import com.wo.listview.adapter.Adapter;
import com.wo.listview.adapter.RecyclerItemClickListener;
import com.wo.listview.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

   private RecyclerView recyclerView;

   private List<Filme> listaFilmes = new ArrayList<>();

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      recyclerView = findViewById(R.id.rv_main);

      this.criarFilmes();


      Adapter adapter = new Adapter(listaFilmes);
      RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
      recyclerView.setHasFixedSize(true);
      recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
      recyclerView.setLayoutManager(layoutManager);
      recyclerView.setAdapter(adapter);


      recyclerView.addOnItemTouchListener(
              new RecyclerItemClickListener(
                      getApplicationContext(),
                      recyclerView,
                      new RecyclerItemClickListener.OnItemClickListener() {
                         @Override
                         public void onItemClick(View view, int position) {
                            Filme filme = listaFilmes.get(position);
                            Toast.makeText(
                                    getApplicationContext(),
                                    "Item presssiondo: " + filme.getTitulo(),
                                    Toast.LENGTH_LONG
                            ).show();
                         }

                         @Override
                         public void onLongItemClick(View view, int position) {
                            Filme filme = listaFilmes.get(position);
                            Toast.makeText(
                                    getApplicationContext(),
                                    "Click longo: " + filme.getTitulo(),
                                    Toast.LENGTH_LONG
                            ).show();
                         }

                         @Override
                         public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                         }
                      }
              )
      );

   }

   public void criarFilmes() {

      Filme filme = new Filme("Homem aranha - De volta para casa", "Aventura", "2020");
      listaFilmes.add(filme);

      filme = new Filme("Mulher maravilha", "Fantasia", "2017");
      listaFilmes.add(filme);

      filme = new Filme("Liga da justiça", "Ficção", "2017");
      listaFilmes.add(filme);

      filme = new Filme("Capitão América - Guerra Civil", "Aventura/Ficção", "2016");
      listaFilmes.add(filme);

      filme = new Filme("Pica Pau: O Filme", "Comédia/Animação", "2017");
      listaFilmes.add(filme);

      filme = new Filme("A Múmia", "Terror", "2017");
      listaFilmes.add(filme);

      filme = new Filme("A Bela e a Fera", "Romance", "2017");
      listaFilmes.add(filme);

      filme = new Filme("Meu malvado favorito 3", "Comédia", "2017");
      listaFilmes.add(filme);

      filme = new Filme("Carros 3", "Comédia", "2017");
      listaFilmes.add(filme);

   }

}