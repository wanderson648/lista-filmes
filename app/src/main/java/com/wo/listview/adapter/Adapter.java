package com.wo.listview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wo.listview.R;
import com.wo.listview.model.Filme;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

   private final List<Filme> listaFilmes;

   public Adapter(List<Filme> lista) {
      this.listaFilmes = lista;
   }

   @NonNull
   @Override
   public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

      View itemLista = LayoutInflater.from(parent.getContext())
              .inflate(R.layout.rv_list, parent, false);
      return new MyViewHolder(itemLista);
   }

   @Override
   public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

      Filme filme = listaFilmes.get(position);

      holder.titulo.setText(filme.getTitulo());
      holder.genero.setText(filme.getGenero());
      holder.ano.setText(filme.getAno());
   }

   @Override
   public int getItemCount() {
      return listaFilmes.size();
   }

   public static class MyViewHolder extends RecyclerView.ViewHolder {

      TextView titulo;
      TextView genero;
      TextView ano;

      public MyViewHolder(View itemView) {
         super(itemView);

         titulo = itemView.findViewById(R.id.txt_titulo);
         genero = itemView.findViewById(R.id.txt_genero);
         ano = itemView.findViewById(R.id.txt_ano);
      }
   }




}
