package com.example.happy_jellyfish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.happy_jellyfish.PaperScissorStone.*;
import com.example.happy_jellyfish.TicTacToe.*;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private TextView tv_choose;
    private Button btn_open;
    private String[] game=new String[]{"PaperScissorStone","TicTacToe","Orange"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        tv_choose = findViewById(R.id.tv_choose);
        btn_open = findViewById(R.id.btn_open);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, game);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = game[position];
                tv_choose.setText("選擇的項目是：" + selectedItem);
            }
        });
        btn_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(tv_choose.getText().toString())
                {
                    case "選擇的項目是：PaperScissorStone" :
                        Intent intent = new Intent(MainActivity.this, PaperScissorStoneMainActivity.class);
                        startActivity(intent);
                        break;

                    case "選擇的項目是：TicTacToe" :
                        Intent intent1 = new Intent(MainActivity.this, TicTacToeActivity.class);
                        startActivity(intent1);
                        break;

                    default:
                        Toast.makeText(MainActivity.this, "不要瞎按", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


}