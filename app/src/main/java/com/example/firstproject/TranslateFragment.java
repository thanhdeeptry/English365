package com.example.firstproject;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.firstproject.presenter.ViewPresenter;


public class TranslateFragment extends Fragment implements onClickView {
Button btnEngtovn,btnVntoeng;
EditText edtInput;
View vRoot;
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
        btnVntoeng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.VntoEng();
            }
        });
        return vRoot;
    }
    public void init(){
        presenter=new ViewPresenter(this);
        edtInput=vRoot.findViewById(R.id.edtInput);
        btnEngtovn=vRoot.findViewById(R.id.btnEngtovn);
        btnVntoeng=vRoot.findViewById(R.id.btnVntoeng);
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
        Toast.makeText(getContext(),"Translate English to Vietnamese",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void vntoenng() {
        Toast.makeText(getContext(),"Translate from Vietnamese to English",Toast.LENGTH_SHORT).show();
    }
}
