package com.example.happy_jellyfish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.happy_jellyfish.FifteenPuzzle.FifteenPuzzleMainActivity;
import com.example.happy_jellyfish.FlappyBird.FlappyBirdMainActivity;
import com.example.happy_jellyfish.PaperScissorStone.*;
import com.example.happy_jellyfish.TicTacToe.*;
import com.example.happy_jellyfish.catchfruit.CatchFruitMainActivity;


public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ImageView iv_1;
    private TextView tv_choose, tv_textView1;
    private Button btn_open;
    private String[] game=new String[]{"PaperScissorStone","TicTacToe","CatchFruit","FlappyBird","15Puzzle"};
    private int[] imageresource = new int[]{R.drawable.rockpaperscissor_0,R.drawable.tictactoe,R.drawable.catchthefruit,R.drawable.bird_0,R.drawable.jellyfish};
    private String[] explain = new String[]{"跟電腦猜拳，下方EXIT按鈕點擊可回到主畫面","Player1是X，Player2是O，結束可以選擇重玩或是回到主畫面","在10秒內點擊出現的水果","點擊螢幕讓小鳥飛過水管中間的空隙，不可以碰到水管或螢幕邊緣","將15個數字用最少的步數排列"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        tv_choose = findViewById(R.id.tv_choose);
        btn_open = findViewById(R.id.btn_open);
        tv_textView1 = findViewById(R.id.tv_textView1);
        iv_1 =findViewById(R.id.iv_1);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, game);
        listView.setAdapter(adapter);

        iv_1.setImageResource(R.drawable.jellyfish);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = game[position];
                tv_choose.setText("選擇的項目是：" + selectedItem);
                tv_textView1.setText(explain[position]);
                iv_1.setImageResource(imageresource[position]);
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

                    case "選擇的項目是：CatchFruit" :
                        Intent intent2 = new Intent(MainActivity.this, CatchFruitMainActivity.class);
                        startActivity(intent2);
                        break;

                    case "選擇的項目是：FlappyBird" :
                        Intent intent3 = new Intent(MainActivity.this, FlappyBirdMainActivity.class);
                        startActivity(intent3);
                        break;

                    case "選擇的項目是：15Puzzle" :
                        Intent intent4 = new Intent(MainActivity.this, FifteenPuzzleMainActivity.class);
                        startActivity(intent4);
                        break;

                    default:
                        Toast.makeText(MainActivity.this, "不要瞎按", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


}