package com.rismawan.sistem_pasar.DataModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginRespone {
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("pesan")
    @Expose
    private String pesan;
    @SerializedName("role")
    @Expose
    private String role;
    @SerializedName("data")
    @Expose
    private AdminData data;
    @SerializedName("status")
    @Expose
    private String status;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public AdminData getData() {
        return data;
    }

    public void setData(AdminData data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
