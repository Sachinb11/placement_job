package com.proj.jobsopedia.Login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
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
import com.google.firebase.auth.FirebaseUser;
import com.proj.jobsopedia.R;
import com.proj.jobsopedia.homeContent.Home;

import java.util.Objects;

public class Login_Home extends AppCompatActivity {

    private TextInputLayout logemail, logpass;
    Button logbtn, btnregister;
    public  FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_home);

        try
        {
            this.getSupportActionBar().hide();
            this.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        }
        catch (NullPointerException e){}

        setContentView(R.layout.activity_login_home);

        btnregister=(Button)findViewById(R.id.btnregister);

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Login_Home.this, Register.class);
                startActivity(intent);
            }


        });



        logemail = findViewById(R.id.logEmail);
        logpass = findViewById(R.id.logPass);
        logbtn = findViewById(R.id.btnlog);
        btnregister = findViewById(R.id.btnregister);

        mAuth = FirebaseAuth.getInstance();

        logbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logbtn();
            }
        });
    }

    private Boolean validemail(){
            String emailInput = Objects.requireNonNull(logemail.getEditText()).getText().toString().trim();

            if (emailInput.isEmpty()) {
                logemail.setError("Field can't be empty");
                return false;
            } else {
                logemail.setError(null);
                return true;
            }

        }

    private Boolean validpassword(){
        String passInput = Objects.requireNonNull(logpass.getEditText()).getText().toString().trim();

        if (passInput.isEmpty()) {
            logpass.setError("Field can't be empty");
            return false;
        } else  {
            logpass.setError(null);
            return true;
        }

    }

    private void logbtn() {
        String Email = logemail.getEditText().getText().toString().trim();
        String Password = logpass.getEditText().getText().toString().trim();

        if (!validemail()| (!validpassword())) {

            return;

        }
            mAuth.signInWithEmailAndPassword(Email, Password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {

                                Toast.makeText(Login_Home.this, "Login is successful.",
                                        Toast.LENGTH_SHORT).show();
                                FirebaseUser user = mAuth.getCurrentUser();
                                Intent home = new Intent(Login_Home.this, Home.class);
                                startActivity(home);
                            } else {
                                Toast.makeText(Login_Home.this, "login is failed.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
    }

    @Override
    public void onBackPressed() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Do you want to exit");
        builder.setCancelable(true);
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }


}


