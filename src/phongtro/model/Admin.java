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
public class Admin implements Serializable {

    private String username;
    private String pass;
    private String sdt;
    private String email;
    private String ghiChu;

    public Admin() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public Admin(String username, String pass, String sdt, String email, String ghiChu) {
        this.username = username;
        this.pass = pass;
        this.sdt = sdt;
        this.email = email;
        this.ghiChu = ghiChu;
    }

}
