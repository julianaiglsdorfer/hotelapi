package com.ue04.hotelapi.model;

public class SearchModel {
    private String checkindate;
    private String ceckoutdate;
    private int size;
    private int price;
    private int persons;
    private int singleBed;
    private int doubleBed;
    private boolean balcony;

    public String getCheckInDate() {
        return checkindate;
    }

    public String getCheckOutDate() {
        return ceckoutdate;
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
