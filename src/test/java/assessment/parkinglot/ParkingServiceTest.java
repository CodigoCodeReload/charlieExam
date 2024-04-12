package assessment.parkinglot;


import assessment.parkinglot.adapter.ParkingService;
import assessment.parkinglot.domain.ParkingSpot;
import assessment.parkinglot.domain.SpotType;
import assessment.parkinglot.domain.Vehicle;
import assessment.parkinglot.domain.VehicleType;
import assessment.parkinglot.port.input.ParkingSpotRepository;
import assessment.parkinglot.port.input.VehicleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class ParkingServiceTest {

    @Mock
    private ParkingSpotRepository parkingSpotRepository;

    @Mock
    private VehicleRepository vehicleRepository;

    @InjectMocks
    private ParkingService parkingService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testParkVehicle() {
        Vehicle vehicle = new Vehicle();
        vehicle.setType(VehicleType.CAR);

        ParkingSpot spot = new ParkingSpot();
        spot.setSpotType(SpotType.REGULAR);
        spot.setOccupied(false);

        when(parkingSpotRepository.findBySpotTypeAndIsOccupied(SpotType.REGULAR, false))
                .thenReturn(Arrays.asList(spot));

        boolean result = parkingService.parkVehicle(vehicle);

        assertTrue(result, "Expected parkVehicle to return true, but it returned false");
    }
}