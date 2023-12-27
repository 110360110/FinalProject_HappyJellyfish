package com.example.happy_jellyfish.Tetris

import android.content.Context
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import com.example.happy_jellyfish.R
import kotlinx.coroutines.*


class TetrisActivity : AppCompatActivity() {

    val canvas = findViewById<CanvasView>(R.id.canvas)
    val button_rotate = findViewById<ImageButton>(R.id.button_rotate)
    val button_left = findViewById<ImageButton>(R.id.button_left)
    val button_right = findViewById<ImageButton>(R.id.button_right)
    val button_fast_down = findViewById<ImageButton>(R.id.button_fast_down)
    val btn_start = findViewById<Button>(R.id.btn_start)
    val btn_exit = findViewById<Button>(R.id.btn_exit)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tetris)


        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        supportActionBar?.hide()

        button_rotate.setOnClickListener {
            if(Rotate.isRotable()){
                Rotate.doRotate()
                canvas.invalidate()
            }
        }

        button_left.setOnClickListener {
            if (MoveLeft.isMovableLeft()) {
                MoveLeft.moveLeft()
                canvas.invalidate()
            }
        }

        button_right.setOnClickListener {
            if (MoveRight.isMovableRight()) {
                MoveRight.moveRight()
                canvas.invalidate()
            }
        }

        button_fast_down.setOnClickListener {
            while (!Falling.willLanding(1)) {
                Falling.fallingStep()
            }
        }

        btn_start.setOnClickListener {
            game()
        }

        btn_exit.setOnClickListener {

        }
    }

    private fun game() {
        CoroutineScope(Dispatchers.IO).launch {
            // todo eliminate this
            Level.reset()
            Tetromino.newPiece()
            Level.insertNewPosition()
            setBest()

            while (true) {
                if (Falling.willLanding(1)) {
                    // check is need to clear rows
                    Level.checkRows()
                    // if landed piece cant entered
                    if (Level.isGameOver()) {
                        resetBest()
                        Level.reset()
                        break
                    }
                    Tetromino.newPiece()
                    Level.insertNewPosition()
                } else {
                    Falling.fallingStep()
                }
                //game speed in millisecond
                delay(Tetromino.speed)
                canvas.invalidate()
            }

        }
    }

    private fun setBest() {
        val sharedPreference = getSharedPreferences("HIGH_SCORE", Context.MODE_PRIVATE)
        Level.best = sharedPreference.getInt("high_score", 0)
    }
    private fun resetBest(){
        val sharedPreference = getSharedPreferences("HIGH_SCORE", Context.MODE_PRIVATE)
        if (Level.score > sharedPreference.getInt("high_score", 0)) {
            var editor = sharedPreference.edit()
            editor.putInt("high_score", Level.score)
            editor.commit()
            Level.best = sharedPreference.getInt("high_score", 0)
        }
    }
}