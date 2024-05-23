package com.lewis.daointerface.impl;

import com.lewis.daointerface.DaoConnection;
import com.lewis.daointerface.RecordsDao;
import com.lewis.model.Records;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecordsDaoImpl extends DaoConnection implements RecordsDao {

    @Override
    public List<Records> getAllRecords() {
        try {
            Connection connection = DaoConnection.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM records");
            List recordList = new ArrayList();
            while (rs.next()) {
                Records r = new Records();
                r.setId(rs.getInt("id"));
                r.setIsbn(rs.getInt("isbn"));
                r.setRecordName(rs.getString("recordName"));
                recordList.add(r);
            }
            System.out.println(recordList);
            return recordList;

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());

        }
        return null;
    }

    @Override
    public void saveRecord(List<Records> recordsList) {
        try {
            Connection con = DaoConnection.getConnection();
            for (Records r : recordsList) {
                String sqlQuery = "INSERT INTO records (isbn, recordName) value (?,?)";
                PreparedStatement prepStmt = con.prepareStatement(sqlQuery);
                prepStmt.setInt(1, r.getIsbn());
                prepStmt.setString(2, r.getRecordName());
                int affectedRows = prepStmt.executeUpdate();
                System.out.println(affectedRows + " row(s) affected !!");
                System.out.println("isbn " + r.getIsbn() + "\n " + " name: " + r.getRecordName());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * Deletes a record from tthe records table
     *
     * @param id
     * @return
     */
    @Override
    public boolean deleteRecord(int id) {
        try {
            Connection connection = DaoConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement("DELETE FROM records where id = ?");
            ps.setInt(1, id);
            int i = ps.executeUpdate();
            if (i == 1) {
                System.out.println("row(s) affected: " + i);
                return true;
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }


        return false;
    }

    @Override
    public boolean updateRecord(Records record, int id) {
        try {
            Connection connection = DaoConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement("UPDATE records SET isbn=?, recordName=? where id=?");
            ps.setInt(1, record.getIsbn());
            ps.setString(2, record.getRecordName());
            ps.setInt(3, id);
            int i = ps.executeUpdate();
            if (i == 1) {
                System.out.println("row(s) affected: " + i);
                return true;
            }
            DaoConnection.disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());

        }
        return false;
    }
}
