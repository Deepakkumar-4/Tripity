package com.example.tripity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class verificationActivity extends AppCompatActivity {

    EditText otp1, otp2, otp3, otp4, otp5, otp6;
    String OTPsent;
    ProgressBar progressBar;
    Button verify;
    TextView resendOTP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);

        otp1 = findViewById(R.id.Otpdigit1);
        otp2 = findViewById(R.id.Otpdigit2);
        otp3 = findViewById(R.id.Otpdigit3);
        otp4 = findViewById(R.id.Otpdigit4);
        otp5 = findViewById(R.id.Otpdigit5);
        otp6 = findViewById(R.id.Otpdigit6);
        progressBar = findViewById(R.id.OtpprogressBar);
        resendOTP = findViewById(R.id.ResendOtp);
        verify = findViewById(R.id.Verify);


        TextView textView = findViewById(R.id.mobileShow);
        textView.setText(String.format(getIntent().getStringExtra("mobile")));
        OTPsent = getIntent().getStringExtra("otp_sent");

        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (    !otp1.getText().toString().trim().isEmpty() &&
                        !otp2.getText().toString().trim().isEmpty() &&
                        !otp3.getText().toString().trim().isEmpty() &&
                        !otp4.getText().toString().trim().isEmpty() &&
                        !otp5.getText().toString().trim().isEmpty() &&
                        !otp6.getText().toString().trim().isEmpty()    )
                {
                    String OtpCode = otp1.getText().toString()+
                            otp2.getText().toString()+
                            otp3.getText().toString()+
                            otp4.getText().toString()+
                            otp5.getText().toString()+
                            otp6.getText().toString();

                    if (OTPsent != null){
                        progressBar.setVisibility(View.VISIBLE);
                        verify.setVisibility(View.INVISIBLE);
                        PhoneAuthCredential phoneAuthCredential = PhoneAuthProvider.getCredential(OTPsent,OtpCode);

                        FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential).addOnCompleteListener(new OnCompleteListener<AuthResult>()
                                {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        progressBar.setVisibility(View.GONE);
                                        verify.setVisibility(View.VISIBLE);
                                        if (task.isSuccessful()){

                                            Intent intent = new Intent(verificationActivity.this,ProfileSetupActivity.class);
                                            intent.setFlags( Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                            startActivity(intent);
                                            finish();
                                            // finish just finish the activity that is currently running
                                            // but finishAffinity finish all activity that are opened previously

                                        }else
                                        {
                                            Toast.makeText(getApplicationContext(), "Enter the correct OTP", Toast.LENGTH_LONG).show();
                                        }
                                    }
                                });

                    }else
                    {
                        Toast.makeText(verificationActivity.this, "Please check Internet connection", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(verificationActivity.this, "Enter OTP", Toast.LENGTH_LONG).show();
                }

            }
        });

        numberotmove();

        resendOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PhoneAuthProvider.getInstance().verifyPhoneNumber(

                        getIntent().getStringExtra("mobile"),
                        60,
                        TimeUnit.SECONDS,
                        verificationActivity.this,
                        new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {


                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {

                                Toast.makeText(verificationActivity.this, e.getMessage(),
                                        Toast.LENGTH_LONG).show();

                            }

                            @Override
                            public void onCodeSent(@NonNull String newBackEndOtp, @NonNull PhoneAuthProvider
                                    .ForceResendingToken forceResendingToken) {

                                OTPsent = newBackEndOtp;
                                Toast.makeText(verificationActivity.this, "OTP sent Successfully", Toast.LENGTH_SHORT).show();

                            }
                        }


                );
            }
        });


    }

    private void numberotmove() {

        otp1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (!charSequence.toString().trim().isEmpty()) {
                    otp2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }

        });
        otp2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (!charSequence.toString().trim().isEmpty()) {
                    otp3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }

        });
        otp3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (!charSequence.toString().trim().isEmpty()) {
                    otp4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }

        });
        otp4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (!charSequence.toString().trim().isEmpty()) {
                    otp5.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }

        });
        otp5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (!charSequence.toString().trim().isEmpty()) {
                    otp6.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }

        });

    }
}