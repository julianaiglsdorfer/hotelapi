package com.ue04.hotelapi;

import com.ue04.hotelapi.model.Booking;
import com.ue04.hotelapi.model.Room;
import com.ue04.hotelapi.model.SearchModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Collection;

@Transactional
@RestController
@RequestMapping("/api")
public class HotelRoomController {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @GetMapping("/")
    public String home() {
        return "Service Engineering HotelAPI runs on AzureAppService";
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/freeRooms")
    public Collection<Room> getFreeRooms(@RequestBody SearchModel searchModel) {
        Collection<Room> rooms = roomRepository.findFreeRooms(
                searchModel.getSize(),
                searchModel.getPrice(),
                searchModel.getPersons(),
                searchModel.getSingleBed(),
                searchModel.getDoubleBed(),
                searchModel.isBalcony(),
                searchModel.getCheckInDate(),
                searchModel.getCheckOutDate()
        );
        return rooms;
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

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/addBooking")
    public ResponseEntity<Booking> addBooking(@RequestBody Booking booking) {
        Booking newBooking = bookingRepository.save(booking);
        return new ResponseEntity<>(newBooking, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/deleteBooking/{bookingno}")
    public void deleteBooking(@PathVariable Long bookingno) {
        bookingRepository.deleteByBookingno(bookingno);
    }
}
