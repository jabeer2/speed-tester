package com.example.speed_tester;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button GoBtn,button1,button2,button3,button4;
    TextView SumText,result,score,sec,cong;
    int total,pos,qus=0,ans=0;
    boolean isTimeon = false,isGoOn = false;
    public  void G0(View view){
        isGoOn=false;
            GoBtn.setVisibility(View.INVISIBLE);
            cong.setText("");

    }
    public void timmer(){
        if (isTimeon == false) {
            new CountDownTimer(30100, 1000) {
                @Override
                public void onTick(long l) {
                    sec.setText(String.valueOf(l / 1000) + "s");

                }

                @Override
                public void onFinish() {
                    finished();
                }
            }.start();
            isTimeon = true;
        }

    }

    public void play(){
        Random random = new Random();
        int a = random.nextInt(50);
        int b = random.nextInt(50);
        int sign = random.nextInt(3);
        switch (sign) {
            case 1:
                SumText.setText(Integer.toString(a) + "+" + Integer.toString(b));
                total = a + b;
                break;
            case 2:
                SumText.setText(Integer.toString(a) + "-" + Integer.toString(b));
                total = a - b;
                break;
            default:
                SumText.setText(Integer.toString(a) + "*" + Integer.toString(b));
                total = a * b;
                break;
        }
        int Answer = random.nextInt(10);
        int position = random.nextInt(4);
        switch (position) {
            case 1:
                button2.setText(Integer.toString(total));
                button3.setText(Integer.toString(total + b));
                button4.setText(Integer.toString(total - b));
                button1.setText(Integer.toString(total * b));
                pos = 1;
                break;
            case 2:
                button3.setText(Integer.toString(total));
                button2.setText(Integer.toString(total + b));
                button4.setText(Integer.toString(total - b));
                button1.setText(Integer.toString(total * b));
                pos = 2;
                break;
            case 3:
                button4.setText(Integer.toString(total));
                button2.setText(Integer.toString(total + b));
                button3.setText(Integer.toString(total - b));
                button1.setText(Integer.toString(total * b));
                pos = 3;
                break;
            default:
                button1.setText(Integer.toString(total));
                button3.setText(Integer.toString(total + b));
                button4.setText(Integer.toString(total - b));
                button2.setText(Integer.toString(total * b));
                pos = 0;
                break;
        }
        qus++;
        timmer();



    }
    public void finished(){
        sec.setText("00s");
        button1.setText("0");
        button2.setText("0");
        button3.setText("0");
        button4.setText("0");
        SumText.setText("0+0");
        score.setText("0/0");
        cong.setText("you answered "+Integer.toString(ans)+" correct from "+Integer.toString(qus)+" Question");
        isGoOn=true;
        isTimeon=false;
        GoBtn.setText("play Again");
        GoBtn.setVisibility(View.VISIBLE);
        result.setText("");
        ans=0;
        qus=0;

    }
    public void Ans(View view){
        if(isGoOn == false) {
            if (view.getTag().toString().equals(Integer.toString(pos))) {
                Log.i("true", "true");
                result.setText("Correct!");
                ans++;

            } else {
                result.setText("Wrong!");
            }
            score.setText(Integer.toString(qus) + "/" + Integer.toString(ans));
            play();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sec = (TextView)findViewById(R.id.score);
        GoBtn = (Button)findViewById(R.id.GoBtn);
        score = (TextView)findViewById(R.id.sec);
        SumText = (TextView)findViewById(R.id.sumText);
        result = (TextView)findViewById(R.id.desitionText);
        button1 = (Button)findViewById(R.id.button2);
        button2 = (Button)findViewById(R.id.button3);
        button3 = (Button)findViewById(R.id.button4);
        button4 = (Button)findViewById(R.id.button5);
        cong = (TextView)findViewById(R.id.cong);
    }
}