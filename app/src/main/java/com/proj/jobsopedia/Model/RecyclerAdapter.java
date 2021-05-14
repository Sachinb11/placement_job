package com.proj.jobsopedia.Model;

import android.content.Context;
import android.content.Intent;
import android.graphics.ColorSpace;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.proj.jobsopedia.R;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter
{
    private final Context  context;
    List<ModelClass> Joblist;
    ModelClass modelClass;

    public RecyclerAdapter(Context context,List<ModelClass> Joblist)
    {
        this.context = context;
        this.Joblist = Joblist;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview,parent,false);
        ViewHolderClass viewHolderClass = new ViewHolderClass(view);
        return viewHolderClass;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ViewHolderClass viewHolderClass = (ViewHolderClass) holder;

        this.modelClass = Joblist.get(position);
        viewHolderClass.CompanyName.setText(modelClass.getCompanyName());
        viewHolderClass.Designation.setText(modelClass.getDesignation());
        viewHolderClass.In_Date.setText("Date: "+ modelClass.getDate());
        viewHolderClass.In_Time.setText("Time: "+modelClass.getTime());
        viewHolderClass.Skill.setText("Skills: "+modelClass.getSkills());

        ((ViewHolderClass) holder).ShowDetails.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Intent intent=new Intent(context,Show_Details.class);

                intent.putExtra("comp_name",modelClass.getCompanyName());
                intent.putExtra("designation",modelClass.getDesignation());
                intent.putExtra("date",modelClass.getDate());
                intent.putExtra("time",modelClass.getTime());
                intent.putExtra("skills",modelClass.getSkills());
                intent.putExtra("experience",modelClass.getExperience());
                intent.putExtra("description",modelClass.getDescription());
                intent.putExtra("location",modelClass.getLocation());
                intent.putExtra("address",modelClass.getVenue());
                intent.putExtra("email",modelClass.getJobEmail());
                intent.putExtra("phone",modelClass.getContact());
                intent.putExtra("qualification",modelClass.getJobQualification());
                intent.putExtra("experience",modelClass.getExperience());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return Joblist.size();
    }

    public class ViewHolderClass extends RecyclerView.ViewHolder {

        TextView CompanyName, In_Date, In_Time, Skill, Designation;
        Button ShowDetails;
        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);
            this.CompanyName = itemView.findViewById(R.id.Company_Name);
            this.Designation = itemView.findViewById(R.id.Designation);
            this.In_Date = itemView.findViewById(R.id.Date);
            this.In_Time = itemView.findViewById(R.id.Time);
            this.Skill = itemView.findViewById(R.id.Skill);
            this.Designation = itemView.findViewById(R.id.Designation);
            this.ShowDetails = itemView.findViewById(R.id.btn_view);
        }
    }
}
