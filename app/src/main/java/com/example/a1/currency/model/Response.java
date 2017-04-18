package com.example.a1.currency.model;

import com.google.gson.annotations.Expose;

import java.util.Date;
import java.util.Map;



public class Response {
    @Expose
    private String base;

    @Expose
    private Date date;

    @Expose
    private Map<String, Double> rates;

    public Response(String base, Date date, Map<String, Double> rates) {
        this.base = base;
        this.date = date;
        this.rates = rates;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setRate(Map<String, Double> rates) {
        this.rates = rates;
    }
}
