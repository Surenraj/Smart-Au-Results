package com.example.calcjit;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DecimalFormat;

public class Gpa2 extends AppCompatActivity {

    static final int RC_SIGN_IN = 123;
    GoogleSignInClient mGoogleSignInClient;

    FirebaseDatabase rootNode;
    DatabaseReference reference;
    DatabaseReference reference1;


    SharedPreferences sharedPreferences;
    TextView Textdepart,Textsem;
    TextView sub1,sub2,sub3,sub4,sub5,sub6,sub7,sub8,sub9,sub10;
    TextView calcGpa;
    Button Btn_calculate;
    TextView subcode1,subcode2,subcode3,subcode4,subcode5,subcode6,subcode7,subcode8,subcode9,subcode10;
    TextView Credit1,Credit2,Credit3,Credit4,Credit5,Credit6,Credit7,Credit8,Credit9,Credit10;
    Spinner Grade1,Grade2,Grade3,Grade4,Grade5,Grade6,Grade7,Grade8,Grade9,Grade10;
    LinearLayout LinearLayout4,LinearLayout5,LinearLayout6,LinearLayout7,LinearLayout8,LinearLayout9,LinearLayout10;

    AlertDialog.Builder alertDialog;
    Button SaveResult,signIn;
    ImageView CloseDialog;

    private static final String SHARED_PREF_NAME1 = "mypref";
    private static final String KEY_DEPARTMENT = "DEPARTMENT";
    private static final String KEY_SEMESTER = "SEMESTER";
    private static final String KEY_GRADE1 = "GRADE1";
    private static final String KEY_GRADE2 = "GRADE2";
    private static final String KEY_GRADE3 = "GRADE3";
    private static final String KEY_GRADE4 = "GRADE4";
    private static final String KEY_GRADE5 = "GRADE5";
    private static final String KEY_GRADE6 = "GRADE6";
    private static final String KEY_GRADE7 = "GRADE7";
    private static final String KEY_GRADE8 = "GRADE8";
    private static final String KEY_GRADE9 = "GRADE9";
    private static final String KEY_GRADE10 = "GRADE10";
    private static final String DEPARTMENT_SEMESTER = "DEPARTMENTSEM";
    private static final String SAVE_RESULT_GRADE1 = "SAVERESULTGRADE1";
    private static final String SAVE_RESULT_GRADE2 = "SAVERESULTGRADE2";
    private static final String SAVE_RESULT_GRADE3 = "SAVERESULTGRADE3";
    private static final String SAVE_RESULT_GRADE4 = "SAVERESULTGRADE4";
    private static final String SAVE_RESULT_GRADE5 = "SAVERESULTGRADE5";
    private static final String SAVE_RESULT_GRADE6 = "SAVERESULTGRADE6";
    private static final String SAVE_RESULT_GRADE7 = "SAVERESULTGRADE7";
    private static final String SAVE_RESULT_GRADE8 = "SAVERESULTGRADE8";
    private static final String SAVE_RESULT_GRADE9 = "SAVERESULTGRADE9";
    private static final String SAVE_RESULT_GRADE10 = "SAVERESULTGRADE10";
    private static final String FINAL_GPA = "FINALGPA";
    private static final String PERSON_NAME = null;
    private static final String PERSON_EMAIL = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpa2);


        LinearLayout4 = (LinearLayout) findViewById(R.id.linearlayout4);
        LinearLayout5 = (LinearLayout) findViewById(R.id.linearlayout5);
        LinearLayout6 = (LinearLayout) findViewById(R.id.linearlayout6);
        LinearLayout7 = (LinearLayout) findViewById(R.id.linearlayout7);
        LinearLayout8 = (LinearLayout) findViewById(R.id.linearlayout8);
        LinearLayout9 = (LinearLayout) findViewById(R.id.linearlayout9);
        LinearLayout10 = (LinearLayout) findViewById(R.id.linearlayout10);
        Textdepart= findViewById(R.id.textdepart);
        Textsem= findViewById(R.id.textsem);
        calcGpa = findViewById(R.id.textcalculate);


        SaveResult = findViewById(R.id.save_result);

        Btn_calculate=findViewById(R.id.btn_calculate);

        sub1 =findViewById(R.id.textsub1);
        sub2 =findViewById(R.id.textsub2);
        sub3 =findViewById(R.id.textsub3);
        sub4 =findViewById(R.id.textsub4);
        sub5 =findViewById(R.id.textsub5);
        sub6 =findViewById(R.id.textsub6);
        sub7 =findViewById(R.id.textsub7);
        sub8 =findViewById(R.id.textsub8);
        sub9 =findViewById(R.id.textsub9);
        sub10 =findViewById(R.id.textsub10);



        subcode1 =findViewById(R.id.textsubcode1);
        subcode2 =findViewById(R.id.textsubcode2);
        subcode3 =findViewById(R.id.textsubcode3);
        subcode4 =findViewById(R.id.textsubcode4);
        subcode5 =findViewById(R.id.textsubcode5);
        subcode6 =findViewById(R.id.textsubcode6);
        subcode7 =findViewById(R.id.textsubcode7);
        subcode8 =findViewById(R.id.textsubcode8);
        subcode9 =findViewById(R.id.textsubcode9);
        subcode10 =findViewById(R.id.textsubcode10);

        Credit1 =findViewById(R.id.credit1);
        Credit2 =findViewById(R.id.credit2);
        Credit3 =findViewById(R.id.credit3);
        Credit4 =findViewById(R.id.credit4);
        Credit5 =findViewById(R.id.credit5);
        Credit6 =findViewById(R.id.credit6);
        Credit7 =findViewById(R.id.credit7);
        Credit8 =findViewById(R.id.credit8);
        Credit9 =findViewById(R.id.credit9);
        Credit10 =findViewById(R.id.credit10);

        Grade1 = findViewById(R.id.grade1);
        Grade2 = findViewById(R.id.grade2);
        Grade3 = findViewById(R.id.grade3);
        Grade4 = findViewById(R.id.grade4);
        Grade5 = findViewById(R.id.grade5);
        Grade6 = findViewById(R.id.grade6);
        Grade7 = findViewById(R.id.grade7);
        Grade8 = findViewById(R.id.grade8);
        Grade9 = findViewById(R.id.grade9);
        Grade10 = findViewById(R.id.grade10);

        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("User");

        reference.child("test").setValue("hii");

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
         mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Context.MODE_PRIVATE);
        final String department = sharedPreferences.getString(KEY_DEPARTMENT, null);
        String semester = sharedPreferences.getString(KEY_SEMESTER, null);
        final String value = department+semester;
        Textdepart.setText(department);
        Textsem.setText(semester);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(DEPARTMENT_SEMESTER, value);
        editor.apply();


        SaveResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                // updateUI(GoogleSignInAccount)

//                rootNode = FirebaseDatabase.getInstance();
//                reference = rootNode.getReference(personame);
//
//                String grade1 = sharedPreferences.getString(SAVE_RESULT_GRADE1, null);
//                String grade2 = sharedPreferences.getString(SAVE_RESULT_GRADE2, null);
//                String grade3 = sharedPreferences.getString(SAVE_RESULT_GRADE3, null);
//                String grade4 = sharedPreferences.getString(SAVE_RESULT_GRADE4, null);
//                String grade5 = sharedPreferences.getString(SAVE_RESULT_GRADE5, null);
//                String grade6 = sharedPreferences.getString(SAVE_RESULT_GRADE6, null);
//                String grade7 = sharedPreferences.getString(SAVE_RESULT_GRADE7, null);
//                String grade8 = sharedPreferences.getString(SAVE_RESULT_GRADE8, null);
//                String grade9 = sharedPreferences.getString(SAVE_RESULT_GRADE9, null);
//                String grade10 = sharedPreferences.getString(SAVE_RESULT_GRADE10, null);
//                String gpa = sharedPreferences.getString(FINAL_GPA, null);
//                Toast.makeText(Gpa2.this, personame, Toast.LENGTH_SHORT).show();
//
//                UserHelperClass helperClass = new UserHelperClass(grade1, grade2, grade3, grade4, grade5, grade6, grade7, grade8, grade9, grade10, gpa);
//                reference.child(departmentSem).setValue(helperClass);



             //   if (personame == null) {

                    alertDialog = new AlertDialog.Builder(Gpa2.this);
                    alertDialog.setView(R.layout.custom_dialog_view);
                    final AlertDialog dialog = alertDialog.create();
                    dialog.show();

                    //Handling outside touch of Dialog---------------->
                    dialog.setCanceledOnTouchOutside(false);


                    CloseDialog = dialog.findViewById(R.id.close_dialog);
                    signIn = dialog.findViewById(R.id.signin_withgoogle);

                    //Closing the Dialog on clicking of the cross image------------->
                    CloseDialog.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                            Toast.makeText(Gpa2.this, "You Closed the Dialog", Toast.LENGTH_SHORT).show();
                        }
                    });

                    //Click Listener on Sync Button-------------------->
                    signIn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                            signIn();

//                            String personame = sharedPreferences.getString(PERSON_NAME, null);
//                            String personemail = sharedPreferences.getString(PERSON_EMAIL, null);

                        }
                    });
////                            sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Context.MODE_PRIVATE);
////                            String departmentSem = sharedPreferences.getString(DEPARTMENT_SEMESTER, null);
////                            rootNode = FirebaseDatabase.getInstance();
////                            reference = rootNode.getReference(personame);
////
////                            String grade1 = sharedPreferences.getString(SAVE_RESULT_GRADE1, null);
////                            String grade2 = sharedPreferences.getString(SAVE_RESULT_GRADE2, null);
////                            String grade3 = sharedPreferences.getString(SAVE_RESULT_GRADE3, null);
////                            String grade4 = sharedPreferences.getString(SAVE_RESULT_GRADE4, null);
////                            String grade5 = sharedPreferences.getString(SAVE_RESULT_GRADE5, null);
////                            String grade6 = sharedPreferences.getString(SAVE_RESULT_GRADE6, null);
////                            String grade7 = sharedPreferences.getString(SAVE_RESULT_GRADE7, null);
////                            String grade8 = sharedPreferences.getString(SAVE_RESULT_GRADE8, null);
////                            String grade9 = sharedPreferences.getString(SAVE_RESULT_GRADE9, null);
////                            String grade10 = sharedPreferences.getString(SAVE_RESULT_GRADE10, null);
////                            String gpa = sharedPreferences.getString(FINAL_GPA, null);
////
////                            UserHelperClass helperClass = new UserHelperClass(grade1, grade2, grade3, grade4, grade5, grade6, grade7, grade8, grade9, grade10, gpa);
////                            reference.child(departmentSem).setValue(helperClass);
//                            Toast.makeText(Gpa2.this, "Your Result saved Successfully", Toast.LENGTH_SHORT).show();
//                        }
//                    });
//                }
//                if (personame!=null){
//                    sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Context.MODE_PRIVATE);
//                    String departmentSem = sharedPreferences.getString(DEPARTMENT_SEMESTER, null);
//                    rootNode = FirebaseDatabase.getInstance();
//                    reference = rootNode.getReference(personame);
//
//                    String grade1 = sharedPreferences.getString(SAVE_RESULT_GRADE1, null);
//                    String grade2 = sharedPreferences.getString(SAVE_RESULT_GRADE2, null);
//                    String grade3 = sharedPreferences.getString(SAVE_RESULT_GRADE3, null);
//                    String grade4 = sharedPreferences.getString(SAVE_RESULT_GRADE4, null);
//                    String grade5 = sharedPreferences.getString(SAVE_RESULT_GRADE5, null);
//                    String grade6 = sharedPreferences.getString(SAVE_RESULT_GRADE6, null);
//                    String grade7 = sharedPreferences.getString(SAVE_RESULT_GRADE7, null);
//                    String grade8 = sharedPreferences.getString(SAVE_RESULT_GRADE8, null);
//                    String grade9 = sharedPreferences.getString(SAVE_RESULT_GRADE9, null);
//                    String grade10 = sharedPreferences.getString(SAVE_RESULT_GRADE10, null);
//                    String gpa = sharedPreferences.getString(FINAL_GPA, null);
//
//                    UserHelperClass helperClass = new UserHelperClass(grade1, grade2, grade3, grade4, grade5, grade6, grade7, grade8, grade9, grade10, gpa);
//                    reference.child("virat").setValue(helperClass);
                    // Toast.makeText(Gpa2.this, "Your Result saved Successfully"+ personemail, Toast.LENGTH_SHORT).show();
                    // }
                }

        });


        ArrayAdapter<CharSequence> adaptergrade1;
        ArrayAdapter<CharSequence> adaptergrade2;
        ArrayAdapter<CharSequence> adaptergrade3;
        ArrayAdapter<CharSequence> adaptergrade4;
        ArrayAdapter<CharSequence> adaptergrade5;
        ArrayAdapter<CharSequence> adaptergrade6;
        ArrayAdapter<CharSequence> adaptergrade7;
        ArrayAdapter<CharSequence> adaptergrade8;
        ArrayAdapter<CharSequence> adaptergrade9;
        ArrayAdapter<CharSequence> adaptergrade10;

        String[] grade = {"O","A+","A","B+","B","RA","SA","W","AB"};

        adaptergrade1 = new ArrayAdapter<CharSequence>(this,android.R.layout.simple_spinner_item,grade);
        adaptergrade1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Grade1.setAdapter(adaptergrade1);

        adaptergrade2 = new ArrayAdapter<CharSequence>(this,android.R.layout.simple_spinner_item,grade);
        adaptergrade2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Grade2.setAdapter(adaptergrade2);

        adaptergrade3 = new ArrayAdapter<CharSequence>(this,android.R.layout.simple_spinner_item,grade);
        adaptergrade3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Grade3.setAdapter(adaptergrade3);

        adaptergrade4 = new ArrayAdapter<CharSequence>(this,android.R.layout.simple_spinner_item,grade);
        adaptergrade4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Grade4.setAdapter(adaptergrade4);

        adaptergrade5 = new ArrayAdapter<CharSequence>(this,android.R.layout.simple_spinner_item,grade);
        adaptergrade5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Grade5.setAdapter(adaptergrade5);

        adaptergrade6 = new ArrayAdapter<CharSequence>(this,android.R.layout.simple_spinner_item,grade);
        adaptergrade6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Grade6.setAdapter(adaptergrade6);

        adaptergrade7 = new ArrayAdapter<CharSequence>(this,android.R.layout.simple_spinner_item,grade);
        adaptergrade7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Grade7.setAdapter(adaptergrade7);

        adaptergrade8 = new ArrayAdapter<CharSequence>(this,android.R.layout.simple_spinner_item,grade);
        adaptergrade8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Grade8.setAdapter(adaptergrade8);

        adaptergrade9 = new ArrayAdapter<CharSequence>(this,android.R.layout.simple_spinner_item,grade);
        adaptergrade9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Grade9.setAdapter(adaptergrade9);

        adaptergrade10 = new ArrayAdapter<CharSequence>(this,android.R.layout.simple_spinner_item,grade);
        adaptergrade10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Grade10.setAdapter(adaptergrade10);

        Grade1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String text = adapterView.getSelectedItem().toString();


                if (text.equals("O")) {
                    sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_GRADE1, "10");
                    editor.apply();
                }
                if (text.equals("A+")) {
                    sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_GRADE1, "9");
                    editor.apply();
                }
                if (text.equals("A")) {
                    sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_GRADE1, "8");
                    editor.apply();
                }
                if (text.equals("B+")) {
                    sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_GRADE1, "7");
                    editor.apply();
                }if (text.equals("B")){
                    sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_GRADE1, "6");
                    editor.apply();
                }
                if (text.equals("RA")||text.equals("SA")||text.equals("W")||text.equals("AB")){
                    sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_GRADE1, "0");
                    editor.apply();
                }
                sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(SAVE_RESULT_GRADE1, text);
                editor.apply();
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });
        Grade2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View arg1, int arg2, long arg3) {

                String text = adapterView.getSelectedItem().toString();
                if (text.equals("O")) {
                    sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_GRADE2, "10");
                    editor.apply();
                }
                if (text.equals("A+")) {
                    sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_GRADE2, "9");
                    editor.apply();
                }
                if (text.equals("A")) {
                    sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_GRADE2, "8");
                    editor.apply();
                }
                if (text.equals("B+")) {
                    sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_GRADE3, "7");
                    editor.apply();
                }if (text.equals("B")){
                    sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_GRADE2, "6");
                    editor.apply();
                }
                if (text.equals("RA")||text.equals("SA")||text.equals("W")||text.equals("AB")){
                    sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_GRADE2, "0");
                    editor.apply();
                }
                sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(SAVE_RESULT_GRADE2, text);
                editor.apply();
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });
        Grade3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View arg1, int arg2, long arg3) {

                String text = adapterView.getSelectedItem().toString();
                if (text.equals("O")) {
                    sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_GRADE3, "10");
                    editor.apply();
                }
                if (text.equals("A+")) {
                    sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_GRADE3, "9");
                    editor.apply();
                }
                if (text.equals("A")) {
                    sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_GRADE3, "8");
                    editor.apply();
                }
                if (text.equals("B+")) {
                    sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_GRADE3, "7");
                    editor.apply();
                }if (text.equals("B")){
                    sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_GRADE3, "6");
                    editor.apply();
                }
                if (text.equals("RA")||text.equals("SA")||text.equals("W")||text.equals("AB")){
                    sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_GRADE3, "0");
                    editor.apply();
                }
                sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(SAVE_RESULT_GRADE3, text);
                editor.apply();
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });
        Grade4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View arg1, int arg2, long arg3) {

                String text = adapterView.getSelectedItem().toString();
                if (text.equals("O")) {
                    sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_GRADE4, "10");
                    editor.apply();
                }
                if (text.equals("A+")) {
                    sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_GRADE4, "9");
                    editor.apply();
                }
                if (text.equals("A")) {
                    sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_GRADE4, "8");
                    editor.apply();
                }
                if (text.equals("B+")) {
                    sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_GRADE4, "7");
                    editor.apply();
                }if (text.equals("B")){
                    sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_GRADE4, "6");
                    editor.apply();
                }
                if (text.equals("RA")||text.equals("SA")||text.equals("W")||text.equals("AB")){
                    sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_GRADE4, "0");
                    editor.apply();
                }
                sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(SAVE_RESULT_GRADE4, text);
                editor.apply();
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });
        Grade5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View arg1, int arg2, long arg3) {

                String text = adapterView.getSelectedItem().toString();
                if (text.equals("O")) {
                    sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_GRADE5, "10");
                    editor.apply();
                }
                if (text.equals("A+")) {
                    sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_GRADE5, "9");
                    editor.apply();
                }
                if (text.equals("A")) {
                    sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_GRADE5, "8");
                    editor.apply();
                }
                if (text.equals("B+")) {
                    sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_GRADE5, "7");
                    editor.apply();
                }if (text.equals("B")){
                    sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_GRADE5, "6");
                    editor.apply();
                }
                if (text.equals("RA")||text.equals("SA")||text.equals("W")||text.equals("AB")){
                    sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_GRADE5, "0");
                    editor.apply();
                }
                sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(SAVE_RESULT_GRADE5, text);
                editor.apply();
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });
        Grade6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View arg1, int arg2, long arg3) {

                String text = adapterView.getSelectedItem().toString();
                if (text.equals("O")) {
                    sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_GRADE6, "10");
                    editor.apply();
                }
                if (text.equals("A+")) {
                    sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_GRADE6, "9");
                    editor.apply();
                }
                if (text.equals("A")) {
                    sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_GRADE6, "8");
                    editor.apply();
                }
                if (text.equals("B+")) {
                    sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_GRADE6, "7");
                    editor.apply();
                }if (text.equals("B")){
                    sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_GRADE6, "6");
                    editor.apply();
                }
                if (text.equals("RA")||text.equals("SA")||text.equals("W")||text.equals("AB")){
                    sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_GRADE6, "0");
                    editor.apply();
                }
                sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(SAVE_RESULT_GRADE6, text);
                editor.apply();
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });
        Grade7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View arg1, int arg2, long arg3) {

                String text = adapterView.getSelectedItem().toString();
                if (text.equals("O")) {
                    sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_GRADE7, "10");
                    editor.apply();
                }
                if (text.equals("A+")) {
                    sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_GRADE7, "9");
                    editor.apply();
                }
                if (text.equals("A")) {
                    sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_GRADE7, "8");
                    editor.apply();
                }
                if (text.equals("B+")) {
                    sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_GRADE7, "7");
                    editor.apply();
                }if (text.equals("B")){
                    sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_GRADE7, "6");
                    editor.apply();
                }
                if (text.equals("RA")||text.equals("SA")||text.equals("W")||text.equals("AB")){
                    sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_GRADE7, "0");
                    editor.apply();
                }
                sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(SAVE_RESULT_GRADE7, text);
                editor.apply();
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });
        Grade8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()

    {
        @Override
        public void onItemSelected (AdapterView < ? > adapterView, View arg1,int arg2, long arg3){

        String text = adapterView.getSelectedItem().toString();
        if (text.equals("O")) {
            sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(KEY_GRADE8, "10");
            editor.apply();
        }
        if (text.equals("A+")) {
            sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(KEY_GRADE8, "9");
            editor.apply();
        }
        if (text.equals("A")) {
            sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(KEY_GRADE8, "8");
            editor.apply();
        }
        if (text.equals("B+")) {
            sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(KEY_GRADE8, "7");
            editor.apply();
        }
        if (text.equals("B")) {
            sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(KEY_GRADE8, "6");
            editor.apply();
        }
        if (text.equals("RA") || text.equals("SA") || text.equals("W") || text.equals("AB")) {
            sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(KEY_GRADE8, "0");
            editor.apply();
        }
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SAVE_RESULT_GRADE8, text);
        editor.apply();
    }
        @Override
        public void onNothingSelected (AdapterView < ? > arg0) {
            // TODO Auto-generated method stub
        }
        });
        Grade9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View arg1, int arg2, long arg3) {

                String text = adapterView.getSelectedItem().toString();
                if (text.equals("O")) {
                    sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_GRADE9, "10");
                    editor.apply();
                }
                if (text.equals("A+")) {
                    sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_GRADE9, "9");
                    editor.apply();
                }
                if (text.equals("A")) {
                    sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_GRADE9, "8");
                    editor.apply();
                }
                if (text.equals("B+")) {
                    sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_GRADE9, "7");
                    editor.apply();
                }if (text.equals("B")){
                    sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_GRADE9, "6");
                    editor.apply();
                }
                if (text.equals("RA")||text.equals("SA")||text.equals("W")||text.equals("AB")){
                    sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_GRADE9, "0");
                    editor.apply();
                }
                sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(SAVE_RESULT_GRADE9, text);
                editor.apply();
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });
        Grade10.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View arg1, int arg2, long arg3) {

                String text = adapterView.getSelectedItem().toString();
                if (text.equals("O")) {
                    sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_GRADE10, "10");
                    editor.apply();
                }
                if (text.equals("A+")) {
                    sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_GRADE10, "9");
                    editor.apply();
                }
                if (text.equals("A")) {
                    sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_GRADE10, "8");
                    editor.apply();
                }
                if (text.equals("B+")) {
                    sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_GRADE10, "7");
                    editor.apply();
                }if (text.equals("B")){
                    sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_GRADE10, "6");
                    editor.apply();
                }
                if (text.equals("RA")||text.equals("SA")||text.equals("W")||text.equals("AB")){
                    sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_GRADE10, "0");
                    editor.apply();
                }
                sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(SAVE_RESULT_GRADE10, text);
                editor.apply();
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        Btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SaveResult.setVisibility(View.VISIBLE);

                if (value.equals("CSESemester 1")){
                    CseSemester1();
                }if (value.equals("CSESemester 2")){
                    CseSemester2();
                }if (value.equals("CSESemester 3")){
                    CseSemester3();
                }if (value.equals("CSESemester 4")){
                    CseSemester4();
                }if (value.equals("CSESemester 5")){
                    CseSemester5();
                }if (value.equals("CSESemester 6")){
                    CseSemester6();
                }if (value.equals("CSESemester 7")){
                    CseSemester7();
                }if (value.equals("CSESemester 8")){
                    CseSemester8();
                }

                if (value.equals("ITSemester 1")) {
                    ItSemester1();
                }if (value.equals("ITSemester 2")) {
                    ItSemester2();
                }if (value.equals("ITSemester 3")) {
                    ItSemester3();
                }if (value.equals("ITSemester 4")) {
                    ItSemester4();
                }if (value.equals("ITSemester 5")) {
                    ItSemester5();
                }if (value.equals("ITSemester 6")) {
                    ItSemester6();
                }if (value.equals("ITSemester 7")) {
                    ItSemester7();
                }if (value.equals("ITSemester 8")) {
                    ItSemester8();
                }

                if (value.equals("ECESemester 1")) {
                    EceSemester1();
                }if (value.equals("ECESemester 2")) {
                    EceSemester2();
                }if (value.equals("ECESemester 3")) {
                    EceSemester3();
                }if (value.equals("ECESemester 4")) {
                    EceSemester4();
                }if (value.equals("ECESemester 5")) {
                    EceSemester5();
                }if (value.equals("ECESemester 6")) {
                    EceSemester6();
                }if (value.equals("ECESemester 7")) {
                    EceSemester7();
                }if (value.equals("ECESemester 8")) {
                    EceSemester8();
                }

                if (value.equals("EEESemester 1")) {
                    EeeSemester1();
                }if (value.equals("EEESemester 2")) {
                    EeeSemester2();
                }if (value.equals("EEESemester 3")) {
                    EeeSemester3();
                }if (value.equals("EEESemester 4")) {
                    EeeSemester4();
                }if (value.equals("EEESemester 5")) {
                    EeeSemester5();
                }if (value.equals("EEESemester 6")) {
                    EeeSemester6();
                }if (value.equals("EEESemester 7")) {
                    EeeSemester7();
                }if (value.equals("EEESemester 8")) {
                    EeeSemester8();
                }

                if (value.equals("MechanicalSemester 1")) {
                    MechanicalSemester1();
                }if (value.equals("MechanicalSemester 2")) {
                    MechanicalSemester2();
                }if (value.equals("MechanicalSemester 3")) {
                    MechanicalSemester3();
                }if (value.equals("MechanicalSemester 4")) {
                    MechanicalSemester4();
                }if (value.equals("MechanicalSemester 5")) {
                    MechanicalSemester5();
                }if (value.equals("MechanicalSemester 6")) {
                    MechanicalSemester6();
                }if (value.equals("MechanicalSemester 7")) {
                    MechanicalSemester7();
                }if (value.equals("MechanicalSemester 8")) {
                    MechanicalSemester8();
                }
            }
        });

        if (value.equals("CSESemester 1")){

            sub1.setText("1. Communicative English");
            subcode1.setText("Subject code- HS8151");
            Credit1.setText("4");

            sub2.setText("2. Mathematics I");
            subcode2.setText("Subject code- MA8151");
            Credit2.setText("4");

            sub3.setText("3. Engineering Physics");
            subcode3.setText("Subject code- PH8151");
            Credit3.setText("3");

            sub4.setText("4. Engineering Chemistry");
            subcode4.setText("Subject code- CY8151");
            Credit4.setText("3");

            sub5.setText("5. Prob Solving & Python programming");
            subcode5.setText("Subject code- GE8151");
            Credit5.setText("3");

            sub6.setText("6. Engineering Graphics");
            subcode6.setText("Subject code- GE8152");
            Credit6.setText("4");
            sub7.setText("7. Prob Solving& Python \n    Programming Lab");
            subcode7.setText("Subject code- GE8161");
            Credit7.setText("2");

            sub8.setText("8. Physics & Chemistry Lab");
            subcode8.setText("Subject code- BS8161");
            Credit8.setText("2");

            LinearLayout9.setVisibility(View.GONE);
            LinearLayout10.setVisibility(View.GONE);

        }
        if (value.equals("CSESemester 2")){

            sub1.setText("1. Technical English");
            subcode1.setText("Subject code- HS8251");
            Credit1.setText("4");

            sub2.setText("2. Mathematics II");
            subcode2.setText("Subject code- MA8251");
            Credit2.setText("4");

            sub3.setText("3. Physics for Information Science");
            subcode3.setText("Subject code- PH8252");
            Credit3.setText("3");

            sub4.setText("4. Basic Electrical & Measurement Engineering");
            subcode4.setText("Subject code- BE8255");
            Credit4.setText("3");

            sub5.setText("5. Environmental Science & Engineering");
            subcode5.setText("Subject code- GE8291");
            Credit5.setText("3");

            sub6.setText("6. Programming in C");
            subcode6.setText("Subject code- CS8251");
            Credit6.setText("3");

            sub7.setText("7. C Programming lab");
            subcode7.setText("Subject code- CS8261");
            Credit7.setText("2");

            sub8.setText("8. Engineering Practices Lab");
            subcode8.setText("Subject code- GE8261");
            Credit8.setText("2");

            LinearLayout9.setVisibility(View.GONE);
            LinearLayout10.setVisibility(View.GONE);
        }
        if (value.equals("CSESemester 3")){
            sub1.setText("1. Discrete Mathematics");
            subcode1.setText("Subject code- MA8351");
            Credit1.setText("4");

            sub2.setText("2. Digital Principles & System Design");
            subcode2.setText("Subject code- CS8351");
            Credit2.setText("4");

            sub3.setText("3. Data Structures");
            subcode3.setText("Subject code- CS8391");
            Credit3.setText("3");

            sub4.setText("4 Object Oriented Programming");
            subcode4.setText("Subject code- CS8392");
            Credit4.setText("3");

            sub5.setText("5. Communication Engineering");
            subcode5.setText("Subject code- EC8395");
            Credit5.setText("3");

            sub6.setText("6. Data Structures Lab");
            subcode6.setText("Subject code- CS8381");
            Credit6.setText("2");

            sub7.setText("7. Object Oriented programming Lab");
            subcode7.setText("Subject code- CS8383");
            Credit7.setText("2");

            sub8.setText("8. Digital Systems Lab");
            subcode8.setText("Subject code- CS8382");
            Credit8.setText("2");

            sub9.setText("9. Interpersonal Skills Listening &Speaking");
            subcode9.setText("Subject code- HS8381");
            Credit9.setText("1");

            LinearLayout10.setVisibility(View.GONE);
        }
        if (value.equals("CSESemester 4")){
            sub1.setText("1. Probability & Queueing Theory");
            subcode1.setText("Subject code- MA8402");
            Credit1.setText("4");

            sub2.setText("2. Computer Architecture");
            subcode2.setText("Subject code- CS8491");
            Credit2.setText("3");

            sub3.setText("3. Database Management Systems");
            subcode3.setText("Subject code- CS8492");
            Credit3.setText("3");

            sub4.setText("4. Design and Analysis of Algorithms");
            subcode4.setText("Subject code- CS8451");
            Credit4.setText("3");

            sub5.setText("5. Operating Systems");
            subcode5.setText("Subject code- CS8493");
            Credit5.setText("3");

            sub6.setText("6. Software Engineering");
            subcode6.setText("Subject code- CS8494");
            Credit6.setText("3");

            sub7.setText("7. Operating Systems Lab");
            subcode7.setText("Subject code- CS8461");
            Credit7.setText("2");

            sub8.setText("8. Database Management Systems Lab");
            subcode8.setText("Subject code- CS8481");
            Credit8.setText("2");

            sub9.setText("9. Advanced Reading & Writing");
            subcode9.setText("Subject code- HS8461");
            Credit9.setText("1");
            LinearLayout10.setVisibility(View.GONE);
        }
        if (value.equals("CSESemester 5")){
            sub1.setText("1. Algebra & Number theory");
            subcode1.setText("Subject code- MA8551");
            Credit1.setText("4");

            sub2.setText("2. Computer Networks");
            subcode2.setText("Subject code- CS8591");
            Credit2.setText("3");

            sub3.setText("3. Microprocessors and Microcontrollers");
            subcode3.setText("Subject code- EC8691");
            Credit3.setText("3");

            sub4.setText("4. Theory of Computation");
            subcode4.setText("Subject code- CS8501");
            Credit4.setText("3");

            sub5.setText("5. Object Oriented Analysis & Design");
            subcode5.setText("Subject code- CS8592");
            Credit5.setText("3");

            sub6.setText("6. Open Elective I");
            subcode6.setVisibility(View.GONE);
            Credit6.setText("3");

            sub7.setText("7. Microprocessors and Microcontrollers Lab");
            subcode7.setText("Subject code- EC8681");
            Credit7.setText("2");

            sub8.setText("8. Object Oriented Analysis & Design Lab");
            subcode8.setText("Subject code- CS8582");
            Credit8.setText("2");

            sub9.setText("9. Networks Lab");
            subcode9.setText("Subject code- CS8581");
            Credit9.setText("2");

            LinearLayout10.setVisibility(View.GONE);
        }
        if (value.equals("CSESemester 6")){
            sub1.setText("1. Internet Programming");
            subcode1.setText("Subject code- CS8651");
            Credit1.setText("3");

            sub2.setText("2. Artificial Intelligence");
            subcode2.setText("Subject code- CS8691");
            Credit2.setText("3");

            sub3.setText("3. Mobile Computing");
            subcode3.setText("Subject code- CS8601");
            Credit3.setText("3");

            sub4.setText("4. Compiler Design");
            subcode4.setText("Subject code- CS8602");
            Credit4.setText("4");

            sub5.setText("5. Distributed Systems");
            subcode5.setText("Subject code- CS8603");
            Credit5.setText("3");

            sub6.setText("6. Professional Elective I");
            subcode6.setVisibility(View.GONE);
            Credit6.setText("3");

            sub7.setText("7. Internet Programming Lab");
            subcode7.setText("Subject code- CS8661");
            Credit7.setText("2");

            sub8.setText("8. Mobile Application Development Lab");
            subcode8.setText("Subject code- CS8662");
            Credit8.setText("2");

            sub9.setText("9. Mini Project");
            subcode9.setText("Subject code- CS8611");
            Credit9.setText("1");

            sub10.setText("10. Professional Communication");
            subcode10.setText("Subject code- HS8581");
            Credit10.setText("1");
        }
        if (value.equals("CSESemester 7")){
            sub1.setText("1. Principles of Management");
            subcode1.setText("Subject code- MG8591");
            Credit1.setText("3");

            sub2.setText("2. Cryptography & Network Security");
            subcode2.setText("Subject code- CS8792");
            Credit2.setText("3");

            sub3.setText("3. Cloud Computing");
            subcode3.setText("Subject code- CS8791");
            Credit3.setText("3");

            sub4.setText("4. Open Elective II");
            subcode4.setVisibility(View.GONE);
            Credit4.setText("3");

            sub5.setText("5. Professional Elective II");
            subcode5.setVisibility(View.GONE);
            Credit5.setText("3");

            sub6.setText("6. Professional Elective III");
            subcode6.setVisibility(View.GONE);
            Credit6.setText("3");

            sub7.setText("7. Cloud Computing Lab");
            subcode7.setText("Subject code- CS8711");
            Credit7.setText("2");

            sub8.setText("8. Security Lab");
            subcode8.setText("Subject code- IT8761");
            Credit8.setText("2");

            LinearLayout9.setVisibility(View.GONE);
            LinearLayout10.setVisibility(View.GONE);
        }
        if (value.equals("CSESemester 8")){
            sub1.setText("1. Professional Elective IV");
            subcode1.setText("Subject code- CS6801");
            Credit1.setText("3");

            sub2.setText("2. Professional Elective V");
            subcode2.setVisibility(View.GONE);
            Credit2.setText("3");

            sub3.setText("3. Project Work");
            subcode3.setText("Subject code- CS8811");
            Credit3.setText("10");
            LinearLayout4.setVisibility(View.GONE);
            LinearLayout5.setVisibility(View.GONE);
            LinearLayout6.setVisibility(View.GONE);
            LinearLayout7.setVisibility(View.GONE);
            LinearLayout8.setVisibility(View.GONE);
            LinearLayout9.setVisibility(View.GONE);
            LinearLayout10.setVisibility(View.GONE);


        }

        if (value.equals("ITSemester 1")){

            sub1.setText("1. Communicative English");
            subcode1.setText("Subject code- HS8151");
            Credit1.setText("4");

            sub2.setText("2. Mathematics I");
            subcode2.setText("Subject code- MA8151");
            Credit2.setText("4");

            sub3.setText("3. Engineering Physics");
            subcode3.setText("Subject code- PH8151");
            Credit3.setText("3");

            sub4.setText("4. Engineering Chemistry");
            subcode4.setText("Subject code- CY8151");
            Credit4.setText("3");

            sub5.setText("5. Prob Solving & Python programming");
            subcode5.setText("Subject code- GE8151");
            Credit5.setText("3");

            sub6.setText("6. Engineering Graphics");
            subcode6.setText("Subject code- GE8152");
            Credit6.setText("4");

            sub7.setText("7. Prob Solving& Python \n    Programming Lab");
            subcode7.setText("Subject code- GE8161");
            Credit7.setText("2");

            sub8.setText("8. Physics & Chemistry Lab");
            subcode8.setText("Subject code- BS8161");
            Credit8.setText("2");

            LinearLayout9.setVisibility(View.GONE);
            LinearLayout10.setVisibility(View.GONE);
        }
        if (value.equals("ITSemester 2")){

            sub1.setText("1. Technical English");
            subcode1.setText("Subject code- HS8251");
            Credit1.setText("4");

            sub2.setText("2. Mathematics II");
            subcode2.setText("Subject code- MA8251");
            Credit2.setText("4");

            sub3.setText("3. Physics for Information Science");
            subcode3.setText("Subject code- PH8252");
            Credit3.setText("3");

            sub4.setText("4. Basic Electrical & Measurement Engineering");
            subcode4.setText("Subject code- BE8255");
            Credit4.setText("3");

            sub5.setText("5. Information Technology Essentials");
            subcode5.setText("Subject code- IT8201");
            Credit5.setText("3");

            sub6.setText("6. Programming in C");
            subcode6.setText("Subject code- CS8251");
            Credit6.setText("3");

            sub7.setText("7. C Programming lab");
            subcode7.setText("Subject code- CS8261");
            Credit7.setText("2");

            sub8.setText("8. Engineering Practices Lab");
            subcode8.setText("Subject code- GE8261");
            Credit8.setText("2");

            sub9.setText("9. Information tech essentials Lab");
            subcode9.setText("Subject code- IT8211");
            Credit9.setText("1");
            LinearLayout10.setVisibility(View.GONE);
        }
        if (value.equals("ITSemester 3")){
            sub1.setText("1. Discrete Mathematics");
            subcode1.setText("Subject code- MA8351");
            Credit1.setText("4");

            sub2.setText("2. Digital Principles & System Design");
            subcode2.setText("Subject code- CS8351");
            Credit2.setText("4");

            sub3.setText("3. Data Structures");
            subcode3.setText("Subject code- CS8391");
            Credit3.setText("3");

            sub4.setText("4 Object Oriented Programming");
            subcode4.setText("Subject code- CS8392");
            Credit4.setText("3");

            sub5.setText("5. Analog and Digital Communication");
            subcode5.setText("Subject code- EC8394");
            Credit5.setText("3");

            sub6.setText("6. Data Structures Lab");
            subcode6.setText("Subject code- CS8381");
            Credit6.setText("2");

            sub7.setText("7. Object Oriented programming Lab");
            subcode7.setText("Subject code- CS8383");
            Credit7.setText("2");

            sub8.setText("8. Digital Systems Lab");
            subcode8.setText("Subject code- CS8382");
            Credit8.setText("2");

            sub9.setText("9. Interpersonal Skills Listening &Speaking");
            subcode9.setText("Subject code- HS8381");
            Credit9.setText("1");

            LinearLayout10.setVisibility(View.GONE);
        }
        if (value.equals("ITSemester 4")){
            sub1.setText("1. Probability and Statistics");
            subcode1.setText("Subject code- MA8391");
            Credit1.setText("4");

            sub2.setText("2. Computer Architecture");
            subcode2.setText("Subject code- CS8491");
            Credit2.setText("3");

            sub3.setText("3. Database Management Systems");
            subcode3.setText("Subject code- CS8492");
            Credit3.setText("3");

            sub4.setText("4. Design and Analysis of Algorithms");
            subcode4.setText("Subject code- CS8451");
            Credit4.setText("3");

            sub5.setText("5. Operating Systems");
            subcode5.setText("Subject code- CS8493");
            Credit5.setText("3");

            sub6.setText("6. Environmental Science and Engineering");
            subcode6.setText("Subject code- GE8291");
            Credit6.setText("3");

            sub7.setText("7. Operating Systems Lab");
            subcode7.setText("Subject code- CS8461");
            Credit7.setText("2");

            sub8.setText("8. Database Management Systems Lab");
            subcode8.setText("Subject code- CS8481");
            Credit8.setText("2");

            sub9.setText("9. Advanced Reading & Writing");
            subcode9.setText("Subject code- HS8461");
            Credit9.setText("1");
            LinearLayout10.setVisibility(View.GONE);
        }
        if (value.equals("ITSemester 5")){
            sub1.setText("1. Algebra & Number theory");
            subcode1.setText("Subject code- MA8551");
            Credit1.setText("4");

            sub2.setText("2. Computer Networks");
            subcode2.setText("Subject code- CS8591");
            Credit2.setText("3");

            sub3.setText("3. Microprocessors and Microcontrollers");
            subcode3.setText("Subject code- EC8691");
            Credit3.setText("3");

            sub4.setText("4. Web Technology");
            subcode4.setText("Subject code- IT8501");
            Credit4.setText("3");

            sub5.setText("5. Software Engineering");
            subcode5.setText("Subject code- CS8494");
            Credit5.setText("3");

            sub6.setText("6. Open Elective I");
            subcode6.setVisibility(View.GONE);
            Credit6.setText("3");

            sub7.setText("7. Microprocessors and Microcontrollers Lab");
            subcode7.setText("Subject code- EC8681");
            Credit7.setText("2");

            sub8.setText("8. Networks Lab");
            subcode8.setText("Subject code- CS8581");
            Credit8.setText("2");

            sub9.setText("9. Web Technology Lab");
            subcode9.setText("Subject code- IT8511");
            Credit9.setText("2");
            LinearLayout10.setVisibility(View.GONE);
        }
        if (value.equals("ITSemester 6")){
            sub1.setText("1. Computational Intelligence");
            subcode1.setText("Subject code- IT8601");
            Credit1.setText("3");

            sub2.setText("2. Object Oriented Analysis and Design");
            subcode2.setText("Subject code- CS8592");
            Credit2.setText("3");

            sub3.setText("3. Mobile Communication");
            subcode3.setText("Subject code- IT8602");
            Credit3.setText("3");

            sub4.setText("4. Big Data Analytics");
            subcode4.setText("Subject code- CS8091");
            Credit4.setText("4");

            sub5.setText("5. Computer Graphics and Multimedia");
            subcode5.setText("Subject code- CS8092");
            Credit5.setText("3");

            sub6.setText("6. Professional Elective I");
            subcode6.setVisibility(View.GONE);
            Credit6.setText("3");

            sub7.setText("7. Object Oriented Analysis and Design Lab");
            subcode7.setText("Subject code- CS8582");
            Credit7.setText("2");

            sub8.setText("8. Mobile Application Development Lab");
            subcode8.setText("Subject code- CS8662");
            Credit8.setText("2");

            sub9.setText("9. Mini Project");
            subcode9.setText("Subject code- CS8611");
            Credit9.setText("1");

            sub10.setText("10. Professional Communication");
            subcode10.setText("Subject code- HS8581");
            Credit10.setText("1");
        }
        if (value.equals("ITSemester 7")){
            sub1.setText("1. Principles of Management");
            subcode1.setText("Subject code- MG8591");
            Credit1.setText("3");

            sub2.setText("2. Cryptography & Network Security");
            subcode2.setText("Subject code- CS8792");
            Credit2.setText("3");

            sub3.setText("3. Cloud Computing");
            subcode3.setText("Subject code- CS8791");
            Credit3.setText("3");

            sub4.setText("4. Open Elective II");
            subcode4.setVisibility(View.GONE);
            Credit4.setText("3");

            sub5.setText("5. Professional Elective II");
            subcode5.setVisibility(View.GONE);
            Credit5.setText("3");

            sub6.setText("6. Professional Elective III");
            subcode6.setVisibility(View.GONE);
            Credit6.setText("3");

            sub7.setText("7. FOSS and Cloud Computing Lab");
            subcode7.setText("Subject code- IT8711");
            Credit7.setText("2");

            sub8.setText("8. Security Lab");
            subcode8.setText("Subject code- IT8761");
            Credit8.setText("2");

            LinearLayout9.setVisibility(View.GONE);
            LinearLayout10.setVisibility(View.GONE);
        }
        if (value.equals("ITSemester 8")){
            sub1.setText("1. Professional Elective IV");
            subcode1.setVisibility(View.GONE);
            Credit1.setText("3");

            sub2.setText("2. Professional Elective V");
            subcode2.setVisibility(View.GONE);
            Credit2.setText("3");

            sub3.setText("3. Project Work");
            subcode3.setText("Subject code- IT8811");
            Credit3.setText("10");
            LinearLayout4.setVisibility(View.GONE);
            LinearLayout5.setVisibility(View.GONE);
            LinearLayout6.setVisibility(View.GONE);
            LinearLayout7.setVisibility(View.GONE);
            LinearLayout8.setVisibility(View.GONE);
            LinearLayout9.setVisibility(View.GONE);
            LinearLayout10.setVisibility(View.GONE);
        }

        if (value.equals("ECESemester 1")){

            sub1.setText("1. Communicative English");
            subcode1.setText("Subject code- HS8151");
            Credit1.setText("4");

            sub2.setText("2. Mathematics I");
            subcode2.setText("Subject code- MA8151");
            Credit2.setText("4");

            sub3.setText("3. Engineering Physics");
            subcode3.setText("Subject code- PH8151");
            Credit3.setText("3");

            sub4.setText("4. Engineering Chemistry");
            subcode4.setText("Subject code- CY8151");
            Credit4.setText("3");

            sub5.setText("5. Prob Solving & Python programming");
            subcode5.setText("Subject code- GE8151");
            Credit5.setText("3");

            sub6.setText("6. Engineering Graphics");
            subcode6.setText("Subject code- GE8152");
            Credit6.setText("4");

            sub7.setText("7. Prob Solving& Python \n    Programming Lab");
            subcode7.setText("Subject code- GE8161");
            Credit7.setText("2");

            sub8.setText("8. Physics & Chemistry Lab");
            subcode8.setText("Subject code- BS8161");
            Credit8.setText("2");

            LinearLayout9.setVisibility(View.GONE);
            LinearLayout10.setVisibility(View.GONE);
        }
        if (value.equals("ECESemester 2")){

            sub1.setText("1. Technical English");
            subcode1.setText("Subject code- HS8251");
            Credit1.setText("4");

            sub2.setText("2. Mathematics II");
            subcode2.setText("Subject code- MA8251");
            Credit2.setText("4");

            sub3.setText("3. Physics for Information Science");
            subcode3.setText("Subject code- PH8252");
            Credit3.setText("3");

            sub4.setText("4. Basic Electrical & Instrumentation Engineering");
            subcode4.setText("Subject code- BE8254");
            Credit4.setText("3");

            sub5.setText("5. Circuit Analysis");
            subcode5.setText("Subject code- EC8251");
            Credit5.setText("4");

            sub6.setText("6. Electronic Devices");
            subcode6.setText("Subject code- EC8252");
            Credit6.setText("3");

            sub7.setText("7. Circuits & Devices Lab");
            subcode7.setText("Subject code- EC8261");
            Credit7.setText("2");

            sub8.setText("8. Engineering Practices Lab");
            subcode8.setText("Subject code- GE8261");
            Credit8.setText("2");

            LinearLayout9.setVisibility(View.GONE);
            LinearLayout10.setVisibility(View.GONE);
        }
        if (value.equals("ECESemester 3")){
            sub1.setText("1. Linear Algebra & Partial Differential Equation");
            subcode1.setText("Subject code- MA8352");
            Credit1.setText("4");

            sub2.setText("2. Fundamentals of Data Structures In C");
            subcode2.setText("Subject code- EC8393");
            Credit2.setText("3");

            sub3.setText("3. Electronic Circuits- I");
            subcode3.setText("Subject code- EC8351");
            Credit3.setText("3");

            sub4.setText("4 Signals and Systems");
            subcode4.setText("Subject code- EC8352");
            Credit4.setText("4");

            sub5.setText("5. Digital Electronics");
            subcode5.setText("Subject code- EC8392");
            Credit5.setText("3");

            sub6.setText("6. Control Systems Engineering");
            subcode6.setText("Subject code- EC8391");
            Credit6.setText("3");

            sub7.setText("7.Fundamentals of Data Structures In C Lab");
            subcode7.setText("Subject code- EC8381");
            Credit7.setText("2");

            sub8.setText("8. Analog and Digital Circuits Lab");
            subcode8.setText("Subject code- EC8361");
            Credit8.setText("2");

            sub9.setText("9. Interpersonal Skills Listening &Speaking");
            subcode9.setText("Subject code- HS8381");
            Credit9.setText("1");

            LinearLayout10.setVisibility(View.GONE);
        }
        if (value.equals("ECESemester 4")){
            sub1.setText("1. Probability & Random Processes");
            subcode1.setText("Subject code- MA8451");
            Credit1.setText("4");

            sub2.setText("2. Electronic Circuits II");
            subcode2.setText("Subject code- EC8452");
            Credit2.setText("3");

            sub3.setText("3. Communication Theory");
            subcode3.setText("Subject code- EC8491");
            Credit3.setText("3");

            sub4.setText("4. Electromagnetic Fields");
            subcode4.setText("Subject code- EC8451");
            Credit4.setText("4");

            sub5.setText("5. Linear Integrated Circuits");
            subcode5.setText("Subject code- EC8453");
            Credit5.setText("3");

            sub6.setText("6. Environmental Science & Engineering");
            subcode6.setText("Subject code- GE8291");
            Credit6.setText("3");

            sub7.setText("7. circuits design & simulation lab");
            subcode7.setText("Subject code- EC8461");
            Credit7.setText("2");

            sub8.setText("8. Linear Integrated Circuit Lab");
            subcode8.setText("Subject code- EC8462");
            Credit8.setText("2");

            LinearLayout9.setVisibility(View.GONE);
            LinearLayout10.setVisibility(View.GONE);
        }
        if (value.equals("ECESemester 5")){
            sub1.setText("1. Digital Communication");
            subcode1.setText("Subject code- EC8501");
            Credit1.setText("3");

            sub2.setText("2. Discrete-Time Signal Processing");
            subcode2.setText("Subject code- EC8553");
            Credit2.setText("4");

            sub3.setText("3. Computer Architecture & Organization");
            subcode3.setText("Subject code- EC8552");
            Credit3.setText("3");

            sub4.setText("4. Communication Networks");
            subcode4.setText("Subject code- EC8551");
            Credit4.setText("3");

            sub5.setText("5. Professional Elective I");
            subcode5.setVisibility(View.GONE);
            Credit5.setText("3");

            sub6.setText("6. Open Elective I");
            subcode6.setVisibility(View.GONE);
            Credit6.setText("3");

            sub7.setText("7. Digital Signal Processing lab");
            subcode7.setText("Subject code- EC85622");
            Credit7.setText("2");

            sub8.setText("8. Communication System Lab");
            subcode8.setText("Subject code- EC8561");
            Credit8.setText("2");

            sub9.setText("9. Communication Networks Lab");
            subcode9.setText("Subject code- EC8563");
            Credit9.setText("2");

            LinearLayout10.setVisibility(View.GONE);
        }
        if (value.equals("ECESemester 6")){
            sub1.setText("1. Microprocessors and Microcontrollers");
            subcode1.setText("Subject code- EC8691");
            Credit1.setText("3");

            sub2.setText("2. VLSI Design");
            subcode2.setText("Subject code- EC8095");
            Credit2.setText("3");

            sub3.setText("3. Wireless Communication");
            subcode3.setText("Subject code- EC8652");
            Credit3.setText("3");

            sub4.setText("4. Principles of Management");
            subcode4.setText("Subject code- MG8591");
            Credit4.setText("3");

            sub5.setText("5. Transmission Lines & RF Systems");
            subcode5.setText("Subject code- EC8651");
            Credit5.setText("3");

            sub6.setText("6. Professional Elective I");
            subcode6.setVisibility(View.GONE);
            Credit6.setText("3");

            sub7.setText("7. Microprocessors & Microcontrollers Laboratory");
            subcode7.setText("Subject code- EC8681");
            Credit7.setText("2");

            sub8.setText("8. VLSI Design Lab");
            subcode8.setText("Subject code- EC8661");
            Credit8.setText("2");

            sub9.setText("9. Technical Seminar");
            subcode9.setText("Subject code- EC8611");
            Credit9.setText("1");

            sub10.setText("10. Professional Communication");
            subcode10.setText("Subject code- EC8611");
            Credit10.setText("1");
        }
        if (value.equals("ECESemester 7")){
            sub1.setText("1. Antennas and Microwave Engineering");
            subcode1.setText("Subject code- EC8701");
            Credit1.setText("3");

            sub2.setText("2. Optical Communication");
            subcode2.setText("Subject code- EC8751");
            Credit2.setText("3");

            sub3.setText("3. Embedded & Real Tme Systems");
            subcode3.setText("Subject code- EC8791");
            Credit3.setText("3");

            sub4.setText("4. Ad hoc and Wireless Sensor Networks");
            subcode4.setText("Subject code- EC8702");
            Credit4.setText("3");

            sub5.setText("5. Professional Elective III");
            subcode5.setVisibility(View.GONE);
            Credit5.setText("3");

            sub6.setText("6. Open Elective II");
            subcode6.setVisibility(View.GONE);
            Credit6.setText("3");

            sub7.setText("7. Embedded Lab");
            subcode7.setText("Subject code- EC8711");
            Credit7.setText("2");

            sub8.setText("8. Advanced Communication Lab");
            subcode8.setText("Subject code- EC8761");
            Credit8.setText("2");

            LinearLayout9.setVisibility(View.GONE);
            LinearLayout10.setVisibility(View.GONE);
        }
        if (value.equals("ECESemester 8")){
            sub1.setText("1. Professional Elective IV");
            subcode1.setVisibility(View.GONE);
            Credit1.setText("3");

            sub2.setText("2. Professional Elective V");
            subcode2.setVisibility(View.GONE);
            Credit2.setText("3");

            sub3.setText("3. Project Work");
            subcode3.setText("Subject code- EC8811");
            Credit3.setText("10");
            LinearLayout4.setVisibility(View.GONE);
            LinearLayout5.setVisibility(View.GONE);
            LinearLayout6.setVisibility(View.GONE);
            LinearLayout7.setVisibility(View.GONE);
            LinearLayout8.setVisibility(View.GONE);
            LinearLayout9.setVisibility(View.GONE);
            LinearLayout10.setVisibility(View.GONE);


        }

        if (value.equals("EEESemester 1")){

            sub1.setText("1. Communicative English");
            subcode1.setText("Subject code- HS8151");
            Credit1.setText("4");

            sub2.setText("2. Mathematics I");
            subcode2.setText("Subject code- MA8151");
            Credit2.setText("4");

            sub3.setText("3. Engineering Physics");
            subcode3.setText("Subject code- PH8151");
            Credit3.setText("3");

            sub4.setText("4. Engineering Chemistry");
            subcode4.setText("Subject code- CY8151");
            Credit4.setText("3");

            sub5.setText("5. Prob Solving & Python programming");
            subcode5.setText("Subject code- GE8151");
            Credit5.setText("3");

            sub6.setText("6. Engineering Graphics");
            subcode6.setText("Subject code- GE8152");
            Credit6.setText("4");

            sub7.setText("7. Prob Solving& Python \n    Programming Lab");
            subcode7.setText("Subject code- GE8161");
            Credit7.setText("2");

            sub8.setText("8. Physics & Chemistry Lab");
            subcode8.setText("Subject code- BS8161");
            Credit8.setText("2");

            LinearLayout9.setVisibility(View.GONE);
            LinearLayout10.setVisibility(View.GONE);
        }
        if (value.equals("EEESemester 2")){

            sub1.setText("1. Technical English");
            subcode1.setText("Subject code- HS8251");
            Credit1.setText("4");

            sub2.setText("2. Mathematics II");
            subcode2.setText("Subject code- MA8251");
            Credit2.setText("4");

            sub3.setText("3. Physics for Information Science");
            subcode3.setText("Subject code- PH8252");
            Credit3.setText("3");

            sub4.setText("4. Basic Civil & Mechanical Engineering");
            subcode4.setText("Subject code- BE8252");
            Credit4.setText("4");

            sub5.setText("5. Environmental Science & Engineering");
            subcode5.setText("Subject code- GE8291");
            Credit5.setText("3");

            sub6.setText("6. Circuit Theory");
            subcode6.setText("Subject code- EE8251");
            Credit6.setText("3");

            sub7.setText("7. Electric Circuits Lab");
            subcode7.setText("Subject code- EE8261");
            Credit7.setText("2");

            sub8.setText("8. Engineering Practices Lab");
            subcode8.setText("Subject code- GE8261");
            Credit8.setText("2");

            LinearLayout9.setVisibility(View.GONE);
            LinearLayout10.setVisibility(View.GONE);
        }
        if (value.equals("EEESemester 3")){
            sub1.setText("1. Transforms & Partial Differential Equations");
            subcode1.setText("Subject code- MA8351");
            Credit1.setText("4");

            sub2.setText("2. Digital Logic Circuits");
            subcode2.setText("Subject code-  EE8351");
            Credit2.setText("3");

            sub3.setText("3. Electromagnetic Theory");
            subcode3.setText("Subject code- EE8391");
            Credit3.setText("3");

            sub4.setText("4. Electrical Machines - I");
            subcode4.setText("Subject code- EE8301");
            Credit4.setText("4");

            sub5.setText("5. Electronic Devices & Circuits");
            subcode5.setText("Subject code- EC8353");
            Credit5.setText("3");

            sub6.setText("6. Power Plan Enginnering");
            subcode6.setText("Subject code- ME8792");
            Credit6.setText("3");

            sub7.setText("7. Electronics Lab");
            subcode7.setVisibility(View.GONE);
            Credit7.setText("2");

            sub8.setText("8. Electrical Machines Lab I");
            subcode8.setVisibility(View.GONE);
            Credit8.setText("2");

            LinearLayout9.setVisibility(View.GONE);
            LinearLayout10.setVisibility(View.GONE);
        }
        if (value.equals("EEESemester 4")){
            sub1.setText("1. Numerical Methods");
            subcode1.setText("Subject code- MA8491");
            Credit1.setText("4");

            sub2.setText("2. Electrical Machines I");
            subcode2.setText("Subject code- EE8401");
            Credit2.setText("3");

            sub3.setText("3. Transmission & Distribution");
            subcode3.setText("Subject code- EE8402");
            Credit3.setText("3");

            sub4.setText("4. Measurements and Instrumentation");
            subcode4.setText("Subject code- EE8403");
            Credit4.setText("3");

            sub5.setText("5. Linear Integrated Circuits & Applications");
            subcode5.setText("Subject code- EE8451");
            Credit5.setText("3");

            sub6.setText("6. Control Systems");
            subcode6.setText("Subject code- IC8451");
            Credit6.setText("3");

            sub7.setText("7. Electrical Machines Lab II");
            subcode7.setText("Subject code- EE8411");
            Credit7.setText("2");

            sub8.setText("8. Linear & Digital Integrated Circuits Lab");
            subcode8.setText("Subject code- EE8461");
            Credit8.setText("2");

            sub9.setText("9. Technical Seminar");
            subcode9.setText("Subject code- EE8412");
            Credit9.setText("1");
            LinearLayout10.setVisibility(View.GONE);
        }
        if (value.equals("EEESemester 5")){
            sub1.setText("1. Power System Analysis");
            subcode1.setText("Subject code- EE8501");
            Credit1.setText("3");

            sub2.setText("2. Microprocessors & Microcontrollers");
            subcode2.setText("Subject code- EE8551");
            Credit2.setText("3");

            sub3.setText("3. Power Engineering");
            subcode3.setText("Subject code- EE8552");
            Credit3.setText("3");

            sub4.setText("4. Digital Signal Processing");
            subcode4.setText("Subject code- EE8591");
            Credit4.setText("3");

            sub5.setText("5. Object Oriented Programming");
            subcode5.setText("Subject code- CS8392 ");
            Credit5.setText("3");

            sub6.setText("6. Open Elective I");
            subcode6.setVisibility(View.GONE);
            Credit6.setText("3");

            sub7.setText("7. EControl & Instrumentation Lab");
            subcode7.setText("Subject code- EE8511");
            Credit7.setText("2");

            sub8.setText("8. Professional Communication");
            subcode8.setText("Subject code- HS8581");
            Credit8.setText("1");

            sub9.setText("9. Object Oriented Programming Lab");
            subcode9.setText("Subject code- CS8383");
            Credit9.setText("2");
            LinearLayout10.setVisibility(View.GONE);
        }
        if (value.equals("EEESemester 6")){
            sub1.setText("1. Solid State Drives");
            subcode1.setText("Subject code- EE8601");
            Credit1.setText("3");

            sub2.setText("2. Protection and Switchgear");
            subcode2.setText("Subject code- EE8602");
            Credit2.setText("3");

            sub3.setText("3. Embedded Systems");
            subcode3.setText("Subject code- EE8691");
            Credit3.setText("3");

            sub4.setText("4. Professional Elective I");
            subcode4.setVisibility(View.GONE);
            Credit4.setText("3");

            sub5.setText("5. Professional Elective II");
            subcode5.setVisibility(View.GONE);
            Credit5.setText("3");

            sub6.setText("6. Power Electronics and Drives Lab");
            subcode6.setText("Subject code- EE8661");
            Credit6.setText("2");

            sub7.setText("7. Microproce & Micro controller Lab");
            subcode7.setText("Subject code- EE8681");
            Credit7.setText("2");

            sub8.setText("8. Mini Project");
            subcode8.setText("Subject code- EE8611");
            Credit8.setText("2");

            LinearLayout9.setVisibility(View.GONE);
            LinearLayout10.setVisibility(View.GONE);
        }
        if (value.equals("EEESemester 7")){
            sub1.setText("1. High Voltage Engineering");
            subcode1.setText("Subject code- EE8701");
            Credit1.setText("3");

            sub2.setText("2. Power System Operation and Control");
            subcode2.setText("Subject code- EE8702");
            Credit2.setText("3");

            sub3.setText("3. Renewable Energy Systems");
            subcode3.setText("Subject code- EE8703");
            Credit3.setText("3");

            sub4.setText("4. Open Elective II");
            subcode4.setVisibility(View.GONE);
            Credit4.setText("3");

            sub5.setText("5. Professional Elective III");
            subcode5.setVisibility(View.GONE);
            Credit5.setText("3");

            sub6.setText("6. Professional Elective IV");
            subcode6.setVisibility(View.GONE);
            Credit6.setText("3");

            sub7.setText("7. Power System Simulation Lab");
            subcode7.setText("Subject code- EE8711");
            Credit7.setText("2");

            sub8.setText("8. Renewable Energy Systems Lab");
            subcode8.setText("Subject code- EE8712");
            Credit8.setText("2");

            LinearLayout9.setVisibility(View.GONE);
            LinearLayout10.setVisibility(View.GONE);
        }
        if (value.equals("EEESemester 8")){
            sub1.setText("1. Professional Elective V");
            subcode1.setVisibility(View.GONE);
            Credit1.setText("3");

            sub2.setText("2. Professional Elective V");
            subcode2.setVisibility(View.GONE);
            Credit2.setText("3");

            sub3.setText("3. Project Work");
            subcode3.setText("Subject code- EE8811");
            Credit3.setText("10");
            LinearLayout4.setVisibility(View.GONE);
            LinearLayout5.setVisibility(View.GONE);
            LinearLayout6.setVisibility(View.GONE);
            LinearLayout7.setVisibility(View.GONE);
            LinearLayout8.setVisibility(View.GONE);
            LinearLayout9.setVisibility(View.GONE);
            LinearLayout10.setVisibility(View.GONE);


        }
        if (value.equals("MechanicalSemester 1")){

            sub1.setText("1. Communicative English");
            subcode1.setText("Subject code- HS8151");
            Credit1.setText("4");

            sub2.setText("2. Mathematics I");
            subcode2.setText("Subject code- MA8151");
            Credit2.setText("4");

            sub3.setText("3. Engineering Physics");
            subcode3.setText("Subject code- PH8151");
            Credit3.setText("3");

            sub4.setText("4. Engineering Chemistry");
            subcode4.setText("Subject code- CY8151");
            Credit4.setText("3");

            sub5.setText("5. Prob Solving & Python programming");
            subcode5.setText("Subject code- GE8151");
            Credit5.setText("3");

            sub6.setText("6. Engineering Graphics");
            subcode6.setText("Subject code- GE8152");
            Credit6.setText("4");

            sub7.setText("7. Prob Solving& Python \n    Programming Lab");
            subcode7.setText("Subject code- GE8161");
            Credit7.setText("2");

            sub8.setText("8. Physics & Chemistry Lab");
            subcode8.setText("Subject code- BS8161");
            Credit8.setText("2");

            LinearLayout9.setVisibility(View.GONE);
            LinearLayout10.setVisibility(View.GONE);
        }
        if (value.equals("MechanicalSemester 2")){

            sub1.setText("1. Technical English");
            subcode1.setText("Subject code- HS8251");
            Credit1.setText("4");

            sub2.setText("2. Mathematics II");
            subcode2.setText("Subject code- MA8251");
            Credit2.setText("4");

            sub3.setText("3. Materials Science");
            subcode3.setText("Subject code- PH8251");
            Credit3.setText("3");

            sub4.setText("4. Basic Electri, Electronics & Instr Engi");
            subcode4.setText("Subject code- BE8253");
            Credit4.setText("3");

            sub5.setText("5. Environmental Science & Engineering");
            subcode5.setText("Subject code- GE8291");
            Credit5.setText("3");

            sub6.setText("6. Engineering Mechanics");
            subcode6.setText("Subject code- GE8292");
            Credit6.setText("4");

            sub7.setText("7. Basic Electri, Electronics & Instr Engi lab");
            subcode7.setText("Subject code- BE8261");
            Credit7.setText("2");

            sub8.setText("8. Engineering Practices Lab");
            subcode8.setText("Subject code- GE8261");
            Credit8.setText("2");

            LinearLayout9.setVisibility(View.GONE);
            LinearLayout10.setVisibility(View.GONE);
        }
        if (value.equals("MechanicalSemester 3")){
            sub1.setText("1. Transforms and Partial Differential Equations");
            subcode1.setText("Subject code- MA8353");
            Credit1.setText("4");

            sub2.setText("2. Engineering Thermodynamics");
            subcode2.setText("Subject code-  ME8391");
            Credit2.setText("4");

            sub3.setText("3. Fluid Mechanics and Machinery");
            subcode3.setText("Subject code- CE8394");
            Credit3.setText("3");

            sub4.setText("4. Manufacturing Technology I");
            subcode4.setText("Subject code- ME8351");
            Credit4.setText("3");

            sub5.setText("5. Electrical Drives and Controls");
            subcode5.setText("Subject code- EE8353");
            Credit5.setText("3");

            sub6.setText("6. Manufacturing Technology Lab");
            subcode6.setText("Subject code- ME8361");
            Credit6.setText("2");

            sub7.setText("7. Computer Aided Machine Drawing");
            subcode7.setText("Subject code- ME8381");
            Credit7.setText("2");

            sub8.setText("8. Electrical Engineering Lab");
            subcode8.setText("Subject code- EE8361");
            Credit8.setText("2");

            sub9.setText("9. Interpersonal Skills / Listening & Speaking");
            subcode9.setText("Subject code- HS8381");
            Credit9.setText("1");


            LinearLayout10.setVisibility(View.GONE);
        }
        if (value.equals("MechanicalSemester 4")){
            sub1.setText("1. Statistics and Numerical Methods");
            subcode1.setText("Subject code- MA8452");
            Credit1.setText("4");

            sub2.setText("2. Kinematics of Machinery");
            subcode2.setText("Subject code- ME8492");
            Credit2.setText("3");

            sub3.setText("3. Manufacturing Technology II");
            subcode3.setText("Subject code- ME8451");
            Credit3.setText("3");

            sub4.setText("4. Engineering Metallurgy");
            subcode4.setText("Subject code- ME8491");
            Credit4.setText("3");

            sub5.setText("5. Strength of Materials for Mechanical Engineers");
            subcode5.setText("Subject code- CE8395");
            Credit5.setText("3");

            sub6.setText("6. Thermal Engineering- I");
            subcode6.setText("Subject code- ME8493");
            Credit6.setText("3");

            sub7.setText("7. Manufacturing Technology Lab-II");
            subcode7.setText("Subject code- ME8462");
            Credit7.setText("2");

            sub8.setText("8. Strength of Materials & fluid MM Lab");
            subcode8.setText("Subject code- CE8381");
            Credit8.setText("2");

            sub9.setText("9. Advanced Reading and Writing");
            subcode9.setText("Subject code- HS8461");
            Credit9.setText("1");
            LinearLayout10.setVisibility(View.GONE);
        }
        if (value.equals("MechanicalSemester 5")){
            sub1.setText("1. Thermal Engineering- II");
            subcode1.setText("Subject code- ME8595");
            Credit1.setText("3");

            sub2.setText("2. Design of Machine Elements");
            subcode2.setText("Subject code- ME8593");
            Credit2.setText("3");

            sub3.setText("3. Metrology and Measurements");
            subcode3.setText("Subject code- ME8511");
            Credit3.setText("3");

            sub4.setText("4. Dynamics of Machines");
            subcode4.setText("Subject code- ME8594");
            Credit4.setText("4");

            sub5.setText("5. Open Elective I");
            subcode5.setVisibility(View.GONE);
            Credit5.setText("3");

            sub6.setText("6. Kinematics and Dynamics Lab");
            subcode6.setText("Subject code- ME8511");
            Credit6.setText("3");

            sub7.setText("7. Thermal Engineering Lab");
            subcode7.setText("Subject code-  ME8512");
            Credit7.setText("2");

            sub8.setText("8. Metrology and Measurements Lab");
            subcode8.setText("Subject code- ME8513");
            Credit8.setText("2");

            LinearLayout9.setVisibility(View.GONE);
            LinearLayout10.setVisibility(View.GONE);
        }
        if (value.equals("MechanicalSemester 6")){
            sub1.setText("1. Design of Transmission Systems");
            subcode1.setText("Subject code- ME8651");
            Credit1.setText("3");

            sub2.setText("2. Computer Aided Design & Manufacturing");
            subcode2.setText("Subject code- ME8691");
            Credit2.setText("3");

            sub3.setText("3. Heat and Mass Transfer");
            subcode3.setText("Subject code- ME8693");
            Credit3.setText("4");

            sub4.setText("4. Finite Element Analysis");
            subcode4.setText("Subject code- ME8692");
            Credit4.setText("3");

            sub5.setText("5. Hydraulics and Pneumatics");
            subcode5.setText("Subject code- ME8694");
            Credit5.setText("3");

            sub6.setText("6. Professional Elective I");
            subcode6.setVisibility(View.GONE);
            Credit6.setText("3");

            sub7.setText("7. CAD CAM LAb");
            subcode7.setText("Subject code- ME8681");
            Credit7.setText("2");

            sub8.setText("8. Design & Fabrication Project");
            subcode8.setText("Subject code- ME8682");
            Credit8.setText("2");

            sub9.setText("9. Professional Communication");
            subcode9.setText("Subject code- HS8581");
            Credit9.setText("1");

            LinearLayout10.setVisibility(View.GONE);
        }
        if (value.equals("MechanicalSemester 7")){
            sub1.setText("1. Power Plant Engineering");
            subcode1.setText("Subject code- ME8792");
            Credit1.setText("3");

            sub2.setText("2. Process Planning and Cost Estimation");
            subcode2.setText("Subject code- ME8793");
            Credit2.setText("3");

            sub3.setText("3. Mechatronics");
            subcode3.setText("Subject code- ME8791");
            Credit3.setText("3");

            sub4.setText("4. Open Elective - II");
            subcode4.setVisibility(View.GONE);
            Credit4.setText("3");

            sub5.setText("5. Professional Elective- II");
            subcode5.setVisibility(View.GONE);
            Credit5.setText("3");

            sub6.setText("6. Professional Elective- III");
            subcode6.setVisibility(View.GONE);
            Credit6.setText("3");

            sub7.setText("7. Simulation & Analysis LAb");
            subcode7.setText("Subject code- ME8711");
            Credit7.setText("2");

            sub8.setText("8. Mechatronics Lab");
            subcode8.setText("Subject code- ME8781");
            Credit8.setText("2");

            sub9.setText("9. Technical Seminar");
            subcode9.setText("Subject code- ME8712");
            Credit9.setText("1");

            LinearLayout10.setVisibility(View.GONE);
        }
        if (value.equals("MechanicalSemester 8")){
            sub1.setText("1. Principles of Management");
            subcode1.setText("Subject code- MG8591");
            Credit1.setText("3");

            sub2.setText("2. Professional Elective– IV");
            subcode2.setVisibility(View.GONE);
            Credit2.setText("3");

            sub3.setText("3. Project Work");
            subcode3.setText("Subject code- EE8811");
            Credit3.setText("10");
            LinearLayout4.setVisibility(View.GONE);
            LinearLayout5.setVisibility(View.GONE);
            LinearLayout6.setVisibility(View.GONE);
            LinearLayout7.setVisibility(View.GONE);
            LinearLayout8.setVisibility(View.GONE);
            LinearLayout9.setVisibility(View.GONE);
            LinearLayout10.setVisibility(View.GONE);
        }
    }



    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }else {
            Toast.makeText(this, "Signin Error", Toast.LENGTH_SHORT).show();
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            // Signed in successfully, show authenticated UI.
            String name = account.getDisplayName();
            String email = account.getEmail();

            sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Context.MODE_PRIVATE);
            String departmentSem = sharedPreferences.getString(DEPARTMENT_SEMESTER, null);

            rootNode = FirebaseDatabase.getInstance();
            reference = rootNode.getReference(name);

            String grade1 = sharedPreferences.getString(SAVE_RESULT_GRADE1, null);
            String grade2 = sharedPreferences.getString(SAVE_RESULT_GRADE2, null);
            String grade3 = sharedPreferences.getString(SAVE_RESULT_GRADE3, null);
            String grade4 = sharedPreferences.getString(SAVE_RESULT_GRADE4, null);
            String grade5 = sharedPreferences.getString(SAVE_RESULT_GRADE5, null);
            String grade6 = sharedPreferences.getString(SAVE_RESULT_GRADE6, null);
            String grade7 = sharedPreferences.getString(SAVE_RESULT_GRADE7, null);
            String grade8 = sharedPreferences.getString(SAVE_RESULT_GRADE8, null);
            String grade9 = sharedPreferences.getString(SAVE_RESULT_GRADE9, null);
            String grade10 = sharedPreferences.getString(SAVE_RESULT_GRADE10, null);
            String gpa = sharedPreferences.getString(FINAL_GPA, null);

            UserHelperClass helperClass = new UserHelperClass(grade1, grade2, grade3, grade4, grade5, grade6, grade7, grade8, grade9, grade10, gpa);
            reference.child(departmentSem ).setValue(helperClass);
            Toast.makeText(this, name+ email, Toast.LENGTH_SHORT).show();
            //updateUI(account);
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w("Error", "signInResult:failed code=" + e.getStatusCode());
            //updateUI(null);
        }
    }

//    private void updateUI(GoogleSignInAccount account){
//        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
//        String name = account.getDisplayName();
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putString(PERSON_NAME, name);
//        editor.apply();
//
//        String email = account.getEmail();
//        SharedPreferences.Editor editor1 = sharedPreferences.edit();
//        editor1.putString(PERSON_EMAIL, email);
//        editor1.apply();
//
//        Toast.makeText(this, name+ email, Toast.LENGTH_SHORT).show();
//    }


    private void CseSemester1(){

        String sub1gradenum = sharedPreferences.getString(KEY_GRADE1, null);
        String sub2gradenum = sharedPreferences.getString(KEY_GRADE2, null);
        String sub3gradenum = sharedPreferences.getString(KEY_GRADE3, null);
        String sub4gradenum = sharedPreferences.getString(KEY_GRADE4, null);
        String sub5gradenum = sharedPreferences.getString(KEY_GRADE5, null);
        String sub6gradenum = sharedPreferences.getString(KEY_GRADE6, null);
        String sub7gradenum = sharedPreferences.getString(KEY_GRADE7, null);
        String sub8gradenum = sharedPreferences.getString(KEY_GRADE8, null);

        double sub1grade= Double.parseDouble(sub1gradenum);
        double sub2grade= Double.parseDouble(sub2gradenum);
        double sub3grade= Double.parseDouble(sub3gradenum);
        double sub4grade= Double.parseDouble(sub4gradenum);
        double sub5grade= Double.parseDouble(sub5gradenum);
        double sub6grade= Double.parseDouble(sub6gradenum);
        double sub7grade= Double.parseDouble(sub7gradenum);
        double sub8grade= Double.parseDouble(sub8gradenum);

        double s1= 4;
        double s2= 4;
        double s3= 3;
        double s4= 3;
        double s5= 3;
        double s6= 4;
        double s7= 2;
        double s8= 2;

        double creditTotal= s1+ s2+ s3+ s4+ s5+ s6+ s7+ s8;

        if (sub1grade==0.000){
            s1= 0;
        }
        if (sub2grade==0.000){
            s2=0;
        }
        if(sub3grade==0.000){
            s3=0;
        }
        if (sub4grade==0.000){
            s4=0;
        }
        if (sub5grade==0.000){
            s5=0;
        }
        if (sub6grade==0.000){
            s6=0;
        }
        if (sub7grade==0.000){
            s7=0;
        }
        if (sub8grade==0.000){
            s8=0;
        }
        double totalgpa = (sub1grade * s1 + sub2grade * s2+ sub3grade* s3 + sub4grade* s4+
                sub5grade* s5 + sub6grade* s6 +sub7grade* s7 + sub8grade * s8)/creditTotal;

        DecimalFormat numberFormat = new DecimalFormat("#.000");

        String a = numberFormat.format(totalgpa);

        calcGpa.setText(a);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(FINAL_GPA, a);
        editor.apply();
    }
    private void CseSemester2(){
        String sub1gradenum = sharedPreferences.getString(KEY_GRADE1, null);
        String sub2gradenum = sharedPreferences.getString(KEY_GRADE2, null);
        String sub3gradenum = sharedPreferences.getString(KEY_GRADE3, null);
        String sub4gradenum = sharedPreferences.getString(KEY_GRADE4, null);
        String sub5gradenum = sharedPreferences.getString(KEY_GRADE5, null);
        String sub6gradenum = sharedPreferences.getString(KEY_GRADE6, null);
        String sub7gradenum = sharedPreferences.getString(KEY_GRADE7, null);
        String sub8gradenum = sharedPreferences.getString(KEY_GRADE8, null);

        double sub1grade= Double.parseDouble(sub1gradenum);
        double sub2grade= Double.parseDouble(sub2gradenum);
        double sub3grade= Double.parseDouble(sub3gradenum);
        double sub4grade= Double.parseDouble(sub4gradenum);
        double sub5grade= Double.parseDouble(sub5gradenum);
        double sub6grade= Double.parseDouble(sub6gradenum);
        double sub7grade= Double.parseDouble(sub7gradenum);
        double sub8grade= Double.parseDouble(sub8gradenum);

        double s1 =4;
        double s2= 4;
        double s3= 3;
        double s4=3;
        double s5=3;
        double s6=3;
        double s7=2;
        double s8=2;

        double creditTotal= s1+ s2+ s3+ s4+ s5+ s6+ s7+ s8;

        if (sub1grade==0.000){
            s1= 0;
        }
        if (sub2grade==0.000){
            s2=0;
        }
        if(sub3grade==0.000){
            s3=0;
        }
        if (sub4grade==0.000){
            s4=0;
        }
        if (sub5grade==0.000){
            s5=0;
        }
        if (sub6grade==0.000){
            s6=0;
        }
        if (sub7grade==0.000){
            s7=0;
        }
        if (sub8grade==0.000){
            s8=0;
        }

        double totalgpa = (sub1grade* s1+ sub2grade* s2+ sub3grade* s3+ sub4grade* s4+
                sub5grade * s5+ sub6grade* s6+ sub7grade* s7+ sub8grade* s8)/creditTotal;

        DecimalFormat numberFormat = new DecimalFormat("#.000");

        String a = numberFormat.format(totalgpa);

        calcGpa.setText(a);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(FINAL_GPA, a);
        editor.apply();
    }
    private void CseSemester3(){
        String sub1gradenum = sharedPreferences.getString(KEY_GRADE1, null);
        String sub2gradenum = sharedPreferences.getString(KEY_GRADE2, null);
        String sub3gradenum = sharedPreferences.getString(KEY_GRADE3, null);
        String sub4gradenum = sharedPreferences.getString(KEY_GRADE4, null);
        String sub5gradenum = sharedPreferences.getString(KEY_GRADE5, null);
        String sub6gradenum = sharedPreferences.getString(KEY_GRADE6, null);
        String sub7gradenum = sharedPreferences.getString(KEY_GRADE7, null);
        String sub8gradenum = sharedPreferences.getString(KEY_GRADE8, null);
        String sub9gradenum = sharedPreferences.getString(KEY_GRADE9, null);

        double sub1grade= Double.parseDouble(sub1gradenum);
        double sub2grade= Double.parseDouble(sub2gradenum);
        double sub3grade= Double.parseDouble(sub3gradenum);
        double sub4grade= Double.parseDouble(sub4gradenum);
        double sub5grade= Double.parseDouble(sub5gradenum);
        double sub6grade= Double.parseDouble(sub6gradenum);
        double sub7grade= Double.parseDouble(sub7gradenum);
        double sub8grade= Double.parseDouble(sub8gradenum);
        double sub9grade= Double.parseDouble(sub9gradenum);

        double s1 = 4;
        double s2 = 4;
        double s3 = 3;
        double s4 = 3;
        double s5 = 3;
        double s6 = 3;
        double s7 = 2;
        double s8 = 2;
        double s9 = 1;

        double creditTotal= s1+ s2+ s3+ s4+ s5+ s6+ s7+ s8+ s9;

        if (sub1grade==0.000){
            s1= 0;
        }
        if (sub2grade==0.000){
            s2=0;
        }
        if(sub3grade==0.000){
            s3=0;
        }
        if (sub4grade==0.000){
            s4=0;
        }
        if (sub5grade==0.000){
            s5=0;
        }
        if (sub6grade==0.000){
            s6=0;
        }
        if (sub7grade==0.000){
            s7=0;
        }
        if (sub8grade==0.000){
            s8=0;
        }
        if (sub9grade==0.000){
            s9=0;
        }
        double totalgpa= (sub1grade* s1+ sub2grade * s2+ sub3grade * s3+ sub4grade* s4+
                sub5grade * s5 + sub6grade* s6 + sub7grade * s7+ sub8grade* s8 + sub9grade* s9)/creditTotal;

        DecimalFormat numberFormat = new DecimalFormat("#.000");

        String a = numberFormat.format(totalgpa);

        calcGpa.setText(a);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(FINAL_GPA, a);
        editor.apply();
    }
    private void CseSemester4(){

        String sub1gradenum = sharedPreferences.getString(KEY_GRADE1, null);
        String sub2gradenum = sharedPreferences.getString(KEY_GRADE2, null);
        String sub3gradenum = sharedPreferences.getString(KEY_GRADE3, null);
        String sub4gradenum = sharedPreferences.getString(KEY_GRADE4, null);
        String sub5gradenum = sharedPreferences.getString(KEY_GRADE5, null);
        String sub6gradenum = sharedPreferences.getString(KEY_GRADE6, null);
        String sub7gradenum = sharedPreferences.getString(KEY_GRADE7, null);
        String sub8gradenum = sharedPreferences.getString(KEY_GRADE8, null);
        String sub9gradenum = sharedPreferences.getString(KEY_GRADE9, null);

        double sub1grade= Double.parseDouble(sub1gradenum);
        double sub2grade= Double.parseDouble(sub2gradenum);
        double sub3grade= Double.parseDouble(sub3gradenum);
        double sub4grade= Double.parseDouble(sub4gradenum);
        double sub5grade= Double.parseDouble(sub5gradenum);
        double sub6grade= Double.parseDouble(sub6gradenum);
        double sub7grade= Double.parseDouble(sub7gradenum);
        double sub8grade= Double.parseDouble(sub8gradenum);
        double sub9grade= Double.parseDouble(sub9gradenum);

        double s1= 4;
        double s2= 3;
        double s3= 3;
        double s4= 3;
        double s5= 3;
        double s6= 3;
        double s7= 2;
        double s8= 2;
        double s9= 1;

        double creditTotal= s1+ s2+ s3+ s4+ s5+ s6+ s7+ s8+ s9;

        if (sub1grade==0.000){
            s1= 0;
        }
        if (sub2grade==0.000){
            s2=0;
        }
        if(sub3grade==0.000){
            s3=0;
        }
        if (sub4grade==0.000){
            s4=0;
        }
        if (sub5grade==0.000){
            s5=0;
        }
        if (sub6grade==0.000){
            s6=0;
        }
        if (sub7grade==0.000){
            s7=0;
        }
        if (sub8grade==0.000){
            s8=0;
        }
        if (sub9grade==0.000){
            s9=0;
        }

        double totalgpa= ( sub1grade* s1+ sub2grade* s2+ sub3grade * s3+ sub4grade * s4+
                sub5grade* s5+ sub6grade * s6+sub7grade* s7+ sub8grade* s8+ sub9grade* s9)/creditTotal;

        DecimalFormat numberFormat = new DecimalFormat("#.000");

        String a = numberFormat.format(totalgpa);

        calcGpa.setText(a);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(FINAL_GPA, a);
        editor.apply();

    }
    private void CseSemester5(){
        String sub1gradenum = sharedPreferences.getString(KEY_GRADE1, null);
        String sub2gradenum = sharedPreferences.getString(KEY_GRADE2, null);
        String sub3gradenum = sharedPreferences.getString(KEY_GRADE3, null);
        String sub4gradenum = sharedPreferences.getString(KEY_GRADE4, null);
        String sub5gradenum = sharedPreferences.getString(KEY_GRADE5, null);
        String sub6gradenum = sharedPreferences.getString(KEY_GRADE6, null);
        String sub7gradenum = sharedPreferences.getString(KEY_GRADE7, null);
        String sub8gradenum = sharedPreferences.getString(KEY_GRADE8, null);
        String sub9gradenum = sharedPreferences.getString(KEY_GRADE9, null);

        double sub1grade= Double.parseDouble(sub1gradenum);
        double sub2grade= Double.parseDouble(sub2gradenum);
        double sub3grade= Double.parseDouble(sub3gradenum);
        double sub4grade= Double.parseDouble(sub4gradenum);
        double sub5grade= Double.parseDouble(sub5gradenum);
        double sub6grade= Double.parseDouble(sub6gradenum);
        double sub7grade= Double.parseDouble(sub7gradenum);
        double sub8grade= Double.parseDouble(sub8gradenum);
        double sub9grade= Double.parseDouble(sub9gradenum);

        double s1=  4;
        double s2 = 3;
        double s3 = 3;
        double s4 = 3;
        double s5 = 3;
        double s6 = 3;
        double s7 = 2;
        double s8 = 2;
        double s9 = 2;
        double creditTotal= s1+ s2+ s3+ s4+ s5+ s6+ s7+ s8+ s9;

        if (sub1grade==0.000){
            s1= 0;
        }
        if (sub2grade==0.000){
            s2=0;
        }
        if(sub3grade==0.000){
            s3=0;
        }
        if (sub4grade==0.000){
            s4=0;
        }
        if (sub5grade==0.000){
            s5=0;
        }
        if (sub6grade==0.000){
            s6=0;
        }
        if (sub7grade==0.000){
            s7=0;
        }
        if (sub8grade==0.000){
            s8=0;
        }
        if (sub9grade==0.000){
            s9=0;
        }
        double totalgpa= (sub1grade* s1+ sub2grade * s2+ sub3grade * s3+ sub4grade* s4+
                sub5grade * s5 + sub6grade* s6+ sub7grade * s7+ sub8grade* s8+ sub9grade* s9)/creditTotal;

        DecimalFormat numberFormat = new DecimalFormat("#.000");

        String a = numberFormat.format(totalgpa);

        calcGpa.setText(a);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(FINAL_GPA, a);
        editor.apply();

    }
    private void CseSemester6(){

        String sub1gradenum = sharedPreferences.getString(KEY_GRADE1, null);
        String sub2gradenum = sharedPreferences.getString(KEY_GRADE2, null);
        String sub3gradenum = sharedPreferences.getString(KEY_GRADE3, null);
        String sub4gradenum = sharedPreferences.getString(KEY_GRADE4, null);
        String sub5gradenum = sharedPreferences.getString(KEY_GRADE5, null);
        String sub6gradenum = sharedPreferences.getString(KEY_GRADE6, null);
        String sub7gradenum = sharedPreferences.getString(KEY_GRADE7, null);
        String sub8gradenum = sharedPreferences.getString(KEY_GRADE8, null);
        String sub9gradenum = sharedPreferences.getString(KEY_GRADE9, null);
        String sub10gradenum = sharedPreferences.getString(KEY_GRADE10, null);

        double sub1grade= Double.parseDouble(sub1gradenum);
        double sub2grade= Double.parseDouble(sub2gradenum);
        double sub3grade= Double.parseDouble(sub3gradenum);
        double sub4grade= Double.parseDouble(sub4gradenum);
        double sub5grade= Double.parseDouble(sub5gradenum);
        double sub6grade= Double.parseDouble(sub6gradenum);
        double sub7grade= Double.parseDouble(sub7gradenum);
        double sub8grade= Double.parseDouble(sub8gradenum);
        double sub9grade= Double.parseDouble(sub9gradenum);
        double sub10grade= Double.parseDouble(sub10gradenum);

        double s1 = 3;
        double s2 = 3;
        double s3 = 3;
        double s4 = 4;
        double s5 = 3;
        double s6 = 3;
        double s7 = 2;
        double s8 = 2;
        double s9 = 1;
        double s10 = 1;

        double creditTotal= s1+ s2+ s3+ s4+ s5+ s6+ s7+ s8+ s9+ s10;

        if (sub1grade==0.000){
            s1= 0;
        }
        if (sub2grade==0.000){
            s2=0;
        }
        if(sub3grade==0.000){
            s3=0;
        }
        if (sub4grade==0.000){
            s4=0;
        }
        if (sub5grade==0.000){
            s5=0;
        }
        if (sub6grade==0.000){
            s6=0;
        }
        if (sub7grade==0.000){
            s7=0;
        }
        if (sub8grade==0.000){
            s8=0;
        }
        if (sub9grade==0.000){
            s9=0;
        }
        if (sub10grade==0.000){
            s10=0;
        }

        double totalgpa = (sub1grade * s1 + sub2grade * s2 + sub3grade * s3+
                sub4grade* s4+ sub5grade* s5+ sub6grade* s6+ sub7grade* s7+ sub8grade*  s8+ sub9grade* s9+ sub10grade* s10)/creditTotal;

        DecimalFormat numberFormat = new DecimalFormat("#.000");

        String a = numberFormat.format(totalgpa);

        calcGpa.setText(a);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(FINAL_GPA, a);
        editor.apply();
    }
    private void CseSemester7(){
        String sub1gradenum = sharedPreferences.getString(KEY_GRADE1, null);
        String sub2gradenum = sharedPreferences.getString(KEY_GRADE2, null);
        String sub3gradenum = sharedPreferences.getString(KEY_GRADE3, null);
        String sub4gradenum = sharedPreferences.getString(KEY_GRADE4, null);
        String sub5gradenum = sharedPreferences.getString(KEY_GRADE5, null);
        String sub6gradenum = sharedPreferences.getString(KEY_GRADE6, null);
        String sub7gradenum = sharedPreferences.getString(KEY_GRADE7, null);
        String sub8gradenum = sharedPreferences.getString(KEY_GRADE8, null);

        double sub1grade= Double.parseDouble(sub1gradenum);
        double sub2grade= Double.parseDouble(sub2gradenum);
        double sub3grade= Double.parseDouble(sub3gradenum);
        double sub4grade= Double.parseDouble(sub4gradenum);
        double sub5grade= Double.parseDouble(sub5gradenum);
        double sub6grade= Double.parseDouble(sub6gradenum);
        double sub7grade= Double.parseDouble(sub7gradenum);
        double sub8grade= Double.parseDouble(sub8gradenum);

        double s1 = 3;
        double s2 = 3;
        double s3 = 3;
        double s4 = 3;
        double s5 = 3;
        double s6 = 3;
        double s7 = 2;
        double s8 = 2;

        double creditTotal= s1+ s2+ s3+ s4+ s5+ s6+ s7+ s8;

        if (sub1grade==0.000){
            s1= 0;
        }
        if (sub2grade==0.000){
            s2=0;
        }
        if(sub3grade==0.000){
            s3=0;
        }
        if (sub4grade==0.000){
            s4=0;
        }
        if (sub5grade==0.000){
            s5=0;
        }
        if (sub6grade==0.000){
            s6=0;
        }
        if (sub7grade==0.000){
            s7=0;
        }
        if (sub8grade==0.000){
            s8=0;
        }

        double totalgpa = ( sub1grade* s1+ sub2grade *s2+ sub3grade*s3+ sub4grade *s4+
                sub5grade *s5+ sub6grade *s6+ sub7grade* s7+ sub8grade* s8)/creditTotal;

        DecimalFormat numberFormat = new DecimalFormat("#.000");

        String a = numberFormat.format(totalgpa);

        calcGpa.setText(a);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(FINAL_GPA, a);
        editor.apply();
    }
    private void CseSemester8(){
        String sub1gradenum = sharedPreferences.getString(KEY_GRADE1, null);
        String sub2gradenum = sharedPreferences.getString(KEY_GRADE2, null);
        String sub3gradenum = sharedPreferences.getString(KEY_GRADE3, null);

        double sub1grade= Double.parseDouble(sub1gradenum);
        double sub2grade= Double.parseDouble(sub2gradenum);
        double sub3grade= Double.parseDouble(sub3gradenum);

        double s1 = 3;
        double s2 = 3;
        double s3 = 10;

        double creditTotal = s1+s2+s3;

        if (sub1grade==0.000){
            s1=0;
        }
        if (sub2grade==0.000){
            s2=0;
        }
        if (sub3grade==0.000){
            s3=0;
        }
        double totalgpa = (sub1grade* s1 + sub2grade * s2 + sub3grade * s3 )/creditTotal;

        DecimalFormat numberFormat = new DecimalFormat("#.000");

        String a = numberFormat.format(totalgpa);

        calcGpa.setText(a);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(FINAL_GPA, a);
        editor.apply();

    }

    private void ItSemester1(){

        String sub1gradenum = sharedPreferences.getString(KEY_GRADE1, null);
        String sub2gradenum = sharedPreferences.getString(KEY_GRADE2, null);
        String sub3gradenum = sharedPreferences.getString(KEY_GRADE3, null);
        String sub4gradenum = sharedPreferences.getString(KEY_GRADE4, null);
        String sub5gradenum = sharedPreferences.getString(KEY_GRADE5, null);
        String sub6gradenum = sharedPreferences.getString(KEY_GRADE6, null);
        String sub7gradenum = sharedPreferences.getString(KEY_GRADE7, null);
        String sub8gradenum = sharedPreferences.getString(KEY_GRADE8, null);

        double sub1grade= Double.parseDouble(sub1gradenum);
        double sub2grade= Double.parseDouble(sub2gradenum);
        double sub3grade= Double.parseDouble(sub3gradenum);
        double sub4grade= Double.parseDouble(sub4gradenum);
        double sub5grade= Double.parseDouble(sub5gradenum);
        double sub6grade= Double.parseDouble(sub6gradenum);
        double sub7grade= Double.parseDouble(sub7gradenum);
        double sub8grade= Double.parseDouble(sub8gradenum);

        double s1= 4;
        double s2= 4;
        double s3= 3;
        double s4= 3;
        double s5= 3;
        double s6= 4;
        double s7= 2;
        double s8= 2;

        double creditTotal= s1+ s2+ s3+ s4+ s5+ s6+ s7+ s8;

        if (sub1grade==0.000){
            s1= 0;
        }
        if (sub2grade==0.000){
            s2=0;
        }
        if(sub3grade==0.000){
            s3=0;
        }
        if (sub4grade==0.000){
            s4=0;
        }
        if (sub5grade==0.000){
            s5=0;
        }
        if (sub6grade==0.000){
            s6=0;
        }
        if (sub7grade==0.000){
            s7=0;
        }
        if (sub8grade==0.000){
            s8=0;
        }

        double totalgpa = (sub1grade * s1 + sub2grade * s2+ sub3grade* s3 + sub4grade* s4+
                sub5grade* s5 + sub6grade* s6 +sub7grade* s7 + sub8grade * s8)/creditTotal;

        DecimalFormat numberFormat = new DecimalFormat("#.000");

        String a = numberFormat.format(totalgpa);

        calcGpa.setText(a);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(FINAL_GPA, a);
        editor.apply();
    }
    private void ItSemester2(){

        String sub1gradenum = sharedPreferences.getString(KEY_GRADE1, null);
        String sub2gradenum = sharedPreferences.getString(KEY_GRADE2, null);
        String sub3gradenum = sharedPreferences.getString(KEY_GRADE3, null);
        String sub4gradenum = sharedPreferences.getString(KEY_GRADE4, null);
        String sub5gradenum = sharedPreferences.getString(KEY_GRADE5, null);
        String sub6gradenum = sharedPreferences.getString(KEY_GRADE6, null);
        String sub7gradenum = sharedPreferences.getString(KEY_GRADE7, null);
        String sub8gradenum = sharedPreferences.getString(KEY_GRADE8, null);

        double sub1grade= Double.parseDouble(sub1gradenum);
        double sub2grade= Double.parseDouble(sub2gradenum);
        double sub3grade= Double.parseDouble(sub3gradenum);
        double sub4grade= Double.parseDouble(sub4gradenum);
        double sub5grade= Double.parseDouble(sub5gradenum);
        double sub6grade= Double.parseDouble(sub6gradenum);
        double sub7grade= Double.parseDouble(sub7gradenum);
        double sub8grade= Double.parseDouble(sub8gradenum);

        double s1 = 4;
        double s2 = 4;
        double s3 = 3;
        double s4 = 3;
        double s5 = 3;
        double s6 = 3;
        double s7 = 2;
        double s8 = 2;

        double creditTotal= s1+ s2+ s3+ s4+ s5+ s6+ s7+ s8;

        if (sub1grade==0.000){
            s1= 0;
        }
        if (sub2grade==0.000){
            s2=0;
        }
        if(sub3grade==0.000){
            s3=0;
        }
        if (sub4grade==0.000){
            s4=0;
        }
        if (sub5grade==0.000){
            s5=0;
        }
        if (sub6grade==0.000){
            s6=0;
        }
        if (sub7grade==0.000){
            s7=0;
        }
        if (sub8grade==0.000){
            s8=0;
        }

        double totalgpa = (sub1grade * s1 + sub2grade * s2 + sub3grade* s3 + sub4grade* s4+
                sub5grade* s5 + sub6grade* s6 +sub7grade* s7 + sub8grade * s8)/creditTotal;

        DecimalFormat numberFormat = new DecimalFormat("#.000");

        String a = numberFormat.format(totalgpa);

        calcGpa.setText(a);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(FINAL_GPA, a);
        editor.apply();
    }
    private void ItSemester3(){

        String sub1gradenum = sharedPreferences.getString(KEY_GRADE1, null);
        String sub2gradenum = sharedPreferences.getString(KEY_GRADE2, null);
        String sub3gradenum = sharedPreferences.getString(KEY_GRADE3, null);
        String sub4gradenum = sharedPreferences.getString(KEY_GRADE4, null);
        String sub5gradenum = sharedPreferences.getString(KEY_GRADE5, null);
        String sub6gradenum = sharedPreferences.getString(KEY_GRADE6, null);
        String sub7gradenum = sharedPreferences.getString(KEY_GRADE7, null);
        String sub8gradenum = sharedPreferences.getString(KEY_GRADE8, null);
        String sub9gradenum = sharedPreferences.getString(KEY_GRADE9, null);

        double sub1grade= Double.parseDouble(sub1gradenum);
        double sub2grade= Double.parseDouble(sub2gradenum);
        double sub3grade= Double.parseDouble(sub3gradenum);
        double sub4grade= Double.parseDouble(sub4gradenum);
        double sub5grade= Double.parseDouble(sub5gradenum);
        double sub6grade= Double.parseDouble(sub6gradenum);
        double sub7grade= Double.parseDouble(sub7gradenum);
        double sub8grade= Double.parseDouble(sub8gradenum);
        double sub9grade= Double.parseDouble(sub9gradenum);

        double s1 = 4;
        double s2 = 4;
        double s3 = 3;
        double s4 = 3;
        double s5 = 3;
        double s6 = 2;
        double s7 = 2;
        double s8 = 2;
        double s9 = 1;

        double creditTotal= s1+ s2+ s3+ s4+ s5+ s6+ s7+ s8+ s9;

        if (sub1grade==0.000){
            s1= 0;
        }
        if (sub2grade==0.000){
            s2=0;
        }
        if(sub3grade==0.000){
            s3=0;
        }
        if (sub4grade==0.000){
            s4=0;
        }
        if (sub5grade==0.000){
            s5=0;
        }
        if (sub6grade==0.000){
            s6=0;
        }
        if (sub7grade==0.000){
            s7=0;
        }
        if (sub8grade==0.000){
            s8=0;
        }
        if (sub9grade==0.000){
            s9=0;
        }

        double totalgpa = (sub1grade * s1 + sub2grade * s2+ sub3grade* s3 + sub4grade* s4+
                sub5grade*s5 + sub6grade*s6 +sub7grade* s7 + sub8grade * s8 + sub9grade * s9)/creditTotal;

        DecimalFormat numberFormat = new DecimalFormat("#.000");

        String a = numberFormat.format(totalgpa);

        calcGpa.setText(a);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(FINAL_GPA, a);
        editor.apply();
    }
    private void ItSemester4(){

        String sub1gradenum = sharedPreferences.getString(KEY_GRADE1, null);
        String sub2gradenum = sharedPreferences.getString(KEY_GRADE2, null);
        String sub3gradenum = sharedPreferences.getString(KEY_GRADE3, null);
        String sub4gradenum = sharedPreferences.getString(KEY_GRADE4, null);
        String sub5gradenum = sharedPreferences.getString(KEY_GRADE5, null);
        String sub6gradenum = sharedPreferences.getString(KEY_GRADE6, null);
        String sub7gradenum = sharedPreferences.getString(KEY_GRADE7, null);
        String sub8gradenum = sharedPreferences.getString(KEY_GRADE8, null);
        String sub9gradenum = sharedPreferences.getString(KEY_GRADE9, null);

        double sub1grade= Double.parseDouble(sub1gradenum);
        double sub2grade= Double.parseDouble(sub2gradenum);
        double sub3grade= Double.parseDouble(sub3gradenum);
        double sub4grade= Double.parseDouble(sub4gradenum);
        double sub5grade= Double.parseDouble(sub5gradenum);
        double sub6grade= Double.parseDouble(sub6gradenum);
        double sub7grade= Double.parseDouble(sub7gradenum);
        double sub8grade= Double.parseDouble(sub8gradenum);
        double sub9grade= Double.parseDouble(sub9gradenum);

        double s1 = 4;
        double s2 = 3;
        double s3 = 3;
        double s4 = 3;
        double s5 = 3;
        double s6 = 3;
        double s7 = 2;
        double s8 = 2;
        double s9 = 1;

        double creditTotal= s1+ s2+ s3+ s4+ s5+ s6+ s7+ s8+ s9;

        if (sub1grade==0.000){
            s1= 0;
        }
        if (sub2grade==0.000){
            s2=0;
        }
        if(sub3grade==0.000){
            s3=0;
        }
        if (sub4grade==0.000){
            s4=0;
        }
        if (sub5grade==0.000){
            s5=0;
        }
        if (sub6grade==0.000){
            s6=0;
        }
        if (sub7grade==0.000){
            s7=0;
        }
        if (sub8grade==0.000){
            s8=0;
        }
        if (sub9grade==0.000){
            s9=0;
        }

        double totalgpa = (sub1grade * s1 + sub2grade * s2+ sub3grade* s3 + sub4grade* s4+
                sub5grade* s5 + sub6grade* s6 +sub7grade* s7 + sub8grade * s8 + sub9grade * s9)/creditTotal;

        DecimalFormat numberFormat = new DecimalFormat("#.000");

        String a = numberFormat.format(totalgpa);

        calcGpa.setText(a);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(FINAL_GPA, a);
        editor.apply();
    }
    private void ItSemester5(){

        String sub1gradenum = sharedPreferences.getString(KEY_GRADE1, null);
        String sub2gradenum = sharedPreferences.getString(KEY_GRADE2, null);
        String sub3gradenum = sharedPreferences.getString(KEY_GRADE3, null);
        String sub4gradenum = sharedPreferences.getString(KEY_GRADE4, null);
        String sub5gradenum = sharedPreferences.getString(KEY_GRADE5, null);
        String sub6gradenum = sharedPreferences.getString(KEY_GRADE6, null);
        String sub7gradenum = sharedPreferences.getString(KEY_GRADE7, null);
        String sub8gradenum = sharedPreferences.getString(KEY_GRADE8, null);
        String sub9gradenum = sharedPreferences.getString(KEY_GRADE9, null);

        double sub1grade= Double.parseDouble(sub1gradenum);
        double sub2grade= Double.parseDouble(sub2gradenum);
        double sub3grade= Double.parseDouble(sub3gradenum);
        double sub4grade= Double.parseDouble(sub4gradenum);
        double sub5grade= Double.parseDouble(sub5gradenum);
        double sub6grade= Double.parseDouble(sub6gradenum);
        double sub7grade= Double.parseDouble(sub7gradenum);
        double sub8grade= Double.parseDouble(sub8gradenum);
        double sub9grade= Double.parseDouble(sub9gradenum);

        double s1 = 4;
        double s2 = 3;
        double s3 = 3;
        double s4 = 3;
        double s5 = 3;
        double s6 = 3;
        double s7 = 2;
        double s8 = 2;
        double s9 = 2;

        double creditTotal= s1+ s2+ s3+ s4+ s5+ s6+ s7+ s8+ s9;

        if (sub1grade==0.000){
            s1= 0;
        }
        if (sub2grade==0.000){
            s2=0;
        }
        if(sub3grade==0.000){
            s3=0;
        }
        if (sub4grade==0.000){
            s4=0;
        }
        if (sub5grade==0.000){
            s5=0;
        }
        if (sub6grade==0.000){
            s6=0;
        }
        if (sub7grade==0.000){
            s7=0;
        }
        if (sub8grade==0.000){
            s8=0;
        }
        if (sub9grade==0.000){
            s9=0;
        }

        double totalgpa = (sub1grade * s1 + sub2grade * s2+ sub3grade* s3 + sub4grade* s4+
                sub5grade* s5 + sub6grade* s6 +sub7grade* s7 + sub8grade * s8 + sub9grade * s9)/creditTotal;

        DecimalFormat numberFormat = new DecimalFormat("#.000");

        String a = numberFormat.format(totalgpa);

        calcGpa.setText(a);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(FINAL_GPA, a);
        editor.apply();
    }
    private void ItSemester6(){

        String sub1gradenum = sharedPreferences.getString(KEY_GRADE1, null);
        String sub2gradenum = sharedPreferences.getString(KEY_GRADE2, null);
        String sub3gradenum = sharedPreferences.getString(KEY_GRADE3, null);
        String sub4gradenum = sharedPreferences.getString(KEY_GRADE4, null);
        String sub5gradenum = sharedPreferences.getString(KEY_GRADE5, null);
        String sub6gradenum = sharedPreferences.getString(KEY_GRADE6, null);
        String sub7gradenum = sharedPreferences.getString(KEY_GRADE7, null);
        String sub8gradenum = sharedPreferences.getString(KEY_GRADE8, null);
        String sub9gradenum = sharedPreferences.getString(KEY_GRADE9, null);
        String sub10gradenum = sharedPreferences.getString(KEY_GRADE10, null);

        double sub1grade= Double.parseDouble(sub1gradenum);
        double sub2grade= Double.parseDouble(sub2gradenum);
        double sub3grade= Double.parseDouble(sub3gradenum);
        double sub4grade= Double.parseDouble(sub4gradenum);
        double sub5grade= Double.parseDouble(sub5gradenum);
        double sub6grade= Double.parseDouble(sub6gradenum);
        double sub7grade= Double.parseDouble(sub7gradenum);
        double sub8grade= Double.parseDouble(sub8gradenum);
        double sub9grade= Double.parseDouble(sub9gradenum);
        double sub10grade= Double.parseDouble(sub10gradenum);

        double s1 = 3;
        double s2 = 3;
        double s3 = 3;
        double s4 = 3;
        double s5 = 3;
        double s6 = 3;
        double s7 = 2;
        double s8 = 2;
        double s9 = 1;
        double s10 = 1;
        double creditTotal= s1+ s2+ s3+ s4+ s5+ s6+ s7+ s8+ s9+ s10;

        if (sub1grade==0.000){
            s1= 0;
        }
        if (sub2grade==0.000){
            s2=0;
        }
        if(sub3grade==0.000){
            s3=0;
        }
        if (sub4grade==0.000){
            s4=0;
        }
        if (sub5grade==0.000){
            s5=0;
        }
        if (sub6grade==0.000){
            s6=0;
        }
        if (sub7grade==0.000){
            s7=0;
        }
        if (sub8grade==0.000){
            s8=0;
        }
        if (sub9grade==0.000){
            s9=0;
        }
        if (sub10grade==0.000){
            s10=0;
        }

        double totalgpa = (sub1grade * s1+ sub2grade * s2+ sub3grade* s3 + sub4grade* s4+
                sub5grade* s5 + sub6grade* s6 +sub7grade* s7 + sub8grade *s8 + sub9grade * s9 + sub10grade*s10)/creditTotal;

        DecimalFormat numberFormat = new DecimalFormat("#.000");

        String a = numberFormat.format(totalgpa);

        calcGpa.setText(a);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(FINAL_GPA, a);
        editor.apply();
    }
    private void ItSemester7(){

        String sub1gradenum = sharedPreferences.getString(KEY_GRADE1, null);
        String sub2gradenum = sharedPreferences.getString(KEY_GRADE2, null);
        String sub3gradenum = sharedPreferences.getString(KEY_GRADE3, null);
        String sub4gradenum = sharedPreferences.getString(KEY_GRADE4, null);
        String sub5gradenum = sharedPreferences.getString(KEY_GRADE5, null);
        String sub6gradenum = sharedPreferences.getString(KEY_GRADE6, null);
        String sub7gradenum = sharedPreferences.getString(KEY_GRADE7, null);
        String sub8gradenum = sharedPreferences.getString(KEY_GRADE8, null);

        double sub1grade= Double.parseDouble(sub1gradenum);
        double sub2grade= Double.parseDouble(sub2gradenum);
        double sub3grade= Double.parseDouble(sub3gradenum);
        double sub4grade= Double.parseDouble(sub4gradenum);
        double sub5grade= Double.parseDouble(sub5gradenum);
        double sub6grade= Double.parseDouble(sub6gradenum);
        double sub7grade= Double.parseDouble(sub7gradenum);
        double sub8grade= Double.parseDouble(sub8gradenum);

        double s1 = 3;
        double s2 = 3;
        double s3 = 3;
        double s4 = 3;
        double s5 = 3;
        double s6 = 3;
        double s7 = 2;
        double s8 = 2;
        double creditTotal= s1+ s2+ s3+ s4+ s5+ s6+ s7+ s8;

        if (sub1grade==0.000){
            s1= 0;
        }
        if (sub2grade==0.000){
            s2=0;
        }
        if(sub3grade==0.000){
            s3=0;
        }
        if (sub4grade==0.000){
            s4=0;
        }
        if (sub5grade==0.000){
            s5=0;
        }
        if (sub6grade==0.000){
            s6=0;
        }
        if (sub7grade==0.000){
            s7=0;
        }
        if (sub8grade==0.000){
            s8=0;
        }

        double totalgpa = (sub1grade * s1 + sub2grade * s2+ sub3grade* s3 + sub4grade* s4+
                sub5grade*s5 + sub6grade* s6 +sub7grade* s7 + sub8grade * s8 )/creditTotal;

        DecimalFormat numberFormat = new DecimalFormat("#.000");

        String a = numberFormat.format(totalgpa);

        calcGpa.setText(a);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(FINAL_GPA, a);
        editor.apply();
    }
    private void ItSemester8(){

        String sub1gradenum = sharedPreferences.getString(KEY_GRADE1, null);
        String sub2gradenum = sharedPreferences.getString(KEY_GRADE2, null);
        String sub3gradenum = sharedPreferences.getString(KEY_GRADE3, null);


        double sub1grade= Double.parseDouble(sub1gradenum);
        double sub2grade= Double.parseDouble(sub2gradenum);
        double sub3grade= Double.parseDouble(sub3gradenum);

        double s1 = 3;
        double s2 = 3;
        double s3 = 10;

        double creditTotal = s1+s2+s3;

        if (sub1grade==0.000){
            s1=0;
        }
        if (sub2grade==0.000){
            s2=0;
        }
        if (sub3grade==0.000){
            s3=0;
        }
        double totalgpa = (sub1grade* s1 + sub2grade * s2 + sub3grade * s3 )/creditTotal;

        DecimalFormat numberFormat = new DecimalFormat("#.000");

        String a = numberFormat.format(totalgpa);

        calcGpa.setText(a);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(FINAL_GPA, a);
        editor.apply();
    }

    private void EceSemester1(){

        String sub1gradenum = sharedPreferences.getString(KEY_GRADE1, null);
        String sub2gradenum = sharedPreferences.getString(KEY_GRADE2, null);
        String sub3gradenum = sharedPreferences.getString(KEY_GRADE3, null);
        String sub4gradenum = sharedPreferences.getString(KEY_GRADE4, null);
        String sub5gradenum = sharedPreferences.getString(KEY_GRADE5, null);
        String sub6gradenum = sharedPreferences.getString(KEY_GRADE6, null);
        String sub7gradenum = sharedPreferences.getString(KEY_GRADE7, null);
        String sub8gradenum = sharedPreferences.getString(KEY_GRADE8, null);

        double sub1grade= Double.parseDouble(sub1gradenum);
        double sub2grade= Double.parseDouble(sub2gradenum);
        double sub3grade= Double.parseDouble(sub3gradenum);
        double sub4grade= Double.parseDouble(sub4gradenum);
        double sub5grade= Double.parseDouble(sub5gradenum);
        double sub6grade= Double.parseDouble(sub6gradenum);
        double sub7grade= Double.parseDouble(sub7gradenum);
        double sub8grade= Double.parseDouble(sub8gradenum);

        double s1= 4;
        double s2= 4;
        double s3= 3;
        double s4= 3;
        double s5= 3;
        double s6= 4;
        double s7= 2;
        double s8= 2;

        double creditTotal= s1+ s2+ s3+ s4+ s5+ s6+ s7+ s8;

        if (sub1grade==0.000){
            s1= 0;
        }
        if (sub2grade==0.000){
            s2=0;
        }
        if(sub3grade==0.000){
            s3=0;
        }
        if (sub4grade==0.000){
            s4=0;
        }
        if (sub5grade==0.000){
            s5=0;
        }
        if (sub6grade==0.000){
            s6=0;
        }
        if (sub7grade==0.000){
            s7=0;
        }
        if (sub8grade==0.000){
            s8=0;
        }

        double totalgpa = (sub1grade * s1 + sub2grade * s2+ sub3grade* s3 + sub4grade* s4+
                sub5grade* s5 + sub6grade* s6 +sub7grade* s7 + sub8grade * s8)/creditTotal;

        DecimalFormat numberFormat = new DecimalFormat("#.000");

        String a = numberFormat.format(totalgpa);

        calcGpa.setText(a);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(FINAL_GPA, a);
        editor.apply();
    }
    private void EceSemester2(){

        String sub1gradenum = sharedPreferences.getString(KEY_GRADE1, null);
        String sub2gradenum = sharedPreferences.getString(KEY_GRADE2, null);
        String sub3gradenum = sharedPreferences.getString(KEY_GRADE3, null);
        String sub4gradenum = sharedPreferences.getString(KEY_GRADE4, null);
        String sub5gradenum = sharedPreferences.getString(KEY_GRADE5, null);
        String sub6gradenum = sharedPreferences.getString(KEY_GRADE6, null);
        String sub7gradenum = sharedPreferences.getString(KEY_GRADE7, null);
        String sub8gradenum = sharedPreferences.getString(KEY_GRADE8, null);

        double sub1grade= Double.parseDouble(sub1gradenum);
        double sub2grade= Double.parseDouble(sub2gradenum);
        double sub3grade= Double.parseDouble(sub3gradenum);
        double sub4grade= Double.parseDouble(sub4gradenum);
        double sub5grade= Double.parseDouble(sub5gradenum);
        double sub6grade= Double.parseDouble(sub6gradenum);
        double sub7grade= Double.parseDouble(sub7gradenum);
        double sub8grade= Double.parseDouble(sub8gradenum);

        double s1 = 4;
        double s2 = 4;
        double s3 = 3;
        double s4 = 3;
        double s5 = 4;
        double s6 = 3;
        double s7 = 2;
        double s8 = 1;

        double creditTotal= s1+ s2+ s3+ s4+ s5+ s6+ s7+ s8;

        if (sub1grade==0.000){
            s1= 0;
        }
        if (sub2grade==0.000){
            s2=0;
        }
        if(sub3grade==0.000){
            s3=0;
        }
        if (sub4grade==0.000){
            s4=0;
        }
        if (sub5grade==0.000){
            s5=0;
        }
        if (sub6grade==0.000){
            s6=0;
        }
        if (sub7grade==0.000){
            s7=0;
        }
        if (sub8grade==0.000){
            s8=0;
        }

        double totalgpa = (sub1grade * s1 + sub2grade * s2+ sub3grade* s3 + sub4grade* s4+
                sub5grade* s5 + sub6grade* s6 +sub7grade* s7 + sub8grade * s8)/creditTotal;

        DecimalFormat numberFormat = new DecimalFormat("#.000");

        String a = numberFormat.format(totalgpa);

        calcGpa.setText(a);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(FINAL_GPA, a);
        editor.apply();
    }
    private void EceSemester3(){

        String sub1gradenum = sharedPreferences.getString(KEY_GRADE1, null);
        String sub2gradenum = sharedPreferences.getString(KEY_GRADE2, null);
        String sub3gradenum = sharedPreferences.getString(KEY_GRADE3, null);
        String sub4gradenum = sharedPreferences.getString(KEY_GRADE4, null);
        String sub5gradenum = sharedPreferences.getString(KEY_GRADE5, null);
        String sub6gradenum = sharedPreferences.getString(KEY_GRADE6, null);
        String sub7gradenum = sharedPreferences.getString(KEY_GRADE7, null);
        String sub8gradenum = sharedPreferences.getString(KEY_GRADE8, null);
        String sub9gradenum = sharedPreferences.getString(KEY_GRADE9, null);

        double sub1grade= Double.parseDouble(sub1gradenum);
        double sub2grade= Double.parseDouble(sub2gradenum);
        double sub3grade= Double.parseDouble(sub3gradenum);
        double sub4grade= Double.parseDouble(sub4gradenum);
        double sub5grade= Double.parseDouble(sub5gradenum);
        double sub6grade= Double.parseDouble(sub6gradenum);
        double sub7grade= Double.parseDouble(sub7gradenum);
        double sub8grade= Double.parseDouble(sub8gradenum);
        double sub9grade= Double.parseDouble(sub9gradenum);

        double s1 = 4;
        double s2 = 3;
        double s3 = 3;
        double s4 = 4;
        double s5 = 3;
        double s6 = 3;
        double s7 = 2;
        double s8 = 2;
        double s9 = 1;

        double creditTotal= s1+ s2+ s3+ s4+ s5+ s6+ s7+ s8+ s9;


        if (sub1grade==0.000){
            s1= 0;
        }
        if (sub2grade==0.000){
            s2=0;
        }
        if(sub3grade==0.000){
            s3=0;
        }
        if (sub4grade==0.000){
            s4=0;
        }
        if (sub5grade==0.000){
            s5=0;
        }
        if (sub6grade==0.000){
            s6=0;
        }
        if (sub7grade==0.000){
            s7=0;
        }
        if (sub8grade==0.000){
            s8=0;
        }
        if (sub9grade==0.000){
            s9=0;
        }

        double totalgpa = (sub1grade * s1 + sub2grade * s2+ sub3grade* s3 + sub4grade* s4+
                sub5grade* s5 + sub6grade* s6 +sub7grade* s7 + sub8grade * s8+ sub9grade* s9)/creditTotal;

        DecimalFormat numberFormat = new DecimalFormat("#.000");

        String a = numberFormat.format(totalgpa);

        calcGpa.setText(a);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(FINAL_GPA, a);
        editor.apply();
    }
    private void EceSemester4(){

        String sub1gradenum = sharedPreferences.getString(KEY_GRADE1, null);
        String sub2gradenum = sharedPreferences.getString(KEY_GRADE2, null);
        String sub3gradenum = sharedPreferences.getString(KEY_GRADE3, null);
        String sub4gradenum = sharedPreferences.getString(KEY_GRADE4, null);
        String sub5gradenum = sharedPreferences.getString(KEY_GRADE5, null);
        String sub6gradenum = sharedPreferences.getString(KEY_GRADE6, null);
        String sub7gradenum = sharedPreferences.getString(KEY_GRADE7, null);
        String sub8gradenum = sharedPreferences.getString(KEY_GRADE8, null);

        double sub1grade= Double.parseDouble(sub1gradenum);
        double sub2grade= Double.parseDouble(sub2gradenum);
        double sub3grade= Double.parseDouble(sub3gradenum);
        double sub4grade= Double.parseDouble(sub4gradenum);
        double sub5grade= Double.parseDouble(sub5gradenum);
        double sub6grade= Double.parseDouble(sub6gradenum);
        double sub7grade= Double.parseDouble(sub7gradenum);
        double sub8grade= Double.parseDouble(sub8gradenum);

        double s1 = 4;
        double s2 = 3;
        double s3 = 3;
        double s4 = 4;
        double s5 = 3;
        double s6 = 3;
        double s7 = 2;
        double s8 = 2;

        double creditTotal= s1+ s2+ s3+ s4+ s5+ s6+ s7+ s8;

        if (sub1grade==0.000){
            s1= 0;
        }
        if (sub2grade==0.000){
            s2=0;
        }
        if(sub3grade==0.000){
            s3=0;
        }
        if (sub4grade==0.000){
            s4=0;
        }
        if (sub5grade==0.000){
            s5=0;
        }
        if (sub6grade==0.000){
            s6=0;
        }
        if (sub7grade==0.000){
            s7=0;
        }
        if (sub8grade==0.000){
            s8=0;
        }

        double totalgpa = (sub1grade * s1 + sub2grade * s2+ sub3grade* s3 + sub4grade* s4+
                sub5grade* s5 + sub6grade* s6 +sub7grade* s7 + sub8grade * s8)/creditTotal;

        DecimalFormat numberFormat = new DecimalFormat("#.000");

        String a = numberFormat.format(totalgpa);

        calcGpa.setText(a);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(FINAL_GPA, a);
        editor.apply();
    }
    private void EceSemester5(){

        String sub1gradenum = sharedPreferences.getString(KEY_GRADE1, null);
        String sub2gradenum = sharedPreferences.getString(KEY_GRADE2, null);
        String sub3gradenum = sharedPreferences.getString(KEY_GRADE3, null);
        String sub4gradenum = sharedPreferences.getString(KEY_GRADE4, null);
        String sub5gradenum = sharedPreferences.getString(KEY_GRADE5, null);
        String sub6gradenum = sharedPreferences.getString(KEY_GRADE6, null);
        String sub7gradenum = sharedPreferences.getString(KEY_GRADE7, null);
        String sub8gradenum = sharedPreferences.getString(KEY_GRADE8, null);
        String sub9gradenum = sharedPreferences.getString(KEY_GRADE9, null);

        double sub1grade= Double.parseDouble(sub1gradenum);
        double sub2grade= Double.parseDouble(sub2gradenum);
        double sub3grade= Double.parseDouble(sub3gradenum);
        double sub4grade= Double.parseDouble(sub4gradenum);
        double sub5grade= Double.parseDouble(sub5gradenum);
        double sub6grade= Double.parseDouble(sub6gradenum);
        double sub7grade= Double.parseDouble(sub7gradenum);
        double sub8grade= Double.parseDouble(sub8gradenum);
        double sub9grade= Double.parseDouble(sub9gradenum);

        double s1 = 3;
        double s2 = 4;
        double s3 = 3;
        double s4 = 3;
        double s5 = 3;
        double s6 = 3;
        double s7 = 2;
        double s8 = 2;
        double s9 = 2;

        double creditTotal= s1+ s2+ s3+ s4+ s5+ s6+ s7+ s8+ s9;

        if (sub1grade==0.000){
            s1= 0;
        }
        if (sub2grade==0.000){
            s2=0;
        }
        if(sub3grade==0.000){
            s3=0;
        }
        if (sub4grade==0.000){
            s4=0;
        }
        if (sub5grade==0.000){
            s5=0;
        }
        if (sub6grade==0.000){
            s6=0;
        }
        if (sub7grade==0.000){
            s7=0;
        }
        if (sub8grade==0.000){
            s8=0;
        }
        if (sub9grade==0.000){
            s9=0;
        }

        double totalgpa = (sub1grade * s1 + sub2grade * s2+ sub3grade* s3 + sub4grade* s4+
                sub5grade* s5 + sub6grade* s6 +sub7grade* s7 + sub8grade * s8+ sub9grade* s9)/creditTotal;

        DecimalFormat numberFormat = new DecimalFormat("#.000");

        String a = numberFormat.format(totalgpa);

        calcGpa.setText(a);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(FINAL_GPA, a);
        editor.apply();
    }
    private void EceSemester6(){

        String sub1gradenum = sharedPreferences.getString(KEY_GRADE1, null);
        String sub2gradenum = sharedPreferences.getString(KEY_GRADE2, null);
        String sub3gradenum = sharedPreferences.getString(KEY_GRADE3, null);
        String sub4gradenum = sharedPreferences.getString(KEY_GRADE4, null);
        String sub5gradenum = sharedPreferences.getString(KEY_GRADE5, null);
        String sub6gradenum = sharedPreferences.getString(KEY_GRADE6, null);
        String sub7gradenum = sharedPreferences.getString(KEY_GRADE7, null);
        String sub8gradenum = sharedPreferences.getString(KEY_GRADE8, null);
        String sub9gradenum = sharedPreferences.getString(KEY_GRADE9, null);
        String sub10gradenum = sharedPreferences.getString(KEY_GRADE10, null);

        double sub1grade= Double.parseDouble(sub1gradenum);
        double sub2grade= Double.parseDouble(sub2gradenum);
        double sub3grade= Double.parseDouble(sub3gradenum);
        double sub4grade= Double.parseDouble(sub4gradenum);
        double sub5grade= Double.parseDouble(sub5gradenum);
        double sub6grade= Double.parseDouble(sub6gradenum);
        double sub7grade= Double.parseDouble(sub7gradenum);
        double sub8grade= Double.parseDouble(sub8gradenum);
        double sub9grade= Double.parseDouble(sub9gradenum);
        double sub10grade= Double.parseDouble(sub10gradenum);

        double s1 = 3;
        double s2 = 3;
        double s3 = 3;
        double s4 = 3;
        double s5 = 3;
        double s6 = 3;
        double s7 = 2;
        double s8 = 2;
        double s9 = 1;
        double s10 = 1;

        double creditTotal= s1+ s2+ s3+ s4+ s5+ s6+ s7+ s8+ s9+ s10;

        if (sub1grade==0.000){
            s1= 0;
        }
        if (sub2grade==0.000){
            s2=0;
        }
        if(sub3grade==0.000){
            s3=0;
        }
        if (sub4grade==0.000){
            s4=0;
        }
        if (sub5grade==0.000){
            s5=0;
        }
        if (sub6grade==0.000){
            s6=0;
        }
        if (sub7grade==0.000){
            s7=0;
        }
        if (sub8grade==0.000){
            s8=0;
        }
        if (sub9grade==0.000){
            s9=0;
        }
        if (sub10grade==0.000){
            s10=0;
        }

        double totalgpa = (sub1grade *s1 + sub2grade *s2+ sub3grade*s3 + sub4grade*s4+
                sub5grade*s5 + sub6grade*s6 +sub7grade*s7 + sub8grade *s8+ sub9grade*s9+ sub10grade*s10)/creditTotal;

        DecimalFormat numberFormat = new DecimalFormat("#.000");

        String a = numberFormat.format(totalgpa);

        calcGpa.setText(a);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(FINAL_GPA, a);
        editor.apply();
    }
    private void EceSemester7(){

        String sub1gradenum = sharedPreferences.getString(KEY_GRADE1, null);
        String sub2gradenum = sharedPreferences.getString(KEY_GRADE2, null);
        String sub3gradenum = sharedPreferences.getString(KEY_GRADE3, null);
        String sub4gradenum = sharedPreferences.getString(KEY_GRADE4, null);
        String sub5gradenum = sharedPreferences.getString(KEY_GRADE5, null);
        String sub6gradenum = sharedPreferences.getString(KEY_GRADE6, null);
        String sub7gradenum = sharedPreferences.getString(KEY_GRADE7, null);
        String sub8gradenum = sharedPreferences.getString(KEY_GRADE8, null);

        double sub1grade= Double.parseDouble(sub1gradenum);
        double sub2grade= Double.parseDouble(sub2gradenum);
        double sub3grade= Double.parseDouble(sub3gradenum);
        double sub4grade= Double.parseDouble(sub4gradenum);
        double sub5grade= Double.parseDouble(sub5gradenum);
        double sub6grade= Double.parseDouble(sub6gradenum);
        double sub7grade= Double.parseDouble(sub7gradenum);
        double sub8grade= Double.parseDouble(sub8gradenum);

        double s1 = 3;
        double s2 = 3;
        double s3 = 3;
        double s4 = 3;
        double s5 = 3;
        double s6 = 3;
        double s7 = 2;
        double s8 = 2;

        double creditTotal= s1+ s2+ s3+ s4+ s5+ s6+ s7+ s8;

        if (sub1grade==0.000){
            s1= 0;
        }
        if (sub2grade==0.000){
            s2=0;
        }
        if(sub3grade==0.000){
            s3=0;
        }
        if (sub4grade==0.000){
            s4=0;
        }
        if (sub5grade==0.000){
            s5=0;
        }
        if (sub6grade==0.000){
            s6=0;
        }
        if (sub7grade==0.000){
            s7=0;
        }
        if (sub8grade==0.000){
            s8=0;
        }
        double totalgpa = (sub1grade * s1 + sub2grade * s2+ sub3grade* s3 + sub4grade* s4+
                sub5grade*s5 + sub6grade* s6 +sub7grade* s7 + sub8grade * s8 )/creditTotal;

        DecimalFormat numberFormat = new DecimalFormat("#.000");

        String a = numberFormat.format(totalgpa);

        calcGpa.setText(a);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(FINAL_GPA, a);
        editor.apply();
    }
    private void EceSemester8(){

        String sub1gradenum = sharedPreferences.getString(KEY_GRADE1, null);
        String sub2gradenum = sharedPreferences.getString(KEY_GRADE2, null);
        String sub3gradenum = sharedPreferences.getString(KEY_GRADE3, null);


        double sub1grade= Double.parseDouble(sub1gradenum);
        double sub2grade= Double.parseDouble(sub2gradenum);
        double sub3grade= Double.parseDouble(sub3gradenum);

        double s1 = 3;
        double s2 = 3;
        double s3 = 10;

        double creditTotal = s1+s2+s3;

        if (sub1grade==0.000){
            s1=0;
        }
        if (sub2grade==0.000){
            s2=0;
        }
        if (sub3grade==0.000){
            s3=0;
        }
        double totalgpa = (sub1grade* s1 + sub2grade * s2 + sub3grade * s3 )/creditTotal;

        DecimalFormat numberFormat = new DecimalFormat("#.000");

        String a = numberFormat.format(totalgpa);

        calcGpa.setText(a);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(FINAL_GPA, a);
        editor.apply();
    }

    private void EeeSemester1(){

        String sub1gradenum = sharedPreferences.getString(KEY_GRADE1, null);
        String sub2gradenum = sharedPreferences.getString(KEY_GRADE2, null);
        String sub3gradenum = sharedPreferences.getString(KEY_GRADE3, null);
        String sub4gradenum = sharedPreferences.getString(KEY_GRADE4, null);
        String sub5gradenum = sharedPreferences.getString(KEY_GRADE5, null);
        String sub6gradenum = sharedPreferences.getString(KEY_GRADE6, null);
        String sub7gradenum = sharedPreferences.getString(KEY_GRADE7, null);
        String sub8gradenum = sharedPreferences.getString(KEY_GRADE8, null);

        double sub1grade= Double.parseDouble(sub1gradenum);
        double sub2grade= Double.parseDouble(sub2gradenum);
        double sub3grade= Double.parseDouble(sub3gradenum);
        double sub4grade= Double.parseDouble(sub4gradenum);
        double sub5grade= Double.parseDouble(sub5gradenum);
        double sub6grade= Double.parseDouble(sub6gradenum);
        double sub7grade= Double.parseDouble(sub7gradenum);
        double sub8grade= Double.parseDouble(sub8gradenum);

        double s1= 4;
        double s2= 4;
        double s3= 3;
        double s4= 3;
        double s5= 3;
        double s6= 4;
        double s7= 2;
        double s8= 2;

        double creditTotal= s1+ s2+ s3+ s4+ s5+ s6+ s7+ s8;

        if (sub1grade==0.000){
            s1= 0;
        }
        if (sub2grade==0.000){
            s2=0;
        }
        if(sub3grade==0.000){
            s3=0;
        }
        if (sub4grade==0.000){
            s4=0;
        }
        if (sub5grade==0.000){
            s5=0;
        }
        if (sub6grade==0.000){
            s6=0;
        }
        if (sub7grade==0.000){
            s7=0;
        }
        if (sub8grade==0.000){
            s8=0;
        }

        double totalgpa = (sub1grade * s1 + sub2grade * s2+ sub3grade* s3 + sub4grade* s4+
                sub5grade* s5 + sub6grade* s6 +sub7grade* s7 + sub8grade * s8)/creditTotal;

        DecimalFormat numberFormat = new DecimalFormat("#.000");

        String a = numberFormat.format(totalgpa);

        calcGpa.setText(a);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(FINAL_GPA, a);
        editor.apply();
    }
    private void EeeSemester2(){

        String sub1gradenum = sharedPreferences.getString(KEY_GRADE1, null);
        String sub2gradenum = sharedPreferences.getString(KEY_GRADE2, null);
        String sub3gradenum = sharedPreferences.getString(KEY_GRADE3, null);
        String sub4gradenum = sharedPreferences.getString(KEY_GRADE4, null);
        String sub5gradenum = sharedPreferences.getString(KEY_GRADE5, null);
        String sub6gradenum = sharedPreferences.getString(KEY_GRADE6, null);
        String sub7gradenum = sharedPreferences.getString(KEY_GRADE7, null);
        String sub8gradenum = sharedPreferences.getString(KEY_GRADE8, null);

        double sub1grade= Double.parseDouble(sub1gradenum);
        double sub2grade= Double.parseDouble(sub2gradenum);
        double sub3grade= Double.parseDouble(sub3gradenum);
        double sub4grade= Double.parseDouble(sub4gradenum);
        double sub5grade= Double.parseDouble(sub5gradenum);
        double sub6grade= Double.parseDouble(sub6gradenum);
        double sub7grade= Double.parseDouble(sub7gradenum);
        double sub8grade= Double.parseDouble(sub8gradenum);

        double s1 = 4;
        double s2 = 4;
        double s3 = 3;
        double s4 = 4;
        double s5 = 3;
        double s6 = 3;
        double s7 = 2;
        double s8 = 2;

        double creditTotal= s1+ s2+ s3+ s4+ s5+ s6+ s7+ s8;

        if (sub1grade==0.000){
            s1= 0;
        }
        if (sub2grade==0.000){
            s2=0;
        }
        if(sub3grade==0.000){
            s3=0;
        }
        if (sub4grade==0.000){
            s4=0;
        }
        if (sub5grade==0.000){
            s5=0;
        }
        if (sub6grade==0.000){
            s6=0;
        }
        if (sub7grade==0.000){
            s7=0;
        }
        if (sub8grade==0.000){
            s8=0;
        }

        double totalgpa = (sub1grade * s1 + sub2grade * s2+ sub3grade* s3 + sub4grade* s4+
                sub5grade* s5 + sub6grade* s6 +sub7grade* s7 + sub8grade * s8)/creditTotal;

        DecimalFormat numberFormat = new DecimalFormat("#.000");

        String a = numberFormat.format(totalgpa);

        calcGpa.setText(a);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(FINAL_GPA, a);
        editor.apply();
    }
    private void EeeSemester3(){

        String sub1gradenum = sharedPreferences.getString(KEY_GRADE1, null);
        String sub2gradenum = sharedPreferences.getString(KEY_GRADE2, null);
        String sub3gradenum = sharedPreferences.getString(KEY_GRADE3, null);
        String sub4gradenum = sharedPreferences.getString(KEY_GRADE4, null);
        String sub5gradenum = sharedPreferences.getString(KEY_GRADE5, null);
        String sub6gradenum = sharedPreferences.getString(KEY_GRADE6, null);
        String sub7gradenum = sharedPreferences.getString(KEY_GRADE7, null);
        String sub8gradenum = sharedPreferences.getString(KEY_GRADE8, null);

        double sub1grade= Double.parseDouble(sub1gradenum);
        double sub2grade= Double.parseDouble(sub2gradenum);
        double sub3grade= Double.parseDouble(sub3gradenum);
        double sub4grade= Double.parseDouble(sub4gradenum);
        double sub5grade= Double.parseDouble(sub5gradenum);
        double sub6grade= Double.parseDouble(sub6gradenum);
        double sub7grade= Double.parseDouble(sub7gradenum);
        double sub8grade= Double.parseDouble(sub8gradenum);

        double s1 = 4;
        double s2 = 3;
        double s3 = 3;
        double s4 = 3;
        double s5 = 3;
        double s6 = 3;
        double s7 = 2;
        double s8 = 2;
        double creditTotal= s1+ s2+ s3+ s4+ s5+ s6+ s7+ s8;

        if (sub1grade==0.000){
            s1= 0;
        }
        if (sub2grade==0.000){
            s2=0;
        }
        if(sub3grade==0.000){
            s3=0;
        }
        if (sub4grade==0.000){
            s4=0;
        }
        if (sub5grade==0.000){
            s5=0;
        }
        if (sub6grade==0.000){
            s6=0;
        }
        if (sub7grade==0.000){
            s7=0;
        }
        if (sub8grade==0.000){
            s8=0;
        }

        double totalgpa = (sub1grade * s1 + sub2grade * s2+ sub3grade* s3 + sub4grade* s4+
                sub5grade* s5 + sub6grade* s6 +sub7grade* s7 + sub8grade * s8)/creditTotal;

        DecimalFormat numberFormat = new DecimalFormat("#.000");

        String a = numberFormat.format(totalgpa);

        calcGpa.setText(a);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(FINAL_GPA, a);
        editor.apply();
    }
    private void EeeSemester4(){

        String sub1gradenum = sharedPreferences.getString(KEY_GRADE1, null);
        String sub2gradenum = sharedPreferences.getString(KEY_GRADE2, null);
        String sub3gradenum = sharedPreferences.getString(KEY_GRADE3, null);
        String sub4gradenum = sharedPreferences.getString(KEY_GRADE4, null);
        String sub5gradenum = sharedPreferences.getString(KEY_GRADE5, null);
        String sub6gradenum = sharedPreferences.getString(KEY_GRADE6, null);
        String sub7gradenum = sharedPreferences.getString(KEY_GRADE7, null);
        String sub8gradenum = sharedPreferences.getString(KEY_GRADE8, null);
        String sub9gradenum = sharedPreferences.getString(KEY_GRADE9, null);

        double sub1grade= Double.parseDouble(sub1gradenum);
        double sub2grade= Double.parseDouble(sub2gradenum);
        double sub3grade= Double.parseDouble(sub3gradenum);
        double sub4grade= Double.parseDouble(sub4gradenum);
        double sub5grade= Double.parseDouble(sub5gradenum);
        double sub6grade= Double.parseDouble(sub6gradenum);
        double sub7grade= Double.parseDouble(sub7gradenum);
        double sub8grade= Double.parseDouble(sub8gradenum);
        double sub9grade= Double.parseDouble(sub9gradenum);

        double s1 = 4;
        double s2 = 3;
        double s3 = 3;
        double s4 = 3;
        double s5 = 3;
        double s6 = 4;
        double s7 = 2;
        double s8 = 2;
        double s9 = 1;

        double creditTotal= s1+ s2+ s3+ s4+ s5+ s6+ s7+ s8+ s9;

        if (sub1grade==0.000){
            s1= 0;
        }
        if (sub2grade==0.000){
            s2=0;
        }
        if(sub3grade==0.000){
            s3=0;
        }
        if (sub4grade==0.000){
            s4=0;
        }
        if (sub5grade==0.000){
            s5=0;
        }
        if (sub6grade==0.000){
            s6=0;
        }
        if (sub7grade==0.000){
            s7=0;
        }
        if (sub8grade==0.000){
            s8=0;
        }
        if (sub9grade==0.000){
            s9=0;
        }

        double totalgpa = (sub1grade * s1 + sub2grade * s2+ sub3grade* s3 + sub4grade* s4+
                sub5grade* s5 + sub6grade* s6 +sub7grade* s7 + sub8grade * s8+ sub9grade* s9)/creditTotal;

        DecimalFormat numberFormat = new DecimalFormat("#.000");

        String a = numberFormat.format(totalgpa);

        calcGpa.setText(a);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(FINAL_GPA, a);
        editor.apply();
    }
    private void EeeSemester5(){

        String sub1gradenum = sharedPreferences.getString(KEY_GRADE1, null);
        String sub2gradenum = sharedPreferences.getString(KEY_GRADE2, null);
        String sub3gradenum = sharedPreferences.getString(KEY_GRADE3, null);
        String sub4gradenum = sharedPreferences.getString(KEY_GRADE4, null);
        String sub5gradenum = sharedPreferences.getString(KEY_GRADE5, null);
        String sub6gradenum = sharedPreferences.getString(KEY_GRADE6, null);
        String sub7gradenum = sharedPreferences.getString(KEY_GRADE7, null);
        String sub8gradenum = sharedPreferences.getString(KEY_GRADE8, null);
        String sub9gradenum = sharedPreferences.getString(KEY_GRADE9, null);

        double sub1grade= Double.parseDouble(sub1gradenum);
        double sub2grade= Double.parseDouble(sub2gradenum);
        double sub3grade= Double.parseDouble(sub3gradenum);
        double sub4grade= Double.parseDouble(sub4gradenum);
        double sub5grade= Double.parseDouble(sub5gradenum);
        double sub6grade= Double.parseDouble(sub6gradenum);
        double sub7grade= Double.parseDouble(sub7gradenum);
        double sub8grade= Double.parseDouble(sub8gradenum);
        double sub9grade= Double.parseDouble(sub9gradenum);

        double s1= 3;
        double s2= 3;
        double s3= 3;
        double s4 = 3;
        double s5 = 3;
        double s6 = 3;
        double s7 = 2;
        double s8 = 1;
        double s9 = 2;

        double creditTotal= s1+ s2+ s3+ s4+ s5+ s6+ s7+ s8+ s9;

        if (sub1grade==0.000){
            s1= 0;
        }
        if (sub2grade==0.000){
            s2=0;
        }
        if(sub3grade==0.000){
            s3=0;
        }
        if (sub4grade==0.000){
            s4=0;
        }
        if (sub5grade==0.000){
            s5=0;
        }
        if (sub6grade==0.000){
            s6=0;
        }
        if (sub7grade==0.000){
            s7=0;
        }
        if (sub8grade==0.000){
            s8=0;
        }
        if (sub9grade==0.000){
            s9=0;
        }

        double totalgpa = (sub1grade * s1 + sub2grade * s2+ sub3grade* s3 + sub4grade* s4+
                sub5grade* s5 + sub6grade* s6 +sub7grade* s7 + sub8grade * s8+ sub9grade* s9)/creditTotal;

        DecimalFormat numberFormat = new DecimalFormat("#.000");

        String a = numberFormat.format(totalgpa);

        calcGpa.setText(a);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(FINAL_GPA, a);
        editor.apply();
    }
    private void EeeSemester6(){

        String sub1gradenum = sharedPreferences.getString(KEY_GRADE1, null);
        String sub2gradenum = sharedPreferences.getString(KEY_GRADE2, null);
        String sub3gradenum = sharedPreferences.getString(KEY_GRADE3, null);
        String sub4gradenum = sharedPreferences.getString(KEY_GRADE4, null);
        String sub5gradenum = sharedPreferences.getString(KEY_GRADE5, null);
        String sub6gradenum = sharedPreferences.getString(KEY_GRADE6, null);
        String sub7gradenum = sharedPreferences.getString(KEY_GRADE7, null);
        String sub8gradenum = sharedPreferences.getString(KEY_GRADE8, null);

        double sub1grade= Double.parseDouble(sub1gradenum);
        double sub2grade= Double.parseDouble(sub2gradenum);
        double sub3grade= Double.parseDouble(sub3gradenum);
        double sub4grade= Double.parseDouble(sub4gradenum);
        double sub5grade= Double.parseDouble(sub5gradenum);
        double sub6grade= Double.parseDouble(sub6gradenum);
        double sub7grade= Double.parseDouble(sub7gradenum);
        double sub8grade= Double.parseDouble(sub8gradenum);

        double s1 = 3;
        double s2 = 3;
        double s3 = 3;
        double s4 = 3;
        double s5 = 3;
        double s6 = 2;
        double s7 = 2;
        double s8 = 2;

        double creditTotal= s1+ s2+ s3+ s4+ s5+ s6+ s7+ s8;

        if (sub1grade==0.000){
            s1= 0;
        }
        if (sub2grade==0.000){
            s2=0;
        }
        if(sub3grade==0.000){
            s3=0;
        }
        if (sub4grade==0.000){
            s4=0;
        }
        if (sub5grade==0.000){
            s5=0;
        }
        if (sub6grade==0.000){
            s6=0;
        }
        if (sub7grade==0.000){
            s7=0;
        }
        if (sub8grade==0.000){
            s8=0;
        }

        double totalgpa = (sub1grade * s1 + sub2grade * s2+ sub3grade* s3 + sub4grade* s4+
                sub5grade* s5 + sub6grade* s6 +sub7grade* s7 + sub8grade * s8)/creditTotal;

        DecimalFormat numberFormat = new DecimalFormat("#.000");

        String a = numberFormat.format(totalgpa);

        calcGpa.setText(a);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(FINAL_GPA, a);
        editor.apply();
    }
    private void EeeSemester7(){

        String sub1gradenum = sharedPreferences.getString(KEY_GRADE1, null);
        String sub2gradenum = sharedPreferences.getString(KEY_GRADE2, null);
        String sub3gradenum = sharedPreferences.getString(KEY_GRADE3, null);
        String sub4gradenum = sharedPreferences.getString(KEY_GRADE4, null);
        String sub5gradenum = sharedPreferences.getString(KEY_GRADE5, null);
        String sub6gradenum = sharedPreferences.getString(KEY_GRADE6, null);
        String sub7gradenum = sharedPreferences.getString(KEY_GRADE7, null);
        String sub8gradenum = sharedPreferences.getString(KEY_GRADE8, null);

        double sub1grade= Double.parseDouble(sub1gradenum);
        double sub2grade= Double.parseDouble(sub2gradenum);
        double sub3grade= Double.parseDouble(sub3gradenum);
        double sub4grade= Double.parseDouble(sub4gradenum);
        double sub5grade= Double.parseDouble(sub5gradenum);
        double sub6grade= Double.parseDouble(sub6gradenum);
        double sub7grade= Double.parseDouble(sub7gradenum);
        double sub8grade= Double.parseDouble(sub8gradenum);

        double s1 = 3;
        double s2 = 3;
        double s3 = 3;
        double s4 = 3;
        double s5 = 3;
        double s6 = 3;
        double s7 = 2;
        double s8 = 2;

        double creditTotal= s1+ s2+ s3+ s4+ s5+ s6+ s7+ s8;

        if (sub1grade==0.000){
            s1= 0;
        }
        if (sub2grade==0.000){
            s2=0;
        }
        if(sub3grade==0.000){
            s3=0;
        }
        if (sub4grade==0.000){
            s4=0;
        }
        if (sub5grade==0.000){
            s5=0;
        }
        if (sub6grade==0.000){
            s6=0;
        }
        if (sub7grade==0.000){
            s7=0;
        }
        if (sub8grade==0.000){
            s8=0;
        }

        double totalgpa = (sub1grade * s1 + sub2grade * s2+ sub3grade* s3 + sub4grade* s4+
                sub5grade* s5 + sub6grade* s6 +sub7grade* s7 + sub8grade * s8)/creditTotal;

        DecimalFormat numberFormat = new DecimalFormat("#.000");

        String a = numberFormat.format(totalgpa);

        calcGpa.setText(a);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(FINAL_GPA, a);
        editor.apply();
    }
    private void EeeSemester8(){

        String sub1gradenum = sharedPreferences.getString(KEY_GRADE1, null);
        String sub2gradenum = sharedPreferences.getString(KEY_GRADE2, null);
        String sub3gradenum = sharedPreferences.getString(KEY_GRADE3, null);


        double sub1grade= Double.parseDouble(sub1gradenum);
        double sub2grade= Double.parseDouble(sub2gradenum);
        double sub3grade= Double.parseDouble(sub3gradenum);

        double s1 = 3;
        double s2 = 3;
        double s3 = 10;

        double creditTotal = s1+s2+s3;

        if (sub1grade==0.000){
            s1=0;
        }
        if (sub2grade==0.000){
            s2=0;
        }
        if (sub3grade==0.000){
            s3=0;
        }
        double totalgpa = (sub1grade* s1 + sub2grade * s2 + sub3grade * s3 )/creditTotal;

        DecimalFormat numberFormat = new DecimalFormat("#.000");

        String a = numberFormat.format(totalgpa);

        calcGpa.setText(a);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(FINAL_GPA, a);
        editor.apply();
    }

    private void MechanicalSemester1(){

        String sub1gradenum = sharedPreferences.getString(KEY_GRADE1, null);
        String sub2gradenum = sharedPreferences.getString(KEY_GRADE2, null);
        String sub3gradenum = sharedPreferences.getString(KEY_GRADE3, null);
        String sub4gradenum = sharedPreferences.getString(KEY_GRADE4, null);
        String sub5gradenum = sharedPreferences.getString(KEY_GRADE5, null);
        String sub6gradenum = sharedPreferences.getString(KEY_GRADE6, null);
        String sub7gradenum = sharedPreferences.getString(KEY_GRADE7, null);
        String sub8gradenum = sharedPreferences.getString(KEY_GRADE8, null);

        double sub1grade= Double.parseDouble(sub1gradenum);
        double sub2grade= Double.parseDouble(sub2gradenum);
        double sub3grade= Double.parseDouble(sub3gradenum);
        double sub4grade= Double.parseDouble(sub4gradenum);
        double sub5grade= Double.parseDouble(sub5gradenum);
        double sub6grade= Double.parseDouble(sub6gradenum);
        double sub7grade= Double.parseDouble(sub7gradenum);
        double sub8grade= Double.parseDouble(sub8gradenum);

        double s1= 4;
        double s2= 4;
        double s3= 3;
        double s4= 3;
        double s5= 3;
        double s6= 4;
        double s7= 2;
        double s8= 2;

        double creditTotal= s1+ s2+ s3+ s4+ s5+ s6+ s7+ s8;

        if (sub1grade==0.000){
            s1= 0;
        }
        if (sub2grade==0.000){
            s2=0;
        }
        if(sub3grade==0.000){
            s3=0;
        }
        if (sub4grade==0.000){
            s4=0;
        }
        if (sub5grade==0.000){
            s5=0;
        }
        if (sub6grade==0.000){
            s6=0;
        }
        if (sub7grade==0.000){
            s7=0;
        }
        if (sub8grade==0.000){
            s8=0;
        }

        double totalgpa = (sub1grade * s1 + sub2grade * s2+ sub3grade* s3 + sub4grade* s4+
                sub5grade* s5 + sub6grade* s6 +sub7grade* s7 + sub8grade * s8)/creditTotal;

        DecimalFormat numberFormat = new DecimalFormat("#.000");

        String a = numberFormat.format(totalgpa);

        calcGpa.setText(a);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(FINAL_GPA, a);
        editor.apply();
    }
    private void MechanicalSemester2(){

        String sub1gradenum = sharedPreferences.getString(KEY_GRADE1, null);
        String sub2gradenum = sharedPreferences.getString(KEY_GRADE2, null);
        String sub3gradenum = sharedPreferences.getString(KEY_GRADE3, null);
        String sub4gradenum = sharedPreferences.getString(KEY_GRADE4, null);
        String sub5gradenum = sharedPreferences.getString(KEY_GRADE5, null);
        String sub6gradenum = sharedPreferences.getString(KEY_GRADE6, null);
        String sub7gradenum = sharedPreferences.getString(KEY_GRADE7, null);
        String sub8gradenum = sharedPreferences.getString(KEY_GRADE8, null);

        double sub1grade= Double.parseDouble(sub1gradenum);
        double sub2grade= Double.parseDouble(sub2gradenum);
        double sub3grade= Double.parseDouble(sub3gradenum);
        double sub4grade= Double.parseDouble(sub4gradenum);
        double sub5grade= Double.parseDouble(sub5gradenum);
        double sub6grade= Double.parseDouble(sub6gradenum);
        double sub7grade= Double.parseDouble(sub7gradenum);
        double sub8grade= Double.parseDouble(sub8gradenum);

        double s1 = 4;
        double s2 = 4;
        double s3 = 3;
        double s4 = 3;
        double s5 = 3;
        double s6 = 4;
        double s7 = 2;
        double s8 = 2;
        double creditTotal= s1+ s2+ s3+ s4+ s5+ s6+ s7+ s8;

        if (sub1grade==0.000){
            s1= 0;
        }
        if (sub2grade==0.000){
            s2=0;
        }
        if(sub3grade==0.000){
            s3=0;
        }
        if (sub4grade==0.000){
            s4=0;
        }
        if (sub5grade==0.000){
            s5=0;
        }
        if (sub6grade==0.000){
            s6=0;
        }
        if (sub7grade==0.000){
            s7=0;
        }
        if (sub8grade==0.000){
            s8=0;
        }
        double totalgpa = (sub1grade * s1 + sub2grade * s2+ sub3grade* s3 + sub4grade* s4+
                sub5grade* s5 + sub6grade* s6 +sub7grade* s7 + sub8grade * s8)/creditTotal;

        DecimalFormat numberFormat = new DecimalFormat("#.000");

        String a = numberFormat.format(totalgpa);

        calcGpa.setText(a);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(FINAL_GPA, a);
        editor.apply();
    }
    private void MechanicalSemester3(){

        String sub1gradenum = sharedPreferences.getString(KEY_GRADE1, null);
        String sub2gradenum = sharedPreferences.getString(KEY_GRADE2, null);
        String sub3gradenum = sharedPreferences.getString(KEY_GRADE3, null);
        String sub4gradenum = sharedPreferences.getString(KEY_GRADE4, null);
        String sub5gradenum = sharedPreferences.getString(KEY_GRADE5, null);
        String sub6gradenum = sharedPreferences.getString(KEY_GRADE6, null);
        String sub7gradenum = sharedPreferences.getString(KEY_GRADE7, null);
        String sub8gradenum = sharedPreferences.getString(KEY_GRADE8, null);
        String sub9gradenum = sharedPreferences.getString(KEY_GRADE9, null);

        double sub1grade= Double.parseDouble(sub1gradenum);
        double sub2grade= Double.parseDouble(sub2gradenum);
        double sub3grade= Double.parseDouble(sub3gradenum);
        double sub4grade= Double.parseDouble(sub4gradenum);
        double sub5grade= Double.parseDouble(sub5gradenum);
        double sub6grade= Double.parseDouble(sub6gradenum);
        double sub7grade= Double.parseDouble(sub7gradenum);
        double sub8grade= Double.parseDouble(sub8gradenum);
        double sub9grade= Double.parseDouble(sub9gradenum);

        double s1 = 4;
        double s2 = 4;
        double s3 = 4;
        double s4 = 3;
        double s5 = 3;
        double s6 = 2;
        double s7 = 2;
        double s8 = 2;
        double s9 = 1;

        double creditTotal= s1+ s2+ s3+ s4+ s5+ s6+ s7+ s8+ s9;

        if (sub1grade==0.000){
            s1= 0;
        }
        if (sub2grade==0.000){
            s2=0;
        }
        if(sub3grade==0.000){
            s3=0;
        }
        if (sub4grade==0.000){
            s4=0;
        }
        if (sub5grade==0.000){
            s5=0;
        }
        if (sub6grade==0.000){
            s6=0;
        }
        if (sub7grade==0.000){
            s7=0;
        }
        if (sub8grade==0.000){
            s8=0;
        }
        if (sub9grade==0.000){
            s9=0;
        }

        double totalgpa = (sub1grade * s1 + sub2grade * s2+ sub3grade* s3 + sub4grade* s4+
                sub5grade* s5 + sub6grade* s6 +sub7grade* s7 + sub8grade * s8+ sub9grade* s9)/creditTotal;

        DecimalFormat numberFormat = new DecimalFormat("#.000");

        String a = numberFormat.format(totalgpa);

        calcGpa.setText(a);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(FINAL_GPA, a);
        editor.apply();
    }
    private void MechanicalSemester4(){

        String sub1gradenum = sharedPreferences.getString(KEY_GRADE1, null);
        String sub2gradenum = sharedPreferences.getString(KEY_GRADE2, null);
        String sub3gradenum = sharedPreferences.getString(KEY_GRADE3, null);
        String sub4gradenum = sharedPreferences.getString(KEY_GRADE4, null);
        String sub5gradenum = sharedPreferences.getString(KEY_GRADE5, null);
        String sub6gradenum = sharedPreferences.getString(KEY_GRADE6, null);
        String sub7gradenum = sharedPreferences.getString(KEY_GRADE7, null);
        String sub8gradenum = sharedPreferences.getString(KEY_GRADE8, null);
        String sub9gradenum = sharedPreferences.getString(KEY_GRADE9, null);

        double sub1grade= Double.parseDouble(sub1gradenum);
        double sub2grade= Double.parseDouble(sub2gradenum);
        double sub3grade= Double.parseDouble(sub3gradenum);
        double sub4grade= Double.parseDouble(sub4gradenum);
        double sub5grade= Double.parseDouble(sub5gradenum);
        double sub6grade= Double.parseDouble(sub6gradenum);
        double sub7grade= Double.parseDouble(sub7gradenum);
        double sub8grade= Double.parseDouble(sub8gradenum);
        double sub9grade= Double.parseDouble(sub9gradenum);

        double s1 = 4;
        double s2 = 3;
        double s3 = 3;
        double s4 = 3;
        double s5 = 3;
        double s6 = 3;
        double s7 = 2;
        double s8 = 2;
        double s9 = 1;
        double creditTotal= s1+ s2+ s3+ s4+ s5+ s6+ s7+ s8+ s9;

        if (sub1grade==0.000){
            s1= 0;
        }
        if (sub2grade==0.000){
            s2=0;
        }
        if(sub3grade==0.000){
            s3=0;
        }
        if (sub4grade==0.000){
            s4=0;
        }
        if (sub5grade==0.000){
            s5=0;
        }
        if (sub6grade==0.000){
            s6=0;
        }
        if (sub7grade==0.000){
            s7=0;
        }
        if (sub8grade==0.000){
            s8=0;
        }
        if (sub9grade==0.000){
            s9=0;
        }

        double totalgpa = (sub1grade * s1 + sub2grade * s2+ sub3grade* s3 + sub4grade* s4+
                sub5grade* s5 + sub6grade* s6 +sub7grade* s7 + sub8grade * s8+ sub9grade* s9)/creditTotal;

        DecimalFormat numberFormat = new DecimalFormat("#.000");

        String a = numberFormat.format(totalgpa);

        calcGpa.setText(a);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(FINAL_GPA, a);
        editor.apply();
    }
    private void MechanicalSemester5(){

        String sub1gradenum = sharedPreferences.getString(KEY_GRADE1, null);
        String sub2gradenum = sharedPreferences.getString(KEY_GRADE2, null);
        String sub3gradenum = sharedPreferences.getString(KEY_GRADE3, null);
        String sub4gradenum = sharedPreferences.getString(KEY_GRADE4, null);
        String sub5gradenum = sharedPreferences.getString(KEY_GRADE5, null);
        String sub6gradenum = sharedPreferences.getString(KEY_GRADE6, null);
        String sub7gradenum = sharedPreferences.getString(KEY_GRADE7, null);
        String sub8gradenum = sharedPreferences.getString(KEY_GRADE8, null);


        double sub1grade= Double.parseDouble(sub1gradenum);
        double sub2grade= Double.parseDouble(sub2gradenum);
        double sub3grade= Double.parseDouble(sub3gradenum);
        double sub4grade= Double.parseDouble(sub4gradenum);
        double sub5grade= Double.parseDouble(sub5gradenum);
        double sub6grade= Double.parseDouble(sub6gradenum);
        double sub7grade= Double.parseDouble(sub7gradenum);
        double sub8grade= Double.parseDouble(sub8gradenum);

        double s1 = 3;
        double s2 = 3;
        double s3 = 3;
        double s4 = 4;
        double s5 = 3;
        double s6 = 2;
        double s7 = 2;
        double s8 = 2;
        double creditTotal= s1+ s2+ s3+ s4+ s5+ s6+ s7+ s8;

        if (sub1grade==0.000){
            s1= 0;
        }
        if (sub2grade==0.000){
            s2=0;
        }
        if(sub3grade==0.000){
            s3=0;
        }
        if (sub4grade==0.000){
            s4=0;
        }
        if (sub5grade==0.000){
            s5=0;
        }
        if (sub6grade==0.000){
            s6=0;
        }
        if (sub7grade==0.000){
            s7=0;
        }
        if (sub8grade==0.000){
            s8=0;
        }

        double totalgpa = (sub1grade * s1 + sub2grade * s2+ sub3grade* s3 + sub4grade* s4+
                sub5grade* s5 + sub6grade* s6 +sub7grade* s7 + sub8grade * s8)/creditTotal;

        DecimalFormat numberFormat = new DecimalFormat("#.000");

        String a = numberFormat.format(totalgpa);

        calcGpa.setText(a);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(FINAL_GPA, a);
        editor.apply();
    }
    private void MechanicalSemester6(){

        String sub1gradenum = sharedPreferences.getString(KEY_GRADE1, null);
        String sub2gradenum = sharedPreferences.getString(KEY_GRADE2, null);
        String sub3gradenum = sharedPreferences.getString(KEY_GRADE3, null);
        String sub4gradenum = sharedPreferences.getString(KEY_GRADE4, null);
        String sub5gradenum = sharedPreferences.getString(KEY_GRADE5, null);
        String sub6gradenum = sharedPreferences.getString(KEY_GRADE6, null);
        String sub7gradenum = sharedPreferences.getString(KEY_GRADE7, null);
        String sub8gradenum = sharedPreferences.getString(KEY_GRADE8, null);
        String sub9gradenum = sharedPreferences.getString(KEY_GRADE9, null);


        double sub1grade= Double.parseDouble(sub1gradenum);
        double sub2grade= Double.parseDouble(sub2gradenum);
        double sub3grade= Double.parseDouble(sub3gradenum);
        double sub4grade= Double.parseDouble(sub4gradenum);
        double sub5grade= Double.parseDouble(sub5gradenum);
        double sub6grade= Double.parseDouble(sub6gradenum);
        double sub7grade= Double.parseDouble(sub7gradenum);
        double sub8grade= Double.parseDouble(sub8gradenum);
        double sub9grade= Double.parseDouble(sub9gradenum);

        double s1= 3;
        double s2= 3;
        double s3= 4;
        double s4= 3;
        double s5= 3;
        double s6= 3;
        double s7= 2;
        double s8= 2;
        double s9= 1;
        double creditTotal= s1+ s2+ s3+ s4+ s5+ s6+ s7+ s8+ s9;

        if (sub1grade==0.000){
            s1= 0;
        }
        if (sub2grade==0.000){
            s2=0;
        }
        if(sub3grade==0.000){
            s3=0;
        }
        if (sub4grade==0.000){
            s4=0;
        }
        if (sub5grade==0.000){
            s5=0;
        }
        if (sub6grade==0.000){
            s6=0;
        }
        if (sub7grade==0.000){
            s7=0;
        }
        if (sub8grade==0.000){
            s8=0;
        }
        if (sub9grade==0.000){
            s9=0;
        }

        double totalgpa = (sub1grade * s1 + sub2grade * s2+ sub3grade* s3 + sub4grade* s4+
                sub5grade* s5 + sub6grade* s6 +sub7grade* s7 + sub8grade * s8+ sub9grade* s9)/creditTotal;

        DecimalFormat numberFormat = new DecimalFormat("#.000");

        String a = numberFormat.format(totalgpa);

        calcGpa.setText(a);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(FINAL_GPA, a);
        editor.apply();
    }
    private void MechanicalSemester7(){

        String sub1gradenum = sharedPreferences.getString(KEY_GRADE1, null);
        String sub2gradenum = sharedPreferences.getString(KEY_GRADE2, null);
        String sub3gradenum = sharedPreferences.getString(KEY_GRADE3, null);
        String sub4gradenum = sharedPreferences.getString(KEY_GRADE4, null);
        String sub5gradenum = sharedPreferences.getString(KEY_GRADE5, null);
        String sub6gradenum = sharedPreferences.getString(KEY_GRADE6, null);
        String sub7gradenum = sharedPreferences.getString(KEY_GRADE7, null);
        String sub8gradenum = sharedPreferences.getString(KEY_GRADE8, null);
        String sub9gradenum = sharedPreferences.getString(KEY_GRADE9, null);


        double sub1grade= Double.parseDouble(sub1gradenum);
        double sub2grade= Double.parseDouble(sub2gradenum);
        double sub3grade= Double.parseDouble(sub3gradenum);
        double sub4grade= Double.parseDouble(sub4gradenum);
        double sub5grade= Double.parseDouble(sub5gradenum);
        double sub6grade= Double.parseDouble(sub6gradenum);
        double sub7grade= Double.parseDouble(sub7gradenum);
        double sub8grade= Double.parseDouble(sub8gradenum);
        double sub9grade= Double.parseDouble(sub9gradenum);

        double s1 = 3;
        double s2 = 3;
        double s3 = 3;
        double s4 = 3;
        double s5 = 3;
        double s6 = 3;
        double s7 = 2;
        double s8 = 2;
        double s9 = 1;

        double creditTotal = s1+ s2+ s3+ s4+ s5+ s6+ s7+ s8+ s9;

        if (sub1grade==0.000){
            s1= 0;
        }
        if (sub2grade==0.000){
            s2=0;
        }
        if(sub3grade==0.000){
            s3=0;
        }
        if (sub4grade==0.000){
            s4=0;
        }
        if (sub5grade==0.000){
            s5=0;
        }
        if (sub6grade==0.000){
            s6=0;
        }
        if (sub7grade==0.000){
            s7=0;
        }
        if (sub8grade==0.000){
            s8=0;
        }
        if (sub9grade==0.000){
            s9=0;
        }

        double totalgpa = (sub1grade * s1 + sub2grade * s2+ sub3grade* s3 + sub4grade* s4+
                sub5grade* s5 + sub6grade* s6 +sub7grade* s7 + sub8grade * s8+ sub9grade* s9)/creditTotal;

        DecimalFormat numberFormat = new DecimalFormat("#.000");

        String a = numberFormat.format(totalgpa);

        calcGpa.setText(a);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(FINAL_GPA, a);
        editor.apply();
    }
    private void MechanicalSemester8(){

        String sub1gradenum = sharedPreferences.getString(KEY_GRADE1, null);
        String sub2gradenum = sharedPreferences.getString(KEY_GRADE2, null);
        String sub3gradenum = sharedPreferences.getString(KEY_GRADE3, null);


        double sub1grade= Double.parseDouble(sub1gradenum);
        double sub2grade= Double.parseDouble(sub2gradenum);
        double sub3grade= Double.parseDouble(sub3gradenum);

        double s1 = 3;
        double s2 = 3;
        double s3 = 10;

        double creditTotal = s1+s2+s3;

        if (sub1grade==0.000){
            s1=0;
        }
        if (sub2grade==0.000){
            s2=0;
        }
        if (sub3grade==0.000){
            s3=0;
        }
        double totalgpa = (sub1grade* s1 + sub2grade * s2 + sub3grade * s3 )/creditTotal;

        DecimalFormat numberFormat = new DecimalFormat("#.000");

        String a = numberFormat.format(totalgpa);

        calcGpa.setText(a);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Gpa2.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(FINAL_GPA, a);
        editor.apply();
    }

}