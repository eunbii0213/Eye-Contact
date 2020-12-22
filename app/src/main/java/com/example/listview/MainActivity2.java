package com.example.listview;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity2 extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    LensFragment lensFragment;
    LensCareFragment lensCareFragment;
    TestFragment testFragment;
    CalenderFragment calenderFragment;
    MypageFragment mypageFragment;
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main2);
    bottomNavigationView = findViewById(R.id.bottomNavigationView);

        //5개의 메뉴에 들어갈 Fragment들
        lensFragment = new LensFragment();
        lensCareFragment = new LensCareFragment();
        testFragment = new TestFragment();
        calenderFragment = new CalenderFragment();
        mypageFragment = new MypageFragment();
        //메인화면 설정
      getSupportFragmentManager().beginTransaction().replace(R.id.main_layout,lensFragment).commitAllowingStateLoss();
      bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

          @Override public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
              //각각 메뉴마다 Fragment 불러오기
              switch (menuItem.getItemId()){
                 case R.id.lens:{
                     getSupportFragmentManager().beginTransaction() .replace(R.id.main_layout,lensFragment).commitAllowingStateLoss();
                     return true;
                 } case R.id.lensCare:{
                     getSupportFragmentManager().beginTransaction() .replace(R.id.main_layout,lensCareFragment).commitAllowingStateLoss();
                     return true;
                 } case R.id.test:{
                     getSupportFragmentManager().beginTransaction() .replace(R.id.main_layout,testFragment).commitAllowingStateLoss();
                     return true;
                 } case R.id.calender:{
                      getSupportFragmentManager().beginTransaction() .replace(R.id.main_layout,calenderFragment).commitAllowingStateLoss();
                      return true;
                  }case R.id.myPage:{
                      getSupportFragmentManager().beginTransaction().replace(R.id.main_layout,mypageFragment).commitAllowingStateLoss();
                      return true;
                  }default: return false;
              }
          }
      });
    }
}


