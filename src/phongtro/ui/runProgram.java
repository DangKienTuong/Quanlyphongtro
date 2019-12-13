/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phongtro.ui;

/**
 *
 * @author Tường Ngao Tạng
 */
public class runProgram {

    public static void main(String[] args) {
        try {
            Loading ho = new Loading();
            ho.setVisible(true);
            Thread.sleep(6500);
            for (int i = 0; i <= 100; i++) {
                if (i == 100) {
                    DangNhap login = new DangNhap();
                    login.setVisible(true);
                    ho.dispose();
                }
            }

        } catch (Exception e) {
        }
    }
}
