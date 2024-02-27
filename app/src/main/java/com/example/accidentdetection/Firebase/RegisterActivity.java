package com.example.accidentdetection.Firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.accidentdetection.MainActivity;
import com.example.accidentdetection.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class RegisterActivity extends AppCompatActivity {
    private EditText mFullName,mEmail,mPassword,mConfPassword,mPhone;
    private Button mRegister;
    private TextView mGoToLogin;
    static int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mFullName =  findViewById(R.id.txt_name);
        mEmail =  findViewById(R.id.txt_email);
        mPassword =  findViewById(R.id.txt_password);
        mConfPassword = findViewById(R.id.txt_confirm_password);
        mPhone  = findViewById(R.id.txt_phone);

        mRegister =  findViewById(R.id.btn_register);

        mGoToLogin =  findViewById(R.id.textView_login);


        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //checking already logged in or not
                String fname =  mFullName.getText().toString().trim();
                String email =  mEmail.getText().toString().trim();
                String pass = mPassword.getText().toString().trim();
                String confirmpass =  mConfPassword.getText().toString().trim();
                String phone =  mPhone.getText().toString().trim();
                if(checkEmpty(fname, mFullName) || checkEmpty(email, mEmail) || checkEmpty(phone, mPhone) ||
                        checkEmpty(pass, mPassword) || checkEmpty(confirmpass, mConfPassword))
                    return;
                if(phone.length()!=10){
                    mPhone.setError("Invalid Number");
                    return;
                }
                if(pass.length() <6) {
                    mPassword.setError("Password should be minimum of 6 characters");
                    return;
                }
                if(!pass.equals(confirmpass)){
                    mConfPassword.setError("Password don't match");
                    return;
                }


            }
        });
        mGoToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        });
    }
    public Boolean checkEmpty(String s ,EditText et){
        if(TextUtils.isEmpty(s)){
            et.setError("This can't be Empty");
            return true;
        }
        return false;
    }
}