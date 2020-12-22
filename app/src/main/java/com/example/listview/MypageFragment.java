package com.example.listview;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MypageFragment extends Fragment {
    ViewGroup viewGroup;


    public EditText mMemoEdit = null;
    public TextFileManager mTextFileManager = null;
    public Button load_btn, save_btn, delete_btn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_mypage, container, false);

        Context ctx = getActivity();
        if (ctx == null) {
            ctx = getContext();
        } //ctx가 null이면 error발생해서 이 코드를 추가함

        mTextFileManager = new TextFileManager(ctx);

        mMemoEdit = viewGroup.findViewById(R.id.memo_edit);
        load_btn = viewGroup.findViewById(R.id.load_btn);
        save_btn = viewGroup.findViewById(R.id.save_btn);
        delete_btn = viewGroup.findViewById(R.id.delete_btn);



        load_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //1. 파일에 저장된 메모 텍스트 파일 불러오기
                String memoData = mTextFileManager.load();

                mMemoEdit.setText(memoData);

                Toast.makeText(getActivity(), "불러오기 완료", Toast.LENGTH_LONG).show();
            }
        });


        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {

                    //2. 에디트텍스트에 입력된 메모를 텍스트 파일로 저장하기

                    case R.id.save_btn: {
                        String memoData = mMemoEdit.getText().toString();
                        mTextFileManager.save(memoData);
                        mMemoEdit.setText("");

                        Toast.makeText(getActivity(), "저장 완료", Toast.LENGTH_LONG).show();
                        break;
                    }
                }
            }

        });





        delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {

                    //3. 저장된 메모 파일 삭제하기

                    case R.id.delete_btn: {
                        mTextFileManager.delete();
                        mMemoEdit.setText("");

                        Toast.makeText(getActivity(), "삭제 완료", Toast.LENGTH_LONG).show();
                    }
                }
            }


        });
        return viewGroup;
    }
}