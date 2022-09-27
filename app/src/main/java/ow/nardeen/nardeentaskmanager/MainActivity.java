package ow.nardeen.nardeentaskmanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SearchView;

public class MainActivity extends AppCompatActivity {

    private SearchView search;
    private ListView list;
    private ImageButton imgBAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgBAdd=findViewById(R.id.imgBAdd);

        imgBAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
            Intent iSO=new Intent(MainActivity.this,SignInActivity.class);
            startActivity(iSO);
        }
        return true;
    }
}
