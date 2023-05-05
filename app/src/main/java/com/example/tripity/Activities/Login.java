package com.example.tripity.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.tripity.R;
import com.example.tripity.databinding.ActivityLoginBinding;

public class Login extends AppCompatActivity {

    private ActivityLoginBinding loginbinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        loginbinding =ActivityLoginBinding.inflate(getLayoutInflater());
    }
}