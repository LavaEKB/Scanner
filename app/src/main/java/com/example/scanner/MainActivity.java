package com.example.scanner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextPassword;
    private Button buttonSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editTextName.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                if (name.isEmpty() || password.isEmpty()) {
                    Toast.makeText(
                            MainActivity.this,
                            R.string.error_fields_empty,
                            Toast.LENGTH_SHORT
                    ).show();
                } else {
                    launchNextScreen(name);
                }

            }
        });
    }

    private void launchNextScreen(String userName){
        Intent intent = new Intent(this, ScannerActivity.class);
        intent.putExtra("message", userName);
        startActivity(intent);
    }

    private void initViews(){
        editTextName = findViewById(R.id.EditTextName);
        editTextPassword = findViewById(R.id.EditTextPassword);
        buttonSignIn = findViewById(R.id.ButtonSignIn);
    }
}