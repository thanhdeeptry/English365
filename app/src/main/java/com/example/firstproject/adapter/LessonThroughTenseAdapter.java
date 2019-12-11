package com.example.firstproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstproject.LessonFlIdTenseActivity;
import com.example.firstproject.databinding.RowLessonThrougtenseBinding;
import com.example.firstproject.model.LessonThroughTense;
import com.example.firstproject.R;
import com.example.firstproject.onClickView;
import com.example.firstproject.presenter.ViewPresenter;

import java.util.ArrayList;

public  class LessonThroughTenseAdapter extends RecyclerView.Adapter<LessonThroughTenseAdapter.ViewHolder> implements onClickView {
    Context context;
    ArrayList<LessonThroughTense> data;
    ViewPresenter viewPresenter;
    public LessonThroughTenseAdapter(Context context, ArrayList<LessonThroughTense> data) {
        this.context = context;
        this.data = data;
        viewPresenter=new ViewPresenter( this);
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RowLessonThrougtenseBinding rowLessonThrougtenseBinding= DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.row_lesson_througtense,parent,false);
        return new ViewHolder(rowLessonThrougtenseBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        LessonThroughTense lessonThroughTense=data.get(position);
        holder.binding.setLessonthroughtense(lessonThroughTense);
        holder.binding.imvRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPresenter.navigateflid(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
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
        bundle.putString("name",data.get(pos).getTitle());
        bundle.putString("idtense",data.get(pos).getId()+"");
        Intent intent=new Intent(context, LessonFlIdTenseActivity.class);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        RowLessonThrougtenseBinding binding;
        public ViewHolder(@NonNull RowLessonThrougtenseBinding itemView) {
            super(itemView.getRoot());
            binding=itemView;

        }
    }
}
