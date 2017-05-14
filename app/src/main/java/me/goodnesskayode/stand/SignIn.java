package me.goodnesskayode.stand;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignIn extends AppCompatActivity {

    TextView rSignUp;
    Button rMain;
    private EditText iEmail;
    private EditText iPassword;
    private Button mSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        rSignUp = (TextView) findViewById(R.id.sign_up_button);
        rSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signup = new Intent(getApplicationContext(),Signup.class);
                startActivity(signup);
            }
        });

        rMain =  (Button) findViewById(R.id.signin_button);
        rMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(main);
            }
        });

        iEmail = (EditText) findViewById(R.id.email);
        iPassword = (EditText) findViewById(R.id.password);
        mSignIn = (Button) findViewById(R.id.signin_button);

        mSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = iEmail.getText().toString().trim();
                String password = iPassword.getText().toString().trim();

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

            }
        });


    }

}
