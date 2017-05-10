package me.goodnesskayode.stand;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SignIn extends AppCompatActivity {

    TextView rSignUp;
    Button rMain;

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
    }

}
