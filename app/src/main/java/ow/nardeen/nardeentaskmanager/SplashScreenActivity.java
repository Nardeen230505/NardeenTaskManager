package ow.nardeen.nardeentaskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) { //When an Activity first call or launched then onCreate(Bundle savedInstanceState) method is responsible to create the activity.
        //After Orientation changed then onCreate(Bundle savedInstanceState) will call and recreate the activity and load all data from savedInstanceState.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen); //يبني واجهة المستعمل بحيث تبني كل الكائنات الموجودة بملف التنسيق xml

        //start next activity/screen otamaticly after period of time
        //فتح الشاشة التالية تلقائيا بعد فترة من الزمن
        //ننعرف كائن من نوع Handler
        //
        Handler h=new Handler(); //تعريف كائن من نوع Handler
        Runnable r=new Runnable() {
            @Override
            public void run() { //anonymous class
                Intent i=new Intent(SplashScreenActivity.this, SignInActivity.class);
                        startActivity(i);

              finish();//اغلاق الشاشة الحالية

            }
        };

        h.postDelayed(r,3000);
        }
}