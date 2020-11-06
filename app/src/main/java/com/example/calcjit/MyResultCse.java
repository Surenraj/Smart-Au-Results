package com.example.calcjit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MyResultCse extends AppCompatActivity {

    LinearLayout Layout1,Layout2,Layout3,Layout4,Layout5,Layout6,Layout7,Layout8;
    TextView CseSem1G1,CseSem1G2,CseSem1G3,CseSem1G4,CseSem1G5,CseSem1G6,CseSem1G7,CseSem1G8,CseSem1Gpa;

    private static final String SHARED_PREF_NAME1 = "mypref";
    private static final String DEPARTMENT_SEMESTER = "DEPARTMENTSEM";
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_result_cse);


        Layout1 = findViewById(R.id.cse_layout1);
        CseSem1G1 = findViewById(R.id.cse_sem1_g1);
        CseSem1G2 = findViewById(R.id.cse_sem1_g2);
        CseSem1G3 = findViewById(R.id.cse_sem1_g3);
        CseSem1G4 = findViewById(R.id.cse_sem1_g4);
        CseSem1G5 = findViewById(R.id.cse_sem1_g5);
        CseSem1G6 = findViewById(R.id.cse_sem1_g6);
        CseSem1G7 = findViewById(R.id.cse_sem1_g7);
        CseSem1G8 = findViewById(R.id.cse_sem1_g8);
        CseSem1Gpa = findViewById(R.id.cse_sem1_gpa);

        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);

        String personame = account.getDisplayName();
        String email = account.getEmail();
       // Toast.makeText(this, email, Toast.LENGTH_SHORT).show();

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME1, Context.MODE_PRIVATE);
        final String departmentSem = sharedPreferences.getString(DEPARTMENT_SEMESTER, null);


         DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child(personame).child(departmentSem);

       // Query checkUserCseSem1 = reference.orderByChild(departmentSem).equalTo("CSESemester 1");
         reference.addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                 String g1 = datasnapshot.child("grade1").getValue().toString();
                 String g2 = datasnapshot.child("grade2").getValue().toString();
                 String g3 = datasnapshot.child("grade3").getValue().toString();
                 String g4 = datasnapshot.child("grade4").getValue().toString();
                 String g5 = datasnapshot.child("grade5").getValue().toString();
                 String g6 = datasnapshot.child("grade6").getValue().toString();
                 String g7 = datasnapshot.child("grade7").getValue().toString();
                 String g8 = datasnapshot.child("grade8").getValue().toString();
                 String gpa = datasnapshot.child("gpa").getValue().toString();

                 CseSem1G1.setText(g1);
                 CseSem1G2.setText(g2);
                 CseSem1G3.setText(g3);
                 CseSem1G4.setText(g4);
                 CseSem1G5.setText(g5);
                 CseSem1G6.setText(g6);
                 CseSem1G7.setText(g7);
                 CseSem1G8.setText(g8);
                 CseSem1Gpa.setText(gpa);
                 //Toast.makeText(MyResultCse.this, g1, Toast.LENGTH_SHORT).show();
             }

             @Override
             public void onCancelled(@NonNull DatabaseError error) {

             }
         });

//        Query checkUserCseSem1 = reference.orderByChild(departmentSem).equalTo("CSESemester 1");
//
//        checkUserCseSem1.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
//
//
//
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });


    }
}