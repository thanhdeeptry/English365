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

import com.example.firstproject.LessonActivity;
import com.example.firstproject.Model.LessonFollowID;
import com.example.firstproject.R;

import java.util.ArrayList;

public class LessonFollowIDAdapter extends RecyclerView.Adapter<LessonFollowIDAdapter.ViewHolder> {
    Context context;
    ArrayList<LessonFollowID> list;

    public LessonFollowIDAdapter(Context context, ArrayList<LessonFollowID> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.row_lesson,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvTitle.setText(list.get(position).getTitle());
        holder.tvDes.setText(list.get(position).getDes());
        holder.imvRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, LessonActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
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
