package com.example.dialog;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button backButton = findViewById(R.id.button_back); // Updated ID here

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an intent to return to the first activity
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);

                // Set flags to clear the backstack
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                // Start the first activity and clear the backstack
                startActivity(intent);
            } // This closing brace was missing
        });
    }
}
