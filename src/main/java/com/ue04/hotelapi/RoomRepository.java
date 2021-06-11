package com.ue04.hotelapi;

import com.ue04.hotelapi.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface RoomRepository extends JpaRepository<Room, Integer> {

    //Select * erlaubt Abfrage aller Daten dabei müssen in der unteren Section nicht alle erwähnt werden
    //für Abfrage eines oder einer spezifischen Anzahl muss genau die Anzahl unten angegeben sein
    @Query(value = "select * FROM Room r " +
            "WHERE r.size = :size " +
            "AND r.capacity >= :persons " +
            "AND r.price <= :price " +
            "AND r.noofsinglebeds >= :singleBed " +
            "AND r.noofdoublebeds >= :doubleBed " +
            "AND r.balcony = :balcony", nativeQuery = true)
    Collection<Room> findFreeRooms(
            @Param("size")int size,
            @Param("price") int price,
            @Param("persons") int persons,
            @Param("singleBed") int singleBed,
            @Param("doubleBed") int doubleBed,
            @Param("balcony") boolean balcony
    );


//    return "SELECT r.RoomNo as 'rRoomNo', r.Type as 'rType', r.Price as 'rPrice', r.Capacity as 'rCapacity',
//    r.Size as 'rSize', r.NoOfSingleBeds as 'rNoOfSingleBeds', r.NoOfDoubleBeds as 'rNoOfDoubleBeds',
//    r.Balcony as 'rBalcony'
//    FROM Room r
//    WHERE r.RoomNo NOT IN
//            (SELECT b.RoomNo
//                    FROM Booked b
//                    WHERE b.RoomNo = r.RoomNo"
//                    . $string .
//                    "ORDER BY r.Capacity";

}
