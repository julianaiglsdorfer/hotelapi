package com.ue04.hotelapi.model;

import javax.persistence.*;

@Entity
@Table
public class Room {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column
    private String nr;

    @Column
    private String type;

    @Column
    private int price;

    @Column
    private int capacity;

    @Column
    private int size;

    @Column
    private int noOfSingleBeds;

    @Column
    private int noOfDoubleBeds;

    @Column
    private boolean balcony;

    public long getId() {
        return id;
    }

    public String getNr() {
        return nr;
    }

    public void setNr(String nr) {
        this.nr = nr;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getNoOfSingleBeds() {
        return noOfSingleBeds;
    }

    public void setNoOfSingleBeds(int noOfSingleBeds) {
        this.noOfSingleBeds = noOfSingleBeds;
    }

    public int getNoOfDoubleBeds() {
        return noOfDoubleBeds;
    }

    public void setNoOfDoubleBeds(int noOfDoubleBeds) {
        this.noOfDoubleBeds = noOfDoubleBeds;
    }

    public boolean isBalcony() {
        return balcony;
    }

    public void setBalcony(boolean balcony) {
        this.balcony = balcony;
    }
}
