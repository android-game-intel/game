package com.example.daiphongpc.ngich.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.example.daiphongpc.ngich.Model.Game;
import com.example.daiphongpc.ngich.R;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    int count = 10;
    static int index = 0;
    TextSwitcher txtQues;
    TextView txtPoint;
    ImageButton btnTrue, btnFlase;
    ArrayList<Game> arrData = new ArrayList<>();
    int i = 0;
    boolean flag = false;
    Timer timer;
    static int diem=0;

    @Override
    protected void onResume() {
        super.onResume();
        diem=0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        process();
    }

    private void process() {
        txtQues.setText(arrData.get(i).getQuestion());
    }


    private void addControls() {
        txtPoint=findViewById(R.id.txt_point);
        progressBar = findViewById(R.id.progressBar);
        btnTrue = findViewById(R.id.btn_true);
        btnFlase = findViewById(R.id.btn_false);
        txtQues = findViewById(R.id.txt_ques);
        arrData.add(new Game("1+1=3", 1));
        arrData.add(new Game("9+6=14", 1));
        arrData.add(new Game("5-1=4", 0));
        arrData.add(new Game("10-7=3", 0));
        arrData.add(new Game("1+1=3", 1));
        arrData.add(new Game("9+6=14", 1));
        arrData.add(new Game("5-1=4", 0));
        arrData.add(new Game("10-7=3", 0));
        arrData.add(new Game("1+1=3", 1));
        arrData.add(new Game("9+6=14", 1));
        arrData.add(new Game("5-1=4", 0));
        arrData.add(new Game("10-7=3", 0));
        arrData.add(new Game("1+1=3", 1));
        arrData.add(new Game("9+6=14", 1));
        arrData.add(new Game("5-1=4", 0));
        arrData.add(new Game("10-7=3", 0));
        arrData.add(new Game("1+1=3", 1));
        arrData.add(new Game("9+6=14", 1));
        arrData.add(new Game("5-1=4", 0));
        arrData.add(new Game("10-7=3", 0));
        arrData.add(new Game("1+1=3", 1));
        arrData.add(new Game("9+6=14", 1));
        arrData.add(new Game("5-1=4", 0));
        arrData.add(new Game("10-7=3", 0));
        arrData.add(new Game("1+1=3", 1));
        arrData.add(new Game("9+6=14", 1));
        arrData.add(new Game("5-1=4", 0));
        arrData.add(new Game("10-7=3", 0));
        arrData.add(new Game("1+1=3", 1));
        arrData.add(new Game("9+6=14", 1));
        arrData.add(new Game("5-1=4", 0));
        arrData.add(new Game("10-7=3", 0));
        arrData.add(new Game("1+1=3", 1));
        arrData.add(new Game("9+6=14", 1));
        arrData.add(new Game("5-1=4", 0));
        arrData.add(new Game("10-7=3", 0));
        arrData.add(new Game("1+1=3", 1));
        arrData.add(new Game("9+6=14", 1));
        arrData.add(new Game("5-1=4", 0));
        arrData.add(new Game("10-7=3", 0));


        btnTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (arrData.get(i).getAnswer() == 0) {
                    i = i + 1;
                    diem=diem+1;
                    txtQues.setText(arrData.get(i).getQuestion());
                    count = 11;
                    txtPoint.setText(diem+"");
                    if(timer != null) {
                        timer.cancel();
                        timer = null;
                    }
                    timer=new Timer();
                    threadTime();
                    if (i>=arrData.size()-1)
                        i=0;
                } else {
                    Toast.makeText(MainActivity.this, "sai rồi", Toast.LENGTH_LONG).show();
                }
            }
        });
        Log.d("adasd", "addControls: " + index);
        txtQues.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(MainActivity.this);
                textView.setTextColor(Color.WHITE);
                textView.setTextSize(80);
                textView.setGravity(Gravity.CENTER_HORIZONTAL);
                return textView;
            }
        });
        btnFlase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (arrData.get(i).getAnswer() == 1) {
                    i = i + 1;
                    diem=diem+1;
                    if(timer != null) {
                        timer.cancel();
                        timer = null;
                    }
                    timer=new Timer();
                    threadTime();
                    txtQues.setText(arrData.get(i).getQuestion());
                    txtPoint.setText(diem+"");
                    count = 11;
                    if (i>=arrData.size()-1)
                        i=0;
                } else {
                    Toast.makeText(MainActivity.this, "sai rồi", Toast.LENGTH_LONG).show();
                }
            }
        });


    }

    void threadTime() {


        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        count--;
                        progressBar.setProgress(count);
                        if (count == 0) {
                            Toast.makeText(MainActivity.this, "điểm của là:"+diem, Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                            startActivity(intent);
                            finish();
                        }

                    }
                });
            }
        };

        timer.schedule(timerTask, 0, 150);


    }

}
