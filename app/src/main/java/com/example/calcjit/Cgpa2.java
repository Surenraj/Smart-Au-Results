package com.example.calcjit;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Cgpa2 extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME2 = "mypref";
    private static final String KEY_CGPA_DEPARTMENT = "DEPARTMENT";
    private static final String KEY_CGPA_SEMESTER = "SEMESTER";


    EditText EditTextCgpa1;
    EditText EditTextCgpa2;
    EditText EditTextCgpa3;
    EditText EditTextCgpa4;
    EditText EditTextCgpa5;
    EditText EditTextCgpa6;
    EditText EditTextCgpa7;
    EditText EditTextCgpa8;

    LinearLayout Sem1Layout;
    LinearLayout SecondLayout1;
    LinearLayout Sem2Layout;
    LinearLayout SecondLayout2;
    LinearLayout Sem3Layout;
    LinearLayout Sem4Layout;
    LinearLayout Sem5Layout;
    LinearLayout Sem6Layout;
    LinearLayout Sem7Layout;
    LinearLayout Sem8Layout;
    int num;

    TextView TextCgpa;
    Button BtnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cgpa2);


        EditTextCgpa1 = findViewById(R.id.Edit_cgpa1);
        EditTextCgpa2 = findViewById(R.id.Edit_cgpa2);
        EditTextCgpa3 = findViewById(R.id.Edit_cgpa3);
        EditTextCgpa4 = findViewById(R.id.Edit_cgpa4);
        EditTextCgpa5 = findViewById(R.id.Edit_cgpa5);
        EditTextCgpa6 = findViewById(R.id.Edit_cgpa6);
        EditTextCgpa7 = findViewById(R.id.Edit_cgpa7);
        EditTextCgpa8 = findViewById(R.id.Edit_cgpa8);


        Sem1Layout = findViewById(R.id.sem1Layout);
        SecondLayout1 = findViewById(R.id.second_layout1);
        Sem2Layout = findViewById(R.id.sem2Layout);
        SecondLayout2 = findViewById(R.id.second_layout2);
        Sem3Layout = findViewById(R.id.sem3Layout);
        Sem4Layout = findViewById(R.id.sem4Layout);
        Sem5Layout = findViewById(R.id.sem5Layout);
        Sem6Layout = findViewById(R.id.sem6Layout);
        Sem7Layout = findViewById(R.id.sem7Layout);
        Sem8Layout = findViewById(R.id.sem8Layout);

        TextCgpa = findViewById(R.id.textCalculateCGPA);

        BtnCalculate = findViewById(R.id.btn_cgpa);
        AlertDialog.Builder builder = new AlertDialog.Builder(Cgpa2.this);

        builder.setMessage("Are you a Lateral entry Student?")
                .setTitle("Attention")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Sem1Layout.setVisibility(View.GONE);
                        SecondLayout1.setVisibility(View.VISIBLE);
                        Sem2Layout.setVisibility(View.GONE);
                        SecondLayout2.setVisibility(View.VISIBLE);
                        EditTextCgpa1.setText(null);
                        EditTextCgpa2.setText(null);
                        num = 1;
                    }
                }).setCancelable(false)
                .setNegativeButton("No", null).setCancelable(false);
        AlertDialog alert = builder.create();
        alert.show();


        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME2, Context.MODE_PRIVATE);
        String department = sharedPreferences.getString(KEY_CGPA_DEPARTMENT, null);
        String semester = sharedPreferences.getString(KEY_CGPA_SEMESTER, null);
        final String value = department + semester;

        BtnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (value.equals("CSESemester 2")) {

                    if (num == 0) {
                        String temp1 = EditTextCgpa1.getText().toString();
                        String temp2 = EditTextCgpa2.getText().toString();
                        if ((temp1.isEmpty()) || (temp2.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your GPAs!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        } else {
                            double Cgpa1 = Double.parseDouble(temp1);
                            double CGpa2 = Double.parseDouble(temp2);
                            double total = (Cgpa1 * 25 + CGpa2 * 24) / 49;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }
                    }
                    if (num == 1) {
                        Toast.makeText(Cgpa2.this, "Sorry, you don't have any CGPA!!", Toast.LENGTH_SHORT).show();
                        TextCgpa.setText("0.0");
                    }
                }
                if (value.equals("CSESemester 3")) {

                    if (num == 0) {
                        String temp1 = EditTextCgpa1.getText().toString();
                        String temp2 = EditTextCgpa2.getText().toString();
                        String temp3 = EditTextCgpa3.getText().toString();

                        if ((temp1.isEmpty()) || (temp2.isEmpty()) || (temp3.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your GPAs!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        } else {
                            double Cgpa1 = Double.parseDouble(temp1);
                            double Cgpa2 = Double.parseDouble(temp2);
                            double Cgpa3 = Double.parseDouble(temp3);

                            double total = (Cgpa1 * 25 + Cgpa2 * 24 + Cgpa3 * 25) / 74;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }
                    }
                    if (num == 1) {
                        String temp3 = EditTextCgpa3.getText().toString();
                        if ((temp3.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your 3rd Semester GPA!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        } else {
                            double Cgpa1 = 0;
                            double Cgpa2 = 0;
                            double Cgpa3 = Double.parseDouble(temp3);
                            double total = (Cgpa1 * 25 + Cgpa2 * 24 + Cgpa3 * 25) / 25;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }
                    }
                }
                if (value.equals("CSESemester 4")) {
                    if (num == 0) {
                        String temp1 = EditTextCgpa1.getText().toString();
                        String temp2 = EditTextCgpa2.getText().toString();
                        String temp3 = EditTextCgpa3.getText().toString();
                        String temp4 = EditTextCgpa4.getText().toString();
                        if ((temp1.isEmpty()) || (temp2.isEmpty()) || (temp3.isEmpty()) || (temp4.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your GPAs!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        } else {
                            double Cgpa1 = Double.parseDouble(temp1);
                            double Cgpa2 = Double.parseDouble(temp2);
                            double Cgpa3 = Double.parseDouble(temp3);
                            double Cgpa4 = Double.parseDouble(temp4);

                            double total = (Cgpa1 * 25 + Cgpa2 * 24 + Cgpa3 * 25 + Cgpa4 * 24) / 98;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }
                    }
                    if (num == 1) {
                        String temp3 = EditTextCgpa3.getText().toString();
                        String temp4 = EditTextCgpa4.getText().toString();
                        if ((temp3.isEmpty()) || (temp4.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your GPAs!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        } else {
                            double Cgpa1 = 0;
                            double Cgpa2 = 0;
                            double Cgpa3 = Double.parseDouble(temp3);
                            double Cgpa4 = Double.parseDouble(temp4);

                            double total = (Cgpa1 * 25 + Cgpa2 * 24 + Cgpa3 * 25 + Cgpa4 * 24) / 49;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }
                    }
                }
                if (value.equals("CSESemester 5")) {

                    if (num == 0) {
                        String temp1 = EditTextCgpa1.getText().toString();
                        String temp2 = EditTextCgpa2.getText().toString();
                        String temp3 = EditTextCgpa3.getText().toString();
                        String temp4 = EditTextCgpa4.getText().toString();
                        String temp5 = EditTextCgpa5.getText().toString();

                        if ((temp1.isEmpty()) || (temp2.isEmpty()) || (temp3.isEmpty()) || (temp4.isEmpty()) || (temp5.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your GPAs!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        } else {
                            double Cgpa1 = Double.parseDouble(temp1);
                            double Cgpa2 = Double.parseDouble(temp2);
                            double Cgpa3 = Double.parseDouble(temp3);
                            double Cgpa4 = Double.parseDouble(temp4);
                            double Cgpa5 = Double.parseDouble(temp5);

                            double total = (Cgpa1 * 25 + Cgpa2 * 24 + Cgpa3 * 25 + Cgpa4 * 24 + Cgpa5 * 25) / 123;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }

                    }
                    if (num == 1) {

                        String temp3 = EditTextCgpa3.getText().toString();
                        String temp4 = EditTextCgpa4.getText().toString();
                        String temp5 = EditTextCgpa5.getText().toString();

                        if ((temp4.isEmpty()) || (temp5.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your GPAs!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        } else {
                            double Cgpa1 = 0;
                            double Cgpa2 = 0;
                            double Cgpa3 = Double.parseDouble(temp3);
                            double Cgpa4 = Double.parseDouble(temp4);
                            double Cgpa5 = Double.parseDouble(temp5);

                            double total = (Cgpa1 * 25 + Cgpa2 * 24 + Cgpa3 * 25 + Cgpa4 * 24 + Cgpa5 * 25) / 74;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }
                    }

                }
                if (value.equals("CSESemester 6")) {
                    if (num == 0) {
                        String temp1 = EditTextCgpa1.getText().toString();
                        String temp2 = EditTextCgpa2.getText().toString();
                        String temp3 = EditTextCgpa3.getText().toString();
                        String temp4 = EditTextCgpa4.getText().toString();
                        String temp5 = EditTextCgpa5.getText().toString();
                        String temp6 = EditTextCgpa6.getText().toString();
                        if ((temp1.isEmpty()) || (temp2.isEmpty()) || (temp3.isEmpty()) ||
                                (temp4.isEmpty()) || (temp5.isEmpty()) || (temp6.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your GPAs!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        } else {
                            double Cgpa1 = Double.parseDouble(temp1);
                            double Cgpa2 = Double.parseDouble(temp2);
                            double Cgpa3 = Double.parseDouble(temp3);
                            double Cgpa4 = Double.parseDouble(temp4);
                            double Cgpa5 = Double.parseDouble(temp5);
                            double Cgpa6 = Double.parseDouble(temp6);

                            double total = (Cgpa1 * 25 + Cgpa2 * 24 + Cgpa3 * 25 + Cgpa4 * 24 + Cgpa5 * 25 + Cgpa6 * 25) / 148;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }

                    }
                    if (num == 1) {

                        String temp3 = EditTextCgpa3.getText().toString();
                        String temp4 = EditTextCgpa4.getText().toString();
                        String temp5 = EditTextCgpa5.getText().toString();
                        String temp6 = EditTextCgpa6.getText().toString();
                        if ((temp3.isEmpty()) || (temp4.isEmpty()) || (temp5.isEmpty()) || (temp6.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your GPAs!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        } else {
                            double Cgpa1 = 0;
                            double Cgpa2 = 0;
                            double Cgpa3 = Double.parseDouble(temp3);
                            double Cgpa4 = Double.parseDouble(temp4);
                            double Cgpa5 = Double.parseDouble(temp5);
                            double Cgpa6 = Double.parseDouble(temp6);

                            double total = (Cgpa1 * 25 + Cgpa2 * 24 + Cgpa3 * 25 + Cgpa4 * 24 + Cgpa5 * 25 + Cgpa6 * 25) / 99;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }
                    }
                }
                if (value.equals("CSESemester 7")) {

                    if (num == 0) {
                        String temp1 = EditTextCgpa1.getText().toString();
                        String temp2 = EditTextCgpa2.getText().toString();
                        String temp3 = EditTextCgpa3.getText().toString();
                        String temp4 = EditTextCgpa4.getText().toString();
                        String temp5 = EditTextCgpa5.getText().toString();
                        String temp6 = EditTextCgpa6.getText().toString();
                        String temp7 = EditTextCgpa7.getText().toString();
                        if ((temp1.isEmpty()) || (temp2.isEmpty()) || (temp3.isEmpty()) ||
                                (temp4.isEmpty()) || (temp5.isEmpty()) || (temp6.isEmpty()) || (temp7.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your GPAs!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        } else {
                            double Cgpa1 = Double.parseDouble(temp1);
                            double Cgpa2 = Double.parseDouble(temp2);
                            double Cgpa3 = Double.parseDouble(temp3);
                            double Cgpa4 = Double.parseDouble(temp4);
                            double Cgpa5 = Double.parseDouble(temp5);
                            double Cgpa6 = Double.parseDouble(temp6);
                            double Cgpa7 = Double.parseDouble(temp7);

                            double total = (Cgpa1 * 25 + Cgpa2 * 24 + Cgpa3 * 25 + Cgpa4 * 24 +
                                    Cgpa5 * 25 + Cgpa6 * 25 + Cgpa7 * 22) / 170;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }
                    }
                    if (num == 1) {

                        String temp3 = EditTextCgpa3.getText().toString();
                        String temp4 = EditTextCgpa4.getText().toString();
                        String temp5 = EditTextCgpa5.getText().toString();
                        String temp6 = EditTextCgpa6.getText().toString();
                        String temp7 = EditTextCgpa7.getText().toString();
                        if ((temp3.isEmpty()) || (temp4.isEmpty()) || (temp5.isEmpty()) || (temp6.isEmpty()) || (temp7.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your GPAs!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        } else {
                            double Cgpa1 = 0;
                            double Cgpa2 = 0;
                            double Cgpa3 = Double.parseDouble(temp3);
                            double Cgpa4 = Double.parseDouble(temp4);
                            double Cgpa5 = Double.parseDouble(temp5);
                            double Cgpa6 = Double.parseDouble(temp6);
                            double Cgpa7 = Double.parseDouble(temp7);

                            double total = (Cgpa1 * 25 + Cgpa2 * 24 + Cgpa3 * 25 + Cgpa4 * 24 +
                                    Cgpa5 * 25 + Cgpa6 * 25 + Cgpa7 * 22) / 121;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }
                    }
                }
                if (value.equals("CSESemester 8")) {
                    if (num == 0) {
                        String temp1 = EditTextCgpa1.getText().toString();
                        String temp2 = EditTextCgpa2.getText().toString();
                        String temp3 = EditTextCgpa3.getText().toString();
                        String temp4 = EditTextCgpa4.getText().toString();
                        String temp5 = EditTextCgpa5.getText().toString();
                        String temp6 = EditTextCgpa6.getText().toString();
                        String temp7 = EditTextCgpa7.getText().toString();
                        String temp8 = EditTextCgpa8.getText().toString();
                        if ((temp1.isEmpty()) || (temp2.isEmpty()) || (temp3.isEmpty()) ||
                                (temp4.isEmpty()) || (temp5.isEmpty()) || (temp6.isEmpty()) || (temp7.isEmpty()) || (temp8.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your GPAs!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        } else {
                            double Cgpa1 = Double.parseDouble(temp1);
                            double Cgpa2 = Double.parseDouble(temp2);
                            double Cgpa3 = Double.parseDouble(temp3);
                            double Cgpa4 = Double.parseDouble(temp4);
                            double Cgpa5 = Double.parseDouble(temp5);
                            double Cgpa6 = Double.parseDouble(temp6);
                            double Cgpa7 = Double.parseDouble(temp7);
                            double Cgpa8 = Double.parseDouble(temp8);

                            double total = (Cgpa1 * 25 + Cgpa2 * 24 + Cgpa3 * 25 + Cgpa4 * 24 +
                                    Cgpa5 * 25 + Cgpa6 * 25 + Cgpa7 * 22 + Cgpa8 * 16) / 186;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }
                    }
                    if (num == 1) {

                        String temp3 = EditTextCgpa3.getText().toString();
                        String temp4 = EditTextCgpa4.getText().toString();
                        String temp5 = EditTextCgpa5.getText().toString();
                        String temp6 = EditTextCgpa6.getText().toString();
                        String temp7 = EditTextCgpa7.getText().toString();
                        String temp8 = EditTextCgpa8.getText().toString();
                        if ((temp3.isEmpty()) || (temp4.isEmpty()) || (temp5.isEmpty()) || (temp6.isEmpty()) || (temp7.isEmpty()) || (temp8.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your GPAs!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        } else {
                            double Cgpa1 = 0;
                            double Cgpa2 = 0;
                            double Cgpa3 = Double.parseDouble(temp3);
                            double Cgpa4 = Double.parseDouble(temp4);
                            double Cgpa5 = Double.parseDouble(temp5);
                            double Cgpa6 = Double.parseDouble(temp6);
                            double Cgpa7 = Double.parseDouble(temp7);
                            double Cgpa8 = Double.parseDouble(temp8);

                            double total = (Cgpa1 * 25 + Cgpa2 * 24 + Cgpa3 * 25 + Cgpa4 * 24 +
                                    Cgpa5 * 25 + Cgpa6 * 25 + Cgpa7 * 22 + Cgpa8 * 16) / 137;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }
                    }
                }

                if (value.equals("ITSemester 2")) {
                    if (num == 0) {
                        String temp1 = EditTextCgpa1.getText().toString();
                        String temp2 = EditTextCgpa2.getText().toString();
                        if ((temp1.isEmpty()) || (temp2.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your GPAs!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        } else {
                            double Cgpa1 = Double.parseDouble(temp1);
                            double Cgpa2 = Double.parseDouble(temp2);

                            double total = (Cgpa1 * 25 + Cgpa2 * 24) / 49;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }
                    }
                    if (num == 1) {
                        Toast.makeText(Cgpa2.this, "Sorry, you don't have any CGPA!!", Toast.LENGTH_SHORT).show();
                        TextCgpa.setText("0.0");
                    }
                }
                if (value.equals("ITSemester 3")) {
                    if (num == 0) {
                        String temp1 = EditTextCgpa1.getText().toString();
                        String temp2 = EditTextCgpa2.getText().toString();
                        String temp3 = EditTextCgpa3.getText().toString();
                        if ((temp1.isEmpty()) || (temp2.isEmpty()) || (temp3.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your GPAs!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        } else {
                            double Cgpa1 = Double.parseDouble(temp1);
                            double Cgpa2 = Double.parseDouble(temp2);
                            double Cgpa3 = Double.parseDouble(temp3);

                            double total = (Cgpa1 * 25 + Cgpa2 * 24 + Cgpa3 * 24) / 73;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }
                    }
                    if (num == 1) {
                        String temp3 = EditTextCgpa3.getText().toString();
                        if ((temp3.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your 3rd Semester GPA!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        } else {
                            double Cgpa1 = 0;
                            double Cgpa2 = 0;
                            double Cgpa3 = Double.parseDouble(temp3);

                            double total = (Cgpa1 * 25 + Cgpa2 * 24 + Cgpa3 * 24) / 24;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }
                    }
                }
                if (value.equals("ITSemester 4")) {

                    if (num == 0) {
                        String temp1 = EditTextCgpa1.getText().toString();
                        String temp2 = EditTextCgpa2.getText().toString();
                        String temp3 = EditTextCgpa3.getText().toString();
                        String temp4 = EditTextCgpa4.getText().toString();
                        if ((temp1.isEmpty()) || (temp2.isEmpty()) || (temp3.isEmpty()) || (temp4.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your GPAs!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        } else {
                            double Cgpa1 = Double.parseDouble(temp1);
                            double Cgpa2 = Double.parseDouble(temp2);
                            double Cgpa3 = Double.parseDouble(temp3);
                            double Cgpa4 = Double.parseDouble(temp4);
                            double total = (Cgpa1 * 25 + Cgpa2 * 24 + Cgpa3 * 24 + Cgpa4 * 24) / 97;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }
                    }
                    if (num == 1) {

                        String temp3 = EditTextCgpa3.getText().toString();
                        String temp4 = EditTextCgpa4.getText().toString();
                        if ((temp3.isEmpty()) || (temp4.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your GPAs!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        } else {
                            double Cgpa1 = 0;
                            double Cgpa2 = 0;
                            double Cgpa3 = Double.parseDouble(temp3);
                            double Cgpa4 = Double.parseDouble(temp4);
                            double total = (Cgpa1 * 25 + Cgpa2 * 24 + Cgpa3 * 24 + Cgpa4 * 24) / 48;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }
                    }


                }
                if (value.equals("ITSemester 5")) {
                    if (num == 0) {
                        String temp1 = EditTextCgpa1.getText().toString();
                        String temp2 = EditTextCgpa2.getText().toString();
                        String temp3 = EditTextCgpa3.getText().toString();
                        String temp4 = EditTextCgpa4.getText().toString();
                        String temp5 = EditTextCgpa5.getText().toString();

                        if ((temp1.isEmpty()) || (temp2.isEmpty()) || (temp3.isEmpty()) || (temp4.isEmpty()) || (temp5.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your GPAs!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        } else {
                            double Cgpa1 = Double.parseDouble(temp1);
                            double Cgpa2 = Double.parseDouble(temp2);
                            double Cgpa3 = Double.parseDouble(temp3);
                            double Cgpa4 = Double.parseDouble(temp4);
                            double Cgpa5 = Double.parseDouble(temp5);

                            double total = (Cgpa1 * 25 + Cgpa2 * 24 + Cgpa3 * 24 + Cgpa4 * 24 + Cgpa5 * 25) / 122;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }
                    }
                    if (num == 1) {
                        String temp3 = EditTextCgpa3.getText().toString();
                        String temp4 = EditTextCgpa4.getText().toString();
                        String temp5 = EditTextCgpa5.getText().toString();

                        if ((temp3.isEmpty()) || (temp4.isEmpty()) || (temp5.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your GPAs!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        } else {
                            double Cgpa1 = 0;
                            double Cgpa2 = 0;
                            double Cgpa3 = Double.parseDouble(temp3);
                            double Cgpa4 = Double.parseDouble(temp4);
                            double Cgpa5 = Double.parseDouble(temp5);

                            double total = (Cgpa1 * 25 + Cgpa2 * 24 + Cgpa3 * 24 + Cgpa4 * 24 + Cgpa5 * 25) / 73;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }
                    }
                }
                if (value.equals("ITSemester 6")) {
                    if (num == 0) {
                        String temp1 = EditTextCgpa1.getText().toString();
                        String temp2 = EditTextCgpa2.getText().toString();
                        String temp3 = EditTextCgpa3.getText().toString();
                        String temp4 = EditTextCgpa4.getText().toString();
                        String temp5 = EditTextCgpa5.getText().toString();
                        String temp6 = EditTextCgpa6.getText().toString();
                        if ((temp1.isEmpty()) || (temp2.isEmpty()) || (temp3.isEmpty()) ||
                                (temp4.isEmpty()) || (temp5.isEmpty()) || (temp6.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your GPAs!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        } else {
                            double Cgpa1 = Double.parseDouble(temp1);
                            double Cgpa2 = Double.parseDouble(temp2);
                            double Cgpa3 = Double.parseDouble(temp3);
                            double Cgpa4 = Double.parseDouble(temp4);
                            double Cgpa5 = Double.parseDouble(temp5);
                            double Cgpa6 = Double.parseDouble(temp6);

                            double total = (Cgpa1 * 25 + Cgpa2 * 24 + Cgpa3 * 24 + Cgpa4 * 24 + Cgpa5 * 25 + Cgpa6 * 24) / 146;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }
                    }
                    if (num == 1) {

                        String temp3 = EditTextCgpa3.getText().toString();
                        String temp4 = EditTextCgpa4.getText().toString();
                        String temp5 = EditTextCgpa5.getText().toString();
                        String temp6 = EditTextCgpa6.getText().toString();
                        if ((temp3.isEmpty()) || (temp4.isEmpty()) || (temp5.isEmpty()) || (temp6.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your GPAs!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        } else {
                            double Cgpa1 = 0;
                            double Cgpa2 = 0;
                            double Cgpa3 = Double.parseDouble(temp3);
                            double Cgpa4 = Double.parseDouble(temp4);
                            double Cgpa5 = Double.parseDouble(temp5);
                            double Cgpa6 = Double.parseDouble(temp6);

                            double total = (Cgpa1 * 25 + Cgpa2 * 24 + Cgpa3 * 24 + Cgpa4 * 24 + Cgpa5 * 25 + Cgpa6 * 24) / 97;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }
                    }
                }
                if (value.equals("ITSemester 7")) {
                    if (num == 0) {
                        String temp1 = EditTextCgpa1.getText().toString();
                        String temp2 = EditTextCgpa2.getText().toString();
                        String temp3 = EditTextCgpa3.getText().toString();
                        String temp4 = EditTextCgpa4.getText().toString();
                        String temp5 = EditTextCgpa5.getText().toString();
                        String temp6 = EditTextCgpa6.getText().toString();
                        String temp7 = EditTextCgpa7.getText().toString();
                        if ((temp1.isEmpty()) || (temp2.isEmpty()) || (temp3.isEmpty()) ||
                                (temp4.isEmpty()) || (temp5.isEmpty()) || (temp6.isEmpty()) || (temp7.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your GPAs!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        } else {

                            double Cgpa1 = Double.parseDouble(temp1);
                            double Cgpa2 = Double.parseDouble(temp2);
                            double Cgpa3 = Double.parseDouble(temp3);
                            double Cgpa4 = Double.parseDouble(temp4);
                            double Cgpa5 = Double.parseDouble(temp5);
                            double Cgpa6 = Double.parseDouble(temp6);
                            double Cgpa7 = Double.parseDouble(temp7);

                            double total = (Cgpa1 * 25 + Cgpa2 * 24 + Cgpa3 * 24 + Cgpa4 * 24 + Cgpa5 * 25 + Cgpa6 * 24 + Cgpa7 * 22) / 168;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }
                    }
                    if (num == 1) {
                        String temp3 = EditTextCgpa3.getText().toString();
                        String temp4 = EditTextCgpa4.getText().toString();
                        String temp5 = EditTextCgpa5.getText().toString();
                        String temp6 = EditTextCgpa6.getText().toString();
                        String temp7 = EditTextCgpa7.getText().toString();
                        if ((temp3.isEmpty()) || (temp4.isEmpty()) || (temp5.isEmpty()) || (temp6.isEmpty()) || (temp7.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your GPAs!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        } else {

                            double Cgpa1 = 0;
                            double Cgpa2 = 0;
                            double Cgpa3 = Double.parseDouble(temp3);
                            double Cgpa4 = Double.parseDouble(temp4);
                            double Cgpa5 = Double.parseDouble(temp5);
                            double Cgpa6 = Double.parseDouble(temp6);
                            double Cgpa7 = Double.parseDouble(temp7);

                            double total = (Cgpa1 * 25 + Cgpa2 * 24 + Cgpa3 * 24 + Cgpa4 * 24 + Cgpa5 * 25 + Cgpa6 * 24 + Cgpa7 * 22) / 119;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }
                    }
                }
                if (value.equals("ITSemester 8")) {
                    if (num == 0) {
                        String temp1 = EditTextCgpa1.getText().toString();
                        String temp2 = EditTextCgpa2.getText().toString();
                        String temp3 = EditTextCgpa3.getText().toString();
                        String temp4 = EditTextCgpa4.getText().toString();
                        String temp5 = EditTextCgpa5.getText().toString();
                        String temp6 = EditTextCgpa6.getText().toString();
                        String temp7 = EditTextCgpa7.getText().toString();
                        String temp8 = EditTextCgpa8.getText().toString();
                        if ((temp1.isEmpty()) || (temp2.isEmpty()) || (temp3.isEmpty()) ||
                                (temp4.isEmpty()) || (temp5.isEmpty()) || (temp6.isEmpty()) || (temp7.isEmpty()) || (temp8.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your GPAs!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        } else {

                            double Cgpa1 = Double.parseDouble(temp1);
                            double Cgpa2 = Double.parseDouble(temp2);
                            double Cgpa3 = Double.parseDouble(temp3);
                            double Cgpa4 = Double.parseDouble(temp4);
                            double Cgpa5 = Double.parseDouble(temp5);
                            double Cgpa6 = Double.parseDouble(temp6);
                            double Cgpa7 = Double.parseDouble(temp7);
                            double Cgpa8 = Double.parseDouble(temp8);

                            double total = (Cgpa1 * 25 + Cgpa2 * 24 + Cgpa3 * 24 + Cgpa4 * 24 + Cgpa5 * 25 + Cgpa6 * 24 + Cgpa7 * 22 + Cgpa8 * 16) / 184;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }
                    }
                    if (num == 1) {
                        String temp3 = EditTextCgpa3.getText().toString();
                        String temp4 = EditTextCgpa4.getText().toString();
                        String temp5 = EditTextCgpa5.getText().toString();
                        String temp6 = EditTextCgpa6.getText().toString();
                        String temp7 = EditTextCgpa7.getText().toString();
                        String temp8 = EditTextCgpa8.getText().toString();
                        if ((temp3.isEmpty()) || (temp4.isEmpty()) || (temp5.isEmpty()) || (temp6.isEmpty()) || (temp7.isEmpty()) || (temp8.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your GPAs!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        } else {

                            double Cgpa1 = 0;
                            double Cgpa2 = 0;
                            double Cgpa3 = Double.parseDouble(temp3);
                            double Cgpa4 = Double.parseDouble(temp4);
                            double Cgpa5 = Double.parseDouble(temp5);
                            double Cgpa6 = Double.parseDouble(temp6);
                            double Cgpa7 = Double.parseDouble(temp7);
                            double Cgpa8 = Double.parseDouble(temp8);

                            double total = (Cgpa1 * 25 + Cgpa2 * 24 + Cgpa3 * 24 + Cgpa4 * 24 +
                                    Cgpa5 * 25 + Cgpa6 * 24 + Cgpa7 * 22 + Cgpa8 * 16) / 135;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }
                    }
                }

                if (value.equals("ECESemester 2")) {
                    if (num == 0) {
                        String temp1 = EditTextCgpa1.getText().toString();
                        String temp2 = EditTextCgpa2.getText().toString();
                        if ((temp1.isEmpty()) || (temp2.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your GPAs!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        } else {
                            double Cgpa1 = Double.parseDouble(temp1);
                            double Cgpa2 = Double.parseDouble(temp2);

                            double total = (Cgpa1 * 25 + Cgpa2 * 24) / 49;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }
                    }
                    if (num == 1) {
                        Toast.makeText(Cgpa2.this, "Sorry, you don't have any CGPA!!", Toast.LENGTH_SHORT).show();
                        TextCgpa.setText("0.0");
                    }

                }
                if (value.equals("ECESemester 3")) {
                    if (num == 0) {
                        String temp1 = EditTextCgpa1.getText().toString();
                        String temp2 = EditTextCgpa2.getText().toString();
                        String temp3 = EditTextCgpa3.getText().toString();
                        if ((temp1.isEmpty()) || (temp2.isEmpty()) || (temp3.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your GPAs!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        } else {
                            double Cgpa1 = Double.parseDouble(temp1);
                            double Cgpa2 = Double.parseDouble(temp2);
                            double Cgpa3 = Double.parseDouble(temp3);

                            double total = (Cgpa1 * 25 + Cgpa2 * 24 + Cgpa3 * 25) / 74;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }
                    }
                    if (num == 1) {
                        String temp3 = EditTextCgpa3.getText().toString();
                        if ((temp3.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your 3rd Semester GPA!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        } else {
                            double Cgpa1 = 0;
                            double Cgpa2 = 0;
                            double Cgpa3 = Double.parseDouble(temp3);

                            double total = (Cgpa1 * 25 + Cgpa2 * 24 + Cgpa3 * 25) / 25;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }
                    }
                }
                if (value.equals("ECESemester 4")) {
                    if (num == 0) {
                        String temp1 = EditTextCgpa1.getText().toString();
                        String temp2 = EditTextCgpa2.getText().toString();
                        String temp3 = EditTextCgpa3.getText().toString();
                        String temp4 = EditTextCgpa4.getText().toString();
                        if ((temp1.isEmpty()) || (temp2.isEmpty()) || (temp3.isEmpty()) || (temp4.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your GPAs!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        } else {

                            double Cgpa1 = Double.parseDouble(temp1);
                            double Cgpa2 = Double.parseDouble(temp2);
                            double Cgpa3 = Double.parseDouble(temp3);
                            double Cgpa4 = Double.parseDouble(temp4);

                            double total = (Cgpa1 * 25 + Cgpa2 * 24 + Cgpa3 * 25 + Cgpa4 * 24) / 98;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }
                    }
                    if (num == 1) {
                        String temp3 = EditTextCgpa3.getText().toString();
                        String temp4 = EditTextCgpa4.getText().toString();
                        if ((temp3.isEmpty()) || (temp4.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your GPAs!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        } else {

                            double Cgpa1 = 0;
                            double Cgpa2 = 0;
                            double Cgpa3 = Double.parseDouble(temp3);
                            double Cgpa4 = Double.parseDouble(temp4);

                            double total = (Cgpa1 * 25 + Cgpa2 * 24 + Cgpa3 * 25 + Cgpa4 * 24) / 49;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }
                    }
                }
                if (value.equals("ECESemester 5")) {

                    if (num == 0) {
                        String temp1 = EditTextCgpa1.getText().toString();
                        String temp2 = EditTextCgpa2.getText().toString();
                        String temp3 = EditTextCgpa3.getText().toString();
                        String temp4 = EditTextCgpa4.getText().toString();
                        String temp5 = EditTextCgpa5.getText().toString();

                        if ((temp1.isEmpty()) || (temp2.isEmpty()) || (temp3.isEmpty()) || (temp4.isEmpty()) || (temp5.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your GPAs!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        } else {
                            double Cgpa1 = Double.parseDouble(temp1);
                            double Cgpa2 = Double.parseDouble(temp2);
                            double Cgpa3 = Double.parseDouble(temp3);
                            double Cgpa4 = Double.parseDouble(temp4);
                            double Cgpa5 = Double.parseDouble(temp5);

                            double total = (Cgpa1 * 25 + Cgpa2 * 24 + Cgpa3 * 25 + Cgpa4 * 24 + Cgpa5 * 25) / 123;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }
                    }

                    if (num == 1) {
                        String temp3 = EditTextCgpa3.getText().toString();
                        String temp4 = EditTextCgpa4.getText().toString();
                        String temp5 = EditTextCgpa5.getText().toString();

                        if ((temp3.isEmpty()) || (temp4.isEmpty()) || (temp5.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your GPAs!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        } else {
                            double Cgpa1 = 0;
                            double Cgpa2 = 0;
                            double Cgpa3 = Double.parseDouble(temp3);
                            double Cgpa4 = Double.parseDouble(temp4);
                            double Cgpa5 = Double.parseDouble(temp5);

                            double total = (Cgpa1 * 25 + Cgpa2 * 24 + Cgpa3 * 25 + Cgpa4 * 24 + Cgpa5 * 25) / 74;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }
                    }
                }
                if (value.equals("ECESemester 6")){

                    if (num==0){
                        String temp1 = EditTextCgpa1.getText().toString();
                        String temp2 = EditTextCgpa2.getText().toString();
                        String temp3 = EditTextCgpa3.getText().toString();
                        String temp4 = EditTextCgpa4.getText().toString();
                        String temp5 = EditTextCgpa5.getText().toString();
                        String temp6 = EditTextCgpa6.getText().toString();
                        if ((temp1.isEmpty()) || (temp2.isEmpty()) || (temp3.isEmpty()) ||
                                (temp4.isEmpty()) || (temp5.isEmpty()) || (temp6.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your GPAs!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        } else {
                            double Cgpa1 = Double.parseDouble(temp1);
                            double Cgpa2 = Double.parseDouble(temp2);
                            double Cgpa3 = Double.parseDouble(temp3);
                            double Cgpa4 = Double.parseDouble(temp4);
                            double Cgpa5 = Double.parseDouble(temp5);
                            double Cgpa6 = Double.parseDouble(temp6);

                            double total = (Cgpa1 * 25 + Cgpa2 * 24 + Cgpa3 * 25 + Cgpa4 * 24 + Cgpa5 * 25 + Cgpa6 * 24) / 147;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }
                    }
                    if (num==1){

                        String temp3 = EditTextCgpa3.getText().toString();
                        String temp4 = EditTextCgpa4.getText().toString();
                        String temp5 = EditTextCgpa5.getText().toString();
                        String temp6 = EditTextCgpa6.getText().toString();
                        if ((temp3.isEmpty()) || (temp4.isEmpty()) || (temp5.isEmpty()) || (temp6.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your GPAs!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        } else {
                            double Cgpa1 = 0;
                            double Cgpa2 = 0;
                            double Cgpa3 = Double.parseDouble(temp3);
                            double Cgpa4 = Double.parseDouble(temp4);
                            double Cgpa5 = Double.parseDouble(temp5);
                            double Cgpa6 = Double.parseDouble(temp6);

                            double total = (Cgpa1 * 25 + Cgpa2 * 24 + Cgpa3 * 25 + Cgpa4 * 24 + Cgpa5 * 25 + Cgpa6 * 24) / 98;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }
                    }
                }
                if (value.equals("ECESemester 7")){
                    if (num==0){
                        String temp1 = EditTextCgpa1.getText().toString();
                        String temp2 = EditTextCgpa2.getText().toString();
                        String temp3 = EditTextCgpa3.getText().toString();
                        String temp4 = EditTextCgpa4.getText().toString();
                        String temp5 = EditTextCgpa5.getText().toString();
                        String temp6 = EditTextCgpa6.getText().toString();
                        String temp7 = EditTextCgpa7.getText().toString();
                        if ((temp1.isEmpty()) || (temp2.isEmpty()) || (temp3.isEmpty()) ||
                                (temp4.isEmpty()) || (temp5.isEmpty()) || (temp6.isEmpty()) || (temp7.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your GPAs!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        } else {
                            double Cgpa1 = Double.parseDouble(temp1);
                            double Cgpa2 = Double.parseDouble(temp2);
                            double Cgpa3 = Double.parseDouble(temp3);
                            double Cgpa4 = Double.parseDouble(temp4);
                            double Cgpa5 = Double.parseDouble(temp5);
                            double Cgpa6 = Double.parseDouble(temp6);
                            double Cgpa7 = Double.parseDouble(temp7);

                            double total = (Cgpa1 * 25 + Cgpa2 * 24 + Cgpa3 * 25 + Cgpa4 * 24 + Cgpa5 * 25 + Cgpa6 * 24 + Cgpa7 * 22) / 169;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }
                    }
                    if (num==1){

                        String temp3 = EditTextCgpa3.getText().toString();
                        String temp4 = EditTextCgpa4.getText().toString();
                        String temp5 = EditTextCgpa5.getText().toString();
                        String temp6 = EditTextCgpa6.getText().toString();
                        String temp7 = EditTextCgpa7.getText().toString();
                        if ((temp3.isEmpty()) || (temp4.isEmpty()) || (temp5.isEmpty()) || (temp6.isEmpty()) || (temp7.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your GPAs!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        } else {
                            double Cgpa1 = 0;
                            double Cgpa2 = 0;
                            double Cgpa3 = Double.parseDouble(temp3);
                            double Cgpa4 = Double.parseDouble(temp4);
                            double Cgpa5 = Double.parseDouble(temp5);
                            double Cgpa6 = Double.parseDouble(temp6);
                            double Cgpa7 = Double.parseDouble(temp7);

                            double total = (Cgpa1 * 25 + Cgpa2 * 24 + Cgpa3 * 25 + Cgpa4 * 24 + Cgpa5 * 25 + Cgpa6 * 24 + Cgpa7 * 22) / 120;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }
                    }


                }
                if (value.equals("ECESemester 8")){
                    if (num==0){
                        String temp1 = EditTextCgpa1.getText().toString();
                        String temp2 = EditTextCgpa2.getText().toString();
                        String temp3 = EditTextCgpa3.getText().toString();
                        String temp4 = EditTextCgpa4.getText().toString();
                        String temp5 = EditTextCgpa5.getText().toString();
                        String temp6 = EditTextCgpa6.getText().toString();
                        String temp7 = EditTextCgpa7.getText().toString();
                        String temp8 = EditTextCgpa8.getText().toString();
                        if ((temp1.isEmpty()) || (temp2.isEmpty()) || (temp3.isEmpty()) ||
                                (temp4.isEmpty()) || (temp5.isEmpty()) || (temp6.isEmpty()) || (temp7.isEmpty()) || (temp8.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your GPAs!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        } else {
                            double Cgpa1 = Double.parseDouble(temp1);
                            double Cgpa2 = Double.parseDouble(temp2);
                            double Cgpa3 = Double.parseDouble(temp3);
                            double Cgpa4 = Double.parseDouble(temp4);
                            double Cgpa5 = Double.parseDouble(temp5);
                            double Cgpa6 = Double.parseDouble(temp6);
                            double Cgpa7 = Double.parseDouble(temp7);
                            double Cgpa8 = Double.parseDouble(temp8);


                            double total = (Cgpa1 * 25 + Cgpa2 * 24 + Cgpa3 * 25 + Cgpa4 * 24 + Cgpa5 * 25 + Cgpa6 * 24 + Cgpa7 * 22 + Cgpa8 * 16) / 185;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }
                    }
                    if (num==1){

                        String temp3 = EditTextCgpa3.getText().toString();
                        String temp4 = EditTextCgpa4.getText().toString();
                        String temp5 = EditTextCgpa5.getText().toString();
                        String temp6 = EditTextCgpa6.getText().toString();
                        String temp7 = EditTextCgpa7.getText().toString();
                        String temp8 = EditTextCgpa8.getText().toString();
                        if ((temp3.isEmpty()) || (temp4.isEmpty()) || (temp5.isEmpty()) || (temp6.isEmpty()) || (temp7.isEmpty()) || (temp8.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your GPAs!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        } else {
                            double Cgpa1 = 0;
                            double Cgpa2 = 0;
                            double Cgpa3 = Double.parseDouble(temp3);
                            double Cgpa4 = Double.parseDouble(temp4);
                            double Cgpa5 = Double.parseDouble(temp5);
                            double Cgpa6 = Double.parseDouble(temp6);
                            double Cgpa7 = Double.parseDouble(temp7);
                            double Cgpa8 = Double.parseDouble(temp8);


                            double total = (Cgpa1 * 25 + Cgpa2 * 24 + Cgpa3 * 25 + Cgpa4 * 24 + Cgpa5 * 25 + Cgpa6 * 24 + Cgpa7 * 22 + Cgpa8 * 16) / 136;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }
                    }
                }

                if (value.equals("EEESemester 2")){

                    if (num==0){

                        String temp1 = EditTextCgpa1.getText().toString();
                        String temp2 = EditTextCgpa2.getText().toString();
                        if ((temp1.isEmpty()) || (temp2.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your GPAs!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        }else {
                            double Cgpa1 = Double.parseDouble(temp1);
                            double Cgpa2 = Double.parseDouble(temp2);

                            double total = (Cgpa1 * 25 + Cgpa2 * 25) / 50;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }
                    }
                    if (num==1){

                        Toast.makeText(Cgpa2.this, "Sorry, you don't have any CGPA!!", Toast.LENGTH_SHORT).show();
                        TextCgpa.setText("0.0");
                    }
                }
                if (value.equals("EEESemester 3")){
                    if (num==0) {
                        String temp1 = EditTextCgpa1.getText().toString();
                        String temp2 = EditTextCgpa2.getText().toString();
                        String temp3 = EditTextCgpa3.getText().toString();
                        if ((temp1.isEmpty()) || (temp2.isEmpty()) || (temp3.isEmpty()))
                        {
                            Toast.makeText(Cgpa2.this, "Please fill your GPAs!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        } else {
                            double Cgpa1 = Double.parseDouble(temp1);
                            double Cgpa2 = Double.parseDouble(temp2);
                            double Cgpa3 = Double.parseDouble(temp3);

                            double total = (Cgpa1 * 25 + Cgpa2 * 25 + Cgpa3 * 23) / 73;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }
                    }
                    if (num==1) {
                        String temp3 = EditTextCgpa3.getText().toString();
                        if ((temp3.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your 3rd Semester GPA!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        } else {

                            double Cgpa1 = 0;
                            double Cgpa2 = 0;
                            double Cgpa3 = Double.parseDouble(temp3);

                            double total = (Cgpa1 * 25 + Cgpa2 * 25 + Cgpa3 * 23) / 23;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }

                    }
                }
                if (value.equals("EEESemester 4")){

                    if (num==0) {
                        String temp1 = EditTextCgpa1.getText().toString();
                        String temp2 = EditTextCgpa2.getText().toString();
                        String temp3 = EditTextCgpa3.getText().toString();
                        String temp4 = EditTextCgpa4.getText().toString();
                        if ((temp1.isEmpty()) || (temp2.isEmpty()) || (temp3.isEmpty()) || (temp4.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your GPAs!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        }else {
                            double Cgpa1 = Double.parseDouble(temp1);
                            double Cgpa2 = Double.parseDouble(temp2);
                            double Cgpa3 = Double.parseDouble(temp3);
                            double Cgpa4 = Double.parseDouble(temp4);

                            double total = (Cgpa1 * 25 + Cgpa2 * 25 + Cgpa3 * 23 + Cgpa4 * 25) / 98;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }
                    }
                    if (num==1) {
                        String temp3 = EditTextCgpa3.getText().toString();
                        String temp4 = EditTextCgpa4.getText().toString();
                        if ((temp3.isEmpty()) || (temp4.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your GPAs!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        } else {
                            double Cgpa1 = 0;
                            double Cgpa2 = 0;
                            double Cgpa3 = Double.parseDouble(temp3);
                            double Cgpa4 = Double.parseDouble(temp4);

                            double total = (Cgpa1 * 25 + Cgpa2 * 25 + Cgpa3 * 23 + Cgpa4 * 25) / 48;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }
                    }
                }
                if (value.equals("EEESemester 5")){

                    if (num==0){
                        String temp1 = EditTextCgpa1.getText().toString();
                        String temp2 = EditTextCgpa2.getText().toString();
                        String temp3 = EditTextCgpa3.getText().toString();
                        String temp4 = EditTextCgpa4.getText().toString();
                        String temp5 = EditTextCgpa5.getText().toString();

                        if ((temp1.isEmpty()) || (temp2.isEmpty()) || (temp3.isEmpty()) || (temp4.isEmpty()) || (temp5.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your GPAs!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        } else {
                            double Cgpa1 = Double.parseDouble(temp1);
                            double Cgpa2 = Double.parseDouble(temp2);
                            double Cgpa3 = Double.parseDouble(temp3);
                            double Cgpa4 = Double.parseDouble(temp4);
                            double Cgpa5 = Double.parseDouble(temp5);

                            double total = (Cgpa1 *25 + Cgpa2 * 25 + Cgpa3 * 23 + Cgpa4 * 25 + Cgpa5 * 23)/121;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }
                    }
                    if (num==1){
                        String temp3 = EditTextCgpa3.getText().toString();
                        String temp4 = EditTextCgpa4.getText().toString();
                        String temp5 = EditTextCgpa5.getText().toString();

                        if ((temp3.isEmpty()) || (temp4.isEmpty()) || (temp5.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your GPAs!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        } else {
                            double Cgpa1 = 0;
                            double Cgpa2 = 0;
                            double Cgpa3 = Double.parseDouble(temp3);
                            double Cgpa4 = Double.parseDouble(temp4);
                            double Cgpa5 = Double.parseDouble(temp5);

                            double total = (Cgpa1 *25 + Cgpa2 * 25 + Cgpa3 * 23 + Cgpa4 * 25 + Cgpa5 * 23)/71;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }
                    }

                }
                if (value.equals("EEESemester 6")){
                    if (num==0){
                        String temp1 = EditTextCgpa1.getText().toString();
                        String temp2 = EditTextCgpa2.getText().toString();
                        String temp3 = EditTextCgpa3.getText().toString();
                        String temp4 = EditTextCgpa4.getText().toString();
                        String temp5 = EditTextCgpa5.getText().toString();
                        String temp6 = EditTextCgpa6.getText().toString();

                        if ((temp1.isEmpty()) || (temp2.isEmpty()) || (temp3.isEmpty()) || (temp4.isEmpty()) || (temp5.isEmpty()) ||(temp6.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your GPAs!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        } else {
                            double Cgpa1 = Double.parseDouble(temp1);
                            double Cgpa2 = Double.parseDouble(temp2);
                            double Cgpa3 = Double.parseDouble(temp3);
                            double Cgpa4 = Double.parseDouble(temp4);
                            double Cgpa5 = Double.parseDouble(temp5);
                            double Cgpa6 = Double.parseDouble(temp6);

                            double total = (Cgpa1 *25 + Cgpa2 * 25 + Cgpa3 * 23 + Cgpa4 * 25 + Cgpa5 * 23 + Cgpa6 * 21)/142;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }
                    }
                    if (num==1){
                        String temp3 = EditTextCgpa3.getText().toString();
                        String temp4 = EditTextCgpa4.getText().toString();
                        String temp5 = EditTextCgpa5.getText().toString();
                        String temp6 = EditTextCgpa5.getText().toString();

                        if ((temp3.isEmpty()) || (temp4.isEmpty()) || (temp5.isEmpty()) ||(temp6.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your GPAs!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        } else {
                            double Cgpa1 = 0;
                            double Cgpa2 = 0;
                            double Cgpa3 = Double.parseDouble(temp3);
                            double Cgpa4 = Double.parseDouble(temp4);
                            double Cgpa5 = Double.parseDouble(temp5);
                            double Cgpa6 = Double.parseDouble(temp6);


                            double total = (Cgpa1 *25 + Cgpa2 * 25 + Cgpa3 * 23 + Cgpa4 * 25 + Cgpa5 * 23 + Cgpa6 * 21)/92;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }
                    }
                }
                if (value.equals("EEESemester 7")){
                    if (num==0){
                        String temp1 = EditTextCgpa1.getText().toString();
                        String temp2 = EditTextCgpa2.getText().toString();
                        String temp3 = EditTextCgpa3.getText().toString();
                        String temp4 = EditTextCgpa4.getText().toString();
                        String temp5 = EditTextCgpa5.getText().toString();
                        String temp6 = EditTextCgpa6.getText().toString();
                        String temp7 = EditTextCgpa7.getText().toString();

                        if ((temp1.isEmpty()) || (temp2.isEmpty()) || (temp3.isEmpty()) || (temp4.isEmpty()) ||
                                (temp5.isEmpty()) ||(temp6.isEmpty()) || (temp7.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your GPAs!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        } else {
                            double Cgpa1 = Double.parseDouble(temp1);
                            double Cgpa2 = Double.parseDouble(temp2);
                            double Cgpa3 = Double.parseDouble(temp3);
                            double Cgpa4 = Double.parseDouble(temp4);
                            double Cgpa5 = Double.parseDouble(temp5);
                            double Cgpa6 = Double.parseDouble(temp6);
                            double Cgpa7 = Double.parseDouble(temp7);

                            double total = (Cgpa1 *25 + Cgpa2 * 25 + Cgpa3 * 23 + Cgpa4 * 25 + Cgpa5 * 23 + Cgpa6 * 21 + Cgpa7 *22)/164;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }
                    }
                    if (num==1) {

                        String temp3 = EditTextCgpa3.getText().toString();
                        String temp4 = EditTextCgpa4.getText().toString();
                        String temp5 = EditTextCgpa5.getText().toString();
                        String temp6 = EditTextCgpa6.getText().toString();
                        String temp7 = EditTextCgpa7.getText().toString();

                        if ((temp3.isEmpty()) || (temp4.isEmpty()) || (temp5.isEmpty()) || (temp6.isEmpty()) || (temp7.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your GPAs!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        } else {
                            double Cgpa1 = 0;
                            double Cgpa2 = 0;
                            double Cgpa3 = Double.parseDouble(temp3);
                            double Cgpa4 = Double.parseDouble(temp4);
                            double Cgpa5 = Double.parseDouble(temp5);
                            double Cgpa6 = Double.parseDouble(temp6);
                            double Cgpa7 = Double.parseDouble(temp7);

                            double total = (Cgpa1 * 25 + Cgpa2 * 25 + Cgpa3 * 23 + Cgpa4 * 25 + Cgpa5 * 23 + Cgpa6 * 21 + Cgpa7 * 22) / 114;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }
                    }
                }
                if (value.equals("EEESemester 8")){
                    if (num==0) {
                        String temp1 = EditTextCgpa1.getText().toString();
                        String temp2 = EditTextCgpa2.getText().toString();
                        String temp3 = EditTextCgpa3.getText().toString();
                        String temp4 = EditTextCgpa4.getText().toString();
                        String temp5 = EditTextCgpa5.getText().toString();
                        String temp6 = EditTextCgpa6.getText().toString();
                        String temp7 = EditTextCgpa7.getText().toString();
                        String temp8 = EditTextCgpa8.getText().toString();
                        if ((temp1.isEmpty()) || (temp2.isEmpty()) || (temp3.isEmpty()) ||
                                (temp4.isEmpty()) || (temp5.isEmpty()) || (temp6.isEmpty()) || (temp7.isEmpty()) || (temp8.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your GPAs!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        } else {
                            double Cgpa1 = Double.parseDouble(temp1);
                            double Cgpa2 = Double.parseDouble(temp2);
                            double Cgpa3 = Double.parseDouble(temp3);
                            double Cgpa4 = Double.parseDouble(temp4);
                            double Cgpa5 = Double.parseDouble(temp5);
                            double Cgpa6 = Double.parseDouble(temp6);
                            double Cgpa7 = Double.parseDouble(temp7);
                            double Cgpa8 = Double.parseDouble(temp8);

                            double total = (Cgpa1 * 25 + Cgpa2 * 25 + Cgpa3 * 23 + Cgpa4 * 25 +
                                    Cgpa5 * 23 + Cgpa6 * 21 + Cgpa7 * 22 + Cgpa8 * 16) / 180;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }
                    }
                    if (num==1) {
                        String temp3 = EditTextCgpa3.getText().toString();
                        String temp4 = EditTextCgpa4.getText().toString();
                        String temp5 = EditTextCgpa5.getText().toString();
                        String temp6 = EditTextCgpa6.getText().toString();
                        String temp7 = EditTextCgpa7.getText().toString();
                        String temp8 = EditTextCgpa8.getText().toString();
                        if ((temp3.isEmpty()) || (temp4.isEmpty()) || (temp5.isEmpty()) || (temp6.isEmpty()) || (temp7.isEmpty()) || (temp8.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your GPAs!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        } else {
                            double Cgpa1 = 0;
                            double Cgpa2 = 0;
                            double Cgpa3 = Double.parseDouble(temp3);
                            double Cgpa4 = Double.parseDouble(temp4);
                            double Cgpa5 = Double.parseDouble(temp5);
                            double Cgpa6 = Double.parseDouble(temp6);
                            double Cgpa7 = Double.parseDouble(temp7);
                            double Cgpa8 = Double.parseDouble(temp8);

                            double total = (Cgpa1 * 25 + Cgpa2 * 25 + Cgpa3 * 23 + Cgpa4 * 25 +
                                    Cgpa5 * 23 + Cgpa6 * 21 + Cgpa7 * 22 + Cgpa8 * 16) / 130;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }
                    }
                }

                if (value.equals("MechanicalSemester 2")){
                    if (num==0){

                        String temp1 = EditTextCgpa1.getText().toString();
                        String temp2 = EditTextCgpa2.getText().toString();
                        if ((temp1.isEmpty()) || (temp2.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your GPAs!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        }else {
                            double Cgpa1 = Double.parseDouble(temp1);
                            double Cgpa2 = Double.parseDouble(temp2);

                            double total = (Cgpa1 * 25 + Cgpa2 * 25) / 50;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }
                    }
                    if (num==1){
                        Toast.makeText(Cgpa2.this, "Sorry, you don't have any CGPA!!", Toast.LENGTH_SHORT).show();
                        TextCgpa.setText("0.0");
                    }
                }
                if (value.equals("MechanicalSemester 3")){
                    if (num==0) {
                        String temp1 = EditTextCgpa1.getText().toString();
                        String temp2 = EditTextCgpa2.getText().toString();
                        String temp3 = EditTextCgpa3.getText().toString();
                        if ((temp1.isEmpty()) || (temp2.isEmpty()) || (temp3.isEmpty()))
                        {
                            Toast.makeText(Cgpa2.this, "Please fill your GPAs!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        } else {
                            double Cgpa1 = Double.parseDouble(temp1);
                            double Cgpa2 = Double.parseDouble(temp2);
                            double Cgpa3 = Double.parseDouble(temp3);

                            double total = (Cgpa1 * 25 + Cgpa2 * 25 + Cgpa3 * 25) / 75;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }
                    }
                    if (num==1) {
                        String temp3 = EditTextCgpa3.getText().toString();
                        if ((temp3.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your 3rd Semester GPA!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        } else {

                            double Cgpa1 = 0;
                            double Cgpa2 = 0;
                            double Cgpa3 = Double.parseDouble(temp3);

                            double total = (Cgpa1 * 25 + Cgpa2 * 25 + Cgpa3 * 25) / 25;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }

                    }
                }
                if (value.equals("MechanicalSemester 4")){

                    if (num==0) {
                        String temp1 = EditTextCgpa1.getText().toString();
                        String temp2 = EditTextCgpa2.getText().toString();
                        String temp3 = EditTextCgpa3.getText().toString();
                        String temp4 = EditTextCgpa4.getText().toString();
                        if ((temp1.isEmpty()) || (temp2.isEmpty()) || (temp3.isEmpty()) || (temp4.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your GPAs!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        }else {
                            double Cgpa1 = Double.parseDouble(temp1);
                            double Cgpa2 = Double.parseDouble(temp2);
                            double Cgpa3 = Double.parseDouble(temp3);
                            double Cgpa4 = Double.parseDouble(temp4);

                            double total = (Cgpa1 * 25 + Cgpa2 * 25 + Cgpa3 * 25 + Cgpa4 * 24) / 99;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }
                    }
                    if (num==1) {
                        String temp3 = EditTextCgpa3.getText().toString();
                        String temp4 = EditTextCgpa4.getText().toString();
                        if ((temp3.isEmpty()) || (temp4.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your GPAs!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        } else {
                            double Cgpa1 = 0;
                            double Cgpa2 = 0;
                            double Cgpa3 = Double.parseDouble(temp3);
                            double Cgpa4 = Double.parseDouble(temp4);

                            double total = (Cgpa1 * 25 + Cgpa2 * 25 + Cgpa3 * 25 + Cgpa4 * 24)/44;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }
                    }
                }
                if (value.equals("MechanicalSemester 5")){

                    if (num==0){
                        String temp1 = EditTextCgpa1.getText().toString();
                        String temp2 = EditTextCgpa2.getText().toString();
                        String temp3 = EditTextCgpa3.getText().toString();
                        String temp4 = EditTextCgpa4.getText().toString();
                        String temp5 = EditTextCgpa5.getText().toString();

                        if ((temp1.isEmpty()) || (temp2.isEmpty()) || (temp3.isEmpty()) || (temp4.isEmpty()) || (temp5.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your GPAs!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        } else {
                            double Cgpa1 = Double.parseDouble(temp1);
                            double Cgpa2 = Double.parseDouble(temp2);
                            double Cgpa3 = Double.parseDouble(temp3);
                            double Cgpa4 = Double.parseDouble(temp4);
                            double Cgpa5 = Double.parseDouble(temp5);

                            double total = (Cgpa1 *25 + Cgpa2 * 25 + Cgpa3 * 25 + Cgpa4 * 24 + Cgpa5 * 22)/121;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }
                    }
                    if (num==1){
                        String temp3 = EditTextCgpa3.getText().toString();
                        String temp4 = EditTextCgpa4.getText().toString();
                        String temp5 = EditTextCgpa5.getText().toString();

                        if ((temp3.isEmpty()) || (temp4.isEmpty()) || (temp5.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your GPAs!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        } else {
                            double Cgpa1 = 0;
                            double Cgpa2 = 0;
                            double Cgpa3 = Double.parseDouble(temp3);
                            double Cgpa4 = Double.parseDouble(temp4);
                            double Cgpa5 = Double.parseDouble(temp5);

                            double total = (Cgpa1 *25 + Cgpa2 * 25 + Cgpa3 * 25 + Cgpa4 * 24 + Cgpa5 * 22)/71;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }
                    }

                }
                if (value.equals("MechanicalSemester 6")){
                    if (num==0){
                        String temp1 = EditTextCgpa1.getText().toString();
                        String temp2 = EditTextCgpa2.getText().toString();
                        String temp3 = EditTextCgpa3.getText().toString();
                        String temp4 = EditTextCgpa4.getText().toString();
                        String temp5 = EditTextCgpa5.getText().toString();
                        String temp6 = EditTextCgpa6.getText().toString();

                        if ((temp1.isEmpty()) || (temp2.isEmpty()) || (temp3.isEmpty()) || (temp4.isEmpty()) || (temp5.isEmpty()) ||(temp6.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your GPAs!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        } else {
                            double Cgpa1 = Double.parseDouble(temp1);
                            double Cgpa2 = Double.parseDouble(temp2);
                            double Cgpa3 = Double.parseDouble(temp3);
                            double Cgpa4 = Double.parseDouble(temp4);
                            double Cgpa5 = Double.parseDouble(temp5);
                            double Cgpa6 = Double.parseDouble(temp6);

                            double total = (Cgpa1 *25 + Cgpa2 * 25 + Cgpa3 * 25 + Cgpa4 * 24 + Cgpa5 * 22 + Cgpa6 * 24)/145;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }
                    }
                    if (num==1){
                        String temp3 = EditTextCgpa3.getText().toString();
                        String temp4 = EditTextCgpa4.getText().toString();
                        String temp5 = EditTextCgpa5.getText().toString();
                        String temp6 = EditTextCgpa5.getText().toString();

                        if ((temp3.isEmpty()) || (temp4.isEmpty()) || (temp5.isEmpty()) ||(temp6.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your GPAs!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        } else {
                            double Cgpa1 = 0;
                            double Cgpa2 = 0;
                            double Cgpa3 = Double.parseDouble(temp3);
                            double Cgpa4 = Double.parseDouble(temp4);
                            double Cgpa5 = Double.parseDouble(temp5);
                            double Cgpa6 = Double.parseDouble(temp6);


                            double total = (Cgpa1 *25 + Cgpa2 * 25 + Cgpa3 * 25 + Cgpa4 * 24 + Cgpa5 * 22 + Cgpa6 * 24)/95;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }
                    }
                }
                if (value.equals("MechanicalSemester 7")){
                    if (num==0){
                        String temp1 = EditTextCgpa1.getText().toString();
                        String temp2 = EditTextCgpa2.getText().toString();
                        String temp3 = EditTextCgpa3.getText().toString();
                        String temp4 = EditTextCgpa4.getText().toString();
                        String temp5 = EditTextCgpa5.getText().toString();
                        String temp6 = EditTextCgpa6.getText().toString();
                        String temp7 = EditTextCgpa7.getText().toString();

                        if ((temp1.isEmpty()) || (temp2.isEmpty()) || (temp3.isEmpty()) || (temp4.isEmpty()) ||
                                (temp5.isEmpty()) ||(temp6.isEmpty()) || (temp7.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your GPAs!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        } else {
                            double Cgpa1 = Double.parseDouble(temp1);
                            double Cgpa2 = Double.parseDouble(temp2);
                            double Cgpa3 = Double.parseDouble(temp3);
                            double Cgpa4 = Double.parseDouble(temp4);
                            double Cgpa5 = Double.parseDouble(temp5);
                            double Cgpa6 = Double.parseDouble(temp6);
                            double Cgpa7 = Double.parseDouble(temp7);

                            double total = (Cgpa1 *25 + Cgpa2 * 25 + Cgpa3 * 25 + Cgpa4 * 24 + Cgpa5 * 22 + Cgpa6 * 24 + Cgpa7 *23)/168;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }
                    }
                    if (num==1) {

                        String temp3 = EditTextCgpa3.getText().toString();
                        String temp4 = EditTextCgpa4.getText().toString();
                        String temp5 = EditTextCgpa5.getText().toString();
                        String temp6 = EditTextCgpa6.getText().toString();
                        String temp7 = EditTextCgpa7.getText().toString();

                        if ((temp3.isEmpty()) || (temp4.isEmpty()) || (temp5.isEmpty()) || (temp6.isEmpty()) || (temp7.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your GPAs!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        } else {
                            double Cgpa1 = 0;
                            double Cgpa2 = 0;
                            double Cgpa3 = Double.parseDouble(temp3);
                            double Cgpa4 = Double.parseDouble(temp4);
                            double Cgpa5 = Double.parseDouble(temp5);
                            double Cgpa6 = Double.parseDouble(temp6);
                            double Cgpa7 = Double.parseDouble(temp7);

                            double total = (Cgpa1 *25 + Cgpa2 * 25 + Cgpa3 * 25 + Cgpa4 * 24 + Cgpa5 * 22 + Cgpa6 * 24 + Cgpa7 *23)/118;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }
                    }
                }
                if (value.equals("MechanicalSemester 8")){
                    if (num==0) {
                        String temp1 = EditTextCgpa1.getText().toString();
                        String temp2 = EditTextCgpa2.getText().toString();
                        String temp3 = EditTextCgpa3.getText().toString();
                        String temp4 = EditTextCgpa4.getText().toString();
                        String temp5 = EditTextCgpa5.getText().toString();
                        String temp6 = EditTextCgpa6.getText().toString();
                        String temp7 = EditTextCgpa7.getText().toString();
                        String temp8 = EditTextCgpa8.getText().toString();
                        if ((temp1.isEmpty()) || (temp2.isEmpty()) || (temp3.isEmpty()) ||
                                (temp4.isEmpty()) || (temp5.isEmpty()) || (temp6.isEmpty()) || (temp7.isEmpty()) || (temp8.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your GPAs!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        } else {
                            double Cgpa1 = Double.parseDouble(temp1);
                            double Cgpa2 = Double.parseDouble(temp2);
                            double Cgpa3 = Double.parseDouble(temp3);
                            double Cgpa4 = Double.parseDouble(temp4);
                            double Cgpa5 = Double.parseDouble(temp5);
                            double Cgpa6 = Double.parseDouble(temp6);
                            double Cgpa7 = Double.parseDouble(temp7);
                            double Cgpa8 = Double.parseDouble(temp8);

                            double total = (Cgpa1 * 25 + Cgpa2 * 25 + Cgpa3 * 25 + Cgpa4 * 24 +
                                    Cgpa5 * 22 + Cgpa6 * 24 + Cgpa7 * 23 + Cgpa8 * 16) / 184;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }
                    }
                    if (num==1) {
                        String temp3 = EditTextCgpa3.getText().toString();
                        String temp4 = EditTextCgpa4.getText().toString();
                        String temp5 = EditTextCgpa5.getText().toString();
                        String temp6 = EditTextCgpa6.getText().toString();
                        String temp7 = EditTextCgpa7.getText().toString();
                        String temp8 = EditTextCgpa8.getText().toString();
                        if ((temp3.isEmpty()) || (temp4.isEmpty()) || (temp5.isEmpty()) || (temp6.isEmpty()) || (temp7.isEmpty()) || (temp8.isEmpty())) {
                            Toast.makeText(Cgpa2.this, "Please fill your GPAs!!", Toast.LENGTH_SHORT).show();
                            TextCgpa.setText("");
                        } else {
                            double Cgpa1 = 0;
                            double Cgpa2 = 0;
                            double Cgpa3 = Double.parseDouble(temp3);
                            double Cgpa4 = Double.parseDouble(temp4);
                            double Cgpa5 = Double.parseDouble(temp5);
                            double Cgpa6 = Double.parseDouble(temp6);
                            double Cgpa7 = Double.parseDouble(temp7);
                            double Cgpa8 = Double.parseDouble(temp8);

                            double total = (Cgpa1 * 25 + Cgpa2 * 25 + Cgpa3 * 25 + Cgpa4 * 24 +
                                    Cgpa5 * 22 + Cgpa6 * 24 + Cgpa7 * 23 + Cgpa8 * 16) / 134;
                            DecimalFormat numberFormat = new DecimalFormat("#.00");
                            TextCgpa.setText(numberFormat.format(total));
                        }
                    }
                }
            }
        });

        if (value.equals("CSESemester 2")) {
            Sem3Layout.setVisibility(View.GONE);
            Sem4Layout.setVisibility(View.GONE);
            Sem5Layout.setVisibility(View.GONE);
            Sem6Layout.setVisibility(View.GONE);
            Sem7Layout.setVisibility(View.GONE);
            Sem8Layout.setVisibility(View.GONE);

        }
        if (value.equals("CSESemester 3"))
        {
            Sem4Layout.setVisibility(View.GONE);
            Sem5Layout.setVisibility(View.GONE);
            Sem6Layout.setVisibility(View.GONE);
            Sem7Layout.setVisibility(View.GONE);
            Sem8Layout.setVisibility(View.GONE);
        }
        if (value.equals("CSESemester 4")) {
            Sem5Layout.setVisibility(View.GONE);
            Sem6Layout.setVisibility(View.GONE);
            Sem7Layout.setVisibility(View.GONE);
            Sem8Layout.setVisibility(View.GONE);
        }
        if (value.equals("CSESemester 5")) {
            Sem6Layout.setVisibility(View.GONE);
            Sem7Layout.setVisibility(View.GONE);
            Sem8Layout.setVisibility(View.GONE);

        }
        if (value.equals("CSESemester 6")) {

            Sem7Layout.setVisibility(View.GONE);
            Sem8Layout.setVisibility(View.GONE);
        }
        if (value.equals("CSESemester 7")) {
            Sem8Layout.setVisibility(View.GONE);
        }

        if (value.equals("ITSemester 2")) {
            Sem3Layout.setVisibility(View.GONE);
            Sem4Layout.setVisibility(View.GONE);
            Sem5Layout.setVisibility(View.GONE);
            Sem6Layout.setVisibility(View.GONE);
            Sem7Layout.setVisibility(View.GONE);
            Sem8Layout.setVisibility(View.GONE);


        }
        if (value.equals("ITSemester 3")) {
            Sem4Layout.setVisibility(View.GONE);
            Sem5Layout.setVisibility(View.GONE);
            Sem6Layout.setVisibility(View.GONE);
            Sem7Layout.setVisibility(View.GONE);
            Sem8Layout.setVisibility(View.GONE);
        }
        if (value.equals("ITSemester 4")) {
            Sem5Layout.setVisibility(View.GONE);
            Sem6Layout.setVisibility(View.GONE);
            Sem7Layout.setVisibility(View.GONE);
            Sem8Layout.setVisibility(View.GONE);

        }
        if (value.equals("ITSemester 5")) {
            Sem6Layout.setVisibility(View.GONE);
            Sem7Layout.setVisibility(View.GONE);
            Sem8Layout.setVisibility(View.GONE);

        }
        if (value.equals("ITSemester 6")) {

            Sem7Layout.setVisibility(View.GONE);
            Sem8Layout.setVisibility(View.GONE);

        }
        if (value.equals("ITSemester 7")) {
            Sem8Layout.setVisibility(View.GONE);
        }

        if (value.equals("ECESemester 2")) {
            Sem3Layout.setVisibility(View.GONE);
            Sem4Layout.setVisibility(View.GONE);
            Sem5Layout.setVisibility(View.GONE);
            Sem6Layout.setVisibility(View.GONE);
            Sem7Layout.setVisibility(View.GONE);
            Sem8Layout.setVisibility(View.GONE);

        }
        if (value.equals("ECESemester 3")) {
            Sem4Layout.setVisibility(View.GONE);
            Sem5Layout.setVisibility(View.GONE);
            Sem6Layout.setVisibility(View.GONE);
            Sem7Layout.setVisibility(View.GONE);
            Sem8Layout.setVisibility(View.GONE);
        }
        if (value.equals("ECESemester 4")) {
            Sem5Layout.setVisibility(View.GONE);
            Sem6Layout.setVisibility(View.GONE);
            Sem7Layout.setVisibility(View.GONE);
            Sem8Layout.setVisibility(View.GONE);
        }
        if (value.equals("ECESemester 5")) {
            Sem6Layout.setVisibility(View.GONE);
            Sem7Layout.setVisibility(View.GONE);
            Sem8Layout.setVisibility(View.GONE);
        }
        if (value.equals("ECESemester 6")) {

            Sem7Layout.setVisibility(View.GONE);
            Sem8Layout.setVisibility(View.GONE);

        }
        if (value.equals("ECESemester 7")) {
            Sem8Layout.setVisibility(View.GONE);
        }

        if (value.equals("EEESemester 2")) {
            Sem3Layout.setVisibility(View.GONE);
            Sem4Layout.setVisibility(View.GONE);
            Sem5Layout.setVisibility(View.GONE);
            Sem6Layout.setVisibility(View.GONE);
            Sem7Layout.setVisibility(View.GONE);
            Sem8Layout.setVisibility(View.GONE);

        }
        if (value.equals("EEESemester 3")) {
            Sem4Layout.setVisibility(View.GONE);
            Sem5Layout.setVisibility(View.GONE);
            Sem6Layout.setVisibility(View.GONE);
            Sem7Layout.setVisibility(View.GONE);
            Sem8Layout.setVisibility(View.GONE);
        }
        if (value.equals("EEESemester 4")) {
            Sem5Layout.setVisibility(View.GONE);
            Sem6Layout.setVisibility(View.GONE);
            Sem7Layout.setVisibility(View.GONE);
            Sem8Layout.setVisibility(View.GONE);

        }
        if (value.equals("EEESemester 5")) {
            Sem6Layout.setVisibility(View.GONE);
            Sem7Layout.setVisibility(View.GONE);
            Sem8Layout.setVisibility(View.GONE);

        }
        if (value.equals("EEESemester 6")) {

            Sem7Layout.setVisibility(View.GONE);
            Sem8Layout.setVisibility(View.GONE);

        }
        if (value.equals("EEESemester 7")) {
            Sem8Layout.setVisibility(View.GONE);

        }

        if (value.equals("MechanicalSemester 2")) {
            Sem3Layout.setVisibility(View.GONE);
            Sem4Layout.setVisibility(View.GONE);
            Sem5Layout.setVisibility(View.GONE);
            Sem6Layout.setVisibility(View.GONE);
            Sem7Layout.setVisibility(View.GONE);
            Sem8Layout.setVisibility(View.GONE);

        }
        if (value.equals("MechanicalSemester 3")) {
            Sem4Layout.setVisibility(View.GONE);
            Sem5Layout.setVisibility(View.GONE);
            Sem6Layout.setVisibility(View.GONE);
            Sem7Layout.setVisibility(View.GONE);
            Sem8Layout.setVisibility(View.GONE);

        }
        if (value.equals("MechanicalSemester 4")) {
            Sem5Layout.setVisibility(View.GONE);
            Sem6Layout.setVisibility(View.GONE);
            Sem7Layout.setVisibility(View.GONE);
            Sem8Layout.setVisibility(View.GONE);

        }
        if (value.equals("MechanicalSemester 5")) {
            Sem6Layout.setVisibility(View.GONE);
            Sem7Layout.setVisibility(View.GONE);
            Sem8Layout.setVisibility(View.GONE);

        }
        if (value.equals("MechanicalSemester 6")) {

            Sem7Layout.setVisibility(View.GONE);
            Sem8Layout.setVisibility(View.GONE);

        }
        if (value.equals("MechanicalSemester 7")) {
            Sem8Layout.setVisibility(View.GONE);

        }
    }

}