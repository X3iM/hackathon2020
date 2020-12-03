
package com.android.hackathon.canteen.activities;
import com.android.hackathon.canteen.MainActivity;
import com.android.hackathon.canteen.R;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;



public class RegisterActivity extends AppCompatActivity {

    private EditText name, phone, email, room, password;
    private ImageView image;
    private Uri imUr;
    private Button registrBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        image=(ImageView)findViewById(R.id.logo_register);
        name=(EditText)findViewById(R.id.name);
        password=(EditText)findViewById(R.id.password_registr);
        phone=(EditText)findViewById(R.id.phone);
        room=(EditText)findViewById(R.id.room);
        email=(EditText)findViewById(R.id.email);
        registrBtn=(Button)findViewById(R.id.registr_btn);

//        image.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                findInGalary();
//            }
//        });
//
//        registrBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                validationUserData();
//            }
//        });
//    }
//
//    private void validationUserData() {
//        if(name.toString().isEmpty())
//        {
//            Toast.makeText(RegisterActivity.this, "Please write your name", Toast.LENGTH_SHORT).show();
//        }
//        else if(phone.toString().isEmpty())
//        {
//            Toast.makeText(RegisterActivity.this, "Please write your phone", Toast.LENGTH_SHORT).show();
//        }
//        else if(room.toString().isEmpty())
//        {
//            Toast.makeText(RegisterActivity.this, "Please write your room", Toast.LENGTH_SHORT).show();
//        }
//        else if(email.toString().isEmpty())
//        {
//            Toast.makeText(RegisterActivity.this, "Please write your email", Toast.LENGTH_SHORT).show();
//        }
//        else if(password.toString().isEmpty())
//        {
//            Toast.makeText(RegisterActivity.this, "Please write your password", Toast.LENGTH_SHORT).show();
//
//        }
//    }
//
//    private void findInGalary() {
//        Intent gallary = new Intent();
//        gallary.setAction(Intent.ACTION_GET_CONTENT);
//        gallary.setType("image/*");
//        startActivityForResult(gallary, 1);
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if(requestCode==1 && resultCode==RESULT_OK && data!=null)
//        {
//            imUr=data.getData();
//            image.setImageURI(imUr);
//        }
//    }
//
//
//
//
//
//    @Override
//    public void onClick(View view) {
//
//    }
}}