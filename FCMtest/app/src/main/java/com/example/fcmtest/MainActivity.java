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

    int oldValue;
    private EditText editTextNumber;
    private EditText editTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        changeTextViewValueRandomlyOnButtonClick();

        //asking specific permissions
        ActivityCompat.requestPermissions(MainActivity.this, new String[] {
            Manifest.permission.SEND_SMS, Manifest.permission.READ_SMS
        }, PackageManager.PERMISSION_GRANTED);

        editTextMessage = findViewById(R.id.editTextTextMultiLine);
        editTextNumber = findViewById(R.id.editTextNumber);
    }

    private void changeTextViewValueRandomlyOnButtonClick() {

        final String[] alphabet = {"a","b","c","d","e","f","g"};
        final TextView changingText = (TextView) findViewById((R.id.text_to_change));
        Button changeTextButton = (Button) findViewById(R.id.change_text_button);

        changeTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int random = (int) (Math.random() * alphabet.length);
                changingText.setText(alphabet[random]);
                oldValue = random;
            }
        });
        System.out.println(changingText.getText());
    }

    //onclick will show all the public methods in this file
    public void sendSMS (View view) {
        String message = editTextMessage.getText().toString();
        String number = editTextNumber.getText().toString();

        SmsManager mySmsManager = SmsManager.getDefault();
        mySmsManager.sendTextMessage(number, null, message, null, null );
    }
}