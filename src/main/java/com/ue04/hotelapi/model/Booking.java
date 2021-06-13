package com.ue04.hotelapi.model;

import javax.persistence.*;

@Entity
@Table
public class Booking {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long bookingno;

    @Column
    private String checkindate;

    @Column
    private String checkoutdate;

    @Column
    private String roomno;

    @Column
    private boolean bookingActive;

    public long getBookingno() {
        return bookingno;
    }

    public String getCheckindate() {
        return checkindate;
    }

    public void setCheckindate(String checkInDate) {
        this.checkindate = checkInDate;
    }

    public String getCheckoutdate() {
        return checkoutdate;
    }

    public void setCheckoutdate(String checkOutDate) {
        this.checkoutdate = checkOutDate;
    }

    public String getRoomno() {
        return roomno;
    }

    public void setRoomno(String roomno) {
        this.roomno = roomno;
    }

    public boolean isBookingActive() {
        return bookingActive;
    }

    public void setBookingActive(boolean bookingActive) {
        this.bookingActive = bookingActive;
    }
}
