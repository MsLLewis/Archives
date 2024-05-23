package com.lewis.model;

/**
 * Model Records class contains
 * record data
 */
public class Records {
    private int id;
    private int isbn;
    private String recordName;

    public Records(){}

    public Records(int id, int isbn, String recordName) {
        this.id = id;
        this.isbn = isbn;
        this.recordName = recordName;
    }

    public Records(int isbn, String recordName){
        this.isbn = isbn;
        this.recordName = recordName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getRecordName() {
        return recordName;
    }

    public void setRecordName(String recordName) {
        this.recordName = recordName;
    }

    @Override
    public String toString() {
        return "Records{" +
                "id=" + id +
                ", isbn=" + isbn +
                ", recordName='" + recordName + '\'' +
                '}';
    }
}
