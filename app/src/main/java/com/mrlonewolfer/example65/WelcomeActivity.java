package com.mrlonewolfer.example65;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    TextView txtName;
    UserBean userBean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide(); //hide the title bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_welcome);
        userBean= new UserBean();
        Intent intent=getIntent();
        userBean=intent.getParcelableExtra("UserData");
        txtName=findViewById(R.id.txtName);
        String name=userBean.getUname();
        txtName.setText(userBean.getUname());

    }
}
