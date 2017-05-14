package me.goodnesskayode.stand;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Profile extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myUsers = database.getReference("users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if (user != null) {
            // Name, email address, and profile photo Url
            String name = user.getDisplayName();
            String email = user.getEmail();
            String uid = user.getUid();

            User users = new User("Goodness Kayode","Goodness Kayode",user.getEmail());

            myUsers.child("users").child(uid).setValue(users);


//            UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
//                    .setDisplayName("Jane Q. User")
//                    .setPhotoUri(Uri.parse("https://example.com/jane-q-user/profile.jpg"))
//                    .build();
//
//            user.updateProfile(profileUpdates)
//                    .addOnCompleteListener(new OnCompleteListener<Void>() {
//                        public static final String TAG = "Profile";
//
//                        @Override
//                        public void onComplete(@NonNull Task<Void> task) {
//                            if (task.isSuccessful()) {
//                                Log.d(TAG, "User profile updated.");
//                                Log.d(TAG, user.getDisplayName());
//                                Toast.makeText(Profile.this, user.getDisplayName(), Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                    });

            // The user's ID, unique to the Firebase project. Do NOT use this value to
            // authenticate with your backend server, if you have one. Use
            // FirebaseUser.getToken() instead.

        }

    }
}
