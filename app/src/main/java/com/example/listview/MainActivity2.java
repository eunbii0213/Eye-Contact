package com.example.listview;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

public class MainActivity2 extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    LensFragment lensFragment;
    LensCareFragment lensCareFragment;
    TestFragment testFragment;
    CalenderFragment calenderFragment;
    MypageFragment mypageFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //build the menu
        ImageView icon = new ImageView(this);
        icon.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.menu));

        FloatingActionButton actionButton = new FloatingActionButton.Builder(this)

                .setContentView(icon)

                .build();

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        //build the buttons
        SubActionButton.Builder itemBuilder = new SubActionButton.Builder(this);

        //lens button
        ImageView lensIcon = new ImageView(this);
        lensIcon.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.lens));
        SubActionButton button1 = itemBuilder.setContentView(lensIcon).build();

        //lensCare button
        ImageView lensItemIcon = new ImageView(this);
        lensItemIcon.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.lenscare));
        SubActionButton button2 = itemBuilder.setContentView(lensItemIcon).build();

        //Test button
        ImageView testIcon = new ImageView(this);
        testIcon.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.test));
        SubActionButton button3 = itemBuilder.setContentView(testIcon).build();

        //Calendar button
        ImageView calendarIcon = new ImageView(this);
        calendarIcon.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.calendar));
        SubActionButton button4 = itemBuilder.setContentView(calendarIcon).build();

        //memo button
        ImageView memoItemIcon = new ImageView(this);
        memoItemIcon.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.memo));
        SubActionButton button5 = itemBuilder.setContentView(memoItemIcon).build();

        FloatingActionMenu actionMenu = new FloatingActionMenu.Builder(this)

                .addSubActionView(button1)
                .addSubActionView(button2)
                .addSubActionView(button3)
                .addSubActionView(button4)
                .addSubActionView(button5)
                .attachTo(actionButton)
                .build();

        //5개의 메뉴에 들어갈 Fragment들
        lensFragment = new LensFragment();
        lensCareFragment = new LensCareFragment();
        testFragment = new TestFragment();
        calenderFragment = new CalenderFragment();
        mypageFragment = new MypageFragment();

        //메인화면 설정
        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, lensFragment).commitAllowingStateLoss();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                //각각 메뉴마다 Fragment 불러오기
                switch (menuItem.getItemId()) {
                    case R.id.lens: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, lensFragment).commitAllowingStateLoss();
                        return true;
                    }
                    case R.id.lensCare: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, lensCareFragment).commitAllowingStateLoss();
                        return true;
                    }
                    case R.id.test: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, testFragment).commitAllowingStateLoss();
                        return true;
                    }
                    case R.id.calender: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, calenderFragment).commitAllowingStateLoss();
                        return true;
                    }
                    case R.id.myPage: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, mypageFragment).commitAllowingStateLoss();
                        return true;
                    }
                    default:
                        return false;
                }
            }
        });
    }
}


