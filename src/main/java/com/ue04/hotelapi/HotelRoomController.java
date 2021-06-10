package com.ue04.hotelapi;

import com.ue04.hotelapi.model.Booking;
import com.ue04.hotelapi.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class HotelRoomController {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @GetMapping("/freeRooms")
    public Room getFreeRooms(
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable String size,
            @PathVariable String price,
            @PathVariable String persons,
            @PathVariable String singeBed,
            @PathVariable String doubleBed,
            @PathVariable String balcony
    ) {
        System.out.println(from + to + size);
        return roomRepository.findFreeRooms(1).stream().findFirst().get();
    }

    @GetMapping("/allRooms")
    public Iterable<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @PostMapping("/addRoom")
    public Room addRoom(@RequestParam String roomNo,
                        @RequestParam String type,
                        @RequestParam int price,
                        @RequestParam int capacity,
                        @RequestParam int size,
                        @RequestParam int noOfSingleBeds,
                        @RequestParam int noOfDoubleBeds,
                        @RequestParam boolean balcony) {
        Room r = new Room();
        r.setNr(roomNo);
        r.setType(type);
        r.setPrice(price);
        r.setCapacity(capacity);
        r.setSize(size);
        r.setNoOfSingleBeds(noOfSingleBeds);
        r.setNoOfDoubleBeds(noOfDoubleBeds);
        r.setBalcony(balcony);

        roomRepository.save(r);
        return r;
    }

    @PostMapping("/addBooking")
    public Booking addBooking(@RequestParam Date checkInDate,
                              @RequestParam Date checkOutDate,
                              @RequestParam String roomNo) {
        Booking b = new Booking();
        b.setCheckInDate(checkInDate);
        b.setCheckOutDate(checkOutDate);
        b.setRoomNo(roomNo);

        bookingRepository.save(b);
        return b;
    }


}
