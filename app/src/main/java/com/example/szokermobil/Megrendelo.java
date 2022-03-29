package com.example.szokermobil;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;
public class Megrendelo extends AppCompatActivity{
    TextView textViewMegrendeloNev;

    @SuppressLint("WrongViewCast")
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.megrendelok);
        textViewMegrendeloNev = findViewById(R.id.megrendeloCard);

        textViewMegrendeloNev.setText("Teszt Megrendelő");
    }
}
