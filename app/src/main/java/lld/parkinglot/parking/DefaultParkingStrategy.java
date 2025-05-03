package lld.parkinglot.parking;

import lld.parkinglot.entities.ParkingSpot;
import lld.parkinglot.enums.VehicleType;

import java.util.List;
import java.util.Optional;

public class DefaultParkingStrategy implements ParkingStrategy{
    @Override
    public Optional<ParkingSpot> findParkingSpot(List<ParkingSpot> spots, VehicleType vehicleType){
        return spots.stream().filter(parkingSpot -> parkingSpot.isEmpty() && parkingSpot.getParkingType().equals(vehicleType)).findFirst();
    }
}
