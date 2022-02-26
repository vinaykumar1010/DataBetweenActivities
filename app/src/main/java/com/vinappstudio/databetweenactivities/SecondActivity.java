package com.vinappstudio.databetweenactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private TextView textView;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView = findViewById(R.id.textView);
        backButton = findViewById(R.id.btn_Activity2_ID);

        dataFromFirstActivity();
        onClickBack();

    }

    public void onClickBack() {
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("returnData", " Come From Second Activity");
                setResult(123, intent);
                finish();
            }
        });
    }

    public void dataFromFirstActivity() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String message = extras.getString("Message");
            Integer value = extras.getInt("value");
            textView.setText(message + value);
        } else
            Toast.makeText(this, "We have no data Transfer", Toast.LENGTH_SHORT).show();

    }
}