package com.example.firstproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.firstproject.model.Word;
import com.example.firstproject.adapter.WordAdapter;
import com.example.firstproject.database.DataBaseForDict;
import com.example.firstproject.presenter.ViewPresenter;

import java.util.ArrayList;


public class TranslateFragment extends Fragment implements onClickView {
Button btnEngtovn;
EditText edtInput;
View vRoot;
RecyclerView lvList;


    private DataBaseForDict dataBaseHelper;

    private WordAdapter wordAdapter;

    private LinearLayoutManager linearLayoutManager;

    ArrayList<Word> wordList=new ArrayList<>();

public ViewPresenter presenter;
    public TranslateFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        vRoot=inflater.inflate(R.layout.fragment_translate,container,false);
        init();
        btnEngtovn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.Engtovn();
            }
        });
        return vRoot;
    }
    public void init(){

        presenter=new ViewPresenter(this);
        edtInput=vRoot.findViewById(R.id.edtInput);
        btnEngtovn=vRoot.findViewById(R.id.btnEngtovn);
        dataBaseHelper = new DataBaseForDict(getContext());
        dataBaseHelper.createDataBase();

        lvList=vRoot.findViewById(R.id.lvList);
        wordAdapter = new WordAdapter(wordList, getContext());
        linearLayoutManager = new LinearLayoutManager(getContext());

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
        String word = edtInput.getText().toString().trim();

        // kiểm tra nếu người dùng chưa nhập gì thì dừng lại và thông báo lỗi
        if (word.isEmpty()) {
            edtInput.setError("Vui lòng nhập dữ liệu !!!");
            return;
            // nếu chữ ko empty thì tiếp tục tìm kiếm và hiển thị danh sách kết quả lên list nếu có
        } else {

            ArrayList<Word> wordList = dataBaseHelper.searchWord(word);
            wordAdapter=new WordAdapter(wordList,getContext());
            lvList.setAdapter(wordAdapter);
            lvList.setLayoutManager(linearLayoutManager);
        }



    }

    @Override
    public void vntoenng() {
    }

    @Override
    public void navigateflid(int pos) {

    }


}
