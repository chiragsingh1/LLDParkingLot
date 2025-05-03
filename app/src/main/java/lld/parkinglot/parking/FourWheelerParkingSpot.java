package lld.parkinglot.parking;

import lld.parkinglot.entities.AbstractParkingSpot;
import lld.parkinglot.enums.VehicleType;


public class FourWheelerParkingSpot extends AbstractParkingSpot {
    public FourWheelerParkingSpot(int price, int numOfFloor){
        super(price, numOfFloor);
    }

    public VehicleType getParkingType(){
        return VehicleType.FOUR_WHEELER;
    }
}
