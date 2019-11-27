package com.example.firstproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstproject.LeessonFollowIDActivity;
import com.example.firstproject.LessonActivity;
import com.example.firstproject.Model.LessonFollowID;
import com.example.firstproject.Model.LessonThroughWord;
import com.example.firstproject.R;
import com.example.firstproject.onClickView;
import com.example.firstproject.presenter.ViewPresenter;

import java.util.ArrayList;

public abstract class LessonThroughWordAdapter extends RecyclerView.Adapter<LessonThroughWordAdapter.ViewHolder>  implements onClickView{
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
        View view= LayoutInflater.from(context).inflate(R.layout.row_lesson,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvTitle.setText(position+1+". "+data.get(position).getTitle());
        holder.tvDes.setText(data.get(position).getDes());
        holder.imvRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               viewPresenter.navigate();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void navigate() {
        Intent intent=new Intent(context, LeessonFollowIDActivity.class);
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
