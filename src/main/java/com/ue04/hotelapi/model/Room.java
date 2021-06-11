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
    private int noofsinglebeds;

    @Column
    private int noofdoublebeds;

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

    public int getNoofsinglebeds() {
        return noofsinglebeds;
    }

    public void setNoofsinglebeds(int noofsinglebeds) {
        this.noofsinglebeds = noofsinglebeds;
    }

    public int getNoofdoublebeds() {
        return noofdoublebeds;
    }

    public void setNoofdoublebeds(int noofdoublebeds) {
        this.noofdoublebeds = noofdoublebeds;
    }

    public boolean isBalcony() {
        return balcony;
    }

    public void setBalcony(boolean balcony) {
        this.balcony = balcony;
    }
}
