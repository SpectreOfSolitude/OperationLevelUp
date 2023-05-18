package com.example.whizz.ui.signin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.whizz.R;
import com.example.whizz.ui.ui.login.LoginActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {
    TextView textView;
    TextInputEditText EmailIn, PasswordIn, ConfirmPasswordIn;
    Button ButtonReg;
    FirebaseAuth mAuth;
    ProgressBar progressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mAuth = FirebaseAuth.getInstance();
        EmailIn = findViewById(R.id.editTextEmail);
        PasswordIn = findViewById(R.id.editTextPassword);
        ConfirmPasswordIn = findViewById(R.id.editTextConfirmPassword);
        ButtonReg = findViewById(R.id.button_Signin);
        progressbar = findViewById(R.id.signup_progress);

        textView=(TextView)findViewById(R.id.button_prev);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        ButtonReg.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                progressbar.setVisibility(View.VISIBLE);
                String email, password, ConfirmPassword;
                email = String.valueOf(EmailIn.getText().toString());
                password = String.valueOf(PasswordIn.getText().toString());
                ConfirmPassword = String.valueOf(ConfirmPasswordIn.getText().toString());

                if(TextUtils.isEmpty(email))
                {
                    Toast.makeText(SignUpActivity.this, "Enter Email!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(password))
                {
                    Toast.makeText(SignUpActivity.this, "Enter Password!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(ConfirmPassword))
                {
                    Toast.makeText(SignUpActivity.this, "Confirm Password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task)
                            {
                                progressbar.setVisibility(View.GONE);
                                if (task.isSuccessful() && password == ConfirmPassword)
                                {
                                    Toast.makeText(SignUpActivity.this, "Account Created.",
                                            Toast.LENGTH_SHORT).show();
                                }

                                else if (password != ConfirmPassword)
                                {
                                    Toast.makeText(SignUpActivity.this, "Password Confirmation Does Not Match!",
                                            Toast.LENGTH_SHORT).show();
                                }
                                else
                                {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(SignUpActivity.this, "Account Creation failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
}

