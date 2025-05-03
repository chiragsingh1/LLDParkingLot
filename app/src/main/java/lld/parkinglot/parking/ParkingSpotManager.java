package lld.parkinglot.parking;

import lld.parkinglot.entities.CostComputation;
import lld.parkinglot.entities.ParkingSpot;
import lld.parkinglot.entities.Ticket;
import lld.parkinglot.entities.Vehicle;
import lld.parkinglot.enums.VehicleType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

public class ParkingSpotManager {
    Map<String, ParkingSpot> spotsMap;
    CostComputation costComputation;
    ParkingStrategy strategy;

    public ParkingSpotManager(List<ParkingSpot> parkingSpots){
        this.spotsMap = new HashMap<>();
        this.costComputation = new CostComputation();
        this.strategy = new DefaultParkingStrategy();
        for(ParkingSpot spot: parkingSpots){
            this.spotsMap.put(spot.getId(), spot);
        }
    }

    public void addParkingSpot(ParkingSpot spot){
       spotsMap.put(spot.getId(), spot);
    }
    public void removeParkingSpot(ParkingSpot spotToRemove){
        String spotToRemoveId = spotToRemove.getId();
        if(spotsMap.containsKey(spotToRemoveId)){
            spotsMap.remove(spotToRemoveId);
        }else{
            System.out.println("Spot not found with ID: " + spotToRemoveId);
        }
    }
    public Ticket findAndBookParkingSpot(Vehicle vehicle){
        List<ParkingSpot> availableSpots = new ArrayList<>(spotsMap.values());

        return strategy.findParkingSpot(availableSpots, vehicle.getVehicleType()).map(spot -> {
            spot.occupy();
            Ticket ticket = new Ticket(vehicle, LocalDateTime.now(), spot);
            System.out.println("Parking found and ticket generated.");
            System.out.println("Ticket - " + ticket.getId() + " - Vehicle - " + ticket.getAssignedVehicle().getLicensePlate() + " - Entry Time - " + ticket.getEntryTime());
            return ticket;
        }).orElseGet(()->{
            System.out.println("No available spot found for vehicle type: " + vehicle.getVehicleType());
            return null;
        });

    }
    public void unparkVehicle(Ticket ticket){
        ParkingSpot ticketSpot = ticket.getParkingSpot();

        if(ticketSpot != null && spotsMap.containsKey(ticketSpot.getId())){
            ticketSpot.vacate();
            BigDecimal totalPrice = costComputation.calculateParkingCharges(ticket);
            System.out.println("Your total parking charges are: " + totalPrice);
        }else{
            System.out.println("Ticket invalid.");
        }
    }

    public void displayAvailability(){
        List<ParkingSpot> availableSpots = new ArrayList<>(spotsMap.values());
        int twoWheelerSpots = 0, fourWheelerSpots = 0;
        for(ParkingSpot spot: availableSpots){
            if(spot.isEmpty()){
                if(spot.getParkingType().equals(VehicleType.TWO_WHEELER)) twoWheelerSpots++;
                else if(spot.getParkingType().equals(VehicleType.FOUR_WHEELER)) fourWheelerSpots++;
            }
        }
        System.out.println("Current availability:");
        System.out.println("Two Wheeler: " + twoWheelerSpots);
        System.out.println("Four Wheeler: " + fourWheelerSpots);
    }

}
