package com.example.bynass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class LoginActivity extends AppCompatActivity {

    Button loginBtn;
    TextView registerTxtBtn;
    public static final OkHttpClient client = new OkHttpClient();
    public static String url = "https://c3c4bc43a384.ngrok.io";

    EditText email,password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginBtn = findViewById(R.id.login_btn);
        registerTxtBtn = findViewById(R.id.register_text_btn);

        email = findViewById(R.id.edit_text_email);
        password = findViewById(R.id.edit_text_password);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        registerTxtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
            }
        });


    }

    void login(){

        RequestBody requestBody = new FormBody.Builder()
                .add("email",email.getText().toString())
                .add("password",password.getText().toString()).build();

        Request request = new Request.Builder().url(url + "/auth/login")
                .post(requestBody)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                    e.printStackTrace();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if(response != null){
                    if(response.isSuccessful()){
                        System.out.println("--------------------------------------");
                        System.out.println(response.code());
                        System.out.println("---------------MEOW-------------------");
                        System.out.println(response.body().string());
                        JSONObject jsonData = null;
                        try {
                            jsonData = new JSONObject(response.body().toString());
                            System.out.println("---------------MEOW2-------------------");
                            System.out.println(jsonData.get("token"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    }
                }
            }
        });
    }
}