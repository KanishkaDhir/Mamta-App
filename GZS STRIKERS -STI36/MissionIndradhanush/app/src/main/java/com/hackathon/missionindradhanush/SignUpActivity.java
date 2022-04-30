package com.hackathon.missionindradhanush;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.StorageReference;


public class SignUpActivity extends AppCompatActivity
{
    Button btnSignup;
    TextInputEditText tietName,tietAge,tietEmail,tietPwd,tietContact,tietAdhaarNumber,tietSpouseName,tietSpouseAge,tietSpouseEmail,tietSpouseAdhaarNumber;
    RadioGroup rgGender,rgSpouseGender;

    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    FirebaseUser firebaseUser;
    ProgressDialog progressDialog;
    DatabaseReference databaseReference;
    StorageReference storageReference;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        firebaseAuth=FirebaseAuth.getInstance();
        firebaseUser=firebaseAuth.getCurrentUser();
        databaseReference=FirebaseDatabase.getInstance().getReference("Parent");
        progressDialog=new ProgressDialog(this);

        btnSignup=(Button)findViewById(R.id.btnSignUp);

        tietName=(TextInputEditText)findViewById(R.id.tietSignupName);
        tietAge=(TextInputEditText)findViewById(R.id.tietSignupAge);
        tietEmail=(TextInputEditText)findViewById(R.id.tietSignupEmail);

        tietPwd=(TextInputEditText)findViewById(R.id.tietSignupPwd);
        tietContact=(TextInputEditText) findViewById(R.id.tietSignupContact);
        tietAdhaarNumber=(TextInputEditText) findViewById(R.id.tietSignupAdhaarNumber);

        tietSpouseName=(TextInputEditText)findViewById(R.id.tietSignupSpouseName);
        tietSpouseAge=(TextInputEditText)findViewById(R.id.tietSignupSpouseAge);
        tietSpouseEmail=(TextInputEditText)findViewById(R.id.tietSignupSpouseEmail);

        tietSpouseAdhaarNumber=(TextInputEditText) findViewById(R.id.tietSignupSpouseAdhaarNumber);

        rgGender=(RadioGroup)findViewById(R.id.rgSignupGender);
        rgSpouseGender=(RadioGroup)findViewById(R.id.rgSignupSpouseGender);

        btnSignup.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                doSignUp();

            }
        });

    }

    public void doSignUp()
    {
        /*int selectGenderId=rgGender.getCheckedRadioButtonId();
        int selectedSpouseGenderId=rgSpouseGender.getCheckedRadioButtonId();
        RadioButton rbSelectedGender=(RadioButton)findViewById(selectGenderId);
        RadioButton rbSelectedSpouseGender=(RadioButton)findViewById(selectedSpouseGenderId);

        SignUpGetterSetter sugs=new SignUpGetterSetter();

        sugs.setSignupName(tietName.getText().toString());
        sugs.setSignupAge(tietAge.getText().toString());
        sugs.setSignupEmail(tietEmail.getText().toString());
        sugs.setSignupPwd(tietPwd.getText().toString());
        sugs.setSignupGender(rbSelectedGender.getText().toString());
        sugs.setSignupContact(tietContact.getText().toString());
        sugs.setSignupAdhaarNumber(tietAdhaarNumber.getText().toString());


        sugs.setSignupSpouseName(tietSpouseName.getText().toString());
        sugs.setSignupSpouseAge(tietSpouseAge.getText().toString());
        sugs.setSignupSpouseEmail(tietSpouseEmail.getText().toString());

        sugs.setSignupSpouseGender(rbSelectedSpouseGender.getText().toString());
        sugs.setSignupSpouseAdhaarNumber(tietSpouseAdhaarNumber.getText().toString());*/



        registerUser();



    }

    private void saveInfo() {
        /*String signupname=sugs.getSignupName();
        String signupage=sugs.getSignupAge();
        String signupgender=sugs.getSignupGender();



        String signupContact=sugs.getSignupContact();
        String signupAdhaarNumber=sugs.getSignupAdhaarNumber();
        String signupSpouseAdhaarNumber=sugs.getSignupSpouseAdhaarNumber();
        String signupSpouseGender=sugs.getSignupSpouseGender();
        String signupSpouseName=sugs.getSignupSpouseName();
        String signupSpouseAge=sugs.getSignupSpouseAge();
        String signupSpouseEmail=sugs.getSignupSpouseEmail();

        String signupSpouseContact=sugs.getSignupSpouseContact();
*/
        //rgGender.getCheckedRadioButtonId();

        String signupname=tietName.getText().toString().trim();
        String signupage=tietAge.getText().toString().trim();
        String signupContact=tietContact.getText().toString().trim();
        String signupemail=tietEmail.getText().toString().trim();
        String signupPassword=tietPwd.getText().toString().trim();
        String signupAdhaarNumber=tietAdhaarNumber.getText().toString().trim();
        String rggender=((RadioButton)findViewById(rgGender.getCheckedRadioButtonId())).getText().toString().trim();
        String signupSpouseName=tietSpouseName.getText().toString().trim();
        String signupSpouseAge=tietSpouseAge.getText().toString().trim();
        String signupSpouseEmail=tietSpouseEmail.getText().toString().trim();
        String signupSpouseAdhaarNumber=tietSpouseAdhaarNumber.getText().toString().trim();
        String signupSpouseGender=((RadioButton)findViewById(rgSpouseGender.getCheckedRadioButtonId())).getText().toString().trim();
        String userid=firebaseUser.getUid();





        SignUpGetterSetter signUpGetterSetter=new SignUpGetterSetter(   signupname,  signupage,    signupContact,  signupAdhaarNumber,  rggender, signupSpouseName,  signupSpouseAge,  signupSpouseEmail,  signupSpouseAdhaarNumber,signupSpouseGender,signupemail,signupPassword);
        //databaseReference.child(firebaseUser.getUid()).setValue(signUpGetterSetter);
        DatabaseReference dataref=databaseReference.child(userid);
        dataref.setValue(signUpGetterSetter).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                System.out.println(e.getLocalizedMessage());
            }
        });
        Toast.makeText(SignUpActivity.this,"Registered successfulluy",Toast.LENGTH_SHORT).show();
    }

    private void registerUser() {
        String email=tietEmail.getText().toString().trim();
        String password=tietPwd.getText().toString().trim();

        progressDialog.setMessage("Registering user...");
        progressDialog.show();
        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(SignUpActivity.this," info saved",Toast.LENGTH_SHORT).show();
                    saveInfo();

                }
                else{
                    Toast.makeText(SignUpActivity.this," try again...",Toast.LENGTH_SHORT).show();
                }
                progressDialog.dismiss();
            }
        });

    }


}
