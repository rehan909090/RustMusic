package com.example.rustmusic;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginButton = findViewById(R.id.buttonLogin);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText usernameEditText = findViewById(R.id.editTextUsername);
                EditText passwordEditText = findViewById(R.id.editTextPassword);

                String username = usernameEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                // Validasi input
                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                    Toast.makeText(MainActivity.this, "Harap isi kedua kolom.", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Logika autentikasi sederhana
                if (username.equals("admin") && password.equals("admin")) {
                    // Login berhasil, navigasi ke halaman home
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish(); // Optional, untuk menutup activity login
                }
                else {
                    // Login gagal
                    Log.d("LoginActivity", "Login failed. Username: " + username + ", Password: " + password);
                    Toast.makeText(MainActivity.this, "Login gagal. Periksa kembali username dan password.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

