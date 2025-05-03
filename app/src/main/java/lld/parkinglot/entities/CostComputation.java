package lld.parkinglot.entities;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.LocalDateTime;

public class CostComputation {

    public BigDecimal calculateParkingCharges(Ticket ticket){
        return BigDecimal.valueOf(ticket.getParkingSpot().getPrice()).multiply(calculateParkingDuration(ticket));
    }

    private BigDecimal calculateParkingDuration(Ticket ticket){
        LocalDateTime exitTime = LocalDateTime.now();

        // Validate
        if (exitTime.isBefore(ticket.getEntryTime())) {
            System.out.println("Error: Exit time is before entry time.");
            return null;
        }

        Duration duration = Duration.between(ticket.getEntryTime(), exitTime);
        long totalMinutes = duration.toMinutes();
        BigDecimal totalHours = BigDecimal.valueOf(totalMinutes).divide(BigDecimal.valueOf(60), 2, RoundingMode.HALF_UP);
        System.out.println("Total Parking Duration: " + totalHours + " hours.");
        return totalHours.add(BigDecimal.valueOf(2));
    }
}
