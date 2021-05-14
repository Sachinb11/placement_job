package com.proj.jobsopedia.Model;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.proj.jobsopedia.R;

public class Show_Details extends AppCompatActivity {

    TextView tv_compname,tv_address,tv_designation,tv_description,tv_skills, tv_qualification,
            tv_exp,tv_location,tv_date, tv_time,tv_phone,tv_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show__details);

        Intent intent = getIntent();
        String comp_name = intent.getStringExtra("comp_name");
        String designation = intent.getStringExtra("designation");
        String date = intent.getStringExtra("date");
        String time = intent.getStringExtra("time");
        String skills = intent.getStringExtra("skills");
        String description = intent.getStringExtra("description");
        String experience = intent.getStringExtra("experience");
        String qualification = intent.getStringExtra("qualification");
        String email = intent.getStringExtra("email");
        String phone = intent.getStringExtra("phone");
        String location = intent.getStringExtra("location");
        String address = intent.getStringExtra("address");

        init();

        tv_compname.setText(comp_name);
        tv_address.setText(address);
        tv_designation.setText(designation);
        tv_description.setText(description);
        tv_skills.setText(skills);
        tv_qualification.setText(qualification);
        tv_exp.setText(experience);
        tv_location.setText(location);
        tv_date.setText(date);
        tv_time.setText(time);
        tv_phone.setText(phone);
        tv_email.setText(email);

//        Log.w("comp name",comp_name);
//        Log.w("designation",designation);
//        Log.w("date",date);
//        Log.w("time",time);
//        Log.w("skills",skills);
//        Log.v("description",description);
//        Log.v("experience",experience);
//        Log.v("qualification",qualification);
//        Log.v("email",email);
//        Log.v("phone",phone);
//        Log.v("location",location);
//        Log.v("location1",address);
    }

    public void init()
    {
        tv_compname     =findViewById(R.id.Name);
        tv_address      =findViewById(R.id.address);
        tv_designation  =findViewById(R.id.designation);
        tv_description  =findViewById(R.id.Description);
        tv_skills       =findViewById(R.id.Skills);
        tv_qualification=findViewById(R.id.Qualification);
        tv_exp          =findViewById(R.id.Experience);
        tv_location     =findViewById(R.id.Location);
        tv_date         =findViewById(R.id.Date);
        tv_time         =findViewById(R.id.Time);
        tv_phone        =findViewById(R.id.Phone);
        tv_email        =findViewById(R.id.Email);

        tv_email.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                try{
                    Intent intent = new Intent (Intent.ACTION_VIEW , Uri.parse("mailto:" + "your_email"));
                    intent.putExtra(Intent.EXTRA_SUBJECT, "your_subject");
                    intent.putExtra(Intent.EXTRA_TEXT, "your_text");
                    startActivity(intent);
                }catch(ActivityNotFoundException e){
                    //TODO smth
                }
            }
        });
    }
}