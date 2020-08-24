package com.example.kanishkaranu.newsshare;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Welcome extends AppCompatActivity {


    //final String TAG = this.getClass().getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);

        Button login = (Button) findViewById(R.id.etlogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open_login();
            }
        });

        Button sign = (Button) findViewById(R.id.etsignup);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open_signup();
            }
        });
    }


    public void open_login() {
        Intent intent = new Intent(this, SignIn.class);
        startActivity(intent);
        finish();
    }

    public void open_signup() {
        Intent intent1 = new Intent(this, SignUp.class);
        startActivity(intent1);
        finish();
    }
}