package lld.parkinglot.parking;

import lld.parkinglot.entities.AbstractParkingSpot;
import lld.parkinglot.enums.VehicleType;


public class TwoWheelerParkingSpot extends AbstractParkingSpot {

    public TwoWheelerParkingSpot(int price, int numOfFloor){
        super(price, numOfFloor);
    }

    public VehicleType getParkingType(){
        return VehicleType.TWO_WHEELER;
    }
}
