package com.example.whizz.ui.signin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.whizz.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SigninActivity extends AppCompatActivity {

    TextInputEditText EmailIn, PasswordIn, ConfirmPasswordIn;
    Button ButtonReg;
    FirebaseAuth mAuth;
    ProgressBar progressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        mAuth = FirebaseAuth.getInstance();
        EmailIn = findViewById(R.id.editTextEmail);
        PasswordIn = findViewById(R.id.editTextPassword);
        ConfirmPasswordIn = findViewById(R.id.editTextConfirmPassword);
        ButtonReg = findViewById(R.id.button_Signin);
        progressbar = findViewById(R.id.signup_progress);

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
                    Toast.makeText(SigninActivity.this, "Enter Email!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(password))
                {
                    Toast.makeText(SigninActivity.this, "Enter Password!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(ConfirmPassword))
                {
                    Toast.makeText(SigninActivity.this, "Confirm Password!", Toast.LENGTH_SHORT).show();
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
                                    Toast.makeText(SigninActivity.this, "Account Created.",
                                            Toast.LENGTH_SHORT).show();
                                }

                                else if (password != ConfirmPassword)
                                {
                                    Toast.makeText(SigninActivity.this, "Password Confirmation Does Not Match!",
                                            Toast.LENGTH_SHORT).show();
                                }
                                else
                                {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(SigninActivity.this, "Account Creation failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
}

