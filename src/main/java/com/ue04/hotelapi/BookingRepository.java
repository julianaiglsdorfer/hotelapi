package com.ue04.hotelapi;

import com.ue04.hotelapi.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

    @Query(value = "select * from Booking b " +
            "WHERE b.checkindate = :fromDate " +
            "AND b.checkoutdate = :toDate", nativeQuery = true)
    Collection<Booking> findBookingsFromTo(
            @Param("fromDate") String from,
            @Param("toDate") String to
    );
}
