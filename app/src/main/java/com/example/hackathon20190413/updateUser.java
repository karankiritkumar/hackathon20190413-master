package com.example.hackathon20190413;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class updateUser extends AppCompatActivity {

    EditText NameET;
    EditText EmailET;
    EditText PasswordET;
    EditText PhotoURLET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user);

        NameET = (EditText)this.findViewById(R.id.displayName);
        EmailET = (EditText)this.findViewById(R.id.Email);
        PasswordET = (EditText)this.findViewById(R.id.Password);
        PhotoURLET = (EditText)this.findViewById(R.id.PhotoURL);





        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // Name, email address, and profile photo Url
            String name = user.getDisplayName();
            String email = user.getEmail();
            Uri photoUrl = user.getPhotoUrl();

            // Check if user's email is verified
            boolean emailVerified = user.isEmailVerified();

            // The user's ID, unique to the Firebase project. Do NOT use this value to
            // authenticate with your backend server, if you have one. Use
            // FirebaseUser.getIdToken() instead.
            String uid = user.getUid();

            NameET.setText(name);
            EmailET.setText(email);




        }

    }
    public void onUpdateButtonPressed(View v){

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String Name = NameET.getText().toString();

        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                .setDisplayName(Name)
 //               .setPhotoUri(Uri.parse("https://example.com/jane-q-user/profile.jpg"))
                .build();

         Task<Void> voidTask = user.updateProfile(profileUpdates)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                        System.out.println("*****successful update");
                        }
                    }
                });

         if (PasswordET.getText().toString().trim().length() != 0)
         {
             String newPassword = PasswordET.getText().toString();

             user.updatePassword(newPassword)
                     .addOnCompleteListener(new OnCompleteListener<Void>() {
                         @Override
                         public void onComplete(@NonNull Task<Void> task) {
                             if (task.isSuccessful()) {
                                 System.out.println("*****successful update");
                             }
                         }
                     });
         }
         else{
             System.out.println ("NO PASSWORD");
         }

        user.updateEmail(EmailET.getText().toString().trim())
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            System.out.println("*****successful update");
                        }
                    }
                });

        this.finish();
    }


}
