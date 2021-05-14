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

public class Cs_ITActivity extends AppCompatActivity {

    List<ModelClass> joblistCS;
    RecyclerView recyclerviewCS;
    DatabaseReference dbrefCS;
    TextView textV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerviewCS = findViewById(R.id.recyclerviewmain);
        recyclerviewCS.setLayoutManager(new LinearLayoutManager(this));
        dbrefCS = FirebaseDatabase.getInstance().getReference("CS_IT");
        textV = findViewById(R.id.recText);
        textV.setText("CS_IT");

    }

    @Override
    protected void onStart() {
        super.onStart();
        dbrefCS.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                joblistCS = new ArrayList<>();
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
                    joblistCS.add(modelClass);

                }
                RecyclerAdapter studentInfoAdapter = new RecyclerAdapter(Cs_ITActivity.this, joblistCS);
                recyclerviewCS.setAdapter(studentInfoAdapter);
                studentInfoAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}