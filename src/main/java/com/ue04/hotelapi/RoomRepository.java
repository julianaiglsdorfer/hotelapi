package com.ue04.hotelapi;

import com.ue04.hotelapi.model.Room;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface RoomRepository extends CrudRepository<Room, Integer> {

    @Query("select r FROM Room r WHERE r.nr = :nr")
    Collection<Room> findFreeRooms(@Param("nr") int nr);

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
