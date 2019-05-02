package information.provider.rest.service;

import information.provider.pojo.Hotel;
import information.provider.rest.dao.HotelInformationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HotelInformationService {

    @Autowired
    private HotelInformationDao hotelInformationDao;

    public List<Hotel> findAll() {
        List<Hotel> listHotels = hotelInformationDao.findAll();
        return listHotels;
    }
}
