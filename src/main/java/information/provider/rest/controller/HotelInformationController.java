package information.provider.rest.controller;

import information.provider.pojo.Hotel;
import information.provider.rest.service.HotelInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("info")
public class HotelInformationController {

    @Autowired
    private HotelInformationService hotelInformationService;
    @GetMapping(value = "/hotels")
    public ResponseEntity<List<Hotel>> getAllHotels(){
        List<Hotel> listHotels = hotelInformationService.findAll();
        ResponseEntity response = new ResponseEntity(listHotels, HttpStatus.OK);
        return response;
    }
}
