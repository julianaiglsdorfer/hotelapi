package com.ue04.hotelapi.model;

public class SearchModel {
    private String from;
    private String to;
    private int size;
    private int price;
    private int persons;
    private int singleBed;
    private int doubleBed;
    private boolean balcony;

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public int getSize() {
        return size;
    }

    public int getPrice() {
        return price;
    }

    public int getPersons() {
        return persons;
    }

    public int getSingleBed() {
        return singleBed;
    }

    public int getDoubleBed() {
        return doubleBed;
    }

    public boolean isBalcony() {
        return balcony;
    }
}
