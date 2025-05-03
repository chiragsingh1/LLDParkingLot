package lld.parkinglot.entities;

import java.time.LocalDateTime;
import java.util.UUID;

public class Ticket {
    private final String id;
    private final Vehicle assignedVehicle;
    private final LocalDateTime entryTime;
    private final ParkingSpot parkingSpot;

    public Ticket(Vehicle assignedVehicle, LocalDateTime entryTime, ParkingSpot parkingSpot) {
        this.id = UUID.randomUUID().toString();
        this.assignedVehicle = assignedVehicle;
        this.entryTime = entryTime;
        this.parkingSpot = parkingSpot;
    }

    public String getId() {
        return id;
    }

    public Vehicle getAssignedVehicle() {
        return assignedVehicle;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }
}
