package com.ue04.hotelapi;

import com.ue04.hotelapi.model.Booking;
import com.ue04.hotelapi.model.Room;
import org.springframework.data.repository.CrudRepository;

public interface BookingRepository extends CrudRepository<Booking, Integer> {
}
