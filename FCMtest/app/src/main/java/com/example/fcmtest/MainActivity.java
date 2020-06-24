package com.example.fcmtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNumber;
    private EditText editTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        changeTextView();

        //asking specific permissions
        ActivityCompat.requestPermissions(MainActivity.this, new String[] {
            Manifest.permission.SEND_SMS, Manifest.permission.READ_SMS
        }, PackageManager.PERMISSION_GRANTED);

        editTextMessage = findViewById(R.id.editTextTextMultiLine);
        editTextNumber = findViewById(R.id.editTextNumber);

    }

    //once firebase messages are ready to send, add in parameter to function with the specific data
    private void changeTextView() {
        final String firebaseMsg = "Message from firebase";
        final TextView changingText = (TextView) findViewById((R.id.text_to_change));
        final Button changeTextButton = (Button) findViewById(R.id.change_text_button);
        changeTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changingText.setText(firebaseMsg);
            }
        });
    }

    //onclick will show all the public methods in this file
    public void sendSMS (View view) {
        String message = editTextMessage.getText().toString();
        String number = editTextNumber.getText().toString();

        SmsManager mySmsManager = SmsManager.getDefault();
        mySmsManager.sendTextMessage(number, null, message, null, null );
    }
}