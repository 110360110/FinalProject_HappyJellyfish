package com.example.happy_jellyfish.TicTacToe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.happy_jellyfish.R;
import com.example.happy_jellyfish.TicTacToe.*;

public class TicTacToeActivity extends AppCompatActivity {

    Button button;
    int n = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TicTacToeActivity.this, TicTacToeMainActivity.class);
                intent.putExtra("player1", "Player1");
                intent.putExtra("player2", "Player2");
                intent.putExtra("grid",n);
                startActivity(intent);
            }
        });
    }
}