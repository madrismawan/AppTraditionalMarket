package com.rismawan.sistem_pasar.Pegawai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.rismawan.sistem_pasar.API.APIConnection;
import com.rismawan.sistem_pasar.API.BaseApiService;
import com.rismawan.sistem_pasar.DataModel.LoginRespone;
import com.rismawan.sistem_pasar.MainActivity;
import com.rismawan.sistem_pasar.R;
import com.rismawan.sistem_pasar.SessionManager.SessionLogin;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class pegawai extends AppCompatActivity {

    private static final String TAG = "rismawan" ;
    private BaseApiService baseApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pegawai);
        Button btnLogout = (Button)findViewById(R.id.btnLogout);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baseApiService = APIConnection.getApiService();
                logout();
            }
        });
    }

    public void logout() {
        SharedPreferences getToken = pegawai.this.getSharedPreferences("SESSION", pegawai.MODE_PRIVATE);
        String Token = getToken.getString("token", "");

        baseApiService.logout(Token).enqueue(new Callback<LoginRespone>() {
            @Override
            public void onResponse(Call<LoginRespone> call, Response<LoginRespone> response) {
                if (response.body().getPesan().equals("Logout Berhasil")){
                    Toast.makeText(pegawai.this, response.body().getPesan(), Toast.LENGTH_SHORT).show();
                    SessionLogin sessionLogin = new SessionLogin();
                    sessionLogin.deleteSession(getBaseContext());
                    Intent intent = new Intent(pegawai.this,MainActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<LoginRespone> call, Throwable t) {
                Toast.makeText(pegawai.this, "Gagal Menghubungkan Ke server", Toast.LENGTH_SHORT).show();
            }
        });
    }
}