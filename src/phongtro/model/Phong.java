/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phongtro.model;

import java.io.Serializable;

/**
 *
 * @author Tường Ngao Tạng
 */
public class Phong implements Serializable {

    private String maPhong;
    private String tenPhong;
    private int soNguoiToiDa;
    private Double donGia;
    private String trangThai;
    private String moTa;

    public Phong() {
    }

    public Phong(String maPhong, String tenPhong, int soNguoiToiDa, Double donGia, String trangThai, String moTa) {
        this.maPhong = maPhong;
        this.tenPhong = tenPhong;
        this.soNguoiToiDa = soNguoiToiDa;
        this.donGia = donGia;
        this.trangThai = trangThai;
        this.moTa = moTa;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public int getSoNguoiToiDa() {
        return soNguoiToiDa;
    }

    public void setSoNguoiToiDa(int soNguoiToiDa) {
        this.soNguoiToiDa = soNguoiToiDa;
    }

    public Double getDonGia() {
        return donGia;
    }

    public void setDonGia(Double donGia) {
        this.donGia = donGia;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

}
