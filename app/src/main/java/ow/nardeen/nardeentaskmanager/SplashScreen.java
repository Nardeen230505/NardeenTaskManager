package ow.nardeen.nardeentaskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //start next activity/screen otamaticly after period of time
        //فتح الشاشة التالية تلقائيا بعد فترة من الزمن
        //ننعرف كائن من نوع Handler
        //
        Handler h=new Handler(); //تعريف كائن من نوع Handler
        Runnable r=new Runnable() {
            @Override
            public void run() { //anonymous class
                Intent i=new Intent(SplashScreen.this,SignIn.class);
                        startActivity(i);

              finish();//اغلاق الشاشة الحالية

            }
        };

        h.postDelayed(r,3000);
        }
}