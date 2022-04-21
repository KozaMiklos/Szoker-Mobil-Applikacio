package com.example.szokermobil;

import androidx.appcompat.app.AppCompatActivity;

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

import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class Register extends AppCompatActivity {

    TextInputEditText textInputEditTextFullname, textInputEditTextEmail, textInputEditTextLokacio,textInputLayoutJelszo,textInputLayoutTelszam;
    Button registerButton;
    ProgressBar progressBar;
    CheckBox SzakmunkascheckBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        textInputEditTextFullname = findViewById(R.id.nev);
        textInputEditTextEmail = findViewById(R.id.email);
        textInputEditTextLokacio = findViewById(R.id.lokacio);
        textInputLayoutJelszo = findViewById(R.id.jelszo);
        textInputLayoutTelszam = findViewById(R.id.telefonszam);

        registerButton = findViewById(R.id.registerButton);
        progressBar = findViewById(R.id.progress);
        SzakmunkascheckBox = findViewById(R.id.SzakmunkascheckBox);


        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nev, lokacio, telefonszam, email, jelszo, lakcim;

                nev = String.valueOf(textInputEditTextFullname.getText());
                email = String.valueOf(textInputEditTextEmail.getText());
                lokacio = String.valueOf(textInputEditTextLokacio.getText());
                jelszo = String.valueOf(textInputLayoutJelszo.getText());
                telefonszam = String.valueOf(textInputLayoutTelszam.getText());
                lakcim = String.valueOf(textInputEditTextLokacio.getText());



                if (SzakmunkascheckBox.isChecked()) {
                    if (!nev.equals("") && !lokacio.equals("") && !telefonszam.equals("") && !email.equals("") && !jelszo.equals(""))  {
                        progressBar.setVisibility(View.VISIBLE);
                        Handler handler = new Handler(Looper.getMainLooper());
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                //Starting Write and Read data with URL
                                //Creating array for parameters
                                String[] field = new String[5];
                                field[0] = "nev";
                                field[1] = "lokacio";
                                field[2] = "telefonszam";
                                field[3] = "email";
                                field[4] = "jelszo";
                                //Creating array for data
                                String[] data = new String[5];
                                data[0] = nev;
                                data[1] = lokacio;
                                data[2] = telefonszam;
                                data[3] = email;
                                data[4] = jelszo;
                                //PutData putData = new PutData("http://localhost/registerlogin/signup.php", "POST", field, data);
                                PutData putData = new PutData("http://10.0.11.114/reglog/signupSzakmunkas.php", "POST", field, data);


                                if (putData.startPut()) {
                                    if (putData.onComplete()) {
                                        progressBar.setVisibility(View.GONE);
                                        String result = putData.getResult();
                                        if (result.equals("Sign Up Success")) {
                                            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                            Intent intent = new Intent(getApplicationContext(), SzakmunkasLogin.class);
                                            startActivity(intent);
                                            finish();
                                        } else {
                                            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                        }
                                        Log.i("PutData", result);
                                    }
                                }
                                //End Write and Read data with URL
                            }
                        });
                    } else {
                        Toast.makeText(getApplicationContext(), "All fields required!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    if (!email.equals("") && !jelszo.equals("") && !lakcim.equals("") && !nev.equals("") && !jelszo.equals(""))  {
                        progressBar.setVisibility(View.VISIBLE);
                        Handler handler = new Handler(Looper.getMainLooper());
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                //Starting Write and Read data with URL
                                //Creating array for parameters
                                String[] field = new String[5];
                                field[0] = "email";
                                field[1] = "jelszo";
                                field[2] = "lakcim";
                                field[3] = "nev";
                                field[4] = "telefonszam";
                                //Creating array for data
                                String[] data = new String[5];
                                data[0] = email;
                                data[1] = jelszo;
                                data[2] = lakcim;
                                data[3] = nev;
                                data[4] = telefonszam;
                                //PutData putData = new PutData("http://localhost/registerlogin/signup.php", "POST", field, data);

                                PutData putData = new PutData("http://10.0.11.114/reglog/signup.php", "POST", field, data);


                                if (putData.startPut()) {
                                    if (putData.onComplete()) {
                                        progressBar.setVisibility(View.GONE);
                                        String result = putData.getResult();
                                        if (result.equals("Sign Up Success")) {
                                            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                            Intent intent = new Intent(getApplicationContext(), MegrendeloLogin.class);
                                            startActivity(intent);
                                            finish();
                                        } else {
                                            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                        }
                                        Log.i("PutData", result);
                                    }
                                }
                                //End Write and Read data with URL
                            }
                        });
                    } else {
                        Toast.makeText(getApplicationContext(), "All fields required!", Toast.LENGTH_SHORT).show();
                    }
                }
            }


        });
    }
}