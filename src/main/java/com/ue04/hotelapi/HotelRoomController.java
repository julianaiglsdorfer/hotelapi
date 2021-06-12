package com.ue04.hotelapi;

import com.ue04.hotelapi.model.Booking;
import com.ue04.hotelapi.model.Room;
import com.ue04.hotelapi.model.SearchModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api")
public class HotelRoomController {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private BookingRepository bookingRepository;

    //POST weil = keine Daten in der URL + wir können einen body im Request mitgeben
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/freeRooms")
    public Collection<Room> getFreeRooms(@RequestBody SearchModel searchModel) {
        Collection<Room> rooms = roomRepository.findFreeRooms(
                searchModel.getSize(),
                searchModel.getPrice(),
                searchModel.getPersons(),
                searchModel.getSingleBed(),
                searchModel.getDoubleBed(),
                searchModel.isBalcony()
        );

//        Collection<Booking> bookings = bookingRepository.findAll();
//        int year = Integer.parseInt(searchModel.getFrom().split(3));
//        int month = Integer.parseInt(searchModel.getFrom());
//        bookings = bookings.stream().filter(b -> searchModel.getFrom() < b.getCheckindate() )
        return rooms;

//        return rooms.stream().filter(r -> isNotBooked(r.getNr(), bookings)).collect(Collectors.toList());

    }

    private boolean isNotBooked(String nr, Collection<Booking> bookings) {
        return !bookings.stream().anyMatch(b -> b.getRoomNo() == nr);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/allRooms")
    public Iterable<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/allBookings")
    public Iterable<Booking> getAllBookings(){
    	return bookingRepository.findAll();
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
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
        r.setNoofsinglebeds(noOfSingleBeds);
        r.setNoofdoublebeds(noOfDoubleBeds);
        r.setBalcony(balcony);

        roomRepository.save(r);
        return r;
    }

    @PostMapping("/addBooking")
    public Booking addBooking(@RequestParam String checkindate,
                              @RequestParam String checkoutdate,
                              @RequestParam String roomNo) {
        Booking b = new Booking();
        b.setCheckindate(checkindate);
        b.setCheckoutdate(checkoutdate);
        b.setRoomNo(roomNo);

        bookingRepository.save(b);
        return b;
    }
}
