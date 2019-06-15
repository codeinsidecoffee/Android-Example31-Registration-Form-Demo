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
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtEmail,edtPassword;
    Button btnLogin,btnCancel;
    UserBean userBean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide(); //hide the title bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        edtEmail=findViewById(R.id.edtEmail);
        edtPassword=findViewById(R.id.edtPassword);
        btnLogin=findViewById(R.id.btnSignIn);
        btnCancel=findViewById(R.id.btnCancel);
        btnLogin.setOnClickListener(this);
        btnCancel.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnSignIn){
            checkUserLogin();

        }
        if(v.getId()==R.id.btnCancel){
            Intent intent=new Intent(this,RegistrationActivity.class);
            startActivity(intent);
            finish();
        }
    }

    private void checkUserLogin() {

        userBean=new UserBean();

        SharedPreferences sharedPreferences=getSharedPreferences(edtEmail.getText().toString(),MODE_PRIVATE);

        userBean.setUname(sharedPreferences.getString(Const.PREF_NAME,""));
        userBean.setEmail(sharedPreferences.getString(Const.PREF_EMAIL,""));
        userBean.setPassword(sharedPreferences.getString(Const.PREF_PASSWORD,""));

        if(
                (userBean.getEmail().equals(edtEmail.getText().toString())) &&
                        (userBean.getPassword().equals(edtPassword.getText().toString()))
            ){

            Toast.makeText(this, "You Logged In Succesfully", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(this,WelcomeActivity.class);
            intent.putExtra("UserData",userBean);
            startActivity(intent);
            finish();
        }
        else{
            Toast.makeText(this, "Access Denied \n " +
                    " Please Enter Valid Username and Password"  , Toast.LENGTH_SHORT).show();
        }


    }

}
