package me.goodnesskayode.stand;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Signup extends AppCompatActivity {

    TextView rSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        rSignIn = (TextView) findViewById(R.id.sign_in_button);

        rSignIn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent signIn = new Intent(getApplicationContext(),SignIn.class);
                startActivity(signIn);
            }
        });
    }
}
