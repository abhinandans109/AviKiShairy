package com.example.avikishairy.Api;

import com.example.avikishairy.Models.shairyapimodels;

import java.util.List;

public class
Getshairyresponse {
    String status,message;
    List<shairyapimodels> data;

    public Getshairyresponse(String status, String message, List<shairyapimodels> data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<shairyapimodels> getData() {
        return data;
    }

    public void setData(List<shairyapimodels> data) {
        this.data = data;
    }
}
