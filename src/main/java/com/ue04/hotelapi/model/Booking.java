package com.ue04.hotelapi.model;

import javax.persistence.*;

@Entity
@Table
public class Booking {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long bookingNo;

    @Column
    private String checkindate;

    @Column
    private String checkoutdate;

    @Column
    private String roomNo;

    @Column
    private boolean bookingActive;

    public long getBookingNo() {
        return bookingNo;
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
