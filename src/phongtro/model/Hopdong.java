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
public class Hopdong implements Serializable {

    private String maHopDong;
    private String maPhong;
    private String nguoiDaiDien;
    private String sdt;
    private Double tienDatCoc;
    private Date ngayDatCoc;
    private Date ngayHetHan;

    public Hopdong() {
    }

    public Hopdong(String maHopDong, String maPhong, String nguoiDaiDien, String sdt, Double tienDatCoc, Date ngayDatCoc, Date ngayHetHan) {
        this.maHopDong = maHopDong;
        this.maPhong = maPhong;
        this.nguoiDaiDien = nguoiDaiDien;
        this.sdt = sdt;
        this.tienDatCoc = tienDatCoc;
        this.ngayDatCoc = ngayDatCoc;
        this.ngayHetHan = ngayHetHan;
    }

    public String getMaHopDong() {
        return maHopDong;
    }

    public void setMaHopDong(String maHopDong) {
        this.maHopDong = maHopDong;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getNguoiDaiDien() {
        return nguoiDaiDien;
    }

    public void setNguoiDaiDien(String nguoiDaiDien) {
        this.nguoiDaiDien = nguoiDaiDien;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Double getTienDatCoc() {
        return tienDatCoc;
    }

    public void setTienDatCoc(Double tienDatCoc) {
        this.tienDatCoc = tienDatCoc;
    }

    public Date getNgayDatCoc() {
        return ngayDatCoc;
    }

    public void setNgayDatCoc(Date ngayDatCoc) {
        this.ngayDatCoc = ngayDatCoc;
    }

    public Date getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(Date ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }

}
