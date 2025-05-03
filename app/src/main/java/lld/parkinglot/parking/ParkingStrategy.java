package lld.parkinglot.parking;

import lld.parkinglot.entities.ParkingSpot;
import lld.parkinglot.enums.VehicleType;

import java.util.List;
import java.util.Optional;

public interface ParkingStrategy {
    Optional<ParkingSpot> findParkingSpot(List<ParkingSpot> spots, VehicleType vehicleType);
}
