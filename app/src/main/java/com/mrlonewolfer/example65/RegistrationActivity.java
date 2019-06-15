package com.mrlonewolfer.example65;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/*
Write a program you have to create a Registration, login and welcome activity.

  •In registration activity has data information (Name, Mobile, Email and password).
        Users have to register you and data will be stored in shared preference file.

  •In login activity user have to entered Email and password field and two buttons
            (Login, cancel).

  •On login button user entered email and password will be checked in
        shared  preference file if data matched and user name display on welcome activity.

  •In welcome activity have welcome username control and log out button.
        On logout  button click user will go on login activity.
 */
public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnsignUp;
    TextView txtLoginHere;
    EditText edtUserName,edtMobile,edtPassword,edtEmail;
    UserBean userBean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide(); //hide the title bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_registartion);

        edtUserName=findViewById(R.id.edtUserName);
        edtMobile=findViewById(R.id.edtMobile);
        edtEmail=findViewById(R.id.edtEmail);
        edtPassword=findViewById(R.id.edtPassword);

        btnsignUp=findViewById(R.id.btnSignUp);
        txtLoginHere=findViewById(R.id.txtLoginHere);
        txtLoginHere.setOnClickListener(this);
        btnsignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnSignUp){
            storeDataInSharedPrefrence();
        }
        if(v.getId()==R.id.txtLoginHere){
            Intent intent=new Intent(this,LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }

    private void storeDataInSharedPrefrence() {
        userBean= new UserBean();
        userBean.setUname(edtUserName.getText().toString());
        userBean.setEmail(edtEmail.getText().toString());
        userBean.setMobile(Long.valueOf(edtMobile.getText().toString()));
        userBean.setPassword(edtPassword.getText().toString());

        SharedPreferences sharedPreferences=getSharedPreferences(userBean.getEmail(),MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(Const.PREF_NAME,userBean.getUname());
        editor.putString(Const.PREF_PASSWORD,userBean.getPassword());
        editor.putString(Const.PREF_EMAIL,userBean.getEmail());
        editor.putLong(Const.PREF_MOBILE,userBean.getMobile());

        editor.commit();

        Toast.makeText(this, "Your Account is Created Please Login", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
