package com.example.firebase_login.database;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

public class authentication extends Activity{
    Activity MainActivity;
    FirebaseUser user;


    public authentication(Activity MainActivity){
        this.MainActivity=MainActivity;



    }

    public FirebaseUser sign_in(View view) {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser() != null) {
            Toast.makeText(MainActivity.getApplicationContext(), "User already sign in signout first", Toast.LENGTH_SHORT).show();
            return auth.getCurrentUser();
        }else{
            //Choosing Authentication provider
            List<AuthUI.IdpConfig> providers= Arrays.asList(
                    new AuthUI.IdpConfig.EmailBuilder().build(),
                    new AuthUI.IdpConfig.PhoneBuilder().build(),
                    new AuthUI.IdpConfig.GoogleBuilder().build());
            // List<AuthUI.IdpConfig> providers= Arrays.asList(new AuthUI.IdpConfig.EmailBuilder().build());

            //Creating and launching sign-in intent
            MainActivity.startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder().setAvailableProviders(providers).build(),12345);
            return user;
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Checking for request code
        if(requestCode==12345){
            //Successfully signed-in
            if(resultCode==RESULT_OK){
                //Getting the current user

                user = FirebaseAuth.getInstance().getCurrentUser();
                //Showing toast
                Toast.makeText(getApplicationContext(),"Successfully signed-in",Toast.LENGTH_SHORT).show();
            }
        }else{
            //Signed-in failed. If response is null the user canceled the sign-in flow using the back button.
            //respose.getError().getErrorCode() handle the error.
            Toast.makeText(getApplicationContext(),"Unabled to sign in",Toast.LENGTH_SHORT).show();
        }
    }


}
