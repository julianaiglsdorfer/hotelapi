package com.ue04.hotelapi;

import com.ue04.hotelapi.model.Booking;
import com.ue04.hotelapi.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class InitializationComponent {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @PostConstruct
    private void init() {

        roomRepository.deleteAll();

        roomRepository.save(createRoom("101", "Kingsize Zimmer", 150, 3, 120,3, 1, true));
        roomRepository.save(createRoom("102", "Deluxe Zimmer", 100, 3, 100,3, 1, true));
        roomRepository.save(createRoom("103", "Standard Zimmer", 60, 2, 25,2, 0, false));
        roomRepository.save(createRoom("201", "Standard Zimmer", 50, 2, 20,2, 0, true));
        roomRepository.save(createRoom("202", "Familien Zimmer", 110, 4, 115,2, 1, false));
        roomRepository.save(createRoom("203", "Familien Zimmer", 110, 4, 110,2, 1, true));
        roomRepository.save(createRoom("301", "Deluxe Zimmer", 190, 3, 100,3, 1, true));

        bookingRepository.save(createBooking("101", "2021-07-01", "2021-07-07"));
        bookingRepository.save(createBooking("101", "2021-06-20", "2021-06-28"));
        bookingRepository.save(createBooking("102", "2021-07-01", "2021-07-07"));
        bookingRepository.save(createBooking("202", "2021-07-10", "2021-07-15"));
    }

    private Room createRoom(String nr, String type, int price, int capacity, int size, int noofsinglebeds, int noofdoublebeds, boolean balcony) {
        Room newRoom = new Room();
        newRoom.setNr(nr);
        newRoom.setType(type);
        newRoom.setPrice(price);
        newRoom.setCapacity(capacity);
        newRoom.setSize(size);
        newRoom.setNoofsinglebeds(noofsinglebeds);
        newRoom.setNoofdoublebeds(noofdoublebeds);
        newRoom.setBalcony(balcony);

        return newRoom;
    }

    private Booking createBooking(String roomno, String checkindate, String checkoutdate) {
        Booking newBooking = new Booking();
        newBooking.setRoomno(roomno);
        newBooking.setCheckindate(checkindate);
        newBooking.setCheckoutdate(checkoutdate);
        newBooking.setBookingActive(true);

        return newBooking;
    }
}
