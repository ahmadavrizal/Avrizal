/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Crud {
    private connection connection;
    
    public Crud(){
        koneksi();
    }
    
    public void koneksi(){
        String db = "jdbc:mysql://localhost/rpc";
        String user = "root";
        String pass = "scarlet";
        
        try{
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            connection = (connection) DriverManager.getconnection(db, user, pass);
            if(connection !=null){
                System.out.println("Koneksi DB Berhasil:");
            }
        }catch (SQLDataException ex)
        {
            Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getData(){
        String data = "";
        try{
            java.sql.Statement statement = connection.CreateStatement();
            java.sql.ResultSet rs = statement.executeQuery("Select * FROM biodata");
            while (rs.next()){
                data += rs.getInt(1)+ "," + rs.getString(2) +","
                        + rs.getString(3) + "," + rs.getString(4) + "-";
            }
        }catch (SQLDataException ex){
            Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    public String insertData(String nama, String alamat, String status){
        String data = "";
        String sql = "insert into biodata values (null, ?, ?, ?)";
        try{
            java.sql.PreparedStatement ps = cennection.prepareStatement(sql);
            ps.setString(1, nama);
            ps.setString(2, alamat);
            ps.setString(3, status);
            int kondisi = ps.executeUpdate();
            if (kondisi > 0)
            { data = "Berhasil";}
            else
            {data = "Gagal";}
    }(SQLDataException ex){
        Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
    }return data;
    }
}
