package com.example.firstproject.presenter;

import com.example.firstproject.onClickView;

public class ViewPresenter {
    private onClickView onClickView;

    public ViewPresenter(com.example.firstproject.onClickView onClickView) {
        this.onClickView = onClickView;
    }


    public void grammar(){

        onClickView.grammar();

    }
    public void translate(){
        onClickView.translate();
    }
    public void about(){
        onClickView.about();
    }
    public void exit(){
        onClickView.exit();
    }

    public void navigate() {
        onClickView.navigate();
    }
    public void Engtovn(){
        onClickView.engtovn();
    }
    public void VntoEng(){
        onClickView.vntoenng();
    }
    public void navigateflid(int pos){
        onClickView.navigateflid(pos);
    }

}
