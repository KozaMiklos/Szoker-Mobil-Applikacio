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

    TextInputEditText textInputEditTextFullname, textInputEditTextUsername, textInputEditTextPassword, textInputEditTextEmail;
    Button registerButton;
    ProgressBar progressBar;
    CheckBox SzakmunkascheckBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        textInputEditTextFullname = findViewById(R.id.fullname);
        textInputEditTextUsername = findViewById(R.id.username);
        textInputEditTextPassword = findViewById(R.id.password);
        textInputEditTextEmail = findViewById(R.id.email);
        registerButton = findViewById(R.id.registerButton);
        progressBar = findViewById(R.id.progress);
        SzakmunkascheckBox = findViewById(R.id.SzakmunkascheckBox);


        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullname, username, password, email, fullname2, username2, password2, email2;
                fullname = String.valueOf(textInputEditTextFullname.getText());
                username = String.valueOf(textInputEditTextUsername.getText());
                password = String.valueOf(textInputEditTextPassword.getText());
                email = String.valueOf(textInputEditTextEmail.getText());

                fullname2 = String.valueOf(textInputEditTextFullname.getText());
                username2 = String.valueOf(textInputEditTextUsername.getText());
                password2 = String.valueOf(textInputEditTextPassword.getText());
                email2 = String.valueOf(textInputEditTextEmail.getText());

                if (SzakmunkascheckBox.isChecked()) {
                    if (!fullname2.equals("") && !username2.equals("") && !password2.equals("") && !email2.equals("")) {
                        progressBar.setVisibility(View.VISIBLE);
                        Handler handler = new Handler(Looper.getMainLooper());
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                //Starting Write and Read data with URL
                                //Creating array for parameters
                                String[] field = new String[4];
                                field[0] = "fullname2";
                                field[1] = "username2";
                                field[2] = "password2";
                                field[3] = "email2";
                                //Creating array for data
                                String[] data = new String[4];
                                data[0] = fullname2;
                                data[1] = username2;
                                data[2] = password2;
                                data[3] = email2;
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
                    if (!fullname.equals("") && !username.equals("") && !password.equals("") && !email.equals("")) {
                        progressBar.setVisibility(View.VISIBLE);
                        Handler handler = new Handler(Looper.getMainLooper());
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                //Starting Write and Read data with URL
                                //Creating array for parameters
                                String[] field = new String[4];
                                field[0] = "fullname";
                                field[1] = "username";
                                field[2] = "password";
                                field[3] = "email";
                                //Creating array for data
                                String[] data = new String[4];
                                data[0] = fullname;
                                data[1] = username;
                                data[2] = password;
                                data[3] = email;
                                //PutData putData = new PutData("http://localhost/registerlogin/signup.php", "POST", field, data);

                                PutData putData = new PutData("http://10.0.11.114/reglog/signup.php", "POST", field, data);


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
                }
            }


        });
    }
}