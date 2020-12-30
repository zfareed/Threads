package com.example.threads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        progressBar = findViewById(R.id.progressBar);



        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 0;

                while (count < 101) {

                    int finalCount = count;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            textView.setText(finalCount + "");
                            progressBar.setProgress(finalCount);
                        }
                    });

                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    count++;
                }
            }
        });

        thread.start();

    }
}