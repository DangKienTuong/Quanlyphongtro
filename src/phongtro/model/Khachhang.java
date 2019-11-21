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
public class Khachhang implements Serializable {

    private String maKhachHang;
    private String maPhong;
    private String ten;
    private Date namSinh;
    private String cmnd;
    private String diaChi;
    private String ngheNghiep;
    private String sdt;
    private byte[] hinh;

    public Khachhang() {
    }

    public Khachhang(String maKhachHang, String maPhong, String ten, Date namSinh, String cmnd, String diaChi, String ngheNghiep, String sdt, byte[] hinh) {
        this.maKhachHang = maKhachHang;
        this.maPhong = maPhong;
        this.ten = ten;
        this.namSinh = namSinh;
        this.cmnd = cmnd;
        this.diaChi = diaChi;
        this.ngheNghiep = ngheNghiep;
        this.sdt = sdt;
        this.hinh = hinh;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Date getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(Date namSinh) {
        this.namSinh = namSinh;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getNgheNghiep() {
        return ngheNghiep;
    }

    public void setNgheNghiep(String ngheNghiep) {
        this.ngheNghiep = ngheNghiep;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public byte[] getHinh() {
        return hinh;
    }

    public void setHinh(byte[] hinh) {
        this.hinh = hinh;
    }

}
