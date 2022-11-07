package com.example.avikishairy.Models;

public class shairyapimodels {
    int id;
    String shairy_data,poet_name,date_time;

    public shairyapimodels(int id, String shairy_data, String poet_name, String date_time) {
        this.id = id;
        this.shairy_data = shairy_data;
        this.poet_name = poet_name;
        this.date_time = date_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShairy_data() {
        return shairy_data;
    }

    public void setShairy_data(String shairy_data) {
        this.shairy_data = shairy_data;
    }

    public String getPoet_name() {
        return poet_name;
    }

    public void setPoet_name(String poet_name) {
        this.poet_name = poet_name;
    }

    public String getData_time() {
        return date_time;
    }

    public void setData_time(String data_time) {
        this.date_time = data_time;
    }
}
