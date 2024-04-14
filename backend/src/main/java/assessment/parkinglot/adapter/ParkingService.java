package assessment.parkinglot.adapter;

import assessment.parkinglot.domain.ParkingSpot;
import assessment.parkinglot.domain.SpotType;
import assessment.parkinglot.domain.Vehicle;
import assessment.parkinglot.domain.VehicleType;
import assessment.parkinglot.port.input.ParkingSpotRepository;
import assessment.parkinglot.port.input.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParkingService {

    @Autowired
    private ParkingSpotRepository parkingSpotRepository;

    @Autowired
    private VehicleRepository vehicleRepository;


    // CREATE a method in java to save a parkingspot

    public ParkingSpot saveParkingSpot(ParkingSpot parkingSpot) {
        //The parking lot has 25 total spaces
        if (parkingSpot.getId() > 25) {
            throw new IllegalArgumentException("The parking lot has 25 total spaces");
        }
        return parkingSpotRepository.save(parkingSpot);
    }


    public boolean parkVehicle(Vehicle vehicle) {
        int requiredSpots = switch (vehicle.getType()) {
            case CAR -> 1;
            case VAN -> 3;
            case MOTORCYCLE -> 1;
        };

        SpotType preferredSpotType = switch (vehicle.getType()) {
            case CAR, VAN -> SpotType.REGULAR;
            case MOTORCYCLE -> SpotType.MOTORCYCLE;
        };

        List<ParkingSpot> availableSpots = parkingSpotRepository.findBySpotTypeAndIsOccupied(preferredSpotType, false);
        if (availableSpots.size() >= requiredSpots) {
            for (int i = 0; i < requiredSpots; i++) {
                ParkingSpot spot = availableSpots.get(i);
                spot.setOccupied(true);
                parkingSpotRepository.save(spot);
            }
            vehicleRepository.save(vehicle);
            return true;
        } else {
            return false;
        }
    }

    public boolean vehicleLeave(Long vehicleId) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(vehicleId);
        if (vehicle.isPresent()) {
            // This is a simplified logic. In a real scenario, you'd associate vehicles with their spots.
            vehicleRepository.delete(vehicle.get());
            // Release the spot(s) here
            return true;
        }
        return false;
    }

    public long availableSpots() {
        return parkingSpotRepository.countByIsOccupied(false);
    }

    public boolean areAllSpotsTaken(VehicleType type) {
        SpotType spotType = type == VehicleType.MOTORCYCLE ? SpotType.MOTORCYCLE : SpotType.REGULAR;
        return parkingSpotRepository.findBySpotTypeAndIsOccupied(spotType, false).isEmpty();
    }

}
