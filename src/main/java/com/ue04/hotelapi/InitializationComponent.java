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

        Room roomOne = new Room();
        roomOne.setNr("100");
        roomOne.setType("Kingsize");
        roomOne.setPrice(10);
        roomOne.setCapacity(10);
        roomOne.setSize(10);
        roomOne.setNoofsinglebeds(10);
        roomOne.setNoofdoublebeds(10);
        roomOne.setBalcony(true);

        Room roomTwo = new Room();
        roomTwo.setNr("101");
        roomTwo.setType("Kingsize");
        roomTwo.setPrice(100);
        roomTwo.setCapacity(100);
        roomTwo.setSize(100);
        roomTwo.setNoofsinglebeds(100);
        roomTwo.setNoofdoublebeds(100);
        roomTwo.setBalcony(false);

        roomRepository.save(roomOne);
        roomRepository.save(roomTwo);

        Booking bookingOne = new Booking();
        bookingOne.setRoomNo("100");
        bookingOne.setCheckindate("2020-01-01");
        bookingOne.setCheckoutdate("2020-01-05");

        Booking bookingTwo = new Booking();
        bookingTwo.setRoomNo("101");
        bookingTwo.setCheckindate("2020-01-01");
        bookingTwo.setCheckoutdate("2020-01-05");

        bookingRepository.save(bookingOne);
        bookingRepository.save(bookingTwo);
    }
}
