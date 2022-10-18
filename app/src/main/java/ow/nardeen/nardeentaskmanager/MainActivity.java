package ow.nardeen.nardeentaskmanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SearchView;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
//تعريف صفات الكلاس
    private SearchView search;
    private ListView list;
    private ImageButton imgBAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) { //When an Activity first call or launched then onCreate(Bundle savedInstanceState) method is responsible to create the activity.
        //After Orientation changed then onCreate(Bundle savedInstanceState) will call and recreate the activity and load all data from savedInstanceState.

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgBAdd=findViewById(R.id.imgBAdd);

        imgBAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Register a callback to be invoked when this view is clicked. If this view is not clickable, it becomes clickable.
                Intent in=new Intent(MainActivity.this, AddTaskActivity.class);
                startActivity(in);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        //دالة مسؤولة عن تشغيل الmenu
        //دالة بوليانية ترجع ترو اذا كل اشي تمام
        //بعد ما بنيت المنيو لازم المنيو لما اعمل هرتسا
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    // هذه الدالة عبارة عن ردة فعل لما بختار الحدث
    {
        if (item.getItemId()==R.id.itmSettings)
        {
            Intent intentS=new Intent(MainActivity.this,SettingsActivity.class);
            startActivity(intentS);
        }

        if (item.getItemId()==R.id.itmHistory)
        {
            Intent iH=new Intent(MainActivity.this,HistoryActivity.class);
            startActivity(iH);
        }

        if (item.getItemId()==R.id.itmSignOut)
        {

           // finish();
           //  تجهيز البناء للديالوج
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Signing Out");
            builder.setMessage("Do you want to sign out?");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i)
                {
                    dialogInterface.dismiss(); //إخفاء الديالوج مع الحفظ في الذاكرة
                    FirebaseAuth.getInstance().signOut(); //تسجيل الخروج - الخروج من الحساب
                    //الخروج من الشاشة
                    finish();
                }
            });
            //هون اذا انا بديش اعمل ساين اوت للحساب

            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i)
                {
                    dialogInterface.cancel(); // اخفاء شاشة الديالوج بدون الحفظ في الذاكرة
                }
            });

            // بناء الديالوج
            AlertDialog dialog = builder.create();
            dialog.show();

        }
        return true;
    }
}
