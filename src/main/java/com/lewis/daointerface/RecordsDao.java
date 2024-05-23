package com.lewis.daointerface;

import com.lewis.model.Records;

import java.util.List;

/***
 * RecordsDao interface contains declared
 * functionalities.
 */
public interface RecordsDao {

    List<Records> getAllRecords();
    void saveRecord(List<Records> recordsList);
    boolean deleteRecord(int id);
    boolean updateRecord(Records record, int id);


}
