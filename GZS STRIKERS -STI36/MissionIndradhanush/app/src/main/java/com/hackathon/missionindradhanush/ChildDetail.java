package com.hackathon.missionindradhanush;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.TimeZone;

public class ChildDetail extends AppCompatActivity {

    ImageView user;
    TextInputEditText childName,childDob,childHospitalName,childPlaceOfBirth;
    RadioGroup rgGender;
    Calendar cal = Calendar.getInstance(TimeZone.getDefault()); // Get current date
    ImageButton img1;
    DatePickerDialog datePicker;
    Uri selectedImage;
    StorageReference storageReference;
    DatabaseReference databaseReference;
    ProgressDialog progressDialog;
    FirebaseUser firebaseUser;
    public final static int Request_code=1234;
    public final static String FB_StoragePath="image/";
    public final static String FB_DatabasePath="image";
    Button btnaddchild;
    String parent_id;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_detail);

       progressDialog=new ProgressDialog(this);
       firebaseUser= FirebaseAuth.getInstance().getCurrentUser();
       parent_id=firebaseUser.getUid();
       databaseReference= FirebaseDatabase.getInstance().getReference("Child").child(parent_id);
       storageReference= FirebaseStorage.getInstance().getReference();
        user = (ImageView) findViewById(R.id.user);

        childName=(TextInputEditText) findViewById(R.id.tietChildProfileName);
        childDob=(TextInputEditText) findViewById(R.id.tietChildProfileDOB);
        childHospitalName=(TextInputEditText) findViewById(R.id.tietChildProfileHospitalName);
        childPlaceOfBirth=(TextInputEditText) findViewById(R.id.tietChildProfilePlaceOfBirth);
        rgGender=(RadioGroup)findViewById(R.id.rgChildProfileGender);

        Button b = findViewById(R.id.addphoto);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectImage();
            }
        });

        DatePickerDialog picker;
        EditText eText;
        btnaddchild=findViewById(R.id.btnAddChild);
        btnaddchild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doAddChild();
            }
        });
         datePicker = new DatePickerDialog(this,
                R.style.AppBlackTheme, datePickerListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH));
        datePicker.setCancelable(false);
        datePicker.setTitle("Select the date");
        Window window = datePicker.getWindow();
        window.setLayout(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);;

        img1=findViewById(R.id.imgcalendar);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                datePicker.show();

            }
        });

        // Create the DatePickerDialog instance


    }

    private void doAddChild() {
        if(selectedImage!=null)
        {
            StorageReference storageReferencenew=storageReference.child(FB_StoragePath+System.currentTimeMillis()+"."+getImageExt(selectedImage));
            storageReferencenew.putFile(selectedImage).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                       String name=childName.getText().toString().trim();
                    String dob=childDob.getText().toString().trim();
                    String hospitalname=childHospitalName.getText().toString().trim();
                    String placeofbirth=childPlaceOfBirth.getText().toString().trim();
                    String gender=((RadioButton)findViewById(rgGender.getCheckedRadioButtonId())).getText().toString().trim();
                    String childid=databaseReference.push().getKey();

                    int vacc1=1;
                    int vacc2=1;
                    int vacc3=1;
                    int vacc4=1;
                    int vacc5=0;
                    int vacc6=0;
                    int vacc7=0;
                     int status=0;
                     if(vacc1==1 &&vacc2==1 &&vacc3==1 &&vacc4==1 &&vacc5==1 &&vacc6==1 &&vacc7==1 ){
                         status=1;
                     }
                     else
                     {
                         status=0;
                     }



                    ChildProfileGetterSetter childProfileGetterSetter=new ChildProfileGetterSetter(name,gender,dob,hospitalname,placeofbirth,taskSnapshot.getDownloadUrl().toString().trim(),vacc1,vacc2,vacc3,vacc4,vacc5,vacc6,vacc7,status);
                    databaseReference.child(childid).setValue(childProfileGetterSetter);
                    Toast.makeText(ChildDetail.this, "record saved", Toast.LENGTH_SHORT).show();
                }
            }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                    double progress=(100*taskSnapshot.getBytesTransferred())/taskSnapshot.getTotalByteCount();
                    progressDialog.setMessage("saving.."+(int)progress+"%");
                    progressDialog.show();
                }
            });
            progressDialog.dismiss();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main1, menu);

        return true;
    }

    private void selectImage() {
        final CharSequence[] options = {"Take Photo", "Choose from Gallery", "Cancel"};

        AlertDialog.Builder builder = new AlertDialog.Builder(ChildDetail.this);
        builder.setTitle("Take Photo");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (options[i].equals("Choose from Gallery")) {
                    Intent intent = new Intent();
                    intent.setType("image/");
                    intent.setAction(Intent.ACTION_GET_CONTENT);

                    startActivityForResult(Intent.createChooser(intent,"Select Image"),Request_code);

                }
            }
        });
        builder.show();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==Request_code && resultCode==RESULT_OK && data!=null && data.getData()!=null )
        {
            selectedImage=data.getData();
            try
            {
                Bitmap bitmap=MediaStore.Images.Media.getBitmap(getContentResolver(),selectedImage);
                user.setImageBitmap(bitmap);
            }
            catch (Exception x)
            {
                x.printStackTrace();
            }
        }
    }
    public String getImageExt(Uri uri)
    {
        ContentResolver contentResolver=getContentResolver();
        MimeTypeMap mimeTypeMap=MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri));
    }
    @Override
    protected void onPause() {
        user.setImageURI(selectedImage);
        super.onPause();
    }

    private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {

        // when dialog box is closed, below method will be called.
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {
            String year1 = String.valueOf(selectedYear);
            String month1 = String.valueOf(selectedMonth + 1);
            String day1 = String.valueOf(selectedDay);
            TextView tvDt = (TextView) findViewById(R.id.tietChildProfileDOB);
            tvDt.setText(day1 + "/" + month1 + "/" + year1);

        }
    };

}

