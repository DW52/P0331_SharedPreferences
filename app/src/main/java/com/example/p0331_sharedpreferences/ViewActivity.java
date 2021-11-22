package com.example.p0331_sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import android.widget.TextView;

public class ViewActivity extends Activity implements OnClickListener {

    TextView txtView;
    TextView txtView2;
    TextView txtView3;
    TextView txtView4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        txtView = (TextView) findViewById(R.id.tvView);
        txtView2 = (TextView) findViewById(R.id.tvView2);
        txtView3 = (TextView) findViewById(R.id.tvView3);
        txtView4 = (TextView) findViewById(R.id.tvView4);

        Intent intent = getIntent();
        String Login = intent.getStringExtra("login");
        String Password = intent.getStringExtra("password");
        String Email = intent.getStringExtra("email");
        String Phone = intent.getStringExtra("phone");

        txtView.setText("Log: " +Login);
        txtView2.setText("Pass: " +Password );
        txtView3.setText("Email: "+Email );
        txtView4.setText("Phone:  "+Phone );
    }
    @Override
    public  void onClick(View v){


    }
}
