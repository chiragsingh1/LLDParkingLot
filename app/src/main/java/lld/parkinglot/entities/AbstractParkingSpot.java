package lld.parkinglot.entities;


import java.util.UUID;

public abstract class AbstractParkingSpot implements ParkingSpot{
    public String id;
    public boolean isOccupied;
    public int price;
    public int numOfFloor;

    public AbstractParkingSpot(int price, int numOfFloor){
        this.isOccupied = false;
        this.price = price;
        this.numOfFloor = numOfFloor;
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public boolean isEmpty(){
        return !this.isOccupied;
    }

    @Override
    public void occupy(){
        this.isOccupied = true;
    }

    @Override
    public void vacate(){
        this.isOccupied = false;
    }
    @Override
    public String getId(){
        return this.id;
    }
    public int getPrice(){
        return this.price;
    }
}
