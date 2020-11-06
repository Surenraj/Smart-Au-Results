package com.example.calcjit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

public class Cgpa extends AppCompatActivity implements AdapterView.OnItemSelectedListener  {
    Spinner Cgpadepartment,Cgpasemester;
    SharedPreferences sharedPreferences;

    Button BtnSubmit;
    private static final String SHARED_PREF_NAME2 = "mypref";
    private static final String KEY_CGPA_DEPARTMENT = "DEPARTMENT";
    private static final String KEY_CGPA_SEMESTER = "SEMESTER";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cgpa);

        BtnSubmit =findViewById(R.id.Cgpabtn_submit);
        Cgpadepartment = findViewById(R.id.cgpadepart_spinner);
        Cgpasemester = findViewById(R.id.cgpasem_spinner);
        Cgpadepartment.setOnItemSelectedListener(this);
        Cgpasemester.setOnItemSelectedListener(this);



        BtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cgpa.this,Cgpa2.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME2, MODE_PRIVATE);

        String item = adapterView.getSelectedItem().toString();
        if (item.equals("CSE")) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(KEY_CGPA_DEPARTMENT, item);
            editor.apply();
        }
        if (item.equals("IT")) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(KEY_CGPA_DEPARTMENT, item);
            editor.apply();
        }
        if (item.equals("ECE")) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(KEY_CGPA_DEPARTMENT, item);
            editor.apply();
        }
        if (item.equals("EEE")) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(KEY_CGPA_DEPARTMENT, item);
            editor.apply();
        }
        if (item.equals("Mechanical")) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(KEY_CGPA_DEPARTMENT, item);
            editor.apply();
        }
        if (item.equals("Semester 1")) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(KEY_CGPA_SEMESTER, item);
            editor.apply();
        }
        if (item.equals("Semester 2")) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(KEY_CGPA_SEMESTER, item);
            editor.apply();
        }
        if (item.equals("Semester 3")) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(KEY_CGPA_SEMESTER, item);
            editor.apply();
        }
        if (item.equals("Semester 4")) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(KEY_CGPA_SEMESTER, item);
            editor.apply();
        }
        if (item.equals("Semester 5")) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(KEY_CGPA_SEMESTER, item);
            editor.apply();
        }
        if (item.equals("Semester 6")) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(KEY_CGPA_SEMESTER, item);
            editor.apply();
        }
        if (item.equals("Semester 7")) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(KEY_CGPA_SEMESTER, item);
            editor.apply();
        }
        if (item.equals("Semester 8")) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(KEY_CGPA_SEMESTER, item);
            editor.apply();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}