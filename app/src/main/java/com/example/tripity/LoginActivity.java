package com.example.tripity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class LoginActivity extends AppCompatActivity {

    Button login;
    EditText country, phoneNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.continueBtn);
        country = findViewById(R.id.countryCode);
        phoneNum = findViewById(R.id.mobileNum);

        final ProgressBar progressBar = findViewById(R.id.progressBar);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!phoneNum.getText().toString().trim().isEmpty()) {

                    if ((phoneNum.getText().toString().trim()).length() == 10) {

                        progressBar.setVisibility(View.VISIBLE);
                        login.setVisibility(View.INVISIBLE);


                        SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString("phone", country.getText().toString() + "-" + phoneNum.getText().toString());
                        editor.apply();

                        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                                country.getText().toString() + phoneNum.getText().toString(),
                                60,
                                TimeUnit.SECONDS,
                                LoginActivity.this,
                                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                                    @Override
                                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

                                        progressBar.setVisibility(View.GONE);
                                        login.setVisibility(View.VISIBLE);

                                    }

                                    @Override
                                    public void onVerificationFailed(@NonNull FirebaseException e) {
                                        progressBar.setVisibility(View.GONE);
                                        login.setVisibility(View.VISIBLE);
                                        Toast.makeText(LoginActivity.this, "Error check Internet Connection " + e.getMessage(), Toast.LENGTH_LONG).show();
                                    }

                                    @Override
                                    public void onCodeSent(@NonNull String otp, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                        progressBar.setVisibility(View.GONE);
                                        login.setVisibility(View.VISIBLE);
                                        Intent intent = new Intent(LoginActivity.this, verificationActivity.class);
                                        intent.putExtra("mobile", country.getText().toString() + "-" + phoneNum.getText().toString());
                                        intent.putExtra("otp_sent", otp);
                                        startActivity(intent);

                                    }

                                });
                    } else {
                        Toast.makeText(LoginActivity.this, "Please enter correct phone number", Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(LoginActivity.this, "Please enter phone number", Toast.LENGTH_LONG).show();
                }


            }

        });


    }
}