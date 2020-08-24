package com.example.kanishkaranu.newsshare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ListCategories1 extends AppCompatActivity {
    Button btn=null;
    Button btn1=null;
    Button btn2=null;
    Button btn3=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_categories1);
        btn=(Button)findViewById(R.id.button);
        btn1=(Button)findViewById(R.id.button5);
        btn2=(Button)findViewById(R.id.button6);
        btn3=(Button)findViewById(R.id.button7);

btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent recent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(recent);
        finish();


    }
});
btn2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent sports= new Intent(getApplicationContext(), Sports.class);
        startActivity(sports);
        finish();
    }
});
btn3.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent entertainment = new Intent(getApplicationContext(), Entertainment.class);
        startActivity(entertainment);
        finish();
    }
});
btn1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent business = new Intent(getApplicationContext(), Business.class);
        startActivity(business);
        finish();
    }
});


    }
    public void onBackPressed()
    {
        Intent welcome=new Intent(this,Welcome.class);
        startActivity(welcome);
        finish();
    }
}

