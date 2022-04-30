package com.hackathon.missionindradhanush;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.CardView;
import android.support.v7.widget.CardView;
import android.text.method.ScrollingMovementMethod;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

//import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yashkirat Singh on 28-Mar-18.
 */

public class Child_Profile_Show_Data extends AppCompatActivity
{
    TextView textViewName,textViewHospitalName,textViewPlaceOfBirth,textViewDOB,textViewGender;
    ImageView imgViewPic;
    CardView cardViewPic;
    ListView listViewDemo;
    SwipeRefreshLayout swipeRefreshLayout;
    ProgressBar progBarVaccinationReport;
    DatabaseReference databaseReference;
    List<ChildProfileGetterSetter> imageList;
    ProgressDialog progressDialog;
    FirebaseUser firebaseUser;
    CardView cardViewChildFirst,cardViewChildSecond,cardViewChildThird;
    RelativeLayout rlMain;
    //Child_Profile_Adapter adapter;
    StorageReference storageReference;
    public final static String FB_StoragePath="image/";
    public final static String FB_DatabasePath="image";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.child_profile_show_data);
       // imageList=new ArrayList<>();
        //storageReference= FirebaseStorage.getInstance().getReference();
        //listViewDemo=(ListView)findViewById(R.id.listViewDemo);
        firebaseUser= FirebaseAuth.getInstance().getCurrentUser();
        final String parentid=firebaseUser.getUid();
        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Please wait....");
        databaseReference= FirebaseDatabase.getInstance().getReference("Child").child(parentid);



        cardViewChildFirst=new CardView(this);

      //  rlMain=(RelativeLayout)findViewById(R.id.RLMainChildProfileShowData) ;

        textViewName=(TextView)findViewById(R.id.tvNameOfChild);
        textViewDOB=(TextView)findViewById(R.id.tvDOBOfChild);
        textViewHospitalName=(TextView)findViewById(R.id.tvNameOfHospital);
        textViewPlaceOfBirth=(TextView)findViewById(R.id.tvPlaceOfBirth);
        textViewGender=(TextView)findViewById(R.id.tvGenderOfChild);



        imgViewPic=(ImageView)findViewById(R.id.imgViewChildProfile);
        Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.un_pic);
        RoundedBitmapDrawable roundedBitmapDrawable= RoundedBitmapDrawableFactory.create(getResources(),bitmap);
        roundedBitmapDrawable.setCircular(true);
        imgViewPic.setImageDrawable(roundedBitmapDrawable);

        cardViewPic=(CardView)findViewById(R.id.cardViewImgViewChildProfile);
        Bitmap bitmap2= BitmapFactory.decodeResource(getResources(),R.drawable.un_pic);
        RoundedBitmapDrawable roundedBitmapDrawable2= RoundedBitmapDrawableFactory.create(getResources(),bitmap2);
        roundedBitmapDrawable.setCircular(true);
        imgViewPic.setImageDrawable(roundedBitmapDrawable2);
        progBarVaccinationReport=(ProgressBar)findViewById(R.id.probarVaccinationReportChildProfile);
        progBarVaccinationReport.setProgress(20);

        //----------SWIPE TO REFRESH----------------------
        swipeRefreshLayout=findViewById(R.id.swipeToRefreshLayout);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorAccent);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener()
        {
            @Override
            public void onRefresh()
            {
                doRefreshAndRecheckProgressBar();

            }
        });

        //-------***------------------------------------------
        DatabaseReference parentRef = FirebaseDatabase.getInstance().getReference("Child").child(parentid);
        parentRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot childSnapshot: dataSnapshot.getChildren())
                {
                    String childKey = childSnapshot.getKey();
                    DatabaseReference childRef = FirebaseDatabase.getInstance().getReference("Child").child(parentid).child(childKey);

                    childRef.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String childname=dataSnapshot.child("childProfileName").getValue(String.class);
                            String childdob=dataSnapshot.child("childProfileDOB").getValue(String.class);
                            String childhospitalname=dataSnapshot.child("childProfileHospitalName").getValue(String.class);
                            String childplaceofbirth=dataSnapshot.child("childProfilePlaceOfBirth").getValue(String.class);
                            String childgender=dataSnapshot.child("childProfileGender").getValue(String.class);
                         //  String childpicurl=dataSnapshot.child("url").getValue(String.class);

                          /*  StorageReference storageReferencenew=FirebaseStorage.getInstance().getReference("image/1522428667871.jpg");

                            storageReferencenew.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    Bitmap bitmap= null;
                                    try {
                                        URL url=new URL(uri.toString());
                                       String urlImage= url.toString();

                                        //bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),uri);
                                     //   Glide.with(Child_Profile_Show_Data.this).load(urlImage).into(imgViewPic);
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    //imgViewPic.setImageBitmap(bitmap);
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    System.out.print("faildesd");
                                }
                            });*/

                            textViewName.setText(childname);
                            textViewDOB.setText(childdob);
                            textViewHospitalName.setText(childhospitalname);
                            textViewPlaceOfBirth.setText(childplaceofbirth);
                            textViewGender.setText(childgender);



                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            System.out.println("Failed");
                        }
                    });
                    break;
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("Failed");
            }
        });



    }

    public void doRefreshAndRecheckProgressBar()
    {
        //code
        progBarVaccinationReport.setProgress(0);


    }








}
