package assessment.parkinglot.port.input;

import assessment.parkinglot.domain.ParkingSpot;
import assessment.parkinglot.domain.SpotType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, Long> {
    List<ParkingSpot> findBySpotTypeAndIsOccupied(SpotType spotType, boolean isOccupied);
    long countByIsOccupied(boolean isOccupied);
}