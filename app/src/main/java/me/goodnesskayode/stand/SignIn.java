package me.goodnesskayode.stand;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignIn extends AppCompatActivity {

    TextView rSignUp;
    private EditText iEmail;
    private EditText iPassword;
    private Button mSignIn;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAuth = FirebaseAuth.getInstance();

        if (mAuth.getCurrentUser() != null) {
            startActivity(new Intent(SignIn.this, MainActivity.class));
            finish();
        }
        setContentView(R.layout.activity_sign_in);

        mAuth = FirebaseAuth.getInstance();

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        iEmail = (EditText) findViewById(R.id.email);
        iPassword = (EditText) findViewById(R.id.password);
        mSignIn = (Button) findViewById(R.id.signin_button);

        progressBar.setVisibility(View.VISIBLE);

        mSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = iEmail.getText().toString().trim();
                final String password = iPassword.getText().toString().trim();

                if(TextUtils.isEmpty(email))
                {
                    Toast.makeText(getApplicationContext(),"Email box is empty", Toast.LENGTH_LONG).show();
                    return;
                }
                if(TextUtils.isEmpty(password))
                {
                    Toast.makeText(getApplicationContext(),"Password box is empty", Toast.LENGTH_LONG).show();
                    return;
                }

                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(SignIn.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                progressBar.setVisibility(View.GONE);
                                if (!task.isSuccessful()) {
                                    // there was an error
                                    if (password.length() < 6) {
                                        iPassword.setError(getString(R.string.minimum_password));
                                    } else {
                                        Toast.makeText(SignIn.this, getString(R.string.auth_failed), Toast.LENGTH_LONG).show();
                                    }
                                } else {
                                    Intent intent = new Intent(SignIn.this, MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        });

            }
        });

        //Redirect to Sign Up page
        signupButton();

    }

    public void signupButton()
    {
        rSignUp = (TextView) findViewById(R.id.sign_up_button);
        rSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signup = new Intent(getApplicationContext(),Signup.class);
                startActivity(signup);
            }
        });
    }

}
