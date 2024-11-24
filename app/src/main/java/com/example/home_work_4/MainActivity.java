package com.example.home_work_4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etEmail, etPassword;
    private Button btnLog;
    private TextView tvWelcome, tvForget, tvHeader, tvAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        btnLog = findViewById(R.id.btn_log);
        tvForget = findViewById(R.id.tv_forget);
        tvAction = findViewById(R.id.tv_registration);
        tvHeader = findViewById(R.id.tv_invate);
        tvWelcome = findViewById(R.id.tv_welcome);


        updateBtn();
        btnLog.setOnClickListener(v -> {
            String email = etEmail.getText().toString();
            String password = etPassword.getText().toString();

            if(email.equals("admin") && password.equals("admin")){
                Toast.makeText(MainActivity.this, "Вы успешно зарегистрировались", Toast.LENGTH_SHORT).show();
                signUp();
            } else{
                Toast.makeText(MainActivity.this, "Неправильный логин или пароль", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private  void updateBtn(){
        if(!etEmail.getText().toString().isEmpty() && !etPassword.getText().toString().isEmpty()){
            btnLog.setBackgroundTintList(getResources().getColorStateList(R.color.orange));
        } else {
            btnLog.setBackgroundTintList(getResources().getColorStateList(R.color.gray));
        }
    }
    private void signUp(){
        tvHeader.setVisibility(View.GONE);
        etPassword.setVisibility(View.GONE);
        etEmail.setVisibility(View.GONE);
        tvForget.setVisibility(View.GONE);
        tvAction.setVisibility(View.GONE);
        btnLog.setVisibility(View.GONE);

    }
}