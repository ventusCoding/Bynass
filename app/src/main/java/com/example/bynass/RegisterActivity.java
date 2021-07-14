package com.example.bynass;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RegisterActivity extends AppCompatActivity {

    Button registerBtn;
    TextView loginTxtBtn;
    ImageView mRegisterPhoto;
    Uri imageUri;
    boolean changedPhoto = false;
    EditText name,email,phone,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerBtn = findViewById(R.id.register_btn);
        loginTxtBtn = findViewById(R.id.register_text_btn);
        mRegisterPhoto = findViewById(R.id.userphoto);

        name = findViewById(R.id.edit_text_name);
        email = findViewById(R.id.edit_text_email);
        phone = findViewById(R.id.edit_text_phone);
        password = findViewById(R.id.edit_text_password);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
                Toast.makeText(RegisterActivity.this , "ahla" , Toast.LENGTH_SHORT).show();
            }
        });

        loginTxtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
        });

        mRegisterPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choosePicture();
            }
        });

    }

    private void choosePicture() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent , 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1 && resultCode == RESULT_OK && data != null && data.getData() != null)
        {
            imageUri = data.getData();
            mRegisterPhoto.setImageURI(imageUri);
            changedPhoto = true;
        }
    }

    void register(){

        RequestBody requestBody = new FormBody.Builder()
                .add("name",name.getText().toString())
                .add("email",email.getText().toString())
                .add("phone",phone.getText().toString())
                .add("password",password.getText().toString()).build();

        Request request = new Request.Builder().url(LoginActivity.url + "/auth/register")
                .post(requestBody)
                .build();
        LoginActivity.client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if(response != null){
                    if(response.isSuccessful()){
                        System.out.println("--------------------------------------");
                        System.out.println(response.code());
                        System.out.println("--------------------------------------");
                        System.out.println(response.body().toString());
                        Toast.makeText(RegisterActivity.this , "Success" , Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

}