package com.example.pract16;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText edText;
    private TextView outputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edText = findViewById(R.id.editTextText);
        outputText = findViewById(R.id.selection);

        Button btnSave = findViewById(R.id.butSave);
        Button btnLoad = findViewById(R.id.butLoad);

        SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String savedText = preferences.getString("savedText", "");
        outputText.setText(savedText);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = edText.getText().toString();
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("savedText", text);
                editor.apply();
            }
        });

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String savedText = preferences.getString("savedText", "");
                outputText.setText(savedText);
            }
        });
    }
}

