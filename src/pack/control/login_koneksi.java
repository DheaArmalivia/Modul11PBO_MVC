/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.control;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

/**
 *
 * @author Smktelkom
 */
public class login_koneksi {
     private static Connection koneksi;
     public static Connection GetConnection() throws SQLException
     {
         if (koneksi == null) {
             Driver driver = new Driver() {
                 @Override
                 public Connection connect(String url, Properties info) throws SQLException {
                     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                 }

                 @Override
                 public boolean acceptsURL(String url) throws SQLException {
                     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                 }

                 @Override
                 public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
                     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                 }

                 @Override
                 public int getMajorVersion() {
                     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                 }

                 @Override
                 public int getMinorVersion() {
                     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                 }

                 @Override
                 public boolean jdbcCompliant() {
                     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                 }

                 @Override
                 public Logger getParentLogger() throws SQLFeatureNotSupportedException {
                     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                 }
             };
             koneksi = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/toko?zeroDateTimeBehavior=convertToNull", "root", ""); 
         }
         return koneksi;
     }
}
