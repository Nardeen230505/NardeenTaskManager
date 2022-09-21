package ow.nardeen.nardeentaskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {
private TextInputEditText etEmail2;
private TextInputEditText etPassword;
private TextInputEditText etRepassword;
private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etEmail2=findViewById(R.id.etEmail2);
        etPassword=findViewById(R.id.etPassword);
        etRepassword=findViewById(R.id.etRepassword);
        btnSave=findViewById(R.id.btnSignUpSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckAndSave();
            }
        });
    }

    private void CheckAndSave()
    {
        String email=etEmail2.getText().toString();
        String password=etPassword.getText().toString();
        String rePassword=etRepassword.getText().toString();

        boolean isOk=true;

        if(email.length()*password.length()*rePassword.length()==0)
        {
            etEmail2.setError("One of the files is empty");
        }

        if(password.equals(rePassword)==false)
        {
            etRepassword.setError("Is not equal to password");
            isOk=false;
        }

        if(isOk)
        {
            FirebaseAuth auth1=FirebaseAuth.getInstance();
            auth1.signInWithEmailAndPassword(email,password);
        }





    }
}