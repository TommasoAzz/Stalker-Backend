package it.qbteam.serviceimpl;

import it.qbteam.persistence.areautils.GpsAreaFacade;
import it.qbteam.model.Organization;
import it.qbteam.model.Place;
import it.qbteam.persistence.repository.OrganizationRepository;
import it.qbteam.persistence.repository.PlaceRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

@RunWith(SpringRunner.class)
public class PlaceServiceImplTest {
    @MockBean
    private PlaceRepository placeRepository;

    @MockBean
    private OrganizationRepository organizationRepository;

    @MockBean
    private GpsAreaFacade gpsAreaFacade;

    @TestConfiguration
    static class PlaceServiceImplConfiguration{
        @Bean
        public PlaceServiceImpl placeService(PlaceRepository placeRepository, OrganizationRepository organizationRepository, GpsAreaFacade gpsAreaFacade) {
            return new PlaceServiceImpl(placeRepository, organizationRepository, gpsAreaFacade);
        }
    }
    @Autowired
    private PlaceServiceImpl placeService;

    private Place testPlace = new Place().trackingArea("{\"Organizzazioni\":[]}").organizationId(1L);
    private Organization testOrganization = new Organization().trackingArea("{\"Organizzazioni\":[]}").id(1L);
    private Iterable<Place> testIterable = new ArrayList<>();
    private List<Place> testArray = new ArrayList<>();

    @Before
    public void setUp(){
        testPlace.setId(1l);
    }

    @Test
    public void testCreateNewPlaceCallRepositoryFunctionAndSetIdToNull(){
        Mockito.when(placeRepository.save(any(Place.class))).thenReturn(testPlace);
        Mockito.when(organizationRepository.findById(testOrganization.getId())).thenReturn(Optional.of(testOrganization));
        Mockito.when(placeRepository.findAllPlacesOfAnOrganization(testOrganization.getId())).thenReturn(new ArrayList<>());

        placeService.createNewPlace(testPlace);
        Mockito.verify(placeRepository, Mockito.times(1)).save(testPlace);
        Assert.assertNull(placeService.createNewPlace(testPlace).get().getId());
    }
    @Test
    public void testDeletePlacePerformDeleteOperation(){
        Mockito.doNothing().when(placeRepository).delete(any(Place.class));
        placeService.deletePlace(testPlace);
        Mockito.verify(placeRepository, Mockito.times(1)).delete(testPlace);
    }

    @Test
    public void testUpdatePlacePerformSaveOperationOnThePlaceObjectGiven(){
        Mockito.when(placeRepository.save(any(Place.class))).thenReturn(testPlace);
        Mockito.when(organizationRepository.findById(testOrganization.getId())).thenReturn(Optional.of(testOrganization));
        Mockito.when(placeRepository.findAllPlacesOfAnOrganization(testOrganization.getId())).thenReturn(new ArrayList<>());

        Assert.assertEquals(Optional.of(testPlace), placeService.updatePlace(testPlace));
    }
    @Test
    public void testGetPlaceListOfOrganizationReturnEmptyListGivenInvalidOrganizationId(){
        Mockito.when(placeRepository.findAllPlacesOfAnOrganization(anyLong())).thenReturn(testIterable);
        Assert.assertEquals(testArray, placeService.getPlaceListOfOrganization(1l));
    }
    @Test
    public void testGetPlaceListOfOrganizationReturnValidListGivenValidOrganizationId(){
        testArray.add(testPlace);
        testIterable =testArray;
        Mockito.when(placeRepository.findAllPlacesOfAnOrganization(anyLong())).thenReturn(testIterable);
        Assert.assertEquals(testArray, placeService.getPlaceListOfOrganization(1l));
    }
    @Test
    public void testGetPlaceReturnValidOptionalPlaceGivenValidPlaceId(){
        Mockito.when(placeRepository.findById(anyLong())).thenReturn(Optional.of(testPlace));
        Assert.assertEquals(Optional.of(testPlace), placeService.getPlace(1l));
    }
    @Test
    public void testGetPlaceReturnOptionalEmptyGivenInvalidPlaceId(){
        Mockito.when(placeRepository.findById(anyLong())).thenReturn(Optional.empty());
        Assert.assertEquals(Optional.empty(), placeService.getPlace(1l));
    }
}
