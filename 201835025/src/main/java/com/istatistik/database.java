/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.istatistik;

import java.sql.*;
//MySQL Workbench kullandım

public class database {

    public static void kaydet(model m) {
        try {
            // create a mysql database connection
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost/coffehouse?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&autoReconnect=true&useSSL=false";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "orhaneren123");//USERNAME AND PASWORD*******************

            // the mysql insert statement
            String query = " insert into data (ad, soyad, cinsiyet, yas, pasta, icecek, pastaPuani, icecekPuani)"
                    + " values (?, ?, ?, ?, ?, ?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, m.getAd());
            preparedStmt.setString(2, m.getSoyad());
            preparedStmt.setString(3, m.getCinsiyet());
            preparedStmt.setInt(4, m.getYas());
            preparedStmt.setString(5, m.getPasta());
            preparedStmt.setString(6, m.getIcecek());
            preparedStmt.setInt(7, m.getPastaPuan());
            preparedStmt.setInt(8, m.getIcecekPuan());

            // execute the preparedstatement
            preparedStmt.execute();

            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }

}
