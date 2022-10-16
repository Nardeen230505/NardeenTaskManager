package ow.nardeen.nardeentaskmanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import ow.nardeen.nardeentaskmanager.Data.Mahama;

public class AddTaskActivity extends AppCompatActivity {
    private TextInputEditText etTitle, etSubject;
    private SeekBar sbImportant;
    private Button btnCancel2, btnSave;
    private ImageView imageButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        etTitle=findViewById(R.id.etTitle);
        etSubject=findViewById(R.id.etSubject);
        sbImportant=findViewById(R.id.sbImportant);
        btnCancel2=findViewById(R.id.btnCancel2);
        btnSave=findViewById(R.id.btnSave);
        imageButton2=findViewById(R.id.imageButton2);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAndSave();
            }
        });

    }

    private void checkAndSave()
    {
        String title=etTitle.getText().toString();
        String subjet=etSubject.getText().toString();
        int important=sbImportant.getProgress(); //استخراج  الرقم يتم بهذه الطريقة

        Mahama m =new Mahama();
        m.setTitle(title);
        m.setSubject(subjet);
        m.setImportance(important);

        //استخراج رقم مميز للمستعمل
        String owner= FirebaseAuth.getInstance().getCurrentUser().getUid();
        m.setOwner(owner);

        // انتاج الرقم المميز للمهمة
        String key=FirebaseDatabase.getInstance().getReference().
                child("mahama").child(owner).push().getKey();
        m.setKey(key);

        //حفظ بالخادم
        FirebaseDatabase.getInstance().getReference(). child("mahama").child(owner).child(key).setValue(m)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            finish();
                            Toast.makeText(AddTaskActivity.this, "added successfully", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(AddTaskActivity.this, "added failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }
}