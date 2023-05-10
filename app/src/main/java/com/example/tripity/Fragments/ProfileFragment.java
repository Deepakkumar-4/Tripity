package com.example.tripity.Fragments;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tripity.DashboardActivity;
import com.example.tripity.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class ProfileFragment extends Fragment {
    TextView name,age,email,idtype,idNum,nationality,phone;

    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users");

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences preferences = getActivity().getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String userId = preferences.getString("phone", "");

        readData(userId);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_profile,container,false);

        name = rootView.findViewById(R.id.profile_name);
        email = rootView.findViewById(R.id.profile_email);
        age = rootView.findViewById(R.id.profile_age);
        phone = rootView.findViewById(R.id.profile_phone);
        idtype = rootView.findViewById(R.id.profile_idtype);
        idNum = rootView.findViewById(R.id.profile_idnum);
        nationality = rootView.findViewById(R.id.profile_nationality);


        return rootView;
    }
    private void readData(String userId) {
        reference.child(userId).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {

                 if (task.isSuccessful()){

                     if (task.getResult().exists()){
                         Toast.makeText(getActivity(), "data Fetched", Toast.LENGTH_SHORT).show();

                         DataSnapshot snapshot = task.getResult();
                            name.setText(String.valueOf(snapshot.child("name").getValue()));
                            email.setText(String.valueOf(snapshot.child("email").getValue()));
                            phone.setText(String.valueOf(snapshot.child("phone").getValue()));
                            age.setText(String.valueOf(snapshot.child("age").getValue()));
                            idtype.setText(String.valueOf(snapshot.child("idtype").getValue()));
                            idNum.setText(String.valueOf(snapshot.child("idnum").getValue()));
                            nationality.setText(String.valueOf(snapshot.child("nationality").getValue()));

                     }else {
                         Toast.makeText(getActivity(), "data not found", Toast.LENGTH_SHORT).show();
                     }

                 }else{
                     Toast.makeText(getActivity(), "data not fetched", Toast.LENGTH_SHORT).show();
                 }

            }
        });

    }
}
