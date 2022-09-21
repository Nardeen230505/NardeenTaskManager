package ow.nardeen.nardeentaskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SearchView;

public class MainActivity extends AppCompatActivity {

    private SearchView search;
    private ListView list;
    private ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}