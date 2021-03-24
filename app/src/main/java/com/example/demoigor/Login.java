package com.example.demoigor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        EditText pass = findViewById(R.id.pass);
        EditText login = findViewById(R.id.pochta);
        Button sign = findViewById(R.id.button);
        sign.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
          if (TextUtils.isEmpty(login.getText().toString()) || TextUtils.isEmpty(pass.getText().toString())) {
          Toast.makeText(Login.this, "Ваши поля пустые", Toast.LENGTH_LONG).show();
           } else {
           LoginRequest loginRequest = new LoginRequest();
           loginRequest.setEmail(login.getText().toString());
           loginRequest.setPassword(pass.getText().toString());
           VhodUsers(loginRequest);
            }
            }
            });


    }
    public void VhodUsers(LoginRequest loginRequest){
    Call<LoginResponce> call = ApiClient.getservice().loginUser(loginRequest);
    call.enqueue(new Callback<LoginResponce>() {
        @Override
        public void onResponse(Call<LoginResponce> call, Response<LoginResponce> response) {
            if (response.isSuccessful())
            {
                Intent intent = new Intent(Login.this,MainActivity.class);
                startActivity(intent);
            }
        }

        @Override
        public void onFailure(Call<LoginResponce> call, Throwable t) {
            Toast.makeText(Login.this, "неа", Toast.LENGTH_LONG).show();
        }
    });
    }
}