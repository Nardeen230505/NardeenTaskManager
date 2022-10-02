package ow.nardeen.nardeentaskmanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInActivity extends AppCompatActivity {
    //تعريف صفاتا الكلاس
    private TextInputEditText etEmail;
    private TextInputEditText etPassword;
    private Button btnSignUp;
    private Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) { //When an Activity first call or launched then onCreate(Bundle savedInstanceState) method is responsible to create the activity.
//After Orientation changed then onCreate(Bundle savedInstanceState) will call and recreate the activity and load all data from savedInstanceState.
        super.onCreate(savedInstanceState); //اول اشي بشتغل لما نشغل البرنامج
        setContentView(R.layout.activity_sign_in); //يبني واحهة المستعمل بحيث تبني كل الكائنات الموجودة بملف التنسيق xml

//حقول الصفات
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnSignUp = findViewById(R.id.btnSignUp);
        btnSignIn = findViewById(R.id.btnSignIn);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //الي بين قوسين هو بارامتر الي تسبب بالحدث
                Intent i1 = new Intent(SignInActivity.this, SignUpActivity.class);
                startActivity(i1);
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAndSave();
            }
            //Register a callback to be invoked when this view is clicked. If this view is not clickable, it becomes clickable.
        });
    }

    private void checkAndSave() { //عملية تفحص اذا كل اشي تمام
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        boolean isOk = true;
        if (email.length() == 0) {
            etEmail.setError("enter you Email pls");
            isOk = false;
        }

        if (password.length() == 0) {
            etPassword.setError("enter you password pls");
            isOk = false;
        }

        if (email.indexOf('@') <= 0) {
            etEmail.setError("wrong email syntax");
            isOk = false;
        }

        if (password.length() < 7) {
            etPassword.setError("passward at least 7 character");
            isOk = false;
        }

        if (isOk)
        {
            FirebaseAuth auth = FirebaseAuth.getInstance();
            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task)  //وظيفة الدالة معالجة الحدث وبتوخد بارامترات بتخص الحدث
                {
                    if(task.isSuccessful())
                    {
                        Toast.makeText(SignInActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                        Intent i=new Intent(SignInActivity.this,MainActivity.class);
                        startActivity(i); //بدء تشغيل الشاشة
                        finish(); //لتسكير الشاشة
                    }
                else
                    {
                        Toast.makeText(SignInActivity.this, "Not Successful"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }
    }
}
/*  btnSignIn=findViewById(R.id.btnSignIn); // هادا null لانو عم بدور على الكائن وبعدني مش بانية واجهة المستعمل
    setContentView(R.layout.activity_sign_in);
 */