package com.proj.jobsopedia.homeContent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.proj.jobsopedia.Model.ModelClass;
import com.proj.jobsopedia.Model.RecyclerAdapter;
import com.proj.jobsopedia.R;

import java.util.ArrayList;
import java.util.List;

public class ScienceActivity extends AppCompatActivity {

    List<ModelClass> joblistSci;
    RecyclerView recyclerviewSci;
    DatabaseReference dbrefSci;
    TextView textV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerviewSci = findViewById(R.id.recyclerviewmain);
        recyclerviewSci.setLayoutManager(new LinearLayoutManager(this));
        dbrefSci = FirebaseDatabase.getInstance().getReference("Science");
        textV = findViewById(R.id.recText);
        textV.setText("Science");

    }

    @Override
    protected void onStart() {
        super.onStart();
        dbrefSci.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                joblistSci = new ArrayList<>();
                for (DataSnapshot jobss : datasnapshot.getChildren())
                {
                    ModelClass modelClass = jobss.getValue(ModelClass.class);
                    ModelClass newMC = new ModelClass();

                    String CompanyName=modelClass.getCompanyName();
                    String Designation=modelClass.getDesignation();
                    String Date=modelClass.getDate();
                    String Time=modelClass.getTime();
                    String Skill=modelClass.getSkills();

                    String description=modelClass.getDescription();
                    String location=modelClass.getLocation();
                    String qualification=modelClass.getJobQualification();
                    String phone=modelClass.getContact();
                    String email=modelClass.getJobEmail();
                    String experience=modelClass.getExperience();

                    newMC.setCompanyName(CompanyName);
                    newMC.setDesignation(Designation);
                    newMC.setDate(Date);
                    newMC.setTime(Time);
                    newMC.setSkills(Skill);
                    newMC.setDescription(description);
                    newMC.setLocation(location);
                    newMC.setJobQualification(qualification);
                    newMC.setContact(phone);
                    newMC.setJobEmail(email);
                    newMC.setExperience(experience);

                    String name1=jobss.child("CompanyName").getValue(String.class);
                    Log.w("Company name is:",name1);
                    joblistSci.add(modelClass);

                }
                RecyclerAdapter studentInfoAdapter = new RecyclerAdapter(ScienceActivity.this, joblistSci);
                recyclerviewSci.setAdapter(studentInfoAdapter);
                studentInfoAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}