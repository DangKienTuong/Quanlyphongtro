/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phongtro.model;

import java.io.Serializable;
import java.util.Date;
import phongtro.dao.DichvuDAO;

/**
 *
 * @author Tường Ngao Tạng
 */
public class Hoadondiennuoc implements Serializable {

    private String maHoaDon;
    private String maPhong;
    private Date ngayLap;
    private int chiSoDau;
    private int chiSoCuoi;
    private int tieuThu;
    private Double thanhTien;

    public Hoadondiennuoc() {
    }

    public Hoadondiennuoc(String maHoaDon, String maPhong, Date ngayLap, int chiSoDau, int chiSoCuoi, int tieuThu, Double thanhTien) {
        this.maHoaDon = maHoaDon;
        this.maPhong = maPhong;
        this.ngayLap = ngayLap;
        this.chiSoDau = chiSoDau;
        this.chiSoCuoi = chiSoCuoi;
        this.tieuThu = tieuThu;
        this.thanhTien = thanhTien;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }

    public int getChiSoDau() {
        return chiSoDau;
    }

    public void setChiSoDau(int chiSoDau) {
        this.chiSoDau = chiSoDau;
    }

    public int getChiSoCuoi() {
        return chiSoCuoi;
    }

    public void setChiSoCuoi(int chiSoCuoi) {
        this.chiSoCuoi = chiSoCuoi;
    }

    public int getTieuThu() {
        return tieuThu;
    }

    public void setTieuThu(int tieuThu) {
        this.tieuThu = tieuThu;
    }

    public Double getThanhTien() {
        if (maHoaDon.startsWith("Mhdd")) {
            DichvuDAO dao = new DichvuDAO();
            Dichvu dien = dao.findById("DV02");
            Double giaDien = dien.getDonGia();
            thanhTien = giaDien * tieuThu;
        } else if (maHoaDon.startsWith("Mhdn")) {
            DichvuDAO dao = new DichvuDAO();
            Dichvu nuoc = dao.findById("DV03");
            Double giaNuoc = nuoc.getDonGia();
            thanhTien = giaNuoc * tieuThu;
        }
        return thanhTien;
    }

    public void setThanhTien(Double thanhTien) {
        this.thanhTien = thanhTien;
    }

}
