/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phongtro.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Tường Ngao Tạng
 */
public class Chi implements Serializable {

    private String maChi;
    private String tenKhoanChi;
    private Date ngayChi;
    private String loaiKhoanChi;
    private Double soTien;
    private String moTa;

    public Chi() {
    }

    public Chi(String maChi, String tenKhoanChi, Date ngayChi, String loaiKhoanChi, Double soTien, String moTa) {
        this.maChi = maChi;
        this.tenKhoanChi = tenKhoanChi;
        this.ngayChi = ngayChi;
        this.loaiKhoanChi = loaiKhoanChi;
        this.soTien = soTien;
        this.moTa = moTa;
    }

    public String getMaChi() {
        return maChi;
    }

    public void setMaChi(String maChi) {
        this.maChi = maChi;
    }

    public String getTenKhoanChi() {
        return tenKhoanChi;
    }

    public void setTenKhoanChi(String tenKhoanChi) {
        this.tenKhoanChi = tenKhoanChi;
    }

    public Date getNgayChi() {
        return ngayChi;
    }

    public void setNgayChi(Date ngayChi) {
        this.ngayChi = ngayChi;
    }

    public String getLoaiKhoanChi() {
        return loaiKhoanChi;
    }

    public void setLoaiKhoanChi(String loaiKhoanChi) {
        this.loaiKhoanChi = loaiKhoanChi;
    }

    public Double getSoTien() {
        return soTien;
    }

    public void setSoTien(Double soTien) {
        this.soTien = soTien;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

}
