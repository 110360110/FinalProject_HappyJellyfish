package com.example.happy_jellyfish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.happy_jellyfish.Tetris.TetrisActivity;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private TextView tv_choose;
    private String[] game=new String[]{"Tetris","Banana","Orange"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        tv_choose = findViewById(R.id.tv_choose);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, game);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = game[position];
                tv_choose.setText("選擇的項目是：" + selectedItem);
                Toast.makeText(MainActivity.this, "選擇的項目是：" + selectedItem, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, TetrisService.class);
                startService(intent);
                finish();

            }
        });

    }


}