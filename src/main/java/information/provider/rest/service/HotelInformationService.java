package information.provider.rest.service;

import information.provider.pojo.*;
import information.provider.rest.dao.HotelInformationDao;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
public class HotelInformationService {
    private final String INIT_FILENAME = "words.txt";

    @Autowired
    private HotelInformationDao hotelInformationDao;
    @Autowired
    private SequenceGeneratorService sequenceGenerator;

/*@Autowired
    public HotelInformationService(HotelInformationDao hotelInformationDao, SequenceGeneratorService sequenceGenerator) {
        this.hotelInformationDao = hotelInformationDao;
        this.sequenceGenerator = sequenceGenerator;
    }*/

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
        try {
            FileReader reader = new FileReader(classLoader.getResource(INIT_FILENAME).getFile());
            JSONArray wordsArray = getWordsArrayFromJson(reader);
            populateTheDataBase(wordsArray);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void populateTheDataBase(JSONArray wordsArray) {
        String word = generateRandomWord(wordsArray);
        Hotel hotel = buildHotel(wordsArray);
        hotelInformationDao.save(hotel);
    }

    private String generateRandomWord(JSONArray wordsArray) {
        return wordsArray.get(generateRandomNumberInRange(0, wordsArray.size() - 1)).toString();
    }

    private Hotel buildHotel(JSONArray wordsArray) {
        return Hotel.builder()
                .id(sequenceGenerator.generateSequence(Hotel.SEQUENCE_NAME))
                .published(true)
                .test(false)
                .name(generateRandomWord(wordsArray))
                .hotelType(new HotelType())
                .stars(generateRandomNumberInRange(0, 5))
                .location(generateLocation(wordsArray))
                .checkIn(generateCheckIn(LocalDateTime.now()))
                .checkOut(generateCheckOut(LocalDateTime.now()))
                .mainPicture(generateMainPicture(generateRandomWord(wordsArray)))
                .numberOfRooms(generateRandomNumberInRange(0, 10))
                .creationDate(LocalDateTime.now())
                .lastmodifiedDate(LocalDateTime.now())
                .build();
    }

    private MainPicture generateMainPicture(String url) {
        MainPicture mainPicture = new MainPicture();
        mainPicture.setUrl(url);
        mainPicture.setWidth(generateRandomNumberInRange(1, 100));
        mainPicture.setHeight(generateRandomNumberInRange(1, 100));
        mainPicture.setOrder(generateRandomNumberInRange(0, 100));
        mainPicture.setPictureCategory(new PictureCategory());
        return mainPicture;
    }

    private CheckOut generateCheckOut(LocalDateTime now) {
        CheckOut checkOut = new CheckOut();
        checkOut.setTo(now);
        return checkOut;
    }

    private CheckIn generateCheckIn(LocalDateTime now) {
        CheckIn checkIn = new CheckIn();
        checkIn.setFrom(now);
        return checkIn;
    }

    private Location generateLocation(JSONArray wordsArray) {
        return Location.builder()
                .city(new City())
                .address(generateRandomWord(wordsArray))
                .zipcode(generateRandomWord(wordsArray))
                .latitude(new BigDecimal(10))
                .logtitude(new BigDecimal(10))
                .build();

    }

    private JSONArray getWordsArrayFromJson(FileReader reader) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
        JSONArray words = (JSONArray) jsonObject.get("data");
        return words;
    }

    private Integer generateRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
