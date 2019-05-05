package information.provider.rest.dao;

import information.provider.pojo.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface HotelInformationDao extends MongoRepository<Hotel, String> {


}
