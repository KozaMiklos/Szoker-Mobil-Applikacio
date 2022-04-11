package com.example.szokermobil;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class SzakmunkasLogin extends AppCompatActivity {

    TextInputEditText editTextTextLoginEmail, editTextTextloginPassword;
    ProgressBar progressBar;
    Button Loginbutton;
    CheckBox SzakmunkasLoginCB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


        editTextTextLoginEmail = findViewById(R.id.emailLogin);
        editTextTextloginPassword = findViewById(R.id.passwordLogin);
        Loginbutton = findViewById(R.id.Loginbutton);
        progressBar = findViewById(R.id.progressBar);
        SzakmunkasLoginCB = findViewById(R.id.SzakmunkascheckBox);


        Loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email, password, email2, password2;
                email = String.valueOf(editTextTextLoginEmail.getText());
                email2 = String.valueOf(editTextTextLoginEmail.getText());
                password = String.valueOf(editTextTextloginPassword.getText());
                password2 = String.valueOf(editTextTextloginPassword.getText());


                if (!email2.equals("") && !password2.equals("")) {
                    progressBar.setVisibility(View.VISIBLE);
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            String[] field = new String[2];
                            field[0] = "email2";
                            field[1] = "password2";

                            String[] data = new String[2];
                            data[0] = email2;
                            data[1] = password2;

                            PutData putData = new PutData("http://10.0.11.114/reglog/loginSzakmunkas.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    progressBar.setVisibility(View.GONE);
                                    String result = putData.getResult();
                                    if (result.equals("Login Success")) {
                                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(), Szakmunkasok.class);
                                        startActivity(intent);
                                        finish();

                                    } else {
                                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                    }
                                    Log.i("PutData", result);
                                }
                            }
                        }
                    });
                } else {
                    Toast.makeText(getApplicationContext(), "All fields required!", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}