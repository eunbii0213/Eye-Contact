package com.example.listview;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class TestFragment extends Fragment {

    ViewGroup viewGroup;

    public TextView text1, text2;
    public TextView questionOneText;
    public RadioGroup rGroup1;
    public RadioButton rdonomakeup, rdonatural, rdoglitter; //rdonomakeup은 nomakeup..다른 것도 마찬가지
    public Button btnOK;
    public ImageView imgLens; //설문조사 첫 번째 질문을 위한 선언

    public TextView text3;
    public RadioGroup rGroup2;
    public RadioButton rdono, rdomaybe, rdoyes;
    public Button btnOK2;
    public ImageView imgLens2; //설문조사 두 번째 질문을 위한 선언

    public TextView noMakeUpText;
    public TextView naturalText;
    public TextView glitterText;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_test, container, false);

        text2 = viewGroup.findViewById(R.id.Text2);
        rGroup1 = viewGroup.findViewById(R.id.Rgroup1);
        rdonomakeup = viewGroup.findViewById(R.id.nomakeup);
        rdonatural = viewGroup.findViewById(R.id.natural);
        rdoglitter = viewGroup.findViewById(R.id.glitter);
        btnOK = viewGroup.findViewById(R.id.BtnOK);
        imgLens = viewGroup.findViewById(R.id.ImgLens);


        text3 = viewGroup.findViewById(R.id.Text3);
        rGroup2 = viewGroup.findViewById(R.id.Rgroup2);
        rdono = viewGroup.findViewById(R.id.no);
        rdomaybe = viewGroup.findViewById(R.id.maybe);
        rdoyes = viewGroup.findViewById(R.id.yes);
        btnOK2 = viewGroup.findViewById(R.id.BtnOK2);
        imgLens2 = viewGroup.findViewById(R.id.ImgLens2);

        questionOneText = viewGroup.findViewById(R.id.questionOneText);


        //첫 번째 선택완료 버튼
        btnOK.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                switch (rGroup1.getCheckedRadioButtonId()) {
                    //노메이크업 radio버튼을 누르고 선택완료를 누르면
                    case R.id.nomakeup:
                        //nomakeup(투명렌즈) 이미지, 투명렌즈 TOP3 목록을 띄웁니다
                        imgLens.setImageResource(R.drawable.nomakeup);
                        questionOneText.setText("투명렌즈 TOP3 추천\n[알콘] 데일리스 토탈원 워터렌즈\n[알콘] 에어옵틱스 나이트 앤 데이 아쿠아\n[알콘] 오아시스 원데이");
                       // questionOneText.setVisibility(View.VISIBLE);
                        break;

                    //내츄럴 radio버튼을 누르고 선택완료를 누르면
                    case R.id.natural:
                        //natural(자연스러운 그래픽의 렌즈) 이미지를 띄웁니다
                        imgLens.setImageResource(R.drawable.natural);
                        questionOneText.setText("컬러렌즈 TOP3 추천\n[오렌즈] 비비링 원데이\n[오렌즈] 스칸디\n[오렌즈] 스페니쉬");
                        //questionOneText.setVisibility(View.VISIBLE);
                        break;

                    //화려함 radio버튼을 누르고 선택완료를 누르면
                    case R.id.glitter:
                        //glitter(화려한 그래픽의 렌즈) 이미지를 띄웁니다
                        imgLens.setImageResource(R.drawable.glitter);
                        questionOneText.setText("컬러렌즈 TOP3 추천\n[오렌즈] 시크리스 3콘\n[오렌즈] 오션\n[오렌즈] 크리스탈");
                        //questionOneText.setVisibility(View.VISIBLE);
                        break;

                    // radio버튼중 아무것도 선택안하고 선택완료를 누른다면
                    default:
                        Toast.makeText(getActivity().getApplicationContext(), "올바른 방법으로 선택해주세요", Toast.LENGTH_SHORT)
                                .show();
                }
            }
        });


        //두 번째 선택완료 버튼
        btnOK2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                switch (rGroup2.getCheckedRadioButtonId()) {
                    //그렇지않다 radio버튼을 누르고 선택완료를 누르면
                    case R.id.no:

                        //no(hema렌즈) 이미지를 띄웁니다
                        imgLens2.setImageResource(R.drawable.no);
                        break;

                    //보통 radio버튼을 누르고 선택완료를 누르면
                    case R.id.maybe:

                        //maybe(silicon-hydrogel렌즈) 이미지를 띄웁니다
                        imgLens2.setImageResource(R.drawable.maybe);
                        break;

                    //그렇다 radio버튼을 누르고 선택완료를 누르면
                    case R.id.yes:
                        //yes(pc렌즈) 이미지를 띄웁니다
                        imgLens2.setImageResource(R.drawable.yes);

                        break;

                    default:
                        Toast.makeText(getActivity().getApplicationContext(), "올바른 방법으로 선택해주세요", Toast.LENGTH_SHORT)
                                .show();
                }
            }
        });

        return viewGroup;
    }

}

