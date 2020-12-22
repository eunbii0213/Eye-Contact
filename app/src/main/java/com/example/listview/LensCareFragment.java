package com.example.listview;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LensCareFragment extends Fragment {
    ViewGroup viewGroup;
    @SuppressLint("UseCompatLoadingForDrawables")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //lens care fragment
        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_lens,container,false);

        //listview1, editTextFilter 적용
        final ListView listView = viewGroup.findViewById(R.id.listview1);
        EditText editText = viewGroup.findViewById(R.id.editTextFilter);

        MainAdapter mainAdapter = new MainAdapter();


        //렌즈 용품 추가
        mainAdapter.addItem(getResources().getDrawable(R.drawable.care_1), "바슈롬 리뉴 후레쉬", "500ml ","다목적용액","1p, 5500원");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.care_2), "바슈롬 바이오 트루 렌즈 ", "500ml ","다목적용액","1p, 7500원");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.care_3), "옵티프리 익스프레스 ", "500ml ","다목적용액","1p, 4500원");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.care_4), "옵티프리 퓨어 모이스트", "300ml ","다목적용액","1p, 6300원");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.care_5), "리뉴 센서티브", "355ml ","다목적용액","1p, 6000원");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.care_6), "옵티프리 리플레니시 리무브 프로틴 데일리", "300ml ","다목적용액","1p, 13900원");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.care_7), "자일렉 웨이브 초음파 세척기", "ZL_216UC ","렌즈 세척기","1p, 39900원");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.care_8), "Kaida 콘택트 렌즈 휴대용 클리너", "HL_988 ","렌즈 세척기","1p, 30100원");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.care_9), "셀루미 초음파 렌즈세척기", "SEL-ULC350A","렌즈 세척기","1p, 22900원");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.care_10), "렌즈소녀 당겨라선인장 세척기", "","렌즈 세척기","1p, 7900원");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.care_11), "프렌즈드롭 렌즈습윤제 ", "13ml ","렌즈 습윤제","2p, 3020원");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.care_12), "드림아이 렌즈 습윤액 ", "13ml ","렌즈 습윤제","1p, 6970원");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.care_13), " 메디렌즈 보습액", "15ml ","렌즈 습윤제","6p, 12900원");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.care_14), "로토 시큐브", "17ml ","인공 눈물","1p, 9000원");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.care_151617), "프렌즈 아이드롭 쿨", "17ml ","인공눈물","1p, 5000원");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.care_151617), "프렌즈 아이드롭 쿨하이", "17ml ","인공눈물","1p, 5000원");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.care_151617), "프렌즈 아이드롭 쿨", "17ml ","인공눈물","1p, 5000원");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.care_18), "큐알론", "0.9ml ","인공 눈물 / 일회용","30p, 7000원");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.care_19), "드롭드림아이", "13ml ","인공 눈물","1p, 5000원");


        listView.setAdapter(mainAdapter);

        //TextWatcher (그대로 입력되는 텍스트 감지하는 것) 이용
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable edit) {
                String filterText = edit.toString();
                ((MainAdapter)listView.getAdapter()).getFilter().filter(filterText) ;
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
        return viewGroup;
    }
}


