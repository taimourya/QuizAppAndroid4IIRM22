package com.example.quizv1.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizv1.Dao.UserRepository;
import com.example.quizv1.Entity.User;
import com.example.quizv1.R;

public class Login extends AppCompatActivity {

    private EditText etEmail, etPasswd;
    private Button btnLogin;
    private TextView tvRegister;

    private UserRepository userRepository = new UserRepository();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.etEmail);
        etPasswd = findViewById(R.id.etPasswd);
        btnLogin = findViewById(R.id.btnLogin);
        tvRegister = findViewById(R.id.tvRegister);

        btnLogin.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                //tvRegister.setText("clicked");
                User user = userRepository.authentification(etEmail.getText().toString(), etPasswd.getText().toString());
                if(user == null){
                    //error
                    Toast.makeText(Login.this, "username or password incorrect", Toast.LENGTH_SHORT).show();

                }
                else {
                    //go to quiz
                    startActivity(new Intent(Login.this, Quiz.class));
                }
            }
        });

        tvRegister.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                //go to rogister
                startActivity(new Intent(Login.this,Register.class));
            }
        });

    }
}