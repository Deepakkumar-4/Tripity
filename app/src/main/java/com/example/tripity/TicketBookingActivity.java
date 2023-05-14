package com.example.tripity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.tripity.Adapters.AddedPersonModel;
import com.example.tripity.Adapters.RecyclerAddedPerson;

import java.util.ArrayList;

public class TicketBookingActivity extends AppCompatActivity {

    Button proceed, addperson;
    RecyclerView added_persons;
    Spinner city, place;
    RecyclerAddedPerson addedpersonAdapter;

    ArrayList<AddedPersonModel> personList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_booking);

        addperson = findViewById(R.id.addperson);
        proceed = findViewById(R.id.proceed_to_payment);
        city = findViewById(R.id.city_spinner);
        ArrayAdapter<String> citydapter = new ArrayAdapter<>(TicketBookingActivity.this,
                android.R.layout.simple_spinner_item,
                getResources().getStringArray(R.array.Cities));
        citydapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        city.setAdapter(citydapter);

        place = findViewById(R.id.place_spinner);
        city.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedOption = parent.getItemAtPosition(position).toString();

                switch (selectedOption) {
                    case "Agra":
                        ArrayAdapter<CharSequence> adapter2_1 = ArrayAdapter.createFromResource(TicketBookingActivity.this, R.array.places_agra, android.R.layout.simple_spinner_item);
                        adapter2_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        place.setAdapter(adapter2_1);
                        break;

                    case "Delhi":
                        ArrayAdapter<CharSequence> adapter2_2 = ArrayAdapter.createFromResource(TicketBookingActivity.this, R.array.places_delhi, android.R.layout.simple_spinner_item);
                        adapter2_2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        place.setAdapter(adapter2_2);
                        break;
                    case "Aurangabad":
                        ArrayAdapter<CharSequence> adapter2_3 = ArrayAdapter.createFromResource(TicketBookingActivity.this, R.array.places_aurangabad, android.R.layout.simple_spinner_item);
                        adapter2_3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        place.setAdapter(adapter2_3);
                        break;
                    case "Chattarpur":
                        ArrayAdapter<CharSequence> adapter2_4 = ArrayAdapter.createFromResource(TicketBookingActivity.this, R.array.places_chattarpur, android.R.layout.simple_spinner_item);
                        adapter2_4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        place.setAdapter(adapter2_4);
                        break;

                    // add more cases for other options

                    default:
                        ArrayAdapter<CharSequence> adapter2_default = ArrayAdapter.createFromResource(TicketBookingActivity.this, R.array.select_city, android.R.layout.simple_spinner_item);
                        adapter2_default.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        place.setAdapter(adapter2_default);
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // do nothing
                Toast.makeText(TicketBookingActivity.this, "Please select an item", Toast.LENGTH_SHORT).show();

            }
        });



        added_persons = findViewById(R.id.added_persons);

        //adding person on button click
        addperson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dailog = new Dialog(TicketBookingActivity.this);
                dailog.setContentView(R.layout.add_person_dailog);
                EditText personName = dailog.findViewById(R.id.person_name);
                EditText personId = dailog.findViewById(R.id.person_id);
                Spinner ticketType = dailog.findViewById(R.id.ticketType);
                ArrayAdapter<String> adapter = new ArrayAdapter<>(TicketBookingActivity.this,
                        android.R.layout.simple_spinner_item,
                        getResources().getStringArray(R.array.Ticker_type));
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                ticketType.setAdapter(adapter);

                Button addperson = dailog.findViewById(R.id.addperson);
                Button dismiss = dailog.findViewById(R.id.dismiss);

                addperson.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                            String name = personName.getText().toString().trim();
                            String id = personId.getText().toString().trim();
                            String tickettype = ticketType.getSelectedItem().toString();

                            if (name.isEmpty()) {
                                Toast.makeText(TicketBookingActivity.this, "Enter person name", Toast.LENGTH_SHORT).show();
                            } else if (id.isEmpty()) {
                                Toast.makeText(TicketBookingActivity.this, "Enter person ID", Toast.LENGTH_SHORT).show();
                            } else {
                                // Add the person to the list
                                personList.add(new AddedPersonModel(name, id, tickettype));
                                addedpersonAdapter.notifyItemChanged(personList.size()-1);
                                added_persons.scrollToPosition(personList.size()-1);

                                dailog.dismiss();
                            }
                        }
                });
                dailog.show();
                dismiss.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dailog.dismiss();
                    }
                });
            }
        });

        added_persons.setLayoutManager(new LinearLayoutManager(this));
        addedpersonAdapter = new RecyclerAddedPerson(this,personList);
        added_persons.setAdapter(addedpersonAdapter);

    }
}