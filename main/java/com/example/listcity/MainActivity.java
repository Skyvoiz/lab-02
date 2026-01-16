package com.example.listcity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ListView cityList;
    ArrayAdapter<String> cityAdapter;
    ArrayList<String> dataList;
    Button addButton;
    Button deleteButton;
    Button confirmButton;
    EditText userInput;
    String userText = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityList = findViewById(R.id.city_list);
        addButton = findViewById((R.id.add_button));
        deleteButton = findViewById(R.id.delete_button);
        confirmButton = findViewById(R.id.confirm_button);
        userInput = findViewById(R.id.user_input);

        String []cities = {"Edmonton", "Vancouver", "Moscow", "Sydney", "Berlin", "Vienna", "Tokyo", "Beijing", "Osaka", "New Delhi"};

        dataList = new ArrayList<>();
        dataList.addAll(Arrays.asList(cities));

        cityAdapter = new ArrayAdapter<>(this, R.layout.content, dataList);
        cityList.setAdapter(cityAdapter);

        confirmButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 userText = userInput.getText().toString();
             }
         }
        );

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataList.add(userText);
                cityAdapter.notifyDataSetChanged();
            }
        }
        );

        deleteButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 dataList.remove(userText);
                 cityAdapter.notifyDataSetChanged();
             }
         }
        );

        };



}
