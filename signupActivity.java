
package com.example.nsa;

        import android.annotation.SuppressLint;
        import android.content.Intent;
        import android.os.Bundle;
        import android.text.TextUtils;
        import android.text.method.PasswordTransformationMethod;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

        import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;

        import com.example.nsa.fragment.Myobserver;
        import com.google.android.gms.tasks.OnCompleteListener;
        import com.google.android.gms.tasks.Task;
        import com.google.android.material.textfield.TextInputEditText;
        import com.google.firebase.auth.AuthResult;
        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.auth.FirebaseUser;
        import com.google.firebase.database.DataSnapshot;
        import com.google.firebase.database.DatabaseError;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;
        import com.google.firebase.database.ValueEventListener;


public class signupActivity extends AppCompatActivity  {
    TextInputEditText Input_email, Input_password, Input_fullname, Input_repeatpassword;
    EditText Input_phone;
    Button signup_button, cancel_button;
    FirebaseAuth mAuth;
    User user = new User();
    FirebaseAuth.AuthStateListener mAuthListener;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("message").child("User");
    private void toastMessages(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
    public static final String TAG = "YOUR-TAG-NAME";
    Myobserver obsignup = new Myobserver();



    public static class AsteriskPasswordTransformationMethod extends PasswordTransformationMethod {
        @Override
        public CharSequence getTransformation(CharSequence source, View view) {
            return new PasswordCharSequence(source);
        }

        private static class PasswordCharSequence implements CharSequence {
            private CharSequence mSource;
            public PasswordCharSequence(CharSequence source) {
                mSource = source; // Store char sequence
            }
            public char charAt(int index) {
                return '*'; // This is the important part
            }
            public int length() {
                return mSource.length(); // Return default
            }
            public CharSequence subSequence(int start, int end) {
                return mSource.subSequence(start, end); // Return default
            }
        }
    }
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Input_fullname = findViewById(R.id.firstname);
        Input_password = findViewById(R.id.reg_passwordinput);
        Input_repeatpassword = findViewById(R.id.singup_password);
        Input_email = findViewById(R.id.email_input);
        Input_phone = findViewById(R.id.mnumber);
        signup_button = findViewById(R.id.signup_button);
        cancel_button = findViewById(R.id.cancel_button1);
        user = new User();
        mAuth = FirebaseAuth.getInstance();


        Input_password.setTransformationMethod(new AsteriskPasswordTransformationMethod());
        Input_repeatpassword.setTransformationMethod(new AsteriskPasswordTransformationMethod());
        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), loginActivity.class);
                startActivity(i);
            }
        });
        signup_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean end = validateForm();

                if(end == true){

                    user.setEmail(Input_email.getText().toString());
                    user.setFullname(Input_fullname.getText().toString());
                    user.setMobile(Input_phone.getText().toString());
                    user.setPassword(Input_password.getText().toString());
                    mAuth.createUserWithEmailAndPassword(Input_email.getText().toString(), Input_password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                toastMessage("Successfully registered");
                                FirebaseUser user1 = mAuth.getCurrentUser();
                                String UID = user1.getUid();
                                myRef.child(UID).child("User Info").child("Email").setValue(user.getEmail());
                                myRef.child(UID).child("User Info").child("Full Name").setValue(user.getFullname());
                                myRef.child(UID).child("User Info").child("Mobile").setValue(user.getMobile());
                                mAuth.signInWithEmailAndPassword(Input_email.getText().toString(), Input_password.getText().toString())
                                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                            @Override
                                            public void onComplete(@NonNull Task<AuthResult> task) {
                                                if(task.isSuccessful()){
                                                    Intent login = new Intent(signupActivity.this, afterlogin.class);
                                                    startActivity(login);
                                                    toastMessage("Signed In Successfully");
                                                }else{
                                                    String message = task.getException().toString();
                                                    toastMessage("Error");
                                                }

                                            }
                                        });
                            }
                        }
                    });
                }else{
                    toastMessage("Please complete the form");
                }

            }
        });
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null){
                    //User is signed in
                    Log.d("EmailPassword", "onAuthStateChanged:signed_in:" + user.getUid());
                    toastMessage("Successfully Signed In with " + user.getEmail());

                }else{
                    Log.d("EmailPassword", "onAuthStateChanged:signed_out");
                    toastMessage("Successfully Signed Out ");

                }
            }
        };

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                //String value = dataSnapshot.getValue(String.class);
                Object value = dataSnapshot.getValue();
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


    }
    void toastMessage(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
    private boolean validateForm() {
        boolean valid = true;

        String em = Input_email.getText().toString();
        if (TextUtils.isEmpty(em)) {
            Input_email.setError("Required.");
            valid = false;
        } else {
            Input_email.setError(null);
        }


        String pass = Input_password.getText().toString();
        if (TextUtils.isEmpty(pass)) {
            Input_password.setError("Required.");
            valid = false;
        } else {
            Input_password.setError(null);
        }

        return valid;
    }
}
