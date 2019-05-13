package information.provider.rest.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import information.provider.pojo.Hotel;
import information.provider.rest.dao.HotelInformationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class HotelInformationService<T> {
    private final String INIT_FILENAME = "words.txt";

    @Autowired
    private HotelInformationDao hotelInformationDao;

    public List<Hotel> findAll() {
        List<Hotel> listHotels = hotelInformationDao.findAll();
        return listHotels;
    }

    public void save(Hotel hotel) {
        hotelInformationDao.save(hotel);
    }

    public void saveHotels(List<Hotel> hotels) {

        hotels.stream().forEach(hotelInformationDao::save);

    }

    public void initialize() {
        ClassLoader classLoader = new HotelInformationService().getClass().getClassLoader();
        File file = new File(classLoader.getResource(INIT_FILENAME).getFile());
        // file.get
        try {
            parseJsonFromInitFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parseJsonFromInitFile() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        InputStream inputStream = HotelInformationService.class.getResourceAsStream(INIT_FILENAME);
        Hotel hotel = mapper.readValue(inputStream, Hotel.class);

        // SAFE TO db WILL BE HERE
        System.out.println("Saving to database: " + hotel.toString());
//        String inputString = "{json goes here...}";
//        JsonNode json = mapper.readTree(inputString);
//        JsonNode searchResultsNode = json.get("searchResults");
//        JsonNode classifiedAdvertsNode = searchResultsNode.get("classifiedAdverts");
//        String someValue = classifiedAdvertsNode.asText();
    }
}
