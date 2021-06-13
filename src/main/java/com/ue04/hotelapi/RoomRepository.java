package com.ue04.hotelapi;

import com.ue04.hotelapi.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface RoomRepository extends JpaRepository<Room, Integer> {

    @Query(value = "select * FROM Room r " +
            "WHERE r.size >= :size " +
            "AND r.capacity >= :persons " +
            "AND r.price <= :price " +
            "AND r.noofsinglebeds >= :singleBed " +
            "AND r.noofdoublebeds >= :doubleBed " +
            "AND r.balcony = :balcony " +
            "AND r.nr NOT IN (" +
                "SELECT b.roomno FROM Booking b " +
                "WHERE b.roomno = r.nr " +
                "AND (" +
                    "(b.checkindate <= :from AND b.checkoutdate >= :from)" +
                    "OR (b.checkindate <= :to AND b.checkoutdate >= :to)" +
                ")" +
            ")", nativeQuery = true)
    Collection<Room> findFreeRooms(
            @Param("size")int size,
            @Param("price") int price,
            @Param("persons") int persons,
            @Param("singleBed") int singleBed,
            @Param("doubleBed") int doubleBed,
            @Param("balcony") boolean balcony,
            @Param("from") String from,
            @Param("to") String to
    );
}
