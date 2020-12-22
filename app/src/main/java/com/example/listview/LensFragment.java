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

public class LensFragment extends Fragment {
    ViewGroup viewGroup;
    @SuppressLint("UseCompatLoadingForDrawables")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //lens fragment
        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_lens,container,false);

        //listview1, editTextFilter 적용
        final ListView listView = viewGroup.findViewById(R.id.listview1);
        EditText editText = viewGroup.findViewById(R.id.editTextFilter);

        MainAdapter mainAdapter = new MainAdapter();



        //리스트뷰에 렌즈 추가
        mainAdapter.addItem(getResources().getDrawable(R.drawable.me_1), "벨벳 팝", "그레이","DIA 14.0 / GRA 13.6","1달(1p), 10000원, 병, 렌즈미");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.me_2), "알로하 블룸", "그레이", "DIA 14.5 / GRA 13.8 ", "1달(2p), 10000원, 팩, 렌즈미");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.me_9), "베이글 3칼라", "그레이","DIA 15.0 / GRA 14.5","3달(1p), 15000원, 병, 렌즈미");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.me_17), "클로 세븐 컬러", "그린","DIA 14.3 / GRA 13.3","1달(2p), 20000원, 팩, 렌즈미");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.me_18), "칵테일 블루 하와이", "블루", "DIA 14.1 / GRA 13.7", "1달(2p), 20000원, 팩, 렌즈미");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.me_19), "슈가펄 베리티", "핑크", "DIA 14.2 / GRA 13.4", "1달(2p), 10000원, 팩, 렌즈미");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.town_1), "블라쎄 크리스틴", "브라운","DIA 14.2 / GRA 13.2","1달(2p), 25000원, 팩, 렌즈타운");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.town_2), "라일리 멜로우 먼슬리", "브라운","DIA 14.3 / GRA 13.3","1달(2p), 20000원, 팩, 렌즈타운");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.town_3), "라일리 멜로우 먼슬리", "핑크","DIA 14.3 / GRA 13.3","1달(2p), 20000원, 팩, 렌즈타운");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.town_4), "라일리 멜로우 먼슬리", "그레이","DIA 14.3 / GRA 13.3","1달(2p), 20000원, 팩, 렌즈타운");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.town_5), "팬시아", "실버그레이","DIA 14.0 / GRA 13.6","1년(1p), 80000원, 병, 렌즈타운");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.town_6), "유니쳐로라", "그레이","DIA 14.3 / GRA 13.9","1달(1p), 25000원, 팩, 렌즈타운");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.town_7), "유니쳐로라", "브라운","DIA 14.3 / GRA 13.9","1달(1p), 25000원, 팩, 렌즈타운");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.me_3), "알로하 블룸", "브라운", "DIA 14.5 / GRA 13.8", "1달(2p), 10000원, 팩, 렌즈미");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.me_4), "악마 원 데이 리얼핏 3칼라", "그레이", "DIA 14.2 / GRA 13.5", "원 데이(30p), 45000원, 팩, 렌즈미");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.me_5), "악마 원 데이 리얼핏 3칼라", "브라운","DIA 14.2 / GRA 13.5","원 데이(30p), 45000원, 팩, 렌즈미");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.me_6), "슬크앰플 잭팟", "그레이", "DIA 14.0 / GRA 13.2", "1달(1p), 15000원, 병, 렌즈미");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.me_7), "칵테일 문라잇", "그레이", "DIA 14.2 / GRA 13.3", "1달(2p), 25000원, 팩, 렌즈미");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.me_8), "칵테일 문라잇", "브라운", "DIA 14.2 / GRA 13.3", "1달(2p), 25000원, 팩, 렌즈미");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.me_10), "베이글 3칼라", "브라운", "DIA 15.0 / GRA 14.5", "3달(1p), 15000원, 병, 렌즈미");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.me_11), "키스앤킬15", "브라운", "DIA 14.0 / GRA 13.4", "5달(1p), 50000원, 병, 렌즈미");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.me_12), "시크 3칼라", "브라운", "DIA 14.0 / GRA 13.8", "3달(1p), 25000원, 병, 렌즈미");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.me_13), "시크 3칼라", "그린","DIA 14.0 / GRA 13.8","3달(1p), 25000원, 병, 렌즈미");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.me_14), "시크 3칼라", "그레이", "DIA 14.0 / GRA 13.8", "3달(1p), 25000원, 병, 렌즈미");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.me_15), "클로 세븐 컬러", "블루", "DIA 14.3 / GRA 13.3", "1달(2p), 20000원, 팩, 렌즈미");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.me_16), "클로 세븐 컬러", "핑크", "DIA 14.3 / GRA 13.3", "1달(2p), 20000원, 팩, 렌즈미");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.town_8), "유니쳐로라", "바이올렛","DIA 14.3 / GRA 13.9","1달(1p), 25000원, 팩, 렌즈타운");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.town_20), "스완", "그레이","DIA 14.5 / GRA 13.2","1달(1p), 12000원, 병, 렌즈타운");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.o_1), "스콴다 원 데이", "브라운","DIA 14.2 / GRA 11.9","원데이(20p), 32000원, 팩, 오렌즈");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.o_2), "스콴다 원 데이", "그레이","DIA 14.2 / GRA 11.9","원데이(20p), 32000원, 팩, 오렌즈");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.o_3), "스콴다 원 데이", "그린","DIA 14.2 / GRA 11.9","원데이(10p), 18000원, 팩, 오렌즈");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.o_4), "골드 베리 3콘", "브라운","DIA 14.2 / GRA 13.7","2주(4p), 25000원, 팩, 오렌즈");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.o_5), "골드 베리 3콘", "그레이","DIA 14.2 / GRA 13.7","2주(4p), 25000원, 팩, 오렌즈");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.o_6), "제니스", "골드 핑크","DIA 14.0 / GRA 13.2","2주(4p), 28000원, 팩, 오렌즈");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.o_7), "제니스", "골드 블루","DIA 14.0 / GRA 13.2","2주(4p), 28000원, 팩, 오렌즈");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.o_8), "제니스", "골드 브라운","DIA 14.0 / GRA 13.2","2주(4p), 28000원, 팩, 오렌즈");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.o_9), "제니스", "골드 그레이","DIA 14.0 / GRA 13.2","2주(4p), 28000원, 팩, 오렌즈");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.o_10), "제니스", "골드 그린","DIA 14.0 / GRA 13.2","2주(4p), 28000원, 팩, 오렌즈");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.o_11), "심포니 3콘", "브라운","DIA 14.0 / GRA 13.5","1달(2p), 25000원, 팩, 오렌즈");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.o_20), "스페니쉬", "리얼 브라운","DIA 14.0 / GRA 11.9","1달(2p), 20000원, 팩, 오렌즈");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.o_21), "스페니쉬", "리얼 그레이","DIA 14.0 / GRA 11.9","1달(2p), 20000원, 팩, 오렌즈");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.o_22), "퍼스퍼", "브라운","DIA 14.2 / GRA 13.0","3달(1p), 40000원, 팩, 오렌즈");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.o_23), "퍼스퍼", "그레이","DIA 14.2 / GRA 13.0","3달(1p), 40000원, 팩, 오렌즈");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.town_9), "오로라블링", "펄 바이올렛","DIA 14.2 / GRA 12.9","1달(1p), 20000원, 팩, 렌즈타운");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.town_10), "오로라블링", "펄 브라운","DIA 14.2 / GRA 12.9","1달(1p), 20000원, 팩, 렌즈타운");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.town_11), "오로라블링", "펄 그레이","DIA 14.2 / GRA 12.9","1달(1p), 20000원, 팩, 렌즈타운");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.town_12), "토니아이 원데이", "그레이","DIA 14.3 / GRA 13.8","원 데이(20p), 30000원, 팩, 렌즈타운");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.town_13), "토니아이 원데이", "브라운","DIA 14.3 / GRA 13.8","원 데이(20p), 30000원, 팩, 렌즈타운");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.town_14), "이츠워터 원데이", "그레이","DIA 14.0 / GRA 13.7","원 데이(10p), 15000원, 팩, 렌즈타운");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.town_15), "이츠워터 원데이", "브라운","DIA 14.0 / GRA 13.7","원 데이(10p), 15000원, 팩, 렌즈타운");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.town_16), "루나프리즘", "머큐리블루","DIA 14.2 / GRA 13.8","3달(1p), 30000원, 병, 렌즈타운");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.town_17), "스완", "그린","DIA 14.5 / GRA 13.2","1달(1p), 12000원, 병, 렌즈타운");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.town_18), "스완", "핑크","DIA 14.5 / GRA 13.2","1달(1p), 12000원, 병, 렌즈타운");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.town_19), "스완", "브라운","DIA 14.5 / GRA 13.2","1달(1p), 12000원, 병, 렌즈타운");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.o_31), "실리오", "투명"," ","1달(2p), 20000원, 팩, 오렌즈");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.o_32), "오투에디션", "투명"," ","원 데이(40p), 29000원, 팩, 오렌즈");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.o_33), "프리메디 S45", "투명"," ","6달(1p), 80000원, 병, 오렌즈");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.o_34), "퍼스파인", "투명"," ","6달(1p), 30000원, 병, 오렌즈");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.a_1), "원데이 아큐브 트루아이", "투명","팩, 아큐브","원 데이, 30p 45000, 80p 108000원");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.o_24), "안나수이 3콘", "브라운","DIA 14.2 / GRA 13.7","6달(1p), 60000원, 병, 오렌즈");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.o_25), "안나수이 3콘", "그레이","DIA 14.2 / GRA 13.7","6달(1p), 60000원, 병, 오렌즈");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.o_26), "프렌치 3칼라", "핑크","DIA 14.5 / GRA 14.0","6달(1p), 50000원, 병, 오렌즈");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.o_27), "프렌치 3칼라", "브라운","DIA 14.5 / GRA 14.0","6달(1p), 50000원, 병, 오렌즈");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.o_28), "프렌치 3칼라", "그레이","DIA 14.5 / GRA 14.0","6달(1p), 50000원, 병, 오렌즈");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.o_29), "클래시 미스티크", "브라운","DIA 14.1 / GRA 13.5","6달(1p), 60000원, 병, 오렌즈");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.o_30), "클래시 미스티크", "그레이","DIA 14.1 / GRA 13.5","6달(1p), 60000원, 병, 오렌즈");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.o_12), "심포니 3콘", "그레이","DIA 14.0 / GRA 13.5","1달(2p), 25000원, 팩, 오렌즈");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.o_13), "심포니 3콘", "그린","DIA 14.0 / GRA 13.5","1달(2p), 25000원, 팩, 오렌즈");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.o_14), "크리스탈 3콘", "그레이","DIA 14.0 / GRA 13.3","1달(2p), 25000원, 팩, 오렌즈");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.o_15), "크리스탈 3콘", "브라운","DIA 14.0 / GRA 13.3","1달(2p), 25000원, 팩, 오렌즈");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.o_16), "크리스탈 3콘", "핑크","DIA 14.0 / GRA 13.3","1달(2p), 25000원, 팩, 오렌즈");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.a_3), "원데이 아큐브", "투명","팩, 아큐브","원 데이, 30p 35000원, 80p 84000원");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.a_4), "아큐브 어드밴스", "투명","팩, 아큐브","2주(6p), 27000원");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.o_17), "스페니쉬", "리얼 블루","DIA 14.0 / GRA 11.9","1달(2p), 20000원, 팩, 오렌즈");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.o_18), "스페니쉬", "리얼 핑크","DIA 14.0 / GRA 11.9","1달(2p), 20000원, 팩, 오렌즈");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.o_19), "스페니쉬", "리얼 그린","DIA 14.0 / GRA 11.9","1달(2p), 20000원, 팩, 오렌즈");
        mainAdapter.addItem(getResources().getDrawable(R.drawable.a_2), "원데이 아큐브 모이스트", "투명","팩, 아큐브","원 데이, 30p 40000원, 80p 96000원");

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

