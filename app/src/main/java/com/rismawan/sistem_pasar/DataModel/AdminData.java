package com.rismawan.sistem_pasar.DataModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AdminData {
    @SerializedName("id_admin")
    @Expose
    private Integer idAdmin;
    @SerializedName("id_pegawai")
    @Expose
    private Integer idPegawai;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("role")
    @Expose
    private String role;
    @SerializedName("status")
    @Expose
    private Integer status;

    public Integer getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Integer idAdmin) {
        this.idAdmin = idAdmin;
    }

    public Integer getIdPegawai() {
        return idPegawai;
    }

    public void setIdPegawai(Integer idPegawai) {
        this.idPegawai = idPegawai;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

