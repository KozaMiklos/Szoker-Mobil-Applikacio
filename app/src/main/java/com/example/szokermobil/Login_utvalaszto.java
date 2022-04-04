package com.example.szokermobil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Login_utvalaszto extends AppCompatActivity {

    Button loginSzakmunkas, loginMegrendelo;

    @Override
    protected void  onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_utvalaszto);

        loginSzakmunkas = findViewById(R.id.loginSzakmunkas);
        loginMegrendelo = findViewById(R.id.loginMegrendelo);

        loginMegrendelo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View view){
                Intent intent = new Intent(getApplicationContext(), MegrendeloLogin.class);
                startActivity(intent);
                finish();
            }
        });

        loginSzakmunkas.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View view){
                Intent intent = new Intent(getApplicationContext(), SzakmunkasLogin.class);
                startActivity(intent);
                finish();
            }
        });
    }


}
