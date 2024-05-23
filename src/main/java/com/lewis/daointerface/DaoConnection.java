package com.lewis.daointerface;

import java.sql.*;

/**
 * Utility class connection to Database
 */
public class DaoConnection {
    static Connection conn = null;
   protected static PreparedStatement ps = null;
   protected static ResultSet rs = null;

    public static Connection getConnection(){

        final String DBURL = "jdbc:mysql://localhost:3306/archives";
        final String DBUSERNAME = "root";
        final String DBPASSWORD = "root";
        try{
            conn = DriverManager.getConnection(DBURL, DBUSERNAME, DBPASSWORD);
            System.out.println("Connected to Database Successfully");
        }catch (SQLException e){
            System.out.println(e);
            e.printStackTrace();
        }
        return conn;
    }

    public static void disconnect()
    {
        try {
            if(rs != null)
            {
                rs.close();
            }
            if(ps != null)
            {
                ps.close();
            }
            if(conn != null)
            {
                conn.close();
            }

        }catch (Exception e) {
            // TODO: handle exception
        }

    }


}
