package com.example.firstproject.adapter;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstproject.Model.Word;
import com.example.firstproject.R;
import com.example.firstproject.onClickView;
import com.example.firstproject.presenter.ViewPresenter;

import java.util.ArrayList;
import java.util.List;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.ViewHolder> implements onClickView {
    private ArrayList<Word> wordList;

    private Context context;
    ViewPresenter viewPresenter;

    public WordAdapter(ArrayList<Word> wordList, Context context) {
        this.wordList = wordList;
        this.context = context;
        viewPresenter=new ViewPresenter(this);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.word, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.tvWord.setText(wordList.get(position).word);

        holder.tvWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPresenter.navigateflid(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return wordList.size();
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
        final Word word = wordList.get(pos);
        AlertDialog.Builder builder
                = new AlertDialog.Builder(context);


        builder.setTitle(word.word);
        builder.setMessage(Html.fromHtml(word.html));

        builder.show();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvWord;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvWord = itemView.findViewById(R.id.tvText);

        }
    }
}
