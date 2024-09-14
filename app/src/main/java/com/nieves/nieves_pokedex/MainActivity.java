package com.nieves.nieves_pokedex;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText usernameText;
    EditText passwordText;
    Button loginBtn;

    String user = "jireh";
    String passW = "jireh123";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        usernameText = findViewById(R.id.usernameText);
        passwordText = findViewById(R.id.passwordText);
        loginBtn = findViewById(R.id.loginBtn);

    }


    public void onClickLogin(View view) {
        String name = usernameText.getText().toString();
        String pass = passwordText.getText().toString();

        if (user.equals(name) && passW.equals(pass)) {
            Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, Pokedex.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(MainActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
        }
    }
}