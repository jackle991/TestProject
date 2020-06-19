package com.example.fcmtest;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;
import android.widget.Button;

import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    int oldValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        changeTextViewValueRandomlyOnButtonClick();

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

}