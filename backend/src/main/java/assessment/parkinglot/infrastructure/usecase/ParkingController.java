package assessment.parkinglot.infrastructure.usecase;

import assessment.parkinglot.adapter.ParkingService;
import assessment.parkinglot.domain.ParkingSpot;
import assessment.parkinglot.domain.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParkingController {

    // implement the controller here

    @Autowired
    ParkingService parkingService;

    @PostMapping("/park")
    public ResponseEntity<String> parkVehicle(@RequestBody Vehicle vehicle) {

       if( this.parkingService.parkVehicle(vehicle))
        return ResponseEntity.ok("Vehicle parked");
       else
        return ResponseEntity.ok("No parking available");
    }

    @PostMapping("/saveParking")
    public ResponseEntity<String> saveParkingSpot(@RequestBody ParkingSpot parkingSpot) {

        this.parkingService.saveParkingSpot(parkingSpot);
        // add try catch block
        try {
            this.parkingService.saveParkingSpot(parkingSpot);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
         return ResponseEntity.ok("Parking save");
    }

    @GetMapping("/leave")
    public ResponseEntity<String> vehicleLeave(@RequestBody Long vehicleId) {

        if( this.parkingService.vehicleLeave(vehicleId))
            return ResponseEntity.ok("Vehicle left");
        else
            return ResponseEntity.ok("Vehicle not found");
    }



}
