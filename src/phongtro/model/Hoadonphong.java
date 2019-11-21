/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phongtro.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import phongtro.dao.DichvuDAO;
import phongtro.dao.HoadondiennuocDAO;
import phongtro.dao.PhongDAO;
import phongtro.dao.SudungdvDAO;

/**
 *
 * @author Tường Ngao Tạng
 */
public class Hoadonphong implements Serializable {

    private String maHoadon;
    private Date thangNam;
    private String maPhong;
    private String nguoiDaiDien;
    private Date ngayThanhToan;
    private String tinhTrang;
    private Double thanhTien;

    public Hoadonphong() {
    }

    public Hoadonphong(String maHoadon, Date thangNam, String maPhong, String nguoiDaiDien, Date ngayThanhToan, String tinhTrang, Double thanhTien) {
        this.maHoadon = maHoadon;
        this.thangNam = thangNam;
        this.maPhong = maPhong;
        this.nguoiDaiDien = nguoiDaiDien;
        this.ngayThanhToan = ngayThanhToan;
        this.tinhTrang = tinhTrang;
        this.thanhTien = thanhTien;
    }

    public String getMaHoadon() {
        return maHoadon;
    }

    public void setMaHoadon(String maHoadon) {
        this.maHoadon = maHoadon;
    }

    public Date getThangNam() {
        return thangNam;
    }

    public void setThangNam(Date thangNam) {
        this.thangNam = thangNam;
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

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public Double getThanhTien() {
        PhongDAO dao = new PhongDAO();
        Phong phong = dao.findById(maPhong);
        Double giaPhong = phong.getDonGia();
        Double tienDN = tongTienDienNuoc();
        Double tienDV = tongTienDichVu();
        thanhTien = giaPhong + tienDN + tienDV;
        return thanhTien;
    }

    public Double tongTienDienNuoc() {
        HoadondiennuocDAO dao = new HoadondiennuocDAO();
        List<Hoadondiennuoc> hddn = dao.selectByKeyword(maPhong);
        Double tienDienNuoc = 0.0;
        for (Hoadondiennuoc hd : hddn) {
            if (hd.getNgayLap().getMonth() == this.thangNam.getMonth()) {
                tienDienNuoc += hd.getThanhTien();
            }
        }
        return tienDienNuoc;
    }

    public Double tongTienDichVu() {
        SudungdvDAO dao = new SudungdvDAO();
        List<Sudungdv> sddv = dao.selectByKeyword(maPhong);
        Double tienDichVu = 0.0;
        DichvuDAO dao1 = new DichvuDAO();
        for (Sudungdv sd : sddv) {
            Dichvu dv = dao1.findById(sd.getMaDichVu());
            tienDichVu += dv.getDonGia();
        }
        return tienDichVu;
    }

    public void setThanhTien(Double thanhTien) {
        this.thanhTien = thanhTien;
    }

}
