package com.example.tripity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.tripity.Adapters.PhoneUpdate;
import com.example.tripity.Adapters.ProfileUpdate;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProfileSetupActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText uname, emailAdd, age, nationality, identityNum;
    Spinner spinner;
    Button save;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_setup);
        uname = findViewById(R.id.username);
        emailAdd = findViewById(R.id.emailAdd);
        age = findViewById(R.id.Age);
        nationality = findViewById(R.id.nationality);
        identityNum = findViewById(R.id.idNumber);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Users");

        spinner = findViewById(R.id.identityType);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter
                .createFromResource(this, R.array.identityProof, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        save = findViewById(R.id.saveInfo);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!uname.getText().toString().trim().isEmpty()){

                    if (!emailAdd.getText().toString().trim().isEmpty()){

                        if (!age.getText().toString().trim().isEmpty()){

                            if (!nationality.getText().toString().trim().isEmpty()){

                                if (!identityNum.getText().toString().trim().isEmpty()){

                                    insertProfileData();
                                    Intent intent = new Intent(ProfileSetupActivity.this, DashboardActivity.class);
                                    startActivity(intent);
                                    finish();

                                }else {
                                    Toast.makeText(ProfileSetupActivity.this, "Enter Your Correct Information", Toast.LENGTH_LONG).show();
                                }

                            }else {
                                Toast.makeText(ProfileSetupActivity.this, "Enter Your Nationality", Toast.LENGTH_LONG).show();
                            }

                        }else {
                            Toast.makeText(ProfileSetupActivity.this, "Enter Your Age", Toast.LENGTH_LONG).show();
                        }

                    }else {
                        Toast.makeText(ProfileSetupActivity.this, "Enter Your Email", Toast.LENGTH_LONG).show();
                    }

                }else {
                    Toast.makeText(ProfileSetupActivity.this, "Enter Your Details", Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    //insert data to database
    private void insertProfileData() {

        SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor edit_details = preferences.edit();
        String userInput = preferences.getString("phone", "");

        String Phone = userInput;
        String name = uname.getText().toString();
        String Age = age.getText().toString();
        String email = emailAdd.getText().toString();
        String idProof = spinner.getSelectedItem().toString();
        String identity = identityNum.getText().toString();
        String nationlityType = nationality.getText().toString();

        edit_details.putString("Name",name);
        edit_details.putString("Age",Age);
        edit_details.putString("Email",email);
        edit_details.putString("Id",idProof);
        edit_details.putString("IdNum",identity);
        edit_details.putString("Nationlity",nationlityType);
        edit_details.apply();

        ProfileUpdate profileUpdate = new ProfileUpdate(name, email, Age, idProof, identity, nationlityType, Phone);
        databaseReference.push().setValue(profileUpdate);
        Toast.makeText(this, "Updated", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        String selected = adapterView.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}