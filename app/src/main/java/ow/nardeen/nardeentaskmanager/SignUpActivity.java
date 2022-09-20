package ow.nardeen.nardeentaskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

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
        btnSave=findViewById(R.id.btnSave);
    }

    private void CheckAndSave()
    {
        String email=etEmail2.getText().toString();
        String password=etPassword.getText().toString();
        String rePassword=etRepassword.getText().toString();

        boolean isOk=true;
    }
}