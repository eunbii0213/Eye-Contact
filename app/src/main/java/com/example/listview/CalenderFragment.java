package com.example.listview;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CalenderFragment extends Fragment {
    ViewGroup viewGroup;
    public String fname = null;
    public String str = null;
    public CalendarView calendarView;
    public Button cha_Btn, del_Btn, save_Btn;
    public TextView diaryTextView, textView2;
    public EditText contextEditText;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_calender, container, false);calendarView = viewGroup.findViewById(R.id.calendarView);
        diaryTextView = viewGroup.findViewById(R.id.diaryTextView);
        save_Btn = viewGroup.findViewById(R.id.save_Btn);
        del_Btn = viewGroup.findViewById(R.id.del_Btn);
        cha_Btn = viewGroup.findViewById(R.id.cha_Btn);
        textView2 = viewGroup.findViewById(R.id.textView2);
        contextEditText = viewGroup.findViewById(R.id.contextEditText);
        final String userID = "userID";


        //calendarView를 이용한 날짜선택 listener
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                //setVisibility 를 사용해서 클릭한 날짜, 저장버튼 보이게 하기
                diaryTextView.setVisibility(View.VISIBLE);
                save_Btn.setVisibility(View.VISIBLE);
                contextEditText.setVisibility(View.VISIBLE);
                textView2.setVisibility(View.INVISIBLE);
                cha_Btn.setVisibility(View.INVISIBLE);
                del_Btn.setVisibility(View.INVISIBLE);
                //diarytextview에 몇년,몇월,며칠을 설정
                diaryTextView.setText(String.format("%d / %d / %d", year, month + 1, dayOfMonth));
                contextEditText.setText("");
                checkDay(year, month, dayOfMonth, userID);
            }
        });

        //저장을 클릭하면 저장버튼 숨기고 수정, 삭제버튼 보이게하기, 쓴 내용은 textview2에 저장
        //날짜는 saveDiary 파일로 저장
        save_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveDiary(fname);
                str = contextEditText.getText().toString();
                textView2.setText(str);
                save_Btn.setVisibility(View.INVISIBLE);
                cha_Btn.setVisibility(View.VISIBLE);
                del_Btn.setVisibility(View.VISIBLE);
                contextEditText.setVisibility(View.INVISIBLE);
                textView2.setVisibility(View.VISIBLE);

            }
        });

        return viewGroup;
    }

    //onSelectDayChange에서 호출한 checkDay함수
    public void checkDay(int cYear, int cMonth, int cDay, String userID) {
        fname = "" + userID + cYear + "-" + (cMonth + 1) + "" + "-" + cDay + ".txt";  //저장할 파일 이름설정
        FileInputStream fis = null;   //FileStream fis 변수

        try {
            fis = getActivity().openFileInput(fname); //파일을 스트림으로 읽기위해 openfileinput사용

            //fileData 배열 선언 fileinputstream,fileoutputstream이 byte단위기때문에 배열도 byte
            byte[] fileData = new byte[fis.available()];
            fis.read(fileData); //읽기
            fis.close(); //닫기

            str = new String(fileData);

            //저장버튼 숨기고 수정,삭제 버튼을 보이게 설정
            //저장한 내용을 보이게 함
            contextEditText.setVisibility(View.INVISIBLE);
            textView2.setVisibility(View.VISIBLE);
            textView2.setText(str);

            save_Btn.setVisibility(View.INVISIBLE);
            cha_Btn.setVisibility(View.VISIBLE);
            del_Btn.setVisibility(View.VISIBLE);

            //수정 버튼을 누르면
            cha_Btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //텍스트 수정가능하게 함, 저장버튼 보이고 수정, 삭제 버튼을 숨김
                    //텍스트 수정한 내용은 textview2에 넣음
                    contextEditText.setVisibility(View.VISIBLE);
                    textView2.setVisibility(View.INVISIBLE);
                    contextEditText.setText(str);

                    save_Btn.setVisibility(View.VISIBLE);
                    cha_Btn.setVisibility(View.INVISIBLE);
                    del_Btn.setVisibility(View.INVISIBLE);
                    textView2.setText(contextEditText.getText());
                }

            });

            //삭제 버튼을 누르면
            del_Btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //저장버튼 보이고 수정, 삭제버튼 숨김
                    //텍스트 다시 입력 할 수 있게 함
                    textView2.setVisibility(View.INVISIBLE);
                    contextEditText.setText("");
                    contextEditText.setVisibility(View.VISIBLE);
                    save_Btn.setVisibility(View.VISIBLE);
                    cha_Btn.setVisibility(View.INVISIBLE);
                    del_Btn.setVisibility(View.INVISIBLE);
                    removeDiary(fname);
                }
            });

            //사용자가 저장한 내용이 없다면
            if (textView2.getText() == null) {

                //수정, 삭제버튼 숨기고 저장버튼을 보이게 함
                //입력 할 수 있게 함
                textView2.setVisibility(View.INVISIBLE);
                diaryTextView.setVisibility(View.VISIBLE);
                save_Btn.setVisibility(View.VISIBLE);
                cha_Btn.setVisibility(View.INVISIBLE);
                del_Btn.setVisibility(View.INVISIBLE);
                contextEditText.setVisibility(View.VISIBLE);
            }

         //예외처리
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //삭제하는 함수
    @SuppressLint("WrongConstant")
    public void removeDiary(String readDay) {
        FileOutputStream fos = null; //데이터를 출력하기 위해 fileoutputstream 사용

        try {
            fos = getActivity().openFileOutput(readDay, getActivity().MODE_NO_LOCALIZED_COLLATORS);
            String content = "";// 저장한거 비움
            fos.write((content).getBytes());//바이트 배열에 결과를 저장
            fos.close(); //파일 닫기

            //예외처리
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //저장하는 함수
    @SuppressLint("WrongConstant")
    public void saveDiary(String readDay) {
        FileOutputStream fos = null;

        try {
            fos = getActivity().openFileOutput(readDay, getActivity().MODE_NO_LOCALIZED_COLLATORS);
            String content = contextEditText.getText().toString(); //내용 저장
            fos.write((content).getBytes()); //바이트 배열에 결과를 저장
            fos.close(); //파일 닫음
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
