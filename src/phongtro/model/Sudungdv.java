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
public class Sudungdv implements Serializable {

    private String maSuDungDV;
    private String maPhong;
    private String maDichVu;

    public Sudungdv() {
    }

    public Sudungdv(String maSuDungDV, String maPhong, String maDichVu) {
        this.maSuDungDV = maSuDungDV;
        this.maPhong = maPhong;
        this.maDichVu = maDichVu;
    }

    public String getMaSuDungDV() {
        return maSuDungDV;
    }

    public void setMaSuDungDV(String maSuDungDV) {
        this.maSuDungDV = maSuDungDV;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getMaDichVu() {
        return maDichVu;
    }

    public void setMaDichVu(String maDichVu) {
        this.maDichVu = maDichVu;
    }

}
