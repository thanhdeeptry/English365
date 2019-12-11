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

import com.example.firstproject.LeessonFollowIDWordActivity;
import com.example.firstproject.LessonFlLessonIdWordActivity;
import com.example.firstproject.Model.LessonFlIdWord;
import com.example.firstproject.R;
import com.example.firstproject.onClickView;
import com.example.firstproject.presenter.ViewPresenter;

import java.util.ArrayList;

public class LessionFlIdWordAdapter extends RecyclerView.Adapter<LessionFlIdWordAdapter.ViewHolder> implements onClickView {
    Context context;
    ArrayList<LessonFlIdWord> list;
    ViewPresenter viewPresenter;

    public LessionFlIdWordAdapter(Context context, ArrayList<LessonFlIdWord> list) {
        this.context = context;
        this.list = list;
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
        holder.tvTitle.setText(list.get(position).getName());
        holder.tvDes.setText(list.get(position).getDes());
        holder.imvRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPresenter.navigateflid(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
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
        bundle.putString("name",list.get(pos).getName());
        bundle.putString("id",list.get(pos).getId()+"");
        Intent intent=new Intent(context, LessonFlLessonIdWordActivity.class);
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
