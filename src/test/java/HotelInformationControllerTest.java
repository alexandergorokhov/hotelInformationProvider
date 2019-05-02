import information.provider.pojo.Hotel;
import information.provider.rest.controller.HotelInformationController;
import information.provider.rest.service.HotelInformationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import utils.TestUtils;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = HotelInformationControllerTest.class)
public class HotelInformationControllerTest {
    private MockMvc mockMvc;

    @InjectMocks
    private HotelInformationController hotelInformationController;

    @Mock
    private HotelInformationService hotelInformationService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(hotelInformationController)
                .build();
    }

    @Test
    public void shouldReturnAllHotels_whenGetAllHotelsIsCalled() throws Exception {

        Hotel hotel = TestUtils.getSampleHotel();
        List<Hotel> listHotel = new LinkedList<>();
        listHotel.add(hotel);


        when(hotelInformationService.findAll()).thenReturn( listHotel);
        mockMvc.perform(get("/info/hotels"))
                .andExpect(status().isOk());

               // .andExpect((ResultMatcher) jsonPath("$.status", is(200)));
                //.andExpect((ResultMatcher) jsonPath("$.name", is("ControllerTestHotelOne")));
        verify(hotelInformationService, times(1)).findAll();
        verifyNoMoreInteractions(hotelInformationService);


    }
}
