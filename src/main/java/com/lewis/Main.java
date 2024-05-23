package com.lewis;

import com.lewis.daointerface.RecordsDao;
import com.lewis.daointerface.impl.RecordsDaoImpl;
import com.lewis.model.Records;

import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static RecordsDao record = new RecordsDaoImpl();

    public static void main(String[] args) {
    //  record.getAllRecords();

        //Save new Record
//        Records new_record = new Records(4, "AI Exploration");
//        ArrayList<Records> recordsList = new ArrayList<Records>();
//        recordsList.add(new_record);
//        record.saveRecord(recordsList);

      //  record.deleteRecord(3);

        Records updated_record = new Records(2, "ANN ML Exploration");
        int id = 2;
        record.updateRecord(updated_record, id);

        record .getAllRecords();



    }
}