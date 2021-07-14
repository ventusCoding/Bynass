package com.example.bynass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class NotificationActivity extends AppCompatActivity {

    String status = "good";
    TextView statusTxt , statusDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        statusTxt = findViewById(R.id.status_txt);
        statusDescription = findViewById(R.id.status_detail_txt);

        if(status.equals("pending")){
            statusTxt.setText("Pending");
            statusTxt.setTextColor(getResources().getColor(R.color.pending, null));
            statusDescription.setText("Our Team is on her way to him.");

        }else if(status.equals("good")){
            statusTxt.setText("Good");
            statusTxt.setTextColor(getResources().getColor(R.color.good, null));
            statusDescription.setText("He's allwrite now no need to worry.");

        }else if(status.equals("onHospital")){
            statusTxt.setText("On Hospital");
            statusTxt.setTextColor(getResources().getColor(R.color.on_hospital, null));
            statusDescription.setText("Doctors are taking care of the situation.");

        }
    }
}