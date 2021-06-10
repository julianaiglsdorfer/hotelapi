package com.ue04.hotelapi.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Booking {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long bookingNo;

    @Column
    private Date checkInDate;

    @Column
    private Date checkOutDate;

    @Column
    private String roomNo;

    @Column
    private boolean bookingActive;

    public long getBookingNo() {
        return bookingNo;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public boolean isBookingActive() {
        return bookingActive;
    }

    public void setBookingActive(boolean bookingActive) {
        this.bookingActive = bookingActive;
    }
}
