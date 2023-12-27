package com.example.happy_jellyfish;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.example.happy_jellyfish.Tetris.TetrisActivity;

public class TetrisService extends Service {
    public TetrisService() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    Intent intent = new Intent(TetrisService.this, TetrisActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    TetrisService.this.startActivity(intent);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start();

        stopSelf();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}