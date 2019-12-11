package com.example.firstproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstproject.LessonFlLessonIdTenseActivity;
import com.example.firstproject.LessonFlLessonIdWordActivity;
import com.example.firstproject.Model.LessionFlIdTense;
import com.example.firstproject.R;
import com.example.firstproject.onClickView;
import com.example.firstproject.presenter.ViewPresenter;

import java.util.ArrayList;

public  class LessonFlIdTenseAdapter extends RecyclerView.Adapter<LessonFlIdTenseAdapter.ViewHolder> implements onClickView {
    Context context;
    ArrayList<LessionFlIdTense> idTenses;
    ViewPresenter viewPresenter;

    public LessonFlIdTenseAdapter(Context context, ArrayList<LessionFlIdTense> idTenses) {
        this.context = context;
        this.idTenses = idTenses;
        viewPresenter=new ViewPresenter(this);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.row_lesson,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.tvTitle.setText(idTenses.get(position).getName());
        holder.tvDes.setText(idTenses.get(position).getDes());
        holder.imvRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPresenter.navigateflid(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return idTenses.size();
    }

    @Override
    public void navigate() {
  }

    @Override
    public void grammar() {

    }

    @Override
    public void translate() {

    }

    @Override
    public void about() {

    }

    @Override
    public void exit() {

    }

    @Override
    public void engtovn() {

    }

    @Override
    public void vntoenng() {

    }

    @Override
    public void navigateflid(int pos) {
        Bundle bundle=new Bundle();
        bundle.putString("id",idTenses.get(pos).getId()+"");
        bundle.putString("name",idTenses.get(pos).getName()+"");
        Intent intent=new Intent(context, LessonFlLessonIdTenseActivity.class);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        TextView tvDes;
        ImageView imvRight;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle=itemView.findViewById(R.id.tvTitle);
            tvDes=itemView.findViewById(R.id.tvDes);
            imvRight=itemView.findViewById(R.id.imvRight);
        }
    }
}
