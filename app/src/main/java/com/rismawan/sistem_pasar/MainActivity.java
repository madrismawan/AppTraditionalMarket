package com.rismawan.sistem_pasar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rismawan.sistem_pasar.API.APIConnection;
import com.rismawan.sistem_pasar.API.BaseApiService;
import com.rismawan.sistem_pasar.DataModel.LoginRespone;
import com.rismawan.sistem_pasar.Manager.manager;
import com.rismawan.sistem_pasar.Pegawai.pegawai;
import com.rismawan.sistem_pasar.SessionManager.SessionLogin;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private BaseApiService baseApiService;
    private String getUsername, getPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences getToken = MainActivity.this.getSharedPreferences("SESSION", pegawai.MODE_PRIVATE);
        String role = getToken.getString("role", "");

        if (role.equals("pegawai")){
            Intent intent = new Intent(MainActivity.this,pegawai.class);
            startActivity(intent);
        }if(role.equals("manager")){
            Intent intent = new Intent(MainActivity.this, manager.class);
            startActivity(intent);
        }

        Button btnLogin = (Button)findViewById(R.id.btnLogin);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baseApiService = APIConnection.getApiService();
                EditText username = (EditText) findViewById(R.id.inUsername);
                EditText password = (EditText) findViewById(R.id.inPassword);

                getUsername = username.getText().toString();
                getPassword = password.getText().toString();

                login(getUsername,getPassword);

            }
        });

    }

    private void login(String getUsername, String getPassword) {
        baseApiService.login(getUsername,getPassword).enqueue(new Callback<LoginRespone>() {
            @Override
            public void onResponse(Call<LoginRespone> call, Response<LoginRespone> response) {
                Toast.makeText(MainActivity.this, response.body().getPesan(), Toast.LENGTH_SHORT).show();
                //save token dan role dari login ke dalam session loin
                SessionLogin.saveSession(getBaseContext(),response.body().getToken(),response.body().getRole());

                if (response.body().getRole().equals("pegawai")){
                    Intent intent = new Intent(MainActivity.this,pegawai.class);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(MainActivity.this, manager.class);
                    startActivity(intent);
                }
            }
            @Override
            public void onFailure(Call<LoginRespone> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Gagal Menghubungkan Ke server", Toast.LENGTH_SHORT).show();
            }
        });

    }
}