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
    public CheckBox chkAgree;
    public RadioGroup rGroup1;
    public RadioButton rdonomakeup, rdonatural, rdoglitter; //rdonomakeup은 nomakeup..다른 것도 마찬가지
    public Button btnOK;
    public ImageView imgLens; //설문조사 첫 번째 질문을 위한 선언

    public TextView text3;
    public RadioGroup rGroup2;
    public RadioButton rdono, rdomaybe, rdoyes;
    public Button btnOK2;
    public ImageView imgLens2; //설문조사 두 번째 질문을 위한 선언

    public TextView text4;
    public RadioGroup rGroup3;
    public RadioButton rdono2,rdoyes2;
    public Button btnOK3;
    public ImageView imgLens3; //설문조사 세 번째 질문을 위한 선언
    //선언끝



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_test,container,false);


        text1 = viewGroup.findViewById(R.id.Text1);
        chkAgree = viewGroup.findViewById(R.id.ChkAgree);

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

        text4 = viewGroup.findViewById(R.id.Text4);
        rGroup3 = viewGroup.findViewById(R.id.Rgroup3);
        rdono2 = viewGroup.findViewById(R.id.no2);
        rdoyes2 = viewGroup.findViewById(R.id.yes2);
        btnOK3 = viewGroup.findViewById(R.id.BtnOK3);
        imgLens3 = viewGroup.findViewById(R.id.ImgLens3);



        // 체크박스의 체크가 변경되면
        chkAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
                // 체크되면 모두 보이도록 설정
                if (chkAgree.isChecked() == true) {
                    text2.setVisibility(android.view.View.VISIBLE);
                    text3.setVisibility(android.view.View.VISIBLE);
                    text4.setVisibility(android.view.View.VISIBLE);
                    rGroup1.setVisibility(android.view.View.VISIBLE);
                    rGroup2.setVisibility(android.view.View.VISIBLE);
                    rGroup3.setVisibility(android.view.View.VISIBLE);
                    btnOK.setVisibility(android.view.View.VISIBLE);
                    btnOK2.setVisibility(android.view.View.VISIBLE);
                    btnOK3.setVisibility(android.view.View.VISIBLE);
                    imgLens.setVisibility(android.view.View.VISIBLE);
                    imgLens2.setVisibility(android.view.View.VISIBLE);
                    imgLens3.setVisibility(android.view.View.VISIBLE);


                }
                // 체크되지 않으면 안 보이게 설정
                else {
                    text2.setVisibility(android.view.View.INVISIBLE);
                    text3.setVisibility(android.view.View.INVISIBLE);
                    text4.setVisibility(android.view.View.INVISIBLE);
                    rGroup1.setVisibility(android.view.View.INVISIBLE);
                    rGroup2.setVisibility(android.view.View.INVISIBLE);
                    rGroup3.setVisibility(android.view.View.INVISIBLE);
                    btnOK.setVisibility(android.view.View.INVISIBLE);
                    btnOK2.setVisibility(android.view.View.INVISIBLE);
                    btnOK3.setVisibility(android.view.View.INVISIBLE);
                    imgLens.setVisibility(android.view.View.INVISIBLE);
                    imgLens2.setVisibility(android.view.View.INVISIBLE);
                    imgLens3.setVisibility(android.view.View.INVISIBLE);

                }
            }
        });

        //첫 번째 선택완료 버튼
        btnOK.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                switch (rGroup1.getCheckedRadioButtonId()) {
                    //노메이크업 radio버튼을 누르고 선택완료를 누르면
                    case R.id.nomakeup:
                         //nomakeup(투명렌즈) 이미지를 띄웁니다
                        imgLens.setImageResource(R.drawable.nomakeup);
                        break;

                    //내츄럴 radio버튼을 누르고 선택완료를 누르면
                    case R.id.natural:
                        //natural(자연스러운 그래픽의 렌즈) 이미지를 띄웁니다
                        imgLens.setImageResource(R.drawable.natural);

                        break;

                    //화려함 radio버튼을 누르고 선택완료를 누르면
                    case R.id.glitter:
                        //glitter(화려한 그래픽의 렌즈) 이미지를 띄웁니다
                        imgLens.setImageResource(R.drawable.glitter);

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


        //세 번째 선택완료 버튼
        btnOK3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                switch (rGroup3.getCheckedRadioButtonId()) {

                    //아니요 radio버튼을 누르고 선택완료를 누르면
                    case R.id.no2:
                        //no2(수고하셨습니다) 이미지를 띄웁니다
                        imgLens3.setImageResource(R.drawable.no2);


                        break;


                    //네 radio버튼을 누르고 선택완료를 누르면
                    case R.id.yes2:
                        //yes2(하단바 클릭해보세요) 이미지를 띄웁니다
                        imgLens3.setImageResource(R.drawable.yes2);

                        break;



                    // radio버튼중 아무것도 선택안하고 선택완료를 누른다면
                    default:
                        Toast.makeText(getActivity().getApplicationContext(), "올바른 방법으로 선택해주세요", Toast.LENGTH_SHORT)
                                .show();
                }
            }
        });

    return viewGroup;
    }

}

