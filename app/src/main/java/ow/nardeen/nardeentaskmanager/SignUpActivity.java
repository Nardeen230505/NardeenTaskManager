package ow.nardeen.nardeentaskmanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {
    //تعريف صفات الكلاس
private TextInputEditText etEmail2;
private TextInputEditText etPassword;
private TextInputEditText etRepassword;
private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) { //When an Activity first call or launched then onCreate(Bundle savedInstanceState) method is responsible to create the activity.
//After Orientation changed then onCreate(Bundle savedInstanceState) will call and recreate the activity and load all data from savedInstanceState.

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etEmail2=findViewById(R.id.etEmail2);
        etPassword=findViewById(R.id.etPassword);
        etRepassword=findViewById(R.id.etRepassword);
        btnSave=findViewById(R.id.btnSignUpSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Register a callback to be invoked when this view is clicked. If this view is not clickable, it becomes clickable.
                CheckAndSave();
            }
            //بس نكبس على زر سيف بروح على الدالة تشيك اند سيف بعمل كل الخطوات والأوامر الموجودة بهاي الدالة وبفحص كل الشروط واذا كانت كل الشروط ترو بعمل فينيش اذا لا بروح بنفذ ال ايلس (وبس يعمل فينيش برجع من الصفحة ساين اب لصفحة الساين ان)
        });
    }

    private void CheckAndSave()
    //هاي الدالة بتفحص اذا كل اشي تمام من سيسما وايميل. واذا كالو تمام بتعمل فينيش وبترجع للصفحة الي اجت منها الي هي صفحة الساين ان واذا لا بتروح بتعمل ال ايلس وبال ايلس في امر انو يبعتلنا زي هودعا لفترة زمنية معينة الي مكتوب فيها انو السيسما والايميل منحفظوش وبعدين بعد بفترة بتروح الهودعا
    {
        String email=etEmail2.getText().toString();
        String password=etPassword.getText().toString();
        String rePassword=etRepassword.getText().toString();

        boolean isOk=true;

        if(email.length()*password.length()*rePassword.length()==0)
        {
            etEmail2.setError("One of the files is empty");
        }

        if(password.equals(rePassword)==false) //بفحص اذا طول السيسما الاصلية وطول السيسما التاكيد نفس الطول اذا لا ببعتلنا زي هودعا انو في ارور وبصير فولس
        {
            etRepassword.setError("Is not equal to password");
            isOk=false;
        }

        if(isOk)
        {
            //بهادا الشرط اول اشي ببني كائن بعدين بقول لهاد الكائن يبني اكاونت الي فيو سيسما وايميل وبعدين بفحص اذا كلو تمام وناجح اذا اا ببعتلنا هودعا لفترة معينة من الوقت عن طريق توست الي مكتوب فيها انو السيسما والايميل انحفظو اذا لا بتروح على الايلس
            FirebaseAuth auth1=FirebaseAuth.getInstance(); //used for signing in, signing up and sign out
            auth1.createUserWithEmailAndPassword(email,password).
                    addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override

                /**
                 * onComplete is an event handler when the mession is completed
                 * task -بارامتر الحدث - معلومات عن الحدث
                 */
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()) // تفحص اذا بناء حساب تم بنجاح
                    {
                        Toast.makeText(SignUpActivity.this, "Email and password are saved", Toast.LENGTH_SHORT).show();
                        finish(); // يغلق الشاشة الحالية /
                    }
                    else {
                        //التوست بتعمل على انو تبعتلنا هودعا لفترة معينة من الوقت الي مكتوب فيها انو السيسما والايميل منحفظوش
                        Toast.makeText(SignUpActivity.this, "Saving the e-mail and passwrd is failed!"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                    }
                }
            });

        }





    }
}