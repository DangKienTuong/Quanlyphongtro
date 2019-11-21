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
public class Thietbi implements Serializable {

    private String maThietBi;
    private String maPhong;
    private String tenThietBi;
    private String donVi;
    private Double gia;
    private String trangThai;
    private String moTa;
    private int soLuong;

    public Thietbi() {
    }

    public Thietbi(String maThietBi, String maPhong, String tenThietBi, String donVi, Double gia, String trangThai, String moTa, int soLuong) {
        this.maThietBi = maThietBi;
        this.maPhong = maPhong;
        this.tenThietBi = tenThietBi;
        this.donVi = donVi;
        this.gia = gia;
        this.trangThai = trangThai;
        this.moTa = moTa;
        this.soLuong = soLuong;
    }

    public String getMaThietBi() {
        return maThietBi;
    }

    public void setMaThietBi(String maThietBi) {
        this.maThietBi = maThietBi;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getTenThietBi() {
        return tenThietBi;
    }

    public void setTenThietBi(String tenThietBi) {
        this.tenThietBi = tenThietBi;
    }

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
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

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

}
