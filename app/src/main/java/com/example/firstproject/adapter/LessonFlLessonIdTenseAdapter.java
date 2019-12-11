package com.example.firstproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstproject.model.LessonFlLessonIdTense;
import com.example.firstproject.R;
import com.example.firstproject.databinding.RowLessonFllessonidtenseBinding;
import com.example.firstproject.onClickView;
import com.example.firstproject.presenter.ViewPresenter;

import java.util.ArrayList;

public class LessonFlLessonIdTenseAdapter extends RecyclerView.Adapter<LessonFlLessonIdTenseAdapter.ViewHolder> implements onClickView {
    Context context;
    ArrayList<LessonFlLessonIdTense> list;
    ViewPresenter viewPresenter;

    public LessonFlLessonIdTenseAdapter(Context context, ArrayList<LessonFlLessonIdTense> list) {
        this.context = context;
        this.list = list;
        viewPresenter=new ViewPresenter(this);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RowLessonFllessonidtenseBinding rowLessonFllessonidBinding= DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.row_lesson_fllessonidtense,parent,false);
        return new ViewHolder(rowLessonFllessonidBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        holder.tvTitle.setText(position+1+". "+list.get(position).getTitle());
//        holder.tvsubTitle1.setText("+ "+list.get(position).subtitle1);
        LessonFlLessonIdTense lessonFlLessonIdTense=list.get(position);
        holder.binding.setLessonfllessonidtense(lessonFlLessonIdTense);
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

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RowLessonFllessonidtenseBinding binding;
//        TextView tvTitle,tvsubTitle1;
        public ViewHolder(@NonNull RowLessonFllessonidtenseBinding itemView) {
            super(itemView.getRoot());
            binding=itemView;
        }
    }
}