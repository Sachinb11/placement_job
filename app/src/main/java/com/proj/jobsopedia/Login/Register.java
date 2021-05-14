package com.proj.jobsopedia.Login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.proj.jobsopedia.Model.ModelClass;
import com.proj.jobsopedia.Model.UserModelClass;
import com.proj.jobsopedia.R;

import java.util.Objects;

public class Register extends AppCompatActivity {

    TextInputLayout email, password, Con_pass;
    TextInputLayout fullname,age,qualification,phonenumber;
    Button btn;
    public FirebaseAuth mAuth;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email = findViewById(R.id.Email);
        password = findViewById(R.id.password);
        Con_pass = findViewById(R.id.Con_password);
        btn = findViewById(R.id.register);
        fullname = findViewById(R.id.Name);
        phonenumber = findViewById(R.id.Phone);
        age = findViewById(R.id.Age);
        qualification = findViewById(R.id.Qualification);

        //Database refernces
        databaseReference = FirebaseDatabase.getInstance().getReference("User");
        mAuth = FirebaseAuth.getInstance();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });

    }

    private void register() {

        String Email = email.getEditText().getText().toString().trim();
        String Password = password.getEditText().getText().toString().trim();
        String Name = fullname.getEditText().getText().toString().trim();
        String Phone = phonenumber.getEditText().getText().toString().trim();
        String Age = age.getEditText().getText().toString().trim();
        String Qualification = qualification.getEditText().getText().toString().trim();

        if (!validemail() | !validpassword() | !validCon_password()| !validage() | !validname() | !validqualificationl() | !validphone()){
            return;
        }

        mAuth.createUserWithEmailAndPassword(Email, Password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                             UserModelClass info = new UserModelClass(
                                     Name,
                                     Email,
                                     Phone,
                                     Qualification,
                                     Age
                             );

                             FirebaseDatabase.getInstance().getReference("User")
                                     .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                     .setValue(info).addOnCompleteListener(new OnCompleteListener<Void>() {
                                 @Override
                                 public void onComplete(@NonNull Task<Void> task) {
                                     Toast.makeText(Register.this, "Authentication successful.",
                                             Toast.LENGTH_SHORT).show();
                                     Intent reg = new Intent(Register.this, Login_Home.class);
                                     startActivity(reg);
                                 }
                             });
                        } else {
                            Toast.makeText(Register.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }

    private Boolean validemail(){
        String emailInput = Objects.requireNonNull(email.getEditText()).getText().toString().trim();

        if (emailInput.isEmpty()) {
            email.setError("Field can't be empty");
            return false;
        } else {
            email.setError(null);
            return true;
        }
    }
    private Boolean validpassword(){
        String passwordinput = Objects.requireNonNull(password.getEditText()).getText().toString().trim();

        if (passwordinput.isEmpty()) {
            password.setError("Field can't be empty");
            return false;
        } else {
            password.setError(null);
            return true;
        }
    }
    private Boolean validCon_password(){
        String conpassinput = Objects.requireNonNull(Con_pass.getEditText()).getText().toString().trim();

        if (conpassinput.isEmpty()) {
            Con_pass.setError("Field can't be empty");
            return false;
        } else {
            Con_pass.setError(null);
            return true;
        }
    }
    private Boolean validname(){
        String nameInput = fullname.getEditText().getText().toString().trim();

        if (nameInput.isEmpty()) {
            fullname.setError("Field can't be empty");
            return false;
        } else {
            fullname.setError(null);
            return true;
        }


    }
    private Boolean validphone(){
        String phoneInput = phonenumber.getEditText().getText().toString().trim();

        if (phoneInput.isEmpty()) {
            phonenumber.setError("Field can't be empty");
            return false;
        } else {
            phonenumber.setError(null);
            return true;
        }


    }
    private Boolean validqualificationl(){
        String qualificationInput = qualification.getEditText().getText().toString().trim();

        if (qualificationInput.isEmpty()) {
            qualification.setError("Field can't be empty");
            return false;
        } else {
            qualification.setError(null);
            return true;
        }


    }
    private Boolean validage(){
        String ageInput = Objects.requireNonNull(age.getEditText()).getText().toString().trim();

        if (ageInput.isEmpty()) {
            age.setError("Field can't be empty");
            return false;
        } else {
            age.setError(null);
            return true;
        }


    }
}

