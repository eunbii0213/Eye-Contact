package com.example.listview;

import android.graphics.drawable.Drawable;

//작성한 이미지나 텍스트에 들어갈 데이터를 생성하는 모델 클래스
public class ListViewItem {
    private Drawable drawable;
    private String name;
    private String color;
    private String dias;
    private String desc;


    public ListViewItem(Drawable drawable, String name, String color, String dias, String desc) {
        this.drawable = drawable;
        this.name = name;
        this.color = color;
        this.dias = dias;
        this.desc = desc;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setDias(String dias) { this.dias = dias; }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    public Drawable getDrawable() {
        return drawable;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getDias() {
        return dias;
    }

    public String getDesc() {
        return desc;
    }

}
