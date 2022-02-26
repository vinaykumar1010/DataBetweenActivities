package com.vinappstudio.databetweenactivities;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {
private Button buttonActivity1;
private  final Integer REQUEST_CODE =2 ;
private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        buttonActivity1 = findViewById(R.id.btnActivity1_ID);
        textView = findViewById(R.id.tv_activity1_ID);
        buttonActivity1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this ,SecondActivity.class );
                intent.putExtra("value" , 123);
                intent.putExtra("Message" , "Come From First Activity");
                activityResultLaunch.launch(intent );


            }
        });
    }

    ActivityResultLauncher<Intent> activityResultLaunch = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == 123) {
                        // ToDo : Do your stuff...
                        Intent intent = result.getData();

                        if(intent!=null){
                            // Extract data
                           String data = intent.getStringExtra("returnData");
                              textView.setText( data);
                        } else
                            Log.d("TAG" , "we dot have return data");


                    }
                }
            });

}