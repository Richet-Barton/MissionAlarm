package com.example.missionalarm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import java.util.*;


public class MainActivity extends AppCompatActivity {
    List<String> listItem = new ArrayList<>();
    ListView listView;
    ListView exampleList;

    // 애플리케이션 초기 실행
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tv = findViewById(R.id.textViewAlarm);
        listView = findViewById(R.id.listView);

        listItem.add("Test1");
        listItem.add("Test2");
        listItem.add("Test3");

        updateList();
    }

    // 알람 추가 버튼 클릭 시
    public void addAlarm(View view) {
        Intent intent = new Intent(this, SetAlarmActivity.class);
        startActivityForResult(intent, 0);
    }

    // 알람 수정
    public void setAlarm() {
        Intent intent = new Intent(this, SetAlarmActivity.class);
        startActivityForResult(intent, 1);
    }

    // startActivityForResult 이후 메인 화면으로 돌아올 때
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 0: // 알람을 추가했을 때
                if (resultCode == RESULT_OK)
                    listItem.add("새로운 알람");
                break;
            case 1: // 알람을 수정했을 때
                if (resultCode == RESULT_OK)
                    listItem.add("수정된 알람");
                break;
        }
        updateList();
    }

    // 리스트 새로고침
    public void updateList() {
        exampleList = findViewById(R.id.listView);
        CustomListItemView item = new CustomListItemView(this, (ArrayList<String>) listItem);
        exampleList.setAdapter(item);
    }
}