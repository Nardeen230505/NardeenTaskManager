package ow.nardeen.nardeentaskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class SignIn extends AppCompatActivity {
 private TextInputEditText etEmail;
 private TextInputEditText etPassword;
 private Button btnSignUp;
    private Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in); //يبني واحهة المستعمل بحيث تبني كل الكائنات الموجودة بملف التنسيق xml


        etEmail=findViewById(R.id.etEmail);
        etPassword=findViewById(R.id.etPassword);
        btnSignUp=findViewById(R.id.btnSignUp);
        btnSignIn=findViewById(R.id.btnSignIn);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view ) { //الي بين قوسين هو بارامتر الي تسبب بالحدث
                Intent i1=new Intent(SignIn.this,SignUp.class);
                startActivity(i1);
            }
        });

    }
}
/*  btnSignIn=findViewById(R.id.btnSignIn); // هادا null لانو عم بدور على الكائن وبعدني مش بانية واجهة المستعمل
    setContentView(R.layout.activity_sign_in);
 */