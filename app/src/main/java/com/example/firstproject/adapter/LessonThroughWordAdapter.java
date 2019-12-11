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
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstproject.LeessonFollowIDWordActivity;
import com.example.firstproject.databinding.RowLessonFlidwordBinding;
import com.example.firstproject.databinding.RowLessonThroughwordBinding;
import com.example.firstproject.model.LessonThroughWord;
import com.example.firstproject.R;
import com.example.firstproject.onClickView;
import com.example.firstproject.presenter.ViewPresenter;

import java.util.ArrayList;

public class LessonThroughWordAdapter extends RecyclerView.Adapter<LessonThroughWordAdapter.ViewHolder>  implements onClickView{
    Context context;
    ArrayList<LessonThroughWord> data;
    public ViewPresenter viewPresenter;
    public LessonThroughWordAdapter(Context context, ArrayList<LessonThroughWord> data) {
        this.context = context;
        this.data = data;
        viewPresenter=new ViewPresenter((onClickView) this);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RowLessonThroughwordBinding rowLessonThroughwordBinding= DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.row_lesson_throughword,parent,false);
        return new ViewHolder(rowLessonThroughwordBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
       LessonThroughWord lessonThroughWord=data.get(position);
       holder.binding.setLessonthroughword(lessonThroughWord);
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
        bundle.putString("idword",data.get(pos).getId()+"");
        Intent intent=new Intent(context, LeessonFollowIDWordActivity.class);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RowLessonThroughwordBinding binding;
        public ViewHolder(RowLessonThroughwordBinding itemview) {
            super(itemview.getRoot());
            binding=itemview;
        }

    }
}
