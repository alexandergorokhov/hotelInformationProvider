package information.provider.rest.controller;

import information.provider.pojo.Hotel;
import information.provider.rest.service.HotelInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("info")
public class HotelInformationController {

    @Autowired
    private HotelInformationService hotelInformationService;

    @GetMapping(value = "/hotels")
    public ResponseEntity<List<Hotel>> getAllHotels() {
        List<Hotel> listHotels = hotelInformationService.findAll();
        ResponseEntity response = new ResponseEntity(listHotels, HttpStatus.OK);
        return response;
    }

    @PostMapping(value = "/hotel")
    public ResponseEntity postHotel(@RequestBody Hotel hotel) {
        ResponseEntity response;
        try {
            hotelInformationService.save(hotel);
        } catch (Exception e) {
            response = new ResponseEntity(hotel, HttpStatus.INTERNAL_SERVER_ERROR);
            return response;
        }
        response = new ResponseEntity(hotel, HttpStatus.OK);
        return response;
    }

    @PostMapping(value = "/hotels")
    public ResponseEntity postHotels(@RequestBody List<Hotel> hotels) {
        ResponseEntity response;
        try {
            hotelInformationService.saveHotels(hotels);
        } catch (Exception e) {
            response = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            return response;
        }
        response = new ResponseEntity( HttpStatus.OK);
        return response;

    }

    @PostMapping(value = "/activate")
    public ResponseEntity postActivate() {
        ResponseEntity response;
        try {
            hotelInformationService.initialize();
        } catch (Exception e) {
            response = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            return response;
        }
        response = new ResponseEntity( HttpStatus.OK);
        return response;

    }

}
