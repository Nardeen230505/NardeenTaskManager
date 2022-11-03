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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import ow.nardeen.nardeentaskmanager.Data.Mahama;
import ow.nardeen.nardeentaskmanager.Data.TaskAdapter;

public class MainActivity extends AppCompatActivity {

    // 3. بناء الوسيط TaskAdapter
    TaskAdapter taskAdapter;
    //قائمة عرض المهمات
    ListView lstview;


//تعريف صفات الكلاس
    private SearchView search;
    private ListView list;
    private ImageButton imgBAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) { //When an Activity first call or launched then onCreate(Bundle savedInstanceState) method is responsible to create the activity.
        //After Orientation changed then onCreate(Bundle savedInstanceState) will call and recreate the activity and load all data from savedInstanceState.

        super.onCreate(savedInstanceState);
        // قوم ببناء شاشة التنسيق وكل الكائنات التي تحويها
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

        // تابع لخطوة 3 - بناء الوسيط (الادابتر)
        taskAdapter=new TaskAdapter(getApplicationContext());
        // تجهيز مؤشر لقائمة العرض
        lstview=findViewById(R.id.list);
        // تابع لخطوة 3 - ربط قائمة العرض بالوسيط
        lstview.setAdapter(taskAdapter);

        //تشغيل "مراقب" على قاعدة البيانات
        // ويقوم بتنظيف المعطيات الموجة (حذفها) وتنزيل المعلومات الجديدة
        readMahamatFromFireBase();

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

    private void readMahamatFromFireBase()
    {
        //مؤشر لجذر قاعدة البيانات التابعة للمشروع
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        // listener لمراقبة أي تغيير يحدث تحت الجذر المحدد
        // أي تغيير بقيمة صفة او حذف او اضافة كائن يتم اعلام الlistener
        //عند حدوت التغيير يتم تنزيل او تحميل كل المعطيات الموجودة تحت الجذر
        String owner = FirebaseAuth.getInstance().getCurrentUser().getUid();
        reference.child("mahama").child(owner).addValueEventListener(new ValueEventListener() {
            /**
             * دالة معالجة حدث عند تغيير اي قيمة
             * @param snapshot يحوي نسخة عن كل المعطيات تحت العنوان المُراقب - العنوان المراقب يعني العنوان الي حاطة عليه ليسينير-
             */
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            { // هادا معالج حدث للداتا تشينج يعني معالج حدث بالفاير بيس

                // remove all tasks from adapter
                taskAdapter.clear();

                // استخراج المعطيات ونحطهن بالادابتير
                for (DataSnapshot d:snapshot.getChildren()) {
                    //d يمر على جميع قيم مبنى المعطيات

                    Mahama m=d.getValue(Mahama.class); //استخراج الكائن المحفوظ
                    taskAdapter.add(m); //اضافة كائن للوسيط

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error)
            {

            }
        }); //الممشاك بدو تطبيق عن طريق بناء كائن الي بعمل انينوموس كلاس
    }


}
